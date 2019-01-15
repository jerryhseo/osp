var UIPanelExecutor = (function (namespace, $, designer, executor, toastr) {
    /*jshint -W069 */
    'use strict';
    var simulationUuid = "0028ec20-8d46-4bde-890b-7e2ac0520a32";
    var jobUuid = "fa796ee7-4b2e-424e-b665-5df2d26edfc9";
    var currNodes = eStruct("id")
    var currSimulations = eStruct("simulationId")
    var currJobs = eStruct("id", "data")
    var currInputPorts = eStruct("id")
    var currOutputPorts = eStruct("id")
    var JQ_PORTLET_BOUNDARY_ID = "#p_p_id" + namespace;
    var PANEL_DATA = {
        "new": {
            "col": 6,
            "panel-type": "new",
            "body": "tpl-menu-panel-new",
            "form": {},
            "btn": {
                "create": newSimulation
            }
        }, "new-job": {
            "col": 6,
            "panel-type": "new-job",
            "body": "tpl-menu-panel-new",
            "form": {},
            "btn": {
                "create": newSimulationJob
            }
        },"open": {
            "col": 10,
            "panel-type": "open",
            "body": "tpl-menu-panel-load",
            "header": {
                "id": "tpl-menu-panel-search-header",
                "search-input-name": "search",
                "theads": ["Title", "User", "Created"]
            },
            "form": {},
            "footer": {
                "id": "tpl-menu-panel-pagination",
                "btns": [
                    { "name": "New", "func": openNewSimulationPanel },
                    { "name": "Open", "func": openSimulation },
                    { "name": "Rename", "func": renameSimulation },
                    { "name": "Delete", "func": deleteSimulation }
                ]
            }
        }, "jobs": {
            "col": 4,
            "panel-type": "jobs",
            "header":{
                "id": "tpl-menu-panel-search-header",
                "search-input-name": "search"
            },
            "form": {}
        }, "status": {
            "col": 10,
            "panel-type": "status",
            "body": "tpl-menu-panel-load",
            "header": {
                "id": "tpl-menu-panel-search-header",
                "search-input-name": "search",
                "theads": ["Title", "Status", "Submitted Time", "End Time"]
            },
            "form": {}/* ,
            "footer":{
                "id": "tpl-menu-panel-pagination",
                "btns" : [
                    { "name": "Open", "func": openWorkflow },
                    { "name": "Rename", "func": renameWorkflow },
                    { "name": "Duplicate", "func": duplicateWorkflow },
                    { "name": "Delete", "func": deleteWorkflow }
                ]
            } */
        }, "setting": {
            "col": 6,
            "panel-type": "setting",
            "body": "tpl-menu-panel-setting",
            "form": {},
            "btn": {
                "update": renameSimulation,
                "delete": deleteSimulation
            }
        }, "job-setting": {
            "col": 6,
            "panel-type": "setting",
            "body": "tpl-job-panel-setting",
            "form": {},
            "btn": {
                "update": renameSimulationJobInPanel,
                "copy": copySimulationJobInPanel,
                "delete": deleteSimulationJobInPanel
            }
        }
    };

    $(JQ_PORTLET_BOUNDARY_ID + " .sidbar-run-btn").click(function (e) {
        e.preventDefault();
        var btnType = $(this).attr("data-btn-type");
        if(!PANEL_DATA.setting.form.simulationId){
            toastr["info"]("", "Create Simulation First.");
            $(JQ_PORTLET_BOUNDARY_ID + " .sidebar-btn[data-btn-type='new']").click();
            return false;
        }
        if (btnType === "run") { run(); }
        if (btnType === "rerun") { rerun(); }
        if (btnType === "pause") { pause(); }
        if (btnType === "restart") { restart(); }
        if (btnType === "status") { status(this, "status"); }
    });

    /////////////////////////////////////////// renew start

    function createPanel(boxTitle, templateData, btnType) {
        templateData.boxtitle = boxTitle;
        $("#" + namespace + "menu-panel-box").show();
        $("#" + namespace + "menu-panel-box").empty().mustache('tpl-menu-panel-box', templateData);
        $("#" + namespace + "menu-panel-box .box-body").mustache(templateData.body, templateData);
        if (templateData.header) {
            var boxTitleSelecotr = "#" + namespace + "menu-panel-box .box-header.with-border.header-inner > .box-title";
            $(boxTitleSelecotr).replaceWith($.Mustache.render(templateData.header.id, templateData));
            var _delay600 = _instantDelay(600);
            $(boxTitleSelecotr + " > .search-input").keyup(function (e) {
                _delay600(loadPaginatedSimulations, btnType);
            });
        }

        if (templateData.footer) {
            $("#" + namespace + "menu-panel-box .box")
                .append($.Mustache.render(templateData.footer.id, templateData));
        }

        $(".menu-panel .menu-panel-close").click(function (e) {
            e.preventDefault();
            closePanel();
        });

        $("#" + namespace + "menu-panel-box .data-binded").change(function (e) {
            var thisValue = $(this).val();
            var thisName = $(this).attr("name");
            templateData.form[thisName] = thisValue;
        });

        $("#" + namespace + "menu-panel-box .func").each(function (_) {
            var thisName = $(this).attr("name");
            if (templateData.btn && templateData.btn[thisName]) {
                $(this).click(function (e) {
                    templateData.btn[thisName](btnType, this, e);
                });
            }
        });
    }

    $(JQ_PORTLET_BOUNDARY_ID + " .top-btn").click(function (e) {
        e.preventDefault();
        var btnType = $(this).attr("data-btn-type");
        var templateData = PANEL_DATA[btnType];

        if(btnType === "designer"){
            var fn = window[namespace + "moveToDesigner"];
            fn.apply();
        }

        if(btnType === "save" ){
            if(PANEL_DATA.setting.form.simulationTitle){
                saveOrUpdateWorkflowInstance("setting");
            }else{
                toastr["error"]("", var_create_first_message);
            }
        }

        if (btnType === 'new-job') {
            if (_isEmpty(currSimulations.selected(),
                CONSTS.MESSAGE.edison_wfsimulation_select_first_message)) {
                return false
            } else {
                executor.fetchSimulationJobSeq(
                    currSimulations.selected().simulationId,
                    function (seqMap) {
                        setTimeout(function () {
                            $('.new-job #title').val(seqMap.seq)
                            $('.new-job #title').focus()
                            templateData.form.title = seqMap.seq
                        }, 100)
                    })
            }
        }

        if (templateData) {
            var boxTitle = btnType === 'new-job' ? 'New Simulation Job' : $(this).text();
            activateLi(this);
            createPanel(boxTitle, templateData, btnType);
            if (btnType === 'open') {
                loadPaginatedSimulations(btnType);
            }

            if($(this).hasClass("menu-open")){
                $(".menu-panel").toggle('slide', { direction: 'left' }, 500);
            }else{
                $(".menu-panel").show('slide', { direction: 'left' }, 500);
            }
            $(JQ_PORTLET_BOUNDARY_ID + " li.top-btn").removeClass("menu-open");
            $(this).addClass("menu-open")
        }
    });

    function getParams(workflowId, searchKeyword, currentPage, linePerPage) {
        var params = {};
        if (workflowId) {
            params.workflowId =workflowId;
        }
        if (searchKeyword || searchKeyword === 0) {
            params.title = searchKeyword;
        }
        if (currentPage) {
            params.p_curPage = currentPage;
        }
        if (linePerPage) {
            params.linePerPage = linePerPage;
        }
        return params;
    }

    function loadPaginatedSimulations(panelType, currentPage, callback){
        var workflowId = getMetaData().workflowId;
        currentPage = currentPage || 1;
        var templateData = PANEL_DATA[panelType];
        var params = getParams(
            workflowId,
            getValueByInputName(
                templateData.header["search-input-name"]),
            currentPage);
        templateData.form.params = params;

        fetchPaginatedSimulations(params, callback);
    }

    function fetchPaginatedSimulations(params, callback) {
        aSyncAjaxHelper.post("/delegate/services/simulation/list",
            params,
            function (paginatedSimulations) {
        		if(paginatedSimulations.simulations && paginatedSimulations.simulations.length > 0) {
        			currSimulations.set(paginatedSimulations.simulations, function(id) {});
        		} else {
                    currSimulations.set([])
                }
                renderSimulationTable(paginatedSimulations)
                if(callback) {
                   callback()
                }
            },
            function (msg) {
                toastr["error"]("", msg);
            });
    }

    function renderSimulationTable(simulationsMap) {
        var tbodyTemplate =
            '{{#rows}}'+
            '    <tr simulation-id="{{simulationId}}">'+
            '        <td>{{title}}</td>'+
            '        <td>{{userName}}</td>'+
            '        <td>{{createDate}}</td>'+
            '    </tr>'+
            '{{/rows}}';
        tbodyTemplate +=
            '{{^rows}}'+
            '    <tr>'+
            '        <td colspan="4">No Data</td>'+
            '    </tr>'+
            '{{/rows}}';

        var paginationTemplate =
            '<li class="prev"><a href="#">«</a></li>' +
            '{{#pages}}' +
            '<li class="page-num {{active}}"><a href="#" page-num="{{num}}">{{num}}</a></li>' +
            '{{/pages}}' +
            '<li class="next"><a href="#">»</a></li>';
        var buttonTemplate =
            '{{#buttons}}' +
            '<button type="button" class="btn btn-flat func" name="{{name}}">{{name}}</button>' +
            '{{/buttons}}';

        tbody(simulationsMap, tbodyTemplate, 'open');
        pagination(simulationsMap.pagination, paginationTemplate, 'open');
        buttons(buttonTemplate, 'open');
    }

    function tbody(simulationMap, tbodyTemplate, panelType) {
        var simulations = simulationMap.simulations
        if (simulations && simulations.length > 0) {
            $.each(simulations, function (i) {
                simulations[i].userName = simulationMap.userName
                simulations[i].createDate = $.format.date(
                    new Date(simulations[i].createDate), "yyyy.MM.dd HH:mm");
            });

            $(JQ_PORTLET_BOUNDARY_ID + " .menu-panel tbody.panel-tbody").empty().append(
                Mustache.render(tbodyTemplate, { "rows": simulations }))
                .children("tr").each(function(i){
                var simluationId = $(this).attr("simulation-id");
                if(simluationId === PANEL_DATA[panelType].form.selected){
                    activate(this);
                }
                $(this).click(function(e){
                    PANEL_DATA[panelType].form.selected = simluationId;
                    activate(this);
                });
            });
        }else{
            $(JQ_PORTLET_BOUNDARY_ID + " .menu-panel tbody.panel-tbody").empty().append(
                Mustache.render(tbodyTemplate, { "rows": simulations }));
        }
    }

    function activate(that){
        $(that).siblings().removeClass("active");
        $(that).addClass("active");
    }

    function pagination(paginationData, paginationTemplate, panelType){
        var pages = [];
        for(var i = paginationData.startPage; i <= paginationData.endPage; i++){
            pages.push({
                "active": paginationData.currentPage === i ? "active" : "",
                "num": i
            });
        }
        $(JQ_PORTLET_BOUNDARY_ID + " .menu-panel .pagination").empty().append(
            Mustache.render(paginationTemplate, { "pages": pages })).find("li.page-num > a").click(function (e) {
            e.preventDefault();
            loadPaginatedSimulations(panelType, $(this).attr("page-num"));
        });

        if (paginationData.curBlock > 1 && paginationData.curBlock <= paginationData.totalBlock) {
            $(JQ_PORTLET_BOUNDARY_ID + " .menu-panel .pagination .prev > a").click(function (e) {
                e.preventDefault();
                loadPaginatedSimulations(panelType, paginationData.startPage - 1);
            });
        }else{
            $(JQ_PORTLET_BOUNDARY_ID + " .menu-panel .pagination .prev").addClass("disabled");
        }
        if (paginationData.curBlock < paginationData.totalBlock) {
            $(JQ_PORTLET_BOUNDARY_ID + " .menu-panel .pagination .next > a").click(function (e) {
                e.preventDefault();
                loadPaginatedSimulations(panelType, paginationData.endPage + 1);
            });
        }else{
            $(JQ_PORTLET_BOUNDARY_ID + " .menu-panel .pagination .next").addClass("disabled");
        }
    }

    function buttons(buttonTemplate, panelType) {
        $(JQ_PORTLET_BOUNDARY_ID + " .menu-panel .btn-group").empty().append(
            Mustache.render(buttonTemplate, { "buttons": PANEL_DATA[panelType].footer.btns }))
            .children("button").each(function (i) {
            var fn = PANEL_DATA[panelType].footer.btns[i].func;
            $(this).click(function (e) {
                e.preventDefault();
                fn(panelType, this, e);
            });
        });
    }

    function initJobs() {
        currJobs.set([])
        renderJobs()
    }

    function fetchJobs(simulationId, searchKeyword, currentPage, linePerPage, selectedJobId) {
        if (currSimulations.contains(simulationId)) {
            var params = {}
            if (currentPage) {
                params.p_curPage = currentPage;
            }
            if (linePerPage) {
                params.linePerPage = linePerPage;
            }
            if (searchKeyword || searchKeyword === 0) {
                params.title = searchKeyword;
            }
            executor.fetchSimulationJobs(
                simulationId,
                {},
                function (jobsMap) {
                    currSimulations.select(simulationId)
                    currJobs.set(jobsMap.jobs)
                    currJobs.select(selectedJobId)
                    renderJobs(currentPage === 1)
                },
                function () {
                    currSimulations.select()
                }
            )
            closePanel()
        }
    }

    function renderJobs(isFirstPage) {

        var ulSelector = "#" + namespace + "column-1 > ul";
        var li =
            '<li class="header">\n' +
            '  <div class="header-inner">\n' +
            '    <i class="fa fa-folder"></i> {{simulationTitle}}\n' +
            '  </div>\n' +
            '</li>' +
            '{{#jobs}}' +
            '<li class="treeview" job-id="{{simulationJobId}}">\n' +
            '  <a href="#" class="sidebar-btn job-li" job-id=\"{{simulationJobId}}\" job-status=\"{{status}}\">\n' +
            '    <i class="fa fa-file"></i>\n' +
            '    <span>{{title}}</span>\n' +
            '  <span class="label label-primary pull-right sidebar-btn">\n' +
            '    <i class="icon-arrow-right"></i>\n' +
            '  </span>' +
            '  </a>\n' +
            '  <ul id="nodes-{{simulationJobId}}" class="treeview-menu">\n' +
            // '    <li class="treeview">' +
            // '       <a href="#"><i class="fa fa-laptop"></i><span>input</span></a>' +
            // '       <ul id="input-ports-{{simulationJobId}}" class="treeview-menu"></ul>' +
            // '    </li>\n' +
            // '    <li class="treeview">' +
            // '       <a href="#"><i class="fa fa-laptop"></i><span>output</span></a>' +
            // '       <ul id="output-ports-{{simulationJobId}}" class="treeview-menu"></ul>' +
            // '    </li>\n' +
            '  </ul>' +
            '</li>' +
            '{{/jobs}}';
        var selectedJobId = currJobs.selected() ? currJobs.selected()["simulationJobId"] : undefined
        var selectedSimulationTitle = currSimulations.selected() ? currSimulations.selected()['title'] : 'No available Simulation Job'
        $(ulSelector)
            .empty()
            .append(
                Mustache.render(li, {
                    "simulationTitle": selectedSimulationTitle,
                    "jobs": currJobs.getArray()
                })
            )
            .children("li")
            .each(function(i) {
                if (i === 0) return
                var that = this
                var simulationJobId = $(that).attr("job-id")
                $(that).children("a").click(function(e) {
                    $(this).parent("li").siblings("li").removeClass("action")
                    $(this).parent("li").addClass("action")
                    selectSimulationJob(simulationJobId)
                })
                $(that).children("a").children("span.sidebar-btn").click(function(e) {
                	e.stopPropagation()
                	
                	/* 2019.01.15 _ Open Job Update Panel */
                	var boxTitle = 'Job Information';
                	var templateData = PANEL_DATA["job-setting"];
                	var job = currJobs.get(simulationJobId);
                	var jobTitle = job.title;
                	var getStatusInfo = getStatusAndStatusImg(job);
                	var jobStatus = getStatusInfo.jobStatus;
                	var jobStatusImg = getStatusInfo.jobStatusImg;
                	
                	templateData.form.jobId = simulationJobId;
                	templateData.form.jobTitle = jobTitle;
                	templateData.form.jobStatus = jobStatus;
                	templateData.form.jobStatusImg = jobStatusImg;
                    createPanel(boxTitle, templateData, "job-setting");
                    $(".menu-panel").toggle('slide', { direction: 'left' }, 500);
                })
                if (i === 1 && isFirstPage && !selectedJobId) {
                    _delay(function() {
                        $(that).children("a").click()
                    }, 100)
                    return
                }
                if(simulationJobId == selectedJobId) {
                    _delay(function() {
                        $(that).children("a").click()
                    }, 100)
                }
            })
    }
    
    /* 2019.01.15 _ Get JobStatus */
    function getStatusAndStatusImg(job){
    	var status = job.status;
    	
    	var returnObj = new Object;
    	var jobStatus = "";
    	var jobStatusImg = null;
    	switch(status){
	        case 1701002:
	        case 1701004:
	        case 1701012:
	        	jobStatus = "FAILED";
	        	jobStatusImg = "FAILED";
	        case 1701005:
	        	jobStatus = "QUEUED";
	        	jobStatusImg = "QUEUED";
	        case 1701006:
	        	jobStatus = "RUNNING";
	        	jobStatusImg = "RUNNING";
	        case 1701010:
	        	jobStatus = "CANCELED";
	        	jobStatusImg = "CANCELED";
	        case 1701011:
	        	jobStatus = "SUCCESS";
	        	jobStatusImg = "SUCCESS";
	        default:
	        	jobStatus = "INITIALIZED";
	        	jobStatusImg = "QUEUED";
    	}
    	
    	returnObj.jobStatus = jobStatus;
    	returnObj.jobStatusImg = jobStatusImg;
    	return returnObj;
    }

    function pushPorts(nodeId, ports, classPortArray, nodePortArray) {
        if (ports) {
            $.each(ports, function (key, value) {
                value.id = nodeId + "." + key
                classPortArray.push(value)
                nodePortArray.push(value)
            })
        }
    }

    function setPortsId(nodeId, ports, type) {
        if (ports) {
            var jtkType = type === CONSTS.WF_JSPLUMB_TYPES.INPUT ? 'target' : 'source'
            $.each(ports, function (key, value) {
                var portId = nodeId + "." + key
                $("#" + nodeId)
                    .find("jtk-" + jtkType + "[port-id='" + value.name_ + "']")
                    .parent("div")
                    .addClass(CONSTS.WF_JSPLUMB_TYPES.PORT_ELEMENT)
                    .addClass(type)
                    .attr("port-id", portId)
            })
        }
    }

    function addPortHandler(that, nodeId, isInput) {
        var portId = $(that).attr("port-id")
        $(that).children("a").click(function (e) {
            if(isInput) {
                openInputPort(nodeId, portId)
            }
        })
        $(that).children("a").hover(
            function (e) {
                $("#" + nodeId).addClass("wf-selected-node")
                $("." + CONSTS.WF_JSPLUMB_TYPES.PORT_ELEMENT + "[port-id='" + portId + "']")
                    .addClass("wf-selected-port").siblings("label").addClass("wf-selected-port-label")

            },
            function (e) {
                $("#" + nodeId).removeClass("wf-selected-node")
                $("." + CONSTS.WF_JSPLUMB_TYPES.PORT_ELEMENT + "[port-id='" + portId + "']")
                    .removeClass("wf-selected-port").siblings("label").removeClass("wf-selected-port-label")
            })
        $(that).children("a").children("span.sidebar-btn").click(function (e) {
            e.stopPropagation()
        })
    }

    function selectSimulationJob(simulationJobId) {
        var renderer = designer.getCurrentJsPlumbRenderer()
        console.log(renderer)
        var nodeLi =
            '{{#nodes}}' +
            '<li node-id="{{id}}" class="treeview">\n' +
            '  <a href="#" class="sidebar-btn job-li" node-id=\"{{id}}\">\n' +
            '    <i class="fa fa-cog"></i>\n' +
            '    <span>{{data.scienceAppData.name}}</span>\n' +
            // '  <span class="label label-primary pull-right sidebar-btn">\n' +
            // '    <i class="icon-arrow-right"></i>\n' +
            // '  </span>' +
            '  </a>\n' +
            '  <ul class="treeview-menu">\n' +
            '    <li class="treeview">' +
            '       <a href="#"><i class="fa fa-laptop"></i><span>input</span></a>' +
            '       <ul class="treeview-menu">' +
            '       {{#data.arrInputPorts}}' +
            '       <li class="treeview port-li input" port-id="{{id}}">\n' +
            '           <a href="#" class="sidebar-btn job-li" port-id=\"{{id}}\">\n' +
            '               <i class="fa fa-edit"></i>\n' +
            '               <span>{{name_}}</span>\n' +
            // '               <span class="label label-primary pull-right sidebar-btn">\n' +
            // '               <i class="icon-arrow-right"></i>\n' +
            // '               </span>' +
            '           </a>\n' +
            '       </li>' +
            '       {{/data.arrInputPorts}}' +
            '       </ul>' +
            '    </li>\n' +
            '    <li class="treeview">' +
            '       <a href="#"><i class="fa fa-laptop"></i><span>output</span></a>' +
            '       <ul class="treeview-menu">' +
            '       {{#data.arrOutputPorts}}' +
            '       <li class="treeview port-li output" port-id="{{id}}">\n' +
            '           <a href="#" class="sidebar-btn job-li" port-id=\"{{id}}\">\n' +
            '               <i class="fa fa-edit"></i>\n' +
            '               <span>{{name_}}</span>\n' +
            // '               <span class="label label-primary pull-right sidebar-btn">\n' +
            // '               <i class="icon-arrow-right"></i>\n' +
            // '               </span>' +
            '           </a>\n' +
            '       </li>' +
            '       {{/data.arrOutputPorts}}' +
            '</ul>' +
            '    </li>\n' +
            '  </ul>' +
            '</li>' +
            '{{/nodes}}';

        currJobs.select(simulationJobId)
        var job = currJobs.selected()
        designer.resetWorkflow()
        designer.drawScreenLogic(job.screenLogic)
        // var screenLogic = jpInstance.exportData({ type: "json" })
        var inputPorts = []
        var outputPorts = []
        currNodes.set(
            designer.getCurrentJsPlumbInstance().getNodes(),
            function (id) {
            })

        $.each(currNodes.getArray(), function(i){
            var node = this
            node.data.arrInputPorts = []
            node.data.arrOutputPorts = []
            pushPorts(node.id, node.data.inputPorts, inputPorts, node.data.arrInputPorts)
            pushPorts(node.id, node.data.outputPorts, outputPorts, node.data.arrOutputPorts)
            setPortsId(node.id, node.data.inputPorts, CONSTS.WF_JSPLUMB_TYPES.INPUT)
            setPortsId(node.id, node.data.outputPorts, CONSTS.WF_JSPLUMB_TYPES.OUTPUT)
        })

        currInputPorts.set([])
        currOutputPorts.set([])
        currInputPorts.set(inputPorts)
        currOutputPorts.set(outputPorts)

        var move = _instantDelay(100)
        $("#nodes-" + simulationJobId).empty()
            .append(Mustache.render(nodeLi, { "nodes": currNodes.getArray() }))
            .children("li")
            .each(function(i) {
                var nodeId = $(this).attr("node-id")
                $(this).hover(
                    function (e) {
                        move(function () { renderer.centerOnAndZoom(nodeId, 0.3) })
                        $("#" + nodeId).addClass("wf-selected-node")
                    },
                    function (e) {
                        $("#" + nodeId).removeClass("wf-selected-node")
                    })
                $(this).children("a").click(function(e){
                    currNodes.select(nodeId)
                })
                $(this).children("a").children("span.sidebar-btn").click(function(e) {
                    e.stopPropagation()
                })

                $(this).find("li.treeview.port-li").each(function(){
                    addPortHandler(this, nodeId, $(this).hasClass("input"))
                })
            })
    }

    function setPortData(nodeId, portName, strPortDataJson) {
        var portId = nodeId + "." + portName
        if (strPortDataJson && strPortDataJson !== "false") {
            var prevPortData = currInputPorts.get(portId)
            prevPortData[OSP.Constants.INPUTS] = JSON.parse(strPortDataJson)
            currInputPorts.update(portId, prevPortData)
        }
    }

    function openInputPort(nodeId, portId) {
        var portData = {}
        var currPortData = $.extend({}, currInputPorts.get(portId))
        delete currPortData.id
        portData[currInputPorts.get(portId)[OSP.Constants.NAME]] = currPortData;

        var node = currNodes.get(nodeId)

        window.AUI().use('liferay-portlet-url', function (A) {
            var portletURL = window.Liferay.PortletURL.createRenderURL();
            portletURL.setPortletId("ModuleViewer_WAR_OSPWorkbenchportlet");
            portletURL.setParameter('simulationUuid', simulationUuid);
            portletURL.setParameter('portData', JSON.stringify(portData));
            portletURL.setParameter('portType', "inputPorts");
            portletURL.setParameter('nodeId', nodeId);
            portletURL.setWindowState('pop_up');

            var wWidth = $(window).width();
            var wHeight = $(window).height();
            $("body").css('overflow', 'hidden')
            Liferay.Util.openWindow({
                dialog: {
                    width: wWidth,
                    height: wHeight,
                    cache: false,
                    draggable: false,
                    resizable: false,
                    modal: true,
                    destroyOnClose: true,
                    after: {
                        render: function (event) {
                            $("button.btn.close").on("click", function (e) {
                                $("body").css('overflow', '');
                            });
                        }
                    }
                },
                id: namespace + "inputPort",
                uri: portletURL.toString(),
                title: node.data.scienceAppData.name + " " + currPortData.name_
            });
        });
    }

    function openSimulation(panelType, that, e) {
        var simulationId = PANEL_DATA[panelType].form.selected;
        if(_isEmpty(simulationId, CONSTS.MESSAGE.edison_wfsimulation_select_first_message)){
            return false
        }
        _confirm(CONSTS.MESSAGE.edison_wfsimulation_new_confirm_message,
            function(){ fetchJobs(simulationId, null, 1) })
    }

    function renameSimulation(panelType, that, e) {
        var simulationId = PANEL_DATA[panelType].form.selected;
        if(_isEmpty(simulationId, CONSTS.MESSAGE.edison_wfsimulation_select_first_message)){
            return false;
        }
        var simulation = currSimulations.get(simulationId);
        var inputs = [{"name": "Title", "value": simulation.title}];
        var btns = {"ok": "Save", "cancel": "Cancel"};
        createOpenModal("Rename", inputs, btns, function(e){
            var simulationData = $.extend({}, simulation);
            simulationData.title = $("#" + namespace + "wf-modal").find("input[name='Title']").val();
            delete simulationData.createDate;
            executor.renameSimulation(simulationData, function(){
                if (PANEL_DATA.setting.form.simulationId === simulationId) {
                    PANEL_DATA.setting.form.title = simulationData.title
                }
                loadPaginatedSimulations(panelType, PANEL_DATA[panelType].form.params.p_curPage, function() {
                    if (currSimulations.getArray().length > 0) {
                        var simulationId = currSimulations.getArray()[0].simulationId
                        currSimulations.select(simulationId)
                        fetchJobs(simulationId, null,  1)
                    }
                })

                $("#" + namespace + "wf-modal").modal("hide");
            });
        });
    }

    function deleteSimulation(panelType, that, e) {
        var simulationId = PANEL_DATA[panelType].form.selected;
        if(_isEmpty(simulationId, CONSTS.MESSAGE.edison_wfsimulation_select_first_message)){
            return false;
        }
        _confirm(CONSTS.MESSAGE.edison_wfsimulation_remove_confirm_message,
            function () {
                if (currSimulations.contains(simulationId)) {
                    executor.deleteSimulation(
                        simulationId,
                        function (simulation) {
                            if (simulation) {
                                loadPaginatedSimulations(panelType, PANEL_DATA[panelType].form.params.p_curPage, function() {
                                    if (currSimulations.getArray().length > 0) {
                                        var simulationId = currSimulations.getArray()[0].simulationId
                                        currSimulations.select(simulationId)
                                        fetchJobs(simulationId, null,  1)
                                    } else {
                                        initJobs()
                                    }
                                })
                            }
                        },
                        function () {
                        })
                }
            });
    }

    function openNewSimulationPanel() {
        createPanel('New Simulation', PANEL_DATA['new'], 'new')
    }

    function newSimulation(panelDataType){
        if (isValidate()) {
            var _f = function(){
                executor.createSimulation({
                    workflowId: PANEL_DATA.setting.form.workflowId,
                    title: PANEL_DATA[panelDataType].form.title,
                }, function(simulation){
                    if(panelDataType === "new"){
                        PANEL_DATA[panelDataType].form.title = "";
                        loadPaginatedSimulations('open', 1, function() {
                            if (currSimulations.getArray().length > 0) {
                                var simulationId = currSimulations.getArray()[0].simulationId
                                currSimulations.select(simulationId)
                                fetchJobs(simulationId, null,  1)
                            } else {
                                openNewSimulationPanel()
                            }
                        })
                    }
                    setMetaData({
                        "workflowTitle": PANEL_DATA.setting.form.workflowTitle,
                        "workflowDescription": PANEL_DATA.setting.form.workflowDescription,
                        "workflowId": PANEL_DATA.setting.form.workflowId,
                        "title": simulation.title,
                        "simulationId": simulation.simulationId
                    });
                    toastr["success"]("", var_create_success_message);

                });
                closePanel();
            };
            if (PANEL_DATA.setting.form.simulationId){
                _confirm(CONSTS.MESSAGE.edison_wfsimulation_new_confirm_message, _f, closePanel);
            }else{
                _f();
            }
        }
    }

    function newSimulationJob(panelDataType){
        if (isValidate()) {
            // var ibToken = getIcebreakerAccessToken()
            var simulationId = currSimulations.selected()['simulationId']
            var _f = function(){
                executor.createSimulationJob({
                    simulationId: simulationId,
                    title: PANEL_DATA[panelDataType].form.title,
                    // icebreakerVcToken: ibToken,
                }, function(simulationJob){
                    fetchJobs(simulationId, null, 1)
                    toastr["success"]("", CONSTS.MESSAGE.edison_wfsimulation_create_success_message);
                });
                closePanel();
            };
            _confirm(CONSTS.MESSAGE.edison_wfsimulation_new_confirm_message, _f, closePanel);
        }
    }

    $("#" + namespace + "header-li-save").click(function(e){
        if(currJobs.selected()) {
            saveSimulationJob(currJobs.selected())
        } else {
            toastr["error"]("", CONSTS.MESSAGE.edison_wfsimulation_no_selected_job_message);
        }
    })

    function saveSimulationJob(job, callback) {
        var jqInstance = designer.getCurrentJsPlumbInstance()
        job.screenLogic = JSON.stringify(jqInstance.exportData({ type: "json" }))
        executor.updateSimulationJob(
            job,
            function (simulationJob) {
                if (callback) {
                    callback(simulationJob)
                } else {
                    fetchJobs(simulationJob.simulationId, null, 1, null, job.simulationJobId)
                    _delay(function () {
                        toastr["success"]("", CONSTS.MESSAGE.edison_wfsimulation_save_complete_message)
                    }, 100)
                }
            },
            function () {
            })
    }
    
    $("#" + namespace + "header-li-copy").click(function (e) {
        if(_isEmpty(currJobs.selected(), CONSTS.MESSAGE.edison_wfsimulation_no_selected_job_message)){
            return false;
        }
        var sourceJob = currJobs.selected();
        var inputs = [{"name": "Title", "value": "copy " + sourceJob.title}];
        var btns = {"ok": "Save", "cancel": "Cancel"};
        createOpenModal("Copy", inputs, btns, function(e){
            var title = $("#" + namespace + "wf-modal").find("input[name='Title']").val();
            copySimulationJob(sourceJob, title)
            $("#" + namespace + "wf-modal").modal("hide");
        });
    })
    
    /* 2019.01.15 _ Job Rename Function */
    function renameSimulationJobInPanel(panelType, that, e){
    	var simulationJobId = PANEL_DATA[panelType].form.jobId;
    	var simulationJobTitle = PANEL_DATA[panelType].form.jobTitle;
    	var job = currJobs.get(simulationJobId);
    	job.title = simulationJobTitle;
    	saveSimulationJob(job);
    }
    
    /* 2019.01.15 _ Job Copy Function */
    function copySimulationJobInPanel(){
    	$("#" + namespace + "header-li-copy").click();
    }
    
    /* 2019.01.15 _ Job Delete Function */
    function deleteSimulationJobInPanel(){
    	$("#" + namespace + "header-li-delete").click();
    }

    function copySimulationJob(job, title, callback) {
        saveSimulationJob(job, function(sourceJob){
            var params = {
                simulationJobId: sourceJob.simulationJobId,
                title: title,
            }
            executor.copySimulationJob(
                params,
                function (simulationJob) {
                    if (callback) {
                        callback(simulationJob)
                    } else {
                        fetchJobs(simulationJob.simulationId, null, 1)
                        _delay(function () {
                            toastr["success"]("", CONSTS.MESSAGE.edison_wfsimulation_save_complete_message)
                        }, 100)
                    }
                })
        })
    }

    function createOpenModal(title, inputs, btns, saveHandler) {
        var modal = $("#" + namespace + "wf-modal");
        modal.find(".modal-title").text(title);
        modal.find(".modal-body").empty().append($.Mustache.render("tpl-modal-body", { "inputs": inputs }));
        modal.find(".modal-footer").empty().append($.Mustache.render("tpl-modal-footer", btns));
        modal.modal({ "backdrop": "static", "keyboard": false });
        $("#" + namespace + "wf-modal").find("input[name='Title']").select();
        _delay(function (selector) { $(selector).find("input[name='Title']").select(); }, 500, "#" + namespace + "wf-modal");
        $("#" + namespace + "wf-modal").find("button[name='Save']").click(saveHandler);
        _enterkey("#" + namespace + "wf-modal input[name='Title']", saveHandler);
    }

    function drawWorkflowInstances(params) {
        var simulationId = getMetaData().simulationId;
        var instanceTreeSelector = "#" + namespace + "menu-panel-box .open .box-body";
        aSyncAjaxHelper.post("/delegate/services/simluation/" + simulationId + "/list",
            params,
            function (workflowInstances) {
                if($(instanceTreeSelector).hasClass("jstree")){
                    $(instanceTreeSelector).jstree(true).settings.core.data = workflowInstances;
                    $(instanceTreeSelector).jstree(true).refresh();
                }else{
                    initJstree(instanceTreeSelector, workflowInstances);
                }
            },
            function (msg) {
                toastr["error"]("", msg);
            });
    }

    $("#" + namespace + "header-li-delete").click(function (e) {
        if (_isEmpty(currJobs.selected(), CONSTS.MESSAGE.edison_wfsimulation_no_selected_job_message)) {
            return false;
        }
        _confirm(CONSTS.MESSAGE.edison_wfsimulation_remove_confirm_message,
            function () {
                var simulationId = currJobs.selected().simulationId
                executor.deleteSimulationJob(currJobs.selected(), function () {
                    fetchJobs(simulationId, null, 1)
                    toastr["success"]("", CONSTS.MESSAGE.edison_wfsimulation_delete_success_message)
                })
            },
            function () {
            });
    })

    $("#" + namespace + "header-li-submit").click(function (e) {
        submitSimulationJob()
    })

    function resetSubmitData(){
        $.each(designer.getCurrentJsPlumbInstance().getNodes(),
            function () {
                var node = this
                delete node.data.parentNodes
                delete node.data.childNodes
                delete node.data.outPort
                delete node.data.outPortFile
            })
    }

    function submitSimulationJob() {
        resetSubmitData()
        // console.log(designer.getCurrentJsPlumbInstance())
        var prefix = CONSTS.WF_ENGINE.CMD_PREFIX
        var jp = designer.getCurrentJsPlumbInstance()
        var outputPorts = currOutputPorts.getArray()
        $.each(outputPorts, function(){
            // console.log(this)
            var currSourcePortData = this
            var sourcePort = jp.getPort(this.id)
            // console.log(jp.getPort(sourcePort.id))
            $.each(sourcePort.getSourceEdges(), function(){
                var targetPort = this.target
                if(targetPort) {
                    // console.log(sourcePort)
                    // console.log(targetPort)
                    var prefixedId = prefix + targetPort.id
                    var sourceNode = sourcePort.getNode()
                    var targetNode = targetPort.getNode()
                    sourceNode.data.childNodes || (sourceNode.data.childNodes = [])
                    if($.inArray(targetNode.getFullId(), sourceNode.data.childNodes) < 0){
                        sourceNode.data.childNodes.push(targetNode.getFullId())
                    }

                    sourceNode.data.outPort || (sourceNode.data.outPort = {})
                    sourceNode.data.outPort.hasOwnProperty(prefixedId) || (sourceNode.data.outPort[prefixedId] = [])
                    if($.inArray(targetNode.getFullId(), sourceNode.data.outPort[prefixedId]) < 0){
                        sourceNode.data.outPort[prefixedId].push(targetNode.getFullId())
                    }

                    sourceNode.data.outPortFile || (sourceNode.data.outPortFile = {})
                    sourceNode.data.outPortFile[prefixedId] = currSourcePortData[OSP.Constants.OUTPUT_DATA][OSP.Constants.NAME]

                    targetNode.data.parentNodes || (targetNode.data.parentNodes = [])
                    if($.inArray(sourceNode.getFullId(), targetNode.data.parentNodes) < 0){
                        targetNode.data.parentNodes.push(sourceNode.getFullId())
                    }
                }
            })
        })
        console.log(designer.getCurrentJsPlumbInstance().exportData({ type: "json" }))
        // console.log(designer.getCurrentJsPlumbInstance().getNodes())
    }

    /////////////////////////////////////////// renew end

    function run(){
        // console.log("run");
        var simulationId = PANEL_DATA.setting.form.simulationId;
        var simulationTitle = PANEL_DATA.setting.form.simulationTitle;
        executor.getWorkflowInstance(simulationId,
            function (currentWorkflowInstance) {
                if(currentWorkflowInstance.status === WF_STATUS_CODE.CREATED){
                    var ibToken = getIcebreakerAccessToken();
                    saveWorkflowInstance(simulationId, simulationTitle,
                        function (workflowInstance) {
                            executor.runWorkflowInstance(simulationId, ibToken);
                            toastr["success"]("", var_success_run_workflow_message);
                        });
                }else{
                    toastr["error"]("", var_already_run_message);
                }
            }, function () { });

    }
    function rerun(){
        if($(".wf-box.reset").length){
            var simulationId = PANEL_DATA.setting.form.simulationId;
            executor.reRunWorkflowInstance(simulationId,
                designer.getWorkflowDefinition(designer.getCurrentJsPlumbInstance()),
                function (workflowInstance) {
                    var ibToken = getIcebreakerAccessToken();
                    executor.runWorkflowInstance(workflowInstance.simulationId, ibToken);
                    toastr["success"]("", var_success_run_workflow_message);
                });
        }else{
            toastr["error"]("","Reset First.");
        }

    }
    function pause(){
        var simulationId = PANEL_DATA.setting.form.simulationId;
        executor.getWorkflowInstance(simulationId,
            function (currentWorkflowInstance) {
                if(currentWorkflowInstance.status === WF_STATUS_CODE.RUNNING){
                    executor.pauseWorkflowInstance(simulationId, function(workflowInstance){
                        toastr["success"]("", var_pause_success_message);
                    });
                }else{
                    toastr["error"]("", "Workflow is not running.");
                }});
    }

    function restart(){
        var simulationId = PANEL_DATA.setting.form.simulationId;
        executor.getWorkflowInstance(simulationId,
            function (currentWorkflowInstance) {
                if(currentWorkflowInstance.status === WF_STATUS_CODE.PAUSED){
                    executor.resumeWorkflowInstance(simulationId, function(workflowInstance){
                        toastr["success"]("", var_resume_success_message);
                    });
                }else{
                    toastr["error"]("", "Workflow is not paused.");
                }});
    }

    function drawWorkflowStatus(simulationId){
        executor.getWorkflowInstanceStatus(simulationId, function(workflowStatus){
            var simulations = workflowStatus.workflow.simulations;
            if (!simulations.length || simulations.length < 1) {
                toastr["error"]("", "No Simulations");
                return false;
            }
            sortSimulations(simulations);
            var tableSimulations = [];
            for (var i = 0; i < simulations.length; i++) {
                var tableSimulation = {};
                tableSimulation.title = simulations[i].title;
                if (simulations[i].status) {
                    tableSimulation.status = WF_STATUS_CODE_STRING[simulations[i].status];
                } else {
                    tableSimulation.status = "Waiting";
                }
                if(simulations[i].jobs[0].submittedTime){
                    tableSimulation.submittedTime = $.format.date(new Date(simulations[i].jobs[0].submittedTime), "yyyy.MM.dd HH:mm:ss")
                }else{
                    tableSimulation.submittedTime = "";
                }
                if(simulations[i].jobs[0].endTime){
                    tableSimulation.endTime = $.format.date(new Date(simulations[i].jobs[0].endTime), "yyyy.MM.dd HH:mm:ss");
                }else{
                    tableSimulation.endTime = "";
                }
                tableSimulations.push(tableSimulation);
            }
            var tbodyTemplate = '{{#rows}}' +
                '    <tr>' +
                '        <td>{{title}}</td>' +
                '        <td>{{status}}</td>' +
                '        <td>{{submittedTime}}</td>' +
                '        <td>{{endTime}}</td>' +
                '    </tr>' +
                '{{/rows}}';
            tbodyTemplate +=
                '{{^rows}}' +
                '    <tr>' +
                '        <td colspan="4">No Data</td>' +
                '    </tr>' +
                '{{/rows}}';

            if (tableSimulations && tableSimulations.length > 0) {
                $(JQ_PORTLET_BOUNDARY_ID + " .menu-panel tbody.panel-tbody").empty().append(
                    Mustache.render(tbodyTemplate, { "rows": tableSimulations }));
            }else{
                $(JQ_PORTLET_BOUNDARY_ID + " .menu-panel tbody.panel-tbody").empty().append(
                    Mustache.render(tbodyTemplate, { "rows": tableSimulations }));
            }

        });
    }

    function sortSimulations(simulations){
        simulations.sort(function (a, b) {
            if (!a.jobs[0].submittedTime || !b.jobs[0].submittedTime)
                return 1;
            if (a.jobs[0].submittedTime > b.jobs[0].submittedTime)
                return 1;
            if (a.jobs[0].submittedTime < b.jobs[0].submittedTime)
                return -1;
            return 0;
        });
    }

    function status(that, btnType){
        var templateData = PANEL_DATA[btnType];
        templateData.boxtitle = "Simulation Status";
        var simulationId = PANEL_DATA.setting.form.simulationId;
        $("#" + namespace + "menu-panel-box").show();
        $("#" + namespace + "menu-panel-box").empty().mustache('tpl-menu-panel-box', templateData);
        $("#" + namespace + "menu-panel-box .box-body").mustache(templateData.body, templateData);
        if (templateData.header) {
            var boxTitleSelecotr = "#" + namespace + "menu-panel-box .box-header.with-border.header-inner > .box-title";
            $(boxTitleSelecotr).replaceWith($.Mustache.render(templateData.header.id, templateData));
            var _delay600 = _instantDelay(600);
            $(boxTitleSelecotr + " > .search-input").keyup(function (e) {
                _delay600(drawWorkflowStatus, btnType);
            });
        }

        drawWorkflowStatus(simulationId);

        $(".menu-panel .menu-panel-close").click(function (e) {
            e.preventDefault();
            closePanel();
        });

        $("#" + namespace + "menu-panel-box .data-binded").change(function (e) {
            var thisValue = $(this).val();
            var thisName = $(this).attr("name");
            templateData.form[thisName] = thisValue;
        });

        $("#" + namespace + "menu-panel-box .func").each(function (_) {
            var thisName = $(this).attr("name");
            if (templateData.btn && templateData.btn[thisName]) {
                $(this).click(function (e) {
                    templateData.btn[thisName](btnType, this, e);
                });
            }
        });

        if($(that).parent("li").hasClass("menu-open")){
            $(".menu-panel").toggle('slide', { direction: 'left' }, 500);
            $(JQ_PORTLET_BOUNDARY_ID + " .sidebar-menu > li").removeClass("menu-open");
        }else{
            $(that).parent("li").addClass("menu-open")
            $(".menu-panel").show('slide', { direction: 'left' }, 500);
        }

    }

    function getIcebreakerAccessToken(){
        var fn = window[namespace + "getIcebreakerAccessToken"];
        return fn.apply();
    }

    function initJstree(instanceTreeSelector, instancesData){
        $(instanceTreeSelector).jstree({
            "core" : {
                "check_callback" : true,
                "data" : instancesData,
                "themes" : {
                    "name" : "proton",
                    "responsive" : true
                }
            },
            "types": {
                "root": {},
                "workflow": {},
                "instance": {
                    "icon": "icon-file"
                }
            },
            "progressive_render" : true,
            "plugins" : ["types", "search"]
        }).bind("loaded.jstree", function(event, data){
            $(instanceTreeSelector).jstree(true).open_all();
            var _delay600 = _instantDelay(600);
            var boxTitleSelecotr = "#" + namespace +
                "menu-panel-box .box-header.with-border.header-inner > .box-title";
            var selectedWorkflowInstanceId = PANEL_DATA.setting.form.simulationId;
            $(boxTitleSelecotr + " > .search-input").keyup(function (e) {
                var searchString = $(this).val();
                _delay600(function(){
                    $(instanceTreeSelector).jstree(true).search(searchString);
                    if(!_isEmpty(selectedWorkflowInstanceId)){
                        $(instanceTreeSelector + " .jstree-node#" + selectedWorkflowInstanceId).
                        addClass("selected-jstree");
                    }
                });
            });
        }).bind("load_node.jstree", function(event, data){
        }).bind("select_node.jstree", function(event, data){
            var nodeId = data.node.id;
            var node = data.node;
            if(node.type === "workflow"){
                if(!$("#" + nodeId).hasClass("jstree-open")){
                    openJstreeNode(instanceTreeSelector, nodeId, node);
                }else{
                    $(instanceTreeSelector).jstree("close_node", node);
                }
            }else if(node.type === "instance"){
                var simulationId = node.data.simulationId;
                loadInstance(simulationId);
                //displayJob(nodeId);
            }
        }).bind("hover_node.jstree", function(event, data){
        });
    }

    function loadInstance(simulationId) {
        executor.loadWorkflowInstance(simulationId,
            function (workflowInstance) {
                designer.resetWorkflow();
                designer.drawScreenLogic(workflowInstance.screenLogic);
                setMetaData({
                    "title": PANEL_DATA.setting.form.title,
                    "description": PANEL_DATA.setting.form.description,
                    "workflowId": PANEL_DATA.setting.form.workflowId,
                    "simulationTitle": workflowInstance.title,
                    "simulationId": workflowInstance.simulationId
                });
            }, function (err) {
                if(console){
                    console.log(err);
                }
            });
    }

    function openJstreeNode(instanceTreeSelector, nodeId, node){
        if($("#" + nodeId).hasClass("is-loaded")){
            $(instanceTreeSelector).jstree("open_node", node);
        }
    }

    function saveOrUpdateWorkflowInstance(panelDataType) {
        if (isValidate()) {
            if (_isEmpty(PANEL_DATA.setting.form.simulationId)) {
                newSimulation(panelDataType);
            } else {
                var simulationId = PANEL_DATA.setting.form.simulationId;
                var simulationTitle = PANEL_DATA.setting.form.simulationTitle;
                saveWorkflowInstance(simulationId, simulationTitle,
                    function (workflowInstance) {
                        setMetaData({
                            "title": PANEL_DATA.setting.form.title,
                            "description": PANEL_DATA.setting.form.description,
                            "workflowId": PANEL_DATA.setting.form.workflowId,
                            "simulationTitle": workflowInstance.title,
                            "simulationId": workflowInstance.simulationId
                        });
                        toastr["success"]("", var_save_success_message);
                        closePanel();
                    });
            }
        }
    }

    function saveWorkflowInstance(simulationId, simulationTitle, callback) {
        executor.updateWorkflowInstance(simulationId, simulationTitle,
            designer.getWorkflowDefinition(designer.getCurrentJsPlumbInstance()), callback);
    }

    function openWorkflowByWorkflowId(workflowId, isNotNew, callback){
        designer.loadWorkflowDefinition(workflowId, function(workflow){
            if(!isNotNew){
                setMetaData({
                    "workflowTitle": workflow.title,
                    "workflowDescription": workflow.description,
                    "workflowId": workflowId
                });

                loadPaginatedSimulations('open', 1, function() {
                    if (currSimulations.getArray().length > 0) {
                        var simulationId = currSimulations.getArray()[0].simulationId
                        currSimulations.select(simulationId)
                        fetchJobs(simulationId, null,  1)
                    } else {
                        _delay(function() {
                            $("#" + namespace + "header-li-simulation").click()
                            openNewSimulationPanel()
                        }, 500)
                    }
                })

                if(callback) {
                    callback()
                }
            }
        });
    }

    function getMetaData(){
        return PANEL_DATA.setting.form;
    }

    function setMetaData(metadata){
        setTitle(metadata.title, metadata.simulationTitle);
        PANEL_DATA.setting.form = $.extend({}, metadata);
    }

    function setTitle(titleText, simulationTitle) {
        titleText = titleText || "";
        simulationTitle = simulationTitle || "";
        $("#" + namespace + "workflow-title").text(titleText);
        $("#" + namespace + "workflow-sub-title").text(simulationTitle);
    }

    function isValidate() {
        $("#" + namespace + "menu-panel-box form").validator('validate');
        return $("#" + namespace + "menu-panel-box form").find(".has-error").length === 0;
    }

    function closePanel() {
        $(".menu-panel").hide('slide', { direction: 'left' }, 500);
        $(JQ_PORTLET_BOUNDARY_ID + " li.top-btn.active").removeClass("active");
    }

    function activateLi(jqLink) {
        $(JQ_PORTLET_BOUNDARY_ID + " li.top-btn.active").removeClass("active");
        $(jqLink).addClass("active");
    }

    function getValueByInputName(inputName){
        return $("input[name='" + inputName + "']").val();
    }

    function _isEmpty(value, msg){
        if(!value){
            if(msg){
                toastr["info"]("", msg);
            }
            return true;
        }
        return false;
    }

    $(document).bind('keydown.uiPanel',function (event) {
        if ((event.which == 115 || event.which == 83) &&
            (event.ctrlKey || event.metaKey) || (event.which == 19)) {
            event.preventDefault();
            if(currJobs.selected()) {
                saveSimulationJob(currJobs.selected())
            } else {
                toastr["error"]("", CONSTS.MESSAGE.edison_wfsimulation_no_selected_job_message);
            }
            return false;
        }
        return true;
    });

	/* 2019.01.02 _ Popup Button Event */
	var openScienceAppWorkbench = function(node) {
		var modal = $("#" + namespace + "science-app-workbench-modal");

		var nodeData = node.data;
		var wfId = nodeData.id;

		if(nodeData[CONSTS.WF_NODE_CODE.IB_DATA] == 'undefined' || nodeData[CONSTS.WF_NODE_CODE.IB_DATA] == null){
			nodeData[CONSTS.WF_NODE_CODE.IB_DATA] = {};
		}
		var simulationUuid = nodeData[CONSTS.WF_NODE_CODE.IB_DATA][CONSTS.WF_NODE_CODE.IB_SIM_UUID];
		var jobUuid = nodeData[CONSTS.WF_NODE_CODE.IB_DATA][CONSTS.WF_NODE_CODE.IB_UUID];
		var scienceAppData = nodeData.scienceAppData;
		var scienceAppId = scienceAppData.scienceAppId;
		var inputPorts = nodeData.inputPorts;

		/* Get Connected Input Ports and Disconnected Input Ports */
		var connectedInputPorts = new Array();
		var disconnectedInputPorts = new Array();
		var jobDataArr = new Array();
		for ( var portIndex in node.getPorts()) {
			var port = node.getPorts()[portIndex];
			var portType = port["data"]["type"];
			if (portType == "inputPorts") {
				if (port.getAllEdges().length == 1) {
					connectedInputPorts.push(port.id);

					/* Get Parent Node's JobData */
					var targetEdges = port.getTargetEdges();
					var getJobData = getParentPortsJobData(targetEdges[0]);
					if (getJobData != 'undefined' && getJobData != null
							&& getJobData != '') {
						jobDataArr = jobDataArr.concat(getJobData);
					}
				} else {
					disconnectedInputPorts.push(port.id);

					/* Get Node's JobData */
					var getJobData = getInputPortsJobData(port.getNode(),
							port.id)
					if (getJobData != 'undefined' && getJobData != null
							&& getJobData != '') {
						jobDataArr = jobDataArr.concat(getJobData);
					}
				}
			}
		}

		/* test Uuid */
		simulationUuid = "0028ec20-8d46-4bde-890b-7e2ac0520a32";
		jobUuid = "fa796ee7-4b2e-424e-b665-5df2d26edfc9";

		if (0 < jobDataArr.length) {
			/* Call API get-simulation-job */
			var getSimulationJob = Liferay.Service(
					'/edison-simulation-portlet.simulation/get-simulation-job',
					{
						userId : Liferay.ThemeDisplay.getUserId(),
						appName : scienceAppData.name,
						appVersion : scienceAppData.version,
						simulationUuid : simulationUuid,
						jobUuid : jobUuid,
						jobData : JSON.stringify(jobDataArr)
					}, function(obj) {
						if (obj.hasSimulationInfo) {
							openWorkbenchPopup(scienceAppId, simulationUuid,
									jobUuid, connectedInputPorts, wfId);
						} else {
							toastr["error"]("", "Simulation not exist!!");
						}
					});
		} else {
			toastr["error"]("", "JobData not found!!");
		}
	}

	function getInputPortsJobData(portNode, portId) {
		var jobDataArr = new Array();
		jobDataArr = [];

		var inputPorts = portNode.data.inputPorts;
		var inputPort = inputPorts[portId];
		var isWfSample = inputPort.isWfSample_;
		var inputPortData = inputPort.inputData_;
		if(isWfSample){
			inputPortData = inputPort.wfSample_;
		} else {
			if(inputPort.inputData_){
				inputPortData = inputPort.inputData_;
			} else {
				inputPortData = inputPort.sample_;
			}
		}

		jobDataArr.push(inputPortData);
		return jobDataArr;
	}

	function getParentPortsJobData(targetEdge) {
		var jobDataArr = new Array();
		jobDataArr = [];
		var sourcePort = targetEdge.source;
		var sourceNode = sourcePort.getNode();
		var sourceNodeData = sourceNode.data;
		var runType = sourceNodeData.scienceAppData.runType;

		findJobData: while (runType == 'Controller'
				|| runType == 'DynamicConverter') {
			for ( var portIndex in sourceNode.getPorts()) {
				var port = sourceNode.getPorts()[portIndex];
				if ((runType == 'Controller' && port.id == 'transfer')
						|| (runType == 'DynamicConverter' && port.id == 'localfile0')) {

					var targetEdges = port.getTargetEdges();
					if (targetEdges == 'undefined' || targetEdges == null
							|| targetEdges == '') {
						toastr["error"]("", "JobData not found!!");
						break findJobData;
					} else {
						sourcePort = targetEdges[0].source;
						if (sourcePort == undefined) {
							break findJobData;
						} else {
							sourceNode = sourcePort.getNode();
							sourceNodeData = sourceNode.data;
							runType = sourceNodeData.scienceAppData.runType;
							continue findJobData;
						}
					}
				}
			}
		}

		if (runType != CONSTS.WF_APP_TYPES.CONTROLLER.NAME 
				&& runType != CONSTS.WF_APP_TYPES.DYNAMIC_CONVERTER.NAME) {
			/* get outputData in outputPorts */
			var outputPorts = sourceNodeData.outputPorts;
			for ( var key in outputPorts) {
				var outputPort = outputPorts[key];
				var outputData = "";
				var isWfSample = outputPort.isWfSample_; 

				if(runType == CONSTS.WF_APP_TYPES.FILE_COMPONENT.NAME){
					if(isWfSample){
						outputData = outputPort.wfSample_;
					} else {
						outputData = outputPort.sample_;
					}
				} else{
					outputData = outputPort.outputData_;
				}
				
				var outputDataType = outputData.type_;
				if (outputDataType != 'dlEntryId_') {
					jobDataArr.push(outputData);
				}
			}
		}
		return jobDataArr;
	}

	function openWorkbenchPopup(scienceAppId, simulationUuid, jobUuid,
			connectedInputPorts, nodeId) {
		var getWorkbenchHtml = null;
		window.AUI().use('liferay-portlet-url', function(A) {
			var portletURL = window.Liferay.PortletURL
					.createRenderURL();
			portletURL
					.setPortletId("SimulationWorkbench_WAR_OSPWorkbenchportlet");
			portletURL.setParameter('workbenchType',
					"SIMULATION_WITH_WORKFLOW");
			portletURL.setParameter('scienceAppId',
					scienceAppId);
			portletURL.setParameter('simulationUuid',
					simulationUuid);
			/* portletURL.setParameter('jobUuid', ""); */
			portletURL.setParameter('blockInputPorts',
					connectedInputPorts.toString());
			portletURL.setParameter('nodeId',
					nodeId);
			portletURL.setWindowState('pop_up');

			var wWidth = $(window).width();
			var wHeight = $(window).height();
			$("body").css('overflow', 'hidden')
			Liferay.Util.openWindow({
				dialog : {
					width : wWidth,
					height : wHeight,
					cache : false,
					draggable : false,
					resizable : false,
					modal : true,
					destroyOnClose : true,
					after : {
						render : function(event) {
							$("button.btn.close").on("click", function(e) {
								$("body").css('overflow','');
							});
						}
					}
				},
				id : "dataTypeSearchDialog",
				uri : portletURL.toString(),
				title : "Workbench"
			});
		});
	}

	/* 2019.01.07 _ Setting selected simulationUuid and jobUuid in the workbench */
	function setSelectedJobFromWorkbench(nodeId, simulationUuid, jobUuid){
		var node = designer.getCurrentJsPlumbInstance().getNode(nodeId);
		var nodeData = node.data;
		if(nodeData) {
			if(!nodeData[CONSTS.WF_NODE_CODE.IB_DATA]) {
				nodeData[CONSTS.WF_NODE_CODE.IB_DATA] = {}
			}
			nodeData[CONSTS.WF_NODE_CODE.IB_DATA][CONSTS.WF_NODE_CODE.IB_SIM_UUID] = simulationUuid;
			nodeData[CONSTS.WF_NODE_CODE.IB_DATA][CONSTS.WF_NODE_CODE.IB_UUID] = jobUuid;

			/* TODO Workflow Status Setting */

			nodeData[CONSTS.WF_NODE_CODE.STATUS].status = "";
		}
	}

	return {
		"openWorkflow" : openWorkflowByWorkflowId,
		"openScienceAppWorkbench" : openScienceAppWorkbench,
		"setSelectedJobFromWorkbench" : setSelectedJobFromWorkbench,
		"setPortData" : setPortData,
		"isEmpty" : function() {
			return _isEmpty(PANEL_DATA.setting.form.workflowId
					&& PANEL_DATA.setting.form.simulationId);
		}
	};
});
