package dsynhub.ctrs.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.print.DocFlavor.STRING;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.BookingBean;
import dsynhub.ctrs.bean.UserdetailsBean;
import dsynhub.ctrs.dao.ExtraDAO;

/**
 * Servlet implementation class MovieBookingController
 */
public class MovieBookingController extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session12=request.getSession();
		UserdetailsBean bean12=(UserdetailsBean)session12.getAttribute("userdetailsbean");
	    if(bean12==null)
	    {
	    	request.setAttribute("error","*You need to register first");
	    	request.getRequestDispatcher("userdetails.jsp").forward(request, response);
	    }
	    else
	    {
	    String paymentid=request.getParameter("payment");
	    String name=request.getParameter("name");
	    String price=request.getParameter("price");
	    String email=request.getParameter("email");
	    String mobilenumber=request.getParameter("mobilenumber");
	    String cityname=request.getParameter("cityname");
	    String cityid=request.getParameter("cityid");
	    String cinemaid=request.getParameter("cinemaid");
	    String moviebranchid=request.getParameter("moviebranchid");
	    String screenid=request.getParameter("screenid");
	    String showid=request.getParameter("showid");
	    String cinemabranch=request.getParameter("cinemabranch");
	    String moviename=request.getParameter("moviename");
	    String showdate=request.getParameter("showdate");
	    String userid=request.getParameter("userid");
	    String seat=request.getParameter("seat");
	    String screenno=request.getParameter("screenno");
	    BookingBean bean=new BookingBean();
	    bean.setCityid(cityid);
	    bean.setCinemaid(cinemaid);
	    bean.setMoviebranchid(moviebranchid);
	    bean.setScreenid(screenid);
	    bean.setShowid(showid);
	    bean.setShowdate(showdate);
	    bean.setPrice1(price);
	    bean.setUserid(userid);
	    bean.setSeat(seat);
	    bean.setPaymentid(paymentid);
	    
		ExtraDAO dao=new ExtraDAO();
		boolean flag=dao.insertData(bean);
		if(flag)
		{
			System.out.println("Data Inserted...");
			String to = email;
			final String username = "cinematicket97@gmail.com";
			final String password = "meetparikh";
			String from = "cinematicket97@gmail.com";

			Properties props = System.getProperties();  
	        props.setProperty("mail.smtp.port", "587");  
	        props.setProperty("mail.smtp.socketFactory.port", "587");  
	        props.setProperty("mail.smtp.host", "smtp.gmail.com");  
	        props.setProperty("mail.smtp.starttls.enable", "true");  
	        props.setProperty("mail.smtp.auth", "true"); 
	        
			/*Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");*/

			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(email));
				message.setSubject("Testing Subject");
				message.setText("Dear ,"+name
						+ "\n\n Your Bill is ,"+price+"\n\n Cinema And Branch :"+cinemabranch+"\n\n Movie :"+moviename+"\n\n Show Date And Time :"+showdate+"\n\n Screen :"+screenno+"\n\n Seats :"+seat +"\n\nThanks");

				Transport.send(message);

				System.out.println("Thanks For Using...");
				request.getRequestDispatcher("main.jsp").forward(request, response);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}


		}
		else
		{
			System.out.println("Not Done...");
			response.sendRedirect("main.jsp");
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
