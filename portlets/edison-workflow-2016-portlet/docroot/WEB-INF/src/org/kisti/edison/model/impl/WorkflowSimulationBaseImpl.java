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

import org.kisti.edison.model.WorkflowSimulation;
import org.kisti.edison.service.WorkflowSimulationLocalServiceUtil;

/**
 * The extended model base implementation for the WorkflowSimulation service. Represents a row in the &quot;EDWF_WorkflowSimulation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WorkflowSimulationImpl}.
 * </p>
 *
 * @author EDISON
 * @see WorkflowSimulationImpl
 * @see org.kisti.edison.model.WorkflowSimulation
 * @generated
 */
public abstract class WorkflowSimulationBaseImpl
	extends WorkflowSimulationModelImpl implements WorkflowSimulation {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a workflow simulation model instance should use the {@link WorkflowSimulation} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			WorkflowSimulationLocalServiceUtil.addWorkflowSimulation(this);
		}
		else {
			WorkflowSimulationLocalServiceUtil.updateWorkflowSimulation(this);
		}
	}
}