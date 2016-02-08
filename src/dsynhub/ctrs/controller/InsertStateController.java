package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.dao.StateDao;
import dsynhub.ctrs.util.Validation;

/**
 * Servlet implementation class InsertController
 */
public class InsertStateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session2=request.getSession();
		String adminid1=(String)session2.getAttribute("adminid"); 
		if(adminid1==null){
		request.setAttribute("sessionError","*Your Session Has Been Expied..Log In again..");
		request.getRequestDispatcher("userdetails.jsp").forward(request,response); 
		}
		else{
		String adminid=request.getParameter("admin");
		String statename=request.getParameter("statename");
	    StateDao dao=new StateDao();
	    boolean isError=false;
	    
	    
	    if(Validation.checkNull(statename))
	    {
	    	isError=true;
	    	request.setAttribute("statename","*Enter State Name");
	    	
	    }
	   
	    if(isError)
	    {
	    	request.getRequestDispatcher("state.jsp").forward(request, response);
	    }
	    else
	    {
	    boolean flag=dao.insertState(adminid,statename);
	    if(flag)
	    {
	    	System.out.println("DATA INSERTED..");
              response.sendRedirect("ListStateController");
	    }
	}
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
