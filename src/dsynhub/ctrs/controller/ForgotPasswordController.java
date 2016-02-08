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

import dsynhub.ctrs.dao.ExtraDAO;
import dsynhub.ctrs.util.Validation;

/**
 * Servlet implementation class ForgotPasswordController
 */
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mobilenumber=request.getParameter("mobilenumber");
		boolean isError=false;
		if(Validation.checkNull(name))
		{
			request.setAttribute("name","*Plz enter name");
			isError=true;
		}
		if(Validation.checkNull(email))
		{
			request.setAttribute("email","*Plz Enter email");
			isError=true;
		}
		if(Validation.checkNull(mobilenumber))
		{
			request.setAttribute("mobilenumber","*Plz enter mobile number ");
			isError=true;
		}
		if(isError)
		{
		     request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);	
		}
		else
		{

		ExtraDAO dao=new ExtraDAO();
		String password=dao.sendPassword(name,email,mobilenumber);
		if(password==null)
		{
			request.setAttribute("error","*You are not registered");
			request.getRequestDispatcher("userdetails.jsp").forward(request, response);
		}
		else
		{
			String to = email;
			final String username = "cinematicket97@gmail.com";
			final String password12= "meetparikh";
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
							return new PasswordAuthentication(username, password12);
						}
					});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(email));
				message.setSubject("Testing Subject");
				message.setText("Dear ,"+name
						+ "\n\n Your Password is ,"+password+"\n\nThanks");

				Transport.send(message);

				System.out.println("Thanks For Using...");
				request.getRequestDispatcher("userdetails.jsp").forward(request, response);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
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
