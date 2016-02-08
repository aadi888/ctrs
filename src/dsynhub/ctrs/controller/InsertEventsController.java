package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.EventsBean;
import dsynhub.ctrs.dao.EventsDAO;
import dsynhub.ctrs.util.Validation;

/**
 * Servlet implementation class InsertEventsController
 */
public class InsertEventsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session2=request.getSession();
		String adminid1=(String)session2.getAttribute("adminid"); 
		if(adminid1==null){
		request.setAttribute("sessionError","*Your Session Has Been Expied..Log In again..");
		request.getRequestDispatcher("userdetails.jsp").forward(request,response); 
		}
		else{
		String adminid=request.getParameter("admin");
		String eventname=request.getParameter("eventname");
		String eventinfo=request.getParameter("eventinfo");
		String eventprice=request.getParameter("eventprice");
		boolean isError=false;
		if(Validation.checkNull(adminid))
		{
			request.setAttribute("admin","*Plz Select Admin");
			isError=true;
		}
		
		if(Validation.checkNull(eventname))
		{
			request.setAttribute("eventname","*Plz enter eventname");
			isError=true;
		}
		else
		{
			request.setAttribute("eventname1",eventname);
		}
		if(Validation.checkNull(eventinfo))
		{
			request.setAttribute("eventinfo","*Plz Enter eventinfo");
			isError=true;
		}
		else
		{
			request.setAttribute("eventinfo1",eventinfo);
		}
		if(Validation.checkNull(eventprice))
		{
			request.setAttribute("eventprice","*Plz enter eventprice");
			isError=true;
		}
		else
		{
			request.setAttribute("eventprice1",eventprice);
		}
		if(isError)
		{
		     request.getRequestDispatcher("events.jsp").forward(request, response);	
		}
		else
		{
		
		EventsBean bean=new EventsBean();
		bean.setAdminid(adminid);
		bean.setEventname(eventname);
		bean.setEventinfo(eventinfo);
		bean.setEventprice(eventprice);
		EventsDAO dao=new EventsDAO();
		boolean flag=dao.insertData(bean);
		if(flag)
		{
			System.out.println("Data Inserted...");
            response.sendRedirect("ListEventsController");
		}
		else
		{
			request.getRequestDispatcher("events.jsp").forward(request, response);
		}
		
	}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request, response);
	
	
	}

}
