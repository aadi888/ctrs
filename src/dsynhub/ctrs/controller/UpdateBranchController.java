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
 * Servlet implementation class UpdateBranchController
 */
public class UpdateBranchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBranchController() {
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
		String adminid=request.getParameter("admin");
		String cinemaid=request.getParameter("cinema");
		String branchname=request.getParameter("branchname");
		String branchaddress=request.getParameter("branchaddress");
		BranchBean bean=new BranchBean();
		bean.setBranchid(branchid);
		bean.setBranchname(branchname);
		bean.setBranchaddress(branchaddress);
		bean.setCinemaid(cinemaid);
		bean.setAdminid(adminid);
		BranchDAO dao=new BranchDAO();
		boolean flag=dao.updateData(bean);
		if(flag)
		{
			System.out.println("Data updated...");
			request.getRequestDispatcher("ListBranchController").forward(request, response);
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
