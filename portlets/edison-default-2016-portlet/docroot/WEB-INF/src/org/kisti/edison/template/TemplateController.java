package org.kisti.edison.template;

import java.text.ParseException;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@Controller
@RequestMapping("VIEW")
public class TemplateController {
	protected static Log  log = LogFactoryUtil.getLog(TemplateController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model) throws ParseException {
		return "template/view";
	}
}
