package dsynhub.ctrs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import dsynhub.ctrs.bean.SeatBean;
import dsynhub.ctrs.bean.UserdetailsBean;

/**
 * Servlet implementation class CheckSeatController
 */
public class CheckSeatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckSeatController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] seats=request.getParameterValues("seats");
		String moviebranchid=(String)request.getParameter("moviebranchid");
		String showid=(String)request.getParameter("showid");
		
        if(seats==null)
        {
        	HttpSession session=request.getSession();
    		session.setAttribute("moviebranchid", moviebranchid);
    		session.setAttribute("showid",showid);
        	request.setAttribute("error","Plz Select Seats");
        	request.getRequestDispatcher("seats.jsp").forward(request, response);
        }
        else
        {
        	HttpSession session=request.getSession();
    		session.setAttribute("moviebranchid", moviebranchid);
    		session.setAttribute("showid",showid);
             request.setAttribute("seats",seats);
             request.getRequestDispatcher("BillController").forward(request, response);
        	
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
