package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.UserdetailsBean;
import dsynhub.ctrs.dao.UserdetailsDAO;

/**
 * Servlet implementation class UpdateUserdetailsController
 */
public class UpdateUserdetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserdetailsController() {
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
		String userid=request.getParameter("hid");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mobilenumber=request.getParameter("mobilenumber");
		String gender=request.getParameter("gender");
		String cityid=request.getParameter("city");
		UserdetailsBean bean=new UserdetailsBean();
		bean.setCityid(cityid);
		bean.setName(name);
		bean.setEmail(email);
		bean.setGender(gender);
		bean.setMobilenumber(mobilenumber);
        bean.setUserid(userid);
        UserdetailsDAO dao=new UserdetailsDAO();
        boolean flag=dao.updateData(bean);
        if(flag)
        {
        	System.out.println("Data Updated...");
        	request.getRequestDispatcher("ListUserdetailsController").forward(request, response);
        }
        else
        {
        	request.getRequestDispatcher("ListUserdetailsController").forward(request, response);
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
