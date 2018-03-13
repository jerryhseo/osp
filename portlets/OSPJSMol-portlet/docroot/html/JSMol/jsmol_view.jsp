<%@page import="com.kisti.osp.constants.OSPRepositoryTypes"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@include file="../init.jsp"%>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css">
<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>

<portlet:resourceURL var="serveResourceURL"></portlet:resourceURL>
<portlet:renderURL var="renderURL">
    <portlet:param name="jspPage" value="/html/JSMol/load_jsmol.jsp"/>
</portlet:renderURL>

<%
PortletPreferences preferences = portletDisplay.getPortletSetup();
preferences.setValue("portletSetupShowBorders", String.valueOf(Boolean.FALSE));
preferences.store();

String inputData = GetterUtil.getString(renderRequest.getAttribute("inputData"), "{}");
String connector = (String)renderRequest.getAttribute("connector");
String mode = GetterUtil.getString(renderRequest.getAttribute("mode"), "VIEW");
boolean eventEnable = GetterUtil.getBoolean(renderRequest.getAttribute("eventEnable"), true);
%>


<div class="container-fluid osp-analyzer">
	<div class="row-fluid header">
		<div class="col-sm-10" id="<portlet:namespace/>title"></div>
		<div class="col-sm-2" >
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
					Menu<span class="caret"></span>
				</button>
				<!-- Link or button to toggle dropdown -->
				<ul class="dropdown-menu dropdown-menu-right">
					<li ><a href="javascript:<portlet:namespace/>openLocalFile()"><i class="icon-folder-open"> Open local...</i></a></li>
					<li><a href="javascript:<portlet:namespace/>openServerFile()"><i class="icon-folder-open"> Open server...</i></a></li>
					<li><a href="javascript:<portlet:namespace/>downloadCurrentFile()"><i class="icon-download-alt"> Download</i></a></li> 
				</ul>
			</div>
		</div>	
	</div>
	<div class="row-fluid frame">
		<iframe class ="col-sm-12 iframe-canvas" id="<portlet:namespace/>canvas" src="<%=request.getContextPath()%>/html/JSMol/load_jsmol.jsp">
		</iframe>
	</div>
</div>

<div id="<portlet:namespace/>hiddenSection" class="osp-analyzer hidden">
	<div id="<portlet:namespace/>fileExplorer" class="panel panel-primary ui-draggable" style="padding:0px;margin-bottom:0px;">
		<!-- title -->
		<div class="panel-heading">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true" id='<portlet:namespace/>closeDialog'>&times;</button>
			<h4>Select a File</h4>
		</div>
		
		<!-- content -->
		<div class="panel-body" id="<portlet:namespace/>file-explorer-content" style="height: 81%"></div>

		
		<!-- bottom -->
		<div class="panel-footer">
			<div class="ui-dialog-buttonset">
				<input class="btn btn-primary" id="<portlet:namespace/>file-explorer-ok" type="button" value="OK">
				<input class="btn" id="<portlet:namespace/>file-explorer-cancel" type="button" value="Cancel">
			</div>
		</div>	
		
	</div>
	

	<input type="file" id="<portlet:namespace/>selectFile"/>
</div>




<script>

/***********************************************************************
 * Global variables section
 ***********************************************************************/
var <portlet:namespace/>connector;
var $<portlet:namespace/>fileExplorerDialogSection = $('#<portlet:namespace/>fileExplorer');
var <portlet:namespace/>fileExplorerId = "FileExplorer_WAR_OSPFileExplorerportlet_INSTANCE_js";
if( "<portlet:namespace/>".lastIndexOf("_INSTANCE_") > 0)
	<portlet:namespace/>fileExplorerId += "<portlet:namespace/>".substring("<portlet:namespace/>".lastIndexOf("_INSTANCE_")+10);
else
	<portlet:namespace/>fileExplorerId += '001'; 
console.log('[JSMol] file explorer id Check : '+<portlet:namespace/>fileExplorerId);
	
var <portlet:namespace/>initData;
var <portlet:namespace/>currentData;
var <portlet:namespace/>mode = '<%=mode%>';
var <portlet:namespace/>eventEnable = JSON.parse('<%=eventEnable%>');


/***********************************************************************
 * Initailization section using parameters
***********************************************************************/
// for test
// <portlet:namespace/>eventEnable = false;

