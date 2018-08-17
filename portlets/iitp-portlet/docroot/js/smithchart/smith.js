
var smith = {
  version: "0.1"
  }
smith.chart = function(){  
  // smith chart options
  this.radius = 1
  this.type = 'z'// 'z' or 'y' 
  this.strokeWidth = 2
  // svg options
  var pad = 20; 
  var width = 700 ;
  var height = width;
  var ZERO = 1e-5;
  
  this.b =[0];
  //Circle Data - 숫자가 클수록 원이 작아짐
  this.r =[0.2, 0.5, 1, 2, 5, 10];
  //Curve Data
  this.x = [0.2, 0.5, 1, 2, 4, 10, -0.2, -0.5,-1, -2, -4, -10];

  var xyScale = d3.scale.linear()
            .domain([-this.radius, this.radius])
            .range([pad, width-pad]);

  var xyLScale = d3.scale.linear()
            .domain([this.radius, -this.radius])
            .range([pad, width-pad]);
    
  var rScale = d3.scale.linear()
            .domain([0, this.radius])
            .range([0, (width-2*pad)/2]);
	
smith.chart.prototype.getPointValue = function(mouseX,mouseY){
    this.width = width - pad;
    this.center = 350;

    var realA = mouseX-this.center;
    var realB = Math.pow(this.center-mouseY,2);
    //−(𝑎^2−330×𝑎+𝑏)
    var numerator1 = Math.pow(realA,2)-(this.center-pad)*realA+realB;
    //((𝑎^2−330×𝑎+𝑏)〗^2
    var numerator2 = Math.pow(Math.pow(realA,2)-(this.center-pad)*realA+realB,2);
    //(𝑎^2+〖330〗^2−660×𝑎+𝑏)
    var numerator3 = Math.pow(realA,2)+Math.pow(this.center-pad,2)-660*realA+realB;
    //(𝑎^2+𝑏−〖330〗^2 )
    var numerator4 = Math.pow(realA,2)+realB-Math.pow(this.center-pad,2);
    //𝑎^2+〖330〗^2−660×𝑎+𝑏
    var denominator = Math.pow(realA,2)+Math.pow(this.center-pad,2)-660*realA+realB;
    var realValue = parseFloat((-(numerator1)+Math.sqrt(numerator2-numerator3*numerator4))/denominator);
    var fixedRealValue = realValue.toFixed(2);
    
 

    var imagA = Math.pow(Math.abs(mouseX-this.width),2);
    var imagB = mouseY-this.center;
    var imagValue = -(this.width-pad)*imagB/(imagA+Math.pow(imagB,2));
    var fixedImagValue = imagValue.toFixed(2);
    var reverseImageValue = imagValue<0?parseFloat(Math.abs(imagValue)):parseFloat(-imagValue);

    var leftReal = realValue / (math.pow(realValue, 2) + math.pow(reverseImageValue, 2));
    var leftImag = -1 * reverseImageValue / (math.pow(realValue, 2) + math.pow(reverseImageValue, 2));
    
    
    return {
        real:{
            "value":fixedRealValue,
            "mouse_x_cx":xyScale(realValue/(1+realValue)),
            "mouse_x_r":rScale(1/(1+realValue)),
            "mouse_l_x_cx":xyLScale(leftReal/(1+leftReal)),
            "mouse_l_x_r":rScale(1/(1+leftReal))
        },
        imaginary:{
            "value":fixedImagValue,
            "mouse_y_cy":reverseImageValue==0?xyScale(1/ZERO):xyScale(1/reverseImageValue),
            "mouse_y_r":reverseImageValue==0?rScale(Math.abs(1/ZERO)):rScale(Math.abs(1/reverseImageValue)),
            "mouse_l_y_cy":leftImag==0?xyLScale(1/ZERO):xyLScale(1/leftImag),
            "mouse_l_y_r":leftImag==0?rScale(Math.abs(1/ZERO)):rScale(Math.abs(1/leftImag))
        }
    };
}

  smith.chart.prototype.addMarkerFromMouse = function(svg, real,imag,mouseX,mouseY,id){
	  svg.append('circle')
	      .attr('fill','#2196F3')
	      .attr('cx',mouseX)
	      .attr('cy',mouseY)
	      .attr('real',real)
	      .attr('imaginary',imag)
	      .attr('r',5)
	      .attr('id',id)
	      .attr("stroke-width", 2);
  }
	
  smith.chart.prototype.getPointPosition = function(real,imag){
    this.right = width-pad;
    this.left = pad;
    this.bottom = this.right;
    this.top = this.left;
    this.minDimension = Math.min(this.right - this.left, this.bottom - this.top);

    this.xCenter = 350;
    this.yCenter = 350;
    var realRadius = 1 / (1 + real) * (this.minDimension / 2);
    var realCenterX = this.xCenter + ((real / (1 + real)) * (this.minDimension / 2));
    var realCenterY = this.yCenter;

    var imagRadius = (1 / Math.abs(imag)) * (this.minDimension / 2);
    var imagCenterX = this.xCenter + (this.minDimension / 2);
    var imagCenterY = imag > 0 ? this.yCenter - imagRadius : this.yCenter + imagRadius;
 
    var r0 = Math.sqrt(Math.pow(imagCenterX - realCenterX, 2) + Math.pow(imagCenterY - realCenterY, 2));
    var angle = Math.atan2(realCenterY - imagCenterY, realCenterX - imagCenterX);
	var arccos = Math.acos((Math.pow(imagRadius, 2) - Math.pow(realRadius, 2)) / Math.pow(r0, 2));
    var phi = imag > 0 ? 0.5 * arccos + angle : -0.5 * arccos + angle;
     
    return {
        x: imag === 0 ? realCenterX - realRadius : (Math.cos(phi) * imagRadius) + imagCenterX,
        y: imag === 0 ? this.yCenter : (Math.sin(phi) * imagRadius) + imagCenterY
    };
  }
  
  smith.chart.prototype.getData = function(real,imag,mouseX,mouseY){
	  var current_real = parseFloat(real);
	  var current_imaginary = parseFloat(imag);
	  var current_x = parseFloat(mouseX);
	  var current_y = parseFloat(mouseY);
	  
	  var admin_current_real = current_real / (math.pow(current_real, 2) + math.pow(current_imaginary, 2));
      var admin_current_imaginary = -1 * current_imaginary / (math.pow(current_real, 2) + math.pow(current_imaginary, 2));
      var x = (current_x-350)/330;
      var y = (350-current_y)/330;
      var amplitude = math.sqrt(math.pow(x,2)+math.pow(y,2));
      var theta = math.acos(x/amplitude)*180/math.pi;

      return {
          "Z":'(' + current_real + ') + j  (' + current_imaginary + ') Ω',
          "Y":'(' + admin_current_real + ') + j  (' + admin_current_imaginary + ') S',
          "Q": Math.abs(current_imaginary / current_real),
          "Reflection":amplitude + ' Z ' + theta + '⁰'
      };
  }

  // draw the smith chart on the given svg
  smith.chart.prototype.draw = function(svg){
      
    var flipme = 1 
    if (this.type == 'y'){flipme = -1};
    
    
    Rcx = function(r){
//        var xy = xyScale(r/(1+r)*flipme);
//        var cxy = xyScale.invert(xy)*10;
//        var oVar = cxy/(10-cxy);
        //console.log("data-->"+r+"__Result1->>"+r/(1+r)*flipme+"__Result2->>"+xy+"???"+xyScale.invert(xy)+"__!!!"+oVar);
        return xyScale(r/(1+r)*flipme);
        };
    Lcx = function(r){
        return xyLScale(r/(1+r)*flipme )
        };
    Rcy = function(r){
        return xyScale(0)
        };
    Rr = function(r){
        return rScale(1/(1+r))
        };
    Xcx = function(x){
        return xyScale(1*flipme)
        };
    LXcx = function(x){
        return xyLScale(1*flipme)
        };
    Xcy = function(x){
        if (x==0){x =ZERO};
        return xyScale(1/x)
        };
    Xr = function(x){
        if (x==0){x =ZERO};
        return rScale(Math.abs(1/x))
        };
    Stw = function(r){
        return r===1?"2":"0.5";
    }

    
    svg.attr('width',width)
      .attr('height',height)
      .attr('fill', 'rgba(0,0,0,0)')
      .attr('stroke','black')
      .attr('stroke-width',this.strokeWidth);
        
        
    svg.append('clipPath')
      .attr('id','chart-area')
      .append('circle')
      .attr('cx',Rcx(0))
      .attr('cy',Rcy(0))
      .attr('r',rScale(this.radius)+this.strokeWidth/2);

    var lCircles = svg.selectAll('circle.l')
                        .data(this.r)
                        .enter()
                        .append('circle')
                        .attr('class','rL')
                        .attr('stroke','#2196F3')
                        .attr('cx',Lcx)
                        .attr('cy',Rcy)
                        .attr('r',Rr)
                        .attr("stroke-width", Stw);
    
    var lxCurve = svg.selectAll('circle.z')
                        .data(this.x)
                        .enter()
                        .append('circle')
                        .attr('class','xL')
                        .attr('stroke','#2196F3')
                        .attr('cx',LXcx)
                        .attr('cy',Xcy)
                        .attr('r',Xr)
                        .attr("stroke-width", "0.5");
      
    var rCircles = svg.selectAll('circle.r')
                       .data(this.r)
                       .enter()
                       .append('circle')
                       .attr('class','rR')
                       .attr('stroke','#F44336')
                       .attr('cx',Rcx)
                       .attr('cy',Rcy)
                       .attr('r',Rr)
                       .attr("stroke-width", Stw);              
    
    var rxCurve = svg.selectAll('circle.x')
                       .data(this.x)
                       .enter()
                       .append('circle')							 
                       .attr('class','xR')
                       .attr('stroke','#F44336')
                       .attr('cx',Xcx)
                       .attr('cy',Xcy)
                       .attr('r',Xr)
                       .attr("stroke-width", "0.5");
    
    var line = svg.selectAll('circle.line').data(this.b)
                  .enter()
                  .append('line')
                  .attr("stroke-width", "2")
                  .attr('stroke','black')
                  .attr("x1", LXcx)
                  .attr("y1", Rcy)
                  .attr("x2", Xcx)
                  .attr("y2", Rcy);

    var mCircle1 = svg.selectAll('circle.mouse1')
                  .data([0.7])
                  .enter()
                  .append('circle')
                  .attr('class','mouse_round')
                  .attr('id','mouse_round_r')
                  .attr("stroke-width", "3")
                  .attr('stroke','Orange')
                  .attr('cx',Rcx)
                  .attr('cy',Rcy)
                  .attr('r',Rr);
    var mCircle2 = svg.selectAll('circle.mouse2')
			    .data([0.7])
			    .enter()
			    .append('circle')
			    .attr('class','mouse_round')
			    .attr('id','mouse_round_l')
			    .attr("stroke-width", "3")
			    .attr('stroke','green')
			    .attr('cx',Lcx)
			    .attr('cy',Rcy)
			    .attr('r',Rr);

    var mCurve1 = svg.selectAll('circle.mouse3')
                  .data([-0.7])
                  .enter()
                  .append('circle')
                  .attr('class','mouse_curve')
                  .attr('id','mouse_curve_r')
                  .attr("stroke-width", "3")
                  .attr('stroke','Orange')
                  .attr('cx',Xcx)
                  .attr('cy',Xcy)
                  .attr('r',Xr);
    
    var mCurve1 = svg.selectAll('circle.mouse4')
				    .data([-0.7])
				    .enter()
				    .append('circle')
				    .attr('class','mouse_curve')
				    .attr('id','mouse_curve_l')
				    .attr("stroke-width", "3")
				    .attr('stroke','green')
				    .attr('cx',LXcx)
				    .attr('cy',Xcy)
				    .attr('r',Xr);
    
    var bCircle = svg.selectAll('circle.b')
                  .data(this.b)
                  .enter()
                  .append('circle')
                  .attr('class','big')
                  .attr('id','svg_circle')
                  .attr('stroke','black')
                  .attr('cx',Lcx)
                  .attr('cy',Rcy)
                  .attr('r',Rr)
                  .attr("stroke-width", "4");
  
        svg.selectAll(['.rL','.xL','.rR','.xR','.big','.mouse_round','.mouse_curve']).attr("clip-path", "url(#chart-area)");

    }
}

