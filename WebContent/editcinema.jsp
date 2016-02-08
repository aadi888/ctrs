<%@page import="dsynhub.ctrs.dao.CinemaDAO"%>
<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.bean.CinemaBean"%>
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
<form action="UpdateCinemaController" method="post">
<table border="0">


<%CinemaBean bean=(CinemaBean)request.getAttribute("bean"); %>
<tr>
<td>Select Admin :</td>
<td><select name="admin">
<%CinemaDAO dao=new CinemaDAO();

 List<CinemaBean> list=dao.selectAdmin();
 CinemaBean bean1=new CinemaBean();
%>
<%for(int i=0;i<list.size();i++) {%>
<%bean1 =(CinemaBean)list.get(i); %>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean1.getAdminid().equals(adminid1)){ %> 

<option value="<%=bean1.getAdminid()%>" selected="selected"><%=bean1.getFirstname()%><%=bean1.getLastname() %></option>
<%} %>
<%} %>
</select>${admin}</td>
</tr>




<tr>
<input type="hidden" name="hid" value="<%=bean.getCinemaid()%>">
<%List<CinemaBean> list1=new CinemaDAO().selectCity(); %>
<td>Select City:</td>
<td><select name="city">
<%for(int i=0;i<list1.size();i++) { %>
<%CinemaBean bean2=new CinemaBean(); %>
<%bean2=list1.get(i); %>
<%if(bean2.getCityid().equals(bean.getCityid())) { %>
<option value="<%=bean2.getCityid()%>" selected="selected"><%=bean2.getCityname()%></option>
<%}else { %>
<option value="<%=bean2.getCityid()%>"><%=bean2.getCityname()%></option>
<%} %>
<%} %>
</select></td>
</tr>
<tr>
<td>Enter Cinema Name:</td>
<td><input type="text" name="cinemaname" value="<%=bean.getCinemaname()%>"></td>
</tr>

<tr>
<td><input type="submit" name="update" value="update"></td>
<td><input type="reset" name="reset"></td>
</tr>


</table>


</form>
<%@include file="adminfooter.html" %>
</body>
</html>