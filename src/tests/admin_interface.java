/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import entities.admin;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import services.Inscription_Malade;
import services.Inscription_admin;
import utils.myconnection;

/**
 *
 * @author Achref
 */
public class admin_interface extends Application {
    
    @Override
    public void start(Stage primaryStage) {
  
        try {
            Parent root = FXMLLoader.load(getClass()
                    .getResource("/interfacee/admin_interface.fxml"));
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("COVID 19 Application");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
            
    /*    myconnection mc = new myconnection();
        Inscription_admin iv =new Inscription_admin();
              

            admin u = new admin("admin","admin");
            iv.ajouteradmin(u);
       */
    }
    
}
