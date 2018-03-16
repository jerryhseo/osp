<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<%
//Tab Setting
	String tabNames = (String)request.getAttribute("tabNames");
	String visitSite = CustomUtil.strNull(request.getAttribute("visitSite"), "test");
	String tabsValues = (String)request.getAttribute("tabsValues");
	String portletNameSpace = "_"+portletDisplay.getId()+"_"+"tagScript";
%>
<head>
<liferay-portlet:actionURL var="saveClickTabURL" portletMode="view" copyCurrentRenderParameters="false">
	<liferay-portlet:param name="myaction" value="saveClickTabSatis"/>
</liferay-portlet:actionURL>

<liferay-portlet:resourceURL var="classStatisticsListURL" 	escapeXml="false"	 id="classStatisticsList"  copyCurrentRenderParameters="false"/>

<liferay-portlet:resourceURL var="classStatisticsExcelDownLoadURL"		id="classStatisticsExcelDownLoad"	escapeXml="false" copyCurrentRenderParameters="false"/>

<script type="text/javascript">


AUI().ready(function() {
	<portlet:namespace/>dataSearchList();
	
	$("#<portlet:namespace/>jobStartDt").datepicker({
		showButtonPanel: true,
		showOn: 'button',
		dateFormat:"yy-mm-dd",
		changeMonth: true,
		changeYear: true,
		buttonImage: "${contextPath}/images/calendar.png",
		buttonImageOnly: true,
		onClose: function( selectedDate ) {
			$("#<portlet:namespace/>jobEndDt").datepicker("option", "minDate", selectedDate);
		}
		});

	$("#<portlet:namespace/>jobEndDt").datepicker({
		showButtonPanel: true,
		showOn: 'button',
		dateFormat:"yy-mm-dd",
		changeMonth: true,
		changeYear: true,
		buttonImage: "${contextPath}/images/calendar.png",
		buttonImageOnly: true,
		onClose: function( selectedDate ) {
			$("#<portlet:namespace/>jobStartDt").datepicker("option", "maxDate", selectedDate);
		}
	});

		$("img.ui-datepicker-trigger").attr("style", "margin-left:2px; vertical-align:middle; cursor: Pointer; width: 18px;");
});
function <portlet:namespace/>dataSearchList(pageNumber){
	bStart();
	if(pageNumber == 0) {
		$("#<portlet:namespace/>curPage").val(1);
	} else {
		$("#<portlet:namespace/>curPage").val(pageNumber);
	}
	
	var searchForm = $("form[name=<portlet:namespace/>statisticsForm]").serialize();
	
	$.ajax({
		type: "POST",
		url: "<%=classStatisticsListURL%>",
		async:true,
		data: searchForm,
		success:function(data){
			var statisticsList = data.dataList;
			var $rowResult;
			$("#classStatisticsListBody tr:not(:has(#1))").remove();
			
			var university = "";//
			var universityId = "";
			var lab = "";
			var labId = "";
			var classCount = 0;//기관 rowspan 하기위해 클래스 개수 구하기
			var labCount = 0;
			if(statisticsList.length != 0) {
				for(var i = 0; i < statisticsList.length; i++) {
					$rowResult = $("<tr/>").appendTo("#classStatisticsListBody");

					var nowUniversity = statisticsList[i].university;
					var nowUniversityId = statisticsList[i].universityId;
					
					var nowLabId = statisticsList[i].virtualLabId;
					var nowLab = statisticsList[i].virtualLabTitle;
					
					if(university != nowUniversity){
						
						if(classCount != 0){
							$("#<portlet:namespace/>"+universityId).attr("rowspan", classCount);
							if(labCount != 0){
								$("#<portlet:namespace/>"+universityId+"_"+labId).attr("rowspan", labCount);
							} 
						}
						university = nowUniversity;
						universityId = nowUniversityId;
						lab=nowLab;
						labId = nowLabId;
						$("<td/>").addClass("center").attr("id","<portlet:namespace/>"+universityId).text(nowUniversity).css("text-align","center").appendTo($rowResult);
						$("<td/>").addClass("center").attr("id","<portlet:namespace/>"+universityId+"_"+labId).text(nowLab).css("text-align","center").appendTo($rowResult);
						classCount = 0;
						labCount = 0;
					}else {//기관이 같음 
						if(lab != nowLab){//가상실험실이 다른경우
							if(labCount != 0){//rowspan
								$("#<portlet:namespace/>"+universityId+"_"+labId).attr("rowspan", labCount);
							}
							lab=nowLab;
							labId = nowLabId;
							$("<td/>").addClass("center").attr("id","<portlet:namespace/>"+universityId+"_"+labId).text(nowLab).css("text-align","center").appendTo($rowResult);
							
							labCount = 0;
						}						
					} 
					
					$("<td/>").addClass("center").text(statisticsList[i].classTitle).css("text-align","center").appendTo($rowResult);
					$("<td/>").addClass("center").text(statisticsList[i].virtualLabPersonName).css("text-align","center").appendTo($rowResult);
					
					var scienceAppTitleList = statisticsList[i].scienceAppTitle;
					var scienceAppTitle = "";
					if(scienceAppTitleList != null && scienceAppTitleList.length > 0){
						for(var j=0; j < scienceAppTitleList.length; j++){
							scienceAppTitle += "● " + scienceAppTitleList[j] +"<br/>";
						}
					}
					
					$("<td/>").addClass("center").html(scienceAppTitle).appendTo($rowResult);
					$("<td/>").addClass("center").text(statisticsList[i].executeStudentcount).css("text-align","center").appendTo($rowResult);
					
					
					$("<td/>").addClass("center").text(statisticsList[i].classId).css("text-align","center").appendTo($rowResult);
					$("<td/>").addClass("center").text(statisticsList[i].executeCount).css("text-align","center").appendTo($rowResult);
					$("<td/>").addClass("center").text(statisticsList[i].avgerageRuntime).css("text-align","center").appendTo($rowResult);
					

					classCount++;
					labCount++;
				} 
				$("#<portlet:namespace/>"+universityId).attr("rowspan", classCount);
				$("#<portlet:namespace/>"+universityId+"_"+labId).attr("rowspan", labCount);
			}else if(statisticsList.length== 0){
				$rowResult = $("<tr/>");
				$("<td/>").addClass("center").text("<liferay-ui:message key='edison-class-statistics-no-status' />")
				  .css("text-align","center")
				  .attr("colSpan", "9")
				  .appendTo($rowResult);
				$("#classStatisticsListBody").append($rowResult);
			}	
		},complete: function(){
			bEnd();
		}
	});
}

