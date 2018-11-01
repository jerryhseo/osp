<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>

<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<c:set var="contextPath" value="<%=request.getContextPath() %>" scope="page" />
<link type="text/css" rel="stylesheet" href="${contextPath}/css/scienceappmanager.css" media="screen"/>

<%
	String clickTab = GetterUtil.get(request.getParameter("clickTab"), "m01");
	String jspFile = "";
	if(clickTab.equals("m01")){
		jspFile = "app_infomation";
	}else if(clickTab.equals("m02")){
		jspFile = "execute_infomation";
	}else if(clickTab.equals("m03")){
		jspFile = "port_infomation";
	}else if(clickTab.equals("m04")){
		jspFile = "app_layout";
	}else if(clickTab.equals("m05")){
		jspFile = "public_infomation";
	}
	
%>

<liferay-portlet:renderURL var="listURL" copyCurrentRenderParameters="<%=false%>" portletMode='view'>
	<portlet:param name="searchValue" value="${searchValue}"/>
	<portlet:param name="searchOption" value="${searchOption}"/>
	<portlet:param name="searchStatus" value="${searchStatus}"/>
	<portlet:param name="p_curPage" 	value="${p_curPage}" />
</liferay-portlet:renderURL>


<liferay-portlet:renderURL var="solverRenderURL" copyCurrentRenderParameters="<%=true%>" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>"/>


<liferay-portlet:resourceURL var="edisonFileDownloadURL" escapeXml="false" id="edisonFileDownload" copyCurrentRenderParameters="false"/>

<liferay-portlet:resourceURL var="deleteFileURL" escapeXml="false" id="deleteFile" copyCurrentRenderParameters="false">
	<portlet:param name="scienceAppId" value="${scienceAppId}"/>
</liferay-portlet:resourceURL>

<liferay-portlet:resourceURL var="updateAppStatusURL" escapeXml="false" id="updateAppStatus" copyCurrentRenderParameters="false">
	<portlet:param name="scienceAppId" value="${scienceAppId}"/>
</liferay-portlet:resourceURL>

<liferay-portlet:resourceURL var="copyScienceAppURL" escapeXml="false" id="copyScienceApp" copyCurrentRenderParameters="false">
	<portlet:param name="scienceAppId" value="${scienceAppId}"/>
	
	
</liferay-portlet:resourceURL>

<liferay-portlet:renderURL var="newAppRenderURL" copyCurrentRenderParameters="<%=false%>">	
	<portlet:param name="myRender" value="solverRender" />
	<portlet:param name="searchValue" value="${searchValue}"/>
	<portlet:param name="searchOption" value="${searchOption}"/>
	<portlet:param name="searchStatus" value="${searchStatus}"/>
	<portlet:param name="p_curPage" 	value="${p_curPage}" />
	
	<portlet:param name="redirectURL" 	value="${redirectURL}" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="appTestURL" plid="${workBenchPlid}" portletName="SimulationWorkbench_WAR_OSPWorkbenchportlet" windowState="<%=LiferayWindowState.POP_UP.toString()%>" portletMode="<%=LiferayPortletMode.VIEW.toString()%>">
	<liferay-portlet:param name="workbenchType" value="SIMULATION_WITH_APP"/>
	<liferay-portlet:param name="scienceAppId" value="${scienceAppId}"/>
	
	<portlet:param name="redirectURL" 	value="${redirectURL}"/>
	<portlet:param name="redirectName" 	value="MY EDISON" />
</liferay-portlet:renderURL>
	
<%
    String renderUrl = HttpUtil.removeParameter(solverRenderURL, renderResponse.getNamespace()+"clickTab");
%>
<style type="text/css">
	.no-dialog-padding .ui-dialog-content{
		padding : 0px;
	}
</style>
<div class="container">
	<div class="swleft">
		${tabStr}
	</div>
	<div class="swrightcont">
		<liferay-util:include page='<%= "/WEB-INF/html/appmanager/" + jspFile + ".jsp" %>' servletContext="<%=this.getServletContext() %>">
		</liferay-util:include>
	</div>
</div>

<link media="all" rel="stylesheet" href="${contextPath}/css/jquery-confirm.css" />
<script src="${contextPath}/js/jquery-confirm.js"></script>

