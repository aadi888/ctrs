<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="dsynhub.ctrs.bean.NewsBean"%>
<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.dao.NewsDAO"%>
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
<form action="InsertNewsController" method="post">
<table>
<%DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
Date date = new Date();
 %>
<tr>
<td>Select Admin:</td>
<td><select name="admin">
<%NewsDAO dao=new NewsDAO();
List<NewsBean> list=dao.selectAdmin();

for(int i=0;i<list.size();i++){%>
<%NewsBean bean=new NewsBean(); %>
<%bean=list.get(i); %>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean.getAdminid().equals(adminid1)){ %> 

<option value="<%=bean.getAdminid()%>" selected="selected"><%=bean.getFirstname() %><%=bean.getLastname() %></option>
<%} %>
<%} %>
</select></td>
</tr>
<tr>
<td>Enter News Title:</td>
<td><input type="text" name="newstitle" value="${newstitle1}"><font color="red">${newstitle}</font></td>
</tr>
<tr>
<td>News Created Date:</td>
<td><input type="text" name="datecreated" value="<%=dateFormat.format(date)%>"></td>
</tr>
<tr>
<td>Enter Validity:</td>
<td><input type="text" name="validity" value="${validity1}"><font color="red">${validity}</font></td>
</tr>
<tr>
<td></td>
<td></td>
</tr>
<tr>
<td><input type="submit" value="submit" name="submit"></td>
<td><input type="reset" value="reset" name="reset"></td>

</tr>
</table>
</form>
<%@include file="adminfooter.html" %>
</body>
</html>