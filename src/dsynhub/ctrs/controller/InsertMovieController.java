package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.MovieBean;
import dsynhub.ctrs.dao.MovieDAO;
import dsynhub.ctrs.util.Validation;

/**
 * Servlet implementation class InsertMovieController
 */
public class InsertMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMovieController() {
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
		String moviename=request.getParameter("moviename");
		String director=request.getParameter("director");
		String writer=request.getParameter("writer");
		String music=request.getParameter("music");
		String releasedate=request.getParameter("releasedate");
		String enddate=request.getParameter("enddate");
		boolean isError=false;
		if(Validation.checkNull(moviename))
		{
			request.setAttribute("moviename","*Enter Movie Name");
			isError=true;
		}
		else
		{
			request.setAttribute("moviename1",moviename);
		}
		if(Validation.checkNull(director))
		{
			request.setAttribute("director","*Enter director Name");
			isError=true;
		}
		else
		{
			request.setAttribute("director1",director);
		}
		if(Validation.checkNull(writer))
		{
			request.setAttribute("writer","*Enter writer Name");
			isError=true;
		}
		else
		{
			request.setAttribute("writer1",writer);
		}
		
		if(Validation.checkNull(music))
		{
			request.setAttribute("music","*Enter music Name");
			isError=true;
		}
		else
		{
			request.setAttribute("music1",music);
		}
		
		if(Validation.checkNull(releasedate))
		{
			request.setAttribute("releasedate","*Enter Release Date");
			isError=true;
		}
		else
		{
			request.setAttribute("releasedate1",releasedate);
		}
		
		if(Validation.checkNull(enddate))
		{
			request.setAttribute("enddate","*Enter End Date");
			isError=true;
		}
		else
		{
			request.setAttribute("enddate1",enddate);
		}
		
		if(isError)
		{
			request.getRequestDispatcher("movie.jsp").forward(request, response);
		}
		else
		{
			
		
		
		MovieBean bean=new MovieBean();
		bean.setAdminid(adminid);
		bean.setMoviename(moviename);
		bean.setDirector(director);
		bean.setWriter(writer);
		bean.setMusic(music);
		bean.setReleasedate(releasedate);
		bean.setEnddate(enddate);
		MovieDAO dao=new MovieDAO();
		boolean flag=dao.insertData(bean);
		
		if(flag)
		{
			System.out.println("Data Inserted...");
			response.sendRedirect("ListMovieController");
		}
		else
		{
			request.getRequestDispatcher("movie.jsp").forward(request, response);
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
