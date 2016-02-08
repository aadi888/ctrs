<%@page import="dsynhub.ctrs.bean.CinemaBean"%>
<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.dao.CinemaDAO"%>
<%@page import="dsynhub.ctrs.dao.ExtraDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function main1()
{
	var f=document.main1;
	var retVal = prompt("Enter your City : ","");
	f.city.value=retVal;
	f.action="EnterCityController";
	f.submit();
	
}


</script>
</head>
<body onload="main1()">
<form action="" name="main1">
<input type="hidden" name="city" value="">
</form>
</body>
</html>