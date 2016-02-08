package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.BranchBean;
import dsynhub.ctrs.dao.BranchDAO;
import dsynhub.ctrs.util.Validation;

/**
 * Servlet implementation class InsertBranchController
 */
public class InsertBranchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBranchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session2=request.getSession();
		String adminid1=(String)session2.getAttribute("adminid"); 
		if(adminid1==null){
		request.setAttribute("sessionError","*Your Session Has Been Expied..Log In again..");
		request.getRequestDispatcher("userdetails.jsp").forward(request,response); 
		}
		else{
		String cinemaid=request.getParameter("cinema");
		String adminid=request.getParameter("admin");
		
		String branchname=request.getParameter("branchname");
		String branchaddress=request.getParameter("branchaddress");
		boolean isError=false;
		if(Validation.checkNull(branchname))
		{
			request.setAttribute("branchname","Plz Enter Branch");
			isError=true;
		}
		if(Validation.checkNull(branchaddress))
		{
			request.setAttribute("branchaddress","Plz Enter Branch Address");
			isError=true;
		}
		if(isError)
		{
			request.getRequestDispatcher("branch.jsp").forward(request, response);
		}
		else
		{
	     BranchBean bean=new BranchBean();
	     bean.setAdminid(adminid);
	     bean.setCinemaid(cinemaid);
	     bean.setBranchname(branchname);
	     bean.setBranchaddress(branchaddress);
	     BranchDAO dao=new BranchDAO();
	     boolean flag=dao.insertData(bean);
	     if(flag)
	     {
	    	System.out.println("Data Inserted...");
	    	response.sendRedirect("ListBranchController");
	     }
	     else
	     {
	    	 request.getRequestDispatcher("branch.jsp").forward(request, response);
	     }
	}
		}
}
}
