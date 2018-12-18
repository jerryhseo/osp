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

import com.liferay.portal.service.persistence.BasePersistence;

import org.kisti.edison.model.WorkflowSimulationJob;

/**
 * The persistence interface for the workflow simulation job service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see WorkflowSimulationJobPersistenceImpl
 * @see WorkflowSimulationJobUtil
 * @generated
 */
public interface WorkflowSimulationJobPersistence extends BasePersistence<WorkflowSimulationJob> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkflowSimulationJobUtil} to access the workflow simulation job persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the workflow simulation jobs where title LIKE &#63;.
	*
	* @param title the title
	* @return the matching workflow simulation jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.model.WorkflowSimulationJob> findByTitle(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the workflow simulation jobs where title LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowSimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of workflow simulation jobs
	* @param end the upper bound of the range of workflow simulation jobs (not inclusive)
	* @return the range of matching workflow simulation jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.model.WorkflowSimulationJob> findByTitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the workflow simulation jobs where title LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowSimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of workflow simulation jobs
	* @param end the upper bound of the range of workflow simulation jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching workflow simulation jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.model.WorkflowSimulationJob> findByTitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first workflow simulation job in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow simulation job
	* @throws org.kisti.edison.NoSuchWorkflowSimulationJobException if a matching workflow simulation job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.WorkflowSimulationJob findByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowSimulationJobException;

	/**
	* Returns the first workflow simulation job in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow simulation job, or <code>null</code> if a matching workflow simulation job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.WorkflowSimulationJob fetchByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last workflow simulation job in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow simulation job
	* @throws org.kisti.edison.NoSuchWorkflowSimulationJobException if a matching workflow simulation job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.WorkflowSimulationJob findByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowSimulationJobException;

	/**
	* Returns the last workflow simulation job in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow simulation job, or <code>null</code> if a matching workflow simulation job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.WorkflowSimulationJob fetchByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the workflow simulation jobs before and after the current workflow simulation job in the ordered set where title LIKE &#63;.
	*
	* @param simulationJobId the primary key of the current workflow simulation job
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next workflow simulation job
	* @throws org.kisti.edison.NoSuchWorkflowSimulationJobException if a workflow simulation job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.WorkflowSimulationJob[] findByTitle_PrevAndNext(
		long simulationJobId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowSimulationJobException;

	/**
	* Removes all the workflow simulation jobs where title LIKE &#63; from the database.
	*
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of workflow simulation jobs where title LIKE &#63;.
	*
	* @param title the title
	* @return the number of matching workflow simulation jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the workflow simulation jobs where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching workflow simulation jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.model.WorkflowSimulationJob> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the workflow simulation jobs where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowSimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of workflow simulation jobs
	* @param end the upper bound of the range of workflow simulation jobs (not inclusive)
	* @return the range of matching workflow simulation jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.model.WorkflowSimulationJob> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the workflow simulation jobs where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowSimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of workflow simulation jobs
	* @param end the upper bound of the range of workflow simulation jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching workflow simulation jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.model.WorkflowSimulationJob> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first workflow simulation job in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow simulation job
	* @throws org.kisti.edison.NoSuchWorkflowSimulationJobException if a matching workflow simulation job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.WorkflowSimulationJob findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowSimulationJobException;

	/**
	* Returns the first workflow simulation job in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow simulation job, or <code>null</code> if a matching workflow simulation job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.WorkflowSimulationJob fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last workflow simulation job in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow simulation job
	* @throws org.kisti.edison.NoSuchWorkflowSimulationJobException if a matching workflow simulation job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.WorkflowSimulationJob findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowSimulationJobException;

	/**
	* Returns the last workflow simulation job in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow simulation job, or <code>null</code> if a matching workflow simulation job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.WorkflowSimulationJob fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the workflow simulation jobs before and after the current workflow simulation job in the ordered set where userId = &#63;.
	*
	* @param simulationJobId the primary key of the current workflow simulation job
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next workflow simulation job
	* @throws org.kisti.edison.NoSuchWorkflowSimulationJobException if a workflow simulation job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.WorkflowSimulationJob[] findByUserId_PrevAndNext(
		long simulationJobId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowSimulationJobException;

	/**
	* Removes all the workflow simulation jobs where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of workflow simulation jobs where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching workflow simulation jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the workflow simulation job in the entity cache if it is enabled.
	*
	* @param workflowSimulationJob the workflow simulation job
	*/
	public void cacheResult(
		org.kisti.edison.model.WorkflowSimulationJob workflowSimulationJob);

	/**
	* Caches the workflow simulation jobs in the entity cache if it is enabled.
	*
	* @param workflowSimulationJobs the workflow simulation jobs
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.model.WorkflowSimulationJob> workflowSimulationJobs);

	/**
	* Creates a new workflow simulation job with the primary key. Does not add the workflow simulation job to the database.
	*
	* @param simulationJobId the primary key for the new workflow simulation job
	* @return the new workflow simulation job
	*/
	public org.kisti.edison.model.WorkflowSimulationJob create(
		long simulationJobId);

	/**
	* Removes the workflow simulation job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param simulationJobId the primary key of the workflow simulation job
	* @return the workflow simulation job that was removed
	* @throws org.kisti.edison.NoSuchWorkflowSimulationJobException if a workflow simulation job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.WorkflowSimulationJob remove(
		long simulationJobId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowSimulationJobException;

	public org.kisti.edison.model.WorkflowSimulationJob updateImpl(
		org.kisti.edison.model.WorkflowSimulationJob workflowSimulationJob)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the workflow simulation job with the primary key or throws a {@link org.kisti.edison.NoSuchWorkflowSimulationJobException} if it could not be found.
	*
	* @param simulationJobId the primary key of the workflow simulation job
	* @return the workflow simulation job
	* @throws org.kisti.edison.NoSuchWorkflowSimulationJobException if a workflow simulation job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.WorkflowSimulationJob findByPrimaryKey(
		long simulationJobId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowSimulationJobException;

	/**
	* Returns the workflow simulation job with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param simulationJobId the primary key of the workflow simulation job
	* @return the workflow simulation job, or <code>null</code> if a workflow simulation job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.WorkflowSimulationJob fetchByPrimaryKey(
		long simulationJobId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the workflow simulation jobs.
	*
	* @return the workflow simulation jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.model.WorkflowSimulationJob> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the workflow simulation jobs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowSimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workflow simulation jobs
	* @param end the upper bound of the range of workflow simulation jobs (not inclusive)
	* @return the range of workflow simulation jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.model.WorkflowSimulationJob> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the workflow simulation jobs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowSimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workflow simulation jobs
	* @param end the upper bound of the range of workflow simulation jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of workflow simulation jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.model.WorkflowSimulationJob> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the workflow simulation jobs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of workflow simulation jobs.
	*
	* @return the number of workflow simulation jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the workflows associated with the workflow simulation job.
	*
	* @param pk the primary key of the workflow simulation job
	* @return the workflows associated with the workflow simulation job
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.model.Workflow> getWorkflows(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the workflows associated with the workflow simulation job.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowSimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the workflow simulation job
	* @param start the lower bound of the range of workflow simulation jobs
	* @param end the upper bound of the range of workflow simulation jobs (not inclusive)
	* @return the range of workflows associated with the workflow simulation job
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.model.Workflow> getWorkflows(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the workflows associated with the workflow simulation job.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowSimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the workflow simulation job
	* @param start the lower bound of the range of workflow simulation jobs
	* @param end the upper bound of the range of workflow simulation jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of workflows associated with the workflow simulation job
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.model.Workflow> getWorkflows(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of workflows associated with the workflow simulation job.
	*
	* @param pk the primary key of the workflow simulation job
	* @return the number of workflows associated with the workflow simulation job
	* @throws SystemException if a system exception occurred
	*/
	public int getWorkflowsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the workflow is associated with the workflow simulation job.
	*
	* @param pk the primary key of the workflow simulation job
	* @param workflowPK the primary key of the workflow
	* @return <code>true</code> if the workflow is associated with the workflow simulation job; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsWorkflow(long pk, long workflowPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the workflow simulation job has any workflows associated with it.
	*
	* @param pk the primary key of the workflow simulation job to check for associations with workflows
	* @return <code>true</code> if the workflow simulation job has any workflows associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsWorkflows(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the workflow simulation job and the workflow. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow simulation job
	* @param workflowPK the primary key of the workflow
	* @throws SystemException if a system exception occurred
	*/
	public void addWorkflow(long pk, long workflowPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the workflow simulation job and the workflow. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow simulation job
	* @param workflow the workflow
	* @throws SystemException if a system exception occurred
	*/
	public void addWorkflow(long pk, org.kisti.edison.model.Workflow workflow)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the workflow simulation job and the workflows. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow simulation job
	* @param workflowPKs the primary keys of the workflows
	* @throws SystemException if a system exception occurred
	*/
	public void addWorkflows(long pk, long[] workflowPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the workflow simulation job and the workflows. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow simulation job
	* @param workflows the workflows
	* @throws SystemException if a system exception occurred
	*/
	public void addWorkflows(long pk,
		java.util.List<org.kisti.edison.model.Workflow> workflows)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the workflow simulation job and its workflows. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow simulation job to clear the associated workflows from
	* @throws SystemException if a system exception occurred
	*/
	public void clearWorkflows(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the workflow simulation job and the workflow. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow simulation job
	* @param workflowPK the primary key of the workflow
	* @throws SystemException if a system exception occurred
	*/
	public void removeWorkflow(long pk, long workflowPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the workflow simulation job and the workflow. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow simulation job
	* @param workflow the workflow
	* @throws SystemException if a system exception occurred
	*/
	public void removeWorkflow(long pk, org.kisti.edison.model.Workflow workflow)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the workflow simulation job and the workflows. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow simulation job
	* @param workflowPKs the primary keys of the workflows
	* @throws SystemException if a system exception occurred
	*/
	public void removeWorkflows(long pk, long[] workflowPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the workflow simulation job and the workflows. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow simulation job
	* @param workflows the workflows
	* @throws SystemException if a system exception occurred
	*/
	public void removeWorkflows(long pk,
		java.util.List<org.kisti.edison.model.Workflow> workflows)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the workflows associated with the workflow simulation job, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow simulation job
	* @param workflowPKs the primary keys of the workflows to be associated with the workflow simulation job
	* @throws SystemException if a system exception occurred
	*/
	public void setWorkflows(long pk, long[] workflowPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the workflows associated with the workflow simulation job, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow simulation job
	* @param workflows the workflows to be associated with the workflow simulation job
	* @throws SystemException if a system exception occurred
	*/
	public void setWorkflows(long pk,
		java.util.List<org.kisti.edison.model.Workflow> workflows)
		throws com.liferay.portal.kernel.exception.SystemException;
}