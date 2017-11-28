/**
 * Copyright (c) 2016-present EDISON, KISTI. All rights reserved.
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

package org.kisti.edison.bestsimulation.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import org.kisti.edison.bestsimulation.model.SimulationJob;
import org.kisti.edison.bestsimulation.service.SimulationJobLocalServiceUtil;

/**
 * The extended model base implementation for the SimulationJob service. Represents a row in the &quot;EDSIM_SimulationJob&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SimulationJobImpl}.
 * </p>
 *
 * @author EDISON
 * @see SimulationJobImpl
 * @see org.kisti.edison.bestsimulation.model.SimulationJob
 * @generated
 */
public abstract class SimulationJobBaseImpl extends SimulationJobModelImpl
	implements SimulationJob {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a simulation job model instance should use the {@link SimulationJob} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SimulationJobLocalServiceUtil.addSimulationJob(this);
		}
		else {
			SimulationJobLocalServiceUtil.updateSimulationJob(this);
		}
	}
}