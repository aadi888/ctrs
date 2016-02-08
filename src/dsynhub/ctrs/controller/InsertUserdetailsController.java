package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.UserdetailsBean;
import dsynhub.ctrs.dao.UserdetailsDAO;
import dsynhub.ctrs.util.Validation;

/**
 * Servlet implementation class InsertUserdetailsController
 */
public class InsertUserdetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUserdetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String mobilenumber=request.getParameter("mobilenumber");
		String gender=request.getParameter("gender");
		String cityid=request.getParameter("city");
		boolean isError=false;
		if(Validation.checkNull(name))
		{
			isError=true;
			request.setAttribute("name","Plz Enter Name:");
		}
		if(Validation.checkNull(email))
		{
			isError=true;
			request.setAttribute("email","Plz Enter email:");
		}
		if(Validation.checkNull(password))
		{
			isError=true;
			request.setAttribute("password","Plz Enter password:");
		}
		if(Validation.checkNull(mobilenumber))
		{
			isError=true;
			request.setAttribute("mobilenumber","Plz Enter mobilenumber:");
		}
		if(Validation.checkNull(cityid))
		{
			isError=true;
			request.setAttribute("city","Plz Select city:");
		}
		if(isError)
		{
			request.getRequestDispatcher("userdetails.jsp").forward(request, response);
		}
		else
		{
		UserdetailsBean bean=new UserdetailsBean();
		bean.setCityid(cityid);
		bean.setName(name);
		bean.setEmail(email);
		bean.setPassword(password);
		bean.setGender(gender);
		bean.setMobilenumber(mobilenumber);
		UserdetailsDAO dao=new UserdetailsDAO();
		boolean flag=dao.insertData(bean);
		if(flag)
		{
			System.out.println("Data inserted...");
			HttpSession session=request.getSession();
			session.setAttribute("userdetailsbean",bean);
			request.getRequestDispatcher("main1.jsp").forward(request, response);
			//response.sendRedirect("ListUserdetailsController");
		}
		else
		{
			request.getRequestDispatcher("userdetails.jsp").forward(request, response);
			
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
