<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.dao.BranchDAO"%>
<%@page import="dsynhub.ctrs.bean.BranchBean"%>
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
<form action="UpdateBranchController" method="post">
<table border="0">


<%BranchBean bean=(BranchBean)request.getAttribute("bean"); %>
<input type="hidden" name="hid" value="<%=bean.getBranchid()%>">
<input type="hidden" name="aid" value="<%=bean.getAdminid()%>">
<tr>
<td>Select Admin :</td>
<td><select name="admin">
<%BranchDAO dao=new BranchDAO();

 List<BranchBean> list=dao.selectAdmin();
 BranchBean bean1=new BranchBean();
%>
<%for(int i=0;i<list.size();i++) {%>
<%bean1 =(BranchBean)list.get(i); %>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean1.getAdminid().equals(adminid1)){ %> 

<option value="<%=bean1.getAdminid()%>" selected="selected"><%=bean1.getFirstname()%><%=bean1.getLastname() %></option>
<%} %>
<%} %>
</select>${admin}</td>
</tr>


<%List<BranchBean> list1=new BranchDAO().selectCinema(); %>
<tr>
<td>Select Cinema:</td>
<td><select name="cinema">
<%for(int i=0;i<list1.size();i++) { %>
<%BranchBean bean2=new BranchBean(); %>
<%bean2=list1.get(i); %>
<%if(bean2.getCinemaid().equals(bean.getCinemaid())) { %>
<option value="<%=bean2.getCinemaid()%>" selected="selected"><%=bean2.getCinemaname()%></option>
<%}else{%>
<option value="<%=bean2.getCinemaid()%>"><%=bean2.getCinemaname()%></option>
<%} %>
<%} %>
</select></td>
</tr>
<tr>
<td>Enter Branch Name:</td>
<td><input type="text" name="branchname" value="<%=bean.getBranchname()%>"></td>
</tr>

<tr>
<td>Enter Branch Address:</td>
<td><input type="text" name="branchaddress" value="<%=bean.getBranchaddress()%>"></td>
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