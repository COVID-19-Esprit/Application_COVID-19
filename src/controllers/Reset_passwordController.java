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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Achref
 */
public class Reset_passwordController implements Initializable {

    @FXML
    private TextField code;
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
    private void retour(ActionEvent event) {
         try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/Login.fxml")
                    );
            
            Parent root2 = loader.load();
            LoginController dpc = loader.getController();
           
            code.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

    @FXML
    private void confirmation(ActionEvent event) {
    }

    

    @FXML
    private void order(ActionEvent event) {
    }

   /* @FXML
    private void tfmalade(ActionEvent event) {
    }*/

    @FXML
    private void lastnew(ActionEvent event) {
    }
    
}
