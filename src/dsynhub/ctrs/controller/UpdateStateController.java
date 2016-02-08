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
 * Servlet implementation class UpdateStateController
 */
public class UpdateStateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session2=request.getSession();
		String adminid1=(String)session2.getAttribute("adminid"); 
		if(adminid1==null){
		request.setAttribute("sessionError","*Your Session Has Been Expied..Log In again..");
		request.getRequestDispatcher("userdetails.jsp").forward(request,response); 
		}
		else{
		String stateid=request.getParameter("stateid");
       String adminid=request.getParameter("admin");
        String statename=request.getParameter("statename");
        boolean isError=false;
        if(Validation.checkNull(statename))
        {
        	request.setAttribute("statename", "Enter State");
        	isError=true;
        }
        if(isError)
        {
        	request.getRequestDispatcher("EditStateController").forward(request, response);
        }
        else
        {
        	
        
        
        StateDao dao=new StateDao();
        boolean flag=dao.updateStateData(stateid,statename,adminid);
        if(flag)
        {
        	System.out.println("Data Updated...");
        	request.getRequestDispatcher("ListStateController").forward(request, response);
        }
        else
        {
        	request.getRequestDispatcher("EditStateController").forward(request, response);
        }
	}
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
