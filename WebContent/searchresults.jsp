<%@page import="dsynhub.ctrs.bean.MovieBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.html" %>
<%MovieBean bean=(MovieBean)request.getAttribute("bean"); %>
<center>
<table border="0">
<tr>
<th><span><font color="silver" size="h1"><strong>SEARCH RESULTS :  </strong></font></span></th>
</tr>
<tr>
<td><span><font color="silver" size="h1"><strong>MOVIE :  </strong></font></span></td><td><%=bean.getMoviename()%></td>
</tr>
<tr>
<td><span><font color="silver" size="h1"><strong>DIRECTOR :  </strong></font></span></td><td><%=bean.getDirector()%></td>
</tr>
<tr>
<td><span><font color="silver" size="h1"><strong>WRITER :  </strong></font></span></td><td><%=bean.getWriter()%></td>
</tr>
<tr>
<td><span><font color="silver" size="h1"><strong>MUSIC COMPANY :  </strong></font></span></td><td><%=bean.getMusic()%></td>
</tr>
<tr>
<td><span><font color="silver" size="h1"><strong>RELEASE DATE :  </strong></font></span></td><td><%=bean.getReleasedate()%></td>
</tr>
<tr>
<td><span><font color="silver" size="h1"><strong>LANGUAGE :  </strong></font></span></td><td><%=bean.getLanguagename()%></td>

</tr>
</table>
</center>
<%@include file="footer.html" %>
</body>
</html>