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

import org.kisti.edison.science.model.PortTypeInputdeckForm;
import org.kisti.edison.science.service.PortTypeInputdeckFormLocalServiceUtil;

/**
 * The extended model base implementation for the PortTypeInputdeckForm service. Represents a row in the &quot;EDAPP_PortTypeInputdeckForm&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PortTypeInputdeckFormImpl}.
 * </p>
 *
 * @author EDISON
 * @see PortTypeInputdeckFormImpl
 * @see org.kisti.edison.science.model.PortTypeInputdeckForm
 * @generated
 */
public abstract class PortTypeInputdeckFormBaseImpl
	extends PortTypeInputdeckFormModelImpl implements PortTypeInputdeckForm {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a port type inputdeck form model instance should use the {@link PortTypeInputdeckForm} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PortTypeInputdeckFormLocalServiceUtil.addPortTypeInputdeckForm(this);
		}
		else {
			PortTypeInputdeckFormLocalServiceUtil.updatePortTypeInputdeckForm(this);
		}
	}
}