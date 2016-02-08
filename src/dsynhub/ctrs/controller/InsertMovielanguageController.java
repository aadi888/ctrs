package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.MovielanguageBean;
import dsynhub.ctrs.dao.MovielanguageDAO;

/**
 * Servlet implementation class InsertMovielanguageController
 */
public class InsertMovielanguageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMovielanguageController() {
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
		String movieid=request.getParameter("movie");
		String languageid=request.getParameter("language");
		MovielanguageBean bean=new MovielanguageBean();
		bean.setAdminid(adminid);
		bean.setMovieid(movieid);
		bean.setLanguageid(languageid);
		MovielanguageDAO dao=new MovielanguageDAO();
		boolean flag=dao.insertData(bean);
		if(flag)
		{
			System.out.println("Data inserted...");
			response.sendRedirect("ListMovielanguageController");
		}
		else
		{
			request.getRequestDispatcher("movielanguage.jsp").forward(request, response);
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
