package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.BranchBean;
import dsynhub.ctrs.dao.BranchDAO;

/**
 * Servlet implementation class EditBranchController
 */
public class EditBranchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBranchController() {
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
		String branchid=request.getParameter("hid");
		BranchDAO dao=new BranchDAO();
		BranchBean bean=dao.selectData(branchid);
		if(bean!=null)
		{
			request.setAttribute("bean",bean);
			request.getRequestDispatcher("editbranch.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("ListBranchController").forward(request, response);
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
