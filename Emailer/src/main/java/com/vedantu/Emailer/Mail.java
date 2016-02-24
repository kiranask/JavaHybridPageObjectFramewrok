package com.vedantu.Emailer;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
 
public class Mail {
 
    public static void sendEmailWithAttachments(String host, String port,
    final String userName, final String password, String toAddress,
            String subject, String message, String[] attachFiles)
            throws AddressException, MessagingException {
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
 
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");
 
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // adds attachments
        if (attachFiles != null && attachFiles.length > 0) {
            for (String filePath : attachFiles) {
                MimeBodyPart attachPart = new MimeBodyPart();
 
                try {
                    attachPart.attachFile(filePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
 
                multipart.addBodyPart(attachPart);
            }
        }
 
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
 
        // sends the e-mail
        Transport.send(msg);
 
    }
 
    /**
     * Test sending e-mail with attachments
     * @throws ParserConfigurationException 
     * @throws IOException 
     * @throws SAXException 
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
    	String Status;
    	String path = "D:\\veta\\rdxtest\\target\\surefire-reports\\testng-results.xml";

	    File fXmlFile = new File(path);

	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(fXmlFile);
	    doc.getDocumentElement().normalize();
	    
	    String Total = doc.getDocumentElement().getAttribute("total");
	    String Passed = doc.getDocumentElement().getAttribute("passed");
	    String Failed = doc.getDocumentElement().getAttribute("failed");
	    String Skipped = doc.getDocumentElement().getAttribute("skipped");
	    
	    Boolean state = Total.contentEquals(Passed);
	    
	   
		if(state)
	    Status = "<h1 style='color:green'>TEST PASSED</h1>";
		else
		Status = "<h1 style='color:red'>TEST FAILED</h1>";	
	    
	    System.out.println("Total : " + Total) ;
	    System.out.println("Passed : " + Passed) ;
	    System.out.println("Failed : " + Failed) ;
	    System.out.println("Skipped : " + Skipped) ;
    	   	
 
    	
        // SMTP info
        String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "test.automation@vedantu.com";
        String password = "vedantuautomation";
 
        // message info
        String mailTo = "test.automation@vedantu.com";
        String subject = "QA | Sanity Execution Report | Do not reply";
        String message = "Hello All,"
        		+ "<p></p><p>The following is the summary of the scheduled Sanity Test Execution:- </p>"
        	//	+ "<br></br>"
        		+ "<table border='2'style='color:black;size:10px'><td>Total : " + Total+"</td><td>Passed : "+Passed+"</td><td>Failed : "+Failed+"</td><td>Skipped : "+Skipped+"</td></tr></table>"  		
        		+ Status
        	//	+ "<br></br>"
        		+ "<p>*Kindly find the detailed report attached along with this mail</p>";
        		
       /* + "<p>Total : " + Total+"</p>"
		+ "<p>Passed : " + Passed+"</p>"
		+ "<p>Failed : " + Failed+"</p>"
		+ "<p>Skipped : " + Skipped+"</p>"  */






 
        // attachments
        String[] attachFiles = new String[1]; // change the initialisation to more than 1 to add more attachments
        attachFiles[0] = "D:\\veta\\rdxtest\\target\\surefire-reports\\emailable-report.html";
      //attachFiles[1] = "e:/Test/Music.mp3";
      //attachFiles[2] = "e:/Test/Video.mp4";
 
        try {
            sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
                subject, message, attachFiles);
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Could not send email.");
            ex.printStackTrace();
        }
    }
}