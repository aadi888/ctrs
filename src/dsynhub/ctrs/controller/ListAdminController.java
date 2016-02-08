package dsynhub.ctrs.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.AdminBean;
import dsynhub.ctrs.dao.AdminDAO;


public class ListAdminController extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session2=request.getSession();
		String adminid1=(String)session2.getAttribute("adminid"); 
		if(adminid1==null){
		request.setAttribute("sessionError","*Your Session Has Been Expied..Log In again..");
		request.getRequestDispatcher("userdetails.jsp").forward(request,response); 
		}
		else{
		List<AdminBean> list=new ArrayList<AdminBean>();
		AdminDAO id=new AdminDAO();
		list=id.selectData();
		if(list!=null)
		{
			request.setAttribute("list",list);
			request.getRequestDispatcher("listadmin.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("adminregistration.jsp").forward(request, response);
		}
		}
	}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	doPost(request, response);
	}
}