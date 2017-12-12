package com.kisti.osp.analyzer.portlet.paraview;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import com.kisti.osp.service.FileManagementLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class OSPParaViewPortlet
 */
public class OSPParaViewPortlet extends MVCPortlet {
	private static final String  launcherURL = "https://www.edison.re.kr/paraview";
	private static Log _log = LogFactoryUtil.getLog(OSPParaViewPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
	        throws IOException, PortletException {

		renderRequest.setAttribute("launcherURL", launcherURL);
		super.doView(renderRequest, renderResponse);
	}
	
    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
        throws IOException, PortletException{

        String targetPath = ParamUtil.getString(resourceRequest, "targetPath");
        String command = ParamUtil.getString(resourceRequest, "command");
        String action = ParamUtil.getString(resourceRequest, "action", "output");
        _log.info("command: "+command);
        _log.info("action: "+action);
        _log.info("targetPath: "+targetPath);
        
        boolean isJobResult = action.equalsIgnoreCase("input") ? false : true;
        
        if(command.equalsIgnoreCase("GET_ABSOLUTE_PATH")){
        	String absolutePath = "";
            try{
                absolutePath = FileManagementLocalServiceUtil.getAbolutePath(resourceRequest, targetPath, isJobResult);
            }catch (PortalException | SystemException e){
                _log.error("GET_ABSOLUTE_PATH: " + targetPath);
                throw new PortletException();
            }
            
            HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(resourceResponse);
            ServletResponseUtil.write(httpResponse, absolutePath);
        }else{
            _log.info("There are no command option.");
        }
        
    }
}