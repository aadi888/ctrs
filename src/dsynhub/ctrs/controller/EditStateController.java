package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.StateBean;
import dsynhub.ctrs.dao.StateDao;

/**
 * Servlet implementation class EditStateController
 */
public class EditStateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStateController() {
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
	    String stateid=request.getParameter("sid");
	    
	    StateDao dao=new StateDao();
	    StateBean bean=dao.selectState(stateid);
	    if(bean!=null)
	    {
	    	
	    	
	    	request.setAttribute("bean",bean);
	    	request.getRequestDispatcher("editstate.jsp").forward(request, response);
	    }
	    else
	    {
	    	request.getRequestDispatcher("ListStateController").forward(request, response);
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
