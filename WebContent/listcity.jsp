<%@page import="dsynhub.ctrs.bean.CityBean"%>
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
	var f=document.city;
	f.hid.value=id;
	f.action="EditCityController";
	f.submit();
	}
function del(id)
{
	var f=document.city;
	f.hid.value=id;
	f.action="DeleteCityController";
	f.submit();
	}


</script>
</head>
<body>
<%@include file="adminheader.html" %>
<%List<CityBean> list=(List)request.getAttribute("list"); %>
<form action="" method="post" name="city">
<table border="0">
<input type="hidden" name="hid" value="">
<tr>
<td>City Name</td>
<td>State</td>
<td>Admin</td>
</tr>

<%for(int i=0;i<list.size();i++) { %>
<%CityBean bean=list.get(i); %>
<tr>
<td><%=bean.getCityname() %></td>
<td><%=bean.getStatename() %></td>
<td><%=bean.getFirstname()%><%=" "%><%=bean.getLastname()%></td>
<td><a href="#" onclick="edit(<%=bean.getCityid()%>)">EDIT</a></td>
<td><a href="#" onclick="del(<%=bean.getCityid()%>)">DELETE</a></td>
</tr>
<%} %>
</table>

</form>
<%@include file="adminfooter.html" %>
</body>
</html>