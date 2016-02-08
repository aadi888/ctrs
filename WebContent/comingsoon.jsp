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
<form action="" name="comingsoon">
<%String id=(String)request.getAttribute("id"); %>
<input type="hidden" value="<%=id%>" name="hid">
<center>
<table border="0">
<tr>
<th><marquee direction="up">Coming Soon<img src="images/slide1.jpg"><img src="images/slide2.jpg"></marquee></th>

<td><div class="movie">
					<div class="movie-image">
						<a href="#"><span class="play"><span class="name">SPIDER-MAN</span></span><img src="images/sc1.jpg" alt="movie" /></a>
					</div>
					</div></td>
					<td/>
<td><div class="movie">
					<div class="movie-image">
						<a href="#"><span class="play"><span class="name">BELLE</span></span><img src="images/sc2.jpg" alt="movie" /></a>
					</div>
					
					
				</div></td>
				<td/>
<td><div class="movie">
					<div class="movie-image">
						<a href="#"><span class="play"><span class="name">PURANI JEANS</span></span><img src="images/sc3.jpg" alt="movie" /></a>
					</div>
					
				</div></td>
</tr>
<tr/>
<tr/>
<tr/>
<tr>
<td/>
<td>Release Date :May 8, 2014</td><td/>
<td>Release Date :May 8, 2014</td><td/>
<td>Release Date :May 16, 2014</td>
</tr>
<tr>
<td/>
<td>Writer :Peterson</td><td/>
<td>Writer :Robert Atkinson</td><td/>
<td>Writer :Tanushri Chattrji Bassu</td>
</tr>
<tr>
<td/>
<td>Director :Jackson Buffalo</td><td/>
<td>Director :Methews Mandis</td><td/>
<td>Director :Tanushri Chattrji Bassu</td>
</tr>
<tr>
<td/>
<td>Genre :Action</td><td/>
<td>Genre :Horror</td><td/>
<td>Genre :Drama, Romance</td>
</tr>
<tr>
<td/>
<td>Language :English</td><td/>
<td>Language :English</td><td/>
<td>Language :Hindi</td>
</tr>

</table>
</center>
</form>
<br>
<br>
<br>
<%@include file="footer.html" %>
</body>
</html>