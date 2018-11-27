<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>


<liferay-portlet:resourceURL var="getProjectURL" id="getProject" copyCurrentRenderParameters="false" escapeXml="false"/>
<liferay-portlet:resourceURL var="updateProjectURL" id="updateProject" copyCurrentRenderParameters="false" escapeXml="false"/>
<liferay-portlet:resourceURL var="deleteProjectURL" id="deleteProject" copyCurrentRenderParameters="false" escapeXml="false"/>

<liferay-portlet:resourceURL var="prepareAnalyzerURL" id="prepareAnalyzer" copyCurrentRenderParameters="false" escapeXml="false"/>
<liferay-portlet:resourceURL var="executeAnalyzerURL" id="executeAnalyzer" copyCurrentRenderParameters="false" escapeXml="false"/>
<liferay-portlet:resourceURL var="checkAnalyzerURL" id="checkAnalyzer" copyCurrentRenderParameters="false" escapeXml="false"/>




<style type="text/css">
div#_BladeDataEditor_WAR_OSPMeshGeneratorModuleportlet_content .controllpanel {
	height: 45px;
	border-bottom: 1px solid #d3d3d3;
	width: 100%;
	display: none;
}

div#_BladeDataEditor_WAR_OSPMeshGeneratorModuleportlet_content .controllpanel ul{
	list-style: none;
	margin: 0px;
	padding: 0px;
	width: 100%;
	display: table;
}

div#_BladeDataEditor_WAR_OSPMeshGeneratorModuleportlet_content .controllpanel ul li{
	display: table-cell;
	text-align: center;
	vertical-align: middle;
	background-color: #FFFFFF;
}

div#_BladeDataEditor_WAR_OSPMeshGeneratorModuleportlet_content div.title{
	border-bottom: 1px solid #d3d3d3;
	padding: 10px 0px;
}

div#_BladeDataEditor_WAR_OSPMeshGeneratorModuleportlet_navigatorParameter .osp-editor .header{
	display: none;
}

div#_BladeDataEditor_WAR_OSPMeshGeneratorModuleportlet_navigatorParameter .container-fluid{
	padding-left: 15px;
	padding-right: 15px;
}
</style>
<div class="panel panel-default blade-full-height">
	<div class="panel-heading blade-panel-heading clearfix">
		<div class="panel-title pull-left"><span><i class="icon-chevron-right"></i> Selected File : <span>ssssssssss</span></span></div>
		<div class="pull-right"><button class="btn btn-xs btn-primary">sample</button></div>
	</div>
	<div class="panel-body" style="height: inherit;display: flex;flex-flow: column;">
		<div style="flex:1;height: 50%; overflow-y:auto;">
			<div id="<portlet:namespace/>controllpanel" class="controllpanel">
				<ul>
					<li class="con-button" id="<portlet:namespace/>con-file" onclick="<portlet:namespace/>openFile();return false;">
						<a class='btn btn-small' href='#'>
							<i class='icon-large icon-file-text check-icon'> 
								<span class="font">File</span>
							</i>
						</a>
					</li>
					
					<li class="con-button" id="<portlet:namespace/>con-create" onclick="<portlet:namespace/>createMesh(); return false;">
						<a class='btn btn-small' href='#'>
							<i class='icon-large icon-edit'> 
								<span class="font">Create</span>
							</i>
						</a>
					</li>
					
					<li class="con-button" id="<portlet:namespace/>con-solver">
						<a class='btn btn-small' href='#'>
							<i class='icon-large icon-external-link'> 
								<span class="font">Solver</span>
							</i>
						</a>
					</li>
					
					<li class="con-button" id="<portlet:namespace/>con-analyzer" onclick="<portlet:namespace/>runAnalyzer();">
						<a class='btn btn-small' href='#'>
							<i class='icon-large icon-play-circle'> 
								<span class="font">Analyze</span>
							</i>
						</a>
					</li>
					
					<li class="con-button" id="<portlet:namespace/>con-delete" onclick="<portlet:namespace/>removeNode();">
						<a class='btn btn-small' href='#'>
							<i class='icon-large icon-trash'>
								<span class="font">Delete</span> 
							</i>
						</a>
					</li>
					
					
					<li class="con-button" id="<portlet:namespace/>con-mesh-view">
						<a class='btn btn-small' href='#'>
							<i class='icon-large icon-edit'>
								<span class="font">View</span> 
							</i>
						</a>
					</li>
					
					<li>
						<a class='btn btn-small' href='#' onclick="<portlet:namespace/>closePanel();return false;">
							<i class='icon-large icon-collapse-top'> 
								<span class="font">Close</span>
							</i>
						</a>
					</li>
				</ul>
			</div>
			<div class="title">
				<i class="icon-ok"></i> Navigator</span>
			</div>
			<div id="<portlet:namespace/>navigatorTree">
				
			</div>
		</div>
		<div id="<portlet:namespace/>navigatorParameter" style="height: 45%;padding-top: 5px;">
		<div class="pull-left">
			<i class="icon-ok"></i> Parametric Airfoil</span>
		</div>
		<div class="pull-right"><button class="btn btn-xs btn-primary" onclick="<portlet:namespace/>parameterDraw();">Draw</button></div>
		<div class="h2 clearfix" style="border-bottom: 1px solid #d3d3d3;padding: 5px 0px;"></div>
			<liferay-portlet:runtime portletName="StructuredDataEditor_WAR_OSPStructuredDataEditorportlet_INSTANCE_parametric" queryString=""/>
		</div>
	</div>
