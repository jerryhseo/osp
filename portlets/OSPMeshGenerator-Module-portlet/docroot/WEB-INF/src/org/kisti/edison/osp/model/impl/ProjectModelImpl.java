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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.kisti.edison.osp.model.Project;
import org.kisti.edison.osp.model.ProjectModel;
import org.kisti.edison.osp.model.ProjectSoap;
import org.kisti.edison.osp.service.persistence.ProjectPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Project service. Represents a row in the &quot;EDMESH_Project&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.kisti.edison.osp.model.ProjectModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProjectImpl}.
 * </p>
 *
 * @author edison
 * @see ProjectImpl
 * @see org.kisti.edison.osp.model.Project
 * @see org.kisti.edison.osp.model.ProjectModel
 * @generated
 */
@JSON(strict = true)
public class ProjectModelImpl extends BaseModelImpl<Project>
	implements ProjectModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a project model instance should use the {@link org.kisti.edison.osp.model.Project} interface instead.
	 */
	public static final String TABLE_NAME = "EDMESH_Project";
	public static final Object[][] TABLE_COLUMNS = {
			{ "simulationUuid", Types.VARCHAR },
			{ "portletNamespace", Types.VARCHAR },
			{ "jobSeqNo", Types.BIGINT },
			{ "projectId", Types.BIGINT },
			{ "projectStructure", Types.VARCHAR },
			{ "analyzerStructure", Types.VARCHAR },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table EDMESH_Project (simulationUuid VARCHAR(75) not null,portletNamespace VARCHAR(75) not null,jobSeqNo LONG not null,projectId LONG,projectStructure TEXT null,analyzerStructure TEXT null,userId LONG,createDate DATE null,primary key (simulationUuid, portletNamespace, jobSeqNo))";
	public static final String TABLE_SQL_DROP = "drop table EDMESH_Project";
	public static final String ORDER_BY_JPQL = " ORDER BY project.id.simulationUuid ASC, project.id.portletNamespace ASC, project.id.jobSeqNo ASC";
	public static final String ORDER_BY_SQL = " ORDER BY EDMESH_Project.simulationUuid ASC, EDMESH_Project.portletNamespace ASC, EDMESH_Project.jobSeqNo ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.kisti.edison.osp.model.Project"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.kisti.edison.osp.model.Project"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.kisti.edison.osp.model.Project"),
			true);
	public static long SIMULATIONUUID_COLUMN_BITMASK = 1L;
	public static long PORTLETNAMESPACE_COLUMN_BITMASK = 2L;
	public static long JOBSEQNO_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Project toModel(ProjectSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Project model = new ProjectImpl();

		model.setSimulationUuid(soapModel.getSimulationUuid());
		model.setPortletNamespace(soapModel.getPortletNamespace());
		model.setJobSeqNo(soapModel.getJobSeqNo());
		model.setProjectId(soapModel.getProjectId());
		model.setProjectStructure(soapModel.getProjectStructure());
		model.setAnalyzerStructure(soapModel.getAnalyzerStructure());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Project> toModels(ProjectSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Project> models = new ArrayList<Project>(soapModels.length);

		for (ProjectSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.kisti.edison.osp.model.Project"));

	public ProjectModelImpl() {
	}

	@Override
	public ProjectPK getPrimaryKey() {
		return new ProjectPK(_simulationUuid, _portletNamespace, _jobSeqNo);
	}

	@Override
	public void setPrimaryKey(ProjectPK primaryKey) {
		setSimulationUuid(primaryKey.simulationUuid);
		setPortletNamespace(primaryKey.portletNamespace);
		setJobSeqNo(primaryKey.jobSeqNo);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ProjectPK(_simulationUuid, _portletNamespace, _jobSeqNo);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ProjectPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Project.class;
	}

	@Override
	public String getModelClassName() {
		return Project.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("simulationUuid", getSimulationUuid());
		attributes.put("portletNamespace", getPortletNamespace());
		attributes.put("jobSeqNo", getJobSeqNo());
		attributes.put("projectId", getProjectId());
		attributes.put("projectStructure", getProjectStructure());
		attributes.put("analyzerStructure", getAnalyzerStructure());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String simulationUuid = (String)attributes.get("simulationUuid");

		if (simulationUuid != null) {
			setSimulationUuid(simulationUuid);
		}

		String portletNamespace = (String)attributes.get("portletNamespace");

		if (portletNamespace != null) {
			setPortletNamespace(portletNamespace);
		}

		Long jobSeqNo = (Long)attributes.get("jobSeqNo");

		if (jobSeqNo != null) {
			setJobSeqNo(jobSeqNo);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		String projectStructure = (String)attributes.get("projectStructure");

		if (projectStructure != null) {
			setProjectStructure(projectStructure);
		}

		String analyzerStructure = (String)attributes.get("analyzerStructure");

		if (analyzerStructure != null) {
			setAnalyzerStructure(analyzerStructure);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@JSON
	@Override
	public String getSimulationUuid() {
		if (_simulationUuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _simulationUuid;
		}
	}

	@Override
	public void setSimulationUuid(String simulationUuid) {
		_columnBitmask |= SIMULATIONUUID_COLUMN_BITMASK;

		if (_originalSimulationUuid == null) {
			_originalSimulationUuid = _simulationUuid;
		}

		_simulationUuid = simulationUuid;
	}

	public String getOriginalSimulationUuid() {
		return GetterUtil.getString(_originalSimulationUuid);
	}

	@JSON
	@Override
	public String getPortletNamespace() {
		if (_portletNamespace == null) {
			return StringPool.BLANK;
		}
		else {
			return _portletNamespace;
		}
	}

	@Override
	public void setPortletNamespace(String portletNamespace) {
		_portletNamespace = portletNamespace;
	}

	@JSON
	@Override
	public long getJobSeqNo() {
		return _jobSeqNo;
	}

	@Override
	public void setJobSeqNo(long jobSeqNo) {
		_jobSeqNo = jobSeqNo;
	}

	@JSON
	@Override
	public long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	@JSON
	@Override
	public String getProjectStructure() {
		if (_projectStructure == null) {
			return StringPool.BLANK;
		}
		else {
			return _projectStructure;
		}
	}

	@Override
	public void setProjectStructure(String projectStructure) {
		_projectStructure = projectStructure;
	}

	@JSON
	@Override
	public String getAnalyzerStructure() {
		if (_analyzerStructure == null) {
			return StringPool.BLANK;
		}
		else {
			return _analyzerStructure;
		}
	}

	@Override
	public void setAnalyzerStructure(String analyzerStructure) {
		_analyzerStructure = analyzerStructure;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
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

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Project toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Project)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProjectImpl projectImpl = new ProjectImpl();

		projectImpl.setSimulationUuid(getSimulationUuid());
		projectImpl.setPortletNamespace(getPortletNamespace());
		projectImpl.setJobSeqNo(getJobSeqNo());
		projectImpl.setProjectId(getProjectId());
		projectImpl.setProjectStructure(getProjectStructure());
		projectImpl.setAnalyzerStructure(getAnalyzerStructure());
		projectImpl.setUserId(getUserId());
		projectImpl.setCreateDate(getCreateDate());

		projectImpl.resetOriginalValues();

		return projectImpl;
	}

	@Override
	public int compareTo(Project project) {
		ProjectPK primaryKey = project.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Project)) {
			return false;
		}

		Project project = (Project)obj;

		ProjectPK primaryKey = project.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
		ProjectModelImpl projectModelImpl = this;

		projectModelImpl._originalSimulationUuid = projectModelImpl._simulationUuid;

		projectModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Project> toCacheModel() {
		ProjectCacheModel projectCacheModel = new ProjectCacheModel();

		projectCacheModel.simulationUuid = getSimulationUuid();

		String simulationUuid = projectCacheModel.simulationUuid;

		if ((simulationUuid != null) && (simulationUuid.length() == 0)) {
			projectCacheModel.simulationUuid = null;
		}

		projectCacheModel.portletNamespace = getPortletNamespace();

		String portletNamespace = projectCacheModel.portletNamespace;

		if ((portletNamespace != null) && (portletNamespace.length() == 0)) {
			projectCacheModel.portletNamespace = null;
		}

		projectCacheModel.jobSeqNo = getJobSeqNo();

		projectCacheModel.projectId = getProjectId();

		projectCacheModel.projectStructure = getProjectStructure();

		String projectStructure = projectCacheModel.projectStructure;

		if ((projectStructure != null) && (projectStructure.length() == 0)) {
			projectCacheModel.projectStructure = null;
		}

		projectCacheModel.analyzerStructure = getAnalyzerStructure();

		String analyzerStructure = projectCacheModel.analyzerStructure;

		if ((analyzerStructure != null) && (analyzerStructure.length() == 0)) {
			projectCacheModel.analyzerStructure = null;
		}

		projectCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			projectCacheModel.createDate = createDate.getTime();
		}
		else {
			projectCacheModel.createDate = Long.MIN_VALUE;
		}

		return projectCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{simulationUuid=");
		sb.append(getSimulationUuid());
		sb.append(", portletNamespace=");
		sb.append(getPortletNamespace());
		sb.append(", jobSeqNo=");
		sb.append(getJobSeqNo());
		sb.append(", projectId=");
		sb.append(getProjectId());
		sb.append(", projectStructure=");
		sb.append(getProjectStructure());
		sb.append(", analyzerStructure=");
		sb.append(getAnalyzerStructure());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.osp.model.Project");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>simulationUuid</column-name><column-value><![CDATA[");
		sb.append(getSimulationUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletNamespace</column-name><column-value><![CDATA[");
		sb.append(getPortletNamespace());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobSeqNo</column-name><column-value><![CDATA[");
		sb.append(getJobSeqNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectStructure</column-name><column-value><![CDATA[");
		sb.append(getProjectStructure());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>analyzerStructure</column-name><column-value><![CDATA[");
		sb.append(getAnalyzerStructure());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Project.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Project.class
		};
	private String _simulationUuid;
	private String _originalSimulationUuid;
	private String _portletNamespace;
	private long _jobSeqNo;
	private long _projectId;
	private String _projectStructure;
	private String _analyzerStructure;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private long _columnBitmask;
	private Project _escapedModel;
}