package dsynhub.ctrs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dsynhub.ctrs.bean.UserdetailsBean;
import dsynhub.ctrs.dao.UserdetailsDAO;

/**
 * Servlet implementation class PaymentController
 */
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
			
		
			String seats[]=request.getParameterValues("seats");
			if(seats.length>0)
			{
				int length=seats.length;
				String id=request.getParameter("hid");
				UserdetailsDAO dao=new UserdetailsDAO();
				UserdetailsBean bean=dao.selectInfo(id);
				
				if(bean!=null)
				{
					request.setAttribute("length",length);
				 request.setAttribute("bean",bean);
				request.getRequestDispatcher("bill.jsp").forward(request, response);
				
			}
			else
			{
				request.getRequestDispatcher("seats.jsp").forward(request, response);
			}
		
	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
}
