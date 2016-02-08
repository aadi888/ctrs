<%@page import="dsynhub.ctrs.bean.EventsBean"%>
<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.dao.EventsDAO"%>
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
	var f=document.events;
	f.hid.value=id;
	f.action="DeleteEventsController";
	f.submit();
	}
function edit(id)
{
	var f=document.events;
	f.hid.value=id;
	f.action="EditEventsController";
	f.submit();
	}



</script>
</head>
<body>
<%@include file="adminheader.html" %>
<%List list=(List)request.getAttribute("list"); %>
<form action="" method="post" name="events">
<input type="hidden" name="hid" value=""> 
<table border="0">
<tr>
<td>Event Name</td>
<td>Event Info</td>
<td>Event Price</td>
<td>Admin</td>
</tr>

<%for(int i=0;i<list.size();i++) { %>
<%EventsBean bean=new EventsBean(); %>
<%bean=(EventsBean)list.get(i); %>
<tr>
<td><%=bean.getEventname() %></td>
<td><%=bean.getEventinfo() %></td>
<td><%=bean.getEventprice() %></td>
<td><%=bean.getFirstname() %><%=" " %><%=bean.getLastname() %></td>
<td><a href="#" onclick="edit(<%=bean.getEventid()%>)">edit</a></td>
<td><a href="#" onclick="del(<%=bean.getEventid()%>)">delete</a></td>
</tr>

<%} %>

</table>


</form>
<%@include file="adminfooter.html" %>
</body>
</html>