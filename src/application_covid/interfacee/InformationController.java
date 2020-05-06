/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.interfacee;

import application_covid.entities.Information;
import application_covid.services.InformationCRUD;
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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author House
 */
public class InformationController implements Initializable {

    @FXML
    private TextField tfTitre;
    @FXML
    private TextField tfContent;
    @FXML
    private Button btnValider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void validerInformation(ActionEvent event) {
        try {
            //Sauvegarde de la personne dans la base
            Information i = new Information();
            i.setTitre(tfTitre.getText());
            i.setContent(tfContent.getText());
            
            InformationCRUD icd = new InformationCRUD();
            icd.ajouterInformation(i);
            
            //Redirection vers la page d'affichage
            
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("DetailsInformation.fxml")
                    );
            
            Parent root2 = loader.load();
            DetailsInformationController dic = loader.getController();
            dic.setResTitre(tfTitre.getText());
            dic.setResContent(tfContent.getText());
            tfContent.getScene().setRoot(root2);
            
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
