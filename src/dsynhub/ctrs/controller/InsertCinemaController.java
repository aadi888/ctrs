package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.CinemaBean;
import dsynhub.ctrs.dao.CinemaDAO;
import dsynhub.ctrs.util.Validation;

/**
 * Servlet implementation class InsertCinemaController
 */
public class InsertCinemaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCinemaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session2=request.getSession();
		String adminid1=(String)session2.getAttribute("adminid"); 
		if(adminid1==null){
		request.setAttribute("sessionError","*Your Session Has Been Expied..Log In again..");
		request.getRequestDispatcher("userdetails.jsp").forward(request,response); 
		}
		else{
	 String adminid=request.getParameter("admin");
	 String cityid=request.getParameter("city");
	 String cinemaname=request.getParameter("cinemaname");
	 
	 boolean isError=false;
	 if(Validation.checkNull(adminid))
	 {
		 request.setAttribute("admin","Plz Select Admin");
		 isError=true;
	 }
	 if(Validation.checkNull(cityid))
	 {
		 request.setAttribute("cityid","Plz Select City");
		 isError=true;
	 }
	 if(Validation.checkNull(cinemaname))
	 {
		 request.setAttribute("cinemaname","Plz Enter Cinema Name");
		 isError=true;
	 }
	
	 if(isError)
	 {
		 request.getRequestDispatcher("cinema.jsp").forward(request, response);
	 }
	 else
	 {
      CinemaBean bean=new CinemaBean();
      bean.setAdminid(adminid);
      bean.setCityid(cityid);
      bean.setCinemaname(cinemaname);
      CinemaDAO dao=new CinemaDAO();
      boolean flag=dao.insertData(bean);
      if(flag)
      {
    	  System.out.println("Data Inserted..");
    	  response.sendRedirect("ListCinemaController");
      }
      else
      {
    	  request.getRequestDispatcher("cinema.jsp").forward(request, response);
      }
	 }
	 
	}
	}
}
