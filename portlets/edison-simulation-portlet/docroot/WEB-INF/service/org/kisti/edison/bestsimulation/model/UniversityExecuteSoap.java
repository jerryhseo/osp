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

package org.kisti.edison.bestsimulation.model;

import org.kisti.edison.bestsimulation.service.persistence.UniversityExecutePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.bestsimulation.service.http.UniversityExecuteServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.bestsimulation.service.http.UniversityExecuteServiceSoap
 * @generated
 */
public class UniversityExecuteSoap implements Serializable {
	public static UniversityExecuteSoap toSoapModel(UniversityExecute model) {
		UniversityExecuteSoap soapModel = new UniversityExecuteSoap();

		soapModel.setExecuteDate(model.getExecuteDate());
		soapModel.setUniversityField(model.getUniversityField());
		soapModel.setUserCnt(model.getUserCnt());
		soapModel.setAvgExeTime(model.getAvgExeTime());
		soapModel.setExeCnt(model.getExeCnt());
		soapModel.setCpuTime(model.getCpuTime());

		return soapModel;
	}

	public static UniversityExecuteSoap[] toSoapModels(
		UniversityExecute[] models) {
		UniversityExecuteSoap[] soapModels = new UniversityExecuteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UniversityExecuteSoap[][] toSoapModels(
		UniversityExecute[][] models) {
		UniversityExecuteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UniversityExecuteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UniversityExecuteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UniversityExecuteSoap[] toSoapModels(
		List<UniversityExecute> models) {
		List<UniversityExecuteSoap> soapModels = new ArrayList<UniversityExecuteSoap>(models.size());

		for (UniversityExecute model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UniversityExecuteSoap[soapModels.size()]);
	}

	public UniversityExecuteSoap() {
	}

	public UniversityExecutePK getPrimaryKey() {
		return new UniversityExecutePK(_executeDate, _universityField);
	}

	public void setPrimaryKey(UniversityExecutePK pk) {
		setExecuteDate(pk.executeDate);
		setUniversityField(pk.universityField);
	}

	public String getExecuteDate() {
		return _executeDate;
	}

	public void setExecuteDate(String executeDate) {
		_executeDate = executeDate;
	}

	public long getUniversityField() {
		return _universityField;
	}

	public void setUniversityField(long universityField) {
		_universityField = universityField;
	}

	public long getUserCnt() {
		return _userCnt;
	}

	public void setUserCnt(long userCnt) {
		_userCnt = userCnt;
	}

	public long getAvgExeTime() {
		return _avgExeTime;
	}

	public void setAvgExeTime(long avgExeTime) {
		_avgExeTime = avgExeTime;
	}

	public long getExeCnt() {
		return _exeCnt;
	}

	public void setExeCnt(long exeCnt) {
		_exeCnt = exeCnt;
	}

	public long getCpuTime() {
		return _cpuTime;
	}

	public void setCpuTime(long cpuTime) {
		_cpuTime = cpuTime;
	}

	private String _executeDate;
	private long _universityField;
	private long _userCnt;
	private long _avgExeTime;
	private long _exeCnt;
	private long _cpuTime;
}