</div>

<script type="text/javascript">
/***********************************************************************
 * Global variables section
 ***********************************************************************/
var <portlet:namespace/>INIT_ROOT_DATA = [
	{
		"id":"<portlet:namespace/>GEO",
		"text":"Geometries",
		"type":"root-geo",
		"data":{"NodeType_":"root-geo"}
	},
	{
		"id":"<portlet:namespace/>MESH",
		"type":"root-mesh",
		"text":"Meshes",
		"data":{"NodeType_":"root-mesh"}
	}
];

var <portlet:namespace/>INIT_DISPLAY_DATA = {
		"camera" : {
			"position" : {
				"z" : 0,
				"y" : 0,
				"x" : 0
			}
		}
	};
	
/***********************************************************************
* Portlet Function
***********************************************************************/
function <portlet:namespace/>navigatorInitJstree(){
	var rootData = <portlet:namespace/>INIT_ROOT_DATA;
	
	$("#<portlet:namespace/>navigatorTree").jstree({
		"core" : {
			"data": rootData,
			"themes" : {
				"name" : "proton",
				"responsive" : true
			},
			"check_callback" : true
		},
		"types" : {
			"root" : {
			},
			"root-geo" : {
			},
			"root-mesh" : {
			},
			"root-boundary" : {
			},
			"view-icon" : {
				"icon" : "icon-eye-open <portlet:namespace/>node-click-icon"
			},
			"un-view-icon" : {
				"icon" : "icon-eye-close <portlet:namespace/>node-click-icon"
			},
			"code-icon" : {
				"icon" : "icon-code"
			}
		},
		"state" : { 
			"key" : "checklist_tree_state" 
		},
		"progressive_render" : true,
		"plugins" : ["types","json_data"]
	}).bind("loaded.jstree", function(event, data) {
		$("#<portlet:namespace/>navigatorTree").jstree('open_all');
		
		
	}).bind("open_node.jstree", function(event, data) {
		
	}).bind("refresh.jstree",function(event, data){
		$("#<portlet:namespace/>navigatorTree").jstree('open_all');
	}).bind("select_node.jstree",function(event, data){
		if(typeof data.event!= "undefined"){
			if(data.event.target.tagName === "I"){
				return false;
			}
		}else{
			return false;
		}
		
		console.log(data);
		<portlet:namespace/>selectedNode(data);
	});
}

function <portlet:namespace/>searchNavigator(){
	/*init Data*/
	/*Key 값이 없을 경우 해당 초기 데이터 Setting을 위하여 */
	var projectStructure = JSON.stringify(<portlet:namespace/>INIT_ROOT_DATA);
	var analyzerStructure = JSON.stringify(<portlet:namespace/>INIT_DISPLAY_DATA);
	
	var searchData = {
		"<portlet:namespace/>projectStructure":projectStructure,
		"<portlet:namespace/>analyzerStructure":analyzerStructure,
		"<portlet:namespace/>simulationUuid":<portlet:namespace/>simulationUuid,
		"<portlet:namespace/>jobSeqNo":<portlet:namespace/>jobSeqNo
	};
	
	jQuery.ajax({
		type: "POST",
		url: "<%=getProjectURL%>",
		async : false,
		data  : searchData,
		dataType: 'json',
		success: function(data) {
			var treeData  = data.projectStructure;
			$("#<portlet:namespace/>navigatorTree").jstree(true).settings.core.data = treeData;
			$("#<portlet:namespace/>navigatorTree").jstree(true).refresh();
			
			/*Global ProjectId Setting*/
			<portlet:namespace/>projectId = data.projectId;
			
			/*View File Load Event 호출*/
		},error:function(jqXHR, textStatus, errorThrown){
			if(jqXHR.responseText !== ''){
				alert(textStatus+": "+jqXHR.responseText);
			}else{
				alert(textStatus+": "+errorThrown);
			}  
		}
	});
}


