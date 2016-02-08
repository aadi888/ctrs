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
<%MovielanguageBean bean=(MovielanguageBean)request.getAttribute("bean"); %>
<form action="UpdateMovielanguageController" method="get" name="editmovielanguage">
<input type="hidden" name="hid" value="<%=bean.getMovielanguageid() %>" >
<table>
<tr>
<td>Select Admin :</td>
<td><select name="admin">
<%MovielanguageDAO dao=new MovielanguageDAO();

 List<MovielanguageBean> list=dao.selectAdmin();
 MovielanguageBean bean1=new MovielanguageBean();
%>
<%for(int i=0;i<list.size();i++) { %>
<%bean1=(MovielanguageBean)list.get(i); %>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean1.getAdminid().equals(adminid1)){ %> 
<option value="<%=bean1.getAdminid()%>" selected="selected"><%=bean1.getFirstname()%><%=bean1.getLastname() %></option>
<%} %>
<%} %>
</select>${admin}</td>
</tr>
<tr>
<%List<MovielanguageBean> list1=dao.selectMovie(); %>
<td>Select Movie:</td>
<td><select name="movie">
<%for(int i=0;i<list1.size();i++) { %>
<%MovielanguageBean bean2=new MovielanguageBean(); %>
<%bean2=list1.get(i); %>
<%if(bean2.getMoviename().equals(bean.getMoviename())){ %>
<option value="<%=bean2.getMovieid()%>" selected="selected"><%=bean2.getMoviename()%></option>
<%} else { %>
<option value="<%=bean2.getMovieid()%>"><%=bean2.getMoviename()%></option>
<%} %>
<%} %>
</select></td>
</tr>

<tr>
<%List<MovielanguageBean> list2=dao.selectLanguage(); %>
<td>Select Language:</td>
<td><select name="language">
<%for(int i=0;i<list2.size();i++) { %>
<%MovielanguageBean bean3=new MovielanguageBean(); %>
<%bean3=list2.get(i); %>
<%if(bean3.getLanguagename().equals(bean.getLanguagename())){ %>
<option value="<%=bean3.getLanguageid()%>" selected="selected"><%=bean3.getLanguagename()%></option>
<%} else { %>
<option value="<%=bean3.getLanguageid()%>"><%=bean3.getLanguagename()%></option>
<%} %>
<%} %>
</select></td>
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