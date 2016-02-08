<%@page import="dsynhub.ctrs.bean.AdminBean;"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="adminheader.html" %>
<%AdminBean bean=(AdminBean)request.getAttribute("bean"); %>
<form action="UpdateAdminController" name="edit" method="post">
<center>
<table border="0">
<input type="hidden" name="hid" value="<%=bean.getAdminid()%>">
<tr>
<td>Enter Email Id :</td>
<td><input type="text" name="emailid" value="<%=bean.getEmailid()%>"><font color="red">${emailid}</font></td>
</tr>
<tr>
<td>Enter Password :</td>
<td><input type="password" name="password" value="<%=bean.getPassword()%>"><font color="red">${password}</font></td>
</tr>
<tr>
<td>Enter Firstname :</td>
<td><input type="text" name="firstname" value="<%=bean.getFirstname()%>"><font color="red">${firstname}</font></td>
</tr>
<tr>
<td>Enter Middlename :</td>
<td><input type="text" name="middlename" value="<%=bean.getMiddlename()%>"><font color="red">${middlename}</font></td>
</tr>
<tr>
<td>Enter Lastname :</td>
<td><input type="text" name="lastname" value="<%=bean.getLastname()%>"><font color="red">${lastname}</font></td>
</tr>
<tr>
<td>Enter Address :</td>
<td><textarea rows="5" cols="50" name="address" ><%=bean.getAddress() %></textarea><font color="red">${address}</font>
</tr>
</table>
</center>
<center><input type="submit" value="UPDATE">
<input type="reset" value="RESET"> </center> 

</form>
<%@include file="adminfooter.html" %>
</body>
</html>