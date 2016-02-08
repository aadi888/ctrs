<%@page import="dsynhub.ctrs.dao.UserdetailsDAO"%>
<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.bean.UserdetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="adminheader.html" %>
<%UserdetailsBean bean=(UserdetailsBean)request.getAttribute("bean"); %>

<form action="UpdateUserdetailsController" method="post">
<input type="hidden" name="hid" value="<%=bean.getUserid()%>">
<table border="0">

<tr>
<td>USERNAME:</td>
<td><input type="text" name="name" value="<%=bean.getName()%>"/></td>
</tr>
<tr>
<td>EMAIL:</td>
<td><input type="text" name="email" value="<%=bean.getEmail()%>" /></td>
</tr>

<tr>
<td>MOBILENUMBER:</td>
<td><input type="text" name="mobilenumber" value="<%=bean.getMobilenumber()%>"/></td>
</tr>

<tr>
<td>GENDER:</td>
<%if(bean.getGender().equals("MALE")) {%>
<td><input type="radio" name="gender" value="MALE" checked="checked"/>MALE</td>
<td><input type="radio" name="gender" value="FEMALE" />FEMALE</td>
<%}else { %>
<td><input type="radio" name="gender" value="MALE"/>MALE</td>
<td><input type="radio" name="gender" value="FEMALE" checked="checked" />FEMALE</td>

<%} %>
</tr>


 
 
<%List<UserdetailsBean> list=new UserdetailsDAO().selectCity();%>

<tr>
<td>Select City:</td>
<td><select name="city">
<%for(int i=0;i<list.size();i++) { %>
<%UserdetailsBean bean1=list.get(i); %>

<%if(bean1.getCityid().equals(bean.getCityid())){ %>
<option value="<%=bean1.getCityid()%>" selected="selected"><%=bean1.getCityname() %></option>
<%}else{ %>
<option value="<%=bean1.getCityid()%>"><%=bean1.getCityname() %></option>
<%} %>
<%} %>
</select></td>
</tr>
<tr>
<td><input type="submit" value="add" name="add" /></td>
<td><input type="reset" value="reset" /></td>


</table>
</form>
<%@include file="adminfooter.html" %>
</body>
</html>