package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import entities.Utilisateur_Volontaire;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import static javafx.beans.binding.Bindings.and;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static javax.management.Query.and;
import services.JavaMailUtil;
import utils.myconnection;

/**
 *
 * @author oXCToo
 */
public class LoginVolontaireController implements Initializable {

    @FXML
    private Label lblErrors;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnSignin;

    /// -- 
    Connection con = null;
    PreparedStatement preparedStatement = null;
    PreparedStatement preparedStatement1 = null;
    PreparedStatement preparedStatement2 = null;
    ResultSet resultSet = null;
    ResultSet resultSet1 = null;
    ResultSet resultSet2 = null;
    @FXML
    private Button order;

    @FXML
    public void handleButtonAction(MouseEvent event) throws Exception {

        if (event.getSource() == btnSignin) {
            //login here
            if (logIn().equals("Success")) {
                try {

                    //add you loading or delays - ;-)
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/interfacee/Liste_des_commandes.fxml")));
                    stage.setScene(scene);
                    stage.show();
                    } 
                
                catch (IOException ex) {
                    System.err.println(ex.getMessage());
                } }
            
        
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (con == null) {
            lblErrors.setTextFill(Color.TOMATO);
            lblErrors.setText("Server Error : Check");
        } else {
            lblErrors.setTextFill(Color.GREEN);
            lblErrors.setText("Server is up : Good to go");
        }
    }

    public LoginVolontaireController() {
        con = myconnection.conDB();
    }

    //we gonna use string to check for status
    private String logIn() throws Exception {
        String status = "Success";
         String email = txtUsername.getText();
        String password = txtPassword.getText();
       
        
        if(email.isEmpty() || password.isEmpty()) {
            setLblError(Color.TOMATO, "Empty credentials");
            status = "Error"; } 
        
        else 
        {
            //query
           //  String sql  = "SELECT * FROM malade Where mailMalade = ? and code = ?";
           //  String sql1 = "SELECT * FROM admin Where login = ? and password = ?";
           String sql2 = "SELECT * FROM volentaire Where mail = ? and code = ?";

            try {
              /*  preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();*/
              
            preparedStatement1 = con.prepareStatement(sql2);
                preparedStatement1.setString(1,email);
                preparedStatement1.setString(2,password);
               resultSet1 = preparedStatement1.executeQuery();
                
             /*   preparedStatement2 = con.prepareStatement(sql1);
                preparedStatement2.setString(1, email);
                preparedStatement2.setString(2, password);
                resultSet2 = preparedStatement2.executeQuery();*/
                
                if (!resultSet1.next()) {
                    setLblError(Color.TOMATO, "Enter Correct Email/Password");
                    status = "Error";
                } 
           /*     
                 if (!resultSet1.next()) {
                    setLblError(Color.TOMATO, "Enter Correct Email/Password");
                    status = "Error";
                } 
                  if (!resultSet2.next()) {
                    setLblError(Color.TOMATO, "Enter Correct Email/Password");
                    status = "Error";
                } */
             
                else {
                                  //      JavaMailUtil.main(email);
                    setLblError(Color.GREEN, "Login Successful..Redirecting..");
                    
                }
                
             
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Exception";
            }
        }
        
     return status;
    }
    
    private void setLblError(Color color, String text) {
        lblErrors.setTextFill(color);
        lblErrors.setText(text);
        System.out.println(text);
    }


    @FXML
    private void signUp(ActionEvent event) {
           try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/Interface_Inscription_volontaire.fxml")
                    );
            
            Parent root2 = loader.load();
            controllers.Interface_inscription_volontaireController dpc = loader.getController();
           
            txtUsername.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

    @FXML
    private void forgetpassword(ActionEvent event) throws Exception  {
        try {
           FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/ConfirmMail.fxml"));
            
            Parent root2 = loader.load();
            ConfirmMailController dpc = loader.getController();
              String email = txtUsername.getText();
        String password = txtPassword.getText(); 
        // JavaMailUtil.main(email);
            txtUsername.getScene().setRoot(root2);
           
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
        
        
        
        
        
        
        
        

    }

    @FXML
    private void orderr(ActionEvent event) {
    }

    @FXML
    private void retour(ActionEvent event) {
          try {
            
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/Choix_utilisateur.fxml")
                    );
            
            Parent root2 = loader.load();
             Choix_utilisateurController dpc = loader.getController();
              String email = txtUsername.getText();
        String password = txtPassword.getText(); 
            
            txtUsername.getScene().setRoot(root2);
           
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }
}
