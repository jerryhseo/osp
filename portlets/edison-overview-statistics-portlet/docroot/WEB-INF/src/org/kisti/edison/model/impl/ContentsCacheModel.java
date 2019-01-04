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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.kisti.edison.model.Contents;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Contents in entity cache.
 *
 * @author edison
 * @see Contents
 * @generated
 */
public class ContentsCacheModel implements CacheModel<Contents>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{createDate=");
		sb.append(createDate);
		sb.append(", cnt=");
		sb.append(cnt);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Contents toEntityModel() {
		ContentsImpl contentsImpl = new ContentsImpl();

		if (createDate == null) {
			contentsImpl.setCreateDate(StringPool.BLANK);
		}
		else {
			contentsImpl.setCreateDate(createDate);
		}

		contentsImpl.setCnt(cnt);

		contentsImpl.resetOriginalValues();

		return contentsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		createDate = objectInput.readUTF();
		cnt = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (createDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createDate);
		}

		objectOutput.writeLong(cnt);
	}

	public String createDate;
	public Long cnt;
}