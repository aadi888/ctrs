<%@page import="dsynhub.ctrs.bean.ShowBean"%>
<%@page import="java.util.List"%>
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
	var f=document.listshow;
	f.hid.value=id;
	
	
	f.action="DeleteShowController";
	f.submit();
	}
function edit(id)
{
	var f=document.listshow;
	f.hid.value=id;
	
	f.action="EditShowController";
	f.submit();
	}


</script>
</head>
<body>
<%@include file="adminheader.html" %>
<%List<ShowBean> list=(List)request.getAttribute("list"); %>
<form action="" name="listshow">
<input type="hidden" name="hid" value="">
<table border="0">
<tr>
<td>Movie Name</td>
<td>Branch Name</td>
<td>Show Date Time</td>
<td>admin name</td>
</tr>
<%for(int i=0;i<list.size();i++) { %>
<%ShowBean bean=new ShowBean(); %>
<%bean=list.get(i); %>
<tr>
<td><%=bean.getMoviename()%></td>
<td><%=bean.getBranchname()%></td>
<td><%=bean.getShowdate()%></td>
<td><%=bean.getFirstname()%><%=" "%><%=bean.getLastname()%></td>
<td><a href="#" onclick="edit(<%=bean.getShowid()%>)">edit</a></td>
<td><a href="#" onclick="del(<%=bean.getShowid()%>)">delete</a></td>
</tr>
<%} %>
</table>
</form>
<%@include file="adminfooter.html" %>
</body>
</html>