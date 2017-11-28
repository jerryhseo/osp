/**
 * Copyright (c) 2016-present EDISON, KISTI. All rights reserved.
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

package org.kisti.edison.science.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import org.kisti.edison.science.model.RequiredLibConfirm;
import org.kisti.edison.science.service.RequiredLibConfirmLocalServiceUtil;

/**
 * The extended model base implementation for the RequiredLibConfirm service. Represents a row in the &quot;EDAPP_RequiredLibConfirm&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RequiredLibConfirmImpl}.
 * </p>
 *
 * @author EDISON
 * @see RequiredLibConfirmImpl
 * @see org.kisti.edison.science.model.RequiredLibConfirm
 * @generated
 */
public abstract class RequiredLibConfirmBaseImpl
	extends RequiredLibConfirmModelImpl implements RequiredLibConfirm {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a required lib confirm model instance should use the {@link RequiredLibConfirm} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RequiredLibConfirmLocalServiceUtil.addRequiredLibConfirm(this);
		}
		else {
			RequiredLibConfirmLocalServiceUtil.updateRequiredLibConfirm(this);
		}
	}
}