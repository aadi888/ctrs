package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.ctrs.bean.MovieBean;
import dsynhub.ctrs.dao.ExtraDAO;

/**
 * Servlet implementation class home_submit
 */
public class home_submit extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchfield= request.getParameter("search field");
		ExtraDAO dao=new ExtraDAO();
		MovieBean bean=dao.selectMovieData(searchfield);
		if(bean!=null)
		{
			request.setAttribute("bean",bean);
			request.getRequestDispatcher("searchresults.jsp").forward(request, response);
		}
		else
		{
			response.sendRedirect("main.jsp");
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