function <portlet:namespace/>updateProject(display){
	var v = $('#<portlet:namespace/>navigatorTree').jstree(true).get_json('#', {no_a_attr:true,no_li_attr:true,no_state:true})
	var projectStructure = JSON.stringify(v);
	var analyzerStructure = "";
	if(display!="none"){
		analyzerStructure = display==""?JSON.stringify(<portlet:namespace/>INIT_DISPLAY_DATA):JSON.stringify(display);
	}
	
	var updateData = {
		"<portlet:namespace/>projectStructure":projectStructure,
		"<portlet:namespace/>analyzerStructure":analyzerStructure,
		"<portlet:namespace/>simulationUuid":<portlet:namespace/>simulationUuid,
		"<portlet:namespace/>jobSeqNo":<portlet:namespace/>jobSeqNo
	};
	jQuery.ajax({
		type: "POST",
		url: "<%=updateProjectURL%>",
		async : false,
		data  : updateData,
		success: function(data) {
			
		},error:function(jqXHR, textStatus, errorThrown){
			if(jqXHR.responseText !== ''){
				alert(textStatus+": "+jqXHR.responseText);
			}else{
				alert(textStatus+": "+errorThrown);
			}  
		}
	});
}

function <portlet:namespace/>removeProject(removeType){
	var removeData = {
			"<portlet:namespace/>simulationUuid":<portlet:namespace/>simulationUuid,
			"<portlet:namespace/>jobSeqNo":<portlet:namespace/>jobSeqNo,
			"<portlet:namespace/>removeType":removeType
		};
	
		jQuery.ajax({
			type: "POST",
			url: "<%=deleteProjectURL%>",
			async : false,
			data  : removeData,
			success: function(data) {
				
			},error:function(jqXHR, textStatus, errorThrown){
// 				if(jqXHR.responseText !== ''){
// 					alert(textStatus+": "+jqXHR.responseText);
// 				}else{
// 					alert(textStatus+": "+errorThrown);
// 				}  
			}
		});
}

function <portlet:namespace/>createParameterNode(analyzerJob, geoNode, selectedNode){
	if($("#<portlet:namespace/>navigatorTree").jstree(true).is_parent(geoNode)){
		<portlet:namespace/>removeJstreeChildren(geoNode);
	}
	var outputData = new OSP.InputData(analyzerJob.outputData);
	var nodeData = new MESH.data();
	nodeData.executeId(analyzerJob.analyzerUuid);
	nodeData.nodeType(MESH.Constants.TYPE_GEO_PARAMETER);
	nodeData.analyzerJob = analyzerJob;
	var paramNode = {
			"id": analyzerJob.analyzerUuid,
			"text": outputData.name(),
			"type": MESH.Constants.NODE_CODE,
			"data": nodeData
	};
	
	$("#<portlet:namespace/>navigatorTree").jstree(true).create_node(geoNode.id, paramNode, "last");
	$("#<portlet:namespace/>navigatorTree").jstree(true).open_node(geoNode);
	if(selectedNode){
		$("#<portlet:namespace/>navigatorTree").jstree(true).select_node(analyzerJob.analyzerUuid);
	}
	
	<portlet:namespace/>updateProject('none');
}

function <portlet:namespace/>prepareAnalyzer(appName, appVersion, geoNode, fileContent, draw){
	var geoNodeFileId = geoNode.data[MESH.Constants.DATA_FILE_ID];
	var analyzerUuid = "";
	if($("#<portlet:namespace/>navigatorTree").jstree(true).is_parent(geoNode)){
		analyzerUuid = geoNode.children[0];
	}
	
	$.ajax({
		url : '${prepareAnalyzerURL}',
		type : 'POST',
		dataType : 'json',
		data : {
			"<portlet:namespace/>appName" : appName,
			"<portlet:namespace/>appVersion" : appVersion,
			"<portlet:namespace/>fileId" : geoNodeFileId,
			"<portlet:namespace/>analyzerUuid" : analyzerUuid
		},
		success : function(analyzerJob){
			if(draw){
				<portlet:namespace/>createParameterNode(analyzerJob, geoNode, true);
				<portlet:namespace/>executeAnalyzer(analyzerJob, "input.inp", geoNode.data[MESH.Constants.DATA_FILE_ID],fileContent);
			}else{
				<portlet:namespace/>createParameterNode(analyzerJob, geoNode, false);
				<portlet:namespace/>executeAnalyzer(analyzerJob, geoNode.text, geoNode.data[MESH.Constants.DATA_FILE_ID],'');
			}
		},
		error : function(){
			if(console){
				console.log('[ERROR] AJAX FAILED during prepareAnalyzer');
			}
		}
	});
}