function excelDown(){
	var form = $("form[name=<portlet:namespace/>statisticsForm]").serialize();
	var url = "<%=classStatisticsExcelDownLoadURL%>"+"&"+form;
	window.location.href = spaceDelete(url);
}

</script>
</head>
<body>
<%
	if((Boolean)request.getAttribute("isPortalMain")){
%>

<link type="text/css" rel="stylesheet" href="${contextPath}/css/main.css" media="screen"/>
<style>
#data_wrap{
	margin: 10px 0px;
}

</style>

	<div class="contabmenu"> 
		<edison-ui:tabs 
			names="<%=tabNames%>" 
			tabsValues="<%=tabsValues%>" 
			value="<%=visitSite%>" 
			refresh="<%=false%>" 
			onClick="<%=portletNameSpace%>"
			minwidth="195"
		/>
	</div>
	<%
		}
	%>
	
	<div class="table-responsive panel edison-panel" style="border-top: 0px;">
	
		<h2>
			<img src="${pageContext.request.contextPath}/images/sub_tit_bl.png" />
			<liferay-ui:message key='edison-statistics-class' />
		</h2>
	</div>
	
	<div class="tabletopbox clear">
		<form name="<portlet:namespace/>statisticsForm" method="post">
			<input type="hidden" name="<portlet:namespace/>visitSite" id="<portlet:namespace/>visitSite" value="<%=visitSite%>">
			
			<div id="data_wrap">
				<div class="tabletoptab" style="float: left; margin-right: 10px;">
			  		<input class="box01" type="text" id="<portlet:namespace/>jobStartDt" name="<portlet:namespace/>jobStartDt" readonly="readonly" value="${preDay}"/> 
						~	<input class="box01" type="text" id="<portlet:namespace/>jobEndDt" name="<portlet:namespace/>jobEndDt" readonly="readonly" value="${toDay}"/>
				</div>
				
				<div class="search03">
						<input type="button" name="<portlet:namespace />fullsize" id="fullsize" value="<liferay-ui:message key="edison-button-search" />"  class="btn btn-default" onclick="<portlet:namespace/>dataSearchList(0);" />
						<input type="button" name="fullsize" id="fullsize" value="Excel Download" class="btn btn-default" onClick="excelDown()" style="float: right;"/>
				</div>
				
			</div>
		</form>
	</div>
	
	<div class="table-responsive panel edison-panel">
		<div class="panel-heading clearfix">
		</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table table-bordered table-hover edison-table" >
			<colgroup>
				<col width="10%" />
				<col width="10%" />
				<col width="10%" />
				<col width="8%" />
				<col width="25%" />
				<col width="7%" />
				<col width="7%" />
				<col width="7%" />
				<col width="8%" />
			</colgroup>
			<thead>
				<tr>
					<th align="center" scope="col"><liferay-ui:message key='edison-create-account-field-title-university' /></th>
					<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-tablerow-virtuallab' /></th>
					<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-tablerow-virtualclass' /></th>
					<th align="center" scope="col"><liferay-ui:message key='edison-virtuallab-tablerow-professor' /></th>
					<th align="center" scope="col"><liferay-ui:message key='edison-class-statistics-sw-data' /></th><!-- 활용SW -->
					<th align="center" scope="col"><liferay-ui:message key='edison-class-statistics-execute-student-count' /></th><!-- 실행학생수 -->
					<th align="center" scope="col"><liferay-ui:message key='edison-class-statistics-class-code' /></th><!-- 수업코드 -->
					<th align="center" scope="col"><liferay-ui:message key='edison-science-appstore-view-Execution-count' /></th> <!-- 실행수 -->
					<th align="center" scope="col">CPU Time</th> <!-- CPU Time -->
				</tr>
			</thead>
			<tbody id="classStatisticsListBody">
			</tbody>
		</table>
	</div>
	
	<img id="loadingBox" src="${contextPath}/images/loading.gif" width="400" style="display: none;"/>

<script type="text/javascript">

//liferay-ui 탭 이벤트 return Script
function <portlet:namespace/>tagScript(tabUrl,tabNames,value,scriptName){
	window.location.href = "<%= saveClickTabURL.toString() %>&<portlet:namespace/>groupId=" + value;
}
</script>
</body>