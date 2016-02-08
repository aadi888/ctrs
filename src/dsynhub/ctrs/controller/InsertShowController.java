package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.ShowBean;
import dsynhub.ctrs.dao.ShowDAO;
import dsynhub.ctrs.util.Validation;

/**
 * Servlet implementation class InsertShowController
 */
public class InsertShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertShowController() {
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
		String moviebranchid=request.getParameter("moviebranch");
		String adminid=request.getParameter("admin");
		String showdate=request.getParameter("date")+" "+request.getParameter("time");
		boolean isError=false;
		if(Validation.checkNull(showdate))
		{
			request.setAttribute("showdate","*Enter Show Date");
			isError=true;
		}
		
		if(isError)
		{
			request.getRequestDispatcher("show.jsp").forward(request, response);
		}
		else
		{
		ShowBean bean=new ShowBean();
		bean.setAdminid(adminid);
		bean.setMoviebranchid(moviebranchid);
		bean.setShowdate(showdate);
		ShowDAO dao=new ShowDAO();
		boolean flag=dao.insertData(bean);
		if(flag)
		{
			System.out.println("Data inserted...");
			response.sendRedirect("ListShowController");
		}
		else
		{
			request.getRequestDispatcher("show.jsp").forward(request, response);
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
