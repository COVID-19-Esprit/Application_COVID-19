package application_covid.interfacee;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import application_covid.utils.MyConnection;

/**
 *
 * @author oXCToo
 */
public class LoginController implements Initializable {

    @FXML
    private Label lblErrors;
     @FXML
    private Label lblErrors1;
     @FXML
    public TextField txtUsername;
      @FXML
    private TextField txtPassword;
      @FXML
    private Button btnSignin;
 
       Connection con = null;
 
 PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    ///////////////////////////////////////
    @FXML
    private Button order;
     ///////////////////////////////////////////////////
   //PreparedStatement preparedStatement2 = null;
   // ResultSet resultS/et2 = null;
    @FXML
    private ComboBox combox;
 ObservableList <String> list =FXCollections.observableArrayList("Admin","Patient","Volentary");
    //////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////
 /*
    @FXML
    public void handleButtonAction(MouseEvent event) throws Exception {
         
            if (event.getSource() == btnSignin) {
                
                  if (combox.getValue().toString().equals(""))  
                         {
                         //  setLblError1(Color.TOMATO, "Check User");
           //clear();
                         
                         }
                  
  if (combox.getValue().toString().equals("Admin"))   
                 ///////////////////////////////////////////////////////////
             {   if (logIn().equals("Success")) 
               
              { try {

                    //add you loading or delays - ;-)
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/interfacee/admin_interface.fxml")));
                    stage.setScene(scene);
                    stage.show();
                    }
                 catch (IOException ex) {
                    System.err.println(ex.getMessage());
                } } }
             ///////////////////////////////////////////////////////////////
 if (combox.getValue().toString().equals("Patient"))  
                        {
                        if (logIn1().equals("Success")) 
               
              { try {

                    //add you loading or delays - ;-)
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/interfacee/Commande.fxml")));
                    stage.setScene(scene);
                    stage.show();
                    }
                 catch (IOException ex) {
                    System.err.println(ex.getMessage());
                } } }
                        
                        }
                        
  if (combox.getValue().toString().equals("Volentary"))  
                        {       if (logIn2().equals("Success")) 
               
              { try {

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
                } } }
                      
 
      
        }
    */
//////////////////////////////////////////////////////////////////////////////////////
  
    ///////////////////////////////////////////////////////////////////////////////////

   public void ChangeScreenStatistic(ActionEvent event) throws IOException {
    Parent StaticParent = FXMLLoader.load(getClass().getResource("Statistics.fxml"));
    Scene StaticScene = new Scene(StaticParent);
    
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(StaticScene);
    window.show();

   }  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
     /*   if (con == null) {
            lblErrors.setTextFill(Color.TOMATO);
             lblErrors.setText("Server Error : Check");
          
        } else {
            lblErrors.setTextFill(Color.GREEN);
            lblErrors.setText("Server is up : Good to go");
            
        }
        */
               
