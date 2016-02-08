<%@page import="dsynhub.ctrs.dao.CinemaDAO"%>
<%@page import="dsynhub.ctrs.bean.BranchBean"%>
<%@page import="dsynhub.ctrs.bean.CinemaBean"%>
<%@page import="dsynhub.ctrs.bean.MovielanguageBean"%>
<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.dao.ExtraDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <script type='text/javascript' src='/ctrs/dwr/interface/AjaxDataDAO.js'></script>
  <script type='text/javascript' src='/ctrs/dwr/engine.js'></script>



  <script type='text/javascript' src='/ctrs/dwr/util.js'></script>

<script type="text/javascript">



function date() {
	
	var f=document.main;
	f.action="theatres.jsp";
	f.submit();
	
}
function checkCinema(){
    
	       document.getElementById('movie').style.visibility = 'hidden';
	       document.getElementById('cinema').style.visibility = 'visible';
}	
function checkMovie(){
    
    document.getElementById('cinema').style.visibility = 'hidden';
    document.getElementById('movie').style.visibility = 'visible';
}	
function GoTocinema(){
	var f=document.main;
    f.action="theatres.jsp";
    f.submit();
 }	
function GoToMovies(){
	var f=document.main;
    f.action="movies.jsp";
    f.submit();
 }	


</script>
</head>

<body bgcolor="#999999">

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
			    <li><a class="active" href="main.jsp">HOME</a></li>
			    <li><a href="movies.jsp">MOVIES</a></li>
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
<%String id=(String)request.getAttribute("id"); %>

<form action="" name="main">
<input type="hidden" value="<%=id %>" name="hid">
<input type="hidden" value="" name="city" id="city">
<table>

<p>
<tr>
<td><input type="radio" name="radio" value="movies" checked="checked" onclick="checkMovie()">movies</td>
<td><input type="radio" name="radio" value="cinema" onclick="checkCinema()">cinema</td>
</tr>
<%ExtraDAO dao=new ExtraDAO(); %>
<%List list=dao.selectMovie(cityid); %>
<tr>
<td>

<select name="movie" id="movie" >
<option value="0">---Select Movie---</option>
<%for(int i=0;i<list.size();i++){ %>
<%if(i%2==0){ %>
<%MovielanguageBean bean=(MovielanguageBean)list.get(i); %>
<option value="<%=bean.getMovieid()%>" onclick="GoToMovies()"><%=bean.getMoviename()%><%="("%><%=bean.getLanguagename()%><%=")"%></option>
<%} %>
<%} %>
</select>
</td>
<td></td>
</tr>

<tr>
<td>

<%List list1=dao.selectCinema(cityid); %>
<select name="cinema" id="cinema">
<option value="0">---Select Cinema---</option>
<%for(int i=0;i<list1.size();i++){ %>

<%BranchBean bean=(BranchBean)list1.get(i); %>
<option value="<%=bean.getCinemaid()%>" onclick="GoTocinema()"><%=bean.getCinemaname()%><%="("%><%=bean.getBranchname()%><%=")"%></option>

<%} %>
</select>
</td>
<td></td>
</tr>
<tr>
<td></td>
<td></td>
<th><a href="#">NOW SHOWING   |</a></th>
<th><a href="comingsoon.jsp">COMING SOON</a></th>
</tr>
<tr>
<td></td>
<td></td>
<td><div class="movie">
					<div class="movie-image">
						<a href="trailer.jsp"><span class="play"><span class="name">HIGHWAY</span></span><img src="images/s1.jpg" alt="movie" /></a>
					</div>
					<div class="rating">
						<p>RATING</p>
						<div class="stars">
							<div class="stars-in">
								
							</div>
						</div>
						<span class="comments">12</span>
					</div>
				</div></td>
<td><div class="movie">
					<div class="movie-image">
						<a href="trailer.jsp"><span class="play"><span class="name">2 STATES</span></span><img src="images/s3.jpg" alt="movie" /></a>
					</div>
					<div class="rating">
						<p>RATING</p>
						<div class="stars">
							<div class="stars-in">
								
							</div>
						</div>
						<span class="comments">211</span>
					</div>
				</div></td>
<td><div class="movie">
					<div class="movie-image">
						<a href="trailer.jsp"><span class="play"><span class="name">CAPTAIN AMERICA</span></span><img src="images/s4.jpg" alt="movie" /></a>
					</div>
					<div class="rating">
						<p>RATING</p>
						<div class="stars">
							<div class="stars-in">
								
							</div>
						</div>
						<span class="comments">90</span>
					</div>
				</div></td>
<td><div class="movie">
					<div class="movie-image">
						<a href="trailer.jsp"><span class="play"><span class="name">BHOOTNATH RETURNS</span></span><img src="images/s5.jpg" alt="movie" /></a>
					</div>
					<div class="rating">
						<p>RATING</p>
						<div class="stars">
							<div class="stars-in">
								
							</div>
						</div>
						<span class="comments">121</span>
					</div>
				</div></td>
</tr>
<tr>
<td></td>
<td></td>
<td align="center"><a href="highway.jsp" name="highway" id="highway"><img src="images/image-hover.jpg"></a></td>
<td align="center"><a href="2states.jsp"><img src="images/image-hover.jpg"></a></td>
<td align="center"><a href="captainamerica.jsp"><img src="images/image-hover.jpg"></a></td>
<td align="center"><a href="bhootnathreturns.jsp"><img src="images/image-hover.jpg"></a></td>
</tr>
<tr></tr>
<tr></tr>
</table>
<marquee direction="left"><font color="silver" size="h1"><strong>MOVIE RATINGS : </strong></font>HIGHWAY-->55% , GUNDAY--> 43% ,  BHOOTNATH RETURNS--> 37% ,  CAPTAIN AMERICA--> 89% ,  2 STATES--> 73% ,  </marquee>
</form>

<%@include file="footer.html" %>
</body>
</html>