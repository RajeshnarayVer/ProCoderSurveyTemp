<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
<meta name="viewport" content="target-densitydpi=device-dpi; width=device-width; initial-scale = 1.0; maximum-scale=1.0; user-scalable=no" />

<title>Site Survey</title>
<link href="../css/proCode.css" rel="stylesheet" type="text/css" />

<!--[if IE]>
<link href="../css/base-ie.css" rel="stylesheet" type="text/css" />
<link href="../css/inputs-ie.css" rel="stylesheet" type="text/css" />
<link href="../css/combo-box-ie.css" rel="stylesheet" type="text/css" />
<link href="../css/proprietary-ie.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="../css/all-ie-css.css"/>
<![endif]-->
<!--[if IE 7]>
<link href="css/table-ie7.css" rel="stylesheet" type="text/css" />
<![endif]-->

<%@include file="surveyListTpl.jsp" %>

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/proCode.js"></script>
<script type="text/javascript" src="../js/iscroll.js"></script>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/jquery.tmpl.js"></script>
<!--
<script type="text/javascript" src="../js/login.js"></script>
<script type="text/javascript" src="../js/files-download.js"></script>
<script type="text/javascript" src="../js/loader.js"></script>
<script type="text/javascript" src="../js/secondary.js"></script>
<script type="text/javascript" src="../js/combo-box.js"></script>
<script type="text/javascript" src="../js/popup.js"></script>
<script type="text/javascript" src="../js/expcol.js"></script>
<script type="text/javascript" src="../js/fullpage.js"></script>
<script type="text/javascript" src="../js/buttons.js"></script>


--><!--[if IE]>
<script type="text/javascript" src="../js/checkbox-ie.js"></script> 
<script type="text/javascript" src="../js/ie.js"></script>

<![endif]-->
<style>
#vexp_col{
  background: none repeat scroll 0 0 black;
  height: 38px;
}

#vexp_col img{
margin-left:10px;
margin-top: 3px;
border-right: 1px solid red;
display:block;
float:left;
}
#vexp_col span.vbuild-bar
{
    color: red;
    float: left;
    font-size: 16px;
    font-weight: bold;
    padding-left: 39px;
    padding-top: 9px;
    text-align: center;
}
#vexp_col span.vbuild-bar span{color:#fff;}
#vexp_col span.empName{
 color: lightBlue;
    float: right;
    font-size: 14px;
    font-weight: bold;
    margin-right: 18px;
    padding-top: 9px;
    }

</style>

</head>

<body>

<!-- ### Start Wrapper ### -->
<div id="layout" class="wrapper"> 
  
  <!-- ### Start Layout ### -->
  <div class="layout"> 
    
    <!-- ### Start Primary Navigation ### -->
 
    <!-- ### End Primary Navigation ### --> 
<div class="header1"><span>Favorites</span><span class="span2">My Task</span><span>Site Survey</span></div>
<!--Start Expand/Collapse-->
 <div id="exp_col">  
    <div id="exp_col_bar">
        <span id="exp_title">Site Survey</span>
    </div>
 </div>
<!--End-->

    <!-- ### Start Primary Content ### -->
    <div class="content-primary">
      <div class="shadow-top"></div>
      <!-- Start Dashboard Panel -->
      <!-- End Dashboard Panel -->
      
      <!-- Start Jobs Panel -->
      <div class="content"> 
        <!-- ### Start Secondary Navigation ### -->
        <div class="two-column" style="width:100%; height: 662px;"> 
            <!-- ### Start Left Side ### -->
            <div class="left">
            <div class="shadow-right"></div>
                <div class="left-panel">
                	<%@ include file="proCoeLeft.jsp" %>
                </div>
            </div>
            <!-- ### End Left Side ### --> 
          
            <!-- ### Start Right Side ### -->
            <div class="right">
            <div class="content-secondary"> 
