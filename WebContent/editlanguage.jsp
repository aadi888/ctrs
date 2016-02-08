<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.dao.LanguageDAO"%>
<%@page import="dsynhub.ctrs.bean.LanguageBean"%>
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
<form action="UpdateLanguageController" name="editlanguage" method="get">
<table border="0">
<%LanguageBean bean=(LanguageBean)request.getAttribute("bean"); %>
<input type="hidden" name="hid" value="<%=bean.getLanguageid()%>">
<tr>
<td>Select Admin :</td>
<td><select name="admin">
<%LanguageDAO dao=new LanguageDAO();

 List<LanguageBean> list=(List)dao.selectAdmin();
 
%>
<%for(int i=0;i<list.size();i++) { %>
<%LanguageBean bean1=new LanguageBean();%>
<%bean1=(LanguageBean)list.get(i); %>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean1.getAdminid().equals(adminid1)){ %> 
<option value="<%=bean1.getAdminid()%>" selected="selected"><%=bean1.getFirstname()%><%=bean1.getLastname() %></option>
<%} %>
<%} %>
</select></td>
</tr>
<tr>
<td>Enter Language:</td>
<td><input type="text" name="languagename" value="<%=bean.getLanguagename()%>"></td>
</tr>
<tr>
<td><input type="submit" name="update" value="update"></td>
<td><input type="reset" name="reset" value="reset"></td>
</tr>


</table>





</form>
<%@include file="adminfooter.html" %>
</body>
</html>