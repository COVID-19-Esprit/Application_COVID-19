/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import services.Inscription_admin;
import services.JavaMailUtil;

/**
 * FXML Controller class
 *
 * @author Achref
 */
public class ConfirmMailController implements Initializable   {

    @FXML
    private Label mail;
    @FXML
    private Button lastnew;
    @FXML
    private Button order;
    @FXML
    private Button r;
    @FXML
    private RadioButton sendmail;
    @FXML
    private RadioButton sendsms;
      
    private ToggleGroup x;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        x= new ToggleGroup();
        this.sendmail.setToggleGroup(x);
        this.sendsms.setToggleGroup(x);
       }    
          
    @FXML
    private void retour(ActionEvent event) {
           try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/Login.fxml")
                    );
            
            Parent root2 = loader.load();
            LoginController dpc = loader.getController();
           
            r.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

    
   
   
    
    @FXML
    private void confirmation(ActionEvent event) throws Exception  {
           try {
               if(sendmail.isSelected())
               {
                 // JavaMailUtil.main();
                FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/reset_password.fxml")
                    );
            
            Parent root2 = loader.load();
            Reset_passwordController dpc = loader.getController();
            r.getScene().setRoot(root2);}
               
               if(sendsms.isSelected())
               {  
                   System.out.println("Message envoyer");
               FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/reset_password.fxml")
                    );
            
            Parent root2 = loader.load();
            Reset_passwordController dpc = loader.getController();
            r.getScene().setRoot(root2);}
               
              else if (!sendmail.isSelected() && !sendsms.isSelected()){ 
                   Notifications notif = Notifications.create().title("Error").text("Check your Mail or Telephone Number").graphic(null).hideAfter(Duration.seconds(7)).position(Pos.BOTTOM_RIGHT);
            notif.showConfirm();
           }

        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }


    @FXML
    private void lastnew(ActionEvent event) {
    }

    @FXML
    private void order(ActionEvent event) {
    }

    @FXML
    private void Notyou(ActionEvent event) {
        
  // JavaMailUtil.main("achref.hammami@esprit.tn");

    }

    @FXML
    private void sendmail(ActionEvent event) {
    }

    @FXML
    private void sendsms(ActionEvent event) {
    }
    

    
}
