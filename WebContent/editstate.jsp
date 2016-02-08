<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.dao.StateDao"%>
<%@page import="dsynhub.ctrs.bean.StateBean"%>
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
<%StateBean bean=(StateBean)request.getAttribute("bean"); %>


<form action="UpdateStateController" method="get" name="edit">
<table border="0">
<input type="hidden" name="stateid" value="<%=bean.getStateid()%>">

<tr>
<td>Select Admin :</td>
<td><select name="admin">
<%StateDao dao=new StateDao();

 List<StateBean> list=dao.selectAdmin();
StateBean bean1=null;
%>
<%for(int i=0;i<list.size();i++) {%>
<%bean1=new StateBean(); %>
<%bean1=(StateBean)list.get(i);%>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean1.getAdminid().equals(adminid1)){ %> 
<option value="<%=bean1.getAdminid()%>" selected="selected"><%=bean1.getFirstname()%><%=bean1.getLastname() %></option>
<%}%>
<%} %>
</select>${admin}</td>
</tr>
<tr>
<td>Enter State:</td>
<td><input type="text" name="statename" value="<%=bean.getStatename()%>">${statename}</td>
</tr>
<tr>
<td><input type="submit" name="UPDATE" value="UPDATE"></td>
<td><input type="reset" name="reset"></td>
</tr>
</table>


</form>
<%@include file="adminfooter.html" %>
</body>
</html>