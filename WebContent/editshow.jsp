<%@page import="dsynhub.ctrs.dao.ShowDAO"%>
<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.bean.ShowBean"%>
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
<%ShowBean bean=(ShowBean)request.getAttribute("bean"); %>
<form action="UpdateShowController" method="post">
<input type="hidden" name="hid" value="<%=bean.getShowid()%>">
<table border="0">
<%ShowDAO dao=new ShowDAO(); %>

<%List<ShowBean> list=dao.selectAdmin(); %>
<tr>
<td>Select Admin :</td>
<td><select name="admin">

<%for(int i=0;i<list.size();i++){%>


<%ShowBean bean1=list.get(i);%>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean1.getAdminid().equals(adminid1)){ %> 
<option value="<%=bean1.getAdminid()%>" selected="selected"><%=bean1.getFirstname()%><%=bean1.getMiddlename()%><%=bean1.getLastname() %></option>

<%} %>
<%} %>
</select>${admin}</td>
</tr>
<tr>
<td>Select Movie And Branch :</td>
<td><select name="moviebranch">
<%List<ShowBean> list1=dao.selectMovieBranch();%>

<%for(int i=0;i<list1.size();i++){%>


<%ShowBean bean2=list1.get(i);%>
<%if(bean2.getMoviename().equals(bean.getMoviename()) && bean2.getBranchname().equals(bean.getBranchname())) { %>
<option value="<%=bean2.getMoviebranchid()%>" selected="selected"><%=bean2.getMoviename()%><%=","%><%=bean2.getBranchname()%></option>
<%} else { %>
<option value="<%=bean2.getMoviebranchid()%>"><%=bean2.getMoviename()%><%=","%><%=bean2.getBranchname()%></option>
<%}%>
<%} %>

</select></td>
</tr>
<%String date[]=bean.getShowdate().split(" "); %>
<tr>
<td>Enter Show Date(in 'DD/MM/YYYY' Format ):</td>
<td><input type="text" name="date" value="<%=date[0]%>"></td>
</tr>
<tr>
<td>Enter Show Time(in 'HH24:MM:SS' Format ):</td>
<td><input type="text" name="time" value="<%=date[1]%>"></td>
</tr>
<tr>
<tr>
<td><input type="submit" name="update" value="update"></td>
<td><input type="reset" name="reset" value="reset"></td>
</tr>
</table>



</form>
<%@include file="adminfooter.html" %>
</body>
</html>