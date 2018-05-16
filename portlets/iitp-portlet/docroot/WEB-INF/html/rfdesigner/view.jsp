<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<!-- Plotly libs -->
<script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
<!--Numeric JS-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/numeric/1.2.6/numeric.min.js"></script>
<!--math JS-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/mathjs/4.2.2/math.min.js"></script>
<!--bootstrap validation JS-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>

<script src="${contextPath}/js/lib/jquery.mustache.js"></script>
<script src="${contextPath}/js/lib/mustache.min.js"></script>

<script src="${contextPath}/js/rfdesigner/designer.js"></script>
<script src="${contextPath}/js/rfdesigner/fomular.js"></script>


<style type="text/css">
	
	.rf-designer #_RFDesigner_WAR_iitpportlet_mustache-panel-box .form-group,.rf-designer #_RFDesigner_WAR_iitpportlet_mustache-panel-box .row{
 		margin-left: 0px;
 		margin-right: 0px;
 		margin-bottom: 5px;
 		padding-left: 0px;
		padding-right: 0px;
	}
	
	
	
	.rf-designer .panel-body .my-form-row{
 		margin-bottom: 10px;
	}
	
	.rf-designer .panel-body .my-form-row .form-control{
 		width:100%;
	}
	
	.rf-designer .panel-body .row{
 		margin-left: -15px;
 		margin-right: -15px;
	}
	
	.rf-designer .panel-body .my-group .form-control{
		width:100%;
	}
	
	.rf-designer .panel-body .my-title{
		white-space: nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
		line-height: normal;
		padding-bottom: 8px;
		font-weight: 600;
		margin-top: 0;
		margin-bottom: 0;
		font-size: 15px;
		color: inherit;
	}
	
	.rf-designer option:disabled{
		background-color: #555555;
	}
	
	.rf-designer .img-responsive{
		margin: 0 auto;
	}
	
	.rf-designer .border-grid{
/* 		border: 1px solid #337ab7; */
/* 		padding-top: 5px; */
	}
	
	.rf-designer .vertical-alignment-helper {
	    display:table;
	    height: 100%;
	    width: 100%;
	}
	.rf-designer .vertical-align-center {
	    /* To center vertically */
	    display: table-cell;
	    vertical-align: middle;
	    pointer-events:none;
	}
	.rf-designer .modal-content {
	    /* Bootstrap sets the size of the modal in the modal-dialog class, we need to inherit it */
	    width:inherit;
	    max-width:inherit; /* For Bootstrap 4 - to avoid the modal window stretching full width */
	    height:inherit;
	    /* To center horizontally */
	    margin: 0 auto;
	    pointer-events: all;
	}

/* The Modal (background) */
.rf-designer .image-modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 10; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.9); /* Black w/ opacity */
}

/* Modal Content (Image) */
.rf-designer .image-modal .modal-content {
    margin: auto;
    display: block;
    width: 80%;
    max-width: 700px;
    max-height: 60%;
}

/* Caption of Modal Image (Image Text) - Same Width as the Image */
.rf-designer .image-modal #caption {
    margin: auto;
    display: block;
    width: 80%;
    max-width: 700px;
    text-align: center;
    color: #ccc;
    padding: 10px 0;
    height: 150px;
}

/* The Close Button */
.rf-designer .image-modal .close {
    position: absolute;
    top: 60px;
    right: 35px;
    color: #f1f1f1;
    font-size: 40px;
    font-weight: bold;
    transition: 0.3s;
}

.rf-designer .image-modal .close:hover,
.rf-designer .image-modal .close:focus {
    color: #bbb;
    text-decoration: none;
    cursor: pointer;
}

/* 100% Image Width on Smaller Screens */
@media only screen and (max-width: 700px){
    .rf-designer .image-modal .modal-content {
        width: 100%;
    }
}
</style>

