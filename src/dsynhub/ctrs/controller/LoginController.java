package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.AdminBean;
import dsynhub.ctrs.bean.UserdetailsBean;
import dsynhub.ctrs.dao.ExtraDAO;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		ExtraDAO dao=new ExtraDAO();
	    AdminBean adminbean=dao.checkAdmin(username,password);
	    UserdetailsBean userbean=dao.checkRegisteredUsers(username,password);
	    if(adminbean==null && userbean==null)
	    {
	    	request.setAttribute("loginerror","* You Are Not Registered");
	    	request.getRequestDispatcher("userdetails.jsp").forward(request, response);
	    }
	    
	    else if(adminbean!=null)
	    {
	    	HttpSession session=request.getSession();
	    	session.setAttribute("adminid",adminbean.getAdminid());
	    	request.getRequestDispatcher("index.jsp").forward(request, response);
	    }
	    else if(userbean!=null)
	    {
	    	HttpSession session=request.getSession();
	    	session.setAttribute("userdetailsbean",userbean);
	    	request.getRequestDispatcher("main1.jsp").forward(request, response);
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
