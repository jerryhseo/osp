<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@ include file="../init.jsp" %>

<%-- <script src="<%=request.getContextPath()%>/js/jquery/jquery-1.10.2.min.js"></script>
<script src="<%=request.getContextPath()%>/js/osp/osp_basic_object.js"></script>
<script src="<%=request.getContextPath()%>/js/osp/osp_super_class.js"></script>
<script src="<%=request.getContextPath()%>/js/osp/osp_datatype.js"></script> --%>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/file-explorer-portlet.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/dropdown.css"/>

 <portlet:resourceURL var="serveResourceURL"></portlet:resourceURL>

<%
PortletPreferences preferences = portletDisplay.getPortletSetup();
preferences.setValue("portletSetupShowBorders", String.valueOf(Boolean.FALSE));
preferences.store();

String inputData = (String)renderRequest.getAttribute("inputData");
boolean eventEnable = (Boolean)renderRequest.getAttribute("eventEnable");
String connector = (String)renderRequest.getAttribute("connector");
String mode = (String)renderRequest.getAttribute("mode");
String action = (String)renderRequest.getAttribute("action");

boolean isPopup = LiferayWindowState.isExclusive(request);
%>

<div class="row-fluid file-explorer-portlet editor-portlet" style="overflow: hidden;">
	<div class="span12" style="height: inherit;">
		<div class="row-fluid" id="<portlet:namespace/>choicePanel" style="padding:10px 0 0 10px;">
			<div class="span8">
				<input class="choidPanelInput" id="<portlet:namespace/>selectedFile" style="width:100%;"/>
			</div>
			<div class="offset2 span2 dropdown-wrapper" id="<portlet:namespace/>menuSection">
				<div class="dropdown">
                  <i class="icon-reorder icon-menu"></i>
					<!-- Link or button to toggle dropdown -->
					<div class="dropdown-content">
                        <div class="dropdown-item" id="<portlet:namespace/>sample"><i class="icon-file"> Take sample</i></div>
                        <div class="dropdown-item" id="<portlet:namespace/>upload"><i class="icon-upload"> Upload</i></div>
                        <div class="dropdown-item" id="<portlet:namespace/>download"><i class="icon-download-alt"> Download</i></div>
					</div>
				</div>
			</div>	
		</div>
		<div class="row-fluid" id="<portlet:namespace/>canvasPanel" style="height: 90%;">
			<iframe class="span12 canvas" id="<portlet:namespace/>canvas" src="<%=request.getContextPath()%>/html/FileExplorer/load_explorer.jsp"></iframe>
		</div>
		
		<div id="<portlet:namespace/>hiddenSection" style="display:none;">
			<form action="<%= serveResourceURL.toString() %>" enctype="multipart/form-data" method="post" id="<portlet:namespace/>uploadForm">
				<input type="file" id="<portlet:namespace/>selectFile" name="<portlet:namespace/>uploadFile"/>
				<input type="text" id="<portlet:namespace/>parentPath" name="<portlet:namespace/>parentPath"/>
				<input type="text" id="<portlet:namespace/>fileName" name="<portlet:namespace/>fileName"/>
				<input type="text" id="<portlet:namespace/>connector" name="<portlet:namespace/>connector"/>
				<input type="text" id="<portlet:namespace/>command" name="<portlet:namespace/>command" />
			</form>
					
			<div id="<portlet:namespace/>confirmDialog">
				<input type="text" id="<portlet:namespace/>uploadFileName"/><br/>
				<p id="<portlet:namespace/>confirmMessage">
					File already exists. Change file name or just click 'OK' button to overlap. 
				</p>
			</div>
			<a id="<portlet:namespace/>downloadAnchor" target="_blank" style="z-index:1000;">Download</a>
		</div>
	</div>
</div>


<script>
/***********************************************************************
 * Global variables section
 ***********************************************************************/
var <portlet:namespace/>canvas = $('#<portlet:namespace/>canvas');
var <portlet:namespace/>connector = '<%=connector%>';
var <portlet:namespace/>downloadMode = false;
var <portlet:namespace/>eventEnable = <%=eventEnable %>;
var <portlet:namespace/>mode = '<%=mode %>';
var <portlet:namespace/>action = '<%=action %>';

var <portlet:namespace/>extension;
var <portlet:namespace/>sampleSelected = false;
var <portlet:namespace/>basePath = '';
var <portlet:namespace/>selectedFile;

var <portlet:namespace/>runningMode = '_DEBUG_';
/***********************************************************************
 * Initailization section using parameters
 ***********************************************************************/

