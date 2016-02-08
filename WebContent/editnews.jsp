<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.dao.NewsDAO"%>
<%@page import="dsynhub.ctrs.bean.NewsBean"%>
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
<%NewsBean bean=(NewsBean)request.getAttribute("bean"); %>
<form action="UpdateNewsController" method="post">
<table>
<input type="hidden" name="hid" value="<%=bean.getNewsid()%>">
<tr>
<td>Select Admin :</td>
<td><select name="admin">
<%NewsDAO dao=new NewsDAO();

 List<NewsBean> list=dao.selectAdmin();
 NewsBean bean1=new NewsBean();
%>
<%for(int i=0;i<list.size();i++) {%>
<%bean1 =(NewsBean)list.get(i); %>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean1.getAdminid().equals(adminid1)){ %> 

<option value="<%=bean1.getAdminid()%>" selected="selected"><%=bean1.getFirstname()%><%=bean1.getLastname() %></option>
<%} %>
<%} %>
</select>${admin}</td>
</tr>
<tr>
<td>Enter News Title:</td>
<td><input type="text" name="newstitle" value="<%=bean.getNewstitle()%>"></td>
</tr>

<tr>
<td>Enter Validity:</td>
<td><input type="text" name="validity" value="<%=bean.getValidity()%>"></td>
</tr>

<tr>
<td><input type="submit" name="UPDATE" value="UPDATE"></td>
<td><input type="reset" name="reset" value="reset"></td>
</tr>
</table>


</form>
<%@include file="adminfooter.html" %>
</body>
</html>