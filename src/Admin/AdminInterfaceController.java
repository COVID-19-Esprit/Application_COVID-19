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
public class AdminInterfaceController implements Initializable {

    @FXML
    private Tab dashboardTab;
    @FXML
    private Tab UsersTab;
    @FXML
    private Tab informationTab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            Node node = FXMLLoader.load(getClass().getResource("users.fxml"));
            UsersTab.setContent(node);
        } catch (IOException ex) {
            Logger.getLogger(AdminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