if( <portlet:namespace/>mode === 'VIEW' ){
	$('#<portlet:namespace/>menuSection').css('display', 'none');
}

if( !<portlet:namespace/>eventEnable ){
	var inputData = '<%=inputData%>';
	if( !inputData ){
	    <portlet:namespace/>basePath = new OSP.InputData();
	    <portlet:namespace/>basePath.parent( '');
	    <portlet:namespace/>basePath.name('');
	    <portlet:namespace/>basePath.type(OSP.Enumeration.PathType.FOLDER);
	    <portlet:namespace/>basePath.relative( true );
	}
	else{
	    <portlet:namespace/>basePath = new OSP.InputData(JSON.parse(inputData));
	}
	<portlet:namespace/>passNamespace();
	<portlet:namespace/>initFileExplorer(<portlet:namespace/>basePath, true );
}

function <portlet:namespace/>passNamespace(){
	setTimeout(
			function(){
			    var iframe = document.getElementById('<portlet:namespace/>canvas');
				if ( <portlet:namespace/>iframeReady() && iframe.contentWindow.setNamespace) {
					iframe.contentWindow.setNamespace('<portlet:namespace/>');
				} 
				else{
					<portlet:namespace/>passNamespace();
				}
			}, 
			10
	);
}

function <portlet:namespace/>iframeReady(){
	var iframe = document.getElementById('<portlet:namespace/>canvas');
	var iframeDoc = iframe.contentDocument || iframe.contentWindow.document;

	if ( iframeDoc.readyState  == 'complete' ) {
		return true;
	} 
	else{
		return false;
	}
}
/***********************************************************************
 * Menu click events and binding functions 
 ***********************************************************************/
 $('#<portlet:namespace/>upload').click(function(){
	 var targetFolder;
	 if( <portlet:namespace/>selectedFile.type() === OSP.Enumeration.PathType.FOLDER ){
		 targetFolder = OSP.Util.mergePath( <portlet:namespace/>basePath, <portlet:namespace/>selectedFile.parent());
		 targetFolder = OSP.Util.mergePath( targetFolder, <portlet:namespace/>selectedFile.name() );
	 }
	 else if ( <portlet:namespace/>selectedFile.type() === OSP.Enumeration.PathType.FILE || 
			   <portlet:namespace/>selectedFile.type() === OSP.Enumeration.PathType.EXT){
		 targetFolder = OSP.Util.mergePath( <portlet:namespace/>basePath, <portlet:namespace/>selectedFile.parent());
	 }
	 
	 var eventData = {
			portletId: '<%=portletDisplay.getId()%>',
			targetPortlet: <portlet:namespace/>connector,
			data:{
				targetFolder: targetFolder
			}
	 };
	
	Liferay.fire( OSP.Event.OSP_UPLOAD_FILE, eventData );
	//$('#<portlet:namespace/>selectFile').click();
});

$('#<portlet:namespace/>sample').click(function(){
	$('#<portlet:namespace/>selectedFile').val( '--- sample selected ---');
	$('#<portlet:namespace/>selectedFile').attr('disabled', true);
	<portlet:namespace/>sampleSelected = true;
	
	var eventData = {
			portletId: '<%=portletDisplay.getId()%>',
			targetPortlet: <portlet:namespace/>connector
	}
	
	Liferay.fire( OSP.Event.OSP_SAMPLE_SELECTED, eventData );
});

$('#<portlet:namespace/>download').click(function(){
	if( <portlet:namespace/>downloadMode === false ){
		<portlet:namespace/>downloadMode = true;
		$('#<portlet:namespace/>canvas').find('i.jstree-checkbox').css('display', 'inline');
		alert('To download files, select files to be downloaded and SELECT AGAIN download menu.');
		$('#<portlet:namespace/>canvas').jstree().redraw(true);
		return;
	}
	
	var selectedNodes = $('#<portlet:namespace/>canvas').jstree(true).get_selected();
	for( var index in  selectedNodes ){
		var node = selectedNodes[index];
		if( node === '..' ){
			selectedNodes = OSP.Util.removeArrayElement(selectedNodes, index);
			break;
		}
	}
	//console.log( selectedNodes );
	//console.log('Parent of selected: '+ OSP.Util.mergePath(<portlet:namespace/>basePath, <portlet:namespace/>selectedFile.parent()));
	
	data = {
		<portlet:namespace/>command: 'DOWNLOAD',
		<portlet:namespace/>fileNames: JSON.stringify(selectedNodes),
		<portlet:namespace/>folderPath: OSP.Util.mergePath(<portlet:namespace/>basePath, <portlet:namespace/>selectedFile.parent())
	};
	
	var base = '<%=serveResourceURL.toString()%>';
	var sep = (base.indexOf('?') > -1) ? '&' : '?';
	var url = base+sep+$.param(data);
	
	//console.log( 'Download URL: '+ url);
	($('#<portlet:namespace/>downloadAnchor').attr('href', url))[0].click();

	<portlet:namespace/>downloadMode = false;
	$('#<portlet:namespace/>canvas').jstree().uncheck_all();
	$('#<portlet:namespace/>canvas').find('i.jstree-checkbox').css('display', 'none');
});

