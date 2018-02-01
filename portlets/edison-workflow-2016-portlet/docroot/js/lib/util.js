var consoleLog = {
  loggingLevel: { info: true, debug: false, error: true },
  setLoggingLevel : function(loggingLevelJson){
    this.loggingLevel = loggingLevelJson;
  },
  info : function (msg) {
    if(console && this.loggingLevel.info){
      console.log(msg);
    }
  },
  debug : function (msg) {
    if(console && this.loggingLevel.debug){
      console.log(msg);
    }
  },
  error : function (msg) {
    if(console && this.loggingLevel.error){
      console.log(msg);
    }
  }
};

var aSyncAjaxHelper = {
  "get": function (requestUrl, callback, errorCallback) {
    var resultData;
    $.ajax({
      url: requestUrl,
      async: true,
      method: 'GET',
      timeout: 10000,
    }).done(function (result) {
      resultData = result;
      if(callback){ callback(result) };
      consoleLog.debug(requestUrl + " success");
    }).error(function () {
      consoleLog.debug(requestUrl + " error");
      if(errorCallback){ errorCallback(); }
    }).always(function () {
      consoleLog.debug(requestUrl + " complete");
    });
  },
  "post": function (requestUrl, jsonData, callback, errorCallback) {
    var resultData;
    $.ajax({
      url: requestUrl,
      async: true,
      data : jsonData,
      method: 'POST',
      timeout: 10000,
    }).done(function (result) {
      resultData = result;
      if(callback){ callback(result); }
      consoleLog.debug(requestUrl + " success");
    }).error(function (msg) {
      consoleLog.info(requestUrl + " error ");
      consoleLog.info(msg);
      if(errorCallback){ errorCallback(msg.responseText); }
    }).always(function (msg) {
      consoleLog.debug(requestUrl + " complete");
      consoleLog.debug(msg);
    });
  },
  "jsonPost": function (requestUrl, jsonData, callback, errorCallback) {
    var resultData;
    $.ajax({
      url: requestUrl,
      async: true,
      contentType: "application/json; charset=utf-8",
      data : jsonData,
      method: "POST",
      dataType: "json",
      timeout: 10000,
    }).done(function (result) {
      resultData = result;
      if(callback){ callback(result); }
      consoleLog.debug(requestUrl + " success");
    }).error(function (msg) {
      consoleLog.info(requestUrl + " error ");
      consoleLog.info(msg);
      if(errorCallback){ errorCallback(msg.responseText); }
    }).always(function (msg) {
      consoleLog.debug(requestUrl + " complete");
      consoleLog.debug(msg);
    });
  }
};

var synchronousAjaxHelper = {
  "get": function (requestUrl, callback, errorCallback) {
    var resultData;
    $.ajax({
      url: requestUrl,
      async: false,
      method: 'GET',
      timeout: 10000,
    }).done(function (result) {
      resultData = result;
      if(callback){ callback(result); }
      consoleLog.debug(requestUrl + " success");
    }).error(function (msg) {
      consoleLog.debug(requestUrl + " error");
      if(errorCallback){ errorCallback(msg.responseText); }
    }).always(function () {
      consoleLog.debug(requestUrl + " complete");
    });
    return resultData;
  },
  "post": function (requestUrl, jsonData, callback, errorCallback) {
    var resultData;
    $.ajax({
      url: requestUrl,
      async: false,
      data : jsonData,
      method: 'POST',
      timeout: 10000,
    }).done(function (result) {
      resultData = result;
      if(callback){ callback(result); }
      consoleLog.debug(requestUrl + " success");
    }).error(function (msg) {
      consoleLog.info(requestUrl + " error ");
      consoleLog.info(msg);
      if(errorCallback){ errorCallback(msg.responseText); }
    }).always(function (msg) {
      consoleLog.debug(requestUrl + " complete");
      consoleLog.debug(msg);
    });
    return resultData;
  },
  "jsonPost": function (requestUrl, jsonData, callback, errorCallback) {
    var resultData;
    $.ajax({
      url: requestUrl,
      async: false,
      contentType: "application/json; charset=utf-8",
      data : jsonData,
      method: "POST",
      dataType: "json",
      timeout: 10000,
    }).done(function (result) {
      resultData = result;
      if(callback){ callback(result); }
      consoleLog.debug(requestUrl + " success");
    }).error(function (msg) {
      consoleLog.info(requestUrl + " error ");
      consoleLog.info(msg);
      if(errorCallback){ errorCallback(msg.responseText); }
    }).always(function (msg) {
      consoleLog.debug(requestUrl + " complete");
      consoleLog.debug(msg);
    });
    return resultData;
  }

};

var getGUID = function () {
  function s4() {
    return Math.floor((1 + Math.random()) * 0x10000)
      .toString(16)
      .substring(1);
  }
  return s4() + s4() + '-' + s4() + '-' + s4() + '-' +
    s4() + '-' + s4() + s4() + s4();
};
