package org.kisti.edison.osp.editor.blade;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.osp.model.Project;
import org.kisti.edison.osp.service.ProjectLocalServiceUtil;
import org.kisti.edison.osp.service.persistence.ProjectPK;
import org.kisti.edison.science.model.ScienceApp;
import org.kisti.edison.science.service.ScienceAppLocalServiceUtil;
import org.kisti.edison.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.kisti.osp.icecap.model.DataType;
import com.kisti.osp.icecap.model.DataTypeStructure;
import com.kisti.osp.icecap.service.DataTypeLocalServiceUtil;
import com.kisti.osp.icecap.service.DataTypeStructureLocalServiceUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Controller
@RequestMapping("VIEW")
public class BladeEditorController {
	private static Log log = LogFactory.getLog(BladeEditorController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model){
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map params = RequestUtil.getParameterMap(request);
		
		try{
			List<String[]> dataStructurAppList = new ArrayList<String[]>();;
			dataStructurAppList.add(new String[]{"KFOIL_AirFoil_Para_parin", "1.0.0", "parametric"});
			model.addAttribute("meshparametric", "null");
			
			for(String[] appList : dataStructurAppList){
				String appName = appList[0];
				String appVersion = appList[1];
				String parameterName = appList[2];
				
				ScienceApp scienceAppParam = ScienceAppLocalServiceUtil.getScienceApp(appName, appVersion);
				String paramInputPorts = ScienceAppLocalServiceUtil.getScienceAppInputPorts(scienceAppParam.getScienceAppId());
				
				long paramTypeId = 0;
				JSONObject paramJSON = (JSONObject) JSONSerializer.toJSON(paramInputPorts);
				Map paramJsonMap = paramJSON;
				Iterator paramItr = paramJsonMap.keySet().iterator();
				while(paramItr.hasNext()) {
					String key = (String) paramItr.next();
					Map paramMap = (Map)paramJsonMap.get(key);
					Map dataTypeMap = (Map) paramMap.get("dataType_");
					String dataTypeName = (String) dataTypeMap.get("name");
					String dataTypeVersion = (String) dataTypeMap.get("version");
					DataType paramDataType = DataTypeLocalServiceUtil.findDataTypeObject(dataTypeName, dataTypeVersion);
					paramTypeId = paramDataType.getTypeId();
					break;
				}
				DataTypeStructure paramStructure = DataTypeStructureLocalServiceUtil.getDataTypeStructure(paramTypeId);
				model.addAttribute(parameterName, paramStructure.getStructure());
			}
		}catch(Exception e){
			e.printStackTrace();
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "view";
	}
	
	@ResourceMapping(value="getProject")
	public void getProject(ResourceRequest request, ResourceResponse response,
			@RequestParam("simulationUuid") String simulationUuid, 
			@RequestParam("jobSeqNo") long jobSeqNo) throws IOException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String portletNamespace = themeDisplay.getPortletDisplay().getNamespace();
		ProjectPK projectPK = new ProjectPK(simulationUuid, portletNamespace, jobSeqNo);
		try{
			Project project = ProjectLocalServiceUtil.getProject(projectPK);
			
			JSONObject obj = new JSONObject();
			obj.putAll(project.getModelAttributes());
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(obj.toString());
		}catch (Exception e) {
			handleRuntimeException(e, PortalUtil.getHttpServletResponse(response), LanguageUtil.get(themeDisplay.getLocale(), "edison-data-search-error"));
		}
		
	}
	
	protected static void handleRuntimeException(Exception ex, HttpServletResponse response,String message) throws IOException {
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		response.getWriter().write(message);
		response.flushBuffer();
	}
	
}
