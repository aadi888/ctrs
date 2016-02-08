<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.dao.SeatDAO"%>
<%@page import="dsynhub.ctrs.bean.SeatBean"%>
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
<%SeatBean bean=(SeatBean)request.getAttribute("bean"); %>
<form action="UpdateSeatController" method="post">
<input type="hidden" name="hid" value="<%=bean.getSeatid()%>">
<table border="0">
<%SeatDAO dao=new SeatDAO();%>

<%List<SeatBean> list=dao.selectAdmin(); %>
<tr>
<td>Select Admin :</td>
<td><select name="admin">

<%for(int i=0;i<list.size();i++){%>


<%SeatBean bean1=list.get(i);%>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean1.getAdminid().equals(adminid1)){ %> 
<option value="<%=bean1.getAdminid()%>" selected="selected"><%=bean1.getFirstname()%><%=bean1.getMiddlename()%><%=bean1.getLastname() %></option>

<%}%>
<%} %>

</select>${admin}</td>
</tr>
<tr>
<td>Select Screen:</td>
<td><select name="screen">
<%List<SeatBean> list1=dao.selectScreen();%>

<%for(int i=0;i<list1.size();i++){%>


<%SeatBean bean2=list1.get(i);%>
<%if(bean2.getScreenid().equals(bean.getScreenid())){ %>
<option value="<%=bean2.getScreenid()%>" selected="selected"><%=bean2.getScreenno()%><%=","%><%=bean2.getShowdate()%><%=","%><%=bean2.getMoviename()%><%=","%><%=bean2.getBranchname()%><%=","%><%=bean2.getCinemaname()%><%=","%><%=bean2.getCityname()%><%=","%><%=bean2.getStatename()%></option>

<%}else{%>
<option value="<%=bean2.getScreenid()%>"><%=bean2.getScreenno()%><%=","%><%=bean2.getShowdate()%><%=","%><%=bean2.getMoviename()%><%=","%><%=bean2.getBranchname()%><%=","%><%=bean2.getCinemaname()%><%=","%><%=bean2.getCityname()%><%=","%><%=bean2.getStatename()%></option>
<%}%>
<%}%>


</select></td>
</tr>
<tr>
<td>Enter Seat Numer:</td>
<td><input type="text" name="seatno" value="<%=bean.getSeatno()%>"></td>
</tr>

<tr>
<td><input type="submit" name="UPDATE" value="update"></td>
<td><input type="reset" name="reset" value="reset"></td>
</tr>
</table>



</form>

<%@include file="adminfooter.html" %>
</body>
</html>