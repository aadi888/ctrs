package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.LanguageBean;
import dsynhub.ctrs.dao.LanguageDAO;

/**
 * Servlet implementation class UpdateLanguageController
 */
public class UpdateLanguageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLanguageController() {
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
		String languageid=request.getParameter("hid");
		String languagename=request.getParameter("languagename");
		String adminid=request.getParameter("admin");
		LanguageBean bean=new LanguageBean();
		bean.setLanguageid(languageid);
		bean.setLanguagename(languagename);
		bean.setAdminid(adminid);
		LanguageDAO dao=new LanguageDAO();
		boolean flag=dao.updateData(bean);
		if(flag)
		{
			System.out.println("Data updated...");
			request.getRequestDispatcher("ListLanguageController").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("ListLanguageController").forward(request, response);
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
