package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.MoviebranchBean;
import dsynhub.ctrs.dao.MoviebranchDAO;

/**
 * Servlet implementation class InsertMoviebranchController
 */
public class InsertMoviebranchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMoviebranchController() {
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
		String branchid=request.getParameter("branch");
		String movieid=request.getParameter("movie");
		MoviebranchBean bean=new MoviebranchBean();
		bean.setAdminid(adminid);
		bean.setBranchid(branchid);
		bean.setMovieid(movieid);
		MoviebranchDAO dao=new MoviebranchDAO();
		boolean flag=dao.insertData(bean);
		if(flag)
		{
	        System.out.println("Data inserted...");	
	        response.sendRedirect("ListMoviebranchController");
		}
		else
		{
		request.getRequestDispatcher("moviebranch.jsp").forward(request, response);
	}
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
