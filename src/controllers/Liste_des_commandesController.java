/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import entities.Commandes;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.myconnection;

/**
 * FXML Controller class
 *
 * @author Achref
 */
public class Liste_des_commandesController implements Initializable {

    @FXML
    private Button txt;
    @FXML
   private TableColumn<Commandes,Integer> code;
    @FXML
    private TableColumn<Commandes,String> commande;
    @FXML
    private TableColumn<Commandes,Integer> quantité;
    @FXML
    private TableColumn<Commandes,String> description;
     @FXML
    private TableColumn<Commandes,String> statu;
    @FXML
    private TableView<Commandes> table;
 
    
    ObservableList<Commandes> oblist = FXCollections.observableArrayList(); 
    @FXML
    private TableColumn<Commandes,String> adresse;
    @FXML
    private TableColumn<Commandes,Integer> telephone;
    @FXML
    private Button retour;
    
          
          
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        try {
            Connection  con = myconnection.conDB();
            
            ResultSet rs =  con.createStatement().executeQuery("select * from commande");
            
            while (rs.next())
                
            {
                oblist.add(new Commandes (rs.getInt("code"),rs.getString("commande"),rs.getString("quantité"),
                        rs.getString("description"),rs.getString("status")  ));   
           
            
            }
              } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        
        
            // TODO
            code.setCellValueFactory(new PropertyValueFactory<>("code"));
              commande.setCellValueFactory(new PropertyValueFactory<>("commande"));
           
            quantité.setCellValueFactory(new PropertyValueFactory<>("quantité"));
           description.setCellValueFactory(new PropertyValueFactory<>("description")); 
             statu.setCellValueFactory(new PropertyValueFactory<>("status")); 

               table.setItems(oblist);
        
    }    

    

    @FXML
    private void retour(ActionEvent event) {
        
          try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/Login.fxml")
                    );
            
            Parent root2 = loader.load();
            controllers.LoginVolontaireController dpc = loader.getController();
           
            txt.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

   
    
    
    

    @FXML
    private void accept(ActionEvent event) {
        String req3="UPDATE commande SET  status=? WHERE code=?";
              Connection  con = myconnection.conDB();
          try {
            PreparedStatement p3 = con.prepareStatement(req3);
             Commandes index = table.getSelectionModel().getSelectedItem();
             status.setText(statu.getCellData(index).toString());
            
             p3.executeUpdate();
             System.out.println("Personne Modifié");
                    } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
    }
    
}
