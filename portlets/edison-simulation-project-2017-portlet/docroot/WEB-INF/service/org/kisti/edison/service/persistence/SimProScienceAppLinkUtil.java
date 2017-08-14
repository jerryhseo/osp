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

package org.kisti.edison.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.kisti.edison.model.SimProScienceAppLink;

import java.util.List;

/**
 * The persistence utility for the sim pro science app link service. This utility wraps {@link SimProScienceAppLinkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author edison
 * @see SimProScienceAppLinkPersistence
 * @see SimProScienceAppLinkPersistenceImpl
 * @generated
 */
public class SimProScienceAppLinkUtil {
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
	public static void clearCache(SimProScienceAppLink simProScienceAppLink) {
		getPersistence().clearCache(simProScienceAppLink);
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
	public static List<SimProScienceAppLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SimProScienceAppLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SimProScienceAppLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SimProScienceAppLink update(
		SimProScienceAppLink simProScienceAppLink) throws SystemException {
		return getPersistence().update(simProScienceAppLink);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SimProScienceAppLink update(
		SimProScienceAppLink simProScienceAppLink, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(simProScienceAppLink, serviceContext);
	}

	/**
	* Returns all the sim pro science app links where simulationProjectId = &#63;.
	*
	* @param simulationProjectId the simulation project ID
	* @return the matching sim pro science app links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.SimProScienceAppLink> findBySimulationProjectId(
		long simulationProjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySimulationProjectId(simulationProjectId);
	}

	/**
	* Returns a range of all the sim pro science app links where simulationProjectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.SimProScienceAppLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param simulationProjectId the simulation project ID
	* @param start the lower bound of the range of sim pro science app links
	* @param end the upper bound of the range of sim pro science app links (not inclusive)
	* @return the range of matching sim pro science app links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.SimProScienceAppLink> findBySimulationProjectId(
		long simulationProjectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySimulationProjectId(simulationProjectId, start, end);
	}

	/**
	* Returns an ordered range of all the sim pro science app links where simulationProjectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.SimProScienceAppLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param simulationProjectId the simulation project ID
	* @param start the lower bound of the range of sim pro science app links
	* @param end the upper bound of the range of sim pro science app links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sim pro science app links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.SimProScienceAppLink> findBySimulationProjectId(
		long simulationProjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySimulationProjectId(simulationProjectId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first sim pro science app link in the ordered set where simulationProjectId = &#63;.
	*
	* @param simulationProjectId the simulation project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sim pro science app link
	* @throws org.kisti.edison.NoSuchSimProScienceAppLinkException if a matching sim pro science app link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.SimProScienceAppLink findBySimulationProjectId_First(
		long simulationProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchSimProScienceAppLinkException {
		return getPersistence()
				   .findBySimulationProjectId_First(simulationProjectId,
			orderByComparator);
	}

	/**
	* Returns the first sim pro science app link in the ordered set where simulationProjectId = &#63;.
	*
	* @param simulationProjectId the simulation project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sim pro science app link, or <code>null</code> if a matching sim pro science app link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.SimProScienceAppLink fetchBySimulationProjectId_First(
		long simulationProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySimulationProjectId_First(simulationProjectId,
			orderByComparator);
	}

	/**
	* Returns the last sim pro science app link in the ordered set where simulationProjectId = &#63;.
	*
	* @param simulationProjectId the simulation project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sim pro science app link
	* @throws org.kisti.edison.NoSuchSimProScienceAppLinkException if a matching sim pro science app link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.SimProScienceAppLink findBySimulationProjectId_Last(
		long simulationProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchSimProScienceAppLinkException {
		return getPersistence()
				   .findBySimulationProjectId_Last(simulationProjectId,
			orderByComparator);
	}

	/**
	* Returns the last sim pro science app link in the ordered set where simulationProjectId = &#63;.
	*
	* @param simulationProjectId the simulation project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sim pro science app link, or <code>null</code> if a matching sim pro science app link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.SimProScienceAppLink fetchBySimulationProjectId_Last(
		long simulationProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySimulationProjectId_Last(simulationProjectId,
			orderByComparator);
	}

	/**
	* Returns the sim pro science app links before and after the current sim pro science app link in the ordered set where simulationProjectId = &#63;.
	*
	* @param simProScienceAppLinkPK the primary key of the current sim pro science app link
	* @param simulationProjectId the simulation project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sim pro science app link
	* @throws org.kisti.edison.NoSuchSimProScienceAppLinkException if a sim pro science app link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.SimProScienceAppLink[] findBySimulationProjectId_PrevAndNext(
		org.kisti.edison.service.persistence.SimProScienceAppLinkPK simProScienceAppLinkPK,
		long simulationProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchSimProScienceAppLinkException {
		return getPersistence()
				   .findBySimulationProjectId_PrevAndNext(simProScienceAppLinkPK,
			simulationProjectId, orderByComparator);
	}

	/**
	* Removes all the sim pro science app links where simulationProjectId = &#63; from the database.
	*
	* @param simulationProjectId the simulation project ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySimulationProjectId(long simulationProjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySimulationProjectId(simulationProjectId);
	}

	/**
	* Returns the number of sim pro science app links where simulationProjectId = &#63;.
	*
	* @param simulationProjectId the simulation project ID
	* @return the number of matching sim pro science app links
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySimulationProjectId(long simulationProjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySimulationProjectId(simulationProjectId);
	}

	/**
	* Caches the sim pro science app link in the entity cache if it is enabled.
	*
	* @param simProScienceAppLink the sim pro science app link
	*/
	public static void cacheResult(
		org.kisti.edison.model.SimProScienceAppLink simProScienceAppLink) {
		getPersistence().cacheResult(simProScienceAppLink);
	}

	/**
	* Caches the sim pro science app links in the entity cache if it is enabled.
	*
	* @param simProScienceAppLinks the sim pro science app links
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.model.SimProScienceAppLink> simProScienceAppLinks) {
		getPersistence().cacheResult(simProScienceAppLinks);
	}

	/**
	* Creates a new sim pro science app link with the primary key. Does not add the sim pro science app link to the database.
	*
	* @param simProScienceAppLinkPK the primary key for the new sim pro science app link
	* @return the new sim pro science app link
	*/
	public static org.kisti.edison.model.SimProScienceAppLink create(
		org.kisti.edison.service.persistence.SimProScienceAppLinkPK simProScienceAppLinkPK) {
		return getPersistence().create(simProScienceAppLinkPK);
	}

	/**
	* Removes the sim pro science app link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param simProScienceAppLinkPK the primary key of the sim pro science app link
	* @return the sim pro science app link that was removed
	* @throws org.kisti.edison.NoSuchSimProScienceAppLinkException if a sim pro science app link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.SimProScienceAppLink remove(
		org.kisti.edison.service.persistence.SimProScienceAppLinkPK simProScienceAppLinkPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchSimProScienceAppLinkException {
		return getPersistence().remove(simProScienceAppLinkPK);
	}

	public static org.kisti.edison.model.SimProScienceAppLink updateImpl(
		org.kisti.edison.model.SimProScienceAppLink simProScienceAppLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(simProScienceAppLink);
	}

	/**
	* Returns the sim pro science app link with the primary key or throws a {@link org.kisti.edison.NoSuchSimProScienceAppLinkException} if it could not be found.
	*
	* @param simProScienceAppLinkPK the primary key of the sim pro science app link
	* @return the sim pro science app link
	* @throws org.kisti.edison.NoSuchSimProScienceAppLinkException if a sim pro science app link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.SimProScienceAppLink findByPrimaryKey(
		org.kisti.edison.service.persistence.SimProScienceAppLinkPK simProScienceAppLinkPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchSimProScienceAppLinkException {
		return getPersistence().findByPrimaryKey(simProScienceAppLinkPK);
	}

	/**
	* Returns the sim pro science app link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param simProScienceAppLinkPK the primary key of the sim pro science app link
	* @return the sim pro science app link, or <code>null</code> if a sim pro science app link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.SimProScienceAppLink fetchByPrimaryKey(
		org.kisti.edison.service.persistence.SimProScienceAppLinkPK simProScienceAppLinkPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(simProScienceAppLinkPK);
	}

	/**
	* Returns all the sim pro science app links.
	*
	* @return the sim pro science app links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.SimProScienceAppLink> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the sim pro science app links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.SimProScienceAppLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sim pro science app links
	* @param end the upper bound of the range of sim pro science app links (not inclusive)
	* @return the range of sim pro science app links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.SimProScienceAppLink> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the sim pro science app links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.SimProScienceAppLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sim pro science app links
	* @param end the upper bound of the range of sim pro science app links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sim pro science app links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.SimProScienceAppLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the sim pro science app links from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of sim pro science app links.
	*
	* @return the number of sim pro science app links
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SimProScienceAppLinkPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SimProScienceAppLinkPersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.service.ClpSerializer.getServletContextName(),
					SimProScienceAppLinkPersistence.class.getName());

			ReferenceRegistry.registerReference(SimProScienceAppLinkUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SimProScienceAppLinkPersistence persistence) {
	}

	private static SimProScienceAppLinkPersistence _persistence;
}