/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inscription;

import Inscription.Inscription_Malade;
import Malade.Utilisateur_Malade;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Achref
 */
public class Interface_inscription_maladeController implements Initializable {

    
    
    @FXML
    private TextField tfid;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
      @FXML
    private TextField tfage;
    @FXML
    private TextField tfadresse;
    @FXML
    private TextField tftelephone;
    @FXML
    private TextField tfmail;
    @FXML
    private TextField tfmdp;
  

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
                            getClass().getResource("Choix_utilisateur.fxml")
                    );
            
            Parent root2 = loader.load();
            Choix_utilisateurController dpc = loader.getController();
           
            tfnom.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

    @FXML
    private void ajoutermalade(ActionEvent event) {
        
            Utilisateur_Malade um = new Utilisateur_Malade();
            um.setId(tfid.getLength());
            um.setNomMalade(tfnom.getText());
            um.setPrenomMalade(tfprenom.getText());
            um.setAgeMalade(tfage.getLength());
            um.setAdresseMalade(tfadresse.getText());
            um.setTelephoneMalade(tftelephone.getLength());
            um.setMailMalade(tfmail.getText());
            um.setCode(tfmdp.getText());


            Inscription_Malade pcd = new Inscription_Malade();
            pcd.ajouterMalade(um);
        Window owner = null;
            showAlert(Alert.AlertType.ERROR, owner, "Succes", 
                    "Malade ajouter avec succes");
    }
    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }  

}
