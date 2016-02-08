package dsynhub.ctrs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.FeedbackBean;
import dsynhub.ctrs.dao.FeedbackDAO;


public class ListFeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session2=request.getSession();
		String adminid1=(String)session2.getAttribute("adminid"); 
		if(adminid1==null){
		request.setAttribute("sessionError","*Your Session Has Been Expied..Log In again..");
		request.getRequestDispatcher("userdetails.jsp").forward(request,response); 
		}
		else{
		  List<FeedbackBean> list=new ArrayList<FeedbackBean>();
		  FeedbackDAO dao=new FeedbackDAO();
		  list=dao.selectData();
		  if(list!=null)
		  {
			  request.setAttribute("list",list);
			  request.getRequestDispatcher("listfeedback.jsp").forward(request, response);
		  }
		  else
		  {
			  request.getRequestDispatcher("feedback.jsp").forward(request, response);
			  
		  }
		}
	}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
}

