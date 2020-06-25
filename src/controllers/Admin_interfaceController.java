/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Commandes;
import entities.Utilisateur_Malade;
import entities.Utilisateur_Volontaire;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.myconnection;

/**
 * FXML Controller class
 *
 * @author Achref
 */
public class Admin_interfaceController implements Initializable {



    @FXML
    private TableColumn<Utilisateur_Malade,Integer> tfid;
    @FXML
    private TableColumn<Utilisateur_Malade,String> tfnom;
    @FXML
    private TableColumn<Utilisateur_Malade,String> tfprenom;
   @FXML
    private TableColumn<Utilisateur_Malade,Date> tfage;
    @FXML
    private TableColumn<Utilisateur_Malade,String> tfadresse;
    @FXML
    private TableColumn<Utilisateur_Malade,Integer> tfcontact;
    @FXML
    private TableColumn<Utilisateur_Malade,String> tfmail;
    @FXML
    private Button affvolontaire1;
    @FXML
    private Button affvolontaire11;
    @FXML
    private Button affvolontaire12;
    @FXML
    private Button lastnew;
    @FXML
    private Button order;
    @FXML
    private TableView<Utilisateur_Malade> table;
      
    ObservableList<Utilisateur_Malade> oblist = FXCollections.observableArrayList(); 
    @FXML
    private Tab p;
    @FXML
    private Tab v;
    
    
    
    
    @FXML
    private TableView<Utilisateur_Volontaire> table1;
    @FXML
    private TableColumn<Utilisateur_Volontaire,Integer> tfid1;
    @FXML
    private TableColumn<Utilisateur_Volontaire,String> tfnom1;
    @FXML
    private TableColumn<Utilisateur_Volontaire,String> tfprenom1;
    @FXML
    private TableColumn<Utilisateur_Volontaire,String> tfadresse1;
    @FXML
    private TableColumn<Utilisateur_Volontaire,String> tfcontact1;
    @FXML
    private TableColumn<Utilisateur_Volontaire,String> tfmail1;
    @FXML
    private TableColumn<Utilisateur_Volontaire,String> tfasso;
    @FXML
    private Button affvolontaire111;
    @FXML
    private Button affvolontaire121;

    ObservableList<Utilisateur_Volontaire> oblist1 = FXCollections.observableArrayList(); 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
             {
        
         Connection  con = myconnection.conDB();
        try { 
            ResultSet rs =  con.createStatement().executeQuery("select * from malade");
            while (rs.next())
                
            {
                oblist.add(new Utilisateur_Malade (rs.getString("nomMalade"),
               rs.getString("prenomMalade"),rs.getString("ageMalade"),rs.getString("adresseMalade"), rs.getString("telephoneMalade"),
                rs.getString("mailMalade"),rs.getString("code") )); 
                }
              } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
             
               // TODO
            tfid.setCellValueFactory(new PropertyValueFactory<>("id"));
            tfnom.setCellValueFactory(new PropertyValueFactory<>("nomMalade"));
            tfprenom.setCellValueFactory(new PropertyValueFactory<>("prenomMalade"));
            tfage.setCellValueFactory(new PropertyValueFactory<>("ageMalade")); 
             tfadresse.setCellValueFactory(new PropertyValueFactory<>("adresseMalade")); 
             tfcontact.setCellValueFactory(new PropertyValueFactory<>("telephoneMalade")); 
             tfmail.setCellValueFactory(new PropertyValueFactory<>("mailMalade")); 
               table.setItems(oblist);
         //********************************************************************    
               try{
                  ResultSet rs1 =  con.createStatement().executeQuery("select * from volentaire");
                    while (rs1.next())
                    {
                          oblist1.add(new Utilisateur_Volontaire(rs1.getString("nomVolontaire"),
               rs1.getString("prenomVolontaire"),rs1.getString("telephoneVolontaire"),rs1.getString("adresseVolontaire"),
                         rs1.getString("mail"),rs1.getString("Assocation"))); 
                    }}
                catch (SQLException ex) {
            System.out.println(ex.getMessage());  }
               
               
              tfid1.setCellValueFactory(new PropertyValueFactory<>("id"));
            tfnom1.setCellValueFactory(new PropertyValueFactory<>("nomVolontaire"));
            tfprenom1.setCellValueFactory(new PropertyValueFactory<>("prenomVolontaire"));
             tfadresse1.setCellValueFactory(new PropertyValueFactory<>("adresseVolontaire")); 
             tfcontact1.setCellValueFactory(new PropertyValueFactory<>("telephoneVolontaire")); 
             tfmail1.setCellValueFactory(new PropertyValueFactory<>("mail")); 
             tfasso.setCellValueFactory(new PropertyValueFactory<>("Association")); 
                      table1.setItems(oblist1);
             
             
             
             
             }

    

   
    @FXML
    private void order(ActionEvent event) {
    }
    
    


    @FXML
    private void lastnew(ActionEvent event) {
    }

    @FXML
    private void retour(ActionEvent event) {
        try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/Login.fxml")
                    );
            
            Parent root2 = loader.load();
            controllers.LoginController dpc = loader.getController();
           
            affvolontaire1.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }
    
}
