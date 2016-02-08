<%@page import="dsynhub.ctrs.bean.StateBean"%>
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
	var f=document.list;
	f.sid.value=id;
	f.action="EditStateController";
	f.submit();
}
function del(id)
{
	var f=document.list;
	f.sid.value=id;
	f.action="DeleteStateController";
	f.submit();
}

</script>
</head>
<body>
<%@include file="adminheader.html" %>
<%List list=(List)request.getAttribute("list");%>
<form action="" method="get" name="list">
<table border="0">
<input type="hidden" name="sid" value="">
<tr>
<td>statename</td>
<td>adminname</td>
</tr>
<%for(int i=0;i<list.size();i++){ %>
<%StateBean bean=(StateBean)list.get(i);%>
 <tr>
 <td><%=bean.getStatename() %></td>
 <td><%=bean.getFirstname()%><%=" " %><%=bean.getLastname() %></td>
 <td><a href="#" onclick="edit(<%=bean.getStateid()%>)">edit</a>    <a href="#" onclick="del(<%=bean.getStateid()%>)">delete</a></td>
 </tr>
<%} %>

</table>

</form>
<%@include file="adminfooter.html" %>
</body>
</html>