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

package org.kisti.edison.service.base;

import org.kisti.edison.service.WorkflowSimulationJobLocalServiceUtil;

import java.util.Arrays;

/**
 * @author EDISON
 * @generated
 */
public class WorkflowSimulationJobLocalServiceClpInvoker {
	public WorkflowSimulationJobLocalServiceClpInvoker() {
		_methodName0 = "addWorkflowSimulationJob";

		_methodParameterTypes0 = new String[] {
				"org.kisti.edison.model.WorkflowSimulationJob"
			};

		_methodName1 = "createWorkflowSimulationJob";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteWorkflowSimulationJob";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteWorkflowSimulationJob";

		_methodParameterTypes3 = new String[] {
				"org.kisti.edison.model.WorkflowSimulationJob"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchWorkflowSimulationJob";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getWorkflowSimulationJob";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getWorkflowSimulationJobs";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getWorkflowSimulationJobsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateWorkflowSimulationJob";

		_methodParameterTypes15 = new String[] {
				"org.kisti.edison.model.WorkflowSimulationJob"
			};

		_methodName16 = "addWorkflowSimulationWorkflowSimulationJob";

		_methodParameterTypes16 = new String[] { "long", "long" };

		_methodName17 = "addWorkflowSimulationWorkflowSimulationJob";

		_methodParameterTypes17 = new String[] {
				"long", "org.kisti.edison.model.WorkflowSimulationJob"
			};

		_methodName18 = "addWorkflowSimulationWorkflowSimulationJobs";

		_methodParameterTypes18 = new String[] { "long", "long[][]" };

		_methodName19 = "addWorkflowSimulationWorkflowSimulationJobs";

		_methodParameterTypes19 = new String[] { "long", "java.util.List" };

		_methodName20 = "clearWorkflowSimulationWorkflowSimulationJobs";

		_methodParameterTypes20 = new String[] { "long" };

		_methodName21 = "deleteWorkflowSimulationWorkflowSimulationJob";

		_methodParameterTypes21 = new String[] { "long", "long" };

		_methodName22 = "deleteWorkflowSimulationWorkflowSimulationJob";

		_methodParameterTypes22 = new String[] {
				"long", "org.kisti.edison.model.WorkflowSimulationJob"
			};

		_methodName23 = "deleteWorkflowSimulationWorkflowSimulationJobs";

		_methodParameterTypes23 = new String[] { "long", "long[][]" };

		_methodName24 = "deleteWorkflowSimulationWorkflowSimulationJobs";

		_methodParameterTypes24 = new String[] { "long", "java.util.List" };

		_methodName25 = "getWorkflowSimulationWorkflowSimulationJobs";

		_methodParameterTypes25 = new String[] { "long" };

		_methodName26 = "getWorkflowSimulationWorkflowSimulationJobs";

		_methodParameterTypes26 = new String[] { "long", "int", "int" };

		_methodName27 = "getWorkflowSimulationWorkflowSimulationJobs";

		_methodParameterTypes27 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName28 = "getWorkflowSimulationWorkflowSimulationJobsCount";

		_methodParameterTypes28 = new String[] { "long" };

		_methodName29 = "hasWorkflowSimulationWorkflowSimulationJob";

		_methodParameterTypes29 = new String[] { "long", "long" };

		_methodName30 = "hasWorkflowSimulationWorkflowSimulationJobs";

		_methodParameterTypes30 = new String[] { "long" };

		_methodName31 = "setWorkflowSimulationWorkflowSimulationJobs";

		_methodParameterTypes31 = new String[] { "long", "long[][]" };

		_methodName58 = "getBeanIdentifier";

		_methodParameterTypes58 = new String[] {  };

		_methodName59 = "setBeanIdentifier";

		_methodParameterTypes59 = new String[] { "java.lang.String" };

		_methodName64 = "getWorkflowSimulationJobs";

		_methodParameterTypes64 = new String[] {
				"long", "java.lang.String", "long", "int", "int"
			};

		_methodName65 = "countWorkflowSimulationJobs";

		_methodParameterTypes65 = new String[] {
				"long", "java.lang.String", "long"
			};

		_methodName66 = "updateWorkflowSimulationJob";

		_methodParameterTypes66 = new String[] { "long", "java.util.Map" };

		_methodName67 = "createWorkflowSimulationJob";

		_methodParameterTypes67 = new String[] {
				"long", "java.util.Map", "javax.servlet.http.HttpServletRequest"
			};

		_methodName69 = "getSimulationJobSeq";

		_methodParameterTypes69 = new String[] { "long" };

		_methodName70 = "createSimulationJob";

		_methodParameterTypes70 = new String[] {
				"org.kisti.edison.model.WorkflowSimulation",
				"org.kisti.edison.model.Workflow", "java.lang.String"
			};

		_methodName71 = "createWorkflowSimulationJob";

		_methodParameterTypes71 = new String[] {  };

		_methodName72 = "createWorkflowSimulationJob";

		_methodParameterTypes72 = new String[] {
				"org.kisti.edison.model.WorkflowSimulationJob"
			};

		_methodName74 = "startWorkflowSimulationJob";

		_methodParameterTypes74 = new String[] { "long" };

		_methodName75 = "startWorkflowSimulationJob";

		_methodParameterTypes75 = new String[] {
				"org.kisti.edison.model.WorkflowSimulationJob"
			};

		_methodName76 = "askForWorkflowStart";

		_methodParameterTypes76 = new String[] { "java.lang.String" };

		_methodName77 = "getWorkflowStatus";

		_methodParameterTypes77 = new String[] { "long" };

		_methodName78 = "deleteSimulationAndJobs";

		_methodParameterTypes78 = new String[] { "long" };

		_methodName79 = "deleteWorkflowSimulationJobWitEngine";

		_methodParameterTypes79 = new String[] { "long" };

		_methodName80 = "deleteWorkflowSimulationJobWitEngine";

		_methodParameterTypes80 = new String[] {
				"org.kisti.edison.model.WorkflowSimulationJob"
			};

		_methodName81 = "pauseWorkflowSimulationJob";

		_methodParameterTypes81 = new String[] { "long" };

		_methodName82 = "resumeWorkflowSimulationJob";

		_methodParameterTypes82 = new String[] { "long" };

		_methodName83 = "updateWorkflowSimulationJob";

		_methodParameterTypes83 = new String[] {
				"org.codehaus.jackson.JsonNode",
				"org.kisti.edison.model.WorkflowSimulationJob"
			};

		_methodName84 = "askForWorkflowStatus";

		_methodParameterTypes84 = new String[] { "java.lang.String" };

		_methodName86 = "getWorkflowSimulationLog";

		_methodParameterTypes86 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName87 = "getWorkflowSimulationErrorLog";

		_methodParameterTypes87 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName89 = "getWorkflowJobIntermediateResult";

		_methodParameterTypes89 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName94 = "downloadFileApi";

		_methodParameterTypes94 = new String[] {
				"com.liferay.portal.model.User", "long",
				"com.liferay.portal.kernel.json.JSONObject"
			};

		_methodName97 = "uploadFileToIcebreaker";

		_methodParameterTypes97 = new String[] {
				"long", "java.lang.String", "java.io.File"
			};

		_methodName98 = "uploadFileToIcebreaker";

		_methodParameterTypes98 = new String[] {
				"long", "java.lang.String", "java.io.InputStream"
			};

		_methodName99 = "uploadFileToIcebreaker";

		_methodParameterTypes99 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName100 = "getCountWorkflowSimulationJobByUserId";

		_methodParameterTypes100 = new String[] {
				"com.liferay.portal.model.User", "java.util.Map"
			};

		_methodName101 = "getWorkflowSimulationJobByUserId";

		_methodParameterTypes101 = new String[] {
				"com.liferay.portal.model.User", "java.util.Map",
				"java.util.Locale"
			};

		_methodName102 = "getDataTypeEditors";

		_methodParameterTypes102 = new String[] {
				"com.kisti.osp.icecap.model.DataType"
			};

		_methodName103 = "getDataTypeDefaultEditor";

		_methodParameterTypes103 = new String[] {
				"com.kisti.osp.icecap.model.DataType"
			};

		_methodName104 = "getDataTypeDefaultAnalyzer";

		_methodParameterTypes104 = new String[] {
				"com.kisti.osp.icecap.model.DataType"
			};

		_methodName105 = "getDataTypeAnalyzers";

		_methodParameterTypes105 = new String[] {
				"com.kisti.osp.icecap.model.DataType"
			};

		_methodName106 = "getRootSiteAssetCategries";

		_methodParameterTypes106 = new String[] { "long", "long" };

		_methodName107 = "getSiteAssetCategoriesByParentId";

		_methodParameterTypes107 = new String[] { "long", "long", "long" };

		_methodName110 = "getLv1Categories";

		_methodParameterTypes110 = new String[] {
				"long", "long", "java.util.Locale"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.addWorkflowSimulationJob((org.kisti.edison.model.WorkflowSimulationJob)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.createWorkflowSimulationJob(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.deleteWorkflowSimulationJob(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.deleteWorkflowSimulationJob((org.kisti.edison.model.WorkflowSimulationJob)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.fetchWorkflowSimulationJob(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getWorkflowSimulationJob(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getWorkflowSimulationJobs(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getWorkflowSimulationJobsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.updateWorkflowSimulationJob((org.kisti.edison.model.WorkflowSimulationJob)arguments[0]);
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			WorkflowSimulationJobLocalServiceUtil.addWorkflowSimulationWorkflowSimulationJob(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			WorkflowSimulationJobLocalServiceUtil.addWorkflowSimulationWorkflowSimulationJob(((Long)arguments[0]).longValue(),
				(org.kisti.edison.model.WorkflowSimulationJob)arguments[1]);

			return null;
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			WorkflowSimulationJobLocalServiceUtil.addWorkflowSimulationWorkflowSimulationJobs(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			WorkflowSimulationJobLocalServiceUtil.addWorkflowSimulationWorkflowSimulationJobs(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.model.WorkflowSimulationJob>)arguments[1]);

			return null;
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			WorkflowSimulationJobLocalServiceUtil.clearWorkflowSimulationWorkflowSimulationJobs(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			WorkflowSimulationJobLocalServiceUtil.deleteWorkflowSimulationWorkflowSimulationJob(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			WorkflowSimulationJobLocalServiceUtil.deleteWorkflowSimulationWorkflowSimulationJob(((Long)arguments[0]).longValue(),
				(org.kisti.edison.model.WorkflowSimulationJob)arguments[1]);

			return null;
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			WorkflowSimulationJobLocalServiceUtil.deleteWorkflowSimulationWorkflowSimulationJobs(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			WorkflowSimulationJobLocalServiceUtil.deleteWorkflowSimulationWorkflowSimulationJobs(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.model.WorkflowSimulationJob>)arguments[1]);

			return null;
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getWorkflowSimulationWorkflowSimulationJobs(((Long)arguments[0]).longValue());
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getWorkflowSimulationWorkflowSimulationJobs(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getWorkflowSimulationWorkflowSimulationJobs(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getWorkflowSimulationWorkflowSimulationJobsCount(((Long)arguments[0]).longValue());
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.hasWorkflowSimulationWorkflowSimulationJob(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.hasWorkflowSimulationWorkflowSimulationJobs(((Long)arguments[0]).longValue());
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			WorkflowSimulationJobLocalServiceUtil.setWorkflowSimulationWorkflowSimulationJobs(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			WorkflowSimulationJobLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getWorkflowSimulationJobs(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.countWorkflowSimulationJobs(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.updateWorkflowSimulationJob(((Long)arguments[0]).longValue(),
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1]);
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.createWorkflowSimulationJob(((Long)arguments[0]).longValue(),
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(javax.servlet.http.HttpServletRequest)arguments[2]);
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getSimulationJobSeq(((Long)arguments[0]).longValue());
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.createSimulationJob((org.kisti.edison.model.WorkflowSimulation)arguments[0],
				(org.kisti.edison.model.Workflow)arguments[1],
				(java.lang.String)arguments[2]);
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.createWorkflowSimulationJob();
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.createWorkflowSimulationJob((org.kisti.edison.model.WorkflowSimulationJob)arguments[0]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.startWorkflowSimulationJob(((Long)arguments[0]).longValue());
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.startWorkflowSimulationJob((org.kisti.edison.model.WorkflowSimulationJob)arguments[0]);
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.askForWorkflowStart((java.lang.String)arguments[0]);
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getWorkflowStatus(((Long)arguments[0]).longValue());
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.deleteSimulationAndJobs(((Long)arguments[0]).longValue());
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.deleteWorkflowSimulationJobWitEngine(((Long)arguments[0]).longValue());
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.deleteWorkflowSimulationJobWitEngine((org.kisti.edison.model.WorkflowSimulationJob)arguments[0]);
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.pauseWorkflowSimulationJob(((Long)arguments[0]).longValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.resumeWorkflowSimulationJob(((Long)arguments[0]).longValue());
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.updateWorkflowSimulationJob((org.codehaus.jackson.JsonNode)arguments[0],
				(org.kisti.edison.model.WorkflowSimulationJob)arguments[1]);
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.askForWorkflowStatus((java.lang.String)arguments[0]);
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getWorkflowSimulationLog((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getWorkflowSimulationErrorLog((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getWorkflowJobIntermediateResult((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.downloadFileApi((com.liferay.portal.model.User)arguments[0],
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.kernel.json.JSONObject)arguments[2]);
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.uploadFileToIcebreaker(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.io.File)arguments[2]);
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.uploadFileToIcebreaker(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				(java.io.InputStream)arguments[2]);
		}

		if (_methodName99.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.uploadFileToIcebreaker(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName100.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getCountWorkflowSimulationJobByUserId((com.liferay.portal.model.User)arguments[0],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1]);
		}

		if (_methodName101.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getWorkflowSimulationJobByUserId((com.liferay.portal.model.User)arguments[0],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(java.util.Locale)arguments[2]);
		}

		if (_methodName102.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getDataTypeEditors((com.kisti.osp.icecap.model.DataType)arguments[0]);
		}

		if (_methodName103.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes103, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getDataTypeDefaultEditor((com.kisti.osp.icecap.model.DataType)arguments[0]);
		}

		if (_methodName104.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getDataTypeDefaultAnalyzer((com.kisti.osp.icecap.model.DataType)arguments[0]);
		}

		if (_methodName105.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getDataTypeAnalyzers((com.kisti.osp.icecap.model.DataType)arguments[0]);
		}

		if (_methodName106.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getRootSiteAssetCategries(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName107.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getSiteAssetCategoriesByParentId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return WorkflowSimulationJobLocalServiceUtil.getLv1Categories(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.util.Locale)arguments[2]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName84;
	private String[] _methodParameterTypes84;
	private String _methodName86;
	private String[] _methodParameterTypes86;
	private String _methodName87;
	private String[] _methodParameterTypes87;
	private String _methodName89;
	private String[] _methodParameterTypes89;
	private String _methodName94;
	private String[] _methodParameterTypes94;
	private String _methodName97;
	private String[] _methodParameterTypes97;
	private String _methodName98;
	private String[] _methodParameterTypes98;
	private String _methodName99;
	private String[] _methodParameterTypes99;
	private String _methodName100;
	private String[] _methodParameterTypes100;
	private String _methodName101;
	private String[] _methodParameterTypes101;
	private String _methodName102;
	private String[] _methodParameterTypes102;
	private String _methodName103;
	private String[] _methodParameterTypes103;
	private String _methodName104;
	private String[] _methodParameterTypes104;
	private String _methodName105;
	private String[] _methodParameterTypes105;
	private String _methodName106;
	private String[] _methodParameterTypes106;
	private String _methodName107;
	private String[] _methodParameterTypes107;
	private String _methodName110;
	private String[] _methodParameterTypes110;
}