$('#<portlet:namespace/>selectFile').bind(
		'change', 
		function(event){
			var uploadFile = $(this)[0].files[0];
			//console.log( 'UploadFile: '+uploadFile);
			
			var uploadFileName = $(this).val();
			var slashIndex = uploadFileName.lastIndexOf('\\');
			if( slashIndex < 0 )
				slashIndex = uploadFileName.lastIndexOf('/'); 
			uploadFileName = uploadFileName.slice(slashIndex+1);
			// $('#<portlet:namespace/>fileName').val( uploadFileName);
			
			var uploadFolder = <portlet:namespace/>selectedFile.parent();
			
			// check that file name is duplicated using AJAX.
			var duplicated;
			var target = OSP.Util.mergePath(
							<portlet:namespace/>basePath,
							uploadFolder
			);
			target = OSP.Util.mergePath( target, uploadFileName );
			
			$.ajax({
				url: '<%=serveResourceURL.toString()%>',
				type: 'POST',
				async: false,
				dataType: 'json',
				data:{
					<portlet:namespace/>command: "CHECK_DUPLICATED",
					<portlet:namespace/>action: <portlet:namespace/>action,
					<portlet:namespace/>target: target
				},
				success:function(result){
					duplicated = result.duplicated;
				},
				error: function(){
					
				}
			});

			if( duplicated ){
				$('#<portlet:namespace/>uploadFileName').val(uploadFileName);
				
				var confirmDialog = $('#<portlet:namespace/>confirmDialog');
				confirmDialog.dialog(
					{
						resizable: false,
						height: "auto",
						width: 400,
						modal: true,
						buttons: {
							'OK': function() {
								<portlet:namespace/>submitUpload( 
										uploadFile, 
										OSP.Util.mergePath( <portlet:namespace/>basePath, uploadFolder),
										$('#<portlet:namespace/>uploadFileName').val()
								);
								$( this ).dialog( "close" );
							},
							Cancel: function() {
								$( this ).dialog( "close" );
							}
						}
					}
				);
			}
			else{
				<portlet:namespace/>submitUpload(
						uploadFile, 
						OSP.Util.mergePath( <portlet:namespace/>basePath, uploadFolder),
						uploadFileName
				);
			}
		}
);

/***********************************************************************
 * Handling OSP Events
 ***********************************************************************/
 Liferay.on(
		OSP.Event.OSP_HANDSHAKE,
		function( e ){
			var myId = '<%=portletDisplay.getId()%>';
			if( e.targetPortlet === myId ){
				<portlet:namespace/>connector = e.portletId;
				<portlet:namespace/>action = e.action;
				
				var events = [
					OSP.Event.OSP_EVENTS_REGISTERED,
					OSP.Event.OSP_LOAD_DATA,
					OSP.Event.OSP_REQUEST_DATA
				];
				var eventData = {
					portletId: myId,
					targetPortlet: <portlet:namespace/>connector,
					data: events
				};
				Liferay.fire( OSP.Event.OSP_REGISTER_EVENTS, eventData );
			}
		}
);

Liferay.on(
		OSP.Event.OSP_EVENTS_REGISTERED,
		function( e ){
			var myId = '<%=portletDisplay.getId()%>';
			if( e.targetPortlet === myId ){
			    <portlet:namespace/>passNamespace();
			    if( <portlet:namespace/>selectedFile ){
				    <portlet:namespace/>initFileExplorer( <portlet:namespace/>selectedFile );
				}
				else{
					var eventData = {
						portletId: myId,
						targetPortlet: <portlet:namespace/>connector
					};
					Liferay.fire( OSP.Event.OSP_REQUEST_PATH, eventData );
				}
			}
		}
);

