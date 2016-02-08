<%@page import="dsynhub.ctrs.bean.NewsBean"%>
<%@page import="dsynhub.ctrs.dao.ExtraDAO"%>
<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.dao.UserdetailsDAO"%>
<%@page import="dsynhub.ctrs.bean.UserdetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter your details</title>
<link rel="stylesheet"
	href="jquery-ui-1.10.4.custom/css/sunny/jquery-ui-1.10.4.custom.css" />
<link rel="stylesheet"
	href="jQuery-Validation/css/validationEngine.jquery.css" />
<script src="jquery-ui-1.10.4.custom/js/jquery-1.10.2.js"></script>
<script src="jquery-ui-1.10.4.custom/js/jquery-ui-1.10.4.custom.js"></script>
<script src="jQuery-Validation/js/jquery.validationEngine.js"></script>
<script src="jQuery-Validation/js/languages/jquery.validationEngine-en.js"></script>
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<!--[if IE 6]>
		<link rel="stylesheet" href="css/ie6.css" type="text/css" media="all" />
	<![endif]-->
	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="js/jquery-func.js"></script>

	<script type="text/javascript" src="js/jq.js"></script>
<script type="text/javascript">
function SurfAsGuest(id){
	
	var f=document.userdetails;
	f.cityid.value=id;
	f.action="SurfAsGuestController";
	f.submit();
	
}


</script>
</head>
<body bgcolor="#999999">
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
		</div>
		</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<%String sessionError=(String)request.getAttribute("sessionError"); %>
<font color="red">${sessionError}</font>

<form action="" name="userdetails">

<table>
<input type="hidden" name="cityid" value="">
<%UserdetailsDAO dao3=new UserdetailsDAO(); %>
<%List<UserdetailsBean> list3=dao3.selectCity(); %>
<%String error=(String)request.getAttribute("error"); %>
<th>SURF AS A GUEST</th><font color="red">${error}</font>

</tr>
<tr>
<td><select name="city">
<%for(int i=0;i<list3.size();i++){ %>
<%UserdetailsBean bean3=list3.get(i); %>
<option value="" onclick="SurfAsGuest(<%=bean3.getCityid()%>)"><%=bean3.getCityname() %></option>
<%} %>
</select></td>
</tr>
</table>
</form>
<br/>

<form name="registerusers" action="LoginController"> 
<table>
<%String loginerror=(String)request.getAttribute("loginerror"); %>

<tr>
<font color="red">${loginerror}</font>
<th>  REGISTERED USER(s)</th>
</tr>



<tr>
<td>USERNAME:</td>
<td><input type="text" name="username"/></td>
</tr>
<tr>
<td>PASSWORD:</td>
<td><input type="password" name="password" /></td>

<td><input type="submit" value="Login"/><a href="forgotpassword.jsp">Forgot Password</a>
</td>
</tr>

</table>
</form>

<br />

<form name="newUser" id="newuser" action="InsertUserdetailsController">
<table align="left">
<tr>
<th>LOGIN AS A NEW USER</th>
</tr>
<tr>
<td>USERNAME:</td>
<td><input type="text" name="name" class="validate[required] text-input"/><font color="red">${name}</font></td>
</tr>
<tr>
<td>EMAIL:</td>
<td><input type="text" name="email" class="validate[required] text-input" /><font color="red">${email}</font></td>
</tr>
<tr>
<td>PASSWORD:</td>
<td><input type="password" name="password" class="validate[required] text-input"/><font color="red">${password}</font></td>
</tr>
<tr>
<td>MOBILENUMBER:</td>
<td><input type="text" name="mobilenumber" class="validate[custom[phone]required] text-input" /><font color="red">${mobilenumber}</font></td>
</tr>
<tr>
<td>GENDER:</td>
<td><input type="radio" name="gender" value="MALE" checked="checked"/>MALE</td>
<td><input type="radio" name="gender" value="FEMALE" />FEMALE</td>
</tr>
<tr>
<td>SELECT CITY :</td>
<td><select name="city">
<%UserdetailsDAO dao=new UserdetailsDAO(); %>
<%List<UserdetailsBean> list=dao.selectCity(); %>
<%for(int i=0;i<list.size();i++){ %>
<%UserdetailsBean bean=list.get(i); %>
<option value="<%=bean.getCityid()%>"><%=bean.getCityname()%></option>
<%} %>
</select></td>
</tr>
<tr>
<td><input type="submit" value="SUBMIT" /></td>
<td><input type="reset" value="reset" /></td>
</tr>
</table>

</form>
<center><input type="image" src="images/cinema.jpg" alt=":)"/></center>
<br>
<br>
<p>
<%ExtraDAO dao1=new ExtraDAO(); %>
<%List list1=(List)dao1.selectNews(); %>
<marquee direction="left">
<font color="red">NEWS:</font>
<%for(int i=0;i<list1.size();i++){ %>
<%NewsBean bean=(NewsBean)list1.get(i);%>
<%=bean.getNewstitle()%><%="  ,  "%>
<%} %>
</marquee>
<%@include file="adminfooter.html" %>
</body>
</html>