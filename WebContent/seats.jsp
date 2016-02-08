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
<%@include file="header.html" %>
<%String moviebranchid=(String)request.getParameter("cinema");%>
<%String showid=(String)request.getParameter("shows");%>
<form action="CheckSeatController" name="seats">

<center><font color="silver" size="h2"><strong><marquee><-----------SELECT YOUR SEATS-------------></marquee></strong></font></center>
<%String error=(String)request.getAttribute("error"); %>
<font color="red">${error}</font>
<%String id=request.getParameter("hid"); %>
<input type="hidden" name="moviebranchid" value="<%=moviebranchid%>">
<input type="hidden" name="showid" value="<%=showid%>"> 
<center>
<table>
<tr>
<td></td>
<%for(int i=1;i<=16;i++){ %>
<td><%=i%></td>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>Z:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="Z<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>Y:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="Y<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>

<tr>
<td>X:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="X<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>W:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="W<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>V:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="V<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>U:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="U<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>T:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="T<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>S:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="S<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>R:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="R<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>Q:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="Q<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>P:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="P<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>O:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="O<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>N:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="N<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>M:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="M<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>L:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="L<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>K:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="K<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>J:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="J<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>I:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="I<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>H:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="H<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>G:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="G<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>F:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="F<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>E:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="E<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>D:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="D<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>C:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="C<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>B:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="B<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
<tr>
<td>A:</td>
<%for(int i=1;i<=16;i++){ %>
<%if(i==5 || i==12){ %>
<td></td>
<%}else{%>
<td><input type="checkbox" name="seats" value="A<%=i%>"></td>
<%} %>
<td></td>
<td></td>
<td></td>
<td></td>
<%} %>
</tr>
</table>
</center>
<center>
<input type="submit" value="payment">
<input type="reset" value="reset">
</center>





</form>
<%@include file="footer.html" %>
</body>
</html>