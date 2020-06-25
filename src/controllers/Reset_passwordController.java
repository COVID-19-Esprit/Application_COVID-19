/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static jdk.nashorn.internal.objects.NativeRegExp.test;
import org.controlsfx.control.Notifications;
import services.JavaMailUtil;
import static services.JavaMailUtil.code;

/**
 * FXML Controller class
 *
 * @author Achref
 */
public class Reset_passwordController implements Initializable {

    @FXML
    private TextField code;
    @FXML
    private Button lastnew;
    @FXML
    private Button order;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      //   test.setText(code());

    }    
//***********************************************************************
    @FXML
    private void retour(ActionEvent event) {
         try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/ConfirmMail.fxml")
                    );
            
            Parent root2 = loader.load();
            ConfirmMailController dpc = loader.getController();
           
            code.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

  

//************************************************************************
 @FXML
    private void confirmation(ActionEvent event) {
      System.out.println(JavaMailUtil.code_verif);
      try {
           if (JavaMailUtil.code_verif.equals(code.getText()))
        {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/ChangerMp.fxml")
                    );
            
            Parent root2 = loader.load();
            ChangerMpController dpc = loader.getController();
            code.getScene().setRoot(root2);}
           
           if (code.getText().isEmpty())
           { Notifications notif = Notifications.create().title("Error").text("Code Incorrect!").graphic(null).hideAfter(Duration.seconds(7)).position(Pos.BOTTOM_RIGHT);
            notif.showConfirm(); }
           else 
           {    Notifications notif = Notifications.create().title("Error").text("Code Incorrect!").graphic(null).hideAfter(Duration.seconds(7)).position(Pos.BOTTOM_RIGHT);
            notif.showConfirm();                        }
       
      
      
      } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

    

    @FXML
    private void order(ActionEvent event) {
    }

   

    @FXML
    private void lastnew(ActionEvent event) {
    }


   
    
}
