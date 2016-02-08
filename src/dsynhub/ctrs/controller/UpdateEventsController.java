package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.EventsBean;
import dsynhub.ctrs.dao.EventsDAO;

public class UpdateEventsController extends HttpServlet {
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
	  String hid=request.getParameter("hid");
	 String eventname=request.getParameter("eventname");
	 String eventinfo=request.getParameter("eventinfo");
	 String eventprice=request.getParameter("eventprice");
	 EventsBean bean=new EventsBean();
	 bean.setAdminid(adminid);
	 bean.setEventid(hid);
	 bean.setEventname(eventname);
	 bean.setEventinfo(eventinfo);
	 bean.setEventprice(eventprice);
	 EventsDAO dao=new EventsDAO();
	 boolean flag=dao.updateData(bean);
	 if(flag)
	 {
		 System.out.println("Data Updated...");
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
