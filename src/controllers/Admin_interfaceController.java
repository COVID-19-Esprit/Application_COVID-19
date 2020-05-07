/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author Achref
 */
public class Admin_interfaceController implements Initializable {

    @FXML
    private Button affmalade;
    @FXML
    private Button affvolontaire;


    @FXML
    private TableColumn<?, ?> tfid;
    @FXML
    private TableColumn<?, ?> tfnom;
    @FXML
    private TableColumn<?, ?> tfprenom;
    @FXML
    private TableColumn<?, ?> tfage;
    @FXML
    private TableColumn<?, ?> tfadresse;
    @FXML
    private TableColumn<?, ?> tfcontact;
    @FXML
    private TableColumn<?, ?> tfmail;
    @FXML
    private Button affvolontaire1;
    @FXML
    private Button affvolontaire11;
    @FXML
    private Button affvolontaire12;
    @FXML
    private Button lastnew;
    @FXML
    private Button order;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void affmalade(ActionEvent event) {
        
    }

   
    @FXML
    private void order(ActionEvent event) {
    }
    
    

    @FXML
    private void affvolontaire(ActionEvent event) {
    }

    @FXML
    private void lastnew(ActionEvent event) {
    }
    
}