Liferay.on(
		OSP.Event.OSP_LOAD_DATA,
		function( e ){
			var myId = '<%=portletDisplay.getId()%>';
			if( e.targetPortlet === myId ){
				var inputData = new OSP.InputData( e.data );
				
				<portlet:namespace/>initFileExplorer( inputData );
			}
		}
);

Liferay.on(
		OSP.Event.OSP_REQUEST_DATA,
		function( e ){
			var myId = '<%=portletDisplay.getId()%>';
			if( e.targetPortlet === myId ){
			    var data = new OSP.InputData();
				data.type(<portlet:namespace/>selectedFile.type());
				data.parent(OSP.Util.mergePath(<portlet:namespace/>basePath, <portlet:namespace/>selectedFile.parent()));
				data.name($('#<portlet:namespace/>selectedFile').val());
				data.relative( <portlet:namespace/>selectedFile.relative())
				
				var eventData = {
					portletId: myId,
					targetPortlet:e.portletId,
					data: OSP.Util.toJSON(data),
					action: e.action
				}
				Liferay.fire( OSP.Event.OSP_RESPONSE_DATA, eventData );
			}
		}
);

Liferay.on(
		OSP.Event.OSP_INITIALIZE,
		function( e ){
			var inputData = new OSP.InputData();
			inputData.type( OSP.Enumeration.PathType.FOLDER);
			inputData.parent( '' );
			inputData.name('');
			inputData.relative(true);
			<portlet:namespace/>initFileExplorer( inputData );
		}
);

Liferay.on(
		OSP.Event.OSP_REFRESH,
		function( e ){
			var myId = '<%=portletDisplay.getId()%>';
			if( e.targetPortlet === myId ){
				<portlet:namespace/>initFileExplorer( <portlet:namespace/>selectedFile );
			}
		}
);

/***********************************************************************
 * Golbal functions
 ***********************************************************************/
function <portlet:namespace/>initFileExplorer( inputData ){
	//console.log("inputData, init ", inputData, init);
	<portlet:namespace/>selectedFile = inputData.clone();

	<portlet:namespace/>selectedFile.type(inputData.type());
	<portlet:namespace/>selectedFile.relative(inputData.relative());
		
	switch( inputData.type() ){
		case OSP.Enumeration.PathType.FILE:
		case OSP.Enumeration.PathType.FOLDER:
			<portlet:namespace/>basePath = OSP.Util.removeEndSlashes ( inputData.parent() );
			var filePath = OSP.Util.convertToPath( inputData.name().trim() );
			<portlet:namespace/>selectedFile.parent(filePath.parent() ? filePath.parent() : '');
			<portlet:namespace/>selectedFile.name( filePath.name() ? filePath.name() : '' );
			break;
		case OSP.Enumeration.PathType.EXT:
		    <portlet:namespace/>basePath = OSP.Util.removeEndSlashes ( inputData.parent() );
			var filePath = OSP.Util.convertToPath( inputData.name() );
			<portlet:namespace/>selectedFile.parent( filePath.parent() );
			<portlet:namespace/>selectedFile.name( filePath.name() );
			<portlet:namespace/>extension = <portlet:namespace/>selectedFile.name();
			break;
		default:
			<portlet:namespace/>selectedFile.type( OSP.Enumeration.PathType.FOLDER );
			<portlet:namespace/>selectedFile.parent( '' );
			<portlet:namespace/>selectedFile.name( '' );
			<portlet:namespace/>selectedFile.relative( true );
	}
	
	$('#<portlet:namespace/>selectedFile').val(
													OSP.Util.mergePath(<portlet:namespace/>selectedFile.parent(), 
																					 <portlet:namespace/>selectedFile.name()) );
	
	var basePath = <portlet:namespace/>basePath;
	var parentPath;
	var fileName = "";
	if(<portlet:namespace/>selectedFile.type() === OSP.Enumeration.PathType.FOLDER){
	    parentPath = OSP.Util.mergePath(<portlet:namespace/>selectedFile.parent(), 
                                        <portlet:namespace/>selectedFile.name()); 
	}else{
	    parentPath = <portlet:namespace/>selectedFile.parent();
	}
	var pathType = OSP.Enumeration.PathType.FOLDER;
	var relative = <portlet:namespace/>selectedFile.relative();
	<portlet:namespace/>lookupPath(
			'GET_FILE_INFO',
			pathType,
			basePath, 
			parentPath,
			fileName
	);
}

