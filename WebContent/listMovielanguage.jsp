<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.bean.MovielanguageBean"%>
<%@page import="dsynhub.ctrs.dao.MovielanguageDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function del(id)
{
	var f=document.listmovielanguage;
	f.hid.value=id;
	
	f.action="DeleteMovielanguageController";
	f.submit();
	}
function edit(id)
{
	var f=document.listmovielanguage;
	f.hid.value=id;
	
	f.action="EditMovielanguageController";
	f.submit();
	}



</script>
</head>
<body>
<%@include file="adminheader.html" %>
<form action="" method="get" name="listmovielanguage">
<table>
<input type="hidden" name="hid" value="">
<tr>
<td>Movie</td>
<td>Language</td>
<td>Admin</td>
</tr>
<%List<MovielanguageBean> list=(List)request.getAttribute("list"); %>
<%for(int i=0;i<list.size();i++) {%>
<%MovielanguageBean bean=list.get(i); %>
<tr>
<td><%=bean.getMoviename() %></td>
<td><%=bean.getLanguagename() %></td>
<td><%=bean.getFirstname()%><%="\n"%><%=bean.getLastname()%></td>
<td><a href="#" onclick="edit(<%=bean.getMovielanguageid()%>)">edit</a></td>
<td><a href="#" onclick="del(<%=bean.getMovielanguageid()%>)">delete</a></td>
</tr>

<%} %>


</table>




</form>
<%@include file="adminfooter.html" %>
</body>
</html>