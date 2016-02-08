<%@page import="dsynhub.ctrs.dao.CityDAO"%>
<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.bean.AdminBean"%>
<%@page import="dsynhub.ctrs.dao.AdminDAO"%>
<%@page import="dsynhub.ctrs.bean.CityBean"%>
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
<%CityBean bean=(CityBean)request.getAttribute("bean"); %>
<form action="UpdateCityController" method="post">
<table border="0">
<input type="hidden" name="hid" value="<%=bean.getCityid()%>">
<tr>
<td>Select Admin :</td>
<td><select name="admin">
<%CityDAO dao=new CityDAO();

 List<CityBean> list=dao.selectAdmin();
 CityBean bean1=new CityBean();
%>
<%for(int i=0;i<list.size();i++) {%>
<%bean1 =(CityBean)list.get(i); %>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean1.getAdminid().equals(adminid1)){ %> 

<option value="<%=bean1.getAdminid()%>" selected="selected"><%=bean1.getFirstname()%><%=bean1.getLastname() %></option>
<%}%>
<%} %>
</select>${admin}</td>
</tr>
<tr>
<%List<CityBean> list1=dao.selectState(); %>
<td>Select State:</td>
<td><select name="state">
<%for(int i=0;i<list1.size();i++) { %>
<%CityBean bean2=new CityBean(); %>
<%bean2=list1.get(i); %>
<%if(bean2.getStateid().equals(bean.getStateid())){ %>
<option value="<%=bean2.getStateid()%>" selected="selected"><%=bean2.getStatename()%></option>
<%} else {%>
<option value="<%=bean2.getStateid()%>"><%=bean2.getStatename()%></option>
<%} %>
<%} %>
</select></td>
</tr>

<tr>
<td>Enter City:</td>
<td><input type="text" name="cityname" value="<%=bean.getCityname()%>"></td>
</tr>

<tr>
<td><input type="submit" name="UPDATE" value="UPDATE"></td>
<td><input type="reset" name="reset" value="reset"></td>
</tr>
</table>


</form>
<%@include file="adminfooter.html" %>
</body>
</html>