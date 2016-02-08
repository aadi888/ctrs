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


public class UpdateAdminController extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session2=request.getSession();
		String adminid1=(String)session2.getAttribute("adminid"); 
		if(adminid1==null){
		request.setAttribute("sessionError","*Your Session Has Been Expied..Log In again..");
		request.getRequestDispatcher("userdetails.jsp").forward(request,response); 
		}
		else{
		String adminid=request.getParameter("hid");
		String emailid=request.getParameter("emailid");
		String password=request.getParameter("password");
		String firstname=request.getParameter("firstname");
		String middlename=request.getParameter("middlename");
		String lastname=request.getParameter("lastname");
		String address=request.getParameter("address");
		
		
			
		
		AdminBean bean=new AdminBean();
		bean.setAdminid(adminid);
		bean.setEmailid(emailid);
		bean.setPassword(password);
		bean.setFirstname(firstname);
		bean.setLastname(lastname);
		bean.setMiddlename(middlename);
		bean.setAddress(address);
		AdminDAO id=new AdminDAO();
		boolean flag=id.updateData(bean);
		if(flag)
		{
			System.out.println("UPDATED");
			request.getRequestDispatcher("ListAdminController").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("ListAdminController").forward(request, response);
		}
	}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

}
