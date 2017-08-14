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

package com.kisti.osp.icecap.model.impl;

import com.kisti.osp.icecap.model.DataEntry;
import com.kisti.osp.icecap.service.DataEntryLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the DataEntry service. Represents a row in the &quot;icecap_DataEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DataEntryImpl}.
 * </p>
 *
 * @author Young-K. Suh and Jerry H. Seo
 * @see DataEntryImpl
 * @see com.kisti.osp.icecap.model.DataEntry
 * @generated
 */
public abstract class DataEntryBaseImpl extends DataEntryModelImpl
	implements DataEntry {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a data entry model instance should use the {@link DataEntry} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DataEntryLocalServiceUtil.addDataEntry(this);
		}
		else {
			DataEntryLocalServiceUtil.updateDataEntry(this);
		}
	}
}