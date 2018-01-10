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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for Content. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author EDISON
 * @see ContentLocalServiceUtil
 * @see org.kisti.edison.content.service.base.ContentLocalServiceBaseImpl
 * @see org.kisti.edison.content.service.impl.ContentLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ContentLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContentLocalServiceUtil} to access the content local service. Add custom service methods to {@link org.kisti.edison.content.service.impl.ContentLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the content to the database. Also notifies the appropriate model listeners.
	*
	* @param content the content
	* @return the content that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.kisti.edison.content.model.Content addContent(
		org.kisti.edison.content.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new content with the primary key. Does not add the content to the database.
	*
	* @param contentSeq the primary key for the new content
	* @return the new content
	*/
	public org.kisti.edison.content.model.Content createContent(long contentSeq);

	/**
	* Deletes the content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contentSeq the primary key of the content
	* @return the content that was removed
	* @throws PortalException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.kisti.edison.content.model.Content deleteContent(long contentSeq)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the content from the database. Also notifies the appropriate model listeners.
	*
	* @param content the content
	* @return the content that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.kisti.edison.content.model.Content deleteContent(
		org.kisti.edison.content.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.kisti.edison.content.model.Content fetchContent(long contentSeq)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content with the primary key.
	*
	* @param contentSeq the primary key of the content
	* @return the content
	* @throws PortalException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.kisti.edison.content.model.Content getContent(long contentSeq)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.content.model.Content> getContents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contents.
	*
	* @return the number of contents
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param content the content
	* @return the content that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.kisti.edison.content.model.Content updateContent(
		org.kisti.edison.content.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	/**
	* 肄섑뀗痢�議고쉶
	*
	* @param locale
	* @param contentSeq
	* @return
	* @throws PortalException
	* @throws NumberFormatException
	* @throws SystemException
	*/
	public java.util.Map<java.lang.String, java.lang.Object> retrieveMapContent(
		long companyId, java.util.Locale locale, long contentSeq)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException;

	/**
	* 肄섑뀗痢�由ъ뒪��議고쉶 �ъ씠��移댄뀒怨좊━ �앹꽦�섏뿬 議고쉶
	*
	* @param companyGroupId
	* @param groupId
	* @param searchText
	肄섑뀗痢�寃�깋��     * @param contentDiv
	肄섑뀗痢��좏삎寃�깋
	* @param start
	* @param end
	* @param locale
	* @param categoryJoin
	移댄뀒怨좊━ �뚯씠釉붽낵 議곗씤 �щ�
	* @return
	* @throws Exception
	*/
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> retrieveListContent(
		long companyGroupId, long groupId, java.lang.String searchText,
		long[] contentDiv, int start, int end, java.util.Locale locale,
		boolean categoryJoin) throws java.lang.Exception;

	/**
	* 媛뺤쓽�명듃 議고쉶 �쒕퉬��- 媛뺤쓽�ㅼ뿉���ъ슜
	*
	* @param categoryIds
	* @param searchText
	* @param start
	* @param end
	* @param locale
	* @return
	* @throws Exception
	*/
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> retrievetListClassNote(
		long[] categoryIds, java.lang.String searchText, int start, int end,
		java.util.Locale locale) throws java.lang.Exception;

	/**
	* 媛뺤쓽�명듃 移댁슫��議고쉶 �쒕퉬��- 媛뺤쓽�ㅼ뿉���ъ슜
	*
	* @param categoryIds
	* @param searchText
	* @param languageId
	* @return
	*/
	public int retrieveCountClassNote(long[] categoryIds,
		java.lang.String searchText, java.util.Locale locale);

	/**
	* 媛뺤쓽�명듃��肄섑뀗痢�紐⑸줉 議고쉶 �쒕퉬��- 媛뺤쓽�ㅼ뿉���ъ슜
	*
	* @param contentIds
	* @param locale
	* @return
	*/
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> retrieveListRelatedClassNote(
		java.util.List<java.lang.Long> contentIds, java.util.Locale locale);

	/**
	* 肄섑뀗痢�由ъ뒪��議고쉶 肄섑뀗痢�紐⑸줉 : �ы꽭 -> categoryIds null
	*
	* @param categoryIds
	* @param searchText
	肄섑뀗痢�寃�깋��     * @param contentDiv
	肄섑뀗痢��좏삎寃�깋
	* @param start
	* @param end
	* @param locale
	* @param categoryJoin
	移댄뀒怨좊━ �뚯씠釉붽낵 議곗씤 �щ�
	* @param isTotalSearch
	�듯빀寃�깋�먯꽌 議고쉶�섎㈃ true - openYn, serviceLanguage 異붽�
	* @return
	* @throws Exception
	*/
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> retrieveListContent(
		long[] categoryIds, java.lang.String searchText, long[] contentDiv,
		int start, int end, java.util.Locale locale, boolean categoryJoin,
		boolean isTotalSearch) throws java.lang.Exception;

	/**
	* 肄섑뀗痢�移댁슫��議고쉶 移댄뀒怨좊━ 諛곗뿴 �앹꽦
	*
	* @param companyGroupId
	* @param groupId
	* @param searchText
	肄섑뀗痢�寃�깋��     * @param contentDiv
	肄섑뀗痢��좏삎寃�깋
	* @param languageId
	* @param categoryJoin
	移댄뀒怨좊━ �뚯씠釉붽낵 議곗씤 �щ�
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public int retrieveCountContent(long companyGroupId, long groupId,
		java.lang.String searchText, long[] contentDiv,
		java.lang.String languageId, boolean categoryJoin)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* 肄섑뀗痢�移댁슫��議고쉶 移댄뀒怨좊━ 諛곗뿴 �뚮씪誘명꽣濡�諛쏆쓬
	*
	* @param categoryIds
	* @param searchText
	肄섑뀗痢�寃�깋��     * @param contentDiv
	肄섑뀗痢��좏삎寃�깋
	* @param languageId
	* @param categoryJoin
	移댄뀒怨좊━ �뚯씠釉붽낵 議곗씤 �щ�
	* @param isTotalSearch
	�듯빀寃�깋�먯꽌 議고쉶�섎㈃ true
	* @return
	*/
	public int retrieveCountContent(long[] categoryIds,
		java.lang.String searchText, long[] contentDiv,
		java.lang.String languageId, boolean categoryJoin, boolean isTotalSearch);

	/**
	* �좎���肄섑뀗痢�由ъ뒪��議고쉶 肄섑뀗痢�以��꾩옱 �ъ슜�먭� OWNER/MANAGER����ぉ議고쉶
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
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> retrieveListUserContent(
		long companyGroupId, long parentGroupId, long groupId,
		java.lang.String searchText, int start, int end,
		java.util.Locale locale, long userId, long roleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* �좎���肄섑뀗痢�移댁슫��議고쉶 肄섑뀗痢�以��꾩옱 �ъ슜�먭� OWNER/MANAGER����ぉ 移댁슫��     *
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
	public int retrieveCountUserContent(long companyGroupId,
		long parentGroupId, long groupId, java.lang.String searchText,
		java.lang.String languageId, long userId, long roleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* 肄섑뀗痢��깅줉
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
	public org.kisti.edison.content.model.Content createContent(
		com.liferay.portal.kernel.upload.UploadPortletRequest upload,
		javax.portlet.PortletRequest request, long companyId, long groupId,
		long userId, java.util.Map<java.lang.String, java.lang.Object> param)
		throws java.lang.Exception;

	/**
	* 肄섑뀗痢��낅뜲�댄듃
	*
	* @param upload
	* @param request
	* @param companyId
	* @param groupId
	* @param userId
	* @param param
	* @return Content
	*/
	public org.kisti.edison.content.model.Content updateContent(
		com.liferay.portal.kernel.upload.UploadPortletRequest upload,
		javax.portlet.PortletRequest request, long companyId, long groupId,
		long userId, java.util.Map<java.lang.String, java.lang.Object> param)
		throws java.lang.Exception;

	/**
	* 肄섑뀗痢���젣
	*
	* @param companyId
	* @param groupId
	* @param param
	*/
	public void deleteContent(long companyId, long groupId,
		java.util.Map<java.lang.String, java.lang.Object> param)
		throws java.lang.Exception;

	/**
	* entryId��愿�젴��肄섑뀗痢�Entry 議고쉶
	*
	* @param params
	* @return List<Map<String, Object>>
	*/
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> relatedAssetLinkedEntryContent(
		java.util.Map params);

	/**
	* 愿�젴�뺣낫�먯꽌 寃�깋�대� �댁슜��寃�깋��肄섑뀗痢�由ъ뒪��     *
	* @param params
	* @return List<Map<String, Object>>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> searchAssetEntryModelContent(
		java.util.Map params);

	/**
	* 愿�젴�뺣낫�먯꽌 寃�깋�대� �댁슜��寃�깋��肄섑뀗痢�移댁슫��     *
	* @param params
	* @return int
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int searchAssetEntryModelContentCount(java.util.Map params);

	/**
	* 肄섑뀗痢좊� ENTRY���깅줉
	*
	* @param companyId
	* @param groupId
	* @param content
	* @return long
	* @throws PortalException
	* @throws SystemException
	*/
	public long contentAddAssetEntry(long companyId, long groupId,
		org.kisti.edison.content.model.Content content)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* 肄섑뀗痢�INSERTID �낅뜲�댄듃 (OWNER 蹂�꼍)
	*
	* @param groupId
	* @param contentSeq
	* @param userId
	* @param projectYn
	* @param projectId
	* @throws Exception
	*/
	public void updateContentInsertId(long groupId, long contentSeq,
		long userId, java.lang.String projectYn, long projectId)
		throws java.lang.Exception;

	/**
	* 移댄뀒怨좊━ 諛곗뿴 �앹꽦 �듯빀寃�깋���ъ슜 �덊븿. 肄섑뀗痢좊뒗 �ы깉�먯꽌��移댄뀒怨좊━蹂꾨줈 議고쉶�섏� �딆쑝誘�줈 parentCategory 媛�0��     * �ъ씠���ы깉)����빐��null��諛섑솚��
	*
	* @param companyGroupId
	* @param groupId
	* @return long[]
	* @throws PortalException
	* @throws SystemException
	*/
	public long[] makeCategoryEntryList(long companyGroupId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getContentDatailListForProjectStatistics(
		java.lang.String projectYn, long columnId, long categoryId,
		java.lang.String languageId, java.util.Locale locale)
		throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getContentForProjectList(
		long userId, java.lang.String searchText,
		java.lang.String projectCategoryId, java.lang.String languageId,
		int start, int end, java.util.Locale locale) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getContentCenterListForProjectStatistics(
		java.lang.String projectYn, java.lang.String propertyKey,
		java.util.Locale locale) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getGeneralContentCountByGroupIdForProjectList(long userId,
		java.lang.String searchText, java.lang.String projectCategoryId,
		java.lang.String languageId);

	public void migrationGeneralContentTable(long companyGroupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void migrationAdvancedContentTable(long companyGroupId,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;
}