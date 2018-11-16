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

package org.kisti.edison.osp.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import org.kisti.edison.osp.model.Execute;
import org.kisti.edison.osp.service.ExecuteLocalServiceUtil;

/**
 * The extended model base implementation for the Execute service. Represents a row in the &quot;EDMESH_Execute&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ExecuteImpl}.
 * </p>
 *
 * @author edison
 * @see ExecuteImpl
 * @see org.kisti.edison.osp.model.Execute
 * @generated
 */
public abstract class ExecuteBaseImpl extends ExecuteModelImpl
	implements Execute {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a execute model instance should use the {@link Execute} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ExecuteLocalServiceUtil.addExecute(this);
		}
		else {
			ExecuteLocalServiceUtil.updateExecute(this);
		}
	}
}