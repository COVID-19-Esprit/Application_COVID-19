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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Flexos
 */
public class Suivimp3Controller implements Initializable {

    @FXML
    private Button logout;
    @FXML
    private Button Submit;
    @FXML
    private Button Previous;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void logout(ActionEvent event) {
    }

    @FXML
    private void Submit(ActionEvent event) {
    }
    public void ChangeScreenStatistic(ActionEvent event) throws IOException {
    Parent StaticParent = FXMLLoader.load(getClass().getResource("Statistics.fxml"));
    Scene StaticScene = new Scene(StaticParent);
    
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(StaticScene);
    window.show();

   }

    @FXML
    private void Previous(ActionEvent event) {
        
        try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("Suivimp2.fxml")
                    );
            
            Parent root2 = loader.load();
            Suivimp2Controller dpc = loader.getController();
           
         Previous.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }
    
}
