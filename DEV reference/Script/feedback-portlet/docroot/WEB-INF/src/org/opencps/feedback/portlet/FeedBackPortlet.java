
package org.opencps.feedback.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.opencps.feedback.model.FeedBack;
import org.opencps.feedback.service.FeedBackLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class FeedBackPortlet
 */
public class FeedBackPortlet extends MVCPortlet {

	public void addFeedback(
	    ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {

		System.out.println("##############################: Da Nhan FeedBack");

		String fullName = ParamUtil.getString(actionRequest, "fullName");

		String email = ParamUtil.getString(actionRequest, "email");

		String feedBackContent = ParamUtil.getString(actionRequest, "feedBack");
		
		List<String> error = new ArrayList<String>();
		
		boolean isValid = vadidator(fullName, email, error);
		
		try {
			ServiceContext serviceContext =
			    ServiceContextFactory.getInstance(actionRequest);
			
			FeedBack feedBack =
			    FeedBackLocalServiceUtil.addFeedBack(
			        fullName, email, feedBackContent, serviceContext);

		}
		catch (Exception e) {
			_log.error(e);
		}

		actionResponse.setRenderParameter("mvcPath", "/html/portlets/feedback/success.jsp");
	}
	
	private boolean vadidator(String fullName, String email, List<String> errors) {
		boolean isValida = true;
		
		if (Validator.isNull(fullName)) {
			isValida = false;
			errors.add("loi-eemial");
		}
		
		if (Validator.isEmailAddress(email)) {
			isValida = false;
		}
		return isValida;
	}
	
	private Log _log = LogFactoryUtil.getLog(FeedBackPortlet.class.getName());
}
