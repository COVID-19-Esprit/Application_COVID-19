/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.interfacee;

import com.jfoenix.controls.JFXButton;
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
 * @author Rihab
 */
public class HomePageController implements Initializable {
    
    @FXML
    private JFXButton tf;
    @FXML
    private JFXButton tf4;
    @FXML
    private JFXButton tf3;
    @FXML
    private JFXButton tf2;
    @FXML
    private JFXButton tf1;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn1(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WhatIsCovid.fxml"));
            Parent root2= loader.load();
            WhatIsCovidController dpc= loader.getController();
            tf.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    private void btn2(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProtectYourself.fxml"));
            Parent root2= loader.load();
            ProtectYourselfController dpc= loader.getController();
            tf1.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }        
    }

    @FXML
    private void btn3(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("QuizTest.fxml"));
            Parent root2= loader.load();
            QuizTestController dpc= loader.getController();
            tf2.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }        
    }

    @FXML
    private void btn4(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("News.fxml"));
            Parent root2= loader.load();
            NewsController dpc= loader.getController();
            tf3.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }        
    }

    @FXML
    private void btn5(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
            Parent root2= loader.load();
            SignInController dpc= loader.getController();
            tf4.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }        
    }


}
