package dsynhub.ctrs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import dsynhub.ctrs.bean.UserdetailsBean;
import dsynhub.ctrs.dao.UserdetailsDAO;

/**
 * Servlet implementation class ListUserdetailsController
 */
public class ListUserdetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUserdetailsController() {
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
		
		List<UserdetailsBean> list=new ArrayList<UserdetailsBean>();
		UserdetailsDAO dao=new UserdetailsDAO();
		list=dao.selectData();
		
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("listuserdetails.jsp").forward(request, response);
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
