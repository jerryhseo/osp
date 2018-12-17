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

package org.kisti.edison.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.kisti.edison.service.ClpSerializer;
import org.kisti.edison.service.ExecuteUserLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author edison
 */
public class ExecuteUserClp extends BaseModelImpl<ExecuteUser>
	implements ExecuteUser {
	public ExecuteUserClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ExecuteUser.class;
	}

	@Override
	public String getModelClassName() {
		return ExecuteUser.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _createDate;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setCreateDate(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _createDate;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("createDate", getCreateDate());
		attributes.put("cnt", getCnt());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String createDate = (String)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long cnt = (Long)attributes.get("cnt");

		if (cnt != null) {
			setCnt(cnt);
		}
	}

	@Override
	public String getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(String createDate) {
		_createDate = createDate;

		if (_executeUserRemoteModel != null) {
			try {
				Class<?> clazz = _executeUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", String.class);

				method.invoke(_executeUserRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Long getCnt() {
		return _cnt;
	}

	@Override
	public void setCnt(Long cnt) {
		_cnt = cnt;

		if (_executeUserRemoteModel != null) {
			try {
				Class<?> clazz = _executeUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCnt", Long.class);

				method.invoke(_executeUserRemoteModel, cnt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getExecuteUserRemoteModel() {
		return _executeUserRemoteModel;
	}

	public void setExecuteUserRemoteModel(BaseModel<?> executeUserRemoteModel) {
		_executeUserRemoteModel = executeUserRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _executeUserRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_executeUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ExecuteUserLocalServiceUtil.addExecuteUser(this);
		}
		else {
			ExecuteUserLocalServiceUtil.updateExecuteUser(this);
		}
	}

	@Override
	public ExecuteUser toEscapedModel() {
		return (ExecuteUser)ProxyUtil.newProxyInstance(ExecuteUser.class.getClassLoader(),
			new Class[] { ExecuteUser.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ExecuteUserClp clone = new ExecuteUserClp();

		clone.setCreateDate(getCreateDate());
		clone.setCnt(getCnt());

		return clone;
	}

	@Override
	public int compareTo(ExecuteUser executeUser) {
		int value = 0;

		value = getCreateDate().compareTo(executeUser.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExecuteUserClp)) {
			return false;
		}

		ExecuteUserClp executeUser = (ExecuteUserClp)obj;

		String primaryKey = executeUser.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{createDate=");
		sb.append(getCreateDate());
		sb.append(", cnt=");
		sb.append(getCnt());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.model.ExecuteUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cnt</column-name><column-value><![CDATA[");
		sb.append(getCnt());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _createDate;
	private Long _cnt;
	private BaseModel<?> _executeUserRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.service.ClpSerializer.class;
}