package kr.re.edison.hook.saml;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

public class SAMLLogoutAction extends BaseStrutsAction {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		boolean isSAML = (Boolean) session.getAttribute("isSAMLLogin");
		session.invalidate();
		String logoutUrl = "/";
		if(isSAML){
		    logoutUrl = Util.getPropertyString(companyId, Constants.LOGOUT_URL);
		}else
		response.sendRedirect(logoutUrl);
		return null;
	}
}
