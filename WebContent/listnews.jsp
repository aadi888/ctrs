<%@page import="dsynhub.ctrs.bean.NewsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
 function edit(id)
 {
	 var f=document.news;
	 f.hid.value=id;
	 f.action="EditNewsController";
	 f.submit();
 }
 function del(id)
 {
	 var f=document.news;
	 f.hid.value=id;
	
	 f.action="DeleteNewsController";
	 f.submit();
 }

</script>
</head>
<body>
<%@include file="adminheader.html" %>
<%List list=(List)request.getAttribute("list"); 
NewsBean bean=null;
%>
<form action="" method="get" name="news">
<input type="hidden" name="hid" value="">
<table border="0">
<tr>
<td>NewsTitle</td>
<td>DateCreated</td>
<td>Validity</td>
<td>Admin</td>
</tr>

<%for(int i=0;i<list.size();i++) {%>
<%bean=(NewsBean)list.get(i); %>
<tr>
<td><%=bean.getNewstitle()%></td>
<td><%=bean.getDatecreated()%></td>
<td><%=bean.getValidity()%></td>
<td><%=bean.getFirstname()%><%=" " %><%=bean.getLastname() %></td>
<td><a href="#" onclick="edit(<%=bean.getNewsid()%>)">edit</td>
<td><a href="#" onclick="del(<%=bean.getNewsid()%>)">delete</td>
</tr>
<%}%>

</table>


</form>
<%@include file="adminfooter.html" %>
</body>
</html>