<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<link type="text/css" rel="stylesheet" href="${contextPath}/css/main.css" media="screen"/>
<link type="text/css" rel="stylesheet" href="${contextPath}/css/commu.css" media="screen"/>

<liferay-portlet:renderURL var="DataEntrySearchURL" copyCurrentRenderParameters="false" >
	<liferay-portlet:param name="redirectName" value="${redirectName}" />
	<liferay-portlet:param name="redirectURL" value="${redirectURL}" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="manageViewDataEntryURL" copyCurrentRenderParameters="false" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>" >
	<liferay-portlet:param name="myRender" value="manageViewDataEntry" />
	<liferay-portlet:param name="redirectName" value="${redirectName}" />
	<liferay-portlet:param name="redirectURL" value="${redirectURL}" />
</liferay-portlet:renderURL>

<div class="virtitlebox">
	<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
	<div class="virtitle">
<%-- 		<liferay-ui:message key='edison-data-collection-title' /> --%>
		<liferay-ui:message key='edison-default-mysciencedata'/>
	</div>
</div>

<div class="h10"></div>

<div class="tabletopbox clear">
	<div class="search">
		<div class="searchbox">
			<input name="<portlet:namespace/>textfield" type="text"
				id="<portlet:namespace/>textfield"
				placeholder="Data Collection <liferay-ui:message key="edison-table-list-header-name"/>"
				size="40"
				onKeydown="if(event.keyCode ==13)<portlet:namespace/>dataEntryList('');" 
				value="${searchText }"
			/>
			<input type="button" name="fullsize" id="fullsize" value="" class="btnsearch" onclick="<portlet:namespace/>dataEntryList('');">
		</div>
		
		<input type="button" name="fullsize" id="fullsize" value="<liferay-ui:message key="edison-button-all-search"/>" class="button01" onclick="<portlet:namespace/>dataEntryListAllSearch();">
	</div>
	
	<!--우편 셀렉트-->
	<div class="tabletopright">
		<select id="<portlet:namespace/>select_line" name="<portlet:namespace/>select_line" title="옵션" onchange="<portlet:namespace/>dataEntryList(1);" class="selectview" style="line-height: 15px;" s>
<%-- 			<option value="5">5<liferay-ui:message key="edison-search-views"/></option> --%>
			<option value="10">10<liferay-ui:message key="edison-search-views"/></option>
			<option value="15">15<liferay-ui:message key="edison-search-views"/></option>
			<option value="20">20<liferay-ui:message key="edison-search-views"/></option>
		</select>
	</div>
</div> 

<aui:form name="entryForm" method="post">
	<aui:input type="hidden" name="isAdmin" value="${isAdmin }"></aui:input>	
	<aui:input type="hidden" name="groupId" value="${groupId }"></aui:input>
	<div class="table1_list borderno">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" summary="내 사이언스데이터 테이블">
			<colgroup>
				<col width="10%" />
				<col width="25%" />
				<col width="25%" />
				<col width="10%" />
				<col width="10%" />
				<col width="15%" />
			</colgroup>
			<thead>
				<tr>
					<th scope="col"><liferay-ui:message key="edison-table-list-header-index" /></th>
					<th scope="col">Data Entry</th>
					<th scope="col">Data Collection</th>
					<th scope="col"><liferay-ui:message key="edison-table-list-header-version"/></th>
					<th scope="col"><liferay-ui:message key="edison-create-account-field-title-name"/></th>
					<th scope="col"><liferay-ui:message key="edison-table-list-header-date"/></th>
				</tr>
			</thead>
			<tbody id="dataEntryTableBody">
				<c:choose>
					<c:when test="${fn:length(dataEntryList) == 0 }">
						<tr>
							<td class="TC" colspan="6"><liferay-ui:message key="edison-there-are-no-data"/></td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="dataEntry" items="${dataEntryList }" varStatus="status">
							<c:if test="${status.index % 2 == 1}">
								<tr class="tablebgtr" onclick="<portlet:namespace/>moveEntryMgt('${dataEntry.entryId }');" style="word-break: break-all; cursor: pointer;">
							</c:if>
							<c:if test="${status.index % 2 == 0}">
								<tr onclick="<portlet:namespace/>moveEntryMgt('${dataEntry.entryId }');" style="word-break: break-all; cursor: pointer;">
							</c:if>
									<td class="TC">${seq - status.index }</td>
									<td>${dataEntry.fileEntry.title }</td>
									<td>${dataEntry.dataCollection.name } </td>
									<td class="TC">V${dataEntry.dataCollection.version } </td>
									<td class="TC">${dataEntry.screenName } </td>
									<td class="TC">${dataEntry.createDate } </td>
								</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>

	<div class="paging">
		<div id="<portlet:namespace/>paging" style="width:100%;text-align: center;">${paging }</div>
	</div>
	
	<div class="buttonbox" style="position: absolute; bottom: 24px; width:auto; right:1%;" id="<portlet:namespace/>createCollection">
		<input type="button" class="button06" value="<liferay-ui:message key="edison-virtuallab-virtualLabClassManagement-class-create" />" onclick="<portlet:namespace/>createDataEntry()"/>
	</div>
</aui:form>



<script>
$(function(){
	$("#<portlet:namespace/>select_line").val('${searchLine}');
})

var currentPage = 0;
function <portlet:namespace/>dataEntryListAllSearch(){
	 $("#<portlet:namespace/>textfield").val("");
	 <portlet:namespace/>dataEntryList('');
}
function <portlet:namespace/>dataEntryList(p_currentPage){
	currentPage = p_currentPage;
	var searchParameter = <portlet:namespace/>createSearchParameterSting('');
	location.href="<%=DataEntrySearchURL%>"+searchParameter;
}


function <portlet:namespace/>createDataEntry(){
	var mode = "<%=Constants.ADD%>";
	var searchParameter = <portlet:namespace/>createSearchParameterSting(mode);
	location.href="<%=manageViewDataEntryURL%>"+searchParameter;
}

function <portlet:namespace/>moveEntryMgt(entryId){
	var mode = "<%=Constants.UPDATE%>";
	var searchParameter = <portlet:namespace/>createSearchParameterSting(mode);
	searchParameter += "&<portlet:namespace/>dataEntryId="+entryId;
	location.href="<%=manageViewDataEntryURL%>"+searchParameter;
}
function <portlet:namespace/>createSearchParameterSting(mode){
	
	var searchText = $("#<portlet:namespace/>textfield").val();
	var searchLine = $("#<portlet:namespace/>select_line").val();
	var groupId = $("#<portlet:namespace/>groupId").val();
	var isAdmin = $("#<portlet:namespace/>isAdmin").val();
	
	var searchParameter = "";
	if( searchText !="")searchParameter += "&<portlet:namespace/>searchText="+searchText;
	if( mode != "" ) searchParameter += "&<portlet:namespace/>mode="+mode;
	
	searchParameter += "&<portlet:namespace/>groupId="+groupId;
	searchParameter += "&<portlet:namespace/>isAdmin="+isAdmin;
	searchParameter += "&<portlet:namespace/>currentPage="+currentPage;
	searchParameter += "&<portlet:namespace/>searchLine="+searchLine;
	
	return searchParameter;
}
</script>