     combox.setItems(list);

    }

    
    public LoginController() {
        con = MyConnection.getInstance().getCnx();
    }

    //we gonna use string to check for status
    public String logIn() throws Exception {
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
            String sql1 = "SELECT * FROM admin Where login = ? and password = ?";
             //String sql2 = "SELECT * FROM volentaire Where mail = ? and code = ?";
            try {
             
                
                preparedStatement = con.prepareStatement(sql1);
                preparedStatement.setString(1,email);
                preparedStatement.setString(2,password);
                resultSet = preparedStatement.executeQuery();
             
                 
                  if (!resultSet.next()) {
                    setLblError(Color.TOMATO, "Enter Correct Email/Password");
                    status = "Error";
                } 
             
                else {
                 
                    setLblError(Color.GREEN, "Login Successful..Redirecting..");
                    
                }
                
             
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Exception";
            }
        }
        
     return status;
    }
    ////////////////////////////////////////////////////////////
     public String logIn1() throws Exception {
        String status = "Success";
        String email = txtUsername.getText();
        String password = txtPassword.getText();
      
        if(email.isEmpty() || password.isEmpty()) {
            setLblError(Color.TOMATO, "Empty credentials");
            status = "Error"; } 
       
         else 
        {
            //query
             String sql  = "SELECT * FROM malade Where mailMalade = ? and code = ?";
           // String sql1 = "SELECT * FROM admin Where login = ? and password = ?";
             //String sql2 = "SELECT * FROM volentaire Where mail = ? and code = ?";
            try {
             
                
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1,email);
                preparedStatement.setString(2,password);
                resultSet = preparedStatement.executeQuery();
             
                 
                  if (!resultSet.next()) {
                    setLblError(Color.TOMATO, "Enter Correct Email/Password");
                    status = "Error";
                } 
             
                else {
                 
                    setLblError(Color.GREEN, "Login Successful..Redirecting..");
                    
                }
                
             
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Exception";
            }
        }
        
     return status;
    }
     
    //////////////////////////////////////////////////////////////////
        public String logIn2() throws Exception {
        String status = "Success";
        String email = txtUsername.getText();
        String password = txtPassword.getText();
      
        if(email.isEmpty() || password.isEmpty()) {
            setLblError(Color.TOMATO, "Empty credentials");
            status = "Error"; } 
       
         else 
        {
            //query
            // String sql  = "SELECT * FROM malade Where mailMalade = ? and code = ?";
           // String sql1 = "SELECT * FROM admin Where login = ? and password = ?";
             String sql2 = "SELECT * FROM volentaire Where mail = ? and code = ?";
            try {
             
                
                preparedStatement = con.prepareStatement(sql2);
                preparedStatement.setString(1,email);
                preparedStatement.setString(2,password);
                resultSet = preparedStatement.executeQuery();
             
                 
                  if (!resultSet.next()) {
                    setLblError(Color.TOMATO, "Enter Correct Email/Password");
                    status = "Error";
                } 
             
                else {
                 
                    setLblError(Color.GREEN, "Login Successful..Redirecting..");
                    
                }
                
             
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Exception";
            }
        }
        
     return status;
    }
    ////////////////////////////////////////////////////////////
    private void setLblError(Color color, String text) {
        lblErrors.setTextFill(color);
        lblErrors.setText(text);
     
        System.out.println(text);
    }
    ////////////////////////////////////////////////////////////////////////////////
       private void setLblError1 (Color colorr, String textt) {
        lblErrors1.setTextFill(colorr);
        lblErrors1.setText(textt);
     
        System.out.println(textt);
    }
  
 /* 
    @FXML
    public void forgetpassword(ActionEvent event) throws Exception  {
       if(txtUsername.getText().isEmpty())
       {try {
            
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/FindYourAccount.fxml")
                    );
            
            Parent root2 = loader.load();
            FindYourAccountController dpc = loader.getController();
              txtUsername.getScene().setRoot(root2);
           
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }}
        
       else 
       {try {
            
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/ConfirmMail.fxml")
                    );
            
            Parent root2 = loader.load();
            ConfirmMailController dpc = loader.getController();
           
            String email = txtUsername.getText();
        String password = txtPassword.getText(); 
            //  JavaMailUtil.main("achref.hammami@esprit.tn");
              txtUsername.getScene().setRoot(root2);
           
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }}
        
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
            
            txtUsername.getScene().setRoot(root2);
           
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }
 */
    @FXML
    private void signUp(ActionEvent event) {
        /////////////////////////////////////////////////////
       /*  if (combox.getValue().toString().equals("Volentary")) 
         {  try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("Interface_Inscription_volontaire.fxml")
                    );
            
            Parent root2 = loader.load();
            application_covid.interfacee.Interface_inscription_maladeController dpc = loader.getController();
           
            txtUsername.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }}
        */
        //////////////////////////////////////////////////////////
        if (combox.getValue().toString().equals("Patient"))  
        {try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("Interface_Inscription_malade.fxml")
                    );
            
            Parent root2 = loader.load();
         application_covid.interfacee.Interface_inscription_maladeController dpc = loader.getController();
           
            txtUsername.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
         }
        ////////////////////////////////////////////////////////////////////////////////////////////
          if (combox.getValue().toString().equals("Admin"))  
          {
           setLblError1(Color.TOMATO, "Check User (Patient Or Volentary");
           
          
          }
        
    }



  
}
