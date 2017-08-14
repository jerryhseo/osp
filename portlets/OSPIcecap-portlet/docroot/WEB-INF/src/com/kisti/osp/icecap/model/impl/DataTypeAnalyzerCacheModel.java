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

import com.kisti.osp.icecap.model.DataTypeAnalyzer;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DataTypeAnalyzer in entity cache.
 *
 * @author Young-K. Suh and Jerry H. Seo
 * @see DataTypeAnalyzer
 * @generated
 */
public class DataTypeAnalyzerCacheModel implements CacheModel<DataTypeAnalyzer>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{typeId=");
		sb.append(typeId);
		sb.append(", analyzerId=");
		sb.append(analyzerId);
		sb.append(", isDefault=");
		sb.append(isDefault);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataTypeAnalyzer toEntityModel() {
		DataTypeAnalyzerImpl dataTypeAnalyzerImpl = new DataTypeAnalyzerImpl();

		dataTypeAnalyzerImpl.setTypeId(typeId);
		dataTypeAnalyzerImpl.setAnalyzerId(analyzerId);
		dataTypeAnalyzerImpl.setIsDefault(isDefault);

		dataTypeAnalyzerImpl.resetOriginalValues();

		return dataTypeAnalyzerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		typeId = objectInput.readLong();
		analyzerId = objectInput.readLong();
		isDefault = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(typeId);
		objectOutput.writeLong(analyzerId);
		objectOutput.writeBoolean(isDefault);
	}

	public long typeId;
	public long analyzerId;
	public boolean isDefault;
}