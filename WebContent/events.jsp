<%@page import="dsynhub.ctrs.bean.EventsBean"%>
<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.dao.EventsDAO"%>
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
<form action="InsertEventsController" method="post" name="events">
<table border="0">
<tr>
<td>Select Admin :</td>
<td><select name="admin">
<%EventsDAO dao=new EventsDAO(); 
 List<EventsBean> list=dao.selectAdmin();
 EventsBean bean=new EventsBean();
%>
<%for(int i=0;i<list.size();i++) { %>
<%bean =(EventsBean)list.get(i); %>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean.getAdminid().equals(adminid1)){ %> 

<option value="<%=bean.getAdminid()%>" selected="selected"><%=bean.getFirstname()%><%=bean.getLastname() %></option>
<%} %>
<%} %>
</select>${admin}</td>
</tr>
<tr>
<td>Enter Event Name:</td>
<td><input type="text" name="eventname" value="${eventname1}"><font color="red">${eventname}</font></td>
</tr>
<tr>
<td>Enter Event Info:</td>
<td><textarea cols="40" rows="5" name="eventinfo">${eventinfo1}</textarea><font color="red">${eventinfo}</font>
</tr>
<tr>
<td>Enter Ticket Price:</td>
<td><input type="text" name="eventprice" value="${eventprice1}"><font color="red">${eventprice}</font></td>
</tr>
<tr>
<td><input type="submit" name="submit" value="submit">
<input type="reset" name="reset" value="reset"></td>
</tr>

</table>
 

</form>
<%@include file="adminfooter.html" %>
</body>
</html>