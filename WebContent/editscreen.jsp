<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.dao.ScreenDAO"%>
<%@page import="dsynhub.ctrs.bean.ScreenBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%ScreenBean bean=(ScreenBean)request.getAttribute("bean"); %>
<body>
<%@include file="adminheader.html" %>
<form action="UpdateScreenController" method="get">
<input type="hidden" name="hid" value="<%=bean.getScreenid()%>">
<table border="0">
<tr>
<td>Select Admin :</td>
<td><select name="admin">
<%ScreenDAO dao=new ScreenDAO();

 List<ScreenBean> list=dao.selectAdmin();
 ScreenBean bean1=new ScreenBean();
%>
<%for(int i=0;i<list.size();i++) {%>
<%bean1 =(ScreenBean)list.get(i); %>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean1.getAdminid().equals(adminid1)){ %> 
<option value="<%=bean1.getAdminid()%>" selected="selected"><%=bean1.getFirstname()%><%=bean1.getLastname() %></option>
<%} %>
<%} %>
</select>${admin}</td>
</tr>

<tr>
<td>Select Show :</td>
<td><select name="show">

<%
 List<ScreenBean> list1=dao.selectShow();
 ScreenBean bean2=new ScreenBean();
%>
<%for(int i=0;i<list1.size();i++) {%>
<%bean2 =(ScreenBean)list1.get(i); %>
<%if(bean2.getShowid().equals(bean.getShowid())){ %>
<option value="<%=bean2.getShowid()%>" selected="selected"><%=bean2.getShowdate()%><%=","%><%=bean2.getMoviename()%><%=","%><%=bean2.getBranchname() %></option>
<%} else {%>
<option value="<%=bean2.getShowid()%>"><%=bean2.getShowdate()%><%=","%><%=bean2.getMoviename()%><%=","%><%=bean2.getBranchname() %></option>
<%} %>
<%} %>
</select>${admin}</td>
</tr>

<tr>
<td>Enter Screen No: </td>
<td><input type="text" name="screenno" value="<%=bean.getScreenno()%>"></td>
</tr>
<tr>
<td><input type="submit" name="update" value="update"></td>
<td><input type="reset" name="reset" value="reset"></td>
</tr>



</table>

</form>
<%@include file="adminfooter.html" %>
</body>
</html>