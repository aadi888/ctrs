<%@page import="dsynhub.ctrs.bean.ScreenBean"%>
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
	var f=document.listscreen;
	f.hid.value=id;
	
	
	f.action="DeleteScreenController";
	f.submit();
	}
function edit(id)
{
	var f=document.listscreen;
	f.hid.value=id;
	
	f.action="EditScreenController";
	f.submit();
	}


</script>
</head>
<%List<ScreenBean> list=(List)request.getAttribute("list"); %>
<body>
<%@include file="adminheader.html" %>
<form action="" name="listscreen" method="get">
<input type="hidden" name="hid" value="">
<table border="0">
 
<tr>
<td>SCREENNO</td>
<td>SHOWDATE</td>
<td>MOVIENAME</td>
<td>BRANCHNAME</td>
<td>ADMIN</td>
<td></td>

</tr>
<%for(int i=0;i<list.size();i++) {%>
<%ScreenBean bean=list.get(i); %>
<tr>
<td><%=bean.getScreenno()%></td>
<td><%=bean.getShowdate()%></td>
<td><%=bean.getMoviename()%></td>
<td><%=bean.getBranchname()%></td>
<td><%=bean.getFirstname()%><%=bean.getLastname()%></td>
<td><a href="#" onclick="edit(<%=bean.getScreenid()%>)">edit</a></td>
<td><a href="#" onclick="del(<%=bean.getScreenid()%>)">delete</a></td>
</tr>
<%} %>

</table>




</form>
<%@include file="adminfooter.html" %>
</body>
</html>