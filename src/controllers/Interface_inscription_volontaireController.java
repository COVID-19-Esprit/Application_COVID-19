/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Utilisateur_Volontaire;
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
public class Interface_inscription_volontaireController implements Initializable {

    @FXML
    private TextField tfidd;
    @FXML
    private TextField tfnomm;
    @FXML
    private TextField tfprenomm;
    private TextField tfadd;
    @FXML
    private TextField tftelephonee;
    @FXML
    private TextField tfmaill;
    private TextField tfasso;
    @FXML
    private TextField tfmp;
    @FXML
    private TextField tfadresse;
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
    private void ajoutervolontaire(ActionEvent event) {
           Utilisateur_Volontaire uv = new Utilisateur_Volontaire();
                    uv.setId(tfidd.getAnchor());
            uv.setNomVolontaire(tfnomm.getText());
            uv.setPrenomVolontaire(tfprenomm.getText());
            uv.setAdresseVolontaire(tfadd.getText());
            uv.setTelephoneVolontaire(tftelephonee.getAnchor());
            uv.setMail(tfmaill.getText());
            uv.setAssociation(tfasso.getText());
            uv.setCode(tfmp.getText());

            
            services.Inscription_Volontaire pcd = new services.Inscription_Volontaire();
            pcd.ajouteruv(uv);
    }

    @FXML
    private void retour(ActionEvent event) {
         try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/Choix_utilisateur.fxml")
                    );
            
            Parent root2 = loader.load();
            Choix_utilisateurController dpc = loader.getController();
           
            tfnomm.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

    @FXML
    private void lastnew(ActionEvent event) {
    }

    @FXML
    private void order(ActionEvent event) {
    }
    
}
