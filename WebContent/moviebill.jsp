<%@page import="dsynhub.ctrs.bean.PaymentBean"%>
<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.dao.ExtraDAO"%>
<%@page import="dsynhub.ctrs.bean.BookingBean"%>
<%@page import="dsynhub.ctrs.bean.UserdetailsBean"%>
<%@page import="java.io.PrintWriter"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">


</script>
</head>
<body>
<%ExtraDAO dao=new ExtraDAO(); %>
<%@include file="header.html" %>
<br>
<br>
<%BookingBean bean=(BookingBean)request.getAttribute("bookingbean");%>
<%UserdetailsBean bean12=(UserdetailsBean)session.getAttribute("userdetailsbean"); %>
<%int price=bean.getPrice(); %>
<%int discount=((10*price)/100); %>
<%int finalamount=((price-discount)); %>


<form action="MovieBookingController" name="receipt" method="post">

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
<th>CITY:</th>
<%String cityname=dao.selectCityname(bean.getCityid()); %>
<td><%=cityname%></td>
</tr>
<tr>
<th>CINEMA AND BRANCH:</th>
<%String cinemabranch=dao.selectCinemaBranch(bean.getMoviebranchid()); %>
<td><%=cinemabranch%></td>

</tr>
<tr>
<th>MOVIE:</th>
<%String moviename=dao.selectMovieName(bean.getMoviebranchid()); %>
<td><%=moviename%></td>

</tr>
<tr>
<th>SHOW DATE AND TIME:</th>
<td><%=bean.getShowdate()%></td>

</tr>

<tr>
<th>SCREEN:</th>
<%String screenno=dao.selectScreen(bean.getScreenid()); %>
<td><%=screenno%></td>

</tr>
<tr>
<th>SEATS:</th>
<%String[] seats= bean.getSeats(); %>
<%String seat1=""; %>
<%for(int i=0;i<seats.length;i++){ %>
<%String seat=seat1+seats[i]; %>
<%seat1=seat; %>
<%}%><td><%=seat1%></td>
</tr>

<tr>
<td><h3 ><font color="red">Your actual bill in (rs) :</font></h3></td>
<td><%=price%></td>
</tr>
<tr>
<td><h3 ><font color="red">discount amount(rs) :</font></h3></td>
<td>-<%=discount%></td>
</tr>
<tr>
<td><h3 ><font color="red">Select Payment Type :</font></h3></td>
<%List list=dao.selectPaymentType();%>

<td><select name="payment">
<%for(int i=0;i<list.size();i++){ %>
<%PaymentBean bean55=(PaymentBean)list.get(i); %>
<option value="<%=bean55.getPaymentid()%>"><%=bean55.getPaymenttype()%></option>
<%} %>


</select></td>
</tr>


<tr>
<td><h3 ><font color="red">bill after discount (rs) :</font></h3></td>
<td><%=finalamount%></td>
</tr>


</table>
</center>

<input type="hidden" name="price" value="<%=finalamount%>">
<input type="hidden" name="name" value="<%=bean12.getName()%>">
<input type="hidden" name="email" value="<%=bean12.getEmail()%>">
<input type="hidden" name="mobilenumber" value="<%=bean12.getMobilenumber()%>">
<input type="hidden" name="cityname" value="<%=cityname%>">
<input type="hidden" name="cityid" value="<%=bean.getCityid()%>">
<input type="hidden" name="cinemaid" value="<%=bean.getCinemaid()%>">
<input type="hidden" name="moviebranchid" value="<%=bean.getMoviebranchid()%>">
<input type="hidden" name="screenid" value="<%=bean.getScreenid()%>">
<input type="hidden" name="showid" value="<%=bean.getShowid()%>">
<input type="hidden" name="cinemabranch" value="<%=cinemabranch%>">
<input type="hidden" name="moviename" value="<%=moviename%>">
<input type="hidden" name="showdate" value="<%=bean.getShowdate()%>">
<input type="hidden" name="userid" value="<%=bean.getUserid()%>">
<input type="hidden" name="seat" value="<%=seat1%>">
<input type="hidden" name="screenno" value="<%=screenno%>">

<center>

<input type="submit" value="Confirm order">
<a href="main.jsp">cancle</a>

</center>
</form>

<%@include file="footer.html" %>
</body>
</html>