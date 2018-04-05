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

package org.kisti.edison.content.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ContentLocalService}.
 *
 * @author EDISON
 * @see ContentLocalService
 * @generated
 */
public class ContentLocalServiceWrapper implements ContentLocalService,
	ServiceWrapper<ContentLocalService> {
	public ContentLocalServiceWrapper(ContentLocalService contentLocalService) {
		_contentLocalService = contentLocalService;
	}

	/**
	* Adds the content to the database. Also notifies the appropriate model listeners.
	*
	* @param content the content
	* @return the content that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.Content addContent(
		org.kisti.edison.content.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.addContent(content);
	}

	/**
	* Creates a new content with the primary key. Does not add the content to the database.
	*
	* @param contentSeq the primary key for the new content
	* @return the new content
	*/
	@Override
	public org.kisti.edison.content.model.Content createContent(long contentSeq) {
		return _contentLocalService.createContent(contentSeq);
	}

	/**
	* Deletes the content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contentSeq the primary key of the content
	* @return the content that was removed
	* @throws PortalException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.Content deleteContent(long contentSeq)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.deleteContent(contentSeq);
	}

	/**
	* Deletes the content from the database. Also notifies the appropriate model listeners.
	*
	* @param content the content
	* @return the content that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.Content deleteContent(
		org.kisti.edison.content.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.deleteContent(content);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contentLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.kisti.edison.content.model.Content fetchContent(long contentSeq)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.fetchContent(contentSeq);
	}

	/**
	* Returns the content with the primary key.
	*
	* @param contentSeq the primary key of the content
	* @return the content
	* @throws PortalException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.Content getContent(long contentSeq)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.getContent(contentSeq);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of contents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.content.model.Content> getContents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.getContents(start, end);
	}

	/**
	* Returns the number of contents.
	*
	* @return the number of contents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.getContentsCount();
	}

	/**
	* Updates the content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param content the content
	* @return the content that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.Content updateContent(
		org.kisti.edison.content.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.updateContent(content);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _contentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contentLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* �꾩꼹�쀯㎘占썼�怨좎돳
	*
	* @param locale
	* @param contentSeq
	* @return
	* @throws PortalException
	* @throws NumberFormatException
	* @throws SystemException
	*/
	@Override
	public java.util.Map<java.lang.String, java.lang.Object> retrieveMapContent(
		long companyId, java.util.Locale locale, long contentSeq)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException {
		return _contentLocalService.retrieveMapContent(companyId, locale,
			contentSeq);
	}

	/**
	* �꾩꼹�쀯㎘占썹뵳��わ옙占썼�怨좎돳 占싼딆뵠占쏙옙燁삳똾�믤�醫듼봺 占쎌빘苑�옙�뤿연 鈺곌퀬��     *
	* @param companyGroupId
	* @param groupId
	* @param searchText
	�꾩꼹�쀯㎘占썲칰占쎄퉳占쏙옙     * @param contentDiv
	�꾩꼹�쀯㎘占쏙옙醫륁굨野껓옙源�     * @param start
	* @param end
	* @param locale
	* @param categoryJoin
	燁삳똾�믤�醫듼봺 占쎈슣�좈뇡遺쎈궢 鈺곌퀣��占싼됵옙
	* @return
	* @throws Exception
	*/
	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> retrieveListContent(
		long companyGroupId, long groupId, java.lang.String searchText,
		long[] contentDiv, int start, int end, java.util.Locale locale,
		boolean categoryJoin) throws java.lang.Exception {
		return _contentLocalService.retrieveListContent(companyGroupId,
			groupId, searchText, contentDiv, start, end, locale, categoryJoin);
	}

	/**
	* 揶쏅벡�쏙옙紐낅뱜 鈺곌퀬��占쎌뮆�э옙占� 揶쏅벡�쏙옙�쇰퓠占쏙옙占싼딆뒠
	*
	* @param categoryIds
	* @param searchText
	* @param start
	* @param end
	* @param locale
	* @return
	* @throws Exception
	*/
	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> retrievetListClassNote(
		long[] categoryIds, java.lang.String searchText, int start, int end,
		java.util.Locale locale) throws java.lang.Exception {
		return _contentLocalService.retrievetListClassNote(categoryIds,
			searchText, start, end, locale);
	}

	/**
	* 揶쏅벡�쏙옙紐낅뱜 燁삳똻�ワ옙占썼�怨좎돳 占쎌뮆�э옙占� 揶쏅벡�쏙옙�쇰퓠占쏙옙占싼딆뒠
	*
	* @param categoryIds
	* @param searchText
	* @param languageId
	* @return
	*/
	@Override
	public int retrieveCountClassNote(long[] categoryIds,
		java.lang.String searchText, java.util.Locale locale) {
		return _contentLocalService.retrieveCountClassNote(categoryIds,
			searchText, locale);
	}

	/**
	* 揶쏅벡�쏙옙紐낅뱜占쏙옙�꾩꼹�쀯㎘占쏙쭗�몄쨯 鈺곌퀬��占쎌뮆�э옙占� 揶쏅벡�쏙옙�쇰퓠占쏙옙占싼딆뒠
	*
	* @param contentIds
	* @param locale
	* @return
	*/
	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> retrieveListRelatedClassNote(
		java.util.List<java.lang.Long> contentIds, java.util.Locale locale) {
		return _contentLocalService.retrieveListRelatedClassNote(contentIds,
			locale);
	}

	/**
	* �꾩꼹�쀯㎘占썹뵳��わ옙占썼�怨좎돳 �꾩꼹�쀯㎘占쏙쭗�몄쨯 : 占싼뗪쉭 -> categoryIds null
	*
	* @param categoryIds
	* @param searchText
	�꾩꼹�쀯㎘占썲칰占쎄퉳占쏙옙     * @param contentDiv
	�꾩꼹�쀯㎘占쏙옙醫륁굨野껓옙源�     * @param start
	* @param end
	* @param locale
	* @param categoryJoin
	燁삳똾�믤�醫듼봺 占쎈슣�좈뇡遺쎈궢 鈺곌퀣��占싼됵옙
	* @param isTotalSearch
	占쎈벏鍮�칰占쎄퉳占쎈Ŋ苑�鈺곌퀬�띰옙�롢늺 true - openYn, serviceLanguage �곕떽占�     * @return
	* @throws Exception
	*/
	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> retrieveListContent(
		long[] categoryIds, java.lang.String searchText, long[] contentDiv,
		int start, int end, java.util.Locale locale, boolean categoryJoin,
		boolean isTotalSearch) throws java.lang.Exception {
		return _contentLocalService.retrieveListContent(categoryIds,
			searchText, contentDiv, start, end, locale, categoryJoin,
			isTotalSearch);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> retrieveListContent(
		long[] categoryIds, java.lang.String searchText, long[] contentDiv,
		int start, int end, java.util.Locale locale, boolean categoryJoin,
		boolean isTotalSearch, java.lang.String sortField,
		java.lang.String sortOrder) throws java.lang.Exception {
		return _contentLocalService.retrieveListContent(categoryIds,
			searchText, contentDiv, start, end, locale, categoryJoin,
			isTotalSearch, sortField, sortOrder);
	}

	/**
	* �꾩꼹�쀯㎘占썹㎉�곸뒲占쏙옙鈺곌퀬��燁삳똾�믤�醫듼봺 獄쏄퀣肉�占쎌빘苑�     *
	* @param companyGroupId
	* @param groupId
	* @param searchText
	�꾩꼹�쀯㎘占썲칰占쎄퉳占쏙옙     * @param contentDiv
	�꾩꼹�쀯㎘占쏙옙醫륁굨野껓옙源�     * @param languageId
	* @param categoryJoin
	燁삳똾�믤�醫듼봺 占쎈슣�좈뇡遺쎈궢 鈺곌퀣��占싼됵옙
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public int retrieveCountContent(long companyGroupId, long groupId,
		java.lang.String searchText, long[] contentDiv,
		java.lang.String languageId, boolean categoryJoin)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.retrieveCountContent(companyGroupId,
			groupId, searchText, contentDiv, languageId, categoryJoin);
	}

	/**
	* �꾩꼹�쀯㎘占썹㎉�곸뒲占쏙옙鈺곌퀬��燁삳똾�믤�醫듼봺 獄쏄퀣肉�占쎈슢�よ첋紐낃숲嚥∽옙獄쏆룇��     *
	* @param categoryIds
	* @param searchText
	�꾩꼹�쀯㎘占썲칰占쎄퉳占쏙옙     * @param contentDiv
	�꾩꼹�쀯㎘占쏙옙醫륁굨野껓옙源�     * @param languageId
	* @param categoryJoin
	燁삳똾�믤�醫듼봺 占쎈슣�좈뇡遺쎈궢 鈺곌퀣��占싼됵옙
	* @param isTotalSearch
	占쎈벏鍮�칰占쎄퉳占쎈Ŋ苑�鈺곌퀬�띰옙�롢늺 true
	* @return
	*/
	@Override
	public int retrieveCountContent(long[] categoryIds,
		java.lang.String searchText, long[] contentDiv,
		java.lang.String languageId, boolean categoryJoin, boolean isTotalSearch) {
		return _contentLocalService.retrieveCountContent(categoryIds,
			searchText, contentDiv, languageId, categoryJoin, isTotalSearch);
	}

	/**
	* 占쎌쥙占쏙옙占썼굜�묐�筌ο옙�귐딅뮞占쏙옙鈺곌퀬���꾩꼹�쀯㎘占썰빳占쏙옙袁⑹삺 占싼딆뒠占쎈Þ占�OWNER/MANAGER占쏙옙占쏙옙�됭�怨좎돳
	*
	* @param companyGroupId
	* @param parentGroupId
	* @param groupId
	* @param searchText
	* @param start
	* @param end
	* @param locale
	* @param userId
	* @param roleId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> retrieveListUserContent(
		long companyGroupId, long parentGroupId, long groupId,
		java.lang.String searchText, int start, int end,
		java.util.Locale locale, long userId, long roleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.retrieveListUserContent(companyGroupId,
			parentGroupId, groupId, searchText, start, end, locale, userId,
			roleId);
	}

	/**
	* 占쎌쥙占쏙옙占썼굜�묐�筌ο옙燁삳똻�ワ옙占썼�怨좎돳 �꾩꼹�쀯㎘占썰빳占쏙옙袁⑹삺 占싼딆뒠占쎈Þ占�OWNER/MANAGER占쏙옙占쏙옙��燁삳똻�ワ옙占�    *
	*
	* @param companyGroupId
	* @param parentGroupId
	* @param groupId
	* @param searchText
	* @param languageId
	* @param userId
	* @param roleId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public int retrieveCountUserContent(long companyGroupId,
		long parentGroupId, long groupId, java.lang.String searchText,
		java.lang.String languageId, long userId, long roleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.retrieveCountUserContent(companyGroupId,
			parentGroupId, groupId, searchText, languageId, userId, roleId);
	}

	/**
	* �꾩꼹�쀯㎘占쏙옙源낆쨯
	*
	* @param upload
	* @param request
	* @param companyId
	* @param groupId
	* @param userId
	* @param param
	* @return Content
	* @throws Exception
	*/
	@Override
	public org.kisti.edison.content.model.Content createContent(
		com.liferay.portal.kernel.upload.UploadPortletRequest upload,
		javax.portlet.PortletRequest request, long companyId, long groupId,
		long userId, java.util.Map<java.lang.String, java.lang.Object> param)
		throws java.lang.Exception {
		return _contentLocalService.createContent(upload, request, companyId,
			groupId, userId, param);
	}

	/**
	* �꾩꼹�쀯㎘占쏙옙�낅쑓占쎈똾��     *
	* @param upload
	* @param request
	* @param companyId
	* @param groupId
	* @param userId
	* @param param
	* @return Content
	*/
	@Override
	public org.kisti.edison.content.model.Content updateContent(
		com.liferay.portal.kernel.upload.UploadPortletRequest upload,
		javax.portlet.PortletRequest request, long companyId, long groupId,
		long userId, java.util.Map<java.lang.String, java.lang.Object> param)
		throws java.lang.Exception {
		return _contentLocalService.updateContent(upload, request, companyId,
			groupId, userId, param);
	}

	/**
	* �꾩꼹�쀯㎘占쏙옙占쎌젫
	*
	* @param companyId
	* @param groupId
	* @param param
	*/
	@Override
	public void deleteContent(long companyId, long groupId,
		java.util.Map<java.lang.String, java.lang.Object> param)
		throws java.lang.Exception {
		_contentLocalService.deleteContent(companyId, groupId, param);
	}

	/**
	* entryId占쏙옙�울옙�댐옙占썼굜�묐�筌ο옙Entry 鈺곌퀬��     *
	* @param params
	* @return List<Map<String, Object>>
	*/
	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> relatedAssetLinkedEntryContent(
		java.util.Map params) {
		return _contentLocalService.relatedAssetLinkedEntryContent(params);
	}

	/**
	* �울옙�댐옙類ｋ궖占쎈Ŋ苑�野껓옙源뗰옙��옙 占쎈똻�쒙옙占썲칰占쎄퉳占쏙옙�꾩꼹�쀯㎘占썹뵳��わ옙占�    *
	*
	* @param params
	* @return List<Map<String, Object>>
	*/
	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> searchAssetEntryModelContent(
		java.util.Map params) {
		return _contentLocalService.searchAssetEntryModelContent(params);
	}

	/**
	* �울옙�댐옙類ｋ궖占쎈Ŋ苑�野껓옙源뗰옙��옙 占쎈똻�쒙옙占썲칰占쎄퉳占쏙옙�꾩꼹�쀯㎘占썹㎉�곸뒲占쏙옙     *
	*
	* @param params
	* @return int
	*/
	@Override
	public int searchAssetEntryModelContentCount(java.util.Map params) {
		return _contentLocalService.searchAssetEntryModelContentCount(params);
	}

	/**
	* �꾩꼹�쀯㎘醫딉옙 ENTRY占쏙옙占쎄퉭以�     *
	* @param companyId
	* @param groupId
	* @param content
	* @return long
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public long contentAddAssetEntry(long companyId, long groupId,
		org.kisti.edison.content.model.Content content)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.contentAddAssetEntry(companyId, groupId,
			content);
	}

	/**
	* �꾩꼹�쀯㎘占폠NSERTID 占쎈굝�뀐옙�꾨뱜 (OWNER 癰귨옙瑗�
	*
	* @param groupId
	* @param contentSeq
	* @param userId
	* @param projectYn
	* @param projectId
	* @throws Exception
	*/
	@Override
	public void updateContentInsertId(long groupId, long contentSeq,
		long userId, java.lang.String projectYn, long projectId)
		throws java.lang.Exception {
		_contentLocalService.updateContentInsertId(groupId, contentSeq, userId,
			projectYn, projectId);
	}

	/**
	* 燁삳똾�믤�醫듼봺 獄쏄퀣肉�占쎌빘苑�占쎈벏鍮�칰占쎄퉳占쏙옙占싼딆뒠 占쎈뜇釉� �꾩꼹�쀯㎘醫딅뮉 占싼뗪퉱占쎈Ŋ苑뚳옙占썹㎉�꾨��⑥쥓�곮퉪袁⑥쨮 鈺곌퀬�띰옙�륅옙 占쎈봿�앲첋占쎌쨮 parentCategory 揶쏉옙0占쏙옙     * 占싼딆뵠占쏙옙占싼뗪퉱)占쏙옙占쏙옙鍮먲옙占퐊ull占쏙옙獄쏆꼹�싷옙占�     *
	* @param companyGroupId
	* @param groupId
	* @return long[]
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public long[] makeCategoryEntryList(long companyGroupId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.makeCategoryEntryList(companyGroupId,
			groupId);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getContentDatailListForProjectStatistics(
		java.lang.String projectYn, long columnId, long categoryId,
		java.lang.String languageId, java.util.Locale locale)
		throws java.lang.Exception {
		return _contentLocalService.getContentDatailListForProjectStatistics(projectYn,
			columnId, categoryId, languageId, locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getContentForProjectList(
		long userId, java.lang.String searchText,
		java.lang.String projectCategoryId, java.lang.String languageId,
		int start, int end, java.util.Locale locale) throws java.lang.Exception {
		return _contentLocalService.getContentForProjectList(userId,
			searchText, projectCategoryId, languageId, start, end, locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getContentCenterListForProjectStatistics(
		java.lang.String projectYn, java.lang.String propertyKey,
		java.util.Locale locale) throws java.lang.Exception {
		return _contentLocalService.getContentCenterListForProjectStatistics(projectYn,
			propertyKey, locale);
	}

	@Override
	public int getGeneralContentCountByGroupIdForProjectList(long userId,
		java.lang.String searchText, java.lang.String projectCategoryId,
		java.lang.String languageId) {
		return _contentLocalService.getGeneralContentCountByGroupIdForProjectList(userId,
			searchText, projectCategoryId, languageId);
	}

	@Override
	public void migrationGeneralContentTable(long companyGroupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_contentLocalService.migrationGeneralContentTable(companyGroupId,
			companyId);
	}

	@Override
	public void migrationAdvancedContentTable(long companyGroupId,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_contentLocalService.migrationAdvancedContentTable(companyGroupId,
			companyId);
	}

	@Override
	public java.util.List<org.kisti.edison.content.model.Content> findByContentDiv(
		long contentDiv)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.findByContentDiv(contentDiv);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ContentLocalService getWrappedContentLocalService() {
		return _contentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedContentLocalService(
		ContentLocalService contentLocalService) {
		_contentLocalService = contentLocalService;
	}

	@Override
	public ContentLocalService getWrappedService() {
		return _contentLocalService;
	}

	@Override
	public void setWrappedService(ContentLocalService contentLocalService) {
		_contentLocalService = contentLocalService;
	}

	private ContentLocalService _contentLocalService;
}