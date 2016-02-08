<%@page import="dsynhub.ctrs.dao.ExtraDAO"%>
<%@page import="dsynhub.ctrs.bean.PaymentBean"%>
<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.bean.UserdetailsBean"%>
<%@page import="dsynhub.ctrs.bean.EventsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
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
<form action="EventController">
<%int nooftickets=(Integer)request.getAttribute("nooftickets"); %>
<%int price=(Integer)request.getAttribute("price"); %>
<%EventsBean bean=(EventsBean)request.getAttribute("bean"); %>
<%UserdetailsBean bean12=(UserdetailsBean)session.getAttribute("userdetailsbean");%>
<%if(bean12==null){ %>
<%request.setAttribute("error","*You need to register first");%>
<%request.getRequestDispatcher("userdetails.jsp").forward(request, response); %>

<%}else{ %>

<center>
<h3>PAYMENT SUMMARY:</h3>
</center>
<center>
<table border="0">
<tr>
<th>NAME:</th>
<td><%=bean12.getName()%></td>
</tr>
<tr>
<th>EMAIL:</th>
<td><%=bean12.getEmail()%></td>
</tr>
<tr>
<th>MOBILE NUMBER:</th>
<td><%=bean12.getMobilenumber()%></td>
</tr>
<tr>
<th>EVENT NAME:</th>
<td><%=bean.getEventname()%></td>
</tr>
<tr>
<th>EVENT INFO:</th>
<td><%=bean.getEventinfo()%></td>
</tr>
<tr>
<th>NUMBER OF TICKETS:</th>
<td><%=nooftickets%></td>
</tr>
<tr>
<td><h3 ><font color="red">Select Payment Type :</font></h3></td>
<%List list=new ExtraDAO().selectPaymentType();%>

<td><select name="payment">
<%for(int i=0;i<list.size();i++){ %>
<%PaymentBean bean55=(PaymentBean)list.get(i); %>
<option value="<%=bean55.getPaymentid()%>"><%=bean55.getPaymenttype()%></option>
<%} %>
</select></td>
</tr>

<tr>
<td><h3 ><font color="red">Your bill in (rs) :</font></h3></td>
<td><%=price%></td>
</tr>

</table>
</center>
<%String eventname=bean.getEventname(); %>
<%String eventid=new ExtraDAO().selectEventid(eventname); %>

<%String userid=new ExtraDAO().selectUserId(bean12.getEmail()); %>
<input type="hidden" name="eventid" value="<%=eventid%>">
<input type="hidden" name="nooftickets" value="<%=nooftickets%>">
<input type="hidden" name="price" value="<%=price%>">
<input type="hidden" name="userid" value="<%=userid%>">
<input type="hidden" name="name" value="<%=bean12.getName()%>">
<input type="hidden" name="email" value="<%=bean12.getEmail()%>">
<input type="hidden" name="eventname" value="<%=bean.getEventname()%>">
<input type="hidden" name="eventinfo" value="<%=bean.getEventinfo()%>">



<center><input type="submit" value="Confirm order">
<a href="main.jsp">cancle</a></center>


<%} %>
</form>
<%@include file="footer.html" %>
</body>
</html>