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

package org.kisti.edison.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import org.kisti.edison.model.Contents;
import org.kisti.edison.service.ContentsLocalServiceUtil;

/**
 * The extended model base implementation for the Contents service. Represents a row in the &quot;EDOV_Contents&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ContentsImpl}.
 * </p>
 *
 * @author edison
 * @see ContentsImpl
 * @see org.kisti.edison.model.Contents
 * @generated
 */
public abstract class ContentsBaseImpl extends ContentsModelImpl
	implements Contents {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a contents model instance should use the {@link Contents} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ContentsLocalServiceUtil.addContents(this);
		}
		else {
			ContentsLocalServiceUtil.updateContents(this);
		}
	}
}