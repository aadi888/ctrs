package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.BookingBean;
import dsynhub.ctrs.bean.UserdetailsBean;
import dsynhub.ctrs.dao.ExtraDAO;
/**
 * Servlet implementation class BillController
 */
public class BillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] seats=(String[])request.getAttribute("seats");
		int price=0;
		for(int i=0;i<seats.length;i++)
		{
		String seat=seats[i];
		
		char section=seat.charAt(0);
		   if(section=='A' || section=='B' || section=='C' || section=='D' || section=='E' || section=='F' || section=='G' || section=='H' || section=='I' || section=='J' )
		   {
			   price=price+60;
		   }
		   else if(section=='J' || section=='K' || section=='L' || section=='M' || section=='N' || section=='O' || section=='P' || section=='Q' || section=='R' || section=='S' || section=='T')
		   {
			   price=price+100;
		   }
		   else
		   {
			   price=price+140;
		   }
		}
		
		HttpSession session=request.getSession();
		String cityid=(String)session.getAttribute("cityid");
		String moviebranchid=(String)session.getAttribute("moviebranchid");
		String showid=(String)session.getAttribute("showid");
		ExtraDAO dao=new ExtraDAO();
		String cinemaid=dao.selectCinemaId(moviebranchid);
		String screenid=dao.selectScreenId(showid);
		String showdate=(String)dao.selectShowDate(showid);
		BookingBean bean=new BookingBean();
		bean.setCityid(cityid);
	    bean.setCinemaid(cinemaid);
	    bean.setMoviebranchid(moviebranchid);
	    bean.setScreenid(screenid);
	    bean.setShowid(showid);
	    bean.setShowdate(showdate);
	    bean.setPrice(price);
	    bean.setSeats(seats);
	    UserdetailsBean bean12=(UserdetailsBean)session.getAttribute("userdetailsbean");
	    if(bean12==null)
	    {
	    	request.setAttribute("error","*You need to register first");
	    	request.getRequestDispatcher("userdetails.jsp").forward(request, response);
	    }
	    else
	    {
	    
	    String userid=dao.selectUserId(bean12.getEmail());
	    bean.setUserid(userid);
	   
        request.setAttribute("bookingbean",bean);
        request.getRequestDispatcher("moviebill.jsp").forward(request, response);
	    
	    
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
