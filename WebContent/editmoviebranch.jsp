<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.dao.MoviebranchDAO"%>
<%@page import="dsynhub.ctrs.bean.MoviebranchBean"%>
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
<form action="UpdateMoviebranchController" name="editmoviebranch">
<%MoviebranchBean bean=(MoviebranchBean)request.getAttribute("bean"); %>
<input type="hidden" name="hid" value="<%=bean.getMoviebranchid()%>">
<table>
<tr>
<td>Select Admin :</td>
<td><select name="admin">
<%MoviebranchDAO dao=new MoviebranchDAO();

 List<MoviebranchBean> list=dao.selectAdmin();
 MoviebranchBean bean1=new MoviebranchBean();
%>
<%for(int i=0;i<list.size();i++) {%>
<%bean1 =(MoviebranchBean)list.get(i); %>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean1.getAdminid().equals(adminid1)){ %> 

<option value="<%=bean1.getAdminid()%>" selected="selected"><%=bean1.getFirstname()%><%=bean1.getLastname() %></option>
<%} %>
<%} %>
</select>${admin}</td>
</tr>
<tr>
<%List<MoviebranchBean> list1=dao.selectMovie(); %>
<td>Select Movie:</td>
<td><select name="movie">
<%for(int i=0;i<list1.size();i++) { %>
<%MoviebranchBean bean2=new MoviebranchBean(); %>
<%bean2=list1.get(i); %>
<%if(bean2.getMoviename().equals(bean.getMoviename())){ %>
<option value="<%=bean2.getMovieid()%>" selected="selected"><%=bean2.getMoviename()%></option>
<%} else {%>
<option value="<%=bean2.getMovieid()%>"><%=bean2.getMoviename()%></option>
<%} %>
<%} %>
</select></td>
</tr>

<tr>
<%List<MoviebranchBean> list2=dao.selectBranch(); %>
<td>Select Branch:</td>
<td><select name="branch">
<%for(int i=0;i<list2.size();i++) { %>
<%MoviebranchBean bean3=new MoviebranchBean(); %>
<%bean3=list2.get(i); %>
<%if(bean3.getBranchname().equals(bean.getBranchname())){ %>
<option value="<%=bean3.getBranchid()%>" selected="selected"><%=bean3.getBranchname()%></option>
<%} else {%>
<option value="<%=bean3.getBranchid()%>"><%=bean3.getBranchname()%></option>
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