package com.skynet.infrastructure;


import java.net.URISyntaxException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class DefaultSMTPService extends InfraBaseService implements SMTPService {

	public DefaultSMTPService() {
		// TODO Auto-generated constructor stub
	}
	private class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
           String username = "report@bettbio.com";
           String password = getPassword();
           
           System.out.print("really called here!");
           return new PasswordAuthentication(username, password);
        }
        protected String getPassword(){
        	return System.getenv("SMTP_PASSWORD");
        }
    }
	
	public void send(String to, String subject, String content){
		try {
			sendEmail( to,  subject,  content);
		} catch (Exception e) {
			System.out.println("Issue when sending message: "+ e);
		}
	}
	protected boolean sendEmail(String to, String subject, String content) throws URISyntaxException, Exception {

		Properties mailProps = new Properties();
        mailProps.put("mail.smtp.from", "report@bettbio.com");
        mailProps.put("mail.smtp.host", "smtp.bettbio.com");
        mailProps.put("mail.smtp.port", 25);
        mailProps.put("mail.smtp.auth", "true");
        //mailProps.put("mail.smtp.socketFactory.port", port);
        //mailProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        //mailProps.put("mail.smtp.socketFactory.fallback", "false");
        //mailProps.put("mail.smtp.starttls.enable", "true");
        SMTPAuthenticator auth = new SMTPAuthenticator();
		Session session = Session.getInstance(mailProps,  auth);
		session.setDebug(true);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("report@bettbio.com"));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		//String content = value + "! product price has been changed ";
		msg.setSubject(subject);
		msg.setText(content);

		// Send the message
		Transport.send(msg);
		return true;

	}
}
