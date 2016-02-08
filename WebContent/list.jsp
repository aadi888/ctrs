<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function seats(){
	
	var f=document.list;
	f.action="seats.jsp";
	f.submit();
}

</script>
</head>

<body bgcolor="#999999">
<%@include file="header.html" %>
<form action="" name="list">
<%String id=request.getParameter("hid"); %>
<input type="hidden" name="hid" value="<%=id%>"> 

<table>
<tr>
<td><h3>HINDI MOVIES:</h3></td>
</tr>
<tr>
<th>NAME</th>
<th>SHOWS</th>
</tr>
<tr>
<td>1-gunday </td>
<td><a href="#" onclick="seats()">8:00 pm,</a><a href="#" onclick="seats()">9:00 pm,</a><a href="#" onclick="seats()">10:00 pm,</a><a href="#" onclick="seats()">1:00 am,</a><a href="#" onclick="seats()">7:00 pm,</a><a href="#" onclick="seats()">4:00 am</a></td>
</tr>
<tr>
<td>2-jai ho </td>
<td><a href="#" onclick="seats()">8:00 pm,</a><a href="#" onclick="seats()">9:00 pm,</a><a href="#" onclick="seats()">10:00 pm,</a><a href="#" onclick="seats()">1:00 am,</a><a href="#" onclick="seats()">7:00 pm,</a><a href="#" onclick="seats()">4:00 am</a></td>
</tr>
<tr>
<td><h3>ENGLISH MOVIES:</h3></td>
</tr>
<tr>
<th>NAME</th>
<th>SHOWS</th>
</tr>
<tr>
<td>1-ninja</td>
<td><a href="#" onclick="seats()">8:00 pm,</a><a href="#" onclick="seats()">9:00 pm,</a><a href="#" onclick="seats()">10:00 pm,</a><a href="#" onclick="seats()">1:00 am,</a><a href="#" onclick="seats()">7:00 pm,</a><a href="#" onclick="seats()">4:00 am</a></td>
</tr>
<tr>
<td>2-spartacus</td>
<td><a href="#" onclick="seats()">8:00 pm,</a><a href="#" onclick="seats()">9:00 pm,</a><a href="#" onclick="seats()">10:00 pm,</a><a href="#" onclick="seats()">1:00 am,</a><a href="#" onclick="seats()">7:00 pm,</a><a href="#" onclick="seats()">4:00 am</a></td>
</tr>
</table>
</form>
<%@include file="footer.html" %>
</body>

</html>