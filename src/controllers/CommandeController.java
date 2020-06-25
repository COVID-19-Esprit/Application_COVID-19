/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Commandes;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Achref
 */
public class CommandeController implements Initializable {

  
    @FXML
    private Button a;
    @FXML
    private Button e;

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
            controllers.LoginController dpc = loader.getController();
           
            e.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

    @FXML
    private void EditProfil(ActionEvent event) {
    
       try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/EditProfil.fxml")
                    );
            
            Parent root2 = loader.load();
            controllers.EditProfilController dpc = loader.getController();
           
            a.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    
    
    
    
    
    
    
    
    
    }

    @FXML
    private void Order(ActionEvent event) {
          try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/PassCommande.fxml")
                    );
            
            Parent root2 = loader.load();
            controllers.PassCommandeController dpc = loader.getController();
           
            a.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

    
}
