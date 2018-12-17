/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package org.kisti.edison.service.impl;

import org.kisti.edison.service.base.ExecuteUserLocalServiceBaseImpl;
import org.kisti.edison.service.persistence.ExecuteUserFinderUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the execute user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.service.ExecuteUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author edison
 * @see org.kisti.edison.service.base.ExecuteUserLocalServiceBaseImpl
 * @see org.kisti.edison.service.ExecuteUserLocalServiceUtil
 */
public class ExecuteUserLocalServiceImpl extends ExecuteUserLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.service.ExecuteUserLocalServiceUtil} to access the execute user local service.
	 */
	
	public boolean updateExecuteUserStatistics(){
		
		boolean updateExecuteUserStatistics = false;
		
		try {
			if(0 < ExecuteUserFinderUtil.updateExecuteUserStatistics()){
				updateExecuteUserStatistics = true;;
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return updateExecuteUserStatistics;
	}
}