/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inscription;

import Inscription.Choix_utilisateurController;
import Inscription.Connect_meController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Achref
 */
public class Interface_connectController implements Initializable {
 

    @FXML
    private TextField tfuserr;
    @FXML
    private TextField tfpasswordd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    



    
    
     private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

   
   

    @FXML
    private void signin(ActionEvent event) {
               String status = "Success";
        String email = tfuserr.getText();
        String password = tfpasswordd.getText();
        if(email.isEmpty() || password.isEmpty()) {
            System.err.println("erreur d'inscription"); 
             Window owner = null;
             showAlert(Alert.AlertType.ERROR, owner, "Error!", 
                    "Please enter your email or your password!");
            status = "Error";
        } 
    }

    @FXML
    private void sigup(ActionEvent event) {
          try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("Choix_utilisateur.fxml")
                    );
            
            Parent root2 = loader.load();
            Choix_utilisateurController dpc = loader.getController();
           
            tfuserr.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

    @FXML
    private void retour(ActionEvent event) {
          try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("Connect_me.fxml")
                    );
            
            Parent root2 = loader.load();
            Connect_meController dpc = loader.getController();
           
            tfuserr.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

    
    
}