<script type="text/javascript">
	function tabAction(tabValue){
		var searchParameter = "";
		searchParameter += "&<portlet:namespace/>clickTab="+tabValue;
		location.href="<%=renderUrl%>"+searchParameter;
	}
	function <portlet:namespace/>statusSubmit(status){
		var statusMsg = "";
		if(status=='1901001'){
			statusMsg = Liferay.Language.get('edison-appstore-status-write');
		}else if(status=='1901002'){
			statusMsg = Liferay.Language.get('edison-appstore-status-request');
		}else if(status=='1901003'){
			statusMsg = Liferay.Language.get('edison-appstore-status-private');
		}else if(status=='1901004'){
			statusMsg = Liferay.Language.get('edison-appstore-status-service');
		}
		
		var confirmMsg = Liferay.Language.get('edison-science-appstore-status-change-msg',[''+statusMsg+'']);
		
		if(confirm(confirmMsg)){
			var dataForm = {	
					"<portlet:namespace/>status"	: status
				};
			
			jQuery.ajax({
				type: "POST",
				url: "<%=updateAppStatusURL%>",
				async : false,
				data  : dataForm,
				success: function(result) {
					if(result=="SUCCESS"){
						location.reload();
					}
				},error:function(jqXHR, textStatus, errorThrown){
					if(jqXHR.responseText !== ''){
						alert(textStatus+": "+jqXHR.responseText);
					}else{
						alert(textStatus+": "+errorThrown);
					}  
				}
			});
		}else{
			return false;
		}
	}
	
	
	function <portlet:namespace/>fileDownload(p_fileEntryId){
		location.href = "<%=edisonFileDownloadURL%>&<portlet:namespace/>fileEntryId="+p_fileEntryId;	
	}
	
	function <portlet:namespace/>goList(){
		location.href = "${redirectOrignURL}";
	}
	
	function <portlet:namespace/>deleteFile(p_fileEntryId,fileType,objectClass,language){
		if(!confirm(Liferay.Language.get('file-delete-confirm'))) return;
		var deleteForm = {
				"<portlet:namespace/>fileEntryId" : p_fileEntryId,
				"<portlet:namespace/>fileType" : fileType,
				"<portlet:namespace/>language" : language
				};
		
		jQuery.ajax({
			type: "POST",
 			url: "<%=deleteFileURL%>",
			data: deleteForm,
	  		async : false,
			success: function(data) {
				alert(Liferay.Language.get('edison-data-delete-success'));
				$("."+objectClass).remove();
				
				if(fileType=="portType"){
					var percentVal = '0%';
					$('.bar').width(percentVal);
					$('.percent').html(percentVal);
					$("#<portlet:namespace/>fileSave").show();
				}else if(fileType=="portSampleFile"){
					$("input:radio[name='CheckFile'][id='portSampleFile']").val('');
				}
			},error:function(data,e){ 
				alert("deleteFile System error!");	
			}
		});
	}
	
	function <portlet:namespace/>noUpdateDisabled(status){
		if(Number(status)>=1901003){
			$(".noupdate").prop('disabled', true);
			$(".noUpdateHidden").css('display', 'none');
		}
	}
	
	function <portlet:namespace/>copyScienceApp(){
		
		var confirmContent = '<p style="font-size: 15px;"> ' + Liferay.Language.get('edison-science-appstore-toolkit-app-copy-message').replace("\n", "<br/>") + '</p>'
							 + '<p style="font-size: 15px;">' + Liferay.Language.get('edison-science-appstore-update-new-version-massage').replace("\n", "<br/>") + '</p>'
							 + '<p> <input type="text" class="field field-control" id="<portlet:namespace/>inputNewVersion" placeholder="ex) 1.0.0" val /> </p>';
		
		/* if(!confirm(Liferay.Language.get('edison-science-appstore-toolkit-app-copy-message'))) return; */
		
		$.confirm({
			boxWidth: '30%',
			useBootstrap: false,
			title: 'Version Upgrade!',
			content: confirmContent,
			buttons: {
				confirm: function () {
					
					var regVersion = new RegExp('[0-9]+[.][0-9]+[.][0-9]');
					var regVersionStr = new RegExp('[a-zA-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+');
					var newVersion = $("#<portlet:namespace/>inputNewVersion").val();
					
					if(newVersion !=null && newVersion != '' && !regVersion.test(newVersion)){
						alert(Liferay.Language.get('edison-data-collection-enter-version-alert'));
						return;
					} else if(newVersion !=null && newVersion != '' && regVersionStr.test(newVersion)){
						alert(Liferay.Language.get('edison-data-collection-enter-version-alert'));
						return;
					}
					
					
					jQuery.ajax({
						type: "POST",
						url: "<%=copyScienceAppURL%>",
						data: {"<portlet:namespace/>newVersion" : newVersion},
						async : false,
						dataType: 'json',
						success: function(result) {
							resultCopy = result.resultCopy;
							if(resultCopy){
								var confirmMsg = Liferay.Language.get('edison-science-appstore-toolkit-app-copy-success-message')+' '+result.newAppVersion;
								if(confirm(confirmMsg)){
									var searchParameter = "";
									searchParameter += "&<portlet:namespace/>scienceAppId="+result.newAppId;
									location.href="<%=newAppRenderURL%>"+searchParameter;
								}else{
									location.reload();
								}
							} else {
								alert(Liferay.Language.get('edison-science-appstore-update-new-version-duplicate-massage'));
							}
						},error:function(jqXHR, textStatus, errorThrown){
							if(jqXHR.responseText !== ''){
								alert(textStatus+": "+jqXHR.responseText);
							}else{
								alert(textStatus+": "+errorThrown);
							}  
						}
					});
					
				},
				cancel: function () {
				}
			}
		});
	}
	
	function <portlet:namespace/>appTest(){
		window.location.href = "<%=appTestURL%>";
	}
</script>
