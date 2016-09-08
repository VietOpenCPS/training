/**
 * OpenCPS is the open source Core Public Services software
 * Copyright (C) 2016-present OpenCPS community
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 */

package org.opencps.feedback.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.opencps.feedback.model.FeedBack;
import org.opencps.feedback.service.FeedBackLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


/**
 * @author khoavd
 *
 */
public class FeedBackAdmin extends MVCPortlet	{

	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#render(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	
	/* (non-Javadoc)
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#include(java.lang.String, javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	protected void include(
	    String path, RenderRequest renderRequest, RenderResponse renderResponse)
	    throws IOException, PortletException {
		if(isIncorrectId()){
			path = "/html/portlets/feedback_admin/error.jsp";
		}
	    // TODO Auto-generated method stub
	    super.include(path, renderRequest, renderResponse);
	}
	
	@Override
	public void render(RenderRequest request, RenderResponse response)
	    throws PortletException, IOException {
		
		setIncorrectId(false);
		
		long feedbackId = ParamUtil.getLong(request, "feedbackId");
		
		if(feedbackId > 0){
			try {
	            FeedBack feedBack = FeedBackLocalServiceUtil.getFeedBack(feedbackId);
	            request.setAttribute("FeedBackAttribute", feedBack);
            }
            catch (Exception e) {
	            e.printStackTrace();
	            setIncorrectId(true);
            }
		}
		
	    // TODO Auto-generated method stub
	    super.render(request, response);
	}
	
	public void deleteFeedBack(ActionRequest actionRequest, ActionResponse actionResponse){
		
		long feedbackId = ParamUtil.getLong(actionRequest, "feedbackId");
		
		try {
	        FeedBackLocalServiceUtil.deleteFeedBack(feedbackId);
        }
        catch (PortalException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
        catch (SystemException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
	}
	
	private boolean incorrectId;

	
    /**
     * @return the incorrectId
     */
    public boolean isIncorrectId() {
    
    	return incorrectId;
    }

	
    /**
     * @param incorrectId the incorrectId to set
     */
    public void setIncorrectId(boolean incorrectId) {
    
    	this.incorrectId = incorrectId;
    }
	
}
