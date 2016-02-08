package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.ScreenBean;
import dsynhub.ctrs.dao.ScreenDAO;

/**
 * Servlet implementation class UpdateScreenController
 */
public class UpdateScreenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateScreenController() {
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
		String screenid=request.getParameter("hid");
		String adminid=request.getParameter("admin");
		String showid=request.getParameter("show");
	    String screenno=request.getParameter("screenno");
	    ScreenBean bean=new ScreenBean();
	    bean.setScreenid(screenid);
	    bean.setAdminid(adminid);
	    bean.setShowid(showid);
	    bean.setScreenno(screenno);
	    ScreenDAO dao=new ScreenDAO();
	    boolean flag=dao.updateData(bean);
	    if(flag)
	    {
	    	System.out.println("Data Updated...");
	    	request.getRequestDispatcher("ListScreenController").forward(request, response);
	    
	    }
	    else
	    {
	    	request.getRequestDispatcher("ListScreenController").forward(request, response);
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
