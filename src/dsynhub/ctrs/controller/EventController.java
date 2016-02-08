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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.ctrs.bean.EventBean;
import dsynhub.ctrs.bean.UserdetailsBean;
import dsynhub.ctrs.dao.ExtraDAO;


public class EventController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session12=request.getSession();
		UserdetailsBean bean12=(UserdetailsBean)session12.getAttribute("userdetailsbean");
	    if(bean12==null)
	    {
	    	request.setAttribute("error","*You need to register first");
			request.getRequestDispatcher("userdetails.jsp").forward(request,response); 
			 }
	    else
	    {
	
		String paymentid=request.getParameter("payment");
		String eventid=request.getParameter("eventid");
		String nooftickets=request.getParameter("nooftickets");
		String price=request.getParameter("price");
		String userid=request.getParameter("userid");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String eventname=request.getParameter("eventname");
		String eventinfo=request.getParameter("eventinfo");

		EventBean bean=new EventBean();
		bean.setEventid(eventid);
		bean.setNooftickets(nooftickets);
		bean.setPrice(price);
		bean.setUserid(userid);
		bean.setPaymentid(paymentid);
		
		ExtraDAO dao=new ExtraDAO();
		boolean flag=dao.insertEventData(bean);
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
						+ "\n\n Your Bill is ,"+price+"\n\n Event Name :"+eventname+"\n\n Event Info :"+eventinfo+"\n\n No Of Tickets :"+nooftickets+"\n\nThanks");

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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
