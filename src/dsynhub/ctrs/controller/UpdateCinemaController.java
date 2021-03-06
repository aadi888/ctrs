package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.CinemaBean;
import dsynhub.ctrs.dao.CinemaDAO;

/**
 * Servlet implementation class UpdateCinemaController
 */
public class UpdateCinemaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCinemaController() {
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
		String cinemaid=request.getParameter("hid");
		String adminid=request.getParameter("admin");
		String cityid=request.getParameter("city");
		String cinemaname=request.getParameter("cinemaname");
		CinemaBean bean=new CinemaBean();
		bean.setAdminid(adminid);
		bean.setCityid(cityid);
		bean.setCinemaid(cinemaid);
		bean.setCinemaname(cinemaname);
		CinemaDAO dao=new CinemaDAO();
		boolean flag=dao.updateData(bean);
		if(flag)
		{
			System.out.println("Data Updated...");
			request.getRequestDispatcher("ListCinemaController").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("ListCinemaController").forward(request, response);
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
