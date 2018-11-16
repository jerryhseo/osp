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

package org.kisti.edison.osp.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import org.kisti.edison.osp.service.persistence.ProjectPK;

import java.io.Serializable;

/**
 * The base model interface for the Project service. Represents a row in the &quot;EDMESH_Project&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.kisti.edison.osp.model.impl.ProjectModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.kisti.edison.osp.model.impl.ProjectImpl}.
 * </p>
 *
 * @author edison
 * @see Project
 * @see org.kisti.edison.osp.model.impl.ProjectImpl
 * @see org.kisti.edison.osp.model.impl.ProjectModelImpl
 * @generated
 */
public interface ProjectModel extends BaseModel<Project> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a project model instance should use the {@link Project} interface instead.
	 */

	/**
	 * Returns the primary key of this project.
	 *
	 * @return the primary key of this project
	 */
	public ProjectPK getPrimaryKey();

	/**
	 * Sets the primary key of this project.
	 *
	 * @param primaryKey the primary key of this project
	 */
	public void setPrimaryKey(ProjectPK primaryKey);

	/**
	 * Returns the simulation uuid of this project.
	 *
	 * @return the simulation uuid of this project
	 */
	@AutoEscape
	public String getSimulationUuid();

	/**
	 * Sets the simulation uuid of this project.
	 *
	 * @param simulationUuid the simulation uuid of this project
	 */
	public void setSimulationUuid(String simulationUuid);

	/**
	 * Returns the portlet namespace of this project.
	 *
	 * @return the portlet namespace of this project
	 */
	@AutoEscape
	public String getPortletNamespace();

	/**
	 * Sets the portlet namespace of this project.
	 *
	 * @param portletNamespace the portlet namespace of this project
	 */
	public void setPortletNamespace(String portletNamespace);

	/**
	 * Returns the job seq no of this project.
	 *
	 * @return the job seq no of this project
	 */
	public long getJobSeqNo();

	/**
	 * Sets the job seq no of this project.
	 *
	 * @param jobSeqNo the job seq no of this project
	 */
	public void setJobSeqNo(long jobSeqNo);

	/**
	 * Returns the project ID of this project.
	 *
	 * @return the project ID of this project
	 */
	public long getProjectId();

	/**
	 * Sets the project ID of this project.
	 *
	 * @param projectId the project ID of this project
	 */
	public void setProjectId(long projectId);

	/**
	 * Returns the project structure of this project.
	 *
	 * @return the project structure of this project
	 */
	@AutoEscape
	public String getProjectStructure();

	/**
	 * Sets the project structure of this project.
	 *
	 * @param projectStructure the project structure of this project
	 */
	public void setProjectStructure(String projectStructure);

	/**
	 * Returns the analyzer structure of this project.
	 *
	 * @return the analyzer structure of this project
	 */
	@AutoEscape
	public String getAnalyzerStructure();

	/**
	 * Sets the analyzer structure of this project.
	 *
	 * @param analyzerStructure the analyzer structure of this project
	 */
	public void setAnalyzerStructure(String analyzerStructure);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(org.kisti.edison.osp.model.Project project);

	@Override
	public int hashCode();

	@Override
	public CacheModel<org.kisti.edison.osp.model.Project> toCacheModel();

	@Override
	public org.kisti.edison.osp.model.Project toEscapedModel();

	@Override
	public org.kisti.edison.osp.model.Project toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}