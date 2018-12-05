<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<liferay-portlet:resourceURL var="jobResultFileURL" id="jobResultFile" copyCurrentRenderParameters="false" escapeXml="false">
	<liferay-portlet:param name="jobUuid" value="${jobUuid}"/>
</liferay-portlet:resourceURL>

<style type="text/css">
#<portlet:namespace/>breadCrumb span.selected{
	font-weight: 600;
	color: #337ab7;
}

.cursor-pointer{
	cursor: pointer;
}

</style>
<div style="border: 1px solid #f2f2f2;border-radius: 10px;">
	<nav class="navbar navbar-default">
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="padding-right:0px;padding-left:0px;">
			<ul class="nav navbar-nav">
				<c:if test="${!empty zipFileId }">
					<li title="List view" class="toolbar cursor-pointer">
						<a href="javascript:void (0);" onclick="<portlet:namespace/>download('${zipFileId}');" class="icon-download-alt" style="font-size: 16px;"> <liferay-ui:message key="edison-simulation-monitoring-result-file-all-down"/></a>
					</li>
				</c:if>
				
				<li title="Level up" class="toolbar toolbar-level-up cursor-pointer" id="<portlet:namespace/>folder-level-up"><a href="javascript:void (0);" class="icon-fb-file-upload" style="font-size: 18px;"></a></li>
				<li title="Grid view" class="toolbar toolbar-gridview cursor-pointer"><a href="javascript:void (0);" class="icon-th" style="font-size: 18px;"></a></li>
				<li title="List view" class="toolbar toolbar-listview cursor-pointer"><a href="javascript:void (0);" class="icon-th-list" style="font-size: 18px;"></a></li>
			</ul>
		</div>
	</nav>
	<ol class="breadcrumb" id="<portlet:namespace/>breadCrumb">
		
	</ol>
	
	<div class="explorer" id="<portlet:namespace/>file-list-area" style="min-height: 560px;">
		
	</div>
</div>

<!-- File manager CSS & JS -->
<link media="all" rel="stylesheet" href="${contextPath}/js/fileManager/jquery.file-manager/jquery.file-manager.css" />
<link href="${contextPath}/css/fileManager/contextMenu.css" rel="stylesheet" type="text/css" />
<link media="all" rel="stylesheet" href="${contextPath}/css/fileManager/default.css" />
<link media="all" rel="stylesheet" href="${contextPath}/css/fileManager/styles.css" />

<script src="${contextPath}/js/workbench/resultfile/file-manager.js"></script>
<script src="${contextPath}/js/fileManager/contextMenu.js"></script>
<script src="${contextPath}/js/fileManager/services.js"></script>

<script type="text/javascript">
/***********************************************************************
 * Global variables section
 ***********************************************************************/
var <portlet:namespace/>defaultFolderPath = "result";

var <portlet:namespace/>reulstFileManegerObj;
$(function(e) {
	<portlet:namespace/>girdFile(<portlet:namespace/>defaultFolderPath);
	
	$("li#<portlet:namespace/>folder-level-up").on("click",function(e){
		var parentPath = $().fileManagerGetParentPath();
		<portlet:namespace/>girdFile(parentPath);
	});
});

function <portlet:namespace/>girdFile(folderFullPath){
	
	<portlet:namespace/>girdBreadCrumb(folderFullPath);
	
	var searchForm = {
		"<portlet:namespace/>searchFolderPath": folderFullPath
	};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=jobResultFileURL%>",
		async : false,
		data  : searchForm,
		dataType: 'json',
		success: function(result) {
			$('#<portlet:namespace/>file-list-area').fileManager(result.resultList,"<portlet:namespace/>",folderFullPath);
		},error:function(jqXHR, textStatus, errorThrown){
			if(jqXHR.responseText !== ''){
				alert(textStatus+": "+jqXHR.responseText);
			}else{
				alert(textStatus+": "+errorThrown);
			}  
		}
	});
}

function <portlet:namespace/>girdBreadCrumb(folderFullPath){
	var breadCrumb = $("ol#<portlet:namespace/>breadCrumb");
	breadCrumb.empty();
	
	var pathSplit = [];
	if(folderFullPath.indexOf('/')==-1){
		pathSplit = [folderFullPath];
	}else{
		pathSplit = folderFullPath.split('/');
	}
	
	var breadCrumbPath = "";
	for ( var i in pathSplit ) {
		var breadcrumbLi = $('<li/>').appendTo(breadCrumb);
		var span = $("<span/>").addClass("cursor-pointer").html(pathSplit[i]).appendTo(breadcrumbLi);
		
		if(breadCrumbPath==""){
			breadCrumbPath+=pathSplit[i];
		}else{
			breadCrumbPath+="/"+pathSplit[i];
		}
		
		span.bind("click",{key:breadCrumbPath},function(e){
			e.stopPropagation();
			e.preventDefault();
			<portlet:namespace/>girdFile(e.data.key);
		});
		
		if(i==pathSplit.length-1){
			span.addClass("selected");
		}
	}
}

function <portlet:namespace/>download(fileId){
	var url = '${icebreakerUrl}/api/file/download?id=' + fileId;
	window.location.href = url;
}

</script>