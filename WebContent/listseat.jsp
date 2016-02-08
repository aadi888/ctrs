<%@page import="dsynhub.ctrs.bean.SeatBean"%>
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
	 var f=document.listseat;
	 f.hid.value=id;
	 f.action="EditSeatController";
	 f.submit();
}
function del(id)
{
	 var f=document.listseat;
	 f.hid.value=id;
	 f.action="DeleteSeatController";
	 f.submit();
}

</script>
</head>
<body>
<%@include file="adminheader.html" %>
<form action="" method="get" name="listseat">
<input type="hidden" name="hid" value="">
<table border="0">
<tr>
<td>Seat No</td>
<td>Screen No</td>
<td>Show Date</td>
<td>Movie Name</td>
<td>Branch Name</td>
<td>Cinema Name</td>
<td>City Name</td>
<td>State Name</td>
<td>Admin</td>
</tr>
<%List<SeatBean> list=(List)request.getAttribute("list"); %>
<%for(int i=0;i<list.size();i++){ %>
<%SeatBean bean=list.get(i); %>
<tr>
<td><%=bean.getSeatno()%></td>
<td><%=bean.getScreenno()%></td>
<td><%=bean.getShowdate()%></td>
<td><%=bean.getMoviename()%></td>
<td><%=bean.getBranchname()%></td>
<td><%=bean.getCinemaname()%></td>
<td><%=bean.getCityname()%></td>
<td><%=bean.getStatename()%></td>
<td><%=bean.getFirstname()%><%=bean.getLastname()%></td>
<td><a href="#" onclick="edit(<%=bean.getSeatid()%>)">edit</a></td>
<td><a href="#" onclick="del(<%=bean.getSeatid()%>)">delete</a></td>
</tr>
<%} %>
</table>

</form>
<%@include file="adminfooter.html" %>
</body>
</html>