/*
User Interface Guidelines V2.0 - Created and Published by PDD-vdsi-Design group.
Please Contact - pdd-vdsi-design-all@one.verizon.com for any clarification
*/
 
// Start Initialize Horizontal Navigation 
var menuTertiaryScroll = {},scrollTertiary = {}; 
var scrollOBJ={};
(function( $ ){ 
	var ignoreValue = 0; /* 0 or ... */ 
	var nameObj = {}; 
	
	var methods = { 
	//Calculate arrows x-pos while resize the window.
	menuResize : function( options,nameObj) {  
		if(typeof options == 'object'){  
			var a = $(options).width();   
			var b = $('.'+nameObj.wrapClass).width() - ignoreValue;
			if(b < a){
				$('.'+nameObj.rightArrowClass).show();
			} else {
				$('.'+nameObj.rightArrowClass+',.'+nameObj.leftArrowClass).hide();		
			}
		}
	},
	 
	//Initialize the iScroll to the elements
	initMenuScroll : function(par1,par2,nameObj ) {  
		if(!$.browser.msie){
			methods.menuResize(par1,nameObj); 
			menuTertiaryScroll[par2] = new iScroll(par2,{checkDOMChanges: true,hScrollbar: false,vScrollbar: false,vScroll:false,
			onScrollStart: function() 
			{	  
				menuTertiaryScroll[par2].refresh();  
			},
			onScrollMove: function() 
			{		 
				methods.controlarrows(par1,this.x,nameObj);
			},
			onScrollEnd:function () 
			{	 
				methods.controlarrows(par1,this.x,nameObj);
			}
			});  
		} 
	},
	 
	//Arrow show/hide controls.
	controlarrows : function(mid,obj,nameObj){   
		var scrollValue = obj;
		if (scrollValue < 0) {
			$('.'+nameObj.leftArrowClass).show();
		} else {
			$('.'+nameObj.leftArrowClass).hide();	
		}  
		
		$('.'+nameObj.hscrollClass).each(function(index, element) { 
					var windowWidth = $('.'+nameObj.wrapClass).width() - scrollValue;
					if($('.'+nameObj.hscrollClass+':eq('+index+')').width() > ($('.'+nameObj.wrapClass+':eq('+index+')').width()-scrollValue)){
						$('.'+nameObj.rightArrowClass+':eq('+index+')').show();
					}
					else{
						$('.'+nameObj.rightArrowClass+':eq('+index+')').hide();
					}
                });
	},
	 
	//Common behaviour for Primary,Tertiary and Context-menu Plugins.
	commonbehaviour:function(thatobj,nameObj){
		var that = thatobj; 
		var nameObj = nameObj; 
		
		$(function(){ 
		 
			for(var j=0;j<$(that).length;j++){ 
			  
			  var tmpObj = ($(that).length == 1)?{
				  hscrollLen : $('.'+nameObj.hscrollClass).length,
				  wrapLen    : $('.'+nameObj.wrapClass).length 
			  }:
			  {
				  hscrollLen : j,
				  wrapLen    : j 
				}; 
			
				var rhtAlign = "";	  
			  if(nameObj.wrapName == "context-menu-wrap"){
				  rhtAlign = "right";
			  }
			//Wrap container for current Element - A.	
			$(that[j]).wrap('<div class='+nameObj.hscrollClass+'/>');   
			 
			
			//Wrapper for A.
			$('.'+nameObj.hscrollClass+':eq('+tmpObj.hscrollLen+')').wrap('<div id='+nameObj.wrapName+' class='+nameObj.wrapClass+' align="'+rhtAlign+'"/>');  
			//Set Left Arrow.
			$('.'+nameObj.wrapClass+':eq('+tmpObj.wrapLen+')').before('<span class='+nameObj.leftArrowClass+'></span>');
			
			//Set Right Arrow.
			$('.'+nameObj.wrapClass+':eq('+tmpObj.wrapLen+')').after('<span class='+nameObj.rightArrowClass+'></span>');
			
			//Call the Scroll Initialize Method.
			if(!$.browser.msie){
				//for(var i=0;i<$("."+nameObj.wrapClass).length;i++){  
					$('.'+nameObj.wrapClass+':eq('+tmpObj.wrapLen+')').attr('id',nameObj.wrapName+tmpObj.wrapLen); 
					methods.initMenuScroll(that[tmpObj.wrapLen],$('.'+nameObj.wrapClass+':eq('+tmpObj.wrapLen+')').attr('id'),nameObj);
				//}	
			}
			
			var width = 0;  
			
			//To calculate the menus width 
				if($(that[tmpObj.wrapLen]).parents('.content').css('display') == 'none'){   
					if($.browser.mozilla){ 
						 
						 $(that[tmpObj.wrapLen]).parents('.content').css('display','-moz-box');
					 }
					 else if($.browser.webkit){
						 
						  $(that).parents('.content').css('display','-webkit-box');
					 }
					 else{
						
						  $(that[tmpObj.wrapLen]).parents('.content').css('display','block');
					 }  
						 $(that[tmpObj.wrapLen]).parents('.content').addClass('none-tertiary');
				}
			 
			   $($(that).children()).each(function(){   
				 	width = width+$(this).outerWidth(true);   
				}); 
				
			// Set de-active menus to none after calculate the outerwidth.
			if($(that).parents('.content').hasClass('none-tertiary')){  
				 if($.browser.mozilla || $.browser.webkit){ 
				   $(that).parents('.none-tertiary').css('display','none');
				  }
			} 
			
			 
				 $(that).css('width',width); 
			// $('.'+nameObj.wrapClass).css('width',width);  
			 width=$(that).outerWidth(true);
			 $(that).css('width',width); 
			// $('.'+nameObj.wrapClass).css('width',width);  
			//To set left and right arrow position Initially.
			methods.menuResize(that[tmpObj.wrapLen],nameObj);  
			}
		});
		  
		if(nameObj.wrapName != "context-menu-wrap"){ 
			if($(that).parents('.tertiary').attr('class') == 'tertiary' ){
				$(that).parents('.tertiary').next().find('.content:eq(0)').addClass('show'); 
			} else { 
				$('.content-primary > .content:eq(0)').addClass('show')
			}
		}
		
		$(window).resize(function(){   
				$('.'+nameObj.hscrollClass).each(function(index, element) { 
					if($('.'+nameObj.hscrollClass+':eq('+index+')').width() > $('.'+nameObj.wrapClass+':eq('+index+')').width()){
						$('.'+nameObj.rightArrowClass+':eq('+index+')').show();
					}
					else{
						$('.'+nameObj.rightArrowClass+':eq('+index+')').hide();
					}
                });
		});	 
		if(nameObj.wrapName != "context-menu-wrap"){ 
		$($(that).children()).click(function() {   
			$(this).siblings().removeClass('selected');
			$(this).addClass('selected'); 
			if(nameObj.wrapName != "context-menu-wrap"){ 
				if($(that).parents('.tertiary').attr('class') == 'tertiary' ){
				$(this).parents('.tertiary').next().find('.content').removeClass('show');
				$(this).parents('.tertiary').next().find('.content:eq('+$(this).index()+')').addClass('show');
			} else {
				$('.content-primary > .content').removeClass('show')
				$('.content-primary > .content').hide();
				$('.content-primary > .content:eq('+$(this).index()+')').show();
				$('.content-primary > .content:eq('+$(this).index()+')').addClass('show');
				if($(this).find('.label').html() == "Timesheet"){
					try{
						initCal();
					}
					catch(e){
					}
				}		
			}
			}
		});	 }
		
		$('.menu-secondary li').click(function(){ 
			if(nameObj.wrapClass == 'menu-context-scroll-wrap') 
				$('.'+nameObj.hscrollClass).each(function(index, element) { 
					if($('.'+nameObj.hscrollClass+':eq('+index+')').width() > $('.'+nameObj.wrapClass+':eq('+index+')').width()){
						$('.'+nameObj.rightArrowClass+':eq('+index+')').show();
					}
					else{
						$('.'+nameObj.rightArrowClass+':eq('+index+')').hide();
					}
                });
		})
	
	}
	 
  };

  //primary menu 
   $.fn.primary = function(nameObj) {   
	    var that = this;   
		var nameObj =nameObj; 
		methods.commonbehaviour(that,nameObj); 
  };
  
  //Tertiary
  $.fn.tertiary = function(nameObj) { 
  
	    var that = this;  
		var nameObj = nameObj; 
		methods.commonbehaviour(that,nameObj); 
  };
  
  //context menu 
   $.fn.contextmenu = function(nameObj) {  

	    var that = this;   
			var nameObj = nameObj; 
		methods.commonbehaviour(that,nameObj); 
  };
  //Initialize iScroll 
   $.fn.initiscroll = function(par) {   
     if(!$.browser.msie){
   $(this).each(function(index, element) {
    if(par == "refresh"){
      scrollOBJ[$(element).attr('id')].refresh();
    }
    else{
   if($(element).attr('id')!='scrollScroll3'){
               scrollOBJ[$(element).attr('id')]= new iScroll($(element).attr('id'), { checkDOMChanges: true,hScroll:false});
   }else{
    scrollOBJ[$(element).attr('id')]= new iScroll($(element).attr('id'), { checkDOMChanges: true,hScroll:true,hScrollbar:true});
   }
   }
   }); 
  }
  };
})( jQuery );
// End Initialize Horizontal Navigation 
