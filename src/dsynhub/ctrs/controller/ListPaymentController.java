package dsynhub.ctrs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.PaymentBean;
import dsynhub.ctrs.dao.PaymentDAO;


public class ListPaymentController extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session2=request.getSession();
		String adminid1=(String)session2.getAttribute("adminid"); 
		if(adminid1==null){
		request.setAttribute("sessionError","*Your Session Has Been Expied..Log In again..");
		request.getRequestDispatcher("userdetails.jsp").forward(request,response); 
		}
		else{
	List<PaymentBean> list=new ArrayList<PaymentBean>();
	PaymentDAO dao=new PaymentDAO();
	list=dao.selectData();
	if(list!=null)
	{
		request.setAttribute("list",list);
		request.getRequestDispatcher("listpayment.jsp").forward(request, response);
	}
	
	else
	{
		request.getRequestDispatcher("payment.jsp").forward(request, response);
	}
	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 doGet(request, response);
	}

}
