package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.MovieBean;
import dsynhub.ctrs.dao.MovieDAO;

/**
 * Servlet implementation class UpdateMovieController
 */
public class UpdateMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMovieController() {
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
		String movieid=request.getParameter("hid");
		String adminid=request.getParameter("admin");
		String moviename=request.getParameter("moviename");
		String director=request.getParameter("director");
		String writer=request.getParameter("writer");
		String music=request.getParameter("music");
		String releasedate=request.getParameter("releasedate");
		String enddate=request.getParameter("enddate");
		
		MovieBean bean=new MovieBean();
		bean.setMovieid(movieid);
		bean.setAdminid(adminid);
		bean.setMoviename(moviename);
		bean.setDirector(director);
		bean.setWriter(writer);
		bean.setMusic(music);
		bean.setReleasedate(releasedate);
		bean.setEnddate(enddate);
		MovieDAO dao=new MovieDAO();
		boolean flag=dao.updateData(bean);
		if(flag)
		{
			System.out.println("Data Updated...");
			request.getRequestDispatcher("ListMovieController").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("ListMovieController").forward(request, response);
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
