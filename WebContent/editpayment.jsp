<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.dao.PaymentDAO"%>
<%@page import="dsynhub.ctrs.bean.PaymentBean"%>
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
<%PaymentBean bean=(PaymentBean)request.getAttribute("bean"); %>
<form name="" action="UpdatePaymentController" method="get">
<table>
<%PaymentDAO dao=new PaymentDAO(); List<PaymentBean> list=dao.selectAdmin();%>
<input type="hidden" name="hid" value="<%=bean.getPaymentid()%>">

<tr>
<td>Select Admin :</td>
<td>
<select name="admin">
<%for(int i=0;i<list.size();i++){ %>
<%PaymentBean bean1=list.get(i); %>
<%HttpSession session2=request.getSession();%>
<%String adminid1=(String)session2.getAttribute("adminid");%>
<%if(bean1.getAdminid().equals(adminid1)){ %> 
<option value="<%=bean1.getAdminid()%>" selected="selected"><%=bean1.getFirstname() %><%=" "%><%=bean1.getLastname()%></option>
<%}%>
<%} %>
</select>
</td>
</tr>
<tr>
<td>Enter Payment Type : </td>
<td><input type="text" name="paymenttype" value="<%=bean.getPaymenttype()%>"></td>
</tr>
<tr>
<td><input type="submit" name="update" value="update"></td>
<td><input type="reset" name="reset" value="reset"> </td>
</tr>
</table>

</form>
<%@include file="adminfooter.html" %>

</body>
</html>