if( <portlet:namespace/>eventEnable === false ){
	var inputData = '<%=inputData%>';
	<portlet:namespace/>connector = '<%=connector%>';
	if(!inputData){
		<portlet:namespace/>initData = new OSP.InputData();
	}else{
		<portlet:namespace/>initData = new OSP.InputData(JSON.parse(inputData));
	}

	<portlet:namespace/>connector = '<%=connector%>';
	//for test
//	<portlet:namespace/>initData.type_ = 'file';
//	<portlet:namespace/>initData.parent_ = 'pdbs';
//	<portlet:namespace/>initData.name_ = '1nmr.pdb';

  <portlet:namespace/>loadJSMolFile( <portlet:namespace/>initData );
}

$("#<portlet:namespace/>fileExplorer").dialog({
	autoOpen: false,
	resizable: false,
	height: 600,
	width: 450,
	modal: true,
	show: {effect:'fade', speed: 800}, 
    hide: {effect:'fade', speed: 800}
});
$(".ui-dialog-titlebar").remove();


$("#<portlet:namespace/>closeDialog").click(function() {
	$("#<portlet:namespace/>fileExplorer").dialog("close");
});

/***********************************************************************
 * Menu click events and binding functions 
 ***********************************************************************/
function <portlet:namespace/>openLocalFile(){
	$('#<portlet:namespace/>selectFile').click();
}

function <portlet:namespace/>openServerFile(){
	var inputData;
    if(<portlet:namespace/>currentData && 
        <portlet:namespace/>currentData.type() !== OSP.Enumeration.PathType.URI &&
        <portlet:namespace/>currentData.type() !== OSP.Enumeration.PathType.CONTEXT ){
        inputData = <portlet:namespace/>currentData;
    }else{
        inputData = new OSP.InputData();
        inputData.type( OSP.Enumeration.PathType.FOLDER );
        inputData.parent('');
        inputData.name('');
        inputData.repositoryType('<%=OSPRepositoryTypes.USER_HOME.toString()%>');
    }
   
    <portlet:namespace/>fileExplorerDialog('VIEW', inputData);
}

function <portlet:namespace/>downloadCurrentFile(){
	console.log("[JSMol] download Request.");
	<portlet:namespace/>downloadCurrentFile();
}

$("#<portlet:namespace/>file-explorer-ok").click(function(e){
	e.preventDefault();
	var eventData = {
		portletId : '<%=portletDisplay.getId()%>',
		targetPortlet : <portlet:namespace/>fileExplorerId,
	};
	Liferay.fire( OSP.Event.OSP_REQUEST_DATA, eventData);
	$<portlet:namespace/>fileExplorerDialogSection.dialog( 'close' );
});

$("#<portlet:namespace/>file-explorer-cancel").click(function(e){
	$<portlet:namespace/>fileExplorerDialogSection.dialog( 'close' );
});

$('#<portlet:namespace/>selectFile').bind(
	'change', 
	function(event){
		var input = document.getElementById('<portlet:namespace/>selectFile');
		var reader = new FileReader();
            
		reader.onload = function (e) {
			$('#<portlet:namespace/>canvas').each(function(){
				$(this).prop('contentWindow').loadJSMolFile(e.target.result);
					console.log("[JSMOL] local file load event 1 : ", e.target);
					console.log("[JSMOL] local file load event 2 : ", e.target.result);
			});
	        console.log("[JSMOL] local file test : ", input);
			console.log("[JSMOL] local file test2 : ", input.files[0]);
			
	        
			<portlet:namespace/>setTitle(input.files[0].name);
		    <portlet:namespace/>currentData = null;
			delete <portlet:namespace/>currentData;
		};
            
		reader.readAsDataURL(input.files[0]);
	}
);

function <portlet:namespace/>fileExplorerDialog( mode, inputData ){
    AUI().use('liferay-portlet-url', function(A){
  
        var dialogURL = Liferay.PortletURL.createRenderURL();
        dialogURL.setPortletId(<portlet:namespace/>fileExplorerId);
        dialogURL.setParameter('inputData', JSON.stringify(inputData));
        //dialogURL.setParameter('loadNow', true);
        dialogURL.setParameter('mode', mode);
        dialogURL.setParameter('eventEnable', false);
        dialogURL.setParameter('connector', '<%=portletDisplay.getId()%>');
        dialogURL.setWindowState('<%=LiferayWindowState.EXCLUSIVE%>');

        console.log("[JSMol] file explorer call inputData  : ", inputData);
        console.log("[JSMol] file explorer url : ", dialogURL);
        console.log("[JSMol] file explorer url2 : " + dialogURL);
        if( $('#<portlet:namespace/>file-explorer-content').children().length > 0 ){
        	$<portlet:namespace/>fileExplorerDialogSection.dialog("open");
		}
        else{
			$("#<portlet:namespace/>file-explorer-content").load( dialogURL.toString());
			$<portlet:namespace/>fileExplorerDialogSection.dialog("open");
        }
	});
}

