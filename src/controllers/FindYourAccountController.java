/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import services.JavaMailUtil;

/**
 * FXML Controller class
 *
 * @author Achref
 */
public class FindYourAccountController implements Initializable {

    @FXML
    private Button r;
    @FXML
    private Label mail;
    @FXML
    private Button lastnew;
    @FXML
    private Button order;
    @FXML
    private TextField tfcode;
    @FXML
    private Button search;
     Connection con = null;
 
 PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void handleButtonAction(MouseEvent event) throws Exception {
        if (event.getSource() == search){ 
        if (log().equals("Success"))
        {
      try {
          JavaMailUtil.main(tfcode.getText());
          FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/ConfirmMail.fxml") );
          Parent root2 = loader.load();
            ConfirmMailController dpc = loader.getController();
            r.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }   
        }
        else {System.out.println("nnnnn");}
    }}
    
    
 public String log() throws Exception {
        String status = "Success";
       
       if(tfcode.getText().isEmpty() || tfcode.getText().isEmpty()) {
           System.out.println("erreur");
           status = "Error"; } 
       
         else 
        {
            //query
            String sql  = "SELECT * FROM malade Where mailMalade = ? ";
           // String sql1 = "SELECT * FROM admin Where login = ? and password = ?";
             //String sql2 = "SELECT * FROM volentaire Where mail = ? and code = ?";
            try {
             
                
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1,tfcode.getText());
                resultSet = preparedStatement.executeQuery();
             
                 
                  if (!resultSet.next()) {
                    status = "Error";} 
             
                else {
                 System.out.println("ok");                    
                }
                
             
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Exception";
            }
        }
        
     return status;
    }
   
 @FXML
    private void lastnew(ActionEvent event) {
    }

    @FXML
    private void order(ActionEvent event) {
    }

  
    
    
}
