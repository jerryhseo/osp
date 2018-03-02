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

package kisti.edison.challenge.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import kisti.edison.challenge.model.ChildChallenge;
import kisti.edison.challenge.model.ChildChallengeModel;
import kisti.edison.challenge.model.ChildChallengeSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ChildChallenge service. Represents a row in the &quot;challenge_ChildChallenge&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link kisti.edison.challenge.model.ChildChallengeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ChildChallengeImpl}.
 * </p>
 *
 * @author KYJ
 * @see ChildChallengeImpl
 * @see kisti.edison.challenge.model.ChildChallenge
 * @see kisti.edison.challenge.model.ChildChallengeModel
 * @generated
 */
@JSON(strict = true)
public class ChildChallengeModelImpl extends BaseModelImpl<ChildChallenge>
	implements ChildChallengeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a child challenge model instance should use the {@link kisti.edison.challenge.model.ChildChallenge} interface instead.
	 */
	public static final String TABLE_NAME = "challenge_ChildChallenge";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "childChallengeId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP },
			{ "number_", Types.INTEGER },
			{ "presentationDay", Types.TIMESTAMP },
			{ "paperStartDay", Types.TIMESTAMP },
			{ "paperEndDay", Types.TIMESTAMP },
			{ "evaluationDay", Types.TIMESTAMP },
			{ "challengeStartDay", Types.TIMESTAMP },
			{ "challengeEndDay", Types.TIMESTAMP },
			{ "challengeStatus", Types.VARCHAR },
			{ "challengeId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table challenge_ChildChallenge (uuid_ VARCHAR(75) null,childChallengeId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,number_ INTEGER,presentationDay DATE null,paperStartDay DATE null,paperEndDay DATE null,evaluationDay DATE null,challengeStartDay DATE null,challengeEndDay DATE null,challengeStatus VARCHAR(75) null,challengeId LONG)";
	public static final String TABLE_SQL_DROP = "drop table challenge_ChildChallenge";
	public static final String ORDER_BY_JPQL = " ORDER BY childChallenge.childChallengeId ASC, childChallenge.challengeEndDay ASC";
	public static final String ORDER_BY_SQL = " ORDER BY challenge_ChildChallenge.childChallengeId ASC, challenge_ChildChallenge.challengeEndDay ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.kisti.edison.challenge.model.ChildChallenge"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.kisti.edison.challenge.model.ChildChallenge"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.kisti.edison.challenge.model.ChildChallenge"),
			true);
	public static long CHALLENGEID_COLUMN_BITMASK = 1L;
	public static long CHALLENGESTATUS_COLUMN_BITMASK = 2L;
	public static long COMPANYID_COLUMN_BITMASK = 4L;
	public static long GROUPID_COLUMN_BITMASK = 8L;
	public static long NUMBER_COLUMN_BITMASK = 16L;
	public static long STATUS_COLUMN_BITMASK = 32L;
	public static long UUID_COLUMN_BITMASK = 64L;
	public static long CHILDCHALLENGEID_COLUMN_BITMASK = 128L;
	public static long CHALLENGEENDDAY_COLUMN_BITMASK = 256L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ChildChallenge toModel(ChildChallengeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ChildChallenge model = new ChildChallengeImpl();

		model.setUuid(soapModel.getUuid());
		model.setChildChallengeId(soapModel.getChildChallengeId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());
		model.setNumber(soapModel.getNumber());
		model.setPresentationDay(soapModel.getPresentationDay());
		model.setPaperStartDay(soapModel.getPaperStartDay());
		model.setPaperEndDay(soapModel.getPaperEndDay());
		model.setEvaluationDay(soapModel.getEvaluationDay());
		model.setChallengeStartDay(soapModel.getChallengeStartDay());
		model.setChallengeEndDay(soapModel.getChallengeEndDay());
		model.setChallengeStatus(soapModel.getChallengeStatus());
		model.setChallengeId(soapModel.getChallengeId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ChildChallenge> toModels(ChildChallengeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ChildChallenge> models = new ArrayList<ChildChallenge>(soapModels.length);

		for (ChildChallengeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.kisti.edison.challenge.model.ChildChallenge"));

	public ChildChallengeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _childChallengeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setChildChallengeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _childChallengeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ChildChallenge.class;
	}

	@Override
	public String getModelClassName() {
		return ChildChallenge.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("childChallengeId", getChildChallengeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("number", getNumber());
		attributes.put("presentationDay", getPresentationDay());
		attributes.put("paperStartDay", getPaperStartDay());
		attributes.put("paperEndDay", getPaperEndDay());
		attributes.put("evaluationDay", getEvaluationDay());
		attributes.put("challengeStartDay", getChallengeStartDay());
		attributes.put("challengeEndDay", getChallengeEndDay());
		attributes.put("challengeStatus", getChallengeStatus());
		attributes.put("challengeId", getChallengeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long childChallengeId = (Long)attributes.get("childChallengeId");

		if (childChallengeId != null) {
			setChildChallengeId(childChallengeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Integer number = (Integer)attributes.get("number");

		if (number != null) {
			setNumber(number);
		}

		Date presentationDay = (Date)attributes.get("presentationDay");

		if (presentationDay != null) {
			setPresentationDay(presentationDay);
		}

		Date paperStartDay = (Date)attributes.get("paperStartDay");

		if (paperStartDay != null) {
			setPaperStartDay(paperStartDay);
		}

		Date paperEndDay = (Date)attributes.get("paperEndDay");

		if (paperEndDay != null) {
			setPaperEndDay(paperEndDay);
		}

		Date evaluationDay = (Date)attributes.get("evaluationDay");

		if (evaluationDay != null) {
			setEvaluationDay(evaluationDay);
		}

		Date challengeStartDay = (Date)attributes.get("challengeStartDay");

		if (challengeStartDay != null) {
			setChallengeStartDay(challengeStartDay);
		}

		Date challengeEndDay = (Date)attributes.get("challengeEndDay");

		if (challengeEndDay != null) {
			setChallengeEndDay(challengeEndDay);
		}

		String challengeStatus = (String)attributes.get("challengeStatus");

		if (challengeStatus != null) {
			setChallengeStatus(challengeStatus);
		}

		Long challengeId = (Long)attributes.get("challengeId");

		if (challengeId != null) {
			setChallengeId(challengeId);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getChildChallengeId() {
		return _childChallengeId;
	}

	@Override
	public void setChildChallengeId(long childChallengeId) {
		_columnBitmask = -1L;

		_childChallengeId = childChallengeId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
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
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
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

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@JSON
	@Override
	public int getNumber() {
		return _number;
	}

	@Override
	public void setNumber(int number) {
		_columnBitmask |= NUMBER_COLUMN_BITMASK;

		if (!_setOriginalNumber) {
			_setOriginalNumber = true;

			_originalNumber = _number;
		}

		_number = number;
	}

	public int getOriginalNumber() {
		return _originalNumber;
	}

	@JSON
	@Override
	public Date getPresentationDay() {
		return _presentationDay;
	}

	@Override
	public void setPresentationDay(Date presentationDay) {
		_presentationDay = presentationDay;
	}

	@JSON
	@Override
	public Date getPaperStartDay() {
		return _paperStartDay;
	}

	@Override
	public void setPaperStartDay(Date paperStartDay) {
		_paperStartDay = paperStartDay;
	}

	@JSON
	@Override
	public Date getPaperEndDay() {
		return _paperEndDay;
	}

	@Override
	public void setPaperEndDay(Date paperEndDay) {
		_paperEndDay = paperEndDay;
	}

	@JSON
	@Override
	public Date getEvaluationDay() {
		return _evaluationDay;
	}

	@Override
	public void setEvaluationDay(Date evaluationDay) {
		_evaluationDay = evaluationDay;
	}

	@JSON
	@Override
	public Date getChallengeStartDay() {
		return _challengeStartDay;
	}

	@Override
	public void setChallengeStartDay(Date challengeStartDay) {
		_challengeStartDay = challengeStartDay;
	}

	@JSON
	@Override
	public Date getChallengeEndDay() {
		return _challengeEndDay;
	}

	@Override
	public void setChallengeEndDay(Date challengeEndDay) {
		_columnBitmask = -1L;

		_challengeEndDay = challengeEndDay;
	}

	@JSON
	@Override
	public String getChallengeStatus() {
		if (_challengeStatus == null) {
			return StringPool.BLANK;
		}
		else {
			return _challengeStatus;
		}
	}

	@Override
	public void setChallengeStatus(String challengeStatus) {
		_columnBitmask |= CHALLENGESTATUS_COLUMN_BITMASK;

		if (_originalChallengeStatus == null) {
			_originalChallengeStatus = _challengeStatus;
		}

		_challengeStatus = challengeStatus;
	}

	public String getOriginalChallengeStatus() {
		return GetterUtil.getString(_originalChallengeStatus);
	}

	@JSON
	@Override
	public long getChallengeId() {
		return _challengeId;
	}

	@Override
	public void setChallengeId(long challengeId) {
		_columnBitmask |= CHALLENGEID_COLUMN_BITMASK;

		if (!_setOriginalChallengeId) {
			_setOriginalChallengeId = true;

			_originalChallengeId = _challengeId;
		}

		_challengeId = challengeId;
	}

	public long getOriginalChallengeId() {
		return _originalChallengeId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ChildChallenge.class.getName()));
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #isApproved}
	 */
	@Override
	public boolean getApproved() {
		return isApproved();
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ChildChallenge.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ChildChallenge toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ChildChallenge)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ChildChallengeImpl childChallengeImpl = new ChildChallengeImpl();

		childChallengeImpl.setUuid(getUuid());
		childChallengeImpl.setChildChallengeId(getChildChallengeId());
		childChallengeImpl.setGroupId(getGroupId());
		childChallengeImpl.setCompanyId(getCompanyId());
		childChallengeImpl.setUserId(getUserId());
		childChallengeImpl.setUserName(getUserName());
		childChallengeImpl.setCreateDate(getCreateDate());
		childChallengeImpl.setModifiedDate(getModifiedDate());
		childChallengeImpl.setStatus(getStatus());
		childChallengeImpl.setStatusByUserId(getStatusByUserId());
		childChallengeImpl.setStatusByUserName(getStatusByUserName());
		childChallengeImpl.setStatusDate(getStatusDate());
		childChallengeImpl.setNumber(getNumber());
		childChallengeImpl.setPresentationDay(getPresentationDay());
		childChallengeImpl.setPaperStartDay(getPaperStartDay());
		childChallengeImpl.setPaperEndDay(getPaperEndDay());
		childChallengeImpl.setEvaluationDay(getEvaluationDay());
		childChallengeImpl.setChallengeStartDay(getChallengeStartDay());
		childChallengeImpl.setChallengeEndDay(getChallengeEndDay());
		childChallengeImpl.setChallengeStatus(getChallengeStatus());
		childChallengeImpl.setChallengeId(getChallengeId());

		childChallengeImpl.resetOriginalValues();

		return childChallengeImpl;
	}

	@Override
	public int compareTo(ChildChallenge childChallenge) {
		int value = 0;

		if (getChildChallengeId() < childChallenge.getChildChallengeId()) {
			value = -1;
		}
		else if (getChildChallengeId() > childChallenge.getChildChallengeId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getChallengeEndDay(),
				childChallenge.getChallengeEndDay());

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

		if (!(obj instanceof ChildChallenge)) {
			return false;
		}

		ChildChallenge childChallenge = (ChildChallenge)obj;

		long primaryKey = childChallenge.getPrimaryKey();

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
		ChildChallengeModelImpl childChallengeModelImpl = this;

		childChallengeModelImpl._originalUuid = childChallengeModelImpl._uuid;

		childChallengeModelImpl._originalGroupId = childChallengeModelImpl._groupId;

		childChallengeModelImpl._setOriginalGroupId = false;

		childChallengeModelImpl._originalCompanyId = childChallengeModelImpl._companyId;

		childChallengeModelImpl._setOriginalCompanyId = false;

		childChallengeModelImpl._originalStatus = childChallengeModelImpl._status;

		childChallengeModelImpl._setOriginalStatus = false;

		childChallengeModelImpl._originalNumber = childChallengeModelImpl._number;

		childChallengeModelImpl._setOriginalNumber = false;

		childChallengeModelImpl._originalChallengeStatus = childChallengeModelImpl._challengeStatus;

		childChallengeModelImpl._originalChallengeId = childChallengeModelImpl._challengeId;

		childChallengeModelImpl._setOriginalChallengeId = false;

		childChallengeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ChildChallenge> toCacheModel() {
		ChildChallengeCacheModel childChallengeCacheModel = new ChildChallengeCacheModel();

		childChallengeCacheModel.uuid = getUuid();

		String uuid = childChallengeCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			childChallengeCacheModel.uuid = null;
		}

		childChallengeCacheModel.childChallengeId = getChildChallengeId();

		childChallengeCacheModel.groupId = getGroupId();

		childChallengeCacheModel.companyId = getCompanyId();

		childChallengeCacheModel.userId = getUserId();

		childChallengeCacheModel.userName = getUserName();

		String userName = childChallengeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			childChallengeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			childChallengeCacheModel.createDate = createDate.getTime();
		}
		else {
			childChallengeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			childChallengeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			childChallengeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		childChallengeCacheModel.status = getStatus();

		childChallengeCacheModel.statusByUserId = getStatusByUserId();

		childChallengeCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = childChallengeCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			childChallengeCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			childChallengeCacheModel.statusDate = statusDate.getTime();
		}
		else {
			childChallengeCacheModel.statusDate = Long.MIN_VALUE;
		}

		childChallengeCacheModel.number = getNumber();

		Date presentationDay = getPresentationDay();

		if (presentationDay != null) {
			childChallengeCacheModel.presentationDay = presentationDay.getTime();
		}
		else {
			childChallengeCacheModel.presentationDay = Long.MIN_VALUE;
		}

		Date paperStartDay = getPaperStartDay();

		if (paperStartDay != null) {
			childChallengeCacheModel.paperStartDay = paperStartDay.getTime();
		}
		else {
			childChallengeCacheModel.paperStartDay = Long.MIN_VALUE;
		}

		Date paperEndDay = getPaperEndDay();

		if (paperEndDay != null) {
			childChallengeCacheModel.paperEndDay = paperEndDay.getTime();
		}
		else {
			childChallengeCacheModel.paperEndDay = Long.MIN_VALUE;
		}

		Date evaluationDay = getEvaluationDay();

		if (evaluationDay != null) {
			childChallengeCacheModel.evaluationDay = evaluationDay.getTime();
		}
		else {
			childChallengeCacheModel.evaluationDay = Long.MIN_VALUE;
		}

		Date challengeStartDay = getChallengeStartDay();

		if (challengeStartDay != null) {
			childChallengeCacheModel.challengeStartDay = challengeStartDay.getTime();
		}
		else {
			childChallengeCacheModel.challengeStartDay = Long.MIN_VALUE;
		}

		Date challengeEndDay = getChallengeEndDay();

		if (challengeEndDay != null) {
			childChallengeCacheModel.challengeEndDay = challengeEndDay.getTime();
		}
		else {
			childChallengeCacheModel.challengeEndDay = Long.MIN_VALUE;
		}

		childChallengeCacheModel.challengeStatus = getChallengeStatus();

		String challengeStatus = childChallengeCacheModel.challengeStatus;

		if ((challengeStatus != null) && (challengeStatus.length() == 0)) {
			childChallengeCacheModel.challengeStatus = null;
		}

		childChallengeCacheModel.challengeId = getChallengeId();

		return childChallengeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", childChallengeId=");
		sb.append(getChildChallengeId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", number=");
		sb.append(getNumber());
		sb.append(", presentationDay=");
		sb.append(getPresentationDay());
		sb.append(", paperStartDay=");
		sb.append(getPaperStartDay());
		sb.append(", paperEndDay=");
		sb.append(getPaperEndDay());
		sb.append(", evaluationDay=");
		sb.append(getEvaluationDay());
		sb.append(", challengeStartDay=");
		sb.append(getChallengeStartDay());
		sb.append(", challengeEndDay=");
		sb.append(getChallengeEndDay());
		sb.append(", challengeStatus=");
		sb.append(getChallengeStatus());
		sb.append(", challengeId=");
		sb.append(getChallengeId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("kisti.edison.challenge.model.ChildChallenge");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>childChallengeId</column-name><column-value><![CDATA[");
		sb.append(getChildChallengeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
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
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>number</column-name><column-value><![CDATA[");
		sb.append(getNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>presentationDay</column-name><column-value><![CDATA[");
		sb.append(getPresentationDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paperStartDay</column-name><column-value><![CDATA[");
		sb.append(getPaperStartDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paperEndDay</column-name><column-value><![CDATA[");
		sb.append(getPaperEndDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>evaluationDay</column-name><column-value><![CDATA[");
		sb.append(getEvaluationDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>challengeStartDay</column-name><column-value><![CDATA[");
		sb.append(getChallengeStartDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>challengeEndDay</column-name><column-value><![CDATA[");
		sb.append(getChallengeEndDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>challengeStatus</column-name><column-value><![CDATA[");
		sb.append(getChallengeStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>challengeId</column-name><column-value><![CDATA[");
		sb.append(getChallengeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ChildChallenge.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ChildChallenge.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _childChallengeId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private int _number;
	private int _originalNumber;
	private boolean _setOriginalNumber;
	private Date _presentationDay;
	private Date _paperStartDay;
	private Date _paperEndDay;
	private Date _evaluationDay;
	private Date _challengeStartDay;
	private Date _challengeEndDay;
	private String _challengeStatus;
	private String _originalChallengeStatus;
	private long _challengeId;
	private long _originalChallengeId;
	private boolean _setOriginalChallengeId;
	private long _columnBitmask;
	private ChildChallenge _escapedModel;
}