function <portlet:namespace/>executeAnalyzer(analyzerJob, inputFileName, fileId, fileContent){
	$.ajax({
		url : '${executeAnalyzerURL}',
		type : 'POST',
		dataType : 'json',
		data : {
			"<portlet:namespace/>analyzerJob" : JSON.stringify(analyzerJob),
			"<portlet:namespace/>inputFileName" : inputFileName,
			"<portlet:namespace/>fileId" : fileId,
			"<portlet:namespace/>fileContent" : fileContent,
			"<portlet:namespace/>projectId" : <portlet:namespace/>projectId
		},
		success : function(result){
			if(result.isComplete){
// 				<portlet:namespace/>setXYPlotterResultPath(analyzerJob);
				<portlet:namespace/>checkAnalyzerJob(analyzerJob);
			}else{
				alert("It did not run properly. Please contact your administrator.");
			}
		},
		error : function(jqXHR, textStatus, errorThrown){
			if(jqXHR.responseText !== ''){
				alert("[ERROR] AJAX FAILED during executeAnalyzer -->"+textStatus+": "+jqXHR.responseText);
			}else{
				alert("[ERROR] AJAX FAILED during executeAnalyzer -->"+textStatus+": "+errorThrown);
			}
		}
	});
}

function <portlet:namespace/>checkAnalyzerJob(analyzerJob){
	/*parameter 프로그래스 필요*/
	$.ajax({
		url : '${checkAnalyzerURL}',
		type : 'POST',
		dataType : 'json',
		data : {
			"<portlet:namespace/>analyzerJob" : JSON.stringify(analyzerJob)
		},
		success : function(result){
			<portlet:namespace/>parameterInitEditor(OSP.Enumeration.PathType.FILE_CONTENT,result.out,'parametric');
		},
		error : function(jqXHR, textStatus, errorThrown){
			if(jqXHR.responseText !== ''){
				alert("[ERROR] AJAX FAILED during executeAnalyzer -->"+textStatus+": "+jqXHR.responseText);
			}else{
				alert("[ERROR] AJAX FAILED during executeAnalyzer -->"+textStatus+": "+errorThrown);
			}
		}
	});
}

function <portlet:namespace/>getSelectedGeometryNode(){
	return  $("#<portlet:namespace/>navigatorTree").jstree("get_selected", true)[0];
}

function <portlet:namespace/>removeExecute(executeId){
	
}

/***********************************************************************
 * Tree Event section
 ***********************************************************************/
function <portlet:namespace/>selectedNode(treeData){
	var node_id = treeData.node.id;
	var node_data_type = treeData.node.data[MESH.Constants.DATA_NODE_TYPE];
	
	/*Controll Panel EVENT - START*/
	var controllPanel = $("#<portlet:namespace/>controllpanel");
	
	var contorllDataId = controllPanel.attr("data-from-id");
	if(contorllDataId===node_id){
		var contorllDataSize = controllPanel.attr("data-size");
		if(contorllDataSize!=0){
			if(controllPanel.is(":visible")==true){
				controllPanel.hide();
			}else{
				controllPanel.slideDown('fast',null);
			}
		}
		
	}else{
		var viewConArr = MESH.Constants.getControllTypes(node_data_type);
		controllPanel.find(".con-button").css("display","none");
		controllPanel.attr("data-from-id",node_id);
		controllPanel.attr("data-size",viewConArr.length);
		if(viewConArr.length!=0){
			for (var i = 0, x = viewConArr.length; i < x; i++) {
				if(viewConArr[i]===MESH.Constants.CON_MESH_VIEW){
					if(typeof treeData.node.data["analyzerJob"]!=="undefined"){
						$("#<portlet:namespace/>con-"+viewConArr[i]).attr("onclick","<portlet:namespace/>showMesh('"+treeData.node.data["analyzerJob"]+"')")
						$("#<portlet:namespace/>con-"+viewConArr[i]).show();
					}
				}else{
					$("#<portlet:namespace/>con-"+viewConArr[i]).show();
				}
			}
			controllPanel.slideDown('fast',null);
		}else{
			controllPanel.hide();
		}
	}
	/*Controll Panel EVENT - END*/
	
	
	/* parameter event - start*/
	if(node_data_type == MESH.Constants.TYPE_GEO_PARAMETER
	    && <portlet:namespace/>checkAnalyzerJob){
	    <portlet:namespace/>checkAnalyzerJob(treeData.node.data["analyzerJob"]);
	}
	
	if(node_data_type == MESH.Constants.TYPE_GEO_PARAMETER
	    && <portlet:namespace/>setXYPlotterResultPath){
	    <portlet:namespace/>setXYPlotterResultPath(treeData.node.data["analyzerJob"]);
	}
	/* parameter event - end*/
}
function <portlet:namespace/>addNode(parentId, node){
	$("#<portlet:namespace/>navigatorTree").jstree().create_node(parentId,OSP.Util.toJSON(node),"last",false);
	$("#<portlet:namespace/>navigatorTree").jstree("open_node", parentId);
	
	<portlet:namespace/>updateProject('none');
}

