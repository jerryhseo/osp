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

package com.kisti.osp.icecap.service.impl;

import java.util.Date;
import java.util.List;

import com.kisti.osp.icecap.model.DataCollection;
import com.kisti.osp.icecap.model.DataEntry;
import com.kisti.osp.icecap.model.DataType;
import com.kisti.osp.icecap.service.base.DataEntryServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the data entry remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kisti.osp.icecap.service.DataEntryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Young-K. Suh and Jerry H. Seo
 * @see com.kisti.osp.icecap.service.base.DataEntryServiceBaseImpl
 * @see com.kisti.osp.icecap.service.DataEntryServiceUtil
 */
public class DataEntryServiceImpl extends DataEntryServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.kisti.osp.icecap.service.DataEntryServiceUtil} to access the data entry remote service.
	 */
}