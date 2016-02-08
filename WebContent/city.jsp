
<%@page import="dsynhub.ctrs.bean.StateBean"%>
<%@page import="dsynhub.ctrs.dao.CityDAO"%>
<%@page import="dsynhub.ctrs.bean.CityBean"%>
<%@page import="java.util.List"%>
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


</head>
<body>
<%@include file="adminheader.html" %>
<%List<CityBean> listAdmin=new CityDAO().selectAdmin(); %>

<form action="InsertCityController" method="post">
<table>
<tr>
<td>Select Admin:</td>
<td>
<select name="admin">
<%for(int i=0;i<listAdmin.size();i++) { %>

<%CityBean bean=(CityBean)listAdmin.get(i); %>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean.getAdminid().equals(adminid1)){ %> 

<option value="<%=bean.getAdminid()%>" selected="selected"><%=bean.getFirstname() %><%=bean.getLastname() %></option>

<%} %>
<%} %>
${adminid}
</select>

</td>

</tr>
<tr>

<td>Select State:</td>
<td>

<select name="state" id="state">
<option value="">---Select State---</option>
<%List listState=(List)application.getAttribute("allStates"); %>

<%for(int i=0;i<listState.size();i++) { %>
<%StateBean bean=(StateBean)listState.get(i); %>
<option value="<%=bean.getStateid()%>"><%=bean.getStatename()%></option>

<%} %>

</select>
<font color="red">${stateid}</font>
</td>

</tr>

 <tr>
    <td><strong>City : </strong></td>
    <td>
    <input type="text" name="city" value="">
		
	</td>
  </tr>
<tr>
<td><input type="submit" name="add" value="add"></td>
<td><input type="reset" name="reset" value="reset"></td>
</tr>

</table>


<%@include file="adminfooter.html" %>
</form>
</body>
</html>