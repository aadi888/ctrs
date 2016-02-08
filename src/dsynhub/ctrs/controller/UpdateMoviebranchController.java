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
 * Servlet implementation class UpdateMoviebranchController
 */
public class UpdateMoviebranchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMoviebranchController() {
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
		String moviebranchid=request.getParameter("hid");
		MoviebranchBean bean=new MoviebranchBean();
		bean.setMoviebranchid(moviebranchid);
		bean.setAdminid(adminid);
		bean.setBranchid(branchid);
		bean.setMovieid(movieid);
		MoviebranchDAO dao=new MoviebranchDAO();
		boolean flag=dao.updateData(bean);
		if(flag)
		{
	        System.out.println("Data updated...");	
	        request.getRequestDispatcher("ListMoviebranchController").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("ListMoviebranchController").forward(request, response);
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
