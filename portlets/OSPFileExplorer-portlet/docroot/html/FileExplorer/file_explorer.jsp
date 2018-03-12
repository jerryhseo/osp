<%@page import="com.kisti.osp.constants.OSPRepositoryTypes"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@ include file="../init.jsp" %>

<%-- <script src="<%=request.getContextPath()%>/js/jquery/jquery-1.10.2.min.js"></script>
<script src="<%=request.getContextPath()%>/js/osp/osp_basic_object.js"></script>
<script src="<%=request.getContextPath()%>/js/osp/osp_super_class.js"></script>
<script src="<%=request.getContextPath()%>/js/osp/osp_datatype.js"></script> --%>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css"/>

 <portlet:resourceURL var="serveResourceURL"></portlet:resourceURL>

<%
PortletPreferences preferences = portletDisplay.getPortletSetup();
preferences.setValue("portletSetupShowBorders", String.valueOf(Boolean.FALSE));
preferences.store();

String inputData = (String)renderRequest.getAttribute("inputData");
boolean eventEnable = (Boolean)renderRequest.getAttribute("eventEnable");
String connector = (String)renderRequest.getAttribute("connector");
String mode = (String)renderRequest.getAttribute("mode");

boolean isEditMode = mode.equalsIgnoreCase("EDIT");
%>

<div class="container-fluid osp-editor file-explorer-portlet " style="height:inherit;">
	<div class="row-fluid header">
		<div class="col-sm-10">
			<input class="form-control" id="<portlet:namespace/>selectedFile" style="width:100%;"/>
		</div>
		<c:if test="<%=isEditMode%>">
			<div class="col-sm-2">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
						Menu<span class="caret"></span>
    				</button>
					<ul class="dropdown-menu dropdown-menu-right">
	                       <li><a href="javascript:<portlet:namespace/>takeSample()"><i class="icon-file"></i>Sample</a></li>
	                       <li><a href="javascript:<portlet:namespace/>upload()"><i class="icon-upload"></i> Upload</a></li>
	                       <li><a href="javascript:<portlet:namespace/>download()"><i class="icon-download-alt"></i> Download</a></li>					
					</ul>
				</div>
			</div>	
		</c:if>
	</div>
	<div class="row-fluid frame">
		<iframe class="col-sm-12 iframe-canvas" id="<portlet:namespace/>canvas" src="<%=request.getContextPath()%>/html/FileExplorer/load_explorer.jsp"></iframe>
	</div>
</div>
<div id="<portlet:namespace/>hiddenSection" class="osp-editor hidden">
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
	<input
			type="file"
			id="<portlet:namespace/>selectLocalFile"
			name="<portlet:namespace/>uploadFile"
	/>
</div>

<script>
/***********************************************************************
 * Global variables section
 ***********************************************************************/
<portlet:namespace/>passNamespace();
var <portlet:namespace/>canvas = $('#<portlet:namespace/>canvas');
var <portlet:namespace/>connector = '<%=connector%>';
var <portlet:namespace/>downloadMode = false;
var <portlet:namespace/>eventEnable = <%=eventEnable %>;
var <portlet:namespace/>mode = '<%=mode %>';

var <portlet:namespace/>sampleSelected = false;
var <portlet:namespace/>selectedFile;
var <portlet:namespace/>baseDir;

var <portlet:namespace/>runningMode = '_DEBUG_';
/***********************************************************************
 * Initailization section using parameters
 ***********************************************************************/
