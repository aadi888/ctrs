package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.ShowBean;
import dsynhub.ctrs.dao.ShowDAO;

/**
 * Servlet implementation class UpdateShowController
 */
public class UpdateShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShowController() {
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
		String showid=request.getParameter("hid");
		String moviebranchid=request.getParameter("moviebranch");
		String adminid=request.getParameter("admin");
		String showdate=request.getParameter("date")+" "+request.getParameter("time");
		ShowBean bean=new ShowBean();
		bean.setShowid(showid);
		bean.setAdminid(adminid);
		bean.setMoviebranchid(moviebranchid);
		bean.setShowdate(showdate);
		ShowDAO dao=new ShowDAO();
		boolean flag=dao.updateData(bean);
		if(flag)
		{
			System.out.println("Data updated...");
			request.getRequestDispatcher("ListShowController").forward(request, response);

		}
		else
		{

			request.getRequestDispatcher("ListShowController").forward(request, response);
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
