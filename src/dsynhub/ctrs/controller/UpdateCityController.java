package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.CityBean;
import dsynhub.ctrs.dao.CityDAO;

/**
 * Servlet implementation class UpdateCityController
 */
public class UpdateCityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCityController() {
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
		String cityid=request.getParameter("hid");
		String adminid=request.getParameter("admin");
		String stateid=request.getParameter("state");
		String cityname=request.getParameter("cityname");
		CityBean bean=new CityBean();
		bean.setAdminid(adminid);
		bean.setStateid(stateid);
		bean.setCityid(cityid);
		bean.setCityname(cityname);
		CityDAO dao=new CityDAO();
		boolean flag=dao.updateData(bean);
		if(flag)
		{
			System.out.println("Data Updated...");
			request.getRequestDispatcher("ListCityController").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("ListCityController").forward(request, response);
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
