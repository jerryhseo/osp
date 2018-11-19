package org.kisti.edison.osp.editor.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kisti.edison.osp.editor.helper.MeshAppHelper;
import org.kisti.edison.osp.model.AnalyzerJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

@Controller
@RequestMapping("VIEW")
public class ParameterController {
	private static Log log = LogFactory.getLog(ParameterController.class);
	
	@Autowired
	private MeshAppHelper meshAppHelper;
	
	@ResourceMapping(value = "prepareAnalyzer")
	public void prepareAnalyzer(
			@RequestParam("fileId") String dataFileId,
			@RequestParam("appName") String appName,
			@RequestParam("appVersion") String appVersion,
			@RequestParam(value = "analyzerUuid", required=false) String analyzerUuid,
			ResourceRequest request, ResourceResponse response) throws IOException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		try{
			String userScreeName = themeDisplay.getUser().getScreenName();
			AnalyzerJob analyzerJob = null;
			if(!StringUtils.hasText(analyzerUuid)){
				analyzerJob = meshAppHelper.prepareAnalyzer(appName, appVersion,userScreeName);
			}else{
				analyzerJob = meshAppHelper.prepareAnalyzer(appName, appVersion,analyzerUuid,userScreeName);
			}
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(new Gson().toJson(analyzerJob));
		}catch (Exception e) {
			handleRuntimeException(e, PortalUtil.getHttpServletResponse(response),LanguageUtil.get(themeDisplay.getLocale(), "edison-data-search-error"));
		}
	}
	
	@ResourceMapping(value="executeAnalyzer")
	public void executeAnalyzer(
			@RequestParam("analyzerJob") String analyzerJobJson,
			@RequestParam("inputFileName") String inputFileName,
			@RequestParam("fileId") String fileId,
			@RequestParam("projectId") String projectId,
			@RequestParam(value = "fileContent", required=false) String fileContent,
			ResourceRequest request, ResourceResponse response) throws IOException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			AnalyzerJob analyzerJob = new Gson().fromJson(analyzerJobJson, AnalyzerJob.class);
			User user = PortalUtil.getUser(request);
//			boolean isCompleteAnalyzer = meshAppHelper.exeAnalyzer(GetterUtil.getLong(projectId), inputFileName, fileId, fileContent, themeDisplay, analyzerJob, user);
			
			long sleepTime = 2*1000;
			Thread.sleep(sleepTime);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
//			out.write("{\"isComplete\": " + isCompleteAnalyzer + "}");
			out.write("{\"isComplete\": " + true + "}");
		}catch (Exception e) {
			e.printStackTrace();
			handleRuntimeException(e, PortalUtil.getHttpServletResponse(response),LanguageUtil.get(themeDisplay.getLocale(), "edison-data-search-error"));
		}
	}
	
	@ResourceMapping(value="checkAnalyzer")
	public void checkAnalyzer(
			@RequestParam("analyzerJob") String analyzerJobJson,
			 ResourceRequest request, ResourceResponse response) throws IOException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			AnalyzerJob analyzerJob = new Gson().fromJson(analyzerJobJson, AnalyzerJob.class);
			
			User user = PortalUtil.getUser(request);
			String outText = meshAppHelper.getTimeLog(themeDisplay, analyzerJob, user,100).trim();
			
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			JsonObject obj = new JsonObject();
			obj.addProperty("out", outText);
			out.write(obj.toString());
		}catch (Exception e) {
			e.printStackTrace();
			handleRuntimeException(e, PortalUtil.getHttpServletResponse(response),LanguageUtil.get(themeDisplay.getLocale(), "edison-data-search-error"));
		}
	}
	
	
	
	protected static void handleRuntimeException(Exception ex, HttpServletResponse response, String message)
	        throws IOException{
	        log.error(message, ex);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().write(message);
			response.flushBuffer();
		}
}
