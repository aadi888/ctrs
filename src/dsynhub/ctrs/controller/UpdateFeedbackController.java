package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dsynhub.ctrs.bean.FeedbackBean;

import dsynhub.ctrs.dao.FeedbackDAO;


public class UpdateFeedbackController extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session2=request.getSession();
		String adminid1=(String)session2.getAttribute("adminid"); 
		if(adminid1==null){
		request.setAttribute("sessionError","*Your Session Has Been Expied..Log In again..");
		request.getRequestDispatcher("userdetails.jsp").forward(request,response); 
		}
		else{
		String emailid=request.getParameter("emailid");
		String msg=request.getParameter("msg");
		String feedbackid=request.getParameter("hid");
		FeedbackBean bean=new FeedbackBean();
		bean.setFeedbackid(feedbackid);
		bean.setEmailid(emailid);
		bean.setMsg(msg);
		FeedbackDAO id=new FeedbackDAO();
		boolean flag=id.updateData(bean);
		if(flag)
		{
			System.out.println("UPDATED");
			request.getRequestDispatcher("ListFeedbackController").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("ListFeedbackController").forward(request, response);
		}
	}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

}
