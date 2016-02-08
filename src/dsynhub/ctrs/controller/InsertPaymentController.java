package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.PaymentBean;
import dsynhub.ctrs.dao.PaymentDAO;
import dsynhub.ctrs.util.Validation;

public class InsertPaymentController extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session2=request.getSession();
		String adminid1=(String)session2.getAttribute("adminid"); 
		if(adminid1==null){
		request.setAttribute("sessionError","*Your Session Has Been Expied..Log In again..");
		request.getRequestDispatcher("userdetails.jsp").forward(request,response); 
		}
		else{
  String adminid=request.getParameter("admin");
  String paymenttype=request.getParameter("paymenttype");
  boolean isError=false;
	if(Validation.checkNull(paymenttype))
	{
		request.setAttribute("paymenttype","*Enter payment type");
		isError=true;
	}
	if(isError)
	{
	request.getRequestDispatcher("payment.jsp").forward(request, response);	
	}
	else
	{
  PaymentBean bean=new PaymentBean();
  bean.setAdminid(adminid);
  bean.setPaymenttype(paymenttype);
  PaymentDAO dao=new PaymentDAO();
  boolean flag=dao.insertData(bean);
  if(flag)
  {
	  System.out.println("Data Inserted...");
	  response.sendRedirect("ListPaymentController");
  }
  else
  {
	  request.getRequestDispatcher("payment.jsp").forward(request, response);
  }
	}
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 doGet(request, response);
	}

}
