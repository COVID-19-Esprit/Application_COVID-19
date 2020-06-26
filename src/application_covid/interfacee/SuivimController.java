/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.interfacee;

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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Flexos
 */
public class SuivimController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Button next;
    @FXML
    private Button logout;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void next (ActionEvent event) {
        
          try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("Suivimp2.fxml")
                    );
            
            Parent root2 = loader.load();
            Suivimp2Controller dpc = loader.getController();
           
         next.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

    @FXML
    public void logout(ActionEvent event) {
    }
    
}
