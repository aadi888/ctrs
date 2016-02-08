<%@page import="dsynhub.ctrs.bean.MovieBean"%>
<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.dao.ExtraDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Free CSS template by ChocoTemplates.com</title>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<!--[if IE 6]>
		<link rel="stylesheet" href="css/ie6.css" type="text/css" media="all" />
	<![endif]-->
	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="js/jquery-func.js"></script>
</head>
<body>
<!-- Shell -->
<div id="shell">
	<!-- Header -->
	<div id="header">
		<h1 id="logo"><a href="#">Movie Hunter</a></h1>
		<div class="social">
			<span>FOLLOW US ON:</span>
			<ul>
			    <li><a class="twitter" href="#">twitter</a></li>
			    <li><a class="facebook" href="#">facebook</a></li>
			    <li><a class="vimeo" href="#">vimeo</a></li>
			    <li><a class="rss" href="#">rss</a></li>
			</ul>
		</div>
		
		<!-- Navigation -->
		<div id="navigation">
			<ul>
			    <li><a href="main.jsp">HOME</a></li>
			    <li><a class="active" href="movies.jsp">MOVIES</a></li>
			    <li><a href="event.jsp">EVENTS</a></li>
			    <li><a href="theatres.jsp">THEATERS</a></li>
			    <li><a href="offers.jsp">OFFERS</a></li>
			    <li><a href="LogoutController">LOGOUT</a></li>
			</ul>
		</div>
		<!-- end Navigation -->
		
		<!-- Sub-menu -->
		<div id="sub-navigation">
			<div>
			<%String cityid=(String)session.getAttribute("cityid"); %>
			<%ExtraDAO dao6=new ExtraDAO(); %>
			<%String cityname=dao6.selectCityname(cityid);%>
		      <a href="main1.jsp">Change City :</a><font color="silver" size="h1"><strong><%="--->"%><%=cityname%></strong></font>
			</div>
			
		
			<div id="search">
		
				<form action="home_submit" method="get" accept-charset="utf-8">
					<label for="search-field">SEARCH</label>					
					<input type="text" name="search field" value="Enter search here" id="search-field" title="Enter search here" class="blink search-field"  />
					<input type="submit" value="GO!" class="search-button" />
				</form>
			</div>
		</div>
		<!-- end Sub-Menu -->
		
	</div>
	<!-- end Header -->
	<%ExtraDAO dao=new ExtraDAO(); %>
	<%List<MovieBean> list=dao.selectMovies(cityid); %>
	<center>
	<table>
	<%int counter=0; %>
	<%for(int i=0;i<list.size();i++){ %>
	<%if(i%2==0){ %>
	<%MovieBean bean=list.get(i); %>
	<%counter=counter+1; %>
	<tr>
	<td><%=counter%>--->Movie:</td>
	<td><%=bean.getMoviename() %></td>
	</tr>
	<tr>
	<td>Director:</td>
	<td><%=bean.getDirector() %></td>
	</tr>
	<tr>
	<td>Writer:</td>
	<td><%=bean.getWriter() %></td>
	</tr>
	<tr>
	<td>Music Company:</td>
	<td><%=bean.getMusic() %></td>
	</tr>
	<tr>
	<td>Release Date:</td>
	<td><%=bean.getReleasedate() %></td>
	</tr>
	<tr>
	<td>Language:</td>
	<td><%=bean.getLanguagename() %></td>
	</tr>
	<br/>
	<p/>
	<%} %>
	<%} %>
	
    </table>
    </center>
<%@include file="footer.html" %>
</body>
</html>