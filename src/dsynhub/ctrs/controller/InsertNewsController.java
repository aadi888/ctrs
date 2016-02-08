package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.NewsBean;
import dsynhub.ctrs.dao.NewsDAO;
import dsynhub.ctrs.util.Validation;


public class InsertNewsController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session2=request.getSession();
		String adminid1=(String)session2.getAttribute("adminid"); 
		if(adminid1==null){
		request.setAttribute("sessionError","*Your Session Has Been Expied..Log In again..");
		request.getRequestDispatcher("userdetails.jsp").forward(request,response); 
		}
		else{
	 String adminid=request.getParameter("admin");
	 String newstitle=request.getParameter("newstitle");
	 String datecreated=request.getParameter("datecreated");
	 String validity=request.getParameter("validity");
	 boolean isError=false;
	 if(Validation.checkNull(newstitle))
	 {
		 request.setAttribute("newstitle","*plz enter news title");
		 isError=true;
	 }
	 else
	 {
		 request.setAttribute("newstitle1", newstitle);
	 }
	 if(Validation.checkNull(validity))
	 {
		 request.setAttribute("validity","*plz enter validity");
		 isError=true;
	 }
	 else
	 {
		 request.setAttribute("validity1",validity);
	 }
	 if(isError)
	 {
		 request.getRequestDispatcher("news.jsp").forward(request, response);
	 }
	 else
	 {
	 
	 
	 NewsBean bean=new NewsBean();
	 bean.setAdminid(adminid);
	 bean.setNewstitle(newstitle);
	 bean.setDatecreated(datecreated);
	 bean.setValidity(validity);
	 
	 NewsDAO dao=new NewsDAO();
	 boolean flag=dao.insertData(bean);
	 if(flag)
	 {
		 System.out.println("Data Inserted...");
		 response.sendRedirect("ListNewsController");
	 }
	 else
	 {
		 request.getRequestDispatcher("news.jsp").forward(request, response);
	 }
	 }
	 	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 doGet(request, response);
	}

}