/***********************************************************************
 * Handling OSP Events
***********************************************************************/
Liferay.on(
  	OSP.Event.OSP_HANDSHAKE,
  	function(e){
  		var myId = '<%=portletDisplay.getId()%>';
  		if( e.targetPortlet === myId ){
  			console.log('[JSMol]OSP_HANDSHAKE: ['+e.portletId+', '+new Date()+']');
  			<portlet:namespace/>connector = e.portletId;
  			if( e.mode )
  				<portlet:namespace/>action = e.mode;
  			else
  				<portlet:namespace/>action = 'VIEW';	
  			var events = [
  				OSP.Event.OSP_EVENTS_REGISTERED,
  				OSP.Event.OSP_LOAD_DATA
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
	function(e){
		var myId = '<%=portletDisplay.getId()%>';
		if(e.targetPortlet === myId){
			console.log('[JSMOL]Regestered'+e.portletId+' activated. '+new Date()+']');
		}
	}
);

Liferay.on( 
	OSP.Event.OSP_LOAD_DATA, 
	function(e){
		var myId = '<%=portletDisplay.getId()%>';
		if( e.targetPortlet === myId ){
			console.log('[JSMol]OSP_LOAD_DATA: ['+e.portletId+', '+new Date()+']', e.data);
			//<portlet:namespace/>initData = new OSP.InputData( e.data );
			<portlet:namespace/>currentData = new OSP.InputData( e.data );
			if( <portlet:namespace/>currentData.type() === OSP.Enumeration.PathType.FOLDER ){
				<portlet:namespace/>currentData.parent(
					OSP.Util.mergePath(<portlet:namespace/>currentData.parent(), <portlet:namespace/>currentData.name()));
					//<portlet:namespace/>initData.name("");
					<portlet:namespace/>currentData.name("");
			}
			<portlet:namespace/>loadJSMolFile( <portlet:namespace/>currentData );
		}
	}
);

Liferay.on(
           OSP.Event.OSP_RESPONSE_DATA,
           function( e ){
               if( e.targetPortlet === '<%=portletDisplay.getId()%>' ){
                   console.log('[JSMOL] OSP_RESPONSE_DATA: ['+e.portletId+', '+new Date()+']');
                   if( e.portletId === <portlet:namespace/>fileExplorerId ){
                       var inputData = new OSP.InputData( e.data );
                       
                       if( inputData.type() !== OSP.Enumeration.PathType.FILE ){
                           alert( 'File should be selected!' );
                           return;
                       }
                       else{
                           <portlet:namespace/>loadJSMolFile( inputData );
                           $<portlet:namespace/>fileExplorerDialogSection.dialog('close');
                       }
                   }
               }
           }
);


Liferay.on(
		OSP.Event.OSP_REFRESH_OUTPUT_VIEW,
		function(e){
			console.log('[JSMol]OSP_REFRESH_OUTPUT_VIEW: ['+e.portletId+', '+new Date()+']');
			var eventData = {
					portletId: '<%=portletDisplay.getId()%>',
					targetPortlet: <portlet:namespace/>connector
			};

			Liferay.fire(OSP.Event.OSP_REQUEST_OUTPUT_PATH, eventData);
		}
);

/***********************************************************************
 * Golbal functions
 ***********************************************************************/
function <portlet:namespace/>loadJSMolFile( inputData ){
	
	console.log("[JSMol] Load Data : input Data ", inputData);
	switch( inputData.type() ){
	case OSP.Enumeration.PathType.FILE:
	    <portlet:namespace/>drawJSMol( inputData );
		break;
	case OSP.Enumeration.PathType.FOLDER:
	case OSP.Enumeration.PathType.EXT:
	    <portlet:namespace/>getFirstFileName( inputData );
	    // serveResourceUrl.setParameter('command', 'READ_FIRST_FILE');
		break;
	case OSP.Enumeration.PathType.URL:
		alert('Un supported yet.'+inputData.type());
		break;
	default:
		alert('Un supported yet.'+inputData.type());
	}
}

function <portlet:namespace/>drawJSMol( inputData ){
    setTimeout(
	    function(){
	    	var iframe = document.getElementById('<portlet:namespace/>canvas');
	    	var iframeDoc = iframe.contentDocument || iframe.contentWindow.document;

	    	console.log( '[JSMol]iframeDoc.readyState : ', iframeDoc.readyState);
	    	if (  iframeDoc.readyState  == 'complete' && iframe.contentWindow.loadJSMolFile ) {
	    		
	    		console.log("[JSMol] test 1 : load data in drawJSMol");
	    	    AUI().use('liferay-portlet-url', function(a) {
	                <portlet:namespace/>currentData = inputData.clone();
	                if( !<portlet:namespace/>currentData.repositoryType() )
	                	<portlet:namespace/>currentData.repositoryType('<%=OSPRepositoryTypes.USER_JOBS.toString()%>');

	    	        var serveResourceUrl = Liferay.PortletURL.createResourceURL();
	    	        
	    	        serveResourceUrl.setPortletId('<%=portletDisplay.getId()%>');
	    	        serveResourceUrl.setParameter('command', 'GET_FILE');
	    	        serveResourceUrl.setParameter('repositoryType', <portlet:namespace/>currentData.repositoryType());
	    	        serveResourceUrl.setParameter('pathType', inputData.type());
	    	        serveResourceUrl.setParameter('parentPath', inputData.parent());
	    	        serveResourceUrl.setParameter('fileName', inputData.name());
	    	        serveResourceUrl.setParameter('relative', inputData.relative());
	    	        
	    	        console.log( '[JSMol]Draw JSMol: ', inputData);
	    	        
		    	    iframe.contentWindow.loadJSMolFile(serveResourceUrl.toString());
		    	    
		    	    $('#<portlet:namespace/>title').html(inputData.name());
	    	    });
	    	} 
	    	else{
	    		console.log("[JSMol] test esle : load data in drawJSMol");
	    	
	    		<portlet:namespace/>drawJSMol( inputData );
	    	}
	    }
	);
}

function <portlet:namespace/>getFirstFileName( argData ){
    console.log('[JSMol]get First File Name : ', argData );
    var inputData = argData.clone();
    console.log('[JSMol]get First File Name2 : ', inputData );
    
    
    if( inputData.type() === 'folder' ){
    	inputData.parent( OSP.Util.mergePath(inputData.parent(), inputData.name()) );
    	inputData.name('');
    }
    if( ! inputData.repositoryType() )
		inputData.repositoryType( '<%=OSPRepositoryTypes.USER_HOME.toString()%>');
    
   
    
    //if( !inputData.repositoryType() )
    //	inputData.repositoryType( '<%=OSPRepositoryTypes.USER_JOBS.toString()%>');
    
    
    var data = {
            <portlet:namespace/>command: 'GET_FIRST_FILE_NAME',
            <portlet:namespace/>pathType: inputData.type(),
            <portlet:namespace/>repositoryType: inputData.repositoryType(),
            <portlet:namespace/>parentPath: inputData.parent(),
            <portlet:namespace/>fileName: inputData.name()
    };
        
    console.log("[JSMOL] laod get first file test : ", data);
    $.ajax({
        type: 'POST',
        url: '<%= serveResourceURL.toString()%>', 
        data  : data,
        dataType : 'json',
        success: function(data) {
            inputData.type( OSP.Enumeration.PathType.FILE );
            inputData.name( data.fileName );
            <portlet:namespace/>drawJSMol( inputData );
            console.log("[JSMOL] Get First File Data : ", inputData);
        },
        error:function(data,e){
        	console.log('[JSMOL]AJAX ERROR1-->', data);
            console.log('[JSMOL]AJAX ERROR2-->', e);
        },
        complete: function( jqXHR, textStatus ){
        }
    });
}

function <portlet:namespace/>downloadCurrentFile(){
	console.log("[JSMol] Download current file");
	console.log("[JSMol] Download current data", <portlet:namespace/>currentData);
    if(<portlet:namespace/>currentData &&
        <portlet:namespace/>currentData.type() === OSP.Enumeration.PathType.FILE ){
        var filePath = <portlet:namespace/>currentData;
        var data = {
            <portlet:namespace/>command: "DOWNLOAD_FILE",
            <portlet:namespace/>pathType: filePath.type(),
            <portlet:namespace/>repositoryType: filePath.repositoryType(),
            <portlet:namespace/>parentPath: filePath.parent(),
            <portlet:namespace/>fileName: filePath.name(),
            <portlet:namespace/>relative: filePath.relative()
        };
        
        var base = '<%=serveResourceURL.toString()%>';
        var sep = (base.indexOf('?') > -1) ? '&' : '?';
        var url = base + sep + $.param(data);
        location.href = url;
        <portlet:namespace/>loadJSMolFile( <portlet:namespace/>currentData );
		//($('#<portlet:namespace/>downloadAnchor').attr('href', url))[0].click();
    }
}

function <portlet:namespace/>setTitle( title ){
	$('#<portlet:namespace/>title').html('<h5>'+title+'</h5>');
}

</script>
 
