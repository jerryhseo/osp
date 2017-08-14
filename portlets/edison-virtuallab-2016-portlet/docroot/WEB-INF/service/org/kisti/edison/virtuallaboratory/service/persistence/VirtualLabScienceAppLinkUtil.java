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

package org.kisti.edison.virtuallaboratory.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink;

import java.util.List;

/**
 * The persistence utility for the virtual lab science app link service. This utility wraps {@link VirtualLabScienceAppLinkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see VirtualLabScienceAppLinkPersistence
 * @see VirtualLabScienceAppLinkPersistenceImpl
 * @generated
 */
public class VirtualLabScienceAppLinkUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(
		VirtualLabScienceAppLink virtualLabScienceAppLink) {
		getPersistence().clearCache(virtualLabScienceAppLink);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<VirtualLabScienceAppLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VirtualLabScienceAppLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VirtualLabScienceAppLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VirtualLabScienceAppLink update(
		VirtualLabScienceAppLink virtualLabScienceAppLink)
		throws SystemException {
		return getPersistence().update(virtualLabScienceAppLink);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VirtualLabScienceAppLink update(
		VirtualLabScienceAppLink virtualLabScienceAppLink,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(virtualLabScienceAppLink, serviceContext);
	}

	/**
	* Returns all the virtual lab science app links where virtualLabId = &#63;.
	*
	* @param virtualLabId the virtual lab ID
	* @return the matching virtual lab science app links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink> findByVirtualLabId(
		long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVirtualLabId(virtualLabId);
	}

	/**
	* Returns a range of all the virtual lab science app links where virtualLabId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabScienceAppLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param virtualLabId the virtual lab ID
	* @param start the lower bound of the range of virtual lab science app links
	* @param end the upper bound of the range of virtual lab science app links (not inclusive)
	* @return the range of matching virtual lab science app links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink> findByVirtualLabId(
		long virtualLabId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVirtualLabId(virtualLabId, start, end);
	}

	/**
	* Returns an ordered range of all the virtual lab science app links where virtualLabId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabScienceAppLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param virtualLabId the virtual lab ID
	* @param start the lower bound of the range of virtual lab science app links
	* @param end the upper bound of the range of virtual lab science app links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching virtual lab science app links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink> findByVirtualLabId(
		long virtualLabId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVirtualLabId(virtualLabId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first virtual lab science app link in the ordered set where virtualLabId = &#63;.
	*
	* @param virtualLabId the virtual lab ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching virtual lab science app link
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabScienceAppLinkException if a matching virtual lab science app link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink findByVirtualLabId_First(
		long virtualLabId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabScienceAppLinkException {
		return getPersistence()
				   .findByVirtualLabId_First(virtualLabId, orderByComparator);
	}

	/**
	* Returns the first virtual lab science app link in the ordered set where virtualLabId = &#63;.
	*
	* @param virtualLabId the virtual lab ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching virtual lab science app link, or <code>null</code> if a matching virtual lab science app link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink fetchByVirtualLabId_First(
		long virtualLabId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVirtualLabId_First(virtualLabId, orderByComparator);
	}

	/**
	* Returns the last virtual lab science app link in the ordered set where virtualLabId = &#63;.
	*
	* @param virtualLabId the virtual lab ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching virtual lab science app link
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabScienceAppLinkException if a matching virtual lab science app link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink findByVirtualLabId_Last(
		long virtualLabId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabScienceAppLinkException {
		return getPersistence()
				   .findByVirtualLabId_Last(virtualLabId, orderByComparator);
	}

	/**
	* Returns the last virtual lab science app link in the ordered set where virtualLabId = &#63;.
	*
	* @param virtualLabId the virtual lab ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching virtual lab science app link, or <code>null</code> if a matching virtual lab science app link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink fetchByVirtualLabId_Last(
		long virtualLabId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVirtualLabId_Last(virtualLabId, orderByComparator);
	}

	/**
	* Returns the virtual lab science app links before and after the current virtual lab science app link in the ordered set where virtualLabId = &#63;.
	*
	* @param scienceAppSeqNo the primary key of the current virtual lab science app link
	* @param virtualLabId the virtual lab ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next virtual lab science app link
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabScienceAppLinkException if a virtual lab science app link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink[] findByVirtualLabId_PrevAndNext(
		long scienceAppSeqNo, long virtualLabId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabScienceAppLinkException {
		return getPersistence()
				   .findByVirtualLabId_PrevAndNext(scienceAppSeqNo,
			virtualLabId, orderByComparator);
	}

	/**
	* Removes all the virtual lab science app links where virtualLabId = &#63; from the database.
	*
	* @param virtualLabId the virtual lab ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVirtualLabId(long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVirtualLabId(virtualLabId);
	}

	/**
	* Returns the number of virtual lab science app links where virtualLabId = &#63;.
	*
	* @param virtualLabId the virtual lab ID
	* @return the number of matching virtual lab science app links
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVirtualLabId(long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVirtualLabId(virtualLabId);
	}

	/**
	* Caches the virtual lab science app link in the entity cache if it is enabled.
	*
	* @param virtualLabScienceAppLink the virtual lab science app link
	*/
	public static void cacheResult(
		org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink virtualLabScienceAppLink) {
		getPersistence().cacheResult(virtualLabScienceAppLink);
	}

	/**
	* Caches the virtual lab science app links in the entity cache if it is enabled.
	*
	* @param virtualLabScienceAppLinks the virtual lab science app links
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink> virtualLabScienceAppLinks) {
		getPersistence().cacheResult(virtualLabScienceAppLinks);
	}

	/**
	* Creates a new virtual lab science app link with the primary key. Does not add the virtual lab science app link to the database.
	*
	* @param scienceAppSeqNo the primary key for the new virtual lab science app link
	* @return the new virtual lab science app link
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink create(
		long scienceAppSeqNo) {
		return getPersistence().create(scienceAppSeqNo);
	}

	/**
	* Removes the virtual lab science app link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppSeqNo the primary key of the virtual lab science app link
	* @return the virtual lab science app link that was removed
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabScienceAppLinkException if a virtual lab science app link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink remove(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabScienceAppLinkException {
		return getPersistence().remove(scienceAppSeqNo);
	}

	public static org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink updateImpl(
		org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink virtualLabScienceAppLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(virtualLabScienceAppLink);
	}

	/**
	* Returns the virtual lab science app link with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchVirtualLabScienceAppLinkException} if it could not be found.
	*
	* @param scienceAppSeqNo the primary key of the virtual lab science app link
	* @return the virtual lab science app link
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabScienceAppLinkException if a virtual lab science app link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink findByPrimaryKey(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabScienceAppLinkException {
		return getPersistence().findByPrimaryKey(scienceAppSeqNo);
	}

	/**
	* Returns the virtual lab science app link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scienceAppSeqNo the primary key of the virtual lab science app link
	* @return the virtual lab science app link, or <code>null</code> if a virtual lab science app link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink fetchByPrimaryKey(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(scienceAppSeqNo);
	}

	/**
	* Returns all the virtual lab science app links.
	*
	* @return the virtual lab science app links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the virtual lab science app links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabScienceAppLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of virtual lab science app links
	* @param end the upper bound of the range of virtual lab science app links (not inclusive)
	* @return the range of virtual lab science app links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the virtual lab science app links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabScienceAppLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of virtual lab science app links
	* @param end the upper bound of the range of virtual lab science app links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of virtual lab science app links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabScienceAppLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the virtual lab science app links from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of virtual lab science app links.
	*
	* @return the number of virtual lab science app links
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VirtualLabScienceAppLinkPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VirtualLabScienceAppLinkPersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.virtuallaboratory.service.ClpSerializer.getServletContextName(),
					VirtualLabScienceAppLinkPersistence.class.getName());

			ReferenceRegistry.registerReference(VirtualLabScienceAppLinkUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VirtualLabScienceAppLinkPersistence persistence) {
	}

	private static VirtualLabScienceAppLinkPersistence _persistence;
}