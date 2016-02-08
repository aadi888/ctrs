package dsynhub.ctrs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.EventsBean;
import dsynhub.ctrs.dao.EventsDAO;

/**
 * Servlet implementation class ListEventsController
 */
public class ListEventsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session2=request.getSession();
		String adminid1=(String)session2.getAttribute("adminid"); 
		if(adminid1==null){
		request.setAttribute("sessionError","*Your Session Has Been Expied..Log In again..");
		request.getRequestDispatcher("userdetails.jsp").forward(request,response); 
		}
		else{
		EventsDAO dao=new EventsDAO();
	  List<EventsBean> list=new ArrayList<EventsBean>();
	  list=dao.selectEvents();
	  if(list!=null)
	  {
		  
	  
	  
	  request.setAttribute("list",list);
	  request.getRequestDispatcher("listevents.jsp").forward(request, response);
	}
	  else
	  {
		  request.getRequestDispatcher("events.jsp").forward(request, response);
	  }
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 doGet(request, response);
	}

}
