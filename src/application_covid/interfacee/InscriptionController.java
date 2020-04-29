/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.interfacee;

import application_covid.entities.Personne;
import application_covid.services.PersonneCRUD;
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
public class InscriptionController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
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
    private void validerPersonne(ActionEvent event) {
        try {
            //Sauvegarde de la personne dans la base
            Personne p = new Personne();
            p.setNom(tfNom.getText());
            p.setPrenom(tfPrenom.getText());
            
            PersonneCRUD pcd = new PersonneCRUD();
            pcd.ajouterPersonne2(p);
            
            //Redirection vers la page d'affichage
            
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("DetailsPersonne.fxml")
                    );
            
            Parent root2 = loader.load();
            DetailsPersonneController dpc = loader.getController();
            dpc.setResNom(tfNom.getText());
            dpc.setResPrenom(tfPrenom.getText());
            tfPrenom.getScene().setRoot(root2);
            
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
