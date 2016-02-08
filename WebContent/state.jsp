<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.bean.StateBean"%>
<%@page import="dsynhub.ctrs.dao.StateDao"%>
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
<form action="InsertStateController" method="post">
<table border="0">
<%StateDao dao=new StateDao(); %>

<%List<StateBean> list=dao.selectAdmin(); %>
<tr>
<td>Select Admin :</td>
<td><select name="admin">

<%for(int i=0;i<list.size();i++){%>

<%StateBean bean=new StateBean(); %>
<%bean=(StateBean)list.get(i);%>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean.getAdminid().equals(adminid1)){ %> 
<option value="<%=bean.getAdminid()%>" selected="selected"><%=bean.getFirstname()%><%=bean.getMiddlename()%><%=bean.getLastname() %></option>

<%}%>
<%} %>
</select>${admin}</td>
</tr>
<tr>
<td>Enter State:</td>
<td><input type="text" name="statename"><font color="red">${statename}</font></td>
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