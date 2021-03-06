var AppTree = (function(namespace, $, designer){
    return {
        "bindDnd" : bindDnd,
        "drawAppTree" : drawAppTree
    };

    function isDraggableNode(data, event) {
        if (!data[0]) return false;
        if (data[0].type === "group") {
            return false;
        } else if (data[0].type === "app") {
            return true;
        } else {
            return false;
        }
    }

    function controller(){
        var cArr = [];
        cArr.push({
            "text": "Controller",
            "parent": "#",
            "type": "category",
            "id": "controller_category"
        });
        cArr.push({
            "text": "Controller",
            "parent": "controller_category",
            "type": "app",
            "id": "controller",
            "data": {
                "appType": "Controller",
                "name": "Controller",
                "text": "Controller",
                "parent": "controller_category",
                "groupId": getSpecificSiteGroupId(),
                "ibData": {
                },
                "status": {
                	"status": "WAITING"
                },
                "inputports": {
                    "criteria": {
                    	"name_": "criteria",
                        "inputData_": {
                            "type_": "file"
                        },
                        "defaultEditor_": "none",
                        "dataType_": {
                            "name": "controller_input",
                            "version": ""
                        },
                        "mandatory_": true
                    },
                    "transfer": {
                        "inputData_": {
                            "type_": "file"
                        },
                        "name_": "transfer",
                        "defaultEditor_": "none",
                        "dataType_": {
                            "name": "controller_input",
                            "version": ""
                        },
                        "mandatory_": true
                    }
                },
                "outputports": {
                    "Y": {
                        "name_": "Y",
                        "defaultAnalyzer_": "none",
                        "dataType_": {
                            "name": "controller_stdout",
                            "version": ""
                        },
                        "mandatory_": false,
                        "outputData_": {
                            "id_": 0,
                            "parent_": "result",
                            "type_": "file",
                            "name_": "stdout",
                            "relative_": true
                        }
                    },
                    "N": {
                        "name_": "N",
                        "defaultAnalyzer_": "none",
                        "dataType_": {
                            "name": "controller_stdout",
                            "version": ""
                        },
                        "mandatory_": false,
                        "outputData_": {
                            "id_": 0,
                            "parent_": "result",
                            "type_": "file",
                            "name_": "stdout",
                            "relative_": true
                        }
                    }
                }
            }
        });
        return cArr;
    }

    function addController(appTreeSelector){
        var nodes = controller();
        $(appTreeSelector).jstree().create_node("#", nodes[0], "first");
        $(appTreeSelector).jstree().create_node("controller_category", nodes[1], "first");
    }

    function getSpecificSiteGroupId(){
        var fn = window[namespace + "getSpecificSiteGroupId"];
        return fn.apply();
    }

    function dynamicConverter(){
        var dArr = [];
        dArr.push({
            "text": "Converter",
            "parent": "#",
            "type": "category",
            "id": "converter_category"
        });
        dArr.push({
            "text": "Dynamic Converter",
            "parent": "converter_category",
            "type": "app",
            "id": "dynamic_converter",
            "data": {
                "appType": "DynamicConverter",
                "name": "Dynamic Converter",
                "text": "Dynamic Converter",
                "parent": "converter_category",
                "groupId": getSpecificSiteGroupId(),
                "ibData": {
                },
                "status": {
                	"status": "WAITING"
                },
                "inputports": {
                    "localfile0": {
                        "inputData_": {
                            "type_": "file"
                        },
                        "name_": "localfile0",
                        "defaultEditor_": "none",
                        "dataType_": {
                            "name": "converter_input",
                            "version": ""
                        },
                        "mandatory_": true
                    }
                },
                "outputports": {
                    "stdout": {
                        "name_": "stdout",
                        "defaultAnalyzer_": "none",
                        "dataType_": {
                            "name": "converter_stdout",
                            "version": ""
                        },
                        "mandatory_": false,
                        "outputData_": {
                            "id_": 0,
                            "parent_": "result",
                            "type_": "file",
                            "name_": "stdout",
                            "relative_": true
                        }
                    }
                }
            }
        });
        return dArr;
    }

    function addDynamicConverter(appTreeSelector){
        var nodes = dynamicConverter();
        $(appTreeSelector).jstree().create_node("#", nodes[0], "first");
        $(appTreeSelector).jstree().create_node("converter_category", nodes[1], "first");
    }


    function componet(){
        var dArr = [];
        dArr.push({
            "text": "Component",
            "parent": "#",
            "type": "category",
            "id": "componet_category"
        });
        
        dArr.push({
            "text": "Data Component",
            "parent": "componet_category",
            "type": "app",
            "id": "file_component",
            "data": {
                "appType": "FileComponent",
                "name": "Data Component",
                "text": "Data Component",
                "parent": "componet_category",
                "groupId": getSpecificSiteGroupId(),
                "outputports": {
                    "stdout": {
                        "name_": "stdout",
                        "defaultAnalyzer_": "none",
                        "mandatory_": false,
                        "outputData_": {
                            "id_": 0,
                            "parent_": "result",
                            "type_": "file",
                            "relative_": true
                        }
                    }
                }
            }
        });
        /*dArr.push({
            "text": "Group",
            "parent": "componet_category",
            "type": "app",
            "id": "group_component",
            "data": {
            	"appType": "GroupComponent",
                "name": "Group Component",
                "text": "Group Component",
                "parent": "componet_category"
            }
        });*/
        
        return dArr;
    }

    function addComponet(appTreeSelector){
        var nodes = componet();
        $(appTreeSelector).jstree().create_node("#", nodes[0], "first");
        $(appTreeSelector).jstree().create_node("componet_category", nodes[1], "first");
        /* Group */
        /*$(appTreeSelector).jstree().create_node("componet_category", nodes[2], "first");*/
    }



    function drawAppTree(appTreeSelector, searchSelector, initData) {
        $(appTreeSelector).jstree({
            "core": {
                "check_callback": function (operation, node, node_parent, node_position, more) {
                    return operation !== 'move_node';
                },
                "data": initData,
                "themes": {
                    "name": "proton",
                    "responsive": true
                }
            },
            "types": {
                "category": {},
                "subCategory": {},
                "app": {
                    "icon": "icon-file"
                }
            },
            "search": {
                "case_sensitive": false,
                "show_only_matches": true
            },
            "dnd": {
                "is_draggable": isDraggableNode,
                "check_while_dragging": true
            },
            "plugins": ["types", "dnd", "search"]
        }).bind("loaded.jstree", function (event, data) {
            addDynamicConverter(appTreeSelector);
            /*addController(appTreeSelector);*/
            addComponet(appTreeSelector);
            $(searchSelector).keyup(function (e) {
                var searchString = $(this).val();
                $(appTreeSelector).jstree(true).search(searchString);
            });


        }).bind("select_node.jstree", function (event, data) {
            var nodeId = data.node.id;
            var node = data.node;
            if (node.type !== "app") {
                if (!$("#" + nodeId).hasClass("jstree-open")) {
                    $(appTreeSelector).jstree("open_node", node);
                } else {
                    $(appTreeSelector).jstree("close_node", node);
                }
            }
        });
    }

    function bindDnd(documentObject, appTreeSelector){
        $(documentObject).on("dnd_start.vakata", function (event, data) {
            var nodeId = data.data.nodes[0];
            var nodeData = $(appTreeSelector).jstree(true).get_node(nodeId).data;
            $(".menu-panel").hide();
        });

        $(documentObject).on("dnd_stop.vakata", function (event, data) {
            var eventTarget = $(data.event.target);
            if(!eventTarget.closest('.jstree').length) {
                if(eventTarget.closest('.wf-drop').length) {
                    var nodeId = data.data.nodes[0];
                    var node = $(appTreeSelector).jstree(true).get_node(nodeId);
                    designer.addScienceApp(data.event.pageX, data.event.pageY, node.data);
                }
            }
            $(".menu-panel").show();
        });

        $(documentObject).on("dnd_move.vakata", function (event, data) {
            var nodeId = data.data.nodes[0];
            var nodeData = $(appTreeSelector).jstree(true).get_node(nodeId).data;
            var eventTarget = $(data.event.target);
            if (!eventTarget.closest('.jstree').length) {
                if (eventTarget.closest('.wf-drop').length) {
                    data.helper.find('.jstree-icon').removeClass('jstree-er').addClass('jstree-ok');
                }
            }
        });
    }
});
