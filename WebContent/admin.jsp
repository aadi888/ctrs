<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Details</title>
</head>
<body>
<%@include file="adminheader.html" %>

<form action="InsertAdminController" name="adminregistration" method="post">
<center>
<table border="0">
<tr>
<td>Enter Email Id :</td>
<td><input type="text" name="emailid" value="${emailid1}"><font color="red">${emailid}</font></td>
</tr>
<tr>
<td>Enter Password :</td>
<td><input type="password" name="password" value="${password1}"><font color="red">${password}</font></td>
</tr>
<tr>
<td>Enter Firstname :</td>
<td><input type="text" name="firstname" value="${firstname1}"><font color="red">${firstname}</font></td>
</tr>
<tr>
<td>Enter Middlename :</td>
<td><input type="text" name="middlename" value="${middlename1}"><font color="red">${middlename}</font></td>
</tr>
<tr>
<td>Enter Lastname :</td>
<td><input type="text" name="lastname" value="${lastname1}"><font color="red">${lastname}</font></td>
</tr>
<tr>
<td>Enter Address :</td>
<td><textarea rows="5" cols="50" name="address">${address1}</textarea><font color="red">${address}</font>
</tr>
</table>
</center>
<center><input type="submit" value="SUBMIT">
<input type="reset" value="RESET"> </center> 

</form>
<%@include file="adminfooter.html" %>
</body>
</html>