if( !<portlet:namespace/>eventEnable ){
	var inputData = '<%=inputData%>';
	if( $.isEmptyObject( inputData ) ){
		//console.log('eventEnable false but inputData is empty......');
	    <portlet:namespace/>baseDir = new OSP.InputData();
	    <portlet:namespace/>baseDir.parent( '');
	    <portlet:namespace/>baseDir.name('');
	    <portlet:namespace/>baseDir.type(OSP.Enumeration.PathType.FOLDER);
	    <portlet:namespace/>baseDir.repositoryType('<%=OSPRepositoryTypes.USER_HOME.toString()%>');
	    <portlet:namespace/>baseDir.relative( true );
	}
	else{
		//console.log('eventEnable false with inputData......', inputData );
	    <portlet:namespace/>baseDir = new OSP.InputData(JSON.parse(inputData));
	    if( !<portlet:namespace/>baseDir.repositoryType() )
	    	<portlet:namespace/>baseDir.repositoryType('<%=OSPRepositoryTypes.USER_HOME.toString()%>');
	}
	
	<portlet:namespace/>selectedFile = <portlet:namespace/>baseDir.clone();
	
	//console.log( 'FileExplorer: ', <portlet:namespace/>selectedFile );
	<portlet:namespace/>initFileExplorer(<portlet:namespace/>selectedFile );
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
function <portlet:namespace/>upload(){
	$('#<portlet:namespace/>selectFile').click();
}

function <portlet:namespace/>takeSample(){
	$('#<portlet:namespace/>selectedFile').val( '--- sample selected ---');
	$('#<portlet:namespace/>selectedFile').attr('disabled', true);
	<portlet:namespace/>sampleSelected = true;
	
	var eventData = {
			portletId: '<%=portletDisplay.getId()%>',
			targetPortlet: <portlet:namespace/>connector
	}
	
	Liferay.fire( OSP.Event.OSP_SAMPLE_SELECTED, eventData );
}


function <portlet:namespace/>download(){
	var iframe = document.getElementById('<portlet:namespace/>canvas');
	
	if( <portlet:namespace/>downloadMode === false ){
		<portlet:namespace/>downloadMode = true;
		iframe.contentWindow.showCheckbox( <portlet:namespace/>downloadMode );
		alert('To download files, select files to be downloaded and SELECT AGAIN download menu.');
		return;
	}
	
	var selectedFiles = iframe.contentWindow.getSelectedFiles();
	data = {
		<portlet:namespace/>command: 'DOWNLOAD',
		<portlet:namespace/>fileNames: JSON.stringify(selectedFiles),
		<portlet:namespace/>folderPath: <portlet:namespace/>selectedFile.parent(),
		<portlet:namespace/>repositoryType: <portlet:namespace/>selectedFile.repositoryType_
	};
	
	var base = '<%=serveResourceURL.toString()%>';
	var sep = (base.indexOf('?') > -1) ? '&' : '?';
	var url = base+sep+$.param(data);
	
	//console.log( 'Download URL: '+ url);
	($('#<portlet:namespace/>downloadAnchor').attr('href', url))[0].click();
	
	<portlet:namespace/>downloadMode = false;
	iframe.contentWindow.showCheckbox( <portlet:namespace/>downloadMode );
}

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
			
			var uploadFolder;
			if( <portlet:namespace/>selectedFile.type() === 'folder' ){
				uploadFolder = OSP.Util.mergePath( 
			                                       <portlet:namespace/>selectedFile.parent(),
			                                       <portlet:namespace/>selectedFile.name());
			}
			else{
				uploadFolder = <portlet:namespace/>selectedFile.parent();
			}
			//console.log('Upload Folder: '+ uploadFolder);
			//console.log('repositoryType: '+ <portlet:namespace/>selectedFile.repositoryType_);
			
			// check that file name is duplicated using AJAX.
			var checkDuplicated = function( target ){
				$.ajax({
					url: '<%=serveResourceURL.toString()%>',
					type: 'POST',
					dataType: 'json',
					data:{
						<portlet:namespace/>command: "CHECK_DUPLICATED",
						<portlet:namespace/>repositoryType: <portlet:namespace/>selectedFile.repositoryType_,
						<portlet:namespace/>target: target
					},
					success:function(result){
						duplicated = result.duplicated;
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
													uploadFolder,
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
									uploadFolder,
									uploadFileName
							);
						}
					},
					error: function(){
						
					}
				});
			};
			
			var target = OSP.Util.mergePath( uploadFolder, uploadFileName );
			checkDuplicated( target );
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
			    /*
			    if( ! <portlet:namespace/>selectedFile ){
					<portlet:namespace/>selectedFile = new OSP.InputData();
					<portlet:namespace/>selectedFile.type(OSP.Enumeration.PathType.FOLDER);
					<portlet:namespace/>selectedFile.repositoryType('<%=OSPRepositoryTypes.USER_HOME.toString()%>');
					<portlet:namespace/>selectedFile.parent('');
					<portlet:namespace/>selectedFile.name('');
					<portlet:namespace/>initFileExplorer( <portlet:namespace/>selectedFile );
				}
			    */
			}
		}
);

