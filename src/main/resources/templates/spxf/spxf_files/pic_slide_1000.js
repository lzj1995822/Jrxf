(function(a){a.fn.maiPlayer=function(c){
	var b={
		oPlay:null,speedSwitch:3000,speedAnimate:500,showPage:0,playerWidth:0,autoPlay:true,flipButton:true,pageButton:true,playerBg:true,numPage:false,imageTitle:false,imageContent:false,switchActionAuto:"roll",switchActionPage:"opacity",switchActionFlip:"roll",textDisplay:0,textSpeed:500};
	var c=a.extend(b,c);
	this.each(function(){
	var p=a(this);
	var n="";
	var h=0;
	var i=0;
	var j=null;
	var d=[];a(p).find("li img").parents("ul").addClass("ul-img").css("position","relative");
	h=a(p).find(".ul-img li").length;
	if(c.playerWidth){
		i=1349;
		a(p).css("width",i+"px");
		a(p).find(".ul-img li").css("width",i+"px");a(p).find("img").css("width",i+"px");
		a(p).find(".bg:first").css("width",i+"px")
		}else{
		i=a(p).find(".ul-img li:first").width()}
		if(c.playerHeight){
			iHeight=c.playerHeight;
			a(p).css("height",iHeight+"px");
		a(p).find(".ul-img").css("height",iHeight+"px");
		a(p).find(".ul-img li").css("height",iHeight+"px");
		a(p).find("img").css("height",iHeight+"px")}a(p).find(".ul-img li").each(function(){
			var q=a(p).find(".ul-img li").index(this);
			d[q]=a(p).find(".ul-img img").eq(q).attr("title");
			a(p).find(".ul-img img").eq(q).removeAttr("title")});
			if(c.imageTitle||c.imageContent){
				var k=a('<ul class="ul-text"></ul>');a(k).insertAfter(a(p).find(".ul-img"));
				a(p).find(".ul-img li").each(function(){
					var s=a("<li></li>");
					var q=a(p).find(".ul-img li").index(this);if(c.imageTitle){
						var t=a("<h2></h2>");
					a(t).text(d[q]);a(s).append(t)}if(c.imageContent){
						var r=a("<p></p>");
					var u=a(p).find(".ul-img img").eq(q).attr("alt");
					a(r).text(u);a(s).append(r)}a(k).append(s)});a(p).find(".ul-text").width(i*h);
					a(p).find(".ul-text").height(a(p).find(".bg:first").height())}a(p).find(".ul-img").width(i*h);
					if(c.flipButton){a(p).find(".next:first").click(function(){if(c.switchActionFlip=="roll"){l(a(p).find(".ul-img"),1);
					if(c.imageTitle||c.imageContent){l(a(p).find(".ul-text"),0)}}else{if(c.switchActionFlip=="opacity"){
						if(c.showPage==h-1){c.showPage=0}else{c.showPage++}f(a(p).find(".ul-img"),c.showPage);f(a(p).find(".ul-text"),c.showPage);
						e(a(p).find(".num span").eq(c.showPage),"on")}}});
						a(p).find(".prev:first").click(function(){if(c.switchActionFlip=="roll"){
							l(a(p).find(".ul-img"),-1);
						if(c.imageTitle||c.imageContent){
							l(a(p).find(".ul-text"),0)}
							}else{if(c.switchActionFlip=="opacity"){
							if(c.showPage==0){c.showPage=h-1
							}else{
								c.showPage--}
								f(a(p).find(".ul-img"),c.showPage);
								f(a(p).find(".ul-text"),c.showPage);
								e(a(p).find(".num span").eq(c.showPage),"on")
								}
								}
								})}else{a(p).find(".next:first").css("display","none")
								;a(p).find(".prev:first").css("display","none")}
							if(c.showPage){a(p).find(".ul-img").css("left",-i*c.showPage+"px");
							a(p).find(".ul-text").css("left",-i*c.showPage+"px")}if(c.pageButton){n="";
							a(p).find(".ul-img li").each(function(){n+="<span></span>"});
							a(p).find(".num:first").html(n);
							a(p).find(".num span:first").addClass("on");
							e(a(p).find(".num span").eq(c.showPage),"on");
							a(p).find(".num span").click(function(){
							var q=a(p).find(".num span").index(this);
							if(c.switchActionPage=="roll"){
								c.showPage=0;
							l(a(p).find(".ul-img"),q);
							l(a(p).find(".ul-text"),0)}else{
								if(c.switchActionPage=="opacity"){
									c.showPage=q;
									f(a(p).find(".ul-img"),c.showPage);
								f(a(p).find(".ul-text"),c.showPage);
								e(a(p).find(".num span").eq(c.showPage),"on")}}
								if(c.numPage){
									a(this).text(a(p).find(".num span").index(this)+1)}})}
							if(!c.playerBg){
								a(p).find(".bg:first").css("display","none")}
								function l(r,q){
								if(r.is(":animated")==false){
									c.showPage+=q;
								if(c.showPage!=-1&&c.showPage!=h){r.animate({left:-c.showPage*i+"px"},c.speedAnimate)
								}else{
									if(c.showPage==-1){c.showPage=h-1;r.css({left:-(i*(c.showPage-1))+"px"});
									r.animate({left:-(i*c.showPage)+"px"},c.speedAnimate)
									}else{
										if(c.showPage==c.showPage){
											c.showPage=0;r.css({left:-i+"px"});
											r.animate({left:0+"px"},c.speedAnimate)}}}
											e(a(p).find(".num span").eq(c.showPage),"on")}}
											function f(s,r){var q=(s.css("left")!=-r*i+"px");
											if(q){s.fadeOut(20,function(){s.css("left",-r*i+"px");
											s.fadeIn(500)})}}function m(){
												j=setInterval(function(){if(c.switchActionAuto=="roll"){l(a(p).find(".ul-img"),1)
												}else{
													if(c.switchActionAuto=="opacity"){c.showPage++;
													if(c.showPage==h){
														c.showPage=0}f(a(p).find(".ul-img"),c.showPage);
														e(a(p).find(".num span").eq(c.showPage),"on")}}
													if(c.imageTitle||c.imageContent){l(a(p).find(".ul-text"),0)}},c.speedSwitch)}
													function o(){
														if(j){clearInterval(j)}}a(p).hover(function(){o();
														if(c.textDisplay==1){a(p).find(".bg:first").slideUp(c.textSpeed);
														a(p).find(".ul-text:first").slideUp(c.textSpeed)}else{
															if(c.textDisplay==2){a(p).find(".bg:first").slideDown(c.textSpeed);
															a(p).find(".ul-text:first").slideDown(c.textSpeed)}}},function(){if(c.autoPlay){m()}
															if(c.textDisplay==1){a(p).find(".bg:first").slideDown(c.textSpeed);
															a(p).find(".ul-text:first").slideDown(c.textSpeed)
															}else{
																if(c.textDisplay==2){a(p).find(".bg:first").slideUp(c.textSpeed);
																a(p).find(".ul-text:first").slideUp(c.textSpeed)}}});
																if(c.autoPlay){
																	m()
																}
																function g(q,r){}
																function e(r,q){r=a(r)?a(r):r;
																r.addClass(q).siblings().removeClass(q)}
																}
																)
															}
														}
													)
												(jQuery);