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

import org.kisti.edison.science.model.CommonLib;
import org.kisti.edison.science.service.CommonLibLocalServiceUtil;

/**
 * The extended model base implementation for the CommonLib service. Represents a row in the &quot;EDAPP_CommonLib&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommonLibImpl}.
 * </p>
 *
 * @author EDISON
 * @see CommonLibImpl
 * @see org.kisti.edison.science.model.CommonLib
 * @generated
 */
public abstract class CommonLibBaseImpl extends CommonLibModelImpl
	implements CommonLib {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a common lib model instance should use the {@link CommonLib} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CommonLibLocalServiceUtil.addCommonLib(this);
		}
		else {
			CommonLibLocalServiceUtil.updateCommonLib(this);
		}
	}
}