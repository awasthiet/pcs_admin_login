package utility;


import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class SendMail {

	String emailType = "nMail";
	String liveTVEmail = "gmail";

	public void sentReportMail(String emailSubject,Object messsageBody)
	{
		if(emailType.equalsIgnoreCase("nMail"))
		{
			String[] sendTo = new String[]{"lavish.mehta@timesinternet.in", "abhinav.singal@timesinternet.in", "Nityananda.Ghosh@timesinternet.in","Virkin.Malla@timesinternet.in","Cmsonduty@timesinternet.in", "harshit.awasthi@timesinternet.in"};
			//			String[] sendTo = new String[]{"chirag.singh@timesinternet.in","chirag.singh@timesinternet.in","chirag.singh@timesinternet.in","chirag.singh@timesinternet.in"};
			String usernameSendFrom = "Please_do_not_reply(ET Automation Report)";

			// Get session object

			boolean flag=false;
			for(int j=1;j<=10;j++)
			{
				Properties props = new Properties();
				props.put("mail.smtp.host", "nmailer.indiatimes.com");  
				props.put("mail.smtp.socketFactory.port","25");  
				System.out.println("j => "+j);

				Session session = Session.getDefaultInstance(props);


				//compose message

				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(usernameSendFrom));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[0]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[1]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[2]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[3]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[4]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[5]));
					message.setSubject(emailSubject);

					// text with html
					message.setContent(messsageBody,"text/html");

					// send Mail
					Transport.send(message);

					System.out.println("Failed Email sent successfully to "+ sendTo[0]);
					flag=true;
				} 
				catch (Exception e) {
					//e.printStackTrace();
					System.out.println("Trying attempt "+j+"\n"+e.getMessage());
				}
				if(flag)
				{
					break;
				}
			}
		} else if(emailType.equalsIgnoreCase("gmail"))
		{
			String[] sendTo = new String[]{"lavish.mehta@timesinternet.in", "abhinav.singal@timesinternet.in", "Nityananda.Ghosh@timesinternet.in","Virkin.Malla@timesinternet.in","Cmsonduty@timesinternet.in", "harshit.awasthi@timesinternet.in"};
			//			String[] sendTo = new String[]{"chirag.singh@timesinternet.in","chirag.singh@timesinternet.in","chirag.singh@timesinternet.in"};
			String usernameSendFrom = "timesinternetlimitedcompany@gmail.com";
			String passwordSendFrom = "times@123";

			// Get session object

			boolean flag=false;
			for(int j=1;j<=10;j++)
			{
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");  
				props.put("mail.smtp.socketFactory.port","465");  
				props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
				props.put("mail.smtp.auth", "true");  
				props.put("mail.smtp.port", "465");

				Session session = Session.getDefaultInstance(props,new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication ()
					{
						return new PasswordAuthentication(usernameSendFrom, passwordSendFrom);
					}
				});


				//compose message

				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(usernameSendFrom));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[0]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[1]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[2]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[3]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[4]));
					message.setSubject(emailSubject);

					// text with html
					message.setContent(messsageBody,"text/html");

					// send Mail
					Transport.send(message);

					System.out.println("Failed Email sent successfully to "+ sendTo[0]);
					flag=true;
				} 
				catch (Exception e) {
					//e.printStackTrace();
					System.out.println("Trying attempt "+j+"\n"+e.getMessage());
				}
				if(flag)
				{
					break;
				}
			}
		}
	}

	/*
	public void sentLoginReportMail(String emailSubject,Object messsageBody)
	{
//		String[] sendTo = new String[]{"chirag.singh@timesinternet.in","Nityananda.Ghosh@timesinternet.in","Virkin.Malla@timesinternet.in","Amit.Chouhan@timesinternet.in","Gyan.Mittal@timesinternet.in"};
//		String[] sendTo = new String[]{"chirag.singh@timesinternet.in","chirag.singh@timesinternet.in","chirag.singh@timesinternet.in","chirag.singh@timesinternet.in","chirag.singh@timesinternet.in"};
		String[] sendTo = new String[]{"chirag.singh@timesinternet.in","Nityananda.Ghosh@timesinternet.in","Virkin.Malla@timesinternet.in","Cmsonduty@timesinternet.in"};
		String usernameSendFrom = "timesinternetlimitedcompany@gmail.com";
		String passwordSendFrom = "times@123";

		// Get session object

		boolean flag=false;
		for(int j=1;j<=10;j++)
		{
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");  
			props.put("mail.smtp.socketFactory.port","465");  
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
			props.put("mail.smtp.auth", "true");  
			props.put("mail.smtp.port", "465");

			Session session = Session.getDefaultInstance(props,new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication ()
				{
					return new PasswordAuthentication(usernameSendFrom, passwordSendFrom);
				}
			});


			//compose message

				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(usernameSendFrom));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[0]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[1]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[2]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[3]));
//					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[4]));
					message.setSubject(emailSubject);

					// text with html
					message.setContent(messsageBody,"text/html");

					// send Mail
					Transport.send(message);

					System.out.println("Failed Email sent successfully to "+ sendTo[0]);
					flag=true;
				} 
				catch (Exception e) {
					//e.printStackTrace();
					System.out.println("Trying attempt "+j+"\n"+e.getMessage());
				}
			if(flag)
			{
				break;
			}
		} 
	} */

	public void sendEmailWithAttachment(String emailSubject,Object messsageBody,String fileName,String setFileName)
	{
		if(emailType.equalsIgnoreCase("nMail"))
		{
			String[] sendTo = new String[]{"lavish.mehta@timesinternet.in", "abhinav.singal@timesinternet.in", "Nityananda.Ghosh@timesinternet.in","Virkin.Malla@timesinternet.in"};
			//			String[] sendTo = new String[]{"chirag.singh@timesinternet.in","chirag.singh@timesinternet.in","chirag.singh@timesinternet.in"};
			String usernameSendFrom = "Please_do_not_reply(ET Automation Report)";

			// Get session object

			boolean flag=false;
			for(int j=1;j<=10;j++)
			{
				Properties props = new Properties();
				props.put("mail.smtp.host", "nmailer.indiatimes.com");  
				props.put("mail.smtp.socketFactory.port","25");  
				System.out.println("j => "+j);

				Session session = Session.getDefaultInstance(props);

				//compose message
				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(usernameSendFrom));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[0]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[1]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[2]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[3]));
					message.setSubject(emailSubject);

					BodyPart msgBody1 = new MimeBodyPart();
					msgBody1.setContent(messsageBody,"text/html");

					// create MimeBodyPart object and set DataHandler object
					BodyPart msgBody2 = new MimeBodyPart();
					DataSource source = new FileDataSource(fileName);
					msgBody2.setDataHandler(new DataHandler(source));
					msgBody2.setFileName(setFileName);

					// create multipart object and add MimeBodyPart object to this object
					Multipart multiPart = new MimeMultipart();
					multiPart.addBodyPart(msgBody1);
					multiPart.addBodyPart(msgBody2);

					// set multipart object to the message object
					message.setContent(multiPart);

					// send Mail
					Transport.send(message);

					System.out.println("Email sent successfully to "+ sendTo[0]);
					flag=true;
				} 
				catch (Exception e) {
					//e.printStackTrace();
					System.out.println("Trying attempt "+j+"\n"+e.getMessage());
				}
				if(flag)
				{
					break;
				}
			}
		} else if(emailType.equalsIgnoreCase("gmail"))
		{
			String[] sendTo = new String[]{"lavish.mehta@timesinternet.in", "abhinav.singal@timesinternet.in", "Nityananda.Ghosh@timesinternet.in","Virkin.Malla@timesinternet.in"};
			String usernameSendFrom = "timesinternetlimitedcompany@gmail.com";
			String passwordSendFrom = "times@123";

			// Get session object

			boolean flag=false;
			for(int j=1;j<=10;j++)
			{
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");  
				props.put("mail.smtp.socketFactory.port","465");  
				props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
				props.put("mail.smtp.auth", "true");  
				props.put("mail.smtp.port", "465");

				Session session = Session.getDefaultInstance(props,new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication ()
					{
						return new PasswordAuthentication(usernameSendFrom, passwordSendFrom);
					}
				});


				//compose message
				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(usernameSendFrom));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[0]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[1]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[2]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[3]));
					message.setSubject(emailSubject);

					BodyPart msgBody1 = new MimeBodyPart();
					msgBody1.setContent(messsageBody,"text/html");

					// create MimeBodyPart object and set DataHandler object
					BodyPart msgBody2 = new MimeBodyPart();
					DataSource source = new FileDataSource(fileName);
					msgBody2.setDataHandler(new DataHandler(source));
					msgBody2.setFileName(setFileName);

					// create multipart object and add MimeBodyPart object to this object
					Multipart multiPart = new MimeMultipart();
					multiPart.addBodyPart(msgBody1);
					multiPart.addBodyPart(msgBody2);

					// set multipart object to the message object
					message.setContent(multiPart);

					// send Mail
					Transport.send(message);

					System.out.println("Email sent successfully to "+ sendTo[0]);
					flag=true;
				} 
				catch (Exception e) {
					//e.printStackTrace();
					System.out.println("Trying attempt "+j+"\n"+e.getMessage());
				}
				if(flag)
				{
					break;
				}
			}
		}
	}

	public void sendEmailWithAttachmentQA(String[] sendTo,String emailSubject,Object messsageBody,String fileName,String setFileName,String fileName1,String setFileName1)
	{
		if(liveTVEmail.equalsIgnoreCase("nMail"))
		{
			String usernameSendFrom = "Please_do_not_reply(ET Automation Report)";

			// Get session object

			boolean flag=false;
			for(int j=1;j<=10;j++)
			{
				Properties props = new Properties();
				props.put("mail.smtp.host", "nmailer.indiatimes.com");  
				props.put("mail.smtp.socketFactory.port","25");  
				System.out.println("j => "+j);

				Session session = Session.getDefaultInstance(props);

				//compose message
				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(usernameSendFrom));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[0]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[1]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[2]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[3]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[4]));
					message.setSubject(emailSubject);

					BodyPart msgBody1 = new MimeBodyPart();
					msgBody1.setContent(messsageBody,"text/html");

					// create MimeBodyPart object and set DataHandler object
					BodyPart msgBody2 = new MimeBodyPart();
					DataSource source = new FileDataSource(fileName);
					msgBody2.setDataHandler(new DataHandler(source));
					msgBody2.setFileName(setFileName);

					BodyPart msgBody3 = new MimeBodyPart();
					DataSource source1 = new FileDataSource(fileName1);
					msgBody3.setDataHandler(new DataHandler(source1));
					msgBody3.setFileName(setFileName1);

					// create multipart object and add MimeBodyPart object to this object
					Multipart multiPart = new MimeMultipart();
					multiPart.addBodyPart(msgBody1);
					multiPart.addBodyPart(msgBody2);
					multiPart.addBodyPart(msgBody3);

					// set multipart object to the message object
					message.setContent(multiPart);

					// send Mail
					Transport.send(message);

					System.out.println("Email sent successfully to "+ sendTo[0]);
					flag=true;
				} 
				catch (Exception e) {
					//e.printStackTrace();
					System.out.println("Trying attempt "+j+"\n"+e.getMessage());
				}
				if(flag)
				{
					break;
				}
			}
		} else if(liveTVEmail.equalsIgnoreCase("gmail"))
		{
			String usernameSendFrom = "timesinternetlimitedcompany@gmail.com";
			String passwordSendFrom = "times@123";

			// Get session object

			boolean flag=false;
			for(int j=1;j<=10;j++)
			{
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");  
				props.put("mail.smtp.socketFactory.port","465");  
				props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
				props.put("mail.smtp.auth", "true");  
				props.put("mail.smtp.port", "465");

				Session session = Session.getDefaultInstance(props,new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication ()
					{
						return new PasswordAuthentication(usernameSendFrom, passwordSendFrom);
					}
				});


				//compose message
				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(usernameSendFrom));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[0]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[1]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[2]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[3]));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[4]));
					message.setSubject(emailSubject);

					BodyPart msgBody1 = new MimeBodyPart();
					msgBody1.setContent(messsageBody,"text/html");

					// create MimeBodyPart object and set DataHandler object
					BodyPart msgBody2 = new MimeBodyPart();
					DataSource source = new FileDataSource(fileName);
					msgBody2.setDataHandler(new DataHandler(source));
					msgBody2.setFileName(setFileName);

					BodyPart msgBody3 = new MimeBodyPart();
					DataSource source1 = new FileDataSource(fileName1);
					msgBody3.setDataHandler(new DataHandler(source1));
					msgBody3.setFileName(setFileName1);

					// create multipart object and add MimeBodyPart object to this object
					Multipart multiPart = new MimeMultipart();
					multiPart.addBodyPart(msgBody1);
					multiPart.addBodyPart(msgBody2);
					multiPart.addBodyPart(msgBody3);

					// set multipart object to the message object
					message.setContent(multiPart);

					// send Mail
					Transport.send(message);

					System.out.println("Email sent successfully to "+ sendTo[0]);
					flag=true;
				} 
				catch (Exception e) {
					//e.printStackTrace();
					System.out.println("Trying attempt "+j+"\n"+e.getMessage());
				}
				if(flag)
				{
					break;
				}
			}
		}

	}

	public void sentReportMailQA(String emailSubject,Object messsageBody)
	{
		if(emailType.equalsIgnoreCase("nmail"))
		{
			String[] sendTo = new String[]{"lavish.mehta@timesinternet.in"};
			String usernameSendFrom = "Please_do_not_reply(ET Automation Report)";

			// Get session object

			boolean flag=false;
			for(int j=1;j<=10;j++)
			{
				Properties props = new Properties();
				props.put("mail.smtp.host", "nmailer.indiatimes.com");  
				props.put("mail.smtp.socketFactory.port","25");  
				System.out.println("j => "+j);

				Session session = Session.getDefaultInstance(props);


				//compose message

				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(usernameSendFrom));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[0]));
					//						message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[1]));
					message.setSubject(emailSubject);

					// text with html
					message.setContent(messsageBody,"text/html");

					// send Mail
					Transport.send(message);

					System.out.println("Normal Email sent successfully to "+ sendTo[0]);
					flag=true;
				} 
				catch (Exception e) {
					//e.printStackTrace();
					System.out.println("Trying attempt "+j+"\n"+e.getMessage());
				}
				if(flag)
				{
					break;
				}
			} 
		} else if(emailType.equalsIgnoreCase("gmail"))
		{
			String[] sendTo = new String[]{"lavish.mehta@timesinternet.in"};
			String usernameSendFrom = "timesinternetlimitedcompany@gmail.com";
			String passwordSendFrom = "times@123";

			// Get session object

			boolean flag=false;
			for(int j=1;j<=10;j++)
			{
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");  
				props.put("mail.smtp.socketFactory.port","465");  
				props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
				props.put("mail.smtp.auth", "true");  
				props.put("mail.smtp.port", "465");

				System.out.println("j => "+j);
				Session session = Session.getDefaultInstance(props,new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication ()
					{
						return new PasswordAuthentication(usernameSendFrom, passwordSendFrom);
					}
				});


				//compose message

				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(usernameSendFrom));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo[0]));
					message.setSubject(emailSubject);

					// text with html
					message.setContent(messsageBody,"text/html");

					// send Mail
					Transport.send(message);

					System.out.println("Normal Email sent successfully to "+ sendTo[0]);
					flag=true;
				} 
				catch (Exception e) {
					//e.printStackTrace();
					System.out.println("Trying attempt "+j+"\n"+e.getMessage());
				}
				if(flag)
				{
					break;
				}
			} 
		}
	}
}
