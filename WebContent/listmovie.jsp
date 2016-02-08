<%@page import="dsynhub.ctrs.bean.MovieBean"%>
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
	 var f=document.listmovie;
	 f.hid.value=id;
	 f.action="EditMovieController";
	 f.submit();
}
function del(id)
{
	 var f=document.listmovie;
	 f.hid.value=id;
	
	 f.action="DeleteMovieController";
	 f.submit();
}

</script>
</head>
<body>
<%@include file="adminheader.html" %>
<%List<MovieBean> list=(List)request.getAttribute("list"); %>
<form action="" name="listmovie">
<input type="hidden" name="hid" value=""> 
<table border="0">
<tr>
<td>MOVIE NAME</td>
<td>DIRECTOR</td>
<td>WRITER</td>
<td>MUSIC</td>
<td>RELEASE DATE</td>
<td>END DATE</td>
<td>ADMIN</td>
</tr>
<%for(int i=0;i<list.size();i++) {%>
<%MovieBean bean=list.get(i); %>
<tr>
<td><%=bean.getMoviename()%></td>
<td><%=bean.getDirector()%></td>
<td><%=bean.getWriter()%></td>
<td><%=bean.getMusic()%></td>
<td><%=bean.getReleasedate()%></td>
<td><%=bean.getEnddate()%></td>
<td><%=bean.getFirstname()%><%=" "%><%=bean.getLastname()%></td>
<td><a href="#" onclick="edit(<%=bean.getMovieid()%>)">edit</a></td>
<td><a href="#" onclick="del(<%=bean.getMovieid()%>)">delete</a></td>
</tr>
<%} %>

</table>

</form>
<%@include file="adminfooter.html" %>
</body>
</html>