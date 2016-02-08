package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.PaymentBean;
import dsynhub.ctrs.dao.PaymentDAO;


public class UpdatePaymentController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session2=request.getSession();
		String adminid1=(String)session2.getAttribute("adminid"); 
		if(adminid1==null){
		request.setAttribute("sessionError","*Your Session Has Been Expied..Log In again..");
		request.getRequestDispatcher("userdetails.jsp").forward(request,response); 
		}
		else{
		
		 String paymentid=request.getParameter("hid");
		 String paymenttype=request.getParameter("paymenttype");
		 String adminid=request.getParameter("admin");
		 PaymentBean bean=new PaymentBean();
		 bean.setPaymentid(paymentid);
		 bean.setPaymenttype(paymenttype);
		 bean.setAdminid(adminid);
		 PaymentDAO dao=new PaymentDAO();
		 boolean flag=dao.updateData(bean);
		 if(flag)
		 {
			 System.out.println("Data Updated...");
			 request.getRequestDispatcher("ListPaymentController").forward(request, response);
		 }
		 else
		 {
			 request.getRequestDispatcher("ListPaymentController").forward(request, response);
		 }
	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 doGet(request, response);
	}

}