function <portlet:namespace/>removeJstreeChildren(parentNode){
	var children = $("#<portlet:namespace/>navigatorTree").jstree(true).get_children_dom(parentNode);
	$("#<portlet:namespace/>navigatorTree").jstree(true).delete_node(children);
}

/***********************************************************************
 * Controll Panel Event section
 ***********************************************************************/
function <portlet:namespace/>openFile(){
	var nodes = $("#<portlet:namespace/>navigatorTree").jstree('get_selected', false);
	var type = nodes[0].replace("<portlet:namespace/>","");
	var fileExt = MESH.Constants.getFileExtension(type);
	
	var selectedNode = $("#<portlet:namespace/>navigatorTree").jstree(true).get_node(nodes[0],false);
	
	var fileIdFilter = "";
	for (var i = 0, x = selectedNode.children.length; i < x; i++) {
		var treeData = $("#<portlet:namespace/>navigatorTree").jstree(true).get_node(selectedNode.children[i],false);
		var node_data_file_id = treeData.data[MESH.Constants.DATA_FILE_ID];
		if(fileIdFilter==""){
			fileIdFilter = node_data_file_id; 
		}else{
			fileIdFilter += ","+node_data_file_id;
		}
	}
	
	AUI().use("liferay-portlet-url", function(a) {
		var portletURL = Liferay.PortletURL.createRenderURL();
		portletURL.setPortletMode("view");
		portletURL.setWindowState("pop_up");
		portletURL.setPortletId("edisonfilemanager_WAR_edisonsimulationportlet");
		portletURL.setParameter("fileExt",fileExt);
		portletURL.setParameter("fileSearchType",type);
		portletURL.setParameter("fileIdFilter",fileIdFilter);
		
		Liferay.Util.openWindow(
			{
				dialog: {
					width:1024,
					height:850,
					cache: false,
					draggable: false,
					resizable: false,
					modal: true,
					destroyOnClose: true,
					after: {
						render: function(event) {
							$("button.btn.close").on("click", function(e){
								$("body").css('overflow','');
							});
						}
					}
				},
			id: "<portlet:namespace/>fileSearchDialog",
			uri: portletURL.toString(),
			title: "File SEARCH"
			}
		);
	});
}

function <portlet:namespace/>removeNode(){
	$.confirm({
		boxWidth: '30%',
		useBootstrap: false,
		title: 'Confirm!',
		content: Liferay.Language.get("file-delete-confirm"),
		buttons: {
			confirm: function () {
				
				try{
					var tree = $("#<portlet:namespace/>navigatorTree").jstree(true);
					
					var selectNode = $("#<portlet:namespace/>navigatorTree").jstree("get_selected");
					var node = tree.get_node(selectNode);
					var node_data_type = node.data[MESH.Constants.DATA_NODE_TYPE];
					
					
					if(node_data_type===MESH.Constants.TYPE_VIEW_SURFACE){
						<portlet:namespace/>surfaceDraw();
					}else{
						var command = "";
						if(node_data_type===MESH.Constants.TYPE_VIEW_FILE){
// 							command = "remove.geometry";
						}else if(node_data_type===MESH.Constants.TYPE_VIEW_DAT){
// 							command = "remove.geometry";
							if(tree.is_parent(node)){
						    	var executeId = node.children[0];
								<portlet:namespace/>removeExecute(executeId);
						    }
						}else if(node_data_type===MESH.Constants.TYPE_VIEW_MESH){
// 							command = "remove.mesh";
						}
						
						var fileArray = new Array();
						fileArray.push({
							'fileId': node.data[MESH.Constants.DATA_FILE_ID],
							'name': node.text
						});
						
						
						$("#<portlet:namespace/>controllpanel").hide();
					}
					
					<portlet:namespace/>updateProject('none');
				}catch(exception){
					
				}finally{
					tree.delete_node(selectNode);
					
					<portlet:namespace/>updateProject(false,"none");
				}
			},
			cancel: function () {
				
			}
		}
	});
}

