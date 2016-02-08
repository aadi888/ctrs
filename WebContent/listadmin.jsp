<%@page import="java.util.ArrayList"%>
<%@page import="dsynhub.ctrs.bean.AdminBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function del(id)
{
	var f=document.list;
	f.hid.value=id;
	f.action="DeleteAdminController";
	f.submit();
	}
	
function edit(id)
{
	var f=document.list;
	f.hid.value=id;
	f.action="EditAdminController";
	f.submit();
	}



</script>
<title>LIST</title>
</head>
<body>
<%@include file="adminheader.html" %>
<%List<AdminBean> list=(List)request.getAttribute("list"); %>
<%AdminBean bean=new AdminBean(); %>
<form action="" name="list">
<table border="0">
<input type="hidden" name="hid">
<tr>
 <th>EMAILID</th>
 <th>PASSWORD</th>
 <th>FIRSTNAME</th>
 <th>MIDDLENAME</th>
 <th>LASTNAME</th>
 <th>ADDRESS</th>
 </tr>
<%for(int i=0;i<list.size();i++) { %>
 
 <%bean=list.get(i); %>
 <tr>
 <td><%=bean.getEmailid() %></td>
 <td><%=bean.getPassword() %></td>
 <td><%=bean.getFirstname()%></td>
 <td><%=bean.getMiddlename()%></td>
 <td><%=bean.getLastname()%></td>
 <td><%=bean.getAddress()%></td>
 <td><a href="#" onclick="edit(<%=bean.getAdminid()%>)">edit</a></td>
 <td><a href="#" onclick="del(<%=bean.getAdminid()%>)">delete</a></td>
 </tr>

<% }%>
</table>
</form>
<%@include file="adminfooter.html" %>
</body>
</html>