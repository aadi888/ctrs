package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.PaymentBean;
import dsynhub.ctrs.dao.PaymentDAO;

/**
 * Servlet implementation class EditPaymentController
 */
public class EditPaymentController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session2=request.getSession();
		String adminid1=(String)session2.getAttribute("adminid"); 
		if(adminid1==null){
		request.setAttribute("sessionError","*Your Session Has Been Expied..Log In again..");
		request.getRequestDispatcher("userdetails.jsp").forward(request,response); 
		}
		else{
	  String paymentid=request.getParameter("hid");
	  PaymentDAO dao=new PaymentDAO();
	  PaymentBean bean=dao.selectData(paymentid);
	  if(bean!=null)
	  {
		  request.setAttribute("bean",bean);
		  request.getRequestDispatcher("editpayment.jsp").forward(request, response);
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