<div class="h20"></div>
<div class="row">
	<div class="col-md-6 border-grid">
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-default" style="min-height: 390px">
					<div class="panel-heading clearfix ">
						<h2 class="panel-title">Filter Options</h2>
					</div>
					<div class="panel-body form-horizontal">
						<div class="form-group">
							<label for="inputEmail3" class="col-md-5 control-label">Response Type</label>
							<div class="col-md-7">
								<div class="radio">
									<label>
										<input type="radio" name="optionsRadios1" id="optionsRadios1" value="CHEBYSHEV" class="mustache-radio">
										Chebyshev
									</label>
								</div>
								<div class="radio">
									<label>
										<input type="radio" name="optionsRadios1" id="optionsRadios1" value="MAXIMALLY" class="mustache-radio">
										Maximally Flat
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-md-5 control-label">Filter Type</label>
							<div class="col-md-7">
								<div class="radio">
									<label>
										<input type="radio" name="optionsRadios2" id='<portlet:namespace/>radioFilterType' value="LOWPASS" class="mustache-radio">
										Lowpass
									</label>
								</div>
								<div class="radio">
									<label>
										<input type="radio" name="optionsRadios2" id="<portlet:namespace/>radioFilterType" value="HIGHPASS" class="mustache-radio">
										Highpass
									</label>
								</div>
								<div class="radio">
									<label>
										<input type="radio" name="optionsRadios2" id="<portlet:namespace/>radioFilterType" value="BANDPASS" class="mustache-radio">
										Bandpass
									</label>
								</div>
								<div class="radio">
									<label>
										<input type="radio" name="optionsRadios2" id="<portlet:namespace/>radioFilterType" value="BANDSTOP" class="mustache-radio">
										Bandstop
									</label>
								</div>
							</div>
						</div>
						<div class="form-group col-md-12">
							<label for="inputEmail3">Characteristic Impedance</label>
							<div class="input-group">
								<input type="email" class="form-control" id="inputEmail3">
								<div class="input-group-addon">&#937;</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="panel panel-default" style="min-height: 390px">
					<div class="panel-heading clearfix ">
						<h2 class="panel-title">Specification</h2>
					</div>
					<div class="panel-body form-horizontal" id="<portlet:namespace/>mustache-panel-box">
						
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="input-group">
					<select class="form-control" id="<portlet:namespace/>filter-type">
						<option value="LUMPED-FILTER">Lumped-Element Filter</option>
						<option value="TRANSMIATION-FILTER">Transmission Line Filter</option>
					</select>
					<div class="input-group-btn">
						<button class="btn btn-primary disabled" id="design-filter">
							<span class="icon-bar-chart">
								Design Filter
							</span>
						</button>
					</div>
				</div>
			</div>
		</div>
		<div class="h10"></div>
	</div>
	<div class="col-md-6 border-grid">
		<div class="panel panel-default" style="min-height: 390px;">
			<div class="panel-heading clearfix ">
				<h2 class="panel-title">Line Calculator</h2>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-12">
						<label class="radio-inline">
							<input type="radio" name="filter-design-option" id="inlineRadio1" value="option1" onchange="<portlet:namespace/>filterDesignChange('type1');"> Single Microstrip Line
						</label>
						<label class="radio-inline">
							<input type="radio" name="filter-design-option" id="inlineRadio2" value="option2" onchange="<portlet:namespace/>filterDesignChange('type2');"> Coupled Microstrip Line
						</label>
					</div>
				</div>
				<div class="h10"></div>
				<div id='<portlet:namespace/>line-calculator-mustache'>
					
				</div>
				
				
				
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-6  border-grid">
		<div class="panel panel-default" style="min-height: 500px;">
			<div class="panel-heading clearfix ">
				<h2 class="panel-title">Graph</h2>
			</div>
			<div class="panel-body form-horizontal">
				<div class="row">
					<div class="col-md-12">
						<div id="graph-plot-content" style="height: 450px;">
						
						</div>
					</div>
				</div>
				<div class="form-horizontal">
					<div class="form-group">
						<label class="col-md-5 control-label">Optimum Order (N)</label>
						<div class="col-md-7">
							<p class="form-control-static" id="optimum-order">0</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-5 control-label">Selected Order (N)</label>
						<div class="col-md-3 input-group">
							<input type="text" class="form-control" id='<portlet:namespace/>selectedOrderText' value="0">
							<div class="input-group-btn">
								<button class="btn btn-primary disabled" id="design-update">Update</button>
							</div>
						</div>
						<div class="col-md-3">
						</div>
					</div>
					<div class="text-center">
						<span>
							*Optimum order is determined based on highest slope of the graph.
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-6  border-grid">
		<div class="panel panel-default" style="min-height: 636px;">
			<div class="panel-heading clearfix ">
				<h2 class="panel-title">Filter Design</h2>
			</div>
			<div class="panel-body" id='<portlet:namespace/>filter-design-mustache'>
				
			</div>
		</div>
	</div>
</div>


