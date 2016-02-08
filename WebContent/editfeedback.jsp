<%@page import="dsynhub.ctrs.bean.*"%>
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
<form action="UpdateFeedbackController" name="edit" method="post">
<%FeedbackBean bean=(FeedbackBean)request.getAttribute("bean"); %>
<center>
<table border="0">
<input type="hidden" name="hid" value="<%=bean.getFeedbackid() %>">
<tr>
<td>Enter Your EmailID :</td>
<td><input type="text" name="emailid" value="<%=bean.getEmailid()%>"></td>
</tr>
<tr>
<td>Enter Your FEEDBACK :</td>
<td><textarea rows="5" cols="40" name="msg"><%=bean.getMsg()%></textarea>
</tr>
</table>
</center>
<center><input type="submit" value="update">
<input type="reset" value="reset">
</center>
</form>
<%@include file="adminfooter.html" %>
</body>
</html>