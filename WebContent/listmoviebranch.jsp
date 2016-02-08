<%@page import="dsynhub.ctrs.bean.MoviebranchBean"%>
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
	var f=document.listmoviebranch;
	f.hid.value=id;
	
	f.action="DeleteMoviebranchController";
	f.submit();
	}
function edit(id)
{
	var f=document.listmoviebranch;
	f.hid.value=id;
	
	f.action="EditMoviebranchController";
	f.submit();
	}



</script>
</head>
<body>
<%@include file="adminheader.html" %>
<form action="" name="listmoviebranch">
<table>
<%List<MoviebranchBean> list=(List)request.getAttribute("list"); %>
<input type="hidden" name="hid" value="">
<tr>
<td>Admin Name</td>
<td>Movie Name</td>
<td>Branch Name</td>
</tr>
<%for(int i=0;i<list.size();i++) { %>
<%MoviebranchBean bean=list.get(i);%>
<tr>
<td><%=bean.getFirstname()%><%=bean.getLastname() %></td>
<td><%=bean.getMoviename()%></td>
<td><%=bean.getBranchname()%></td>
<td><a href="#" onclick="edit(<%=bean.getMoviebranchid()%>)">edit</a></td>
<td><a href="#" onclick="del(<%=bean.getMoviebranchid()%>)">delete</a></td>

</tr>
<%} %>


</table>


</form>
  <%@include file="adminfooter.html" %>        
</body>
</html>