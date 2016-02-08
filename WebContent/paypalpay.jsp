<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Pay through PayPal: http://www.TestAccount.com</title>
</head>
<bodyonload="document.forms['paypalForm'].submit();">
<formname="paypalForm" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
 <inputtype="hidden" name="cmd" value="_xclick"/>
 <inputtype="hidden" name="business" value="dsynhubcompany-facilitator_api1.yahoo.com"/>
 <inputtype="hidden" name="password" value="1398968614"/>
 <inputtype="hidden" name="custom" value="1123"/>
 <inputtype="hidden" name="item_name" value="Computer-Laptop"/>
 <inputtype="hidden" name="amount" value="30"/>
 <inputtype="hidden" name="rm" value="1"/>
 <inputtype="hidden" name="return" value="http://localhost:8080/ctrs/paypalResponse.jsp"/>
 <inputtype="hidden" name="cancel_return" value="http://localhost:8080/ctrs/paypalResponseCancel.jsp"/>
 <inputtype="hidden" name="cert_id" value="AFcWxV21C7fd0v3bYYYRCpSSRl31AHSNfvKuw1PLpd.m4LiMuMUiMYnX"/>
</form>
</body>
</html>
