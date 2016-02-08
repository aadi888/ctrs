<%@page import="dsynhub.ctrs.bean.*"%>
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
	var f=document.list;
	f.hid.value=id;
	f.action="DeleteFeedbackController";
	f.submit();
	
}

function edit(id)
{
	var f=document.list;
	f.hid.value=id;
	f.action="EditFeedbackController";
	f.submit();
	
	}


</script>
</head>
<body>
<%@include file="adminheader.html" %>
<%List list=(List)request.getAttribute("list"); %>
<form action="" name="list" method="post">
<table>
<input type="hidden" name="hid">
<tr>
<td>EMAILID</td>
<td>FEEDBACK</td>
</tr>

<%for(int i=0;i<list.size();i++) {%>
<%FeedbackBean bean=(FeedbackBean)list.get(i); %>
<tr>
<td><%=bean.getEmailid() %></td>
<td><%=bean.getMsg() %></td>
<td><a href="#" onclick="edit(<%=bean.getFeedbackid() %>)">edit</a></td>
<td><a href="#" onclick="del(<%=bean.getFeedbackid() %>)">delete</a></td>

</tr>


<%} %>
</table>


</form>

<%@include file="adminfooter.html" %>
</body>
</html>