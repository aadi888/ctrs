<%@page import="dsynhub.ctrs.bean.CinemaBean"%>
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
	var f=document.listcinema;
	f.hid.value=id;
	f.action="EditCinemaController";
	f.submit();
	
	}

function del(id)
{
	var f=document.listcinema;
	f.hid.value=id;
	f.action="DeleteCinemaController";
	f.submit();
	
	}
</script>

</head>
<body>
<%@include file="adminheader.html" %>
<form action="" name="listcinema">
<input type="hidden" name="hid" value="">
<table>
<tr>
<td>Cinema Name</td>
<td>City</td>
<td>State</td>
<td>Admin</td>
</tr>

<%List<CinemaBean> list=(List)request.getAttribute("list"); %>
<%for(int i=0;i<list.size();i++) { %>
<%CinemaBean bean=list.get(i); %>
<tr>
<td><%=bean.getCinemaname() %></td>
<td><%=bean.getCityname()%></td>
<td><%=bean.getStatename()%></td>
<td><%=bean.getFirstname()%><%=" "%><%=bean.getLastname()%></td>
<td><a href="#" onclick="edit(<%=bean.getCinemaid()%>)">edit</a></td>
<td><a href="#" onclick="del(<%=bean.getCinemaid()%>)">delete</a></td>
</tr>
<%} %>
</table>
</form>
<%@include file="adminfooter.html" %>
</body>
</html>