<!-- ### Start Job List ### -->
                <div class="content" id="survey-his-page">
               	
                <div class="content-area" style="width:100%">
                <div id="scrollScroll111" class="scrollbar"> 
                    <div class="iscroll padT15" id="all_survey">
                    		<div id="survey-list">
                    		</div>
                    </div>
                </div>
                </div>
                 
                </div>
                <!-- ### End Job List ### -->
				<!-- ### Start Job List ### -->
                <div class="content" id="new-survey-page">     	
                
                <div class="content-area" style="width:100%;height: 580px;">
                <div id="scrollScroll1" class="scrollbar"> 
                    <div class="iscroll padT15" id="create_new">
                    <div class="divTable oddeven cellpad15 overlayTrigger">
					<div class="row odd">
						<div align="left" class="cell first">
							Customer Name 
						</div>
						<div class="cell last cust-name bold" align="right">
							<input name="cust-name" id="cust-name"  maxlength="200" type="text"
								class="wid209 cust-name" />
						</div>
						</div>
						<div class="row even">
						<div align="left" class="cell first">
							Site Address 
						</div>
						<div class="cell last cust-add bold" align="right">
							<textarea readonly name="cust-add" id="cust-add"
								class="notes75 cust-add" ></textarea><br><br>
								<a href="javascript:void(0);" onClick="getLocation();" class="btn-context get-loc" style="margin-right: 10px;
border-radius: 10px;">
                      <span class="btn-L"></span><span class="btn-M">Get Location</span><span class="btn-R"></span>
                    </a>
								
						</div>
						</div>
						<div class="row odd">
						<div align="left" class="cell first">
							Room/Building 
						</div>
						<div class="cell last room bold" align="right">
							<input name="room" id="room"  maxlength="200" type="text"
								class="wid209 room" />
						</div>
						</div>
						<div class="row even">
						<div align="left" class="cell first">
							Survey Type 
						</div>
						<div class="cell last type bold" align="right">
							<input name="type" id="type"  maxlength="200" type="text"
								class="wid209 type" />
						</div>
						</div>
						<div class="row odd">
						<div align="left" class="cell first">
							Survey By 
						</div>
						<div class="cell last by bold" align="right">
							<input name="by" id="by"  maxlength="200" type="text"
								class="wid209 by" />
						</div>
						</div>
						<div class="row even">
						<div align="left" class="cell first">
							Survey Date 
						</div>
						<div class="cell last data bold" align="right">
							<input name="date" id="date"  maxlength="200" type="text"
								class="wid209 date" />
						</div>
						</div>
						<div class="row odd">
						<div align="left" class="cell first">
							Remarks 
						</div>
						<div class="cell last rem bold " align="right">
							<textarea name="rem " id="rem"  row="5" column="20"
								class=" rem notes75" ></textarea>
						</div>
						</div>
						</div>
						<div class="divTable oddeven cellpad15 overlayTrigger">
						<div class="row even" style="width:100%">
						<div class="cell">
							<div>
							Please specify a file, or a set of files:<br><br>
							<lable for="file-upload" class="custom-upload">Browse</lable>
							<input type="file" name="files" id="files" accept="image/*" size="3" multiple value="10240">
							<span id="fileList">
							
							</span>
							</div>
						</div>
						</div>
						</div>
					
                        
                        
                    </div>
                </div>
                </div>
                
                <!-- ### Start Context Menu ### -->
                <div class="context-menu">
                <div class="context-menu-wrap" align="right">
                    <a href="javascript:void(0);" onClick="submitSurvey();" class="btn-context submit-survey" style="margin-right: 10px;
border-radius: 10px;">
                      <span class="btn-L"></span><span class="btn-M">Submit</span><span class="btn-R"></span>
                    </a>
                        
                	  
                </div>
                </div>
                <!-- ### End Context Menu ### --> 
                
                </div>
               
               <div class="content" id="survey-map-view">
               	<%@ include file="onMaps.jsp" %>
               </div>
               
               <div class="content" id="survey-his-detail-page">
               	
                <div class="content-area" style="width:100%">
                <div id="scrollScroll111" class="scrollbar"> 
                    <div class="iscroll padT15">	
                    			<div class="divTable oddeven cellpad15 overlayTrigger">
					<div class="row odd">
						<div align="left" class="cell first">
							Customer Name
						</div>
						<div class="cell last cust-name1 bold" align="right">
							
						</div>
						</div>
						<div class="row even">
						<div align="left" class="cell first">
							Site Address 
						</div>
						<div class="cell last cust-add1 bold" align="right">
							
						</div>
						</div>
						<div class="row odd">
						<div align="left" class="cell first">
							Room/Building 
						</div>
						<div class="cell last room1 bold" align="right">
							
						</div>
						</div>
						<div class="row even">
						<div align="left" class="cell first">
							Survey Type 
						</div>
						<div class="cell last type1 bold" align="right">
							
						</div>
						</div>
						<div class="row odd">
						<div align="left" class="cell first">
							Survey By 
						</div>
						<div class="cell last by1 bold" align="right">
							
						</div>
						</div>
						<div class="row even">
						<div align="left" class="cell first">
							Survey Date 
						</div>
						<div class="cell last date1 bold" align="right">
							
						</div>
						</div>
						<div class="row odd">
						<div align="left" class="cell first">
							Remarks 
						</div>
						<div class="cell last rem1 bold " align="right">
							
						</div>
						</div>
						
						<div class="row odd">
						<div align="left" class="cell first">
							Attachments :
						</div>
						<div class="cell last rem1 bold images-att" align="right">
							
						</div>
						</div>
						
						</div>
                    	
                    </div>
                </div>
                </div>
                 
                </div>
               
            </div>
            </div>
            <!-- ### End Right Side ### --> 
        </div>
        <!-- ### End Secondary Navigation ### --> 
      </div>
      <!-- End Jobs Panel -->
      
      
    </div>
    <!-- ### End Primary Content ### --> 
   
  </div>
  <!-- ### End Layout ### --> 
  
