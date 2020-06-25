/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.admin;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
import org.controlsfx.control.Notifications;
import utils.myconnection;

/**
 * FXML Controller class
 *
 * @author Achref
 */
public class ChangerMpController implements Initializable {

    
    @FXML
    private Button r;
    @FXML
    private Label mail;
    @FXML
    private Button lastnew;
    @FXML
    private Button order;
    @FXML
    private TextField newmp;
    @FXML
    private TextField confirmmp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     Connection con = null;
    public ChangerMpController() {
        con = myconnection.conDB();
    }
    @FXML
    private void retour(ActionEvent event) {
          try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/reset_password.fxml")
                    );
            
            Parent root2 = loader.load();
            Reset_passwordController dpc = loader.getController();
           
            r.getScene().setRoot(root2);
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
    private void Update(ActionEvent event) {
        
        if(newmp.getText().equals(confirmmp.getText()) && !newmp.getText().isEmpty() && !confirmmp.getText().isEmpty())
        {
        String req2="UPDATE admin SET  password = ? ";
      //    String req2="UPDATE malade SET  code = ? ";
        // String req1="UPDATE volentaire SET  code = ? ";

        try {
        //    PreparedStatement p3 = con.prepareStatement(req);
            PreparedStatement p2 = con.prepareStatement(req2);
          //  PreparedStatement p1 = con.prepareStatement(req1);

            // p3.setString(1,newmp.getText());
          //   p3.executeUpdate();
              p2.setString(1,newmp.getText());
             p2.executeUpdate();
            //  p1.setString(1,newmp.getText());
            // p1.executeUpdate();
             System.out.println("Updated");


             Notifications notif = Notifications.create().title("Success").text("Password updated !").graphic(null).hideAfter(Duration.seconds(7)).position(Pos.BOTTOM_RIGHT);
            notif.showConfirm();
             try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/Login.fxml")
                    );
            
            Parent root2 = loader.load();
            LoginController dpc = loader.getController();
            r.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());  }
      
                    } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }}
        
        if (newmp.getText().isEmpty() || confirmmp.getText().isEmpty())
        { Notifications notif = Notifications.create().title("Error").text("Password Incorrect !").graphic(null).hideAfter(Duration.seconds(7)).position(Pos.BOTTOM_RIGHT);
            notif.showConfirm();}
        
        
          else {  Notifications notif = Notifications.create().title("Error").text("Password Incorrect !").graphic(null).hideAfter(Duration.seconds(7)).position(Pos.BOTTOM_RIGHT);
            notif.showConfirm();
        
        
        }
     
        
        
        
        
    }
    
}
