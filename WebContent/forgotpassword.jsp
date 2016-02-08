<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Shell -->
<div id="shell">
	<!-- Header -->
	<div id="header">
		<h1 id="logo"><a href="#">Movie Hunter</a></h1>
		<div class="social">
			<span>FOLLOW US ON:</span>
			<ul>
			    <li><a class="twitter" href="#">twitter</a></li>
			    <li><a class="facebook" href="#">facebook</a></li>
			    <li><a class="vimeo" href="#">vimeo</a></li>
			    <li><a class="rss" href="#">rss</a></li>
			</ul>
		</div>
		</div>
		</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<form name="forgotpassword" action="ForgotPasswordController">
<table>
<tr>
<td>Enter Your Name :</td>
<td><input type="text" name="name"><font color="red">${name}</font></td>
</tr>
<tr>
<td>Enter Your Email :</td>
<td><input type="text" name="email"><font color="red">${email}</font></td>
</tr>
<tr>
<td>Enter Your Mobile Number :</td>
<td><input type="text" name="mobilenumber"><font color="red">${mobilenumber}</font></td>
</tr>
</table>
<input type="submit" value="Send Me Password">
</form>
<%@include file="adminfooter.html" %>
</body>

</html>