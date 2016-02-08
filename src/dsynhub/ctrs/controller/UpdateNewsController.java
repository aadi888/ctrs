package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.NewsBean;
import dsynhub.ctrs.dao.NewsDAO;

/**
 * Servlet implementation class UpdateNewsController
 */
public class UpdateNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNewsController() {
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
		String newsid=request.getParameter("hid");
		String adminid=request.getParameter("admin");
		String newstitle=request.getParameter("newstitle"); 
		String datecreated=request.getParameter("datecreated"); 
		String validity=request.getParameter("validity");
		
		NewsBean bean=new NewsBean();
		bean.setNewsid(newsid);
		bean.setAdminid(adminid);
		bean.setNewstitle(newstitle);
		bean.setDatecreated(datecreated);
		bean.setValidity(validity);
		NewsDAO dao=new NewsDAO();
		boolean flag=dao.updateData(bean);
		if(flag)
		{
			System.out.println("Data Updated...");
			request.getRequestDispatcher("ListNewsController").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("ListNewsController").forward(request, response);
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
