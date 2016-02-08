<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.bean.BranchBean"%>
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
	var f=document.listbranch;
	f.hid.value=id;
	
	f.action="EditBranchController";
	f.submit();
	
	}

function del(id)
{
	var f=document.listbranch;
	f.hid.value=id;
	
	f.action="DeleteBranchController";
	f.submit();
	
	}
</script>
</head>
<body>
<%@include file="adminheader.html" %>
<form action="" name="listbranch">
<input type="hidden" name="hid" value="">
<table>
<tr>
<td>Branch Name</td>
<td>Branch Address</td>
<td>Cinema Name</td>
<td>Admin</td>
</tr>

<%List<BranchBean> list=(List)request.getAttribute("list"); %>
<%for(int i=0;i<list.size();i++) { %>
<%BranchBean bean=list.get(i); %>
<tr>
<td><%=bean.getBranchname() %></td>
<td><%=bean.getBranchaddress()%></td>
<td><%=bean.getCinemaname()%></td>
<td><%=bean.getFirstname()%><%=" "%><%=bean.getLastname()%></td>
<td><a href="#" onclick="edit(<%=bean.getBranchid()%>)">edit</a></td>
<td><a href="#" onclick="del(<%=bean.getBranchid()%>)">delete</a></td>
</tr>
<%} %>
</table>
</form>
<%@include file="adminfooter.html" %>
</body>
</html>