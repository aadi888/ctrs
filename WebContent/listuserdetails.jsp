<%@page import="dsynhub.ctrs.bean.UserdetailsBean"%>
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
	 var f=document.userdetails;
	 f.hid.value=id;
	 
	 f.action="DeleteUserdetailsController";
	 f.submit();
 }
 function edit(id)
 {
	 var f=document.userdetails;
	 f.hid.value=id;
	 
	 f.action="EditUserdetailsController";
	 f.submit();
 }

</script>
</head>
<body>
<%@include file="adminheader.html" %>
<%List<UserdetailsBean> list=(List)request.getAttribute("list"); %>
<form action="" name="userdetails" method="post">
<input type="hidden" name="hid" value=""> 
<table border="0">
<tr>
<td>Name</td>
<td>Email</td>
<td>Gender</td>
<td>Mobile Number</td>
<td>City</td>
</tr>
<%for(int i=0;i<list.size();i++) { %>
<%UserdetailsBean bean=list.get(i); %>
<tr>
<td><%=bean.getName() %></td>
<td><%=bean.getEmail() %></td>
<td><%=bean.getGender() %></td>
<td><%=bean.getMobilenumber() %></td>
<td><%=bean.getCityname() %></td>
<td><a href="#" onclick="edit(<%=bean.getUserid()%>)">edit</a></td>
<td><a href="#" onclick="del(<%=bean.getUserid()%>)">delete</a></td>
</tr>


<%} %>
</table>

</form>
<%@include file="adminfooter.html" %>
</body>
</html>