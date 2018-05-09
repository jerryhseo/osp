package com.kaist.wignernwfet.portlet.csvplotter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import com.kisti.osp.constants.OSPRepositoryTypes;
import com.kisti.osp.util.OSPFileUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CSVPlotterPortlet
 */
public class CSVPlotterPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		boolean eventEnable = ParamUtil.getBoolean(renderRequest, "eventEnable", true);
        String inputData = ParamUtil.getString(renderRequest, "inputData", "");
        String connector = ParamUtil.getString(renderRequest, "connector", "broadcast");
        String mode = ParamUtil.getString(renderRequest, "mode", "VIEW");

        renderRequest.setAttribute("eventEnable", eventEnable);
        renderRequest.setAttribute("inputData", inputData);
        renderRequest.setAttribute("connector", connector);
        renderRequest.setAttribute("mode", mode);
		
		super.doView(renderRequest, renderResponse);
	}
	
    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
        throws IOException, PortletException{
        String parentPath = ParamUtil.getString(resourceRequest, "parentPath");
        String fileName = ParamUtil.getString(resourceRequest, "fileName");

        String command = ParamUtil.getString(resourceRequest, "command");
        String repositoryType = ParamUtil.getString(resourceRequest, "repositoryType", OSPRepositoryTypes.USER_HOME.toString());
        
        System.out.println("command: "+command);

        if(command.equalsIgnoreCase("READ_FILE")){
            Path filePath = Paths.get(parentPath).resolve(fileName);
            System.out.println("filePath: "+filePath.toString());
            try{
                OSPFileUtil.readFileContent(resourceRequest, resourceResponse, filePath.toString(), repositoryType);
            }catch (PortalException | SystemException e){
                throw new PortletException();
            }
        }
        else if(command.equalsIgnoreCase("READ_FIRST_FILE")){
            try{
                OSPFileUtil.readFirstFileContent(resourceRequest, resourceResponse, parentPath,
                    fileName, repositoryType);
            }catch (PortalException | SystemException e){
                System.out.println("READ_FIRST_FILE: " + parentPath + ", "+fileName);
                throw new PortletException();
            }
        }
        else if(command.equalsIgnoreCase("GET_FIRST_FILE_NAME")){
            try{
                OSPFileUtil.getFirstFileName(resourceRequest, resourceResponse, parentPath,
                    fileName, repositoryType);
            }catch (PortalException | SystemException e){
                System.out.println("GET_FIRST_FILE_NAME: " + parentPath + ", "+fileName);
                throw new PortletException();
            }
        }else if(command.equalsIgnoreCase("DOWNLOAD_FILE")){
            try{
                OSPFileUtil.download(resourceRequest, resourceResponse, parentPath,
                    new String[]{fileName}, repositoryType);
            }catch (PortalException | SystemException e){
            	System.out.println("checkValidFile(): " + Paths.get(parentPath).resolve(fileName).toString());
                throw new PortletException();
            }
        }
    }
}