</div>
<!-- ### End Wrapper ### -->

<div id="Connection_fail" class="hide">Connection to server failed. Please try again</div>
<div id="alert_nodata" class="hide">No Valid Data , Please check the Values given</div>
<script>

function switchPage(page){
	$('.content-secondary > div').css('display','none');
	$('.content-secondary #'+page).css('display','block');
}

var selDiv = "";

document.addEventListener("DOMContentLoaded", init, false);

function init() {
	document.querySelector('#files').addEventListener('change', handleFileSelect, false);
	selDiv = document.querySelector("#fileList");
}
	
function handleFileSelect(e) {
	
	if(!e.target.files || !window.FileReader) return;

	selDiv.innerHTML = "";
	
	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files);
	var f = '';
	filesArr.forEach(function(i) {
		f = i;
		if(!f.type.match("image.*")) {
			return;
		}
		
		var reader = new FileReader();
		reader.onload = function (e) {
			var html = f.name + ";";
			selDiv.innerHTML += html;				
		};
		reader.readAsDataURL(i); 
		
	});
}

</script>
</body>
<div id="tech-sucess" class="hide">Tech Status is updated Successfully</div>
<div id="job-sucess" class="hide">Job Assigned Successfully</div>
<div id="act-sucess" class="hide">Activities Assigned Successfully</div>
<div id="job-removed" class="hide">Job removed Successfully</div>
<div id="Connection_fail" class="hide">Connection Failed.Please try again</div>
<div id="not_authorised" class="hide">Please create Work profile to assign jobs</div>
<div id="no_techniciandetails" class="hide">Sorry, You dont have any TECHS reporting to you</div>
<div id="alert_oneewo" class="hide">Please select one EWO at a time</div>
<div id="already-assigned" class="hide">Selected EWO already Assigned to the Technician</div>
<div id="already-assigned-act" class="hide">Selected Activity already Assigned to the Technician</div>
<div id="fail-assigned-act" class="hide">Failed to assign one or more activities to the technician</div>
<div id="act-removed" class="hide">Activity removed successfully</div>
<div id="act-removed-fail" class="hide">Failed to Un-Assign one or more activities</div>
<div id="ViewSummary_fail" class="hide">No job summary available</div>
<div id="no-act-assigned" class="hide">No specific activities assigned for selected job. Try unassigning the EWO</div>
<div id="act-not-found" class="hide">Error in fetching the activities. Please try again</div>
<div id="errrMsg-loadtech" class="hide"></div>
<div id="sortlistTechonly" class="hide">
    <ul class="option-list" id="sortlistTechulonly">
      <li>
      	<input type="radio" id="techs0" name="rad" value='A-Z <span class="up-down-arw">&uarr;</span>' checked/>
        <label for="techs0">A-Z <span class='up-down-arw'>&uarr;</span> (Default)</label>
      </li>
     <li>
      	<input type="radio" id="techs1" name="rad" value='Z-A <span class="up-down-arw">&darr;</span>'/>
        <label for="techs1">Z-A <span class='up-down-arw'>&darr;</span></label>
      </li>
    </ul>
</div>
</html>
