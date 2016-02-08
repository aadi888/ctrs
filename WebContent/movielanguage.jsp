<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.dao.MovielanguageDAO"%>
<%@page import="dsynhub.ctrs.bean.MovielanguageBean"%>
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
<form action="InsertMovielanguageController" method="get" name="movielanguage">
<table>
<tr>
<td>Select Admin :</td>
<td><select name="admin">
<%MovielanguageDAO dao=new MovielanguageDAO();

 List<MovielanguageBean> list=dao.selectAdmin();
 MovielanguageBean bean=new MovielanguageBean();
%>
<%for(int i=0;i<list.size();i++) { %>
<%bean =(MovielanguageBean)list.get(i); %>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean.getAdminid().equals(adminid1)){ %> 

<option value="<%=bean.getAdminid()%>"><%=bean.getFirstname()%><%=bean.getLastname() %></option>
<%} %>
<%} %>
</select>${admin}</td>
</tr>
<tr>
<%List<MovielanguageBean> list1=dao.selectMovie(); %>
<td>Select Movie:</td>
<td><select name="movie">
<%for(int i=0;i<list1.size();i++) { %>
<%MovielanguageBean bean1=new MovielanguageBean(); %>
<%bean1=list1.get(i); %>
<option value="<%=bean1.getMovieid()%>"><%=bean1.getMoviename()%></option>
<%} %>
</select></td>
</tr>

<tr>
<%List<MovielanguageBean> list2=dao.selectLanguage(); %>
<td>Select Language:</td>
<td><select name="language">
<%for(int i=0;i<list2.size();i++) { %>
<%MovielanguageBean bean2=new MovielanguageBean(); %>
<%bean2=list2.get(i); %>
<option value="<%=bean2.getLanguageid()%>"><%=bean2.getLanguagename()%></option>
<%} %>
</select></td>
</tr>
<tr>
<td><input type="submit" name="add" value="add"></td>
<td><input type="reset" name="reset" value="reset"></td>
</tr>


</table>




</form>
<%@include file="adminfooter.html" %>
</body>
</html>