package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import dsynhub.ctrs.dao.CinemaDAO;

/**
 * Servlet implementation class EnterCityController
 */
public class EnterCityController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String city=request.getParameter("city");
		//System.out.println(city); 
		CinemaDAO dao5=new CinemaDAO();
		boolean flag=dao5.selectCity(city);
		if(flag){
		HttpSession session=request.getSession();
		String cityid=dao5.selectCityid(city);
		session.setAttribute("cityid",cityid); 
		request.getRequestDispatcher("main.jsp").forward(request, response);
		}
		else
		{ 
		response.sendRedirect("main1.jsp"); 
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