<div class="modal fade" id="<portlet:namespace/>filter-design-modal" tabindex="-1" role="dialog" aria-labelledby="<portlet:namespace/>filter-design-modal" style="display: none;">
	<div class="vertical-alignment-helper">
		<div class="modal-dialog vertical-align-center" role="document" style="width: 1250px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title">Analyze Prototype Design Procedure</h4>
				</div>
				<div class="modal-body" style="padding-left: 30px;padding-right: 30px;">
						<div class="row">
							<div class="col-md-6">
								<div class="panel panel-default" style="min-height: 390px">
									<div class="panel-heading clearfix ">
										<h2 class="panel-title">Detemine Filter Order</h2>
									</div>
									<div class="panel-body form-horizontal">
										<div id="popup-plot-content" style="height: 350px;width: 540px;">
						
										</div>
										<span class="text-center">
											Optimum Order (N) : <br/>
											Optimum Order-1 (N-1) : <br/>
											Optimum Order+1 (N+1) : <br/>
										</span>
										
									</div>
								</div>
								<div class="panel panel-default" style="min-height: 285px">
									<div class="panel-heading clearfix ">
										<h2 class="panel-title">Element Values Table of prototype</h2>
									</div>
									<div class="panel-body form-horizontal">
										<textarea rows="11" class="form-control" style="resize: none;"></textarea>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="panel panel-default" style="min-height: 390px">
									<div class="panel-heading clearfix ">
										<h2 class="panel-title">Prototype - <span id="popupTitle">LPF</span></h2>
									</div>
									<div class="panel-body form-horizontal">
										<div class="row">
											<div class="col-md-12">
												<button class="btn btn-default pull-right" onclick="<portlet:namespace/>viewImage();">Transformation Figure</button>
												<img src="${contextPath}/images/rfdesigner/popup/proto_LPF.png" id="protoImg" class="img-responsive">
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<h3 class="my-title"> <img src="/iitp-portlet/images/title.png" width="20" height="20"> Frequency Scaling </h3>
												<img src="${contextPath}/images/rfdesigner/popup/freq_LPF.png" id="freqImg" class="img-responsive" style="height: 200px;">
												<div class="h10"></div>
												<textarea rows="12" class="form-control" style="resize: none;"></textarea>
											</div>
											<div class="col-md-6">
												<h3 class="my-title"> <img src="/iitp-portlet/images/title.png" width="20" height="20"> Impedance Scaling </h3>
												<img src="${contextPath}/images/rfdesigner/popup/impe.png" class="img-responsive" style="height: 200px;">
												<div class="h10"></div>
												<textarea rows="12" class="form-control" style="resize: none;"></textarea>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- The Modal -->
<div id="imageModal" class="image-modal modal">

  <!-- The Close Button -->
  <span class="close" onclick="<portlet:namespace/>closeImageModal();">&times;</span>

  <!-- Modal Content (The Image) -->
  <img class="modal-content" id="img01" src="${contextPath}/images/rfdesigner/popup/freqScailngFigure.png">

  <!-- Modal Caption (Image Text) -->
  <div id="caption">Freq Scailng Figure</div>
</div>

<script type="text/javascript">
var graphLayout = {
	xaxis: {
		title :'log(w/wc)'
	},
	yaxis: {
		title :'Attenuation (db)'
	}
};

var popupLayout = {
		xaxis: {
			title :'(w/wc)'
		},
		yaxis: {
			title :'Attenuation (db)'
		}
	};



/***********************************************************************
 * Mustache Data
 ***********************************************************************/
var <portlet:namespace/>SPEC_PANEL_DATA = {
	"tpl-filter-lowpass": {
		"boxtitle":"LPF",
		"body": "specification-type-low-high",
		"option": "",
		"form": {}
	},
	"tpl-filter-highpass": {
		"boxtitle":"HPF",
		"body": "specification-type-low-high",
		"option": "",
		"form": {}
	},
	"tpl-filter-bandpass": {
		"boxtitle":"BPF",
		"body": "specification-filter-type-band",
		"option": "",
		"form": {}
	},
	"tpl-filter-bandstop": {
		"boxtitle":"BSF",
		"body": "specification-filter-type-band",
		"option": "",
		"form": {}
	}
};

var <portlet:namespace/>FILTER_PANEL_DATA = {
	"tpl-filter-lowpass": {
		"img":"cktLPF.png",
		"title":"LPF",
		"body": "filter-design-type-1",
		"option": "",
		"form": {}
	},
	"tpl-filter-highpass": {
		"img":"cktHPF.png",
		"title":"HPF",
		"body": "filter-design-type-1",
		"option": "",
		"form": {}
	},
	"tpl-filter-bandpass": {
		"img":"cktBPF.png",
		"title":"BPF",
		"body": "filter-design-type-1",
		"option": "",
		"form": {}
	},
	"tpl-filter-bandstop": {
		"img":"cktBSF.png",
		"title":"BSF",
		"body": "filter-design-type-1",
		"option": "",
		"form": {}
	},
	"tpl-transmission-lowpass": {
		"img":"stepped.png",
		"body": "filter-design-type-2",
		"option": "",
		"form": {}
	},
	"tpl-transmission-bandpass": {
		"img":"coupled.png",
		"body": "filter-design-type-3",
		"option": "",
		"form": {}
	}
};

