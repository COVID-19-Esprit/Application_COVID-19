/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.services;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;
import com.sun.xml.internal.ws.message.MimeAttachmentSet;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class EmailStatistic {
    
    public static void main(String[] args){
    //authentification info
    final String username = "nefzaouiachref1997@gmail.com";
    final String password = "nefzaouinefzaoui1997";
    String fromEmail = "nefzaouiachref1997@gmail.com";
    String toEmail = "achref.nefzaoui@esprit.tn";
    
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.smtp.host","mail.smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        
        
    Session session = Session.getInstance(properties,  
    new Authenticator() {  
      protected PasswordAuthentication getPasswordAuthentication() {  
    return new PasswordAuthentication(username,password);  
      }  
    });
        //Start our mail message 
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
            msg.setSubject("Subject Line");
            msg.setText("Email body text");
            Transport.send(msg);
            System.out.println("test");
            
        } catch (Exception e) {
        }
        
        
    
    }
}
