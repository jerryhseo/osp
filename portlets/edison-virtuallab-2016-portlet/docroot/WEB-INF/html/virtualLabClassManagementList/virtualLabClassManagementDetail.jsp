<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<body>
	<div class="columns-1-2-1" id="main-content" role="main">
    <div class="portlet-layout row-fluid">
        <div class="portlet-column portlet-column-only span12" id="column-1">
            <liferay-portlet:runtime portletName="edisonvirtuallabclassmainvisual_WAR_edisonvirtuallab2016portlet_INSTANCE_44oBtU3CyBWo"  queryString="&classId=${classId}&groupId=${groupId}" />
        </div>
    </div>
    <div class="portlet-layout row-fluid">
        <div class="portlet-column portlet-column-only span12" id="column-3">
            <liferay-portlet:runtime portletName="edisonvirtuallabclasssurvey_WAR_edisonvirtuallab2016portlet"  queryString="&classId=${classId}&groupId=${groupId}" />
        </div>
    </div>
	<div class="portlet-layout row-fluid">
        <div class="portlet-column portlet-column-only span12" id="column-2">
            <liferay-portlet:runtime portletName="edisonvirtuallabclassscienceapplist_WAR_edisonvirtuallab2016portlet"  queryString="&classId=${classId}&groupId=${groupId}" />
        </div>
    </div>
	<div class="portlet-layout row-fluid">
        <div class="portlet-column portlet-column-only span12" id="column-2">
            <liferay-portlet:runtime portletName="edisonvirtuallabclassnote_WAR_edisonvirtuallab2016portlet"  queryString="&classId=${classId}&groupId=${groupId}" />
        </div>
    </div>
    
    <div class="portlet-layout row-fluid">
        <div class="portlet-column portlet-column-first span6" id="column-4">
            <liferay-portlet:runtime portletName="edisonmultiboard_WAR_edisonboard2016portlet_INSTANCE_qY3mIhmesY9r"  queryString="&customId=class_${classId}&boardGroupId=${groupId}&redirectName=${classTitle}&redirectURL=${redirectURL}&isCustomAdmin=${isCustomAdmin }" />
        </div>

        <div class="portlet-column portlet-column-last span6" id="column-5">
            <liferay-portlet:runtime portletName="edisonmultiboard_WAR_edisonboard2016portlet_INSTANCE_HRmNo2UFaZ1Z"  queryString="&customId=class_${classId}&boardGroupId=${groupId}&redirectName=${classTitle}&redirectURL=${redirectURL}&isDefaultUserWrite=${isDefaultUserWrite}&isCustomAdmin=${isCustomAdmin }" />
        </div>
    </div>
    
    <div class="portlet-layout row-fluid">
        <div class="portlet-column portlet-column-only span12" id="column-6">
            <liferay-portlet:runtime portletName="edisonvirtuallabclassstudentmanagement_WAR_edisonvirtuallab2016portlet"   queryString="&classId=${classId}&groupId=${groupId}" />
        </div>
    </div>
</div>
