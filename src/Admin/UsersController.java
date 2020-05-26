/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Tab;

/**
 * FXML Controller class
 *
 * @author A
 */
public class UsersController implements Initializable {

    @FXML
    private Tab membreTab;
    @FXML
    private Tab sickTab;
    @FXML
    private Tab volunteersTab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Node node = FXMLLoader.load(getClass().getResource("membreTab.fxml"));
            membreTab.setContent(node);
            Node node2 = FXMLLoader.load(getClass().getResource("patientTab.fxml"));
            sickTab.setContent(node2);
            Node node3 = FXMLLoader.load(getClass().getResource("volunteersTab.fxml"));
            volunteersTab.setContent(node3);
        } catch (IOException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
