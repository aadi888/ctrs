package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.CityBean;
import dsynhub.ctrs.dao.CityDAO;
import dsynhub.ctrs.util.Validation;

/**
 * Servlet implementation class InsertCityController
 */
public class InsertCityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCityController() {
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
		String stateid=request.getParameter("state");
		String cityname=request.getParameter("city");
		boolean isError=false;
		if(stateid.equals("0"))
		{
			request.setAttribute("stateid","*Plz Select State");
			isError=true;
		}
		else
		{
			request.setAttribute("stateid1", stateid);
		}
		
		if(Validation.checkNull(cityname))
		{
			request.setAttribute("cityname","*Plz Enter City Name");
			isError=true;
		}
		else
		{
			request.setAttribute("cityname1",cityname);
		}
		if(isError)
		{
			request.getRequestDispatcher("city.jsp").forward(request, response);
		}
		else
		{
		CityBean bean=new CityBean();
		bean.setAdminid(adminid);
		bean.setStateid(stateid);
		bean.setCityname(cityname);
		CityDAO dao=new CityDAO();
		boolean flag=dao.insertData(bean);
		if(flag)
		{
			System.out.println("Data Inserted");
			response.sendRedirect("ListCityController");
		}
		else
		{
			request.getRequestDispatcher("city.jsp").forward(request, response);
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
