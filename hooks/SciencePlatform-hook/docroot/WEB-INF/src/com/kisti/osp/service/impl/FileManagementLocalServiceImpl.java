/**
 * Copyright (c) 2016-present EDISON, KISTI. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.kisti.osp.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteStreamHandler;
import org.apache.commons.exec.PumpStreamHandler;

import com.kisti.osp.constants.OSPPropsUtil;
import com.kisti.osp.constants.OSPRepositoryTypes;
import com.kisti.osp.service.FileManagementLocalServiceUtil;
import com.kisti.osp.service.base.FileManagementLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryServiceUtil;

/**
 * The implementation of the file management local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kisti.osp.service.FileManagementLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry h. Seo
 * @see com.kisti.osp.service.base.FileManagementLocalServiceBaseImpl
 * @see com.kisti.osp.service.FileManagementLocalServiceUtil
 */
public class FileManagementLocalServiceImpl
	extends FileManagementLocalServiceBaseImpl {
	private String USER_ROOT_DIR_PATH = "/EDISON/LDAP/DATA";
	private String TEMP_DIR_NAME = "temp";
	private static long _DEFAULT_TIMEOUT = 60000;
	
	private static Log _log = LogFactoryUtil.getLog(FileManagementLocalServiceImpl.class);
	
	private Path get_USER_ROOT_DIR_PATH() {
		return Paths.get( this.USER_ROOT_DIR_PATH );
	}
	
	private Path getRealTemporaryFolderPath( Path realBasePath ){
		Path baseTempPath = Paths.get(this.TEMP_DIR_NAME);
		return realBasePath.resolve(baseTempPath);
	}
	
	private Path createBaseTemporaryFolderPath( Path realContextPath ) throws IOException{
		Path baseTempFolderPath = this.getRealTemporaryFolderPath(realContextPath);
		if( Files.notExists(baseTempFolderPath) ){
			baseTempFolderPath = Files.createDirectory(baseTempFolderPath);
			baseTempFolderPath.toFile().deleteOnExit();
		}
		return baseTempFolderPath;
	}

	private Path createTemporaryFilePath( Path realContextPath, String prefix,  String suffix, boolean isFile ) throws IOException{
		Path baseTempFolderPath = this.createBaseTemporaryFolderPath(realContextPath);
//		System.out.println("rootFilePath: "+baseTempFolderPath);
		
		Path tempFilePath;
		if( isFile )
			tempFilePath = Files.createTempFile(baseTempFolderPath, prefix, suffix);
		else
			tempFilePath = Files.createTempDirectory(baseTempFolderPath, prefix );
		
		tempFilePath.toFile().deleteOnExit();
//		System.out.println("tempFilePath: "+tempFilePath);
		return tempFilePath;
	}
	
	private Path getUniqueUuidFilePath( Path baseFolderPath, String prefix, String suffix ){
		Path uuidFilePath = null;
		do{
			UUID uuid = UUID.randomUUID();
			Path uuidFileName = Paths.get(prefix+uuid.toString()+suffix);
			uuidFilePath = baseFolderPath.resolve(uuidFileName);
		} while( Files.exists(uuidFilePath) );

		return uuidFilePath;
	}
	
	
	private String extractExtension( String fileName ){
		int lastIndex = fileName.lastIndexOf('.');
		if( lastIndex < 0 )	return fileName;
		
		return fileName.substring(lastIndex);
	}
	
	private JSONArray lookUpFolder( File folder, String filter ) throws IOException{
		if( !folder.isDirectory() || !folder.exists() )		throw new FileNotFoundException(folder.getAbsolutePath());
		
		File[] files;
		if( filter == null || filter.isEmpty() )
			files = folder.listFiles();
		else
			files = folder.listFiles( new FileExtensionFilter(filter) );
		
		JSONArray fileInfos = JSONFactoryUtil.createJSONArray();
		for( File file : files ){
			JSONObject fileInfo = this.getFileInformation(file);
//			System.out.println("File Info: "+fileInfo.toString());
			fileInfos.put(fileInfo);
		}
		
		return fileInfos;
	}
	
	private JSONObject getFileInformation( File file ) throws IOException{
		JSONObject fileInfo = JSONFactoryUtil.createJSONObject();
		fileInfo.put("name", file.getName());
		fileInfo.put("size", this.convert2ReadableFileSize(file.length()));
		fileInfo.put("isFile", file.isFile());
		
		return fileInfo;
	}
	
	private JSONObject getFileInformation( Path filePath ) throws IOException{
		JSONObject fileInfo = JSONFactoryUtil.createJSONObject();
//		System.out.println("To get fileInfo: "+filePath.toString());
		fileInfo.put("name", filePath.getFileName().toString());
		fileInfo.put("size", this.convert2ReadableFileSize(Files.size(filePath)));
		fileInfo.put("isFile", Files.isRegularFile(filePath, LinkOption.NOFOLLOW_LINKS));
		
		return fileInfo;
	}
	
	private String convert2ReadableFileSize(long size) {
	    if(size <= 0) return "0";
	    final String[] units = new String[] { "B", "KB", "MB", "GB", "TB" };
	    int digitGroups = (int) (Math.log10(size)/Math.log10(1024));
	    return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];
	}
	
	private class FileExtensionFilter implements FilenameFilter {
		private String extension = "";
		public FileExtensionFilter ( String extension ){
			this.extension = extension;
		}
		
		@Override
		public boolean accept(File directory, String fileName){
			if (fileName.endsWith(this.extension)) 
				return true;
			return false;
		}
	}

	/*****************************************************************
	 * Public APIs Section
	 * @throws SystemException 
	 * @throws PortalException 
	 ****************************************************************/
	
	/**
	 *  Deprecated.
	 *  Link a file or a folder to servlet container template folder based on 
	 *  of the servlet context path.
	 *  Returns the template path based on of the servlet context path.
	 */
	@Deprecated
    public String getLinkedTemporaryFilePath(PortletRequest portletRequest, 
        String target, String prefix, String suffix,
        boolean deleteOnExit, boolean isJobResult) 
            throws IOException, PortalException, SystemException{
		User user = PortalUtil.getUser(portletRequest);
		Path targetPath = this.getUserHome(portletRequest, isJobResult).resolve(target);
		if( Files.notExists(targetPath, LinkOption.NOFOLLOW_LINKS) )	throw new FileNotFoundException(targetPath.toString());
		
		Path baseTempFolderPath = this.get_USER_ROOT_DIR_PATH().resolve(user.getScreenName()).resolve(this.TEMP_DIR_NAME);
		Files.createDirectories(baseTempFolderPath);
		Path tempFilePath = baseTempFolderPath.resolve(targetPath.getFileName());
		
		Path symbolicLink = Files.createSymbolicLink(tempFilePath, targetPath );
//		System.out.println("Symbolic Link: From "+ realTargetPath + " To "+tempFilePath);
		
		if( deleteOnExit )
			symbolicLink.toFile().deleteOnExit();
		
		return symbolicLink.getFileName().toString();
	}
	
	/**
	 *  Link a file or a folder to servlet container template folder based on 
	 *  of the servlet context path.
	 *  Returns the template path based on of the servlet context path. 
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public String getLinkedTemporaryFilePath(
			PortletRequest portletRequest, 
	        String source, 
	        String prefix, 
	        String suffix,
	        boolean deleteOnExit, 
	        String repoType) throws PortalException, SystemException, IOException{
			User user = PortalUtil.getUser(portletRequest);
			Path sourcePath = this.getRepositoryPath(portletRequest, source, repoType);
			
			if( Files.notExists(sourcePath, LinkOption.NOFOLLOW_LINKS) )	
					throw new FileNotFoundException(sourcePath.toString());
			
			portletRequest.getPortletSession().getPortletContext().getRealPath(this.TEMP_DIR_NAME);
			Path tempFolderPath = Paths.get(portletRequest.getPortletSession().getPortletContext().getRealPath(this.TEMP_DIR_NAME));
			if( Files.notExists(tempFolderPath) )
				Files.createDirectories(tempFolderPath);
			
			Path tempUuidPath = this.getUniqueUuidFilePath(tempFolderPath, "", "");

			Path symbolicLink = Files.createSymbolicLink(tempUuidPath, sourcePath );
			if( deleteOnExit ){
				symbolicLink.toFile().deleteOnExit();
			}
			
			return symbolicLink.getParent().getFileName().resolve(symbolicLink.getFileName()).toString();
	}

	/**
	 * Deprecated.
	 * 
	 * Copy a file or a folder to servlet container template folder based on 
	 *  of the servlet context path.
	 *  Returns the template path based on of the servlet context path.
	 */
	@Deprecated
	public String getCopiedTemporaryFilePath(
        PortletRequest portletRequest, String target, String prefix, String suffix, boolean isJobResult)
        throws IOException, PortalException, SystemException{
        final Path targetPath = this.getUserHome(portletRequest, isJobResult).resolve(target);
//		final Path targetPath = this.get_USER_ROOT_DIR_PATH().resolve(target);
//		System.out.println("create tempFile");
		if( Files.notExists(targetPath) )	throw new FileNotFoundException(targetPath.toString());
		
		String tempRealPath = portletRequest.getPortletSession().getPortletContext().getRealPath(this.TEMP_DIR_NAME);
		Path baseTempDir = Paths.get( tempRealPath );
		if( !Files.exists(baseTempDir)){
			Files.createDirectory(baseTempDir);
		}
		Path relativeTempPath = baseTempDir.getFileName();
		baseTempDir = this.getUniqueUuidFilePath(baseTempDir, "", "");
		Files.createDirectory( baseTempDir );
		baseTempDir.toFile().deleteOnExit();
		
		relativeTempPath = relativeTempPath.resolve(baseTempDir.getFileName());
		final Path tempFilePath = baseTempDir.resolve(targetPath.getFileName());
		if(isJobResult){
		    Path relTargetPath = Paths.get(target);
		    Iterator<Path> iter = relTargetPath.iterator();
		    int index = 0;
		    while(iter.hasNext()){
		        Path thisPath = iter.next();
		        if(index++ < 2){
		            continue;
		        }
		        relativeTempPath = relativeTempPath.resolve(thisPath);
		    }
		    
		}else{
		    relativeTempPath = relativeTempPath.resolve(target);
		}
		
		if( Files.isRegularFile(targetPath, LinkOption.NOFOLLOW_LINKS) ){
			Files.copy(targetPath, tempFilePath, StandardCopyOption.REPLACE_EXISTING);
		}
		else if ( Files.isDirectory(targetPath, LinkOption.NOFOLLOW_LINKS) ){
			Files.walkFileTree(targetPath,  new OSPFileVisitor( targetPath, tempFilePath) );
		}
		else
			throw new FileNotFoundException(targetPath.toString()+": is not a regular file.");
		
		return relativeTempPath.toString();
	}
	
	/**
	 * Copy a file or a folder to servlet container template folder based on 
	 *  of the servlet context path.
	 *  Returns the template path based on of the servlet context path.
	 */
	public String getCopiedTemporaryFilePath(
			PortletRequest portletRequest, 
			String source, 
			String prefix, 
			String suffix,
			String repoType) throws IOException, PortalException, SystemException{
		final Path sourcePath = this.getRepositoryPath(portletRequest, source, repoType);
//    		final Path targetPath = this.get_USER_ROOT_DIR_PATH().resolve(target);
//    		System.out.println("create tempFile");
		OSPRepositoryTypes repositoryType = OSPRepositoryTypes.valueOf(repoType);
		if( Files.notExists(sourcePath) )	throw new FileNotFoundException(sourcePath.toString());

		Path tempRealPath = Paths.get(portletRequest.getPortletSession().getPortletContext().getRealPath(this.TEMP_DIR_NAME));
		if( Files.notExists(tempRealPath)){
			Files.createDirectory(tempRealPath);
		}
		
		Path tempUuidPath = tempRealPath.resolve( this.getUniqueUuidFilePath(tempRealPath, "", "") );
		tempUuidPath.toFile().deleteOnExit();
		
		if( Files.isRegularFile(sourcePath, LinkOption.NOFOLLOW_LINKS) ){
			Files.copy(sourcePath, tempUuidPath, StandardCopyOption.REPLACE_EXISTING);
		}
		else if ( Files.isDirectory(sourcePath, LinkOption.NOFOLLOW_LINKS) ){
			Files.createDirectory( tempUuidPath );
			Files.walkFileTree(sourcePath,  new OSPFileVisitor( sourcePath, tempUuidPath) );
		}
		else
			throw new FileNotFoundException(sourcePath.toString()+": is not a regular file.");
	
		return tempUuidPath.getParent().getFileName().resolve(tempUuidPath.getFileName()).toString();
	}

	@Deprecated
	public JSONArray getFolderInformation( 
			PortletRequest portletRequest, 
			String folderPath, 
			String filter,
			boolean isJobResult) throws IOException, PortalException, SystemException{
		Path targetPath = this.getUserHome(portletRequest, isJobResult).resolve(folderPath);
		filter = this.extractExtension(filter);
		
		return this.lookUpFolder(targetPath.toFile(), filter);
	}
	
	/**
	 *  List file information in a folder and return JSONArray.
	 *  [
	 *  	{
	 *  		name:String [file name],
	 *			size: String [file size],
	 *			isFile:boolean [ file or not ]
	 *  	},
	 *  	......
	 *  ]
	 */
	public JSONArray getFolderInformation( 
			PortletRequest portletRequest, 
			String folderPath, 
			String filter,
			String repositoryType ) throws IOException, PortalException, SystemException{
		Path targetPath = this.getRepositoryPath(portletRequest, folderPath, repositoryType);
		filter = this.extractExtension(filter);
		
		return this.lookUpFolder(targetPath.toFile(), filter);
	}
	
	@Deprecated
	public JSONObject getFileInformation( 
			PortletRequest portletRequest, 
			String filePath,
			boolean isJobResult) throws IOException, PortalException, SystemException{
		return this.getFileInformation(this.getUserHome(portletRequest, isJobResult).resolve(filePath));
	}
	
	/**
	 *  Returns information of a specified file and return JSONObject.
	 *  {
	 *  	name:String [file name],
	 *		size: String [file size],
	 *		isFile:boolean [ file or not ]
	 *  }
	 */
	public JSONObject getFileInformation( 
			PortletRequest portletRequest, 
			String filePath,
			String repositoryType ) throws IOException, PortalException, SystemException{
		return this.getFileInformation(this.getRepositoryPath(portletRequest, filePath, repositoryType));
	}
	
	public Path createFile( PortletRequest portletRequest, String target, String repositoryType ) throws PortalException, SystemException, IOException{
		Path filePath = this.getRepositoryPath(portletRequest, target, repositoryType);
		Path parentPath = Files.createDirectories(filePath.getParent());
		Files.deleteIfExists(filePath);
		return Files.createFile(filePath);
	}
	
	public void deleteFile( 
			PortletRequest portletRequest,  
			String target, 
			String repositoryType ) throws IOException, PortalException, SystemException{
		Path targetPath = this.getRepositoryPath(portletRequest, target, repositoryType);
		this.deleteFile(targetPath);
	}
	
	private void deleteFile(Path target) throws IOException{
		Files.deleteIfExists(target);
	}
	
	public String moveFile( 
			PortletRequest portletRequest,  
			String source, 
			String target, 
			boolean overwrite, 
			String repositoryType ) throws IOException, PortalException, SystemException{
		
		Path sourcePath = this.getRepositoryPath(portletRequest, source, repositoryType);
		if( Files.notExists(sourcePath) )
			throw new FileNotFoundException(sourcePath.toString());
		
		Path targetPath = this.getRepositoryPath(portletRequest, target, repositoryType);
		Path targetFolder = targetPath.getParent();
		if( Files.notExists(targetFolder) ){
			Files.createDirectories(targetFolder);
			String owner = this.getUserName(portletRequest);
			
			this.changeFileOwner(portletRequest, targetFolder.toString(), owner, repositoryType);
			this.changeFileMode(portletRequest, targetFolder.toString(), "755", repositoryType);
		}
		
		this.moveFile(sourcePath, targetPath, overwrite);
		
		return target;
	}
	
	private Path moveFile(
			Path source, 
			Path target, 
			boolean overwrite) throws IOException{
		CopyOption[] options;
		Path newPath;
		if( overwrite ){
			options = new CopyOption[]{
				StandardCopyOption.REPLACE_EXISTING
			};
			newPath = Files.move(source, target, options);
		}
		else
			newPath = Files.move(source, target);
		
		return newPath;
	}
	
	public String copyFile( 
			PortletRequest portletRequest,
			String source, 
			String target, 
			boolean overwrite, 
			String repositoryType ) throws IOException, PortalException, SystemException{
		
		Path sourcePath = this.getRepositoryPath(portletRequest, source, repositoryType);
		if( Files.notExists(sourcePath) )
			throw new FileNotFoundException(sourcePath.toString());
		
		Path targetPath = this.getRepositoryPath(portletRequest, target, repositoryType);
		Path targetFolder = targetPath.getParent();
		if( Files.notExists(targetFolder) ){
			Files.createDirectories(targetFolder);
			String owner = this.getUserName(portletRequest);
			
			this.changeFileOwner(portletRequest, targetFolder.toString(), owner, repositoryType);
			this.changeFileMode(portletRequest, targetFolder.toString(), "755", repositoryType);
		}
		
		this.copyFile(sourcePath, targetPath, overwrite);
		
		return target;
	}
	
	private Path copyFile( Path source, Path target, boolean overwrite ) throws IOException{
		CopyOption[] options;
		Path newPath;
		if( overwrite ){
			options = new CopyOption[]{
				StandardCopyOption.REPLACE_EXISTING
			};
			newPath = Files.copy(source, target, options);
		}
		else
			newPath = Files.copy(source, target);
		
		return newPath;
	}
	
	/**
	 *  Copy an dlentry to the target file
	 * @throws IOException 
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public String copyDLEntryFile(
			PortletRequest portletRequest,
			long srcDLEntryId, 
			String target,
			boolean overwrite, 
			String repositoryType ) throws IOException, PortalException, SystemException{
		FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(srcDLEntryId);
		InputStream stream = null;
		
		stream = fileEntry.getContentStream();
		Path targetPath = this.getRepositoryPath(portletRequest, target, repositoryType);
		Path targetFolder = targetPath.getParent();
		if( !Files.exists( targetFolder ) ){
			Files.createDirectories(targetFolder);
			String owner = this.getUserName(portletRequest);
			
			this.changeFileOwner(portletRequest, targetFolder.toString(), owner, repositoryType);
			this.changeFileMode(portletRequest, targetFolder.toString(), "755", repositoryType);
		}
		
		Files.copy(stream, targetPath, StandardCopyOption.REPLACE_EXISTING);
		
		if( Validator.isNotNull(stream) )
			stream.close();
		
		return target;
	}
	
	/**
	 * Change owner of a file
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public void changeFileOwner( 
			PortletRequest portletRequest, 
			String target, 
			String owner, 
			String repositoryType ) throws PortalException, SystemException{
		Path targetPath = this.getRepositoryPath(portletRequest, target, repositoryType);
		owner += owner + ":edisonuser";
		String strCmd = "";
		strCmd += "sudo chown -R ";
		strCmd += owner;
		strCmd += " ";
		strCmd += targetPath.toString();
		
		CommandLine cmdLine = CommandLine.parse( strCmd );
		
		System.out.println("chown Command: "+cmdLine.toString());
		
		final OutputStream outStream = new ByteArrayOutputStream();
		final OutputStream errorStream = new ByteArrayOutputStream();

		DefaultExecuteResultHandler resultHandler;
		try {
			resultHandler = execute(cmdLine, null, outStream, errorStream);
			resultHandler.waitFor(_DEFAULT_TIMEOUT);
		} catch (ExecuteException e) {
			throw new PortalException("Fail to chown exec");
		} catch (IOException e) {
			throw new PortalException("chown IOException: " + e.getMessage(), e);
		} catch (InterruptedException e) {
			throw new PortalException("chown InterruptedException: " + e.getMessage(), e);
		}

		int exitValue = resultHandler.getExitValue();

		if (exitValue != 0)
			throw new PortalException("Failed to chown : " + errorStream.toString());
	}
	
	/**
	 * Change mode of a file
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public void changeFileMode( 
			PortletRequest portletRequest, 
			String target, 
			String mode, 
			String repositoryType) throws PortalException, SystemException{
		Path targetPath = this.getRepositoryPath(portletRequest, target, repositoryType);
		
		String strCmd = "";
		strCmd += "sudo chmod ";
		strCmd += mode;
		strCmd += " ";
		strCmd += targetPath.toString();
		
		CommandLine cmdLine = CommandLine.parse( strCmd );
		
		System.out.println("chmod Command: "+cmdLine.toString());
		
		final OutputStream outStream = new ByteArrayOutputStream();
        final OutputStream errorStream = new ByteArrayOutputStream();
        
        DefaultExecuteResultHandler resultHandler;
        try {
            resultHandler = this.execute(cmdLine, null, outStream, errorStream);
            resultHandler.waitFor(_DEFAULT_TIMEOUT);
        } catch (ExecuteException e) {
        	throw new PortalException("Fail to chmod exec");
        } catch (IOException e) {
            throw new PortalException("chmod IOException: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            throw new PortalException("chmod InterruptedException: " + e.getMessage(), e);
        }

        int exitValue = resultHandler.getExitValue();

        if (exitValue != 0)
            throw new PortalException("Failed to chmod : " + errorStream.toString());
	}
	
	private DefaultExecuteResultHandler execute(CommandLine cmdLine, OutputStream outStream, OutputStream errorStream)
            throws ExecuteException, IOException {
        return this.execute(cmdLine, Collections.<String, String> emptyMap(), outStream, errorStream);
    }

    private DefaultExecuteResultHandler execute(CommandLine cmdLine, Map<String, String> environment, OutputStream outStream,
            OutputStream errorStream) throws ExecuteException, IOException {
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        ExecuteStreamHandler streamHandler = new PumpStreamHandler(outStream, errorStream);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(0);
        executor.setStreamHandler(streamHandler);
        if (environment != null) {
            executor.execute(cmdLine, environment, resultHandler);
        } else {
            executor.execute(cmdLine, resultHandler);
        }
        return resultHandler;
    }

	
	@Deprecated
	public void duplicated( 
			PortletRequest portletRequest, 
			PortletResponse portletResponse, 
			String filePath,
			boolean isJobResult) throws PortalException, SystemException, IOException{
		Path targetPath = this.getUserHome(portletRequest, isJobResult).resolve(filePath);
		
		JSONObject result = JSONFactoryUtil.createJSONObject();
		result.put("duplicated", Files.exists( targetPath ));
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(portletResponse);
		ServletResponseUtil.write(httpResponse, result.toString() );
	}
	
	/**
	 * Check a file is exist or not.
	 * 
	 * @param portletRequest
	 * @param portletResponse
	 * @param filePath
	 * @param repositoryType
	 * 
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	public void duplicated( 
			PortletRequest portletRequest, 
			PortletResponse portletResponse, 
			String filePath,
			String repositoryType) throws PortalException, SystemException, IOException{
		Path targetPath = this.getRepositoryPath(portletRequest, filePath, repositoryType);
		
		JSONObject result = JSONFactoryUtil.createJSONObject();
		result.put("duplicated", Files.exists( targetPath ));
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(portletResponse);
		ServletResponseUtil.write(httpResponse, result.toString() );
	}

	@Deprecated
	public void upload( 
			PortletRequest portletRequest, 
			String target,
			String uploadFileName,
			boolean isJobResult) throws SystemException, PortalException, IOException{
		Path userHome = this.getUserHome(portletRequest, isJobResult);
		
		Path targetPath = userHome.resolve(target);// Data should be inserted by SystemPropertyService.

		System.out.println("Upload Target: "+targetPath.toString());
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(portletRequest);
		
		System.out.println(uploadRequest.getFileName(uploadFileName));
		
		// Get the uploaded file as a file.
		File uploadedFile = uploadRequest.getFile(uploadFileName);
		
		// Move the existing temporary file to new location.
		Files.copy(uploadedFile.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
	}

	/**
	 * Upload a file from session request as the target.
	 * 
	 * @param portletRequest
	 * @param target
	 * @param uploadFileName
	 * @param repositoryType
	 * 
	 * @throws SystemException
	 * @throws PortalException
	 * @throws IOException
	 */
	public void upload( 
			PortletRequest portletRequest, 
			String target,
			String uploadFileName,
			String repositoryType) throws SystemException, PortalException, IOException{
		
		Path targetPath = this.getRepositoryPath(portletRequest, target, repositoryType);

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(portletRequest);
		
		// Get the uploaded file as a file.
		File uploadedFile = uploadRequest.getFile(uploadFileName);
		
		// Move the existing temporary file to new location.
		Files.copy(uploadedFile.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
	}

	@Deprecated
	public void download(
	    PortletRequest portletRequest, 
        PortletResponse portletResponse, 
        long dlFileEntryId) throws PortalException, SystemException, IOException{
	    HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(portletRequest);
        HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(portletResponse);
        
	    DLFileEntry dlFileEntry = DLFileEntryServiceUtil.getFileEntry(dlFileEntryId);
	    InputStream inputStream = dlFileEntry.getContentStream();
        String fileName = dlFileEntry.getTitle();
        ServletResponseUtil.sendFile(
            httpRequest, httpResponse, fileName, inputStream, 
            dlFileEntry.getSize(), "application/octet-stream", "attachment");
	}

	/**
	 * Download a DLEntry file.
	 * 
	 * @param portletRequest
	 * @param portletResponse
	 * @param dlFileEntryId
	 * 
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	public void downloadDLEntry(
		    PortletRequest portletRequest, 
	        PortletResponse portletResponse, 
	        long dlFileEntryId) throws PortalException, SystemException, IOException{
		    HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(portletRequest);
	        HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(portletResponse);
	        
		    DLFileEntry dlFileEntry = DLFileEntryServiceUtil.getFileEntry(dlFileEntryId);
		    InputStream inputStream = dlFileEntry.getContentStream();
	        String fileName = dlFileEntry.getTitle();
	        ServletResponseUtil.sendFile(
	            httpRequest, httpResponse, fileName, inputStream, 
	            dlFileEntry.getSize(), "application/octet-stream", "attachment");
	}

	
	@Deprecated
	public void download(
			PortletRequest portletRequest, 
			PortletResponse portletResponse, 
			String targetFolder, 
			String[] files,
			boolean isJobResult) throws IOException, PortalException, SystemException{
		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(portletRequest);
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(portletResponse);

		Path userHome = this.getUserHome(portletRequest, isJobResult);
		Path targetPath = userHome.resolve(targetFolder);
		_log.info("Download Target Path: "+targetPath.toString());
		if( files.length == 1 ){
			Path filePath = targetPath.resolve(files[0]);
			_log.info("Download Target file: "+ filePath.toString());
			ServletResponseUtil.sendFile(httpRequest, httpResponse, filePath.getFileName().toString(), Files.readAllBytes(filePath), "application/octet-stream", "attachment");
		}
		else{
			final Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxr-xr--");
			final FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);

			Path tempPath = userHome.resolve("temp");
			Files.createDirectories(tempPath, attr );
			
			Path zipPath = tempPath.resolve(targetPath.getFileName()+".zip");
			if( Files.exists(zipPath))
				Files.delete(zipPath);
			Files.createFile(zipPath, attr);
			zipPath.toFile().deleteOnExit();

			List<Path> filePaths = new ArrayList<>();
			for( String file : files ){
				filePaths.add( targetPath.resolve(file) );
			}
			this.zip(filePaths, zipPath);

			ServletResponseUtil.sendFile(httpRequest, httpResponse, zipPath.getFileName().toString(), Files.readAllBytes(zipPath), "application/octet-stream", "attachment");
		}
	}
	
	/**
	 * Download a file or files.
	 * If count of the files is larger than 1, the files zipped as an file.
	 */
	public void download(
			PortletRequest portletRequest, 
			PortletResponse portletResponse, 
			String targetFolder, 
			String[] files,
			String repositoryType) throws IOException, PortalException, SystemException{
		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(portletRequest);
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(portletResponse);

		Path targetPath = this.getRepositoryPath(portletRequest, targetFolder, repositoryType);
		if( files.length == 1 ){
			Path filePath = targetPath.resolve(files[0]);
			ServletResponseUtil.sendFile(httpRequest, httpResponse, filePath.getFileName().toString(), Files.readAllBytes(filePath), "application/octet-stream", "attachment");
		}
		else{
			final Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxr-xr--");
			final FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);

			Path tempPath = this.getRepositoryPath(portletRequest, TEMP_DIR_NAME, repositoryType);
			Files.createDirectories(tempPath, attr );
			
			Path zipPath = tempPath.resolve(targetPath.getFileName()+".zip");
			Files.deleteIfExists(zipPath);
			Files.createFile(zipPath, attr);
			zipPath.toFile().deleteOnExit();

			List<Path> filePaths = new ArrayList<>();
			for( String file : files ){
				filePaths.add( targetPath.resolve(file) );
			}
			this.zip(filePaths, zipPath);

			InputStream inputStream = new FileInputStream(zipPath.toFile());
			ServletResponseUtil.sendFile(
					httpRequest, httpResponse, 
					zipPath.getFileName().toString(), 
					inputStream, 
					Files.size(zipPath),
					"application/octet-stream", "attachment");
		}
	}
	   
    public void downloadFromText(
        PortletRequest portletRequest, 
        PortletResponse portletResponse,
        String fileName,
        String fileContext) throws PortalException, SystemException, IOException{
        HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(portletRequest);
        HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(portletResponse);
        InputStream inputStream = new ByteArrayInputStream(fileContext.getBytes("UTF-8"));
        ServletResponseUtil.sendFile(
            httpRequest, httpResponse, fileName, inputStream, "text/plain");
    }
	
	private void addZipEntry( ZipOutputStream zipOutputStream, Path fileName, Path base ) throws IOException{
		Path filePath = base.resolve(fileName);
		_log.debug(filePath.toString()+" just to be added");
		_log.debug("fileName: "+fileName.toString());
		_log.debug("base: "+base.toString());
		if( Files.isDirectory(filePath) ){
			String[] subFiles = filePath.toFile().list();
			for( String subFile : subFiles ){
				addZipEntry(zipOutputStream, fileName.resolve(subFile), base);
			}
		}
		else if( Files.isRegularFile(filePath) ){
			ZipEntry zipEntry = new ZipEntry(fileName.toString());
			zipOutputStream.putNextEntry(zipEntry);
			FileInputStream fileInputStream = new FileInputStream( filePath.toString() );
			int length;
			byte[] buffer = new byte[2048];
			while ((length = fileInputStream.read(buffer)) > 0) {
				zipOutputStream.write(buffer, 0, length);
			}
			// Closing the fileInputStream instance
			fileInputStream.close();
			zipOutputStream.closeEntry();
		}
		else{
			System.out.println("Un-known file type: "+filePath.toString());
		}
	}
	
	private void zip( List<Path> sources, Path destination ) throws IOException{
		ZipOutputStream zipOutputStream = null;
		try {
			zipOutputStream = new ZipOutputStream(new FileOutputStream(destination.toString()));
		} catch (FileNotFoundException e) {
			_log.error("[ERROR] zip() - destination not found: "+destination.toString());
			throw e;
		}
		
		try {
			for( Path source : sources ){
				this.addZipEntry(zipOutputStream, source.getFileName(), source.getParent());
			}
		} catch (IOException e) {
			_log.error("[ERROR] addZipEntry() while zip()");
			throw e;
		} 
		
		if (zipOutputStream != null) {
			try {
				zipOutputStream.close();
			} catch (IOException iOException) {
				_log.error("[ERROR] zipOutputStream.close() while zip()");
			}
		}
	}
	
	@Deprecated
    private Path getUserHome(PortletRequest portletRequest, boolean isJobResult)
        throws PortalException, SystemException{
        String userScreenName = PortalUtil.getUser(portletRequest).getScreenName();
        Path userHomePath = this.get_USER_ROOT_DIR_PATH();
        if(userScreenName.equalsIgnoreCase("edison")){
            userHomePath = userHomePath.resolve("edisonadm");
        }else{
            userHomePath = userHomePath.resolve(userScreenName);
        }
        if(!isJobResult){
            return userHomePath.resolve("repository");
        }else{
            return userHomePath.resolve("jobs");
        }
    }
	
	@Deprecated
	public void checkValidFile( 
			PortletRequest portletRequest, 
			PortletResponse portletResponse, 
			String filePath,
			boolean isJobResult) throws PortalException, SystemException, IOException{
		Path target = this.getUserHome(portletRequest, isJobResult).resolve(filePath);
		_log.info("checkValidFile()target: "+target.toString());
		
		JSONObject result = JSONFactoryUtil.createJSONObject();
		result.put("valid", Files.isRegularFile( target ));
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(portletResponse);
		ServletResponseUtil.write(httpResponse, result.toString() );
	}
	
	/**
	 * Check a file is regular file or not.
	 * 
	 * @param portletRequest
	 * @param portletResponse
	 * @param target
	 * @param repositoryType
	 * 
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	public void checkValidFile( 
			PortletRequest portletRequest, 
			PortletResponse portletResponse, 
			String target,
			String repositoryType) throws PortalException, SystemException, IOException{
		Path targetPath = this.getRepositoryPath(portletRequest, target, repositoryType);
		_log.info("checkValidFile()target: "+target.toString());
		
		JSONObject result = JSONFactoryUtil.createJSONObject();
		result.put("valid", Files.isRegularFile( targetPath ));
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(portletResponse);
		ServletResponseUtil.write(httpResponse, result.toString() );
	}
	
	@Deprecated
	public void readFileContent(
			PortletRequest portletRequest,
			PortletResponse portletResponse,
			String filePath,
			boolean isJobResult) throws PortalException, SystemException, IOException{
	    readFileContent(portletRequest, portletResponse, null, filePath, isJobResult);
	}

	/**
	 * Read a file content as a character stream.
	 * 
	 * @param portletRequest
	 * @param portletResponse
	 * @param target
	 * @param repositoryType
	 * 
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	public void readFileContent(
			PortletRequest portletRequest,
			PortletResponse portletResponse,
			String target,
			String repositoryType) throws PortalException, SystemException, IOException{
		
		Path targetPath = this.getRepositoryPath(portletRequest, target, repositoryType);
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(portletResponse);
		ServletResponseUtil.write(httpResponse, targetPath.toFile() );
	}

	@Deprecated
	public void getFile(
	    PortletRequest portletRequest,
        PortletResponse portletResponse,
        String filePath,
        boolean isJobResult) throws PortalException, SystemException, IOException{
	    
	    HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(portletRequest);
        HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(portletResponse);
        Path target = this.getUserHome(portletRequest, isJobResult).resolve(filePath);
	
	    ServletResponseUtil.sendFile(
	        httpRequest, httpResponse, target.getFileName().toString(), Files.readAllBytes(target));
	}
	
	/**
	 * Download a file.
	 * 
	 * @param portletRequest
	 * @param portletResponse
	 * @param target
	 * @param repositoryType
	 * 
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	public void downloadFile(
		    PortletRequest portletRequest,
	        PortletResponse portletResponse,
	        String target,
	        String repositoryType) throws PortalException, SystemException, IOException{
		
		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(portletRequest);
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(portletResponse);
		Path targetPath = this.getRepositoryPath(portletRequest, target, repositoryType);
		
		InputStream inputStream = new FileInputStream(targetPath.toFile());
		ServletResponseUtil.sendFile(
		        httpRequest, httpResponse, 
		        targetPath.getFileName().toString(),
		        inputStream,
		        Files.size(targetPath),
		        "application/octet-stream", "attachment");
	}

	
	@Deprecated
	public void readFileContent(
	    PortletRequest portletRequest,
	    PortletResponse portletResponse,
	    String contentType,
	    String filePath,
	    boolean isJobResult) throws PortalException, SystemException, IOException{
	    Path target = this.getUserHome(portletRequest, isJobResult).resolve(filePath);
	    _log.debug("readFileContent() target: "+target.toString());
	    HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(portletResponse);
	    _log.info("target file : " + target.toFile().getAbsolutePath());
	    if(contentType != null && !contentType.isEmpty()){
	        httpResponse.setContentType(contentType);
	    }
	    ServletResponseUtil.write(httpResponse, target.toFile() );
	}

	/**
	 * Read a file content with the specified content type.
	 * 
	 * @param portletRequest
	 * @param portletResponse
	 * @param contentType
	 * @param target
	 * @param repositoryType
	 * 
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	public void readFileContent(
		    PortletRequest portletRequest,
		    PortletResponse portletResponse,
		    String contentType,
		    String target,
		    String repositoryType) throws PortalException, SystemException, IOException{
		Path targetPath = this.getRepositoryPath(portletRequest, target, repositoryType);
		
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(portletResponse);
		if(contentType != null && !contentType.isEmpty()){
			httpResponse.setContentType(contentType);
		}
	    ServletResponseUtil.write(httpResponse, targetPath.toFile() );
	}
	
	@Deprecated
	public void readFirstFileContent(
				PortletRequest portletRequest,
				PortletResponse portletResponse,
				String parentPath,
				String filter,
	            boolean isJobResult ) throws PortalException, SystemException, IOException{
		Path target = this.getUserHome(portletRequest, isJobResult).resolve(parentPath);
		
		_log.info("target Path : " + target.toString());
		
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(portletResponse);
		if(Files.isDirectory(target)){
			File[] subFiles = target.toFile().listFiles( new FileExtensionFilter(filter) );
			for(File file : subFiles){
				if(file.isFile()){
					_log.info("target file : " + file.getAbsolutePath());
					ServletResponseUtil.write(httpResponse, file);
					break;
				}
			}
		}else if(Files.isRegularFile(target)){
			_log.info("readFirstFileContent() target: " + target.toString());
			ServletResponseUtil.write(httpResponse, target.toFile());
		}
	}
	
	/**
	 * Read file content or the first file in a folder.
	 * 
	 * @param portletRequest
	 * @param portletResponse
	 * @param target
	 * @param filter
	 * @param repositoryType
	 * 
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	public void readFirstFileContent(
			PortletRequest portletRequest,
			PortletResponse portletResponse,
			String target,
			String filter,
			String repositoryType ) throws PortalException, SystemException, IOException{
		Path targetPath = this.getRepositoryPath(portletRequest, target, repositoryType);
		
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(portletResponse);
		if(Files.isDirectory(targetPath)){
			File[] subFiles = targetPath.toFile().listFiles( new FileExtensionFilter(filter) );
			for(File file : subFiles){
				if(file.isFile()){
					ServletResponseUtil.write(httpResponse, file);
					break;
				}
			}
		}else if(Files.isRegularFile(targetPath)){
			ServletResponseUtil.write(httpResponse, targetPath.toFile());
		}
	}

	@Deprecated
	public byte[] readFileContent( PortletRequest portletRequest, String filePath, boolean isJobResult) throws PortalException, SystemException, IOException{
		Path target = this.getUserHome(portletRequest, isJobResult).resolve(filePath);
		
		return Files.readAllBytes(target);
	}
	
	/**
	 * Read a file content
	 * 
	 * @param portletRequest
	 * @param target
	 * @param repositoryType
	 * 
	 * @return
	 * 	byte[] file content
	 * 
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	public byte[] readFileContent( 
			PortletRequest portletRequest, 
			String target, 
			String repositoryType) throws PortalException, SystemException, IOException{
		Path targetPath = this.getRepositoryPath(portletRequest, target, repositoryType);
		
		return Files.readAllBytes(targetPath);
	}
	
	@Deprecated
	public void getFirstFileName(
			PortletRequest portletRequest,
			PortletResponse portletResponse,
			String parentPath,
			String filter,
            boolean isJobResult ) throws PortalException, SystemException, IOException{
		Path target = this.getUserHome(portletRequest, isJobResult).resolve(parentPath);
		_log.info("getFirstFileName()*****");
		_log.info("ParentPath : " + parentPath);
		_log.info("filter : " + filter);
		_log.info("***** getFirstFileName()");
		
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(portletResponse);
		JSONObject result = JSONFactoryUtil.createJSONObject();
		if(Files.isDirectory(target)){
			File[] subFiles = target.toFile().listFiles( new FileExtensionFilter(filter) );
			for(File file : subFiles){
				if(file.isFile()){
					_log.info("target file : " + file.getAbsolutePath());
					result.put("parentPath", file.getParent());
					result.put("fileName", file.getName());
					ServletResponseUtil.write(httpResponse, result.toString());
					break;
				}
			}
		}else if(Files.isRegularFile(target)){
			_log.info("readFirstFileName() target: " + target.toString());
			result.put("parentPath", target.getParent().toString());
			result.put("fileName", target.getFileName().toString());
			ServletResponseUtil.write(httpResponse, result.toString());
		}
	}

	/**
	 * Gets the file name of a path or the first file name of a folder.
	 * 
	 * @param portletRequest
	 * @param portletResponse
	 * @param target
	 * @param filter
	 * @param repositoryType
	 * 
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	public void getFirstFileName(
			PortletRequest portletRequest,
			PortletResponse portletResponse,
			String target,
			String filter,
			String repositoryType ) throws PortalException, SystemException, IOException{
		Path targetPath = this.getRepositoryPath(portletRequest, target, repositoryType);
		
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(portletResponse);
		JSONObject result = JSONFactoryUtil.createJSONObject();
		if(Files.isDirectory(targetPath)){
			File[] subFiles = targetPath.toFile().listFiles( new FileExtensionFilter(filter) );
			for(File file : subFiles){
				if(file.isFile()){
					result.put("parentPath", file.getParent());
					result.put("fileName", file.getName());
					ServletResponseUtil.write(httpResponse, result.toString());
					break;
				}
			}
		}else if(Files.isRegularFile(targetPath)){
			_log.info("readFirstFileName() target: " + target.toString());
			result.put("parentPath", targetPath.getParent().toString());
			result.put("fileName", targetPath.getFileName().toString());
			ServletResponseUtil.write(httpResponse, result.toString());
		}
	}

	@Deprecated
	public void saveFileContent(
			PortletRequest portletRequest,
			String filePath,
			String content,
			boolean isJobResult) throws PortalException, SystemException, IOException{
		Path target = this.getUserHome(portletRequest, isJobResult).resolve(filePath);
		_log.debug("readFileContent() target: "+target.toString());
		OpenOption[] openOptions = new OpenOption[] { StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING};
		Files.write(target, content.getBytes(StandardCharsets.UTF_8), openOptions);
	}

	/**
	 * Save the specified content to a file.
	 * 
	 * @param portletRequest
	 * @param target
	 * @param content
	 * @param repositoryType
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	public void saveFileContent(
			PortletRequest portletRequest,
			String target,
			String content,
			String repositoryType) throws PortalException, SystemException, IOException{
		Path targetPath = this.getRepositoryPath(portletRequest, target, repositoryType);
		OpenOption[] openOptions = new OpenOption[] { StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING};
		Files.write(targetPath, content.getBytes(StandardCharsets.UTF_8), openOptions);
	}

    public void writeTextFile(String content, Path target) throws IOException{
        if(!Files.exists(target.getParent())){
            Files.createDirectories(target.getParent());
        }
        Files.write(target, content.getBytes(StandardCharsets.UTF_8), 
            new OpenOption[]{
                StandardOpenOption.CREATE_NEW, 
                StandardOpenOption.WRITE, 
                StandardOpenOption.TRUNCATE_EXISTING
                }
        );
    }
	
	public void readDLAppEntry ( PortletResponse portletResponse, long dlEntryId ) throws SystemException, IOException{
		FileEntry fileEntry;
		JSONObject resultData = JSONFactoryUtil.createJSONObject();
		try {
			fileEntry = DLAppLocalServiceUtil.getFileEntry(dlEntryId);
		} catch (PortalException e) {
			resultData.put("dlEntryId", dlEntryId);
			this.writeToClient(portletResponse, "Invalid DLEntry ID", resultData);
			return;
		}
		
		InputStream stream;
		try {
			stream = fileEntry.getContentStream();
		} catch (PortalException e) {
			resultData.put("dlEntryId", dlEntryId);
			this.writeToClient(portletResponse, "Invalid DLEntry ID", resultData);
			return;
		}

		String content = new String(FileUtil.getBytes(stream));
		stream.close();
		
		resultData.put("type_", "fileContent");
		resultData.put("context_", content);
		
		this.writeToClient( portletResponse, null, resultData );
	}
	
	public void writeToClient( PortletResponse portletResponse, String errorMessage, JSONObject data ) throws IOException{
		JSONObject result = JSONFactoryUtil.createJSONObject();
		if( errorMessage != null ){
			result.put( "error", errorMessage );
		}
		else{
			result.put( "success", data );
		}
		
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(portletResponse);
		ServletResponseUtil.write(httpResponse, result.toString() );
	}
	
	@Deprecated
    public Map<String, Object> readOutLogFile(
        PortletRequest portletRequest, 
        String simulationUuid, 
        String jobUuid,
        long lastPosition) throws IOException, PortalException, SystemException{
        Path target = this.getUserHome(portletRequest, true)
            .resolve(simulationUuid + "/" + jobUuid + ".job/" + jobUuid + ".out");
	    TextAndLastPosition outLog = readTextAndLastPosition(target, lastPosition);
	    Map<String, Object> result = new HashMap<String, Object>();
        result.put("outLog", outLog.getText());
        result.put("lastPosition", outLog.getLastPosition());
        return result;
	}
	
	public JSONObject readFile(
			PortletRequest portletRequest,
			String target,
			long startPosition,
			long size,
			String repositoryType ) throws PortalException, SystemException, IOException{
		Path targetPath = this.getRepositoryPath(portletRequest, target, repositoryType);
		
		TextAndLastPosition outLog = readTextAndLastPosition(targetPath, startPosition);
		
		JSONObject result = JSONFactoryUtil.createJSONObject();
		result.put("outLog", outLog.getText());
		result.put("lastPosition", outLog.getLastPosition());
		return result;
	}
	
	@Deprecated
    public String readTextFile(Path path) throws IOException{
        return readTextAndLastPosition(path, 0).getText();
    }
    
    @Deprecated
    public String getAbolutePath( PortletRequest portletRequest, String path, boolean isJobResult ) throws PortalException, SystemException{
    	Path absolutePath = this.getUserHome(portletRequest, isJobResult).resolve(path);
    	
    	return absolutePath.toString();
    }

    /**
     *  Get path based on repository type.
     */
    private Path getRepositoryPath( PortletRequest portletRequest, String path, String repoType ) throws PortalException, SystemException{
    	Path targetPath;
    	OSPRepositoryTypes repositoryType = OSPRepositoryTypes.valueOf(repoType);
    	switch( repositoryType ){
    		case USER_HOME:
    		case USER_JOBS:
    			targetPath = Paths.get( OSPPropsUtil.getUserRootDirPath() )
    													.resolve(this.getUserName(portletRequest))
    													.resolve(repositoryType.value())
    													.resolve(path);
    			break;
    		case PROVENANCE:
    			targetPath = Paths.get( OSPPropsUtil.getProvenanceRootDirPath() ).resolve(path);
    			break;
    		case ICECAP:
    			targetPath = Paths.get( OSPPropsUtil.getIcecapRootDirPath() ).resolve(path);
    			break;
    		case SCIENCEAPP:
    			targetPath = Paths.get( OSPPropsUtil.getSpyGlassAppsDirPath() ).resolve(path);
    			break;
    		default:
    			targetPath = Paths.get("/");
    	}
    	
    	return targetPath;
    }
    
    public String getJobResultPath( String simulationUuid, String jobUuid, String path ){
    	return Paths.get(simulationUuid, jobUuid+".job", path).toString();
    }
    
    private String getUserName( PortletRequest portletRequest ) throws PortalException, SystemException{
    	String userName = PortalUtil.getUser(portletRequest).getScreenName();
    	if( userName.equalsIgnoreCase("edison") )
    		userName = "edisonadm";
    	
    	return userName;
    }
    
    private TextAndLastPosition readTextAndLastPosition(Path path, long lastPoistion) throws IOException{
        FileChannel fcIn = FileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        StringBuffer sb = new StringBuffer();
        if(lastPoistion > 0){
         fcIn.position(lastPoistion);   
        }
        while(fcIn.read(buffer) != -1){
            byte[] bytes = new byte[buffer.position()];
            buffer.flip();
            buffer.get(bytes);
            sb.append(new String(bytes));
            buffer.clear();
        }
        lastPoistion = fcIn.position();
        fcIn.close();
        return new TextAndLastPosition(sb.toString(), lastPoistion);
    }
    
    private TextAndLastPosition readTextAndLastPosition(Path path, long startPosition, long size) throws IOException{
        FileChannel fcIn = FileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        StringBuffer sb = new StringBuffer();
        if(startPosition > 0){
         fcIn.position(startPosition);   
        }
        while(fcIn.read(buffer) != -1){
            byte[] bytes = new byte[buffer.position()];
            buffer.flip();
            buffer.get(bytes);
            sb.append(new String(bytes));
            buffer.clear();
        }
        long lastPosition = fcIn.position();
        fcIn.close();
        return new TextAndLastPosition(sb.toString(), lastPosition);
    }
    
    static class TextAndLastPosition{
        private String text;
        private long lastPosition;
        public TextAndLastPosition(String text, long lastPosition){
            this.text = text;
            this.lastPosition = lastPosition;
        }
        public String getText(){
            return text;
        }
        public long getLastPosition(){
            return lastPosition;
        }
    }
    
    static class OSPFileVisitor extends SimpleFileVisitor<Path>{
    	Path targetPath;
    	Path tempFilePath;
    	
    	public OSPFileVisitor( Path targetPath, Path tempPath ){
    		this.targetPath = targetPath;
    		this.tempFilePath = tempPath;
    	}
    	
		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
			Path path = targetPath.relativize(dir);
			Path tempPath = tempFilePath.resolve(path);
			if( !Files.exists(tempPath) ){
				Path tempFolder = null;
				try {
					tempFolder = Files.createDirectory(tempPath);
					tempFolder.toFile().deleteOnExit();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
			Path path = targetPath.relativize(file);
			Path tempPath = tempFilePath.resolve(path);
			try {
				Files.copy(file, tempPath, StandardCopyOption.REPLACE_EXISTING);
				tempPath.toFile().deleteOnExit();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return FileVisitResult.CONTINUE;
		}

    }
}