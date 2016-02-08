package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.dao.EventsDAO;

public class DeleteEventsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session2=request.getSession();
		String adminid1=(String)session2.getAttribute("adminid"); 
		if(adminid1==null){
		request.setAttribute("sessionError","*Your Session Has Been Expied..Log In again..");
		request.getRequestDispatcher("userdetails.jsp").forward(request,response); 
		}
		else{
	      String eventid=request.getParameter("hid");
	      EventsDAO dao=new EventsDAO();
	      boolean flag=dao.deleteEvent(eventid);
	      if(flag)
	      {
	    	  System.out.println("Data Deleted...");
	    	  request.getRequestDispatcher("ListEventsController").forward(request, response);
	      }
	      else
	      {
	    	  request.getRequestDispatcher("ListEventsController").forward(request, response);
	      }
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 doGet(request, response);
	
	}

}