function <portlet:namespace/>lookupFolder( parentPath, folderName ){
    console.log( 'Parent Path in lookupFolder: '+parentPath );
	var data = {
				<portlet:namespace/>command: 'GET_FILE_INFO',
				<portlet:namespace/>action: <portlet:namespace/>action,
				<portlet:namespace/>pathType: 'folder',
				<portlet:namespace/>basePath: <portlet:namespace/>basePath,
				<portlet:namespace/>parentPath: parentPath,
				<portlet:namespace/>fileName: folderName
	};

	var fileInfos = null;

	$.ajax({
		type: 'POST',
		url: '<%= serveResourceURL.toString()%>', 
		data  : data,
		dataType : 'json',
		success: function(data) {
			//console.log(JSON.stringify(data, null, 4));
			console.log( 'Parent Path: '+parentPath );
			<portlet:namespace/>loadFileExplorer( 
											<portlet:namespace/>basePath, 
											parentPath,
			                               data.fileInfos );
		},
		error:function(data,e){
			console.log(data);
			console.log('AJAX ERROR-->'+e);
		}
	});
}

function <portlet:namespace/>lookupPath( 
		command, 
		pathType, 
		basePath, 
		parentPath, 
		fileName){
	var data = {
					<portlet:namespace/>command: command,
					<portlet:namespace/>action: <portlet:namespace/>action,
					<portlet:namespace/>pathType: pathType,
					<portlet:namespace/>basePath: basePath,
					<portlet:namespace/>parentPath: parentPath,
					<portlet:namespace/>fileName: fileName
			};
	
	var fileInfos = null;
	
	$.ajax({
		type: 'POST',
		url: '<%= serveResourceURL.toString()%>', 
		data  : data,
		dataType : 'json',
		success: function(data) {
			fileInfos = data;
			//console.log(JSON.stringify(fileInfos, null, 4));
			<portlet:namespace/>loadFileExplorer( 
			                               basePath, 
			                               parentPath,
			                               fileInfos.fileInfos );
		},
		error:function(data,e){
			console.log(data);
			console.log('AJAX ERROR-->'+e);
		}
	});
	
	return fileInfos;
}
function <portlet:namespace/>loadFileExplorer( basePath, parentPath, fileList ){
    setTimeout(
	    function(){
	        var iframe = document.getElementById('<portlet:namespace/>canvas');
	        
	        console.log('loadFileExplorer: ');
	        if( <portlet:namespace/>iframeReady() && iframe.contentWindow.loadFileExplorer){
	    		iframe.contentWindow.loadFileExplorer(
	    				basePath,
	    				parentPath,
	    				fileList,
	    				$('#<portlet:namespace/>canvas').width(),
	    				$('#<portlet:namespace/>canvas').height()
	    		);
	    	}
	    	else{
	    	    <portlet:namespace/>loadFileExplorer( basePath, parentPath, fileList );
	    	}
	    }, 
	    10
	);
}

function <portlet:namespace/>setSelectedFile( folderPath, fileName, type ){
    console.log( 'folder name: '+folderPath);
    console.log( 'file name: '+fileName);
    console.log( 'type: '+type);
	$('#<portlet:namespace/>selectedFile').val( OSP.Util.mergePath( folderPath, fileName ) );
	<portlet:namespace/>selectedFile.type( type );
	<portlet:namespace/>selectedFile.parent( folderPath );
	<portlet:namespace/>selectedFile.name( fileName );
	
	var eventData = {
	     			portletId: '<%=portletDisplay.getId()%>',
	     			targetPortlet: <portlet:namespace/>connector,
	     			data: OSP.Util.toJSON(<portlet:namespace/>selectedFile)
	};
	     	
	Liferay.fire( OSP.Event.OSP_DATA_CHANGED, eventData );
}

function <portlet:namespace/>submitUpload( uploadFile, targetFolder, fileName ){
	//var uploadFolder = OSP.Util.mergePath( <portlet:namespace/>basePath, <portlet:namespace/>selectedFile.parent());
		
	var formData = new FormData();
	formData.append('<portlet:namespace/>uploadFile', uploadFile);
	formData.append('<portlet:namespace/>command', 'UPLOAD');
	formData.append('<portlet:namespace/>action', <portlet:namespace/>action);
	formData.append('<portlet:namespace/>targetFolder', targetFolder);
	formData.append('<portlet:namespace/>fileName', fileName);

	$.ajax({
		url : '<%=serveResourceURL.toString()%>',
		type : 'POST',
		data : formData,
		processData: false,  // tell jQuery not to process the data
		contentType: false,  // tell jQuery not to set contentType
		success : function(data) {
			<portlet:namespace/>initFileExplorer( <portlet:namespace/>selectedFile );
		}
	});
}
</script>


