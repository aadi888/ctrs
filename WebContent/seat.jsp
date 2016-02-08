<%@page import="dsynhub.ctrs.bean.SeatBean"%>
<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.dao.SeatDAO"%>
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
<form action="InsertSeatController" method="post">
<table border="0">
<%SeatDAO dao=new SeatDAO(); %>

<%List<SeatBean> list=dao.selectAdmin(); %>
<tr>
<td>Select Admin :</td>
<td><select name="admin">

<%for(int i=0;i<list.size();i++){%>


<%SeatBean bean=list.get(i);%>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean.getAdminid().equals(adminid1)){ %> 

<option value="<%=bean.getAdminid()%>" selected="selected"><%=bean.getFirstname()%><%=bean.getMiddlename()%><%=bean.getLastname() %></option>

<%}%>
<%} %>
</select>${admin}</td>
</tr>
<tr>
<td>Select Screen:</td>
<td><select name="screen">
<%List<SeatBean> list1=dao.selectScreen();%>

<%for(int i=0;i<list1.size();i++){%>


<%SeatBean bean1=list1.get(i);%>
<option value="<%=bean1.getScreenid()%>"><%=bean1.getScreenno()%><%=","%><%=bean1.getShowdate()%><%=","%><%=bean1.getMoviename()%><%=","%><%=bean1.getBranchname()%><%=","%><%=bean1.getCinemaname()%><%=","%><%=bean1.getCityname()%><%=","%><%=bean1.getStatename()%></option>

<%}%>

</select></td>
</tr>
<tr>
<td>Enter Seat Numer:</td>
<td><input type="text" name="seatno" value=""><font color="red">${seatno}</font></td>
</tr>

<tr>
<td><input type="submit" name="add" value="add"></td>
<td><input type="reset" name="reset" value="reset"></td>
</tr>
</table>



</form>
<%@include file="adminfooter.html" %>
</body>
</html>