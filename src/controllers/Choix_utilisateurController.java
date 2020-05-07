/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Achref
 */
public class Choix_utilisateurController implements Initializable {
    
    @FXML
    private Button tfmala;
    @FXML
    private Button tfvolo;
    @FXML
    private Button lastnew;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void tfmalade(ActionEvent event) {
        try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/Interface_Inscription_malade.fxml")
                    );
            
            Parent root2 = loader.load();
           controllers.Interface_inscription_maladeController dpc = loader.getController();
           
            tfmala.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

    @FXML
    private void tfvolontaire(ActionEvent event) {
        try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/Interface_inscription_volontaire.fxml")
                    );
            
            Parent root2 = loader.load();
            controllers.Interface_inscription_volontaireController dpc = loader.getController();
           
            tfvolo.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

    @FXML
    private void retour(ActionEvent event) {
        
          try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/Login.fxml")
                    );
            
            Parent root2 = loader.load();
            controllers.LoginController dpc = loader.getController();
           
            tfmala.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

    @FXML
    private void lastnew(ActionEvent event) {
    }



        
    }
    

  
    
   
    

