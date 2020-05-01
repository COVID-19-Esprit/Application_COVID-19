/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inscription;

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
    private Button tfmalade;
    @FXML
    private Button tfvolontaire;

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
                            getClass().getResource("interface_inscription_malade.fxml")
                    );
            
            Parent root2 = loader.load();
            Interface_inscription_maladeController dpc = loader.getController();
           
            tfvolontaire.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

    @FXML
    private void tfvolontaire(ActionEvent event) {
        try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("interface_inscription_volontaire.fxml")
                    );
            
            Parent root2 = loader.load();
            Interface_inscription_volontaireeController dpc = loader.getController();
           
            tfvolontaire.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

    @FXML
    private void retour(ActionEvent event) {
        
          try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("Interface_connect.fxml")
                    );
            
            Parent root2 = loader.load();
            Interface_connectController dpc = loader.getController();
           
            tfmalade.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }


        
    }
    

  
    
   
    

