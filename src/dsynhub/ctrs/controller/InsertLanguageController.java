package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.LanguageBean;
import dsynhub.ctrs.dao.LanguageDAO;
import dsynhub.ctrs.util.Validation;

/**
 * Servlet implementation class InsertLanguageController
 */
public class InsertLanguageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertLanguageController() {
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
		String languagename=request.getParameter("languagename");
		 boolean isError=false;
			if(Validation.checkNull(languagename))
			{
				request.setAttribute("languagename","*Enter language name");
				isError=true;
			}
			if(isError)
			{
			request.getRequestDispatcher("language.jsp").forward(request, response);	
			}
			else
			{
		LanguageBean bean=new LanguageBean();
		bean.setAdminid(adminid);
		bean.setLanguagename(languagename);
		LanguageDAO dao=new LanguageDAO();
		boolean flag=dao.insertData(bean);
		if(flag)
		{
			System.out.println("Data Inserted...");
			response.sendRedirect("ListLanguageController");
		}
		else
		{
			request.getRequestDispatcher("language.jsp").forward(request, response);
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
