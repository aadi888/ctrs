<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.bean.MovieBean"%>
<%@page import="dsynhub.ctrs.dao.MovieDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="adminheader.html" %>
<form action="InsertMovieController" name="movie" id="movie">
<table border="0">
<tr>
<td>Select Admin :</td>
<td><select name="admin">
<%MovieDAO dao=new MovieDAO();

 List<MovieBean> list=dao.selectAdmin();
 MovieBean bean=new MovieBean();
%>
<%for(int i=0;i<list.size();i++) { %>
<%bean =(MovieBean)list.get(i); %>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean.getAdminid().equals(adminid1)){ %> 

<option value="<%=bean.getAdminid()%>" selected="selected"><%=bean.getFirstname()%><%=bean.getLastname() %></option>
<%} %>
<%} %>
</select>${admin}</td>
</tr>
<tr>
<td>Enter Movie Name:</td>
<td><input type="text" name="moviename" value="${moviename1}"><font color="red">${moviename}</td>
</tr>

<tr>
<td>Enter Director Name:</td>
<td><input type="text" name="director" value="${director1}"><font color="red">${director}</td>
</tr>
<tr>
<td>Enter Writer Name:</td>
<td><input type="text" name="writer" value="${writer1}"><font color="red">${writer}</font></td>
</tr>
<tr>
<td>Enter Music Company:</td>
<td><input type="text" name="music" value="${music1}"><font color="red">${music}</td>
</tr>
<tr>
<td>Enter Release Date(DD/MM/YYYY format):</td>
<td><input type="text" name="releasedate" value="${releasedate1}"><font color="red">${releasedate}</td>
</tr>
<tr>
<td>Enter End Date(DD/MM/YYYY format):</td>
<td><input type="text" name="enddate" value="${enddate1}"><font color="red">${enddate}</td>
</tr>
<tr>
<td><input type="submit" name="add" value="add"></td>
<td><input type="reset" name="reset" value="reset"></td>
</tr>

</table>


</form>
<%@include file="adminfooter.html" %>
</body>
</html>