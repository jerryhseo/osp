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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.kisti.edison.model.WorkflowSimulationJob;
import org.kisti.edison.model.WorkflowSimulationJobModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the WorkflowSimulationJob service. Represents a row in the &quot;EDWF_WorkflowSimulationJob&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.kisti.edison.model.WorkflowSimulationJobModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WorkflowSimulationJobImpl}.
 * </p>
 *
 * @author EDISON
 * @see WorkflowSimulationJobImpl
 * @see org.kisti.edison.model.WorkflowSimulationJob
 * @see org.kisti.edison.model.WorkflowSimulationJobModel
 * @generated
 */
public class WorkflowSimulationJobModelImpl extends BaseModelImpl<WorkflowSimulationJob>
	implements WorkflowSimulationJobModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a workflow simulation job model instance should use the {@link org.kisti.edison.model.WorkflowSimulationJob} interface instead.
	 */
	public static final String TABLE_NAME = "EDWF_WorkflowSimulationJob";
	public static final Object[][] TABLE_COLUMNS = {
			{ "simulationJobId", Types.BIGINT },
			{ "simulationId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "title", Types.VARCHAR },
			{ "status", Types.VARCHAR },
			{ "statusResponse", Types.VARCHAR },
			{ "startTime", Types.TIMESTAMP },
			{ "endTime", Types.TIMESTAMP },
			{ "workflowId", Types.BIGINT },
			{ "workflowUUID", Types.VARCHAR },
			{ "reuseWorkflowUUID", Types.VARCHAR },
			{ "screenLogic", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table EDWF_WorkflowSimulationJob (simulationJobId LONG not null primary key,simulationId LONG,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,title VARCHAR(75) null,status VARCHAR(75) null,statusResponse VARCHAR(75) null,startTime DATE null,endTime DATE null,workflowId LONG,workflowUUID VARCHAR(75) null,reuseWorkflowUUID VARCHAR(75) null,screenLogic VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table EDWF_WorkflowSimulationJob";
	public static final String ORDER_BY_JPQL = " ORDER BY workflowSimulationJob.simulationJobId DESC";
	public static final String ORDER_BY_SQL = " ORDER BY EDWF_WorkflowSimulationJob.simulationJobId DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.kisti.edison.model.WorkflowSimulationJob"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.kisti.edison.model.WorkflowSimulationJob"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.kisti.edison.model.WorkflowSimulationJob"),
			true);
	public static long SIMULATIONID_COLUMN_BITMASK = 1L;
	public static long TITLE_COLUMN_BITMASK = 2L;
	public static long USERID_COLUMN_BITMASK = 4L;
	public static long SIMULATIONJOBID_COLUMN_BITMASK = 8L;
	public static final String MAPPING_TABLE_EDWF_WORKFLOWSIMULATION_WORKFLOWSIMULATIONJOB_NAME =
		"EDWF_WorkflowSimulation_WorkflowSimulationJob";
	public static final Object[][] MAPPING_TABLE_EDWF_WORKFLOWSIMULATION_WORKFLOWSIMULATIONJOB_COLUMNS =
		{
			{ "simulationId", Types.BIGINT },
			{ "simulationJobId", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_EDWF_WORKFLOWSIMULATION_WORKFLOWSIMULATIONJOB_SQL_CREATE =
		"create table EDWF_WorkflowSimulation_WorkflowSimulationJob (simulationId LONG not null,simulationJobId LONG not null,primary key (simulationId, simulationJobId))";
	public static final boolean FINDER_CACHE_ENABLED_EDWF_WORKFLOWSIMULATION_WORKFLOWSIMULATIONJOB =
		GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.EDWF_WorkflowSimulation_WorkflowSimulationJob"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.kisti.edison.model.WorkflowSimulationJob"));

	public WorkflowSimulationJobModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _simulationJobId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSimulationJobId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _simulationJobId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return WorkflowSimulationJob.class;
	}

	@Override
	public String getModelClassName() {
		return WorkflowSimulationJob.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("simulationJobId", getSimulationJobId());
		attributes.put("simulationId", getSimulationId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("status", getStatus());
		attributes.put("statusResponse", getStatusResponse());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("workflowId", getWorkflowId());
		attributes.put("workflowUUID", getWorkflowUUID());
		attributes.put("reuseWorkflowUUID", getReuseWorkflowUUID());
		attributes.put("screenLogic", getScreenLogic());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long simulationJobId = (Long)attributes.get("simulationJobId");

		if (simulationJobId != null) {
			setSimulationJobId(simulationJobId);
		}

		Long simulationId = (Long)attributes.get("simulationId");

		if (simulationId != null) {
			setSimulationId(simulationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String statusResponse = (String)attributes.get("statusResponse");

		if (statusResponse != null) {
			setStatusResponse(statusResponse);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Long workflowId = (Long)attributes.get("workflowId");

		if (workflowId != null) {
			setWorkflowId(workflowId);
		}

		String workflowUUID = (String)attributes.get("workflowUUID");

		if (workflowUUID != null) {
			setWorkflowUUID(workflowUUID);
		}

		String reuseWorkflowUUID = (String)attributes.get("reuseWorkflowUUID");

		if (reuseWorkflowUUID != null) {
			setReuseWorkflowUUID(reuseWorkflowUUID);
		}

		String screenLogic = (String)attributes.get("screenLogic");

		if (screenLogic != null) {
			setScreenLogic(screenLogic);
		}
	}

	@Override
	public long getSimulationJobId() {
		return _simulationJobId;
	}

	@Override
	public void setSimulationJobId(long simulationJobId) {
		_columnBitmask = -1L;

		_simulationJobId = simulationJobId;
	}

	@Override
	public long getSimulationId() {
		return _simulationId;
	}

	@Override
	public void setSimulationId(long simulationId) {
		_columnBitmask |= SIMULATIONID_COLUMN_BITMASK;

		if (!_setOriginalSimulationId) {
			_setOriginalSimulationId = true;

			_originalSimulationId = _simulationId;
		}

		_simulationId = simulationId;
	}

	public long getOriginalSimulationId() {
		return _originalSimulationId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_columnBitmask |= TITLE_COLUMN_BITMASK;

		if (_originalTitle == null) {
			_originalTitle = _title;
		}

		_title = title;
	}

	public String getOriginalTitle() {
		return GetterUtil.getString(_originalTitle);
	}

	@Override
	public String getStatus() {
		if (_status == null) {
			return StringPool.BLANK;
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		_status = status;
	}

	@Override
	public String getStatusResponse() {
		if (_statusResponse == null) {
			return StringPool.BLANK;
		}
		else {
			return _statusResponse;
		}
	}

	@Override
	public void setStatusResponse(String statusResponse) {
		_statusResponse = statusResponse;
	}

	@Override
	public Date getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	@Override
	public Date getEndTime() {
		return _endTime;
	}

	@Override
	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	@Override
	public long getWorkflowId() {
		return _workflowId;
	}

	@Override
	public void setWorkflowId(long workflowId) {
		_workflowId = workflowId;
	}

	@Override
	public String getWorkflowUUID() {
		if (_workflowUUID == null) {
			return StringPool.BLANK;
		}
		else {
			return _workflowUUID;
		}
	}

	@Override
	public void setWorkflowUUID(String workflowUUID) {
		_workflowUUID = workflowUUID;
	}

	@Override
	public String getReuseWorkflowUUID() {
		if (_reuseWorkflowUUID == null) {
			return StringPool.BLANK;
		}
		else {
			return _reuseWorkflowUUID;
		}
	}

	@Override
	public void setReuseWorkflowUUID(String reuseWorkflowUUID) {
		_reuseWorkflowUUID = reuseWorkflowUUID;
	}

	@Override
	public String getScreenLogic() {
		if (_screenLogic == null) {
			return StringPool.BLANK;
		}
		else {
			return _screenLogic;
		}
	}

	@Override
	public void setScreenLogic(String screenLogic) {
		_screenLogic = screenLogic;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			WorkflowSimulationJob.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public WorkflowSimulationJob toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (WorkflowSimulationJob)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		WorkflowSimulationJobImpl workflowSimulationJobImpl = new WorkflowSimulationJobImpl();

		workflowSimulationJobImpl.setSimulationJobId(getSimulationJobId());
		workflowSimulationJobImpl.setSimulationId(getSimulationId());
		workflowSimulationJobImpl.setGroupId(getGroupId());
		workflowSimulationJobImpl.setUserId(getUserId());
		workflowSimulationJobImpl.setCreateDate(getCreateDate());
		workflowSimulationJobImpl.setModifiedDate(getModifiedDate());
		workflowSimulationJobImpl.setTitle(getTitle());
		workflowSimulationJobImpl.setStatus(getStatus());
		workflowSimulationJobImpl.setStatusResponse(getStatusResponse());
		workflowSimulationJobImpl.setStartTime(getStartTime());
		workflowSimulationJobImpl.setEndTime(getEndTime());
		workflowSimulationJobImpl.setWorkflowId(getWorkflowId());
		workflowSimulationJobImpl.setWorkflowUUID(getWorkflowUUID());
		workflowSimulationJobImpl.setReuseWorkflowUUID(getReuseWorkflowUUID());
		workflowSimulationJobImpl.setScreenLogic(getScreenLogic());

		workflowSimulationJobImpl.resetOriginalValues();

		return workflowSimulationJobImpl;
	}

	@Override
	public int compareTo(WorkflowSimulationJob workflowSimulationJob) {
		int value = 0;

		if (getSimulationJobId() < workflowSimulationJob.getSimulationJobId()) {
			value = -1;
		}
		else if (getSimulationJobId() > workflowSimulationJob.getSimulationJobId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof WorkflowSimulationJob)) {
			return false;
		}

		WorkflowSimulationJob workflowSimulationJob = (WorkflowSimulationJob)obj;

		long primaryKey = workflowSimulationJob.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		WorkflowSimulationJobModelImpl workflowSimulationJobModelImpl = this;

		workflowSimulationJobModelImpl._originalSimulationId = workflowSimulationJobModelImpl._simulationId;

		workflowSimulationJobModelImpl._setOriginalSimulationId = false;

		workflowSimulationJobModelImpl._originalUserId = workflowSimulationJobModelImpl._userId;

		workflowSimulationJobModelImpl._setOriginalUserId = false;

		workflowSimulationJobModelImpl._originalTitle = workflowSimulationJobModelImpl._title;

		workflowSimulationJobModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<WorkflowSimulationJob> toCacheModel() {
		WorkflowSimulationJobCacheModel workflowSimulationJobCacheModel = new WorkflowSimulationJobCacheModel();

		workflowSimulationJobCacheModel.simulationJobId = getSimulationJobId();

		workflowSimulationJobCacheModel.simulationId = getSimulationId();

		workflowSimulationJobCacheModel.groupId = getGroupId();

		workflowSimulationJobCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			workflowSimulationJobCacheModel.createDate = createDate.getTime();
		}
		else {
			workflowSimulationJobCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			workflowSimulationJobCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			workflowSimulationJobCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		workflowSimulationJobCacheModel.title = getTitle();

		String title = workflowSimulationJobCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			workflowSimulationJobCacheModel.title = null;
		}

		workflowSimulationJobCacheModel.status = getStatus();

		String status = workflowSimulationJobCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			workflowSimulationJobCacheModel.status = null;
		}

		workflowSimulationJobCacheModel.statusResponse = getStatusResponse();

		String statusResponse = workflowSimulationJobCacheModel.statusResponse;

		if ((statusResponse != null) && (statusResponse.length() == 0)) {
			workflowSimulationJobCacheModel.statusResponse = null;
		}

		Date startTime = getStartTime();

		if (startTime != null) {
			workflowSimulationJobCacheModel.startTime = startTime.getTime();
		}
		else {
			workflowSimulationJobCacheModel.startTime = Long.MIN_VALUE;
		}

		Date endTime = getEndTime();

		if (endTime != null) {
			workflowSimulationJobCacheModel.endTime = endTime.getTime();
		}
		else {
			workflowSimulationJobCacheModel.endTime = Long.MIN_VALUE;
		}

		workflowSimulationJobCacheModel.workflowId = getWorkflowId();

		workflowSimulationJobCacheModel.workflowUUID = getWorkflowUUID();

		String workflowUUID = workflowSimulationJobCacheModel.workflowUUID;

		if ((workflowUUID != null) && (workflowUUID.length() == 0)) {
			workflowSimulationJobCacheModel.workflowUUID = null;
		}

		workflowSimulationJobCacheModel.reuseWorkflowUUID = getReuseWorkflowUUID();

		String reuseWorkflowUUID = workflowSimulationJobCacheModel.reuseWorkflowUUID;

		if ((reuseWorkflowUUID != null) && (reuseWorkflowUUID.length() == 0)) {
			workflowSimulationJobCacheModel.reuseWorkflowUUID = null;
		}

		workflowSimulationJobCacheModel.screenLogic = getScreenLogic();

		String screenLogic = workflowSimulationJobCacheModel.screenLogic;

		if ((screenLogic != null) && (screenLogic.length() == 0)) {
			workflowSimulationJobCacheModel.screenLogic = null;
		}

		return workflowSimulationJobCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{simulationJobId=");
		sb.append(getSimulationJobId());
		sb.append(", simulationId=");
		sb.append(getSimulationId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusResponse=");
		sb.append(getStatusResponse());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", workflowId=");
		sb.append(getWorkflowId());
		sb.append(", workflowUUID=");
		sb.append(getWorkflowUUID());
		sb.append(", reuseWorkflowUUID=");
		sb.append(getReuseWorkflowUUID());
		sb.append(", screenLogic=");
		sb.append(getScreenLogic());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.model.WorkflowSimulationJob");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>simulationJobId</column-name><column-value><![CDATA[");
		sb.append(getSimulationJobId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>simulationId</column-name><column-value><![CDATA[");
		sb.append(getSimulationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusResponse</column-name><column-value><![CDATA[");
		sb.append(getStatusResponse());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workflowId</column-name><column-value><![CDATA[");
		sb.append(getWorkflowId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workflowUUID</column-name><column-value><![CDATA[");
		sb.append(getWorkflowUUID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reuseWorkflowUUID</column-name><column-value><![CDATA[");
		sb.append(getReuseWorkflowUUID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>screenLogic</column-name><column-value><![CDATA[");
		sb.append(getScreenLogic());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = WorkflowSimulationJob.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			WorkflowSimulationJob.class
		};
	private long _simulationJobId;
	private long _simulationId;
	private long _originalSimulationId;
	private boolean _setOriginalSimulationId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _originalTitle;
	private String _status;
	private String _statusResponse;
	private Date _startTime;
	private Date _endTime;
	private long _workflowId;
	private String _workflowUUID;
	private String _reuseWorkflowUUID;
	private String _screenLogic;
	private long _columnBitmask;
	private WorkflowSimulationJob _escapedModel;
}