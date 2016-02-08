<%@page import="dsynhub.ctrs.bean.PaymentBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function edit(id)
{
	 var f=document.listpayment;
	 f.hid.value=id;
	 f.action="EditPaymentController";
	 f.submit();
}
function del(id)
{
	 var f=document.listpayment;
	 f.hid.value=id;
	 f.action="DeletePaymentController";
	 f.submit();
}


</script>
</head>
<body>
<%@include file="adminheader.html" %>
<%List<PaymentBean> list=(List)request.getAttribute("list"); %>
<form action="" name="listpayment">
<input type="hidden" name="hid" value="">
<table border="0">
<tr>
<td>Payment Type</td>
<td>Admin</td>
</tr>
<%for(int i=0;i<list.size();i++) { %>
<%PaymentBean bean=list.get(i); %>
<tr>
<td><%=bean.getPaymenttype()%></td>
<td><%=bean.getFirstname()%><%=" "%><%=bean.getLastname()%></td>
<td><a href="#" onclick="edit(<%=bean.getPaymentid()%>)">edit</a></td>
<td><a href="#" onclick="del(<%=bean.getPaymentid()%>)">delete</a></td>
</tr>

<%} %>

</table>


</form>
<%@include file="adminfooter.html" %>
</body>
</html>