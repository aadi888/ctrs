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
<form action="UpdateMovieController" method="get">
<table border="0">
<%MovieBean bean=(MovieBean)request.getAttribute("bean"); %>
<input type="hidden" name="hid" value="<%=bean.getMovieid()%>">
<tr>
<td>Select Admin :</td>
<td><select name="admin">
<%MovieDAO dao=new MovieDAO();

 List<MovieBean> list=dao.selectAdmin();
 MovieBean bean1=new MovieBean();
%>
<%for(int i=0;i<list.size();i++) { %>
<%bean1 =(MovieBean)list.get(i); %>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean1.getAdminid().equals(adminid1)){ %> 
<option value="<%=bean1.getAdminid()%>" selected="selected"><%=bean1.getFirstname()%><%=bean1.getLastname() %></option>
<%}%>
<%} %>
</select>${admin}</td>
</tr>
<tr>
<td>Enter Movie Name:</td>
<td><input type="text" name="moviename" value="<%=bean.getMoviename()%>"></td>
</tr>

<tr>
<td>Enter Director Name:</td>
<td><input type="text" name="director" value="<%=bean.getDirector()%>"></td>
</tr>
<tr>
<td>Enter Writer Name:</td>
<td><input type="text" name="writer" value="<%=bean.getWriter()%>"></td>
</tr>
<tr>
<td>Enter Music Company:</td>
<td><input type="text" name="music" value="<%=bean.getMusic()%>"></td>
</tr>
<tr>
<td>Enter Release Date(DD/MM/YYYY format):</td>
<td><input type="text" name="releasedate" value="<%=bean.getReleasedate()%>"></td>
</tr>
<tr>
<td>Enter End Date(DD/MM/YYYY format):</td>
<td><input type="text" name="enddate" value="<%=bean.getEnddate()%>"></td>
</tr>
<tr>
<td><input type="submit" name="UPDATE" value="UPDATE"></td>
<td><input type="reset" name="reset" value="reset"></td>
</tr>
</table>
</form>
<%@include file="adminfooter.html" %>
</body>
</html>