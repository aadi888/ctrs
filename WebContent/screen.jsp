<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.bean.ScreenBean"%>
<%@page import="dsynhub.ctrs.dao.ScreenDAO"%>
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
<form action="InsertScreenController" method="get" name="screen">
<table border="0">
<%ScreenDAO dao=new ScreenDAO(); %>

<%List<ScreenBean> list=dao.selectAdmin(); %>
<tr>
<td>Select Admin :</td>
<td><select name="admin">

<%for(int i=0;i<list.size();i++){%>


<%ScreenBean bean=list.get(i);%>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean.getAdminid().equals(adminid1)){ %> 

<option value="<%=bean.getAdminid()%>" selected="selected"><%=bean.getFirstname()%><%=bean.getMiddlename()%><%=bean.getLastname() %></option>
<%} %>
<%}%>

</select>${admin}</td>
</tr>

<%List<ScreenBean> list1=dao.selectShow(); %>
<tr>
<td>Select Show:</td>
<td><select name="show">

<%for(int i=0;i<list1.size();i++){%>


<%ScreenBean bean=list1.get(i);%>
<option value="<%=bean.getShowid()%>"><%=bean.getShowdate()%><%=","%><%=bean.getMoviename()%><%=","%><%=bean.getBranchname() %></option>

<%}%>

</select>${admin}</td>
</tr>


<tr>
<td>Enter Screen No: </td>
<td><input type="text" name="screenno" value=""><font color="red">${screenno}</font></td>
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