function <portlet:namespace/>runAnalyzer(){
	var geoNode = <portlet:namespace/>getSelectedGeometryNode();
	<portlet:namespace/>prepareAnalyzer(MESH.Constants.getShapeAnalysisParamApp('${type}'),MESH.Constants.getShapeAnalysisParamAppVersion('${type}'),geoNode,'',false);
}

function <portlet:namespace/>closePanel(){
	$("#<portlet:namespace/>controllpanel").hide();
}


/***********************************************************************
 * Parameter Event section
 ***********************************************************************/
function <portlet:namespace/>parameterInitEditor(type,structure,instance){
	var srcData = new OSP.InputData();
	srcData.type(type);
	srcData.context(structure);
	var eventData = {
		targetPortlet: 'StructuredDataEditor_WAR_OSPStructuredDataEditorportlet_INSTANCE_'+instance,
		data: OSP.Util.toJSON(srcData)
	};
	Liferay.fire( OSP.Event.OSP_LOAD_DATA, eventData );
}

function <portlet:namespace/>parameterDraw(){
	var eventData = {
		targetPortlet: 'StructuredDataEditor_WAR_OSPStructuredDataEditorportlet_INSTANCE_parametric'
	};
	setTimeout(function(){
	    Liferay.fire( OSP.Event.OSP_REQUEST_DATA, eventData );
	},1000);
		
}

/*ParameterDraw befor Request Data after this function*/
Liferay.on(OSP.Event.OSP_RESPONSE_DATA,function(e) {
	if(e.portletId == "StructuredDataEditor_WAR_OSPStructuredDataEditorportlet_INSTANCE_parametric"){
		var tree = $("#<portlet:namespace/>navigatorTree").jstree(true);
		var selectNode = $("#<portlet:namespace/>navigatorTree").jstree("get_selected");
		var node = tree.get_node(selectNode);
		var node_data_appName = node.data.analyzerJob.appName;
		alert(node_data_appName);
		if(node_data_appName!=MESH.Constants.SHAPE_ANALYSIS_APP){
			
		}
	}
});
</script>
<aui:script>
Liferay.provide(window, "getFileIdAndName", function(fileSearchType,object){
	<portlet:namespace/>closePopup("<portlet:namespace/>fileSearchDialog");
	
	var parentId = "<portlet:namespace/>"+fileSearchType;
	var command = "";
	
	if(fileSearchType===MESH.Constants.GEOMETRIES_PARENT_FOLDER_ID){
		command = "add.geometry";
	}else if(fileSearchType===MESH.Constants.MESHES_PARENT_FOLDER_ID){
		command = "add.mesh";
	}
	
	var fileArray = new Array();
	for (var i = 0, x = object.length; i < x; i++) {
		var fileMap = object[i];
		var data = new MESH.data();
		data.file(fileMap[0]);
		data.nodeType(MESH.Constants.getTypeByFileName(fileMap[1]));
		var node = new MESH.node();
		node.addNode(fileMap[1], MESH.Constants.NODE_VIEW_FILE, OSP.Util.toJSON(data));
		
		<portlet:namespace/>addNode(parentId,node);
		
		var fileObject = new Object();
		fileObject.fileId = fileMap[0];
		fileObject.name = fileMap[1];
		fileArray.push(fileObject);
	}
	
<!-- 	<portlet:namespace/>callETurbAnalyzerAddObject(command,fileArray) -->
	$("body").css('overflow','');
});

Liferay.provide(window,'<portlet:namespace />closePopup',
	function(popupIdToClose) {
		Liferay.Util.getWindow(popupIdToClose).destroy(); // You can try toggle/hide whatever You want
		},
	['liferay-util-window']
);
</aui:script>