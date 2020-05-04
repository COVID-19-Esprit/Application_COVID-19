/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.interfacee;

import application_covid.entities.Membre;
import application_covid.services.MembreCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author A
 */
public class InscriptionMembreController implements Initializable {

    @FXML
    private TextField membreId;
    @FXML
    private TextField membreName;
    @FXML
    private TextField membreFirstName;
    @FXML
    private TextField emailMembre;
    @FXML
    private TextField membreAge;
    @FXML
    private TextField membrePhone;
    @FXML
    private PasswordField membrePassword;
    @FXML
    private Button btnSignp;
    @FXML
    private Button btnSignin;
    private int id;
    private int age;
    private int phone;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void insertion(ActionEvent event) {
        //Insertion base table membre
        Membre m = new Membre();
        id = Integer.parseInt(membreId.getText());
        m.setId(id);
        m.setNomMembre(membreName.getText());
        m.setPrenomMembre(membreFirstName.getText());
        m.setAdresseMembre(emailMembre.getText());
        m.setAdresseMembre(emailMembre.getText());
        age = Integer.parseInt(membreAge.getText());
        m.setAge(age);
        phone = Integer.parseInt(membrePhone.getText());
        m.setTelephoneMembre(phone);
        m.setPasswordMembre(membrePassword.getText());
        
        MembreCRUD mbc = new MembreCRUD();
        mbc.ajouterMembre(m);
        
        
        
        
    }
    
    
}
