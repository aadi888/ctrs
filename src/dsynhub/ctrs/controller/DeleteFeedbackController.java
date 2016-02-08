package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dsynhub.ctrs.dao.FeedbackDAO;


public class DeleteFeedbackController extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session2=request.getSession();
		String adminid1=(String)session2.getAttribute("adminid"); 
		if(adminid1==null){
		request.setAttribute("sessionError","*Your Session Has Been Expied..Log In again..");
		request.getRequestDispatcher("userdetails.jsp").forward(request,response); 
		}
		else{
		String id=request.getParameter("hid");
	
		FeedbackDAO dao=new FeedbackDAO();
		boolean flag=dao.deleteData(id);
		if(flag)
		{
			System.out.println("deleted");
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

	

