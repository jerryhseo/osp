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

package org.kisti.edison.science.service.base;

import org.kisti.edison.science.service.DeveloperInfoLocalServiceUtil;

import java.util.Arrays;

/**
 * @author EDISON
 * @generated
 */
public class DeveloperInfoLocalServiceClpInvoker {
	public DeveloperInfoLocalServiceClpInvoker() {
		_methodName0 = "addDeveloperInfo";

		_methodParameterTypes0 = new String[] {
				"org.kisti.edison.science.model.DeveloperInfo"
			};

		_methodName1 = "createDeveloperInfo";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteDeveloperInfo";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteDeveloperInfo";

		_methodParameterTypes3 = new String[] {
				"org.kisti.edison.science.model.DeveloperInfo"
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

		_methodName10 = "fetchDeveloperInfo";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getDeveloperInfo";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getDeveloperInfos";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getDeveloperInfosCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateDeveloperInfo";

		_methodParameterTypes15 = new String[] {
				"org.kisti.edison.science.model.DeveloperInfo"
			};

		_methodName164 = "getBeanIdentifier";

		_methodParameterTypes164 = new String[] {  };

		_methodName165 = "setBeanIdentifier";

		_methodParameterTypes165 = new String[] { "java.lang.String" };

		_methodName170 = "getScienceAppDeveloperInfoCount";

		_methodParameterTypes170 = new String[] { "long" };

		_methodName171 = "getListCustomDeveloperInfo";

		_methodParameterTypes171 = new String[] {
				"java.util.Map", "java.util.Locale"
			};

		_methodName172 = "getCountCustomDeveloperInfo";

		_methodParameterTypes172 = new String[] { "java.util.Map" };

		_methodName173 = "getCustomDeveloperInfo";

		_methodParameterTypes173 = new String[] {
				"java.util.Map", "java.util.Locale"
			};

		_methodName174 = "insertCustomDeveloperInfo";

		_methodParameterTypes174 = new String[] { "java.util.Map" };

		_methodName175 = "updateCustomDeveloperInfo";

		_methodParameterTypes175 = new String[] { "java.util.Map" };

		_methodName176 = "deleteCustomDeveloperInfo";

		_methodParameterTypes176 = new String[] { "java.util.Map" };

		_methodName177 = "getDeveloperRequestStatus";

		_methodParameterTypes177 = new String[] {
				"long", "long", "java.lang.String[][]", "java.util.Locale",
				"int", "int"
			};

		_methodName178 = "getCountDeveloperRequestStatus";

		_methodParameterTypes178 = new String[] { "long", "java.lang.String[][]" };

		_methodName179 = "getCountRequestInfo";

		_methodParameterTypes179 = new String[] {
				"long", "java.lang.String[][]", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName180 = "deleteWorkSpace";

		_methodParameterTypes180 = new String[] { "long", "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.addDeveloperInfo((org.kisti.edison.science.model.DeveloperInfo)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.createDeveloperInfo(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.deleteDeveloperInfo(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.deleteDeveloperInfo((org.kisti.edison.science.model.DeveloperInfo)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.fetchDeveloperInfo(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.getDeveloperInfo(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.getDeveloperInfos(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.getDeveloperInfosCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.updateDeveloperInfo((org.kisti.edison.science.model.DeveloperInfo)arguments[0]);
		}

		if (_methodName164.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes164, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName165.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes165, parameterTypes)) {
			DeveloperInfoLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName170.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.getScienceAppDeveloperInfoCount(((Long)arguments[0]).longValue());
		}

		if (_methodName171.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.getListCustomDeveloperInfo((java.util.Map<java.lang.String, java.lang.Object>)arguments[0],
				(java.util.Locale)arguments[1]);
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.getCountCustomDeveloperInfo((java.util.Map<java.lang.String, java.lang.Object>)arguments[0]);
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.getCustomDeveloperInfo((java.util.Map<java.lang.String, java.lang.Object>)arguments[0],
				(java.util.Locale)arguments[1]);
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.insertCustomDeveloperInfo((java.util.Map<java.lang.String, java.lang.Object>)arguments[0]);
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.updateCustomDeveloperInfo((java.util.Map<java.lang.String, java.lang.Object>)arguments[0]);
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.deleteCustomDeveloperInfo((java.util.Map<java.lang.String, java.lang.String>)arguments[0]);
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.getDeveloperRequestStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String[])arguments[2],
				(java.util.Locale)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.getCountDeveloperRequestStatus(((Long)arguments[0]).longValue(),
				(java.lang.String[])arguments[1]);
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			return DeveloperInfoLocalServiceUtil.getCountRequestInfo(((Long)arguments[0]).longValue(),
				(java.lang.String[])arguments[1],
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4]);
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			DeveloperInfoLocalServiceUtil.deleteWorkSpace(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
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
	private String _methodName164;
	private String[] _methodParameterTypes164;
	private String _methodName165;
	private String[] _methodParameterTypes165;
	private String _methodName170;
	private String[] _methodParameterTypes170;
	private String _methodName171;
	private String[] _methodParameterTypes171;
	private String _methodName172;
	private String[] _methodParameterTypes172;
	private String _methodName173;
	private String[] _methodParameterTypes173;
	private String _methodName174;
	private String[] _methodParameterTypes174;
	private String _methodName175;
	private String[] _methodParameterTypes175;
	private String _methodName176;
	private String[] _methodParameterTypes176;
	private String _methodName177;
	private String[] _methodParameterTypes177;
	private String _methodName178;
	private String[] _methodParameterTypes178;
	private String _methodName179;
	private String[] _methodParameterTypes179;
	private String _methodName180;
	private String[] _methodParameterTypes180;
}