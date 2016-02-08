package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.EventsBean;
import dsynhub.ctrs.dao.EventsDAO;

public class EditEventsController extends HttpServlet {
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
	 EventsBean bean=dao.editEvents(eventid);
	 if(bean!=null)
	 {
		 request.setAttribute("bean",bean);
		 request.getRequestDispatcher("editevents.jsp").forward(request, response);
	 }
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 doGet(request, response);
	}

}
