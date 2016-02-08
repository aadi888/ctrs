package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.ScreenBean;
import dsynhub.ctrs.dao.ScreenDAO;
import dsynhub.ctrs.util.Validation;

/**
 * Servlet implementation class InsertScreenController
 */
public class InsertScreenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertScreenController() {
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
		String adminid=request.getParameter("admin");
		String showid=request.getParameter("show");
	    String screenno=request.getParameter("screenno");
	    boolean isError=false;
		if(Validation.checkNull(screenno))
		{
			request.setAttribute("screenno","*Enter Screen no");
			isError=true;
		}
		if(isError)
		{
		request.getRequestDispatcher("screen.jsp").forward(request, response);	
		}
		else
		{
	    ScreenBean bean=new ScreenBean();
	    bean.setAdminid(adminid);
	    bean.setShowid(showid);
	    bean.setScreenno(screenno);
	    ScreenDAO dao=new ScreenDAO();
	    boolean flag=dao.insertData(bean);
	    if(flag)
	    {
	    	System.out.println("Data inserted...");
	    	response.sendRedirect("ListScreenController");
	    }
	    else
	    {
	    	request.getRequestDispatcher("screen.jsp").forward(request, response);
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
