<script type="text/x-jquery-tmpl" id="SurveyDashboard">

<div class="list-cmd each-timeentry" onclick="loadSurveyDetail(this)">
<div class="arw">
    <div class="divTable">
        <div class="row">
        <div class="cell wid80">Date Created<br /><span class="normal noPadding">{{html date}}</span></div>
		<div class="cell wid120">Customer Name<br /><span class="normal noPadding">{{html name}}</span></div>
        <div class="cell wid90">Type<br /><span class="normal noPadding">{{html type}}</span></div> 
        <div class="cell wid110">Created By<br /><span class="normal noPadding">{{html by}}</span></div> 
		<input type='hidden' class='issueId' value={{html issueId}}>
        </div>
    </div>
</div>
</div>

</script>
