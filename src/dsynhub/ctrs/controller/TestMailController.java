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

/**
 * Servlet implementation class TestMailController
 */
public class TestMailController extends HttpServlet {
	
	
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String finalamount = request.getParameter("finalamount");
		// Recipient's email ID needs to be mentioned.
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
					+ "\n\n Your Bill is ,"+finalamount+"\n\nThanks");

			Transport.send(message);

			System.out.println("Thanks For Using...");
			request.getRequestDispatcher("userdetails.jsp").forward(request, response);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}
