<%@page import="dsynhub.ctrs.bean.EventsBean"%>
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
	<script type="text/javascript">
	function book(id)
	{
		var f=document.data;
		 f.hid.value=id;
		 f.action="EventBookingController";
		 f.submit();
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
			    <li><a class="active" href="event.jsp">EVENTS</a></li>
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
		
				<form name="data" action="home_submit" method="get" accept-charset="utf-8">
					<input type="hidden" name="hid" value="" >
					<label for="search-field">SEARCH</label>					
					<input type="text" name="search field" value="Enter search here" id="search-field" title="Enter search here" class="blink search-field"  />
					<input type="submit" value="GO!" class="search-button" />
				</form>
			</div>
		</div>
		<!-- end Sub-Menu -->
		
	</div>
	<!-- end Header -->
	<font color="silver" size="h1"><strong>EVENTS : </strong></font><br/>
	<p>
	
	<%ExtraDAO dao=new ExtraDAO(); %>
	<%List<EventsBean> list=dao.selectEvents();%>
	<%for(int i=0;i<list.size();i++){ %>
	<%EventsBean bean=list.get(i); %>
	<%=i+1%>-->Event Name : <%=bean.getEventname()%><br/>
	           Event Info:  <%=bean.getEventinfo() %><br/>
	           Event Price:  <%=bean.getEventprice() %>(rs)<br/>
	           <form name="event" action="EventBookingController">
	           <input type="hidden" name="eventid" value="<%=bean.getEventid()%>"> 
	           Number of Tickets:<select name="nooftickets">
	           <option value="1">1</option>
	           <option value="2">2</option>
	           <option value="3">3</option>
	           <option value="4">4</option>
	           <option value="5">5</option>
	           <option value="6">6</option>
	           <option value="7">7</option>
	           <option value="8">8</option>
	           <option value="9">9</option>
	           <option value="10">10</option>
	           </select><br/>
              <input type="submit" value="proceed">           
	</form>
	<br/>
	<%} %>
	<br/>
	
<%@include file="footer.html" %>
</body>
</html>