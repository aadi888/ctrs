<%@page import="java.util.List"%>
<%@page import="dsynhub.ctrs.bean.LanguageBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function del(id)
{
	var f=document.listlanguage;
	f.hid.value=id;
	
	f.action="DeleteLanguageController";
	f.submit();
	}
function edit(id)
{
	var f=document.listlanguage;
	f.hid.value=id;
	
	f.action="EditLanguageController";
	f.submit();
	}



</script>

</head>
<%List<LanguageBean> list=(List)request.getAttribute("list"); %>
<body>
<%@include file="adminheader.html" %>
<form action="" name="listlanguage" method="get">
<input type="hidden" name="hid" value="">
<table>
<tr>
<td>Language</td>
<td>Admin</td>
</tr>

<%for(int i=0;i<list.size();i++) { %>
<%LanguageBean bean=list.get(i);%>
<tr>

<td><%=bean.getLanguagename()%></td>
<td><%=bean.getFirstname()%><%="\n"%><%=bean.getLastname() %></td>


<td><a href="#" onclick="edit(<%=bean.getLanguageid()%>)">edit</a></td>
<td><a href="#" onclick="del(<%=bean.getLanguageid()%>)">delete</a></td>

</tr>
<%} %>

</table>

</form>
<%@include file="adminfooter.html" %>
</body>
</html>