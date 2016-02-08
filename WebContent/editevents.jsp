<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.bean.EventsBean"%>
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
<form action="UpdateEventsController" method="post" name="events">
<table border="0">
<tr>
<%EventsBean bean=(EventsBean)request.getAttribute("bean"); %>
<input type="hidden" name="hid" value="<%=bean.getEventid()%>">
<tr>
<td>Select Admin :</td>
<td><select name="admin">
<%EventsDAO dao=new EventsDAO();

 List<EventsBean> list=dao.selectAdmin();
 EventsBean bean1=new EventsBean();
%>
<%for(int i=0;i<list.size();i++) {%>
<%bean1 =(EventsBean)list.get(i); %>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean1.getAdminid().equals(adminid1)){ %> 
<option value="<%=bean1.getAdminid()%>" selected="selected"><%=bean1.getFirstname()%><%=bean1.getLastname() %></option>
<%}%> 
<%}%>
</select>${admin}</td>
</tr>
<tr>
<td>Enter Event Name:</td>
<td><input type="text" name="eventname" value="<%=bean.getEventname()%>"></td>
</tr>
<tr>
<td>Enter Event Info:</td>
<td><textarea cols="40" rows="5" name="eventinfo" value=""><%=bean.getEventinfo()%></textarea>
</tr>
<tr>
<td>Enter Ticket Price:</td>
<td><input type="text" name="eventprice" value="<%=bean.getEventprice()%>"></td>
</tr>
<tr>
<td><input type="submit" name="UPDATE" value="UPDATE">
<input type="reset" name="reset" value="reset"></td>
</tr>

</table>
 

</form>
<%@include file="adminfooter.html" %>
</body>
</html>