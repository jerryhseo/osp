<!DOCTYPE html>
<html style="height:85%;">
<head>
    <script src="<%=request.getContextPath()%>/js/jsmol/jquery/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jsmol/JSmol.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css"/>
</head>
<body style="height:100%;">

    <div id="canvas"></div>

    <script>

    var currentUrl;
    
/***********************************************************************
 * Golbal functions
 ***********************************************************************/
$(window).resize( function(e){
    loadJSMolFile( currentUrl );
});
 
function loadJSMolFile( urlToLoad ){
        console.log( 'URL To Load: '+ urlToLoad );
        if( !urlToLoad )    return;
        currentUrl = urlToLoad;
        
        var Info = {
                  color: '#000000',
                  height: $('body').height(),
                  width: $('body').width(),
                  //script: "load "+"/jsmol-portlet/temp/ospjm2548440710626419920.tmp",
                  //script: "load "+ fileInfos.tempFilePath.replace(/\\/g, '/'),
                  script: 'load '+ currentUrl,
                  //script: "load " + '/jsmol-portlet/js/jsmol/data/1crn.pdb',
                  use: 'HTML5',
                  j2sPath: '<%=request.getContextPath()%>/js/jsmol/j2s',
                  jarPath: '<%=request.getContextPath()%>/js/jsmol/java',
                  jarFile: 'JmolAppletSigned0.jar',
                  isSigned: true,
                  serverURL: '<%=request.getContextPath()%>/js/jsmol/php/jsmol.php',
                  disableInitialConsole: true
        };

        Jmol.setDocument(0);
        Jmol.getApplet('jmol_1', Info);
        $('#canvas').html( Jmol.getAppletHtml(jmol_1) );
}
    
</script>

</body>
</html>

 