<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.bean.BranchBean"%>
<%@page import="dsynhub.ctrs.dao.BranchDAO"%>
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
<form action="InsertBranchController" method="post" name="cinema">
<center>
<table border="0">
<tr>
<td>Select Admin :</td>
<td><select name="admin">
<%BranchDAO dao=new BranchDAO();

 List<BranchBean> list=dao.selectAdmin();
 BranchBean bean=new BranchBean();
%>
<%for(int i=0;i<list.size();i++) { %>
<%bean =(BranchBean)list.get(i); %>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean.getAdminid().equals(adminid1)){ %> 

<option value="<%=bean.getAdminid()%>" selected="selected"><%=bean.getFirstname()%><%=bean.getLastname() %></option>
<%} %>
<%} %>
</select>${admin}</td>
</tr>


<tr>
<%List<BranchBean> list1=dao.selectCinema(); %>
<td>Select Cinema:</td>
<td><select name="cinema">
<%for(int i=0;i<list1.size();i++) { %>
<%BranchBean bean1=new BranchBean(); %>
<%bean1=list1.get(i); %>
<option value="<%=bean1.getCinemaid()%>"><%=bean1.getCinemaname()%></option>
<%} %>
</select>${cinemaid}</td>
</tr>
<tr>
<td>Enter Branch Name:</td>
<td><input type="text" name="branchname" value=""><font color="red">${branchname}</font></td>
</tr>

<tr>
<td>Enter Branch Address:</td>
<td><input type="text" name="branchaddress" value=""><font color="red">${branchaddress}</font></td>
</tr>
<tr>
<td><input type="submit" name="add" value="add"></td>
<td><input type="reset" name="reset" value="reset"></td>
</tr>
</table>
</center>
</form>
<%@include file="adminfooter.html" %>
</body>
</html>