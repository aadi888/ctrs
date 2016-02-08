package dsynhub.ctrs.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.*;
import dsynhub.ctrs.dao.*;
import dsynhub.ctrs.util.Validation;


public class InsertFeedbackController extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String emailid=request.getParameter("emailid");
		String msg=request.getParameter("msg");
		 boolean isError=false;
		 if(Validation.checkNull(emailid))
		 {
			 isError=true;
			 request.setAttribute("emailid","Enter emailid ");
			 
		 }
		 if(Validation.checkNull(msg))
		 {
			 isError=true;
			 request.setAttribute("msg", "Plz Enter Feedback Message");
		 }
		 if(isError)
		 {
			 request.getRequestDispatcher("feedback.jsp").forward(request, response);
		 }
		 else
		 {
		FeedbackBean bean=new FeedbackBean();
		bean.setEmailid(emailid);
		bean.setMsg(msg);
		FeedbackDAO dao=new FeedbackDAO();
		boolean flag=dao.insertData(bean);
		if(flag)
		{
			System.out.println("inserted");
          response.sendRedirect("main.jsp");
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