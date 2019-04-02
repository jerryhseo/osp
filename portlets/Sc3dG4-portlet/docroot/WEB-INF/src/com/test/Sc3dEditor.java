package com.test;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.kisti.osp.service.OSPFileLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;



/**
 * Portlet implementation class Sc3dEditor
 */
public class Sc3dEditor extends MVCPortlet {
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		OSPFileLocalServiceUtil.processOSPResourceAction(resourceRequest, resourceResponse);
		
		
	}
	
}