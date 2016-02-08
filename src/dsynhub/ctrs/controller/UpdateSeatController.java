package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.SeatBean;
import dsynhub.ctrs.dao.SeatDAO;

/**
 * Servlet implementation class UpdateSeatController
 */
public class UpdateSeatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSeatController() {
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
		String screenid=request.getParameter("screen");
		String seatno=request.getParameter("seatno");
		String seatid=request.getParameter("hid");
		SeatBean bean=new SeatBean();
		bean.setAdminid(adminid);
		bean.setScreenid(screenid);
		bean.setSeatno(seatno);
		bean.setSeatid(seatid);
		SeatDAO dao=new SeatDAO();
		boolean flag=dao.updateData(bean);
		if(flag)
		{
			System.out.println("Data Updated...");
			request.getRequestDispatcher("ListSeatController").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("ListSeatController").forward(request, response);
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