var <portlet:namespace/>LINE_PANEL_DATA = {
	"tpl-single": {
		"body": "line-calculator-type-1",
		"form": {}
	},
	"tpl-coupled": {
		"body": "line-calculator-type-2",
		"form": {}
	}
};

/***********************************************************************
* Global Var
***********************************************************************/
var <portlet:namespace/>templateData;

$(document).ready(function(){
	
	Plotly.newPlot('graph-plot-content', null, graphLayout, {scrollZoom: true});
	
	$.Mustache.addFromDom();
	
	$("#p_p_id<portlet:namespace/>").on("change",".mustache-radio",function(e){
		e.preventDefault();
		var resposeType = nullToStr($("input[name='optionsRadios1']:checked").val());
		var filterType = nullToStr($("input[name='optionsRadios2']:checked").val());
		
		/*PANEL_DATA_SETTING*/
		if(resposeType!=""&&filterType!=""){
			var disabledOption = false;
			if(filterType==="LOWPASS"){
				<portlet:namespace/>templateData = <portlet:namespace/>SPEC_PANEL_DATA["tpl-filter-lowpass"];
			}else if(filterType==="HIGHPASS"){
				<portlet:namespace/>templateData = <portlet:namespace/>SPEC_PANEL_DATA["tpl-filter-highpass"];
				disabledOption = true;
			}else if(filterType==="BANDPASS"){
				<portlet:namespace/>templateData = <portlet:namespace/>SPEC_PANEL_DATA["tpl-filter-bandpass"];
			}else if(filterType==="BANDSTOP"){
				<portlet:namespace/>templateData = <portlet:namespace/>SPEC_PANEL_DATA["tpl-filter-bandstop"];
				disabledOption = true;
			}
			
			if(resposeType==="CHEBYSHEV"){
				<portlet:namespace/>templateData.option = false;
			}else{
				<portlet:namespace/>templateData.option = true;
			}
			
			/*SELECT BOX EVENT*/
			if(disabledOption){
				$("#<portlet:namespace/>filter-type option[value='LUMPED-FILTER']").prop("selected", true);;
				$("#<portlet:namespace/>filter-type").css("cursor", "not-allowed");
			}else{
				$("#<portlet:namespace/>filter-type").css("cursor", "pointer");
			}
			
			$("#<portlet:namespace/>filter-type option[value='TRANSMIATION-FILTER']").attr('disabled', disabledOption);
			
			$("#<portlet:namespace/>mustache-panel-box").empty().mustache(<portlet:namespace/>templateData["body"], <portlet:namespace/>templateData);
			
			$("#<portlet:namespace/>mustache-panel-box .data-binded").change(function (e) {
				var thisValue = $(this).val();
				var thisName = $(this).attr("name");
				<portlet:namespace/>templateData.form[thisName] = thisValue;
			});
			
			if($("button#design-filter").hasClass("disabled")){
				$("button#design-filter").removeClass("disabled");
				$("button#design-filter").attr("onclick","<portlet:namespace/>gridFilter();return false;");
				
				$("button#design-update").removeClass("disabled");
				$("button#design-update").attr("onclick","<portlet:namespace/>gridFilter();return false;");
			}
			
			
		}
	});
});

function <portlet:namespace/>isValidate() {
	$("#<portlet:namespace/>mustache-panel-box form").validator('validate');
	return $("#<portlet:namespace/>mustache-panel-box form").find(".has-error").length === 0;
}

function <portlet:namespace/>gridFilter(){
	var filterData = {};
	if (<portlet:namespace/>isValidate()) {
		$("#<portlet:namespace/>mustache-panel-box .data-binded").each(function(e){
			var name = $(this).attr("name");
			if(typeof <portlet:namespace/>templateData.form[name] != "undefined"){
				filterData[name] = <portlet:namespace/>templateData.form[name];
			}else{
				return false;
			}
		});
		<portlet:namespace/>gridFilterDesign();
		<portlet:namespace/>gridGraph(filterData);
	}
	
	console.log(filterData);
}

function <portlet:namespace/>gridGraph(filterData){
	var radioFilterType = $("#<portlet:namespace/>radioFilterType:checked").val();
	var selectedOrder = nullToStr($("#<portlet:namespace/>selectedOrderText").val(),0);
	var data = getGraphData(filterData,radioFilterType,selectedOrder);
	Plotly.newPlot('graph-plot-content', data, graphLayout, {scrollZoom: true});
}

