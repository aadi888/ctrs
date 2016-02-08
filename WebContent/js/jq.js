$(document).ready(function(){
	$("#newuser").validationEngine();
	
	$("#dob").datepicker({
		changeMonth:true,
		changeYear:true,
		yearRange:"1980:1995",
		dateFormat:"dd/mm/yy",
		position:"relative",
		height:"10px",
		width:"10px"});
	$("#dobC").datepicker({
		//dateFormat:"yy-mm-dd",
		dateFormat:"dd/mm/yy",
		position:"relative",
		height:"10px",
		width:"10px"});
});