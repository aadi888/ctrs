<%@page import="dsynhub.ctrs.bean.UserdetailsBean"%>
<%@page import="java.io.PrintWriter"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

function home() {
	var f=document.receipt;
	f.action="main.jsp";
	f.submit();
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="gray">
<%@include file="header.html" %>
<br>
<br>
<%UserdetailsBean bean=(UserdetailsBean)request.getAttribute("bean");%>
<%int length1=(Integer)request.getAttribute("length"); %>
<%int length=100*length1; %>
<%int discount=(10*length1); %>
<%int finalamount=((length)-(discount)); %>
<form action="TestMailController" name="receipt" method="post">
<input type="hidden" name="email" value="<%=bean.getEmail()%>">
<input type="hidden" name="name" value="<%=bean.getName()%>">

<center>
<h3>PAYMENT SUMMARY:</h3>
</center>
<center>
<table border="0">
<tr>
<th>NAME:</th>
<td>${bean.getName()}</td>
</tr>
<tr>
<th>EMAIL:</th>
<td>${bean.getEmail()}</td>
</tr>
<tr>
<th>MOBILE NUMBER:</th>
<td>${bean.getMobilenumber()}</td>
</tr>
<tr>
<th>CITY:</th>
<td>${bean.getCityname()}</td>
</tr>

<tr>
<td><h3 ><font color="red">Your actual bill in (rs) :</font></h3></td>
<td><%=length%></td>
</tr>
<tr>
<td><h3 ><font color="red">discount amount(rs) :</font></h3></td>
<td>-<%=discount%></td>
</tr>


<tr>
<td><h3 ><font color="red">bill after discount (rs) :</font></h3></td>
<input type="hidden" name="finalamount" value="<%=finalamount%>">
<td><%=finalamount%></td>
</tr>

<tr>
<td><input type="submit" value="Confirm order"></td>
<td><input type="button" onclick="home()" value="cancle">
</tr>

</table>
</center>
</form>
<%@include file="footer.html" %>
</body>
</html>