function <portlet:namespace/>gridFilterDesign(){
	var selectFilterType = $("#<portlet:namespace/>filter-type option:selected").val();
	var $filterDiv = $("#<portlet:namespace/>filter-design-mustache");
	var <portlet:namespace/>filterTemplateData;
	
	var radioFilterType = $("#<portlet:namespace/>radioFilterType:checked").val();
	if(selectFilterType==="LUMPED-FILTER"){
		if(radioFilterType==="LOWPASS"){
			<portlet:namespace/>filterTemplateData = <portlet:namespace/>FILTER_PANEL_DATA["tpl-filter-lowpass"];
		}else if(radioFilterType==="HIGHPASS"){
			<portlet:namespace/>filterTemplateData = <portlet:namespace/>FILTER_PANEL_DATA["tpl-filter-highpass"];
		}else if(radioFilterType==="BANDPASS"){
			<portlet:namespace/>filterTemplateData = <portlet:namespace/>FILTER_PANEL_DATA["tpl-filter-bandpass"];
		}else if(radioFilterType==="BANDSTOP"){
			<portlet:namespace/>filterTemplateData = <portlet:namespace/>FILTER_PANEL_DATA["tpl-filter-bandstop"];
		}
	}else{
		if(radioFilterType==="LOWPASS"){
			<portlet:namespace/>filterTemplateData = <portlet:namespace/>FILTER_PANEL_DATA["tpl-transmission-lowpass"];
		}else if(radioFilterType==="BANDPASS"){
			<portlet:namespace/>filterTemplateData = <portlet:namespace/>FILTER_PANEL_DATA["tpl-transmission-bandpass"];
		}
	}
	
	$filterDiv.empty().mustache(<portlet:namespace/>filterTemplateData["body"], <portlet:namespace/>filterTemplateData);
}

function <portlet:namespace/>filterDesignPopup(title){
	var modal = $("#<portlet:namespace/>filter-design-modal");
	modal.modal({ "backdrop": "static", "keyboard": false });
	
	modal.find("span#popupTitle").html(title);
	modal.find("img#protoImg").attr("src","${contextPath}/images/rfdesigner/popup/proto_"+title+".png");
	modal.find("img#freqImg").attr("src","${contextPath}/images/rfdesigner/popup/freq_"+title+".png");
	
	Plotly.newPlot('popup-plot-content', null, popupLayout, {scrollZoom: true});
}

function <portlet:namespace/>filterDesignChange(type){
	var <portlet:namespace/>lintTemplateData;
	if(type==="type1"){
		<portlet:namespace/>lintTemplateData = <portlet:namespace/>LINE_PANEL_DATA["tpl-single"];
	}else{
		<portlet:namespace/>lintTemplateData = <portlet:namespace/>LINE_PANEL_DATA["tpl-coupled"];
	}
	
	$("#<portlet:namespace/>line-calculator-mustache").empty().mustache(<portlet:namespace/>lintTemplateData["body"], <portlet:namespace/>lintTemplateData);
}

function <portlet:namespace/>viewImage(){
	// Get the modal
	$("#imageModal").css("display","block");
	
	var modal = $("#<portlet:namespace/>filter-design-modal");
	modal.modal('toggle');
}

function <portlet:namespace/>closeImageModal(){
	$("#imageModal").css("display","none");
	
	var modal = $("#<portlet:namespace/>filter-design-modal");
	modal.modal({ "backdrop": "static", "keyboard": false });
}
</script>


<script id="specification-type-low-high" type="text/html">
<h3 class="panel-title my-title">
    <img src="/iitp-portlet/images/title.png" width="20" height="20"/> 
    {{boxtitle}}
