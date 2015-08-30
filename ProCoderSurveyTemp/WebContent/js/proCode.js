/**
 * 
 */

var locations = [];
var surveyData = '';
var title='';
var json={}; 
$(function() {

	//getEWOlist('ewos');
	//getJSON('techs'); 
	
	/*job-list selection script*/
	$('.list-button li').click(function() {
		$('.list-button li').removeClass('selected');
		$(this).addClass('selected');
	});
	
	$('#list-ewos li').click(function() {
		title=$(this).html();
		$('#exp_title').html(title);
 	});
	
	
	$('.scrollbar').initiscroll();
	
	skiplogin();
	oddeven();	
});

$(document).ready(function(){
	$('.content-secondary > div').css('display','none');
	$('.content-secondary #survey-his-page').css('display','block');
	
	getSurveyDetails();
	
	
});

function loadSurveyDetail(obj){
	$('.content-secondary > div').css('display','none');
	$('.content-secondary #survey-his-detail-page').css('display','block');
	var surveyId = $(obj).find('.issueId').val();
	
	var surveyDetail = $(surveyData).find('survey').find('surveyId').eq(surveyId).parent('survey');//.filter(function(){return $.trim($(this).text()) == surveyId;}).parent('survey');
	
	$('.cust-name1').text($(surveyDetail).find('name').text());
	$('.cust-add1').text($(surveyDetail).find('address').text());
	$('.room1').text($(surveyDetail).find('room').text());
	$('.type1').text($(surveyDetail).find('type').text());
	$('.by1').text($(surveyDetail).find('by').text());
	$('.date1').text($(surveyDetail).find('date').text());
	$('.rem1').text($(surveyDetail).find('remarks').text());
	$('.fileList1').text($(surveyDetail).find('files').text());
}


function openMap(){
	window.open('../jsp/NewFile.html','Location',width=100,height=150);
}

function skiplogin()
{
	$('.startup').hide();
	$('#layout').show()
}
function oddeven() {
	$('.divTable .cell:first-child').addClass('first');
	$('.divTable .cell:last-child').addClass('last');
	$('.oddeven .row:nth-child(odd)').addClass('odd');
	$('.oddeven .row:nth-child(even)').addClass('even');
}

function switchTab(obj) {
	 $('#menu-primary li:eq('+ obj +')').click();
}

function getSurveyDetails(){
	var req = "";
	var viewUrl = "../xml/surveyList.xml";
	$.ajax({
		type : 'POST',
		url : viewUrl,
		//crossDomain: true,
		data: req ,
		dataType:'text',

		beforeSend: function(){
			//loadLoader();	
	    },
	    complete: function(){
		},
		success : function(result){
			surveyData = result;
			if($(result).find('survey').length == 0){
				$('#survey-list').html('<h4>Records not found. Please create a new survey</h4>');
			}
			$(result).find('survey').each(function(i){
				var surveyId = $(this).find('surveyId').text();
				//$('#survey-list').append("<a class='surveyLink' id='"+surveyId+"'>Survey"+" "+i+"</a><br><br><br>")
				surveyTpl = [{
					date:(($(this).find('date').text() == "" || $(this).find('date').text() == null) ? '&nbsp':$(this).find('date').text()),
					name:(($(this).find('name').text() == "" || $(this).find('name').text() == null) ? '&nbsp':$(this).find('name').text()),
					type:(($(this).find('type').text() == "" || $(this).find('type').text() == null) ? '&nbsp':$(this).find('type').text()),
					by:(($(this).find('by').text() == "" || $(this).find('by').text() == null) ? '&nbsp':$(this).find('by').text()),
					issueId:(($(this).find('surveyId').text() == "" || $(this).find('surveyId').text() == null) ? '&nbsp':$(this).find('surveyId').text())
				}];
				$('#SurveyDashboard').tmpl(surveyTpl).appendTo('#survey-list');
			});
		},
		error : function(msg) {
			
			/*openPopup({
				width:'400px',
				height:'auto',
				title:'Alert',
				contentID:'Connection_fail',
				btn1Title:'Cancel',
				btn1Style:'btn-silver',
				btn1callback:'closePopup()',		
				btn2Title:'Try Again',
				btn2Style:'btn-dark-red',
				btn2callback:'closePopup()' 
			});*/
		}
	});
}

function submitSurvey(){
	
	var fileList = $('#fileList').text().split(';');
	fileListReq = "";
	$(fileList).each(function(f){
		fileListReq +="<fileName>"+f+"</fileName>";
	});
	
	var req="<createReq><name>" + $('#cust-name').val()
	+ "</name>" + "<address>" + $('#cust-add').val()
	+ "</address>" + "<room>" + $('#room').val()
	+ "</room><type>" + $('#type').val()
	+ "</type>" + "<by>" + $('#by').val()
	+ "</by>" + "<date>" + $('#date').val()
	+ "</date>" + "<rem>" + $('#rem').val() + "</rem>"
	+ "<attachlist>" + fileListReq + "</attachlist>"
	+ "</createReq>";
		
    //alert(ewosumreq);
	//var viewUrl = "http://vbscqtd5.ebiz.verizon.com:7001/Vbuild-CXM/rest/jobassignment/getJobSummary";
	var viewUrl = "http://113.128.161.204:8080/com.vogella.jersey.first/rest/hello";
	$.ajax({
		type : 'POST',
		url : viewUrl,
		//crossDomain: true,
		data: req ,
		mediaType:'TEXT_XML',

		beforeSend: function(){
			//loadLoader();	
	    },
	    complete: function(){
		},
		success : function(result){},
		error : function(msg) {
			
			/*openPopup({
				width:'400px',
				height:'auto',
				title:'Alert',
				contentID:'Connection_fail',
				btn1Title:'Cancel',
				btn1Style:'btn-silver',
				btn1callback:'closePopup()',		
				btn2Title:'Try Again',
				btn2Style:'btn-dark-red',
				btn2callback:'closePopup()' 
			});*/
		}
	});
}

function getLocation(){
	  var geocoder;

	  if (navigator.geolocation) {
	    navigator.geolocation.getCurrentPosition(successFunction, errorFunction);
	} 
	//Get the latitude and the longitude;
	function successFunction(position) {
	    var lat = position.coords.latitude;
	    var lng = position.coords.longitude;
	    codeLatLng(lat, lng)
	}

	function errorFunction(){
	    alert("Geocoder failed");
	}

	  function initialize() {
	    geocoder = new google.maps.Geocoder();



	  }

	  function codeLatLng(lat, lng) {

	    var latlng = new google.maps.LatLng(lat, lng);
	    geocoder.geocode({'latLng': latlng}, function(results, status) {
	      if (status == google.maps.GeocoderStatus.OK) {
	      console.log(results)
	        if (results[1]) {
	         //formatted address
	         alert(results[0].formatted_address)
	        //find country name
	             for (var i=0; i<results[0].address_components.length; i++) {
	            for (var b=0;b<results[0].address_components[i].types.length;b++) {

	            //there are different types that might hold a city admin_area_lvl_1 usually does in come cases looking for sublocality type will be more appropriate
	                if (results[0].address_components[i].types[b] == "administrative_area_level_1") {
	                    //this is the object you are looking for
	                    city= results[0].address_components[i];
	                    break;
	                }
	            }
	        }
	        //city data
	        $('#address').text(city.short_name + " " + city.long_name);


	        } else {
	          alert("No results found");
	        }
	      } else {
	        alert("Geocoder failed due to: " + status);
	      }
	    });
	  }
}
