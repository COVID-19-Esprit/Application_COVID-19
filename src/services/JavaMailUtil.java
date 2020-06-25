package services;

import java.util.Properties;  
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;  
import javax.mail.internet.*;  
  
public class JavaMailUtil {  
    public static String code_verif;

 public static void main(String recepient) throws Exception { 
     
             System.out.println("preparing to send...");  
   Properties props = new Properties(); 
      props.put("mail.smtp.auth", "true");  
   props.put("mail.smtp.host","smtp.gmail.com");  
        props.put("mail.smtp.starttls.enable",true);  
   props.put("mail.smtp.port", "587"); 
   
   
  String user="hammamiachref654@gmail.com";//change accordingly  
  String password="Esprit2020";//change accordingly 
  
   Session session = Session.getInstance(props,  
    new Authenticator() {  
      protected PasswordAuthentication getPasswordAuthentication() {  
    return new PasswordAuthentication(user,password);  
      }  
    });  
   Message message =prepareMessage(session,user,recepient);
        Transport.send(message); 
             System.out.println("message sent successfully...");  
 }
 
 public static String code ()
 {  String s= "AZERTYUIOPMLKJHGFDSQWXCVBN1234567890";
        String randomstring="";
        int lenght = 6;
        Random rn = new Random();
        char [] text = new char[lenght];
        for (int i=0 ; i<lenght ; i++)
        {
        text[i]=s.charAt(rn.nextInt(s.length()));
        }
          for (int i=0 ; i<text.length ; i++)
        {
        randomstring+=text[i];
        }
              System.out.println(randomstring);

 return randomstring; }
 



   public  static Message prepareMessage (Session session , String user , String recepient)
 {
       try {  
             //     Random rn = new Random();

     Message message = new MimeMessage(session);  
     message.setFrom(new InternetAddress("Confirmation"));  
     message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));  
     message.setSubject("Confirm email address"); 
      code_verif=code();
     message.setText("Your confirmation code is : "+code_verif);
      
       return message;
  
   
     } 
       catch (Exception ex) {Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE,null,ex);}  
 return null;
 }


}