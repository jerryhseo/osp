<!DOCTYPE html>
<html style="height:100%;">
<head>
    <script src="<%=request.getContextPath()%>/js/jquery/jquery-3.1.0.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery/jquery.mousewheel.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/iviewer-0.7.11/jquery.iviewer.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/jquery/jquery-ui-1.12.1.custom/jquery-ui.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/iviewer-0.7.11/jquery.iviewer.css">
    <style>
	.inner-canvas{position:relative; text-align: center; height:100%;overflow: hidden;}
    </style>
    <script>

		var currentUrl;
		    
		/***********************************************************************
		 * Golbal functions
		 ***********************************************************************/
		$(window).resize( function(e){
		    loadImage( currentUrl, 'fit' );
		});
		 
		function loadImage( urlToLoad, zooming ){
				if( !urlToLoad )    return;
				currentUrl = urlToLoad;

				if($('#canvas').hasClass('iviewer_cursor')){
					$('#canvas').iviewer('loadImage', urlToLoad);
				}
				else{
					var options = {
								src : currentUrl,
								update_on_resize:true
					};
					$('#canvas').iviewer( options );
					// $('#canvas').iviewer('update');
				}

				console.log('Image zooming: '+zooming);
				$('#canvas').iviewer('center');
				if( zooming === 'fit' ){
					console.log('Fit image to container');
					$('#canvas').iviewer( 'fit' );
				}
				else{
					console.log('Zooming image: '+zooming);
					$('#canvas').iviewer( 'set_zoom', zooming );
				}
				$('#canvas').iviewer('update');
		}
		
		function clearImage(){
			$('#canvas').empty();
			$('#canvas').removeClass();
		}
		
	</script>
</head>
<body style="text-align: center; height:100%;">
	<div id="canvas" class="inner-canvas"></div>
</body>
</html>
