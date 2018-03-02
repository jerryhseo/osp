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

package kisti.edison.challenge.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import kisti.edison.challenge.service.ChallengeEvaluationLocalServiceUtil;
import kisti.edison.challenge.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author KYJ
 */
public class ChallengeEvaluationClp extends BaseModelImpl<ChallengeEvaluation>
	implements ChallengeEvaluation {
	public ChallengeEvaluationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ChallengeEvaluation.class;
	}

	@Override
	public String getModelClassName() {
		return ChallengeEvaluation.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _challengeEvaluationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setChallengeEvaluationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _challengeEvaluationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("challengeEvaluationId", getChallengeEvaluationId());
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
		attributes.put("assessmentItem", getAssessmentItem());
		attributes.put("distribution", getDistribution());
		attributes.put("score", getScore());
		attributes.put("challengeTeamId", getChallengeTeamId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long challengeEvaluationId = (Long)attributes.get(
				"challengeEvaluationId");

		if (challengeEvaluationId != null) {
			setChallengeEvaluationId(challengeEvaluationId);
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

		String assessmentItem = (String)attributes.get("assessmentItem");

		if (assessmentItem != null) {
			setAssessmentItem(assessmentItem);
		}

		Double distribution = (Double)attributes.get("distribution");

		if (distribution != null) {
			setDistribution(distribution);
		}

		Double score = (Double)attributes.get("score");

		if (score != null) {
			setScore(score);
		}

		Long challengeTeamId = (Long)attributes.get("challengeTeamId");

		if (challengeTeamId != null) {
			setChallengeTeamId(challengeTeamId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_challengeEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _challengeEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_challengeEvaluationRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getChallengeEvaluationId() {
		return _challengeEvaluationId;
	}

	@Override
	public void setChallengeEvaluationId(long challengeEvaluationId) {
		_challengeEvaluationId = challengeEvaluationId;

		if (_challengeEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _challengeEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setChallengeEvaluationId",
						long.class);

				method.invoke(_challengeEvaluationRemoteModel,
					challengeEvaluationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_challengeEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _challengeEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_challengeEvaluationRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_challengeEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _challengeEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_challengeEvaluationRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_challengeEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _challengeEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_challengeEvaluationRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_challengeEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _challengeEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_challengeEvaluationRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_challengeEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _challengeEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_challengeEvaluationRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_challengeEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _challengeEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_challengeEvaluationRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_challengeEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _challengeEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_challengeEvaluationRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;

		if (_challengeEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _challengeEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_challengeEvaluationRemoteModel, statusByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
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

	@Override
	public String getStatusByUserName() {
		return _statusByUserName;
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;

		if (_challengeEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _challengeEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_challengeEvaluationRemoteModel, statusByUserName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;

		if (_challengeEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _challengeEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDate", Date.class);

				method.invoke(_challengeEvaluationRemoteModel, statusDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAssessmentItem() {
		return _assessmentItem;
	}

	@Override
	public String getAssessmentItem(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getAssessmentItem(languageId);
	}

	@Override
	public String getAssessmentItem(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getAssessmentItem(languageId, useDefault);
	}

	@Override
	public String getAssessmentItem(String languageId) {
		return LocalizationUtil.getLocalization(getAssessmentItem(), languageId);
	}

	@Override
	public String getAssessmentItem(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getAssessmentItem(),
			languageId, useDefault);
	}

	@Override
	public String getAssessmentItemCurrentLanguageId() {
		return _assessmentItemCurrentLanguageId;
	}

	@Override
	public String getAssessmentItemCurrentValue() {
		Locale locale = getLocale(_assessmentItemCurrentLanguageId);

		return getAssessmentItem(locale);
	}

	@Override
	public Map<Locale, String> getAssessmentItemMap() {
		return LocalizationUtil.getLocalizationMap(getAssessmentItem());
	}

	@Override
	public void setAssessmentItem(String assessmentItem) {
		_assessmentItem = assessmentItem;

		if (_challengeEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _challengeEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setAssessmentItem",
						String.class);

				method.invoke(_challengeEvaluationRemoteModel, assessmentItem);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setAssessmentItem(String assessmentItem, Locale locale) {
		setAssessmentItem(assessmentItem, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setAssessmentItem(String assessmentItem, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(assessmentItem)) {
			setAssessmentItem(LocalizationUtil.updateLocalization(
					getAssessmentItem(), "AssessmentItem", assessmentItem,
					languageId, defaultLanguageId));
		}
		else {
			setAssessmentItem(LocalizationUtil.removeLocalization(
					getAssessmentItem(), "AssessmentItem", languageId));
		}
	}

	@Override
	public void setAssessmentItemCurrentLanguageId(String languageId) {
		_assessmentItemCurrentLanguageId = languageId;
	}

	@Override
	public void setAssessmentItemMap(Map<Locale, String> assessmentItemMap) {
		setAssessmentItemMap(assessmentItemMap, LocaleUtil.getDefault());
	}

	@Override
	public void setAssessmentItemMap(Map<Locale, String> assessmentItemMap,
		Locale defaultLocale) {
		if (assessmentItemMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setAssessmentItem(LocalizationUtil.updateLocalization(
					assessmentItemMap, getAssessmentItem(), "AssessmentItem",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public double getDistribution() {
		return _distribution;
	}

	@Override
	public void setDistribution(double distribution) {
		_distribution = distribution;

		if (_challengeEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _challengeEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setDistribution", double.class);

				method.invoke(_challengeEvaluationRemoteModel, distribution);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getScore() {
		return _score;
	}

	@Override
	public void setScore(double score) {
		_score = score;

		if (_challengeEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _challengeEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setScore", double.class);

				method.invoke(_challengeEvaluationRemoteModel, score);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getChallengeTeamId() {
		return _challengeTeamId;
	}

	@Override
	public void setChallengeTeamId(long challengeTeamId) {
		_challengeTeamId = challengeTeamId;

		if (_challengeEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _challengeEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setChallengeTeamId", long.class);

				method.invoke(_challengeEvaluationRemoteModel, challengeTeamId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ChallengeEvaluation.class.getName()));
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

	public BaseModel<?> getChallengeEvaluationRemoteModel() {
		return _challengeEvaluationRemoteModel;
	}

	public void setChallengeEvaluationRemoteModel(
		BaseModel<?> challengeEvaluationRemoteModel) {
		_challengeEvaluationRemoteModel = challengeEvaluationRemoteModel;
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

		Class<?> remoteModelClass = _challengeEvaluationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_challengeEvaluationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ChallengeEvaluationLocalServiceUtil.addChallengeEvaluation(this);
		}
		else {
			ChallengeEvaluationLocalServiceUtil.updateChallengeEvaluation(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> assessmentItemMap = getAssessmentItemMap();

		for (Map.Entry<Locale, String> entry : assessmentItemMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getAssessmentItem();

		if (xml == null) {
			return StringPool.BLANK;
		}

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		prepareLocalizedFieldsForImport(null);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getSiteDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String assessmentItem = getAssessmentItem(defaultLocale);

		if (Validator.isNull(assessmentItem)) {
			setAssessmentItem(getAssessmentItem(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setAssessmentItem(getAssessmentItem(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public ChallengeEvaluation toEscapedModel() {
		return (ChallengeEvaluation)ProxyUtil.newProxyInstance(ChallengeEvaluation.class.getClassLoader(),
			new Class[] { ChallengeEvaluation.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ChallengeEvaluationClp clone = new ChallengeEvaluationClp();

		clone.setUuid(getUuid());
		clone.setChallengeEvaluationId(getChallengeEvaluationId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusByUserName(getStatusByUserName());
		clone.setStatusDate(getStatusDate());
		clone.setAssessmentItem(getAssessmentItem());
		clone.setDistribution(getDistribution());
		clone.setScore(getScore());
		clone.setChallengeTeamId(getChallengeTeamId());

		return clone;
	}

	@Override
	public int compareTo(ChallengeEvaluation challengeEvaluation) {
		int value = 0;

		if (getChallengeEvaluationId() < challengeEvaluation.getChallengeEvaluationId()) {
			value = -1;
		}
		else if (getChallengeEvaluationId() > challengeEvaluation.getChallengeEvaluationId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreateDate(),
				challengeEvaluation.getCreateDate());

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

		if (!(obj instanceof ChallengeEvaluationClp)) {
			return false;
		}

		ChallengeEvaluationClp challengeEvaluation = (ChallengeEvaluationClp)obj;

		long primaryKey = challengeEvaluation.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
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
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", challengeEvaluationId=");
		sb.append(getChallengeEvaluationId());
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
		sb.append(", assessmentItem=");
		sb.append(getAssessmentItem());
		sb.append(", distribution=");
		sb.append(getDistribution());
		sb.append(", score=");
		sb.append(getScore());
		sb.append(", challengeTeamId=");
		sb.append(getChallengeTeamId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("kisti.edison.challenge.model.ChallengeEvaluation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>challengeEvaluationId</column-name><column-value><![CDATA[");
		sb.append(getChallengeEvaluationId());
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
			"<column><column-name>assessmentItem</column-name><column-value><![CDATA[");
		sb.append(getAssessmentItem());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>distribution</column-name><column-value><![CDATA[");
		sb.append(getDistribution());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>score</column-name><column-value><![CDATA[");
		sb.append(getScore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>challengeTeamId</column-name><column-value><![CDATA[");
		sb.append(getChallengeTeamId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _challengeEvaluationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private String _assessmentItem;
	private String _assessmentItemCurrentLanguageId;
	private double _distribution;
	private double _score;
	private long _challengeTeamId;
	private BaseModel<?> _challengeEvaluationRemoteModel;
	private Class<?> _clpSerializerClass = kisti.edison.challenge.service.ClpSerializer.class;
}