Liferay.on(
		OSP.Event.OSP_LOAD_DATA,
		function( e ){
			var myId = '<%=portletDisplay.getId()%>';
			if( e.targetPortlet === myId ){
			    console.log('['+myId+'] OSP_LOAD_DATA: ', e );
				
			    <portlet:namespace/>baseDir = new OSP.InputData( e.data );
				 if( !<portlet:namespace/>baseDir.repositoryType() ){
					 <portlet:namespace/>baseDir.repositoryType('<%=OSPRepositoryTypes.USER_HOME.toString()%>');
				}
				
				<portlet:namespace/>selectedFile = <portlet:namespace/>baseDir.clone();
				
				<portlet:namespace/>initFileExplorer( <portlet:namespace/>selectedFile );
			}
		}
);

Liferay.on(
		OSP.Event.OSP_REQUEST_DATA,
		function( e ){
			var myId = '<%=portletDisplay.getId()%>';
			if( e.targetPortlet === myId ){
				
				var eventData = {
					portletId: myId,
					targetPortlet:e.portletId,
					data: OSP.Util.toJSON(<portlet:namespace/>selectedFile),
					params: e.params
				}
				Liferay.fire( OSP.Event.OSP_RESPONSE_DATA, eventData );
			}
		}
);

Liferay.on(
		OSP.Event.OSP_INITIALIZE,
		function( e ){
			if( e.targetPortlet === '<%=portletDisplay.getId()%>'){
				/*
				var inputData = new OSP.InputData();
				var repositoryType;
				if( <portlet:namespace/>selectedFile.repositoryType_ )
					repositoryType = <portlet:namespace/>selectedFile.repositoryType_;
				else{
					'<%=OSPRepositoryTypes.USER_HOME.toString()%>';
				}
 
				inputData.repositoryType( repositoryType );
				inputData.type( OSP.Enumeration.PathType.FOLDER);
				inputData.parent( '' );
				inputData.name('');
				inputData.relative(true);
				<portlet:namespace/>initFileExplorer( inputData );
				*/
				<portlet:namespace/>selectedFile = <portlet:namespace/>baseDir;
				<portlet:namespace/>initFileExplorer( <portlet:namespace/>selectedFile );
			}
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
	/*
	<portlet:namespace/>selectedFile = inputData.clone();
	if( !<portlet:namespace/>selectedFile.repositoryType() )
		<portlet:namespace/>selectedFile.repositoryType('<%=OSPRepositoryTypes.USER_HOME.toString()%>');
		*/

	switch( inputData.type() ){
		case OSP.Enumeration.PathType.FILE:
		case OSP.Enumeration.PathType.FOLDER:
			var filePath = OSP.Util.convertToPath( inputData.name().trim() );
			<portlet:namespace/>selectedFile.parent(OSP.Util.mergePath( inputData.parent(), filePath.parent()));
			<portlet:namespace/>selectedFile.name( filePath.name() ? filePath.name() : '' );
			<portlet:namespace/>lookupPath(
			                               'GET_FILE_INFO',
			                     			OSP.Enumeration.PathType.FOLDER,
			                     			<portlet:namespace/>selectedFile.parent(),
			                     			''
			                     	);
			$('#<portlet:namespace/>selectedFile').val(<portlet:namespace/>selectedFile.parent());
			break;
		case OSP.Enumeration.PathType.EXT:
			var filePath = OSP.Util.convertToPath( inputData.name().trim() );
			<portlet:namespace/>selectedFile.parent(OSP.Util.mergePath( inputData.parent(), filePath.parent()));
			<portlet:namespace/>selectedFile.name( filePath.name() );
			$('#<portlet:namespace/>selectedFile').val(<portlet:namespace/>selectedFile.parent()+'/*.'+filePath.name());
			<portlet:namespace/>lookupPath(
			                                 'GET_FILE_INFO',
			                     			OSP.Enumeration.PathType.EXT,
			                     			<portlet:namespace/>selectedFile.parent(),
			                     			<portlet:namespace/>selectedFile.name()
			                     	);
			break;
		case OSP.Enumeration.PathType.DLENTRY_ID:
			$('#<portlet:namespace/>selectedFile').val( '--- sample selected ---');
			$('#<portlet:namespace/>selectedFile').attr('disabled', true);
			<portlet:namespace/>sampleSelected = true;
			return;
		default:
			<portlet:namespace/>selectedFile.type( OSP.Enumeration.PathType.FOLDER );
			<portlet:namespace/>selectedFile.parent( '' );
			<portlet:namespace/>selectedFile.name( '' );
			<portlet:namespace/>lookupPath( 'GET_FILE_INFO','', '', OSP.Enumeration.PathType.FOLDER);
			$('#<portlet:namespace/>selectedFile').val('');
	}
}

function <portlet:namespace/>lookupFolder( parentPath, folderName ){
	var basePath = OSP.Util.convertToPath(<portlet:namespace/>baseDir.name());
	<portlet:namespace/>lookupPath(
                                             'GET_FILE_INFO',
                                             <portlet:namespace/>baseDir.type(),
                                             OSP.Util.mergePath( parentPath, folderName ),
                                             basePath.name()
	                               );
}

function <portlet:namespace/>lookupPath( 
		command, 
		pathType, 
		parentPath, 
		fileName){
	
	var data = {
					<portlet:namespace/>command: command,
					<portlet:namespace/>repositoryType: <portlet:namespace/>baseDir.repositoryType(),
					<portlet:namespace/>pathType: pathType,
					<portlet:namespace/>parentPath: parentPath,
					<portlet:namespace/>fileName: fileName
			};
	// console.log( 'lookupPath: ', data );
	
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
			                               fileInfos.parentPath,
			                               fileInfos.fileInfos );
		},
		error:function(data,e){
			console.log(data);
			console.log('AJAX ERROR-->'+e);
		}
	});
	
	return fileInfos;
}
function <portlet:namespace/>loadFileExplorer( folderPath, fileList ){
	//console.log('loadFileExplorer parentPath: ', parentPath);
    setTimeout(
	    function(){
	        var iframe = document.getElementById('<portlet:namespace/>canvas');
	        
	        if( <portlet:namespace/>iframeReady() && iframe.contentWindow.loadFileExplorer){
	    		iframe.contentWindow.loadFileExplorer(
	    				folderPath,
	    				fileList,
	    				$('#<portlet:namespace/>canvas').width(),
	    				$('#<portlet:namespace/>canvas').height()
	    		);
	    	}
	    	else{
	    	    <portlet:namespace/>loadFileExplorer(folderPath, fileList );
	    	}
	    }, 
	    10
	);
}

function <portlet:namespace/>setSelectedFile( folderPath, fileName, type ){
	$('#<portlet:namespace/>selectedFile').val( OSP.Util.mergePath( folderPath, fileName ) );
	if( type ){
		<portlet:namespace/>selectedFile.type( type );
	}
	else{
		<portlet:namespace/>selectedFile.type(<portlet:namespace/>baseDir.type());
	}
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
	var formData = new FormData();
	formData.append('<portlet:namespace/>uploadFile', uploadFile);
	formData.append('<portlet:namespace/>command', 'UPLOAD');
	formData.append('<portlet:namespace/>repositoryType', <portlet:namespace/>selectedFile.repositoryType_);
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



