<%@page import="dsynhub.ctrs.bean.BranchBean"%>
<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.bean.UserdetailsBean"%>
<%@page import="dsynhub.ctrs.dao.UserdetailsDAO"%>
<%@page import="dsynhub.ctrs.bean.MovieBean"%>
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
function getReply(moviebranchid){
    
	dwr.util.removeAllOptions("shows");
	//alert("@");
	document.getElementById('cityLoader').style.visibility = 'visible';
	//alert("@");
	if(moviebranchid==''){
		//alert("@");
		var data=[{ showdate:'-- Select --', showid:'' }];
		dwr.util.addOptions("shows",data,"showid","showdate");
	}else{
		//alert("@");
	   document.getElementById('cityLoader').style.visibility = 'visible';
		AjaxDataDAO.getAllShows(moviebranchid,function(data){
			//alert("@");
			dwr.util.addOptions("shows",data,"showid","showdate");
		   document.getElementById('cityLoader').style.visibility = 'hidden';
		//alert("@");
		});
	}
}	



</script>
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
	<!-- end Header -->
			 
<%String moviename="bhootnath returns"; %>

<%ExtraDAO dao=new ExtraDAO(); %>
<%MovieBean bean=dao.selectMovieData(moviename);%>


<form action="seats.jsp">
<table>
<tr>
<td rowspan="7"><img src="images/s5.jpg" height="250" width="200"><br><span><font color="silver" size="h2"><strong>MOVIE:  </strong></font></span><span><%=bean.getMoviename()%></span><br/><span><font color="silver" size="h2"><strong>DIRECTOR:  </strong></font></span><span><%=bean.getDirector()%></span><br/><span><font color="silver" size="h2"><strong>WRITER:  </strong></font></span><span><%=bean.getWriter()%></span><br/>
<span><font color="silver" size="h2"><strong>MUSIC:  </strong></font></span><span><%=bean.getMusic()%></span><br/><span><font color="silver" size="h2"><strong>RELEASE DATE:  </strong></font></span><span><%=bean.getReleasedate()%></span><br/><span><font color="silver" size="h2"><strong>LANGUAGE:  </strong></font></span><span><%=bean.getLanguagename()%></span><br/></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td rowspan="7">
<%String movieid=bean.getMovieid(); %>
<%ExtraDAO dao7=new ExtraDAO(); %>
<%List list7=dao7.selectCinema(movieid,cityid); %>

<span><font color="silver" size="h2"><strong>Select Cinema and Branch :  </strong></font></span><select name="cinema" id="cinema" onchange="java:getReply(this.value)">
<option value="">---Select Cinema And Branch---</option>
<%for(int i=0;i<list7.size();i++){ %>
<%BranchBean bean7=(BranchBean)list7.get(i); %>
<option value="<%=bean7.getMoviebranchid()%>"><%=bean7.getCinemaname()%><%="("%><%=bean7.getBranchname()%><%=")"%></option>
<%} %>
</select><br/>
<br/>
<br/>

   <strong>Select Show Date And Time : </strong>
    
		<select name="shows" id="shows" style="width:130px; ">
		<option value="">---- Select Shows ----</option>
		</select>
		<span id="cityLoader" style="visibility:hidden;">
		    <img src="images/ajax-loader.gif">		
	    </span>	
	    <br/>
	    <br/>
 

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
</td>
</tr>
</table>
<center><input type="submit" name="seat" value="Select Seats"></center>
</form>


<%@include file="footer.html" %>


</body>
</html>