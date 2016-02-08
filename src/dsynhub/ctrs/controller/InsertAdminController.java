package dsynhub.ctrs.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.AdminBean;
import dsynhub.ctrs.dao.AdminDAO;
import dsynhub.ctrs.util.Validation;


public class InsertAdminController extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 
		HttpSession session2=request.getSession();
		String adminid1=(String)session2.getAttribute("adminid"); 
		
		if(adminid1==null){
		request.setAttribute("sessionError","*Your Session Has Been Expied..Log In again..");
		request.getRequestDispatcher("userdetails.jsp").forward(request,response); 
		}
		else{
		String adminid=request.getParameter("adminid");
		String emailid=request.getParameter("emailid");
		String password=request.getParameter("password");
		String firstname=request.getParameter("firstname");
		String middlename=request.getParameter("middlename");
		String lastname=request.getParameter("lastname");
		String address=request.getParameter("address");
		boolean isError=false;
		if(Validation.checkNull(emailid))
		{
			isError=true;
			request.setAttribute("emailid","*Enter Email Id");
		}
		else
		{
			request.setAttribute("emailid1",emailid);
		}
		if(Validation.checkNull(password))
		{
			isError=true;
			request.setAttribute("password","*Enter password");
		}
		else
		{
			request.setAttribute("password1",password);
		}
		if(Validation.checkNull(firstname))
		{
			isError=true;
			request.setAttribute("firstname","*Enter firstname");
		}
		else
		{
			request.setAttribute("firstname1",firstname);
		}
		if(Validation.checkNull(middlename))
		{
			isError=true;
			request.setAttribute("middlename","*Enter middlename");
		}
		else
		{
			request.setAttribute("middlename1",middlename);
		}
		if(Validation.checkNull(lastname))
		{
			isError=true;
			request.setAttribute("lastname","*Enter lastname");
		}
		else
		{
			request.setAttribute("lastname1",lastname);
		}
		if(Validation.checkNull(address))
		{
			isError=true;
			request.setAttribute("address","*Enter address");
		}
		else
		{
			request.setAttribute("address1",address);
		}
		if(isError)
		{
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
		else
		{
		AdminBean bean=new AdminBean();
		bean.setEmailid(emailid);
		bean.setPassword(password);
		bean.setFirstname(firstname);
		bean.setLastname(lastname);
		bean.setMiddlename(middlename);
		bean.setAddress(address);
		AdminDAO id=new AdminDAO();
		boolean flag=id.insertData(bean);
		if(flag)
		{
			System.out.println("INSERTED");
             response.sendRedirect("ListAdminController");
		}
		else
		{
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
		
		}
		}
		}
	//}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
}