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
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Achref
 */
public class EditProfilController implements Initializable {

    @FXML
    private Label tfc1;
    @FXML
    private Label e1;
    @FXML
    private Label e2;
    @FXML
    private Label lbfirstname;
    @FXML
    private Label lblastname;
    @FXML
    private Label lbage;
    @FXML
    private Label lbadresse;
    @FXML
    private Label lbcontact;
    @FXML
    private Label lbmail;
    @FXML
    private Label lbpassword;
    @FXML
    private TextField tffirst;
    @FXML
    private TextField tflastname;
    @FXML
    private TextField tfage;
    @FXML
    private TextField tfadresse;
    @FXML
    private TextField tfmobile;
    @FXML
    private TextField tfmail;
    @FXML
    private TextField tfpassword2;
    @FXML
    private TextField tfpassword1;
    @FXML
    private TextField tfpassword11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void update(ActionEvent event) {
    }

    @FXML
    private void retour(ActionEvent event) {
        
             try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/Commande.fxml")
                    );
            
            Parent root2 = loader.load();
            controllers.CommandeController dpc = loader.getController();
           
            tfage.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }

    }
    
}