</h3>
<form onsubmit="return false;">
    <div class="form-group">
        <label>Center Frequency</label>
        <div class="form-inline row">
            <div class="form-group col-sm-6">
                <input type="text" name="center-frequency" class="form-control data-binded" value="{{form.center-frequency}}" required autofocus>
            </div>
            <div class="form-group col-sm-6">
                <select class="form-control" name="center-frequency-addon">
                    <option value="Hz">Hz</option>
                    <option value="kHz">kHz</option>
                    <option value="MHz">MHz</option>
                    <option value="GHz">GHz</option>
                </select>
            </div>
        </div>
    </div>
    <div class="form-group">
            <label>Stop Frequency</label>
        <div class="form-inline row">
            <div class="form-group col-sm-6">
                    <input type="text" name="stop-frequency" class="form-control data-binded" value="{{form.stop-frequency}}" required>
            </div>
            <div class="form-group col-sm-6">
                <select class="form-control" name="stop-frequency-addon">
                    <option value="Hz">Hz</option>
                    <option value="kHz">kHz</option>
                    <option value="MHz">MHz</option>
                    <option value="GHz">GHz</option>
                </select>
            </div>
        </div>
    </div>
    <div class="form-group">
        <label>Passband Ripple (Rp)</label>
        <div class="input-group">
            {{#option}}    
                <input type="text" class="form-control" disabled> 
            {{/option}}
            {{^option}}
                <input type="text" name="passband-ripple" class="form-control data-binded" value="{{form.passband-ripple}}" required>
            {{/option}}
            <span class="input-group-addon">dB</span>
        </div>
    </div>
    <div class="form-group">
        <label>Stopband Attenuation</label>
        <div class="input-group">
            <input type="text" name="stopband-attenuation" class="form-control data-binded" value="{{form.stopband-attenuation}}" required>
            <span class="input-group-addon">dB</span>
        </div>
    </div>
</form>
</script>
<script id="specification-filter-type-band" type="text/html">
<h3 class="panel-title my-title">
    <img src="/iitp-portlet/images/title.png" width="20" height="20"/> 
    {{boxtitle}}
</h3>
<form class="form-horizontal" onsubmit="return false;">
<div class="form-group">
    <div class="form-inline row">
        <div class="col-md-6">
            <label class="form-control-static">Passband Freq (L)</label>
        </div>
        <div class="form-group col-md-3 my-group">
            <input type="text" name="passband-freq-L" class="form-control data-binded" value="{{form.passband-freq-L}}" autofocus required>
        </div>
        <div class="form-group col-md-3">
            <select class="form-control" name="passband-freq-L-addon">
                <option value="Hz">Hz</option>
                <option value="kHz">kHz</option>
                <option value="MHz">MHz</option>
                <option value="GHz">GHz</option>
            </select>
        </div>
    </div>
    <div class="form-inline row">
        <div class="col-md-6">
            <label class="form-control-static">Stopband Freq (L)</label>
        </div>
        <div class="form-group col-md-3 my-group">
            <input type="text" name="stopband-freq-L" class="form-control data-binded" value="{{form.stopband-freq-L}}" required>
        </div>
        <div class="form-group col-md-3">
            <select class="form-control" name="stopband-freq-L-addon">
                <option value="Hz">Hz</option>
                <option value="kHz">kHz</option>
                <option value="MHz">MHz</option>
                <option value="GHz">GHz</option>
            </select>
        </div>
    </div>
    <div class="form-inline row">
        <div class="col-md-6">
            <label class="form-control-static">Passband Freq (H)</label>
        </div>
        <div class="form-group col-md-3 my-group">
            <input type="text" name="passband-freq-H" class="form-control data-binded" value="{{form.passband-freq-H}}" required>
        </div>
        <div class="form-group col-md-3">
            <select class="form-control" name="passband-freq-H-addon">
                <option value="Hz">Hz</option>
                <option value="kHz">kHz</option>
                <option value="MHz">MHz</option>
                <option value="GHz">GHz</option>
            </select>
        </div>
    </div>
    <div class="form-inline row">
        <div class="col-md-6">
            <label class="form-control-static">Stopband Freq (H)</label>
        </div>
        <div class="form-group col-md-3 my-group">
            <input type="text" name="stopband-freq-H" class="form-control data-binded" value="{{form.stopband-freq-H}}" required>
        </div>
        <div class="form-group col-md-3">
            <select class="form-control" name="stopband-freq-H-addon">
                <option value="Hz">Hz</option>
                <option value="kHz">kHz</option>
                <option value="MHz">MHz</option>
                <option value="GHz">GHz</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        {{#option}}
        <label>Passband Attenuation</label>
        <div class="input-group">
            <input type="text" name="passband-attenuation" class="form-control data-binded" value="{{form.passband-attenuation}}" required>
            <span class="input-group-addon">dB</span>
        </div>
        {{/option}} {{^option}}
        <label>Passband Ripple (Rp)</label>
        <div class="input-group">
            <input type="text" name="passband-ripple" class="form-control data-binded" value="{{form.passband-ripple}}" required>
            <span class="input-group-addon">dB</span>
        </div>
        {{/option}}
    </div>
    <div class="form-group">
        <label>Stopband Attenuation</label>
        <div class="input-group">
            <input type="text" name="stopband-attenuation" class="form-control data-binded" value="{{form.stopband-attenuation}}">
            <div class="input-group-addon">dB</div>
        </div>
    </div>
</div>
</form>
</script>
<script id="filter-design-type-1" type="text/html">
<div class="row"><div class="col-md-12"><button class="btn btn-default pull-right" onClick="<portlet:namespace/>filterDesignPopup('{{title}}');"><span class="icon-file">  Analyze Prototype Design Procedure</span<</button></div></div>
<div class="row"><div class="col-md-12"><img src="${contextPath}/images/rfdesigner/filter-design/{{img}}" class="img-responsive"></div></div>
<div class="row"><div class="col-md-12 form-group"><textarea rows="18" class="form-control" style="resize: none;"></textarea></div></div>
</script>
<script id="filter-design-type-2" type="text/html">
<div class="row">
    <div class="col-md-12">
        <h3 class="my-title"> <img src="/iitp-portlet/images/title.png" width="20" height="20"> Stepped-impedance implementation </h3>
        <img src="${contextPath}/images/rfdesigner/filter-design/{{img}}" class="img-responsive">
    </div>
</div>
<div class="row">
    <div class="col-md-12">
        <h3 class="my-title"> <img src="/iitp-portlet/images/title.png" width="20" height="20"> Substrate </h3>
    </div>
</div>
<div class="form-inline row my-form-row">
    <div class="col-md-3"> <label class="form-control-static">Dielectric Constant (er) : </label> </div>
    <div class="col-md-3">
        <input type="text" name="dielectric-constant" class="form-control" style="width: 100%">
    </div>
    <div class="col-md-3"> <label class="form-control-static">Height (mm) : </label> </div>
    <div class="col-md-3">
        <input type="text" name="height" class="form-control" style="width: 100%">
    </div>
</div>
<div class="form-inline row my-form-row">
    <div class="col-md-3"> <label class="form-control-static">Lowest Impedance (Zl) : </label> </div>
    <div class="col-md-3">
        <input type="text" name="lowest-impedance" class="form-control" style="width: 100%">
    </div>
    <div class="col-md-3"> <label class="form-control-static">Height Impedance(Zl) : </label> </div>
    <div class="col-md-3">
        <input type="text" name="height" class="form-control" style="width: 100%">
    </div>
</div>
<div class="row my-form-row">
    <div class="col-md-12 text-center">
        <button class="btn-primary btn">Apply</button>
    </div>
</div>
<div class="row">
    <div class="col-md-3 text-center">
        <label>Z(impedance)</label>
    </div>
    <div class="col-md-3 text-center">
        <label>Phase(Degree)</label>
    </div>
    <div class="col-md-3 text-center">
        <label>Width(mm)</label>
    </div>
    <div class="col-md-3 text-center">
        <label>Length(mm)</label>
    </div>
</div>
<div class="row">
    <div class="col-md-12 form-group">
        <textarea rows="4" class="form-control" style="resize: none;"></textarea>
    </div>
</div>
</script>
<script id="filter-design-type-3" type="text/html">
<div class="row">
    <div class="col-md-12">
        <h3 class="my-title"> <img src="/iitp-portlet/images/title.png" width="20" height="20"> Coupled Microstrip Line </h3>
        <img src="${contextPath}/images/rfdesigner/filter-design/{{img}}" class="img-responsive">
    </div>
</div>
<div class="row">
    <div class="col-md-12">
        <h3 class="my-title"> <img src="/iitp-portlet/images/title.png" width="20" height="20"> Substrate </h3>
    </div>
</div>
<div class="form-inline row my-form-row">
    <div class="col-md-3"> <label class="form-control-static">Dielectric Constant (er) : </label> </div>
    <div class="col-md-3">
        <input type="text" name="dielectric-constant" class="form-control" style="width: 100%">
    </div>
    <div class="col-md-3"> <label class="form-control-static">Height (mm) : </label> </div>
    <div class="col-md-3">
        <input type="text" name="height" class="form-control" style="width: 100%">
    </div>
</div>
<div class="row my-form-row">
    <div class="col-md-12 text-center">
        <button class="btn-primary btn">Apply</button>
    </div>
</div>
<div class="row">
    <div class="col-md-12">
        <h3 class="my-title"> <img src="/iitp-portlet/images/title.png" width="20" height="20"> Synthesis of Coupled Microstrip Line </h3>
    </div>
</div>
<div class="row">
    <div class="col-md-3 text-center">
        <label>Section</label>
    </div>
    <div class="col-md-3 text-center">
        <label>Phase(Degree)</label>
    </div>
    <div class="col-md-3 text-center">
        <label>Width(mm)</label>
    </div>
    <div class="col-md-3 text-center">
        <label>Length(mm)</label>
    </div>
</div>
<div class="row">
    <div class="col-md-12 form-group">
        <textarea rows="4" class="form-control" style="resize: none;"></textarea>
    </div>
</div>
<div class="row">
    <div class="col-md-12">
        <h3 class="my-title"> <img src="/iitp-portlet/images/title.png" width="20" height="20"> Even/Odd impedance Calculation Process </h3>
    </div>
</div>
<div class="row">
    <div class="col-md-4 text-center">
        <label>Section</label>
    </div>
    <div class="col-md-2 text-center">
        <label>g(n)</label>
    </div>
    <div class="col-md-2 text-center">
        <label>Zojn</label>
    </div>
    <div class="col-md-2 text-center">
        <label>Zoeven</label>
    </div>
    <div class="col-md-2 text-center">
        <label>Zodd</label>
    </div>
</div>
<div class="row">
    <div class="col-md-12 form-group">
        <textarea rows="4" class="form-control" style="resize: none;"></textarea>
    </div>
</div>
</script>
<script id="line-calculator-type-1" type="text/html">
<div class="row">
    <div class="col-md-12">
        <h3 class="my-title"> <img src="/iitp-portlet/images/title.png" width="20" height="20"> Substrate </h3>
    </div>
</div>
<div class="form-inline row my-form-row">
    <div class="col-md-3"> <label class="form-control-static">Dielectric Constant (Er) : </label> </div>
    <div class="col-md-3">
        <input type="text" name="dielectric-constant" class="form-control" style="width: 100%">
    </div>
    <div class="col-md-3"> <label class="form-control-static">Height (mm) : </label> </div>
    <div class="col-md-3">
        <input type="text" name="height" class="form-control" style="width: 100%">
    </div>
</div>
<div class="row">
    <div class="col-md-6">
        <div class="h30"></div>
        <div class="row form-inline my-form-row">
            <label class="col-md-6">Characteristic Impedance (Za) : </label>
            <div class=" col-md-6">
                <input type="text" name="height" class="form-control" style="width: 100%">
            </div>
        </div>
        <div class="row my-form-row">
            <button class="btn btn-default col-md-6">Synthesize<br/><i class="icon-sort-down"></i></button>
            <button class="btn btn-default col-md-6"><i class="icon-sort-up"></i><br/>Analyze</button>
        </div>
        <div class="row form-inline my-form-row">
            <label class="col-md-6">Width (mm) : </label>
            <div class=" col-md-6">
                <input type="text" name="height" class="form-control" style="width: 100%">
            </div>
        </div>
    </div>
    <div class="col-md-6">
        <img src="/iitp-portlet/images/rfdesigner/line-calculator/single.png" class="img-responsive">
    </div>
</div>
</script>
<script id="line-calculator-type-2" type="text/html">
<div class="row">
    <div class="col-md-12">
        <h3 class="my-title"> <img src="/iitp-portlet/images/title.png" width="20" height="20"> Input Parameters </h3>
    </div>
</div>
<div class="form-inline row my-form-row">
    <div class="col-md-3"> <label class="form-control-static">Z0 : </label> </div>
    <div class="col-md-3">
        <input type="text" name="dielectric-constant" class="form-control" style="width: 100%">
    </div>
    <div class="col-md-3"> <label class="form-control-static">Freqency (GHz) : </label> </div>
    <div class="col-md-3">
        <input type="text" name="height" class="form-control" style="width: 100%">
    </div>
</div>
<div class="form-inline row my-form-row">
    <div class="col-md-3"> <label class="form-control-static">Zoeven : </label> </div>
    <div class="col-md-3">
        <input type="text" name="dielectric-constant" class="form-control" style="width: 100%">
    </div>
    <div class="col-md-3"> <label class="form-control-static">Zoodd : </label> </div>
    <div class="col-md-3">
        <input type="text" name="height" class="form-control" style="width: 100%">
    </div>
</div>
<div class="form-inline row my-form-row">
    <div class="col-md-3"> <label class="form-control-static">Substrate Er : </label> </div>
    <div class="col-md-3">
        <input type="text" name="dielectric-constant" class="form-control" style="width: 100%">
    </div>
    <div class="col-md-3"> <label class="form-control-static">Substrate Height (mm) : </label> </div>
    <div class="col-md-3">
        <input type="text" name="height" class="form-control" style="width: 100%">
    </div>
</div>
<div class="row my-form-row">
    <div class="col-md-12 text-center">
        <button class="btn-primary btn">Calulator</button>
    </div>
</div>
<div class="row">
    <div class="col-md-5">
        Width (mm) : <br/>
        Length (mm) : <br/>
        Spacing (mm) : <br/>
    </div>
    <div class="col-md-7">
        <img src="/iitp-portlet/images/rfdesigner/line-calculator/coupled2.png" class="img-responsive">
    </div>
</div>
</script>
