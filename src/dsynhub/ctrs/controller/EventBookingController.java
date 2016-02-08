package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.ctrs.bean.EventsBean;
import dsynhub.ctrs.dao.ExtraDAO;

/**
 * Servlet implementation class EventBookingController
 */
public class EventBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventBookingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String eventid=request.getParameter("eventid");
		int nooftickets=Integer.parseInt(request.getParameter("nooftickets"));
		ExtraDAO dao=new ExtraDAO();
		EventsBean bean=dao.selectEventData(eventid);
		int price=nooftickets*Integer.parseInt(bean.getEventprice());
		request.setAttribute("nooftickets",nooftickets);
		request.setAttribute("price",price);
		request.setAttribute("bean",bean);
		request.getRequestDispatcher("eventbill.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
