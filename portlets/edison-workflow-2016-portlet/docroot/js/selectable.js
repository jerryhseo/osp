var Selectable = (function (namespace, $, designer) {
    var currentJsPlumbInstance = designer.getCurrentJsPlumbInstance();
    var containerId = "#" + designer.getCurrentJsPlumbContainerId();
    var isDragging = false;
    var startingPos = [];
    
    $(containerId).mousedown(function (evt) {
        isDragging = false;
        startingPos = [evt.pageX, evt.pageY];
    }).mousemove(function (evt) {
        if (!(evt.pageX === startingPos[0] && evt.pageY === startingPos[1])) {
            isDragging = true;
        }
    }).mouseup(function () {
        if (!isDragging) {
            currentJsPlumbInstance.removeFromPosse($(".wf-box"), "posse");
            $(".wf-box").removeClass("ui-selected");
        }
        isDragging = false;
        startingPos = [];
    });

    $(containerId).selectable({
        filter: ".wf-box",
        selected: function (event, ui) {
            var posses = [];
            $(ui.selected).each(function (_) {
                posses.push(this);
            });
            currentJsPlumbInstance.addToPosse(posses, "posse");
        },
        unselected: function (event, ui) {
            var posses = [];
            $(ui.unselected).each(function (_) {
                posses.push(this);
            });
            currentJsPlumbInstance.removeFromPosse(posses, "posse");
        }
    });

    $(document).keydown(function (event) {
        if (event.which === 46 && $(".ui-selected").length > 0) {
            currentJsPlumbInstance.removeFromPosse($(".wf-box"), "posse");
            designer.removeSicenceApps($(".ui-selected"));
        }
    });
});