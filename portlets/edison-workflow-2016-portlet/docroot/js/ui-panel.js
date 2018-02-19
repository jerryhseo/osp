var UIPanel = (function (namespace, $, designer, toastr) {
    'use strict';
    var currWorkflows = (function () {
        var currWorkflows;
        return {
            "set": function (workflows) {
                currWorkflows = {};
                $.each(workflows, function () {
                    var workflow = this;
                    currWorkflows[workflow.workflowId] = workflow;
                });
            },
            "get": function (key) {
                return arguments.length === 0 ? currWorkflows : currWorkflows[key];
            },
            "contains": function(key){
                if(!key){
                    return false;
                }
                if($.isEmptyObject(currWorkflows)){
                    return false;
                }
                return currWorkflows.hasOwnProperty(key);
            }
        };
    })();
    var PANEL_DATA = {
        "apps": {
            "col": 4,
            "panel-type": "apps",
            "header":{
                "id": "tpl-menu-panel-search-header",
                "search-input-name": "search"
            } 
        }, "new": {
            "col": 6,
            "panel-type": "new",
            "body": "tpl-menu-panel-new",
            "form": {},
            "btn": {
                "create": newDesigner
            }
        }, "open": {
            "col": 10,
            "panel-type": "open",
            "body": "tpl-menu-panel-load",
            "header":{
                "id": "tpl-menu-panel-search-header",
                "search-input-name": "search",
                "theads": ["Title", "Description", "Copied from", "Created"]
            },
            "form": {},
            "footer":{
                "id": "tpl-menu-panel-pagination",
                "btns" : [
                    { "name": "Open", "func": openWorkflow },
                    { "name": "Rename", "func": renameWorkflow },
                    { "name": "Duplicate", "func": duplicateWorkflow },
                    { "name": "Delete", "func": deleteWorkflow }
                ]
            }
        }, "import": {
            "col": 10,
            "panel-type": "import",
            "body": "tpl-menu-panel-load",
            "header":{
                "id": "tpl-menu-panel-search-header",
                "search-input-name": "search",
                "theads": ["Title", "Version", "User ID", "Description"]
            },
            "form": {},
            "footer": {
                "id": "tpl-menu-panel-pagination",
                "btns" : [
                    { "name": "Import", "func": importWorkflow }
                ]
            } 
        }, "save-as": {
            "col": 6,
            "panel-type": "save",
            "body": "tpl-menu-panel-save",
            "form": {},
            "btn": {
                "save": saveAsDesigner
            }
        }, "setting": {
            "col": 6,
            "panel-type": "setting",
            "body": "tpl-menu-panel-setting",
            "form": {},
            "btn": {
                "update": saveOrUpdateDesigner,
                "exportWorkflow": exportWorkflow,
                "delete": deleteWorkflow
            }
        }
    };
    var JQ_PORTLET_BOUNDARY_ID = "#p_p_id" + namespace;

    $(JQ_PORTLET_BOUNDARY_ID + " .sidebar-btn[data-btn-type='save']").click(function (e) {
        e.stopPropagation();
        saveOrUpdateDesigner();
    });

    $(JQ_PORTLET_BOUNDARY_ID + " .sidebar-btn").click(function (e) {
        e.preventDefault();
        var btnType = $(this).attr("data-btn-type");
        var templateData = PANEL_DATA[btnType];

        if (templateData) {
            activateLi(this);
            templateData.boxtitle = $(this).text();
            if(btnType === "open" && PANEL_DATA.setting.form.workflowId) {
                PANEL_DATA[btnType].form.selected = PANEL_DATA.setting.form.workflowId;
            }
            if (btnType === "apps") {
                if (!$("#" + namespace + "menu-panel-box-app").hasClass("loaded")) {
                }
                $("#" + namespace + "menu-panel-box-app").show();
                $("#" + namespace + "menu-panel-box").hide();
            } else {
                $("#" + namespace + "menu-panel-box-app").hide();
                $("#" + namespace + "menu-panel-box").show();
                $("#" + namespace + "menu-panel-box").empty().mustache('tpl-menu-panel-box', templateData);
                $("#" + namespace + "menu-panel-box .box-body").mustache(templateData.body, templateData);
                if(templateData.header){
                    var boxTitleSelecotr = "#" + namespace + "menu-panel-box .box-header.with-border.header-inner > .box-title";
                    var _delay600 = _instantDelay(600);
                    $(boxTitleSelecotr).replaceWith($.Mustache.render(templateData.header.id, templateData));
                    $(boxTitleSelecotr + " > .search-input").keyup(function(e){
                        _delay600(loadWorkflowDefinitions, btnType);
                    });
                }
                if (templateData.footer) {
                    $("#" + namespace + "menu-panel-box .box")
                        .append($.Mustache.render(templateData.footer.id, templateData));
                }
            }
            loadWorkflowDefinitions(btnType);
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
            if($(this).parent("li").hasClass("menu-open")){
                $(".menu-panel").toggle('slide', { direction: 'left' }, 500);
                //$(this).parent("li").removeClass("menu-open");
                $(JQ_PORTLET_BOUNDARY_ID + " .sidebar-menu > li").removeClass("menu-open");
            }else{
                $(".menu-panel").show('slide', { direction: 'left' }, 500);
            }
        }
    });

    $(document).keypress(function (event) {
        if ((event.which == 115 || event.which == 83) && 
            (event.ctrlKey || event.metaKey) || (event.which == 19)) {
            event.preventDefault();
            saveOrUpdateDesigner();
            return false;
        }
        return true;
    });

    function _isEmpty(value, msg){
        if(!value){
            if(msg){
                toastr["info"]("", msg);
            }
            return true;
        }
        return false;
    }

    function newDesigner(panelDataType, that, event) {
        if (isValidate()) {
            var _f = function(){
                designer.resetWorkflow();
                setMetaData(PANEL_DATA[panelDataType].form);
                PANEL_DATA[panelDataType].form.title = "";
                PANEL_DATA[panelDataType].form.description = "";
                toastr["success"]("", var_create_success_message);
                closePanel();
            };
            if (PANEL_DATA.setting.form.title){
                _confirm(var_new_workflow_confirm_message, _f, closePanel);
            }else{
                _f();
            }
        }
    }

    function saveOrUpdateDesigner(){
        designer.saveOrUpdateWorkflowDefinition(PANEL_DATA.setting.form,
            function (workflowId) {
                PANEL_DATA.setting.form.workflowId = workflowId;
                setMetaData(PANEL_DATA.setting.form);
            });
        closePanel();
    }

    function saveAsDesigner(panelDataType, that, event) {
        if (isValidate()) {
            setMetaData(PANEL_DATA[panelDataType].form);
            designer.saveAsWorkflowDefinition(PANEL_DATA[panelDataType].form,
                function (workflowId) {
                    PANEL_DATA.setting.form.workflowId = workflowId;
                    setMetaData(PANEL_DATA.setting.form);
                });
            closePanel();
        }
    }

    function setMetaData(metadata){
        setTitle(metadata.title);
        PANEL_DATA.setting.form = $.extend({}, metadata);
        PANEL_DATA["save-as"].form = PANEL_DATA.setting.form;
    }

    function setTitle(titleText) {
        titleText = titleText || "";
        $("#" + namespace + "workflow-title").text(titleText);
    }

    function isValidate() {
        $("#" + namespace + "menu-panel-box form").validator('validate');
        return $("#" + namespace + "menu-panel-box form").find(".has-error").length === 0;
    }

    function closePanel() {
        $(".menu-panel").hide('slide', { direction: 'left' }, 500);
        $(JQ_PORTLET_BOUNDARY_ID + " .sidebar > .sidebar-menu > li.active").removeClass("active");
    }

    function activateLi(jqLink) {
        $(JQ_PORTLET_BOUNDARY_ID + " .sidebar > .sidebar-menu > li.active").removeClass("active");
        $(jqLink).parent("li").addClass("active");
    }

    function loadWorkflowDefinitions(panelType, currentPage){
        if(panelType === 'open' || panelType === 'import'){
            currentPage = currentPage || 1;
            var templateData = PANEL_DATA[panelType];
            var isPublic = panelType === 'import';
            var params = getWorkflowDefinitionParam(
                getValueByInputName(
                    templateData.header["search-input-name"]), currentPage, isPublic);
            templateData.form.params = params;
                
            drawWorkflowDefinitions(params, isPublic);
        }
    }

    function drawWorkflowDefinitions(params, isPublic) {
        aSyncAjaxHelper.post("/delegate/services/workflows",
            params,
            function (result) {
                currWorkflows.set(result.workflows);
                drawWorkflowTable(result, isPublic);
            },
            function (msg) {
                toastr["error"]("", msg);
            });
    }

    function getValueByInputName(inputName){
        return $("input[name='" + inputName + "']").val();
    }

    function getWorkflowDefinitionParam(searchKeyword, p_curPage, isPublic, linePerPage){
        var params = {};
        if (searchKeyword || searchKeyword === 0) {
            params.title = searchKeyword;
        }
        if (p_curPage) {
            params.p_curPage = p_curPage;
        }
        if (linePerPage) {
            params.linePerPage = linePerPage;
        }
        if (isPublic) {
            params.isPublic = "true";
        }
        return params;
    }

    function drawWorkflowTable(workflowsMap, isPublic) {
        var tbodyTemplate = isPublic ? 
            '{{#rows}}'+
            '    <tr workflow-id="{{workflowId}}">'+
            '        <td>{{title}}</td>'+
            '        <td>{{version}}</td>'+
            '        <td>{{screenName}}</td>'+
            '        <td>{{description}}</td>'+
            '    </tr>'+
            '{{/rows}}' :
            '{{#rows}}'+
            '    <tr workflow-id="{{workflowId}}">'+
            '        <td>{{title}}</td>'+
            '        <td>{{description}}</td>'+
            '        <td>{{parentTitle}}</td>'+
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
        
        tbody(workflowsMap.workflows, tbodyTemplate, _panelType(isPublic));
        pagination(workflowsMap.pagination, paginationTemplate, _panelType(isPublic));
        buttons(buttonTemplate, _panelType(isPublic));
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
    
    function openWorkflow(panelType, that, e){
        var workflowId = PANEL_DATA[panelType].form.selected;
        if(_isEmpty(workflowId, var_select_workflow_first_message)){
            return false;
        }
        var _f = function(){
            if(currWorkflows.contains(workflowId)){
                var workflow = currWorkflows.get(workflowId);
                setMetaData({
                    "title": workflow.title,
                    "description": workflow.description,
                    "workflowId": workflowId
                });
                designer.loadWorkflowDefinition(workflow);
                closePanel();
            }
        };
        if(!_isEmpty(PANEL_DATA.setting.form.title)){
            _confirm(var_new_workflow_confirm_message, _f);
        }else{
            _f();
        }
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

    function renameWorkflow(panelType, that, e){
        var workflowId = PANEL_DATA[panelType].form.selected;
        if(_isEmpty(workflowId, var_select_workflow_first_message)){
            return false;
        }
        if(currWorkflows.contains(workflowId)){
            var workflow = currWorkflows.get(workflowId);
            var inputs = [{"name": "Title", "value": workflow.title}];
            var btns = {"ok": "Save", "cancel": "Cancel"};
            createOpenModal("Rename", inputs, btns, function(e){
                var workflowData = $.extend({}, workflow);
                workflowData.title = $("#" + namespace + "wf-modal").find("input[name='Title']").val();
                delete workflowData.createDate;
                designer.renameWorkflowDefinition(workflowData, function(){
                    if (PANEL_DATA.setting.form.workflowId === workflowId) {
                        setMetaData({
                            "title": workflowData.title,
                            "description": workflowData.description,
                            "workflowId": workflowId
                        });
                    }
                    loadWorkflowDefinitions(panelType, PANEL_DATA[panelType].form.params.p_curPage);
                    $("#" + namespace + "wf-modal").modal("hide");
                });
            });
        }
    }

    function duplicateWorkflow(panelType, that, e){
        var workflowId = PANEL_DATA[panelType].form.selected;
        if(_isEmpty(workflowId, var_select_workflow_first_message)){
            return false;
        }
        if(currWorkflows.contains(workflowId)){
            var workflow = currWorkflows.get(workflowId);
            var inputs = [{"name": "Title", "value": workflow.title}];
            var btns = {"ok": "Save", "cancel": "Cancel"};
            createOpenModal("Duplicate", inputs, btns, function (e) {
                designer.duplicateWorkflowDefinition(
                    workflowId,
                    $("#" + namespace + "wf-modal").find("input[name='Title']").val(),
                    function () {
                        loadWorkflowDefinitions(panelType, PANEL_DATA[panelType].form.params.p_curPage);
                        $("#" + namespace + "wf-modal").modal("hide");
                    });
            });
        }
    }

    function deleteWorkflow(panelType, that, e){
        var workflowId = panelType === "setting" ? 
                PANEL_DATA[panelType].form.workflowId : 
                PANEL_DATA[panelType].form.selected;
        var workflow = currWorkflows.get(workflowId);
        if(_isEmpty(workflowId, var_select_workflow_first_message)){
            return false;
        }
        _confirm(var_remove_workflow_confirm_message, function () {
            designer.deleteWorkflowDefinition(workflowId,
                function (resetDesignerFn) {
                    if (PANEL_DATA.setting.form.workflowId === workflowId) {
                        designer.resetWorkflow();
                        setMetaData({});
                        if(panelType === "setting"){
                            $("#" + namespace + "menu-panel-box .data-binded").val("");
                        }
                    }
                    toastr["success"]("", var_success_remove_workflow_message);
                    loadWorkflowDefinitions(panelType, PANEL_DATA.open.form.params.p_curPage);
                });
        }, function () { });
    }
    
    function importWorkflow(panelType, that, e){
        var workflowId = PANEL_DATA[panelType].form.selected;
        if(_isEmpty(workflowId, var_select_workflow_first_message)){
            return false;
        }
        var _f = function(){
            if(currWorkflows.contains(workflowId)){
                var workflow = currWorkflows.get(workflowId);
                setMetaData({
                    "title": "Imported from " + workflow.title,
                    "description": workflow.description,
                    "workflowId": workflowId
                });
                designer.loadWorkflowDefinition(workflow);
                saveAsDesigner("setting");
                closePanel();
            }
        };
        if(!_isEmpty(PANEL_DATA.setting.form.title)){
            _confirm(var_new_workflow_confirm_message, _f);
        }else{
            _f();
        }
    }

    function exportWorkflow(panelType, that, e){
        var workflowId = PANEL_DATA.setting.form.workflowId;
        if(_isEmpty(workflowId, var_select_workflow_first_message)){
            return false;
        }
        PANEL_DATA.setting.form.isPublic = true;
        designer.saveOrUpdateWorkflowDefinition(PANEL_DATA.setting.form,
            function (workflowId) {
                PANEL_DATA.setting.form.workflowId = workflowId;
                setMetaData(PANEL_DATA.setting.form);
            });
        closePanel();
    }

    function _panelType(isPublic){
        return isPublic ? "import" : "open";
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
                loadWorkflowDefinitions(panelType, $(this).attr("page-num"));
            });
        
        if (paginationData.curBlock > 1 && paginationData.curBlock <= paginationData.totalBlock) {
            $(JQ_PORTLET_BOUNDARY_ID + " .menu-panel .pagination .prev > a").click(function (e) {
                e.preventDefault();
                loadWorkflowDefinitions(panelType, paginationData.startPage - 1);
            });
        }else{
            $(JQ_PORTLET_BOUNDARY_ID + " .menu-panel .pagination .prev").addClass("disabled");
        }
        if (paginationData.curBlock < paginationData.totalBlock) {
            $(JQ_PORTLET_BOUNDARY_ID + " .menu-panel .pagination .next > a").click(function (e) {
                e.preventDefault();
                loadWorkflowDefinitions(panelType, paginationData.endPage + 1);
            });
        }else{
            $(JQ_PORTLET_BOUNDARY_ID + " .menu-panel .pagination .next").addClass("disabled");
        }
    }

    function tbody(workflows, tbodyTemplate, panelType) {
        if (workflows && workflows.length > 0) {
            $.each(workflows, function (i) {
                workflows[i].createDate = $.format.date(
                    new Date(workflows[i].createDate), "yyyy.MM.dd HH:mm");
            });
            $(JQ_PORTLET_BOUNDARY_ID + " .menu-panel tbody.panel-tbody").empty().append(
                Mustache.render(tbodyTemplate, { "rows": workflows }))
                    .children("tr").each(function(i){
                        var workflowId = $(this).attr("workflow-id");
                        if(workflowId === PANEL_DATA[panelType].form.selected){
                            activate(this);
                        }
                        $(this).click(function(e){
                            PANEL_DATA[panelType].form.selected = workflowId;
                            activate(this);
                        });
                    });
        }else{
            $(JQ_PORTLET_BOUNDARY_ID + " .menu-panel tbody.panel-tbody").empty().append(
                Mustache.render(tbodyTemplate, { "rows": workflows }));
        }
    }

    function activate(that){
        $(that).siblings().removeClass("active");
        $(that).addClass("active");
    }
});
