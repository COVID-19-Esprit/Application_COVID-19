/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static controllers.Interface_inscription_volontaireController.isTextFieldNotEmpty;
import entities.Commandes;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import static services.JavaMailUtil.code;
import utils.myconnection;

/**
 * FXML Controller class
 *
 * @author Achref
 */
public class PassCommandeController implements Initializable {

    @FXML
    private TextField commande;
    @FXML
    private TextField quantité;
    @FXML
    private Button retour;
    @FXML
    private TextField description;
    @FXML
    private TableView<Commandes> table;
    @FXML
    private TableColumn<Commandes,String> prod;
    @FXML
    private TableColumn<Commandes,String> quantitprod;
    @FXML
    private TableColumn<Commandes,String> descrproduit;
   ObservableList<Commandes> oblist = FXCollections.observableArrayList(); 
    @FXML
    private TableColumn<Commandes,Integer> tfcode;
    @FXML
    private Label tfc1;
    /**
     * Initializes the controller class.
     */
     ValidationSupport valide = new ValidationSupport();
    @FXML
    private Label e1;
    @FXML
    private Label e2;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           affiche();
       
           
    }    

    @FXML
    private void retour(ActionEvent event) {
            try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/Commande.fxml")
                    );
            
            Parent root2 = loader.load();
            controllers.CommandeController dpc = loader.getController();
           
            commande.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

    @FXML
    private void ajouter(ActionEvent event) {
         /*  valide.registerValidator(commande,Validator.createEmptyValidator("")) ;     
           valide.registerValidator(description,Validator.createEmptyValidator("")) ;     
           valide.registerValidator(quantité,Validator.createEmptyValidator("")) ; */
          boolean nomempty = isTextFieldNotEmpty(commande,e1,"Give your order !");
          boolean adresseempty = isTextFieldNotEmpty(quantité,e2,"Quantité");
          Commandes um = new Commandes();
               um.setCommande(commande.getText());
            um.setQuantité(quantité.getText());
            um.setDescription(description.getText());
            
                   if (nomempty  && adresseempty )
           {      
        services.Ajouter_commande pcd = new services.Ajouter_commande();
            pcd.ajoutercommande(um);
            
           commande.setText(null);
            quantité.setText(null);
            description.setText(null);
              Notifications notif = Notifications.create().title("Succes").text("Commande ajouter avec succes").graphic(null).hideAfter(Duration.seconds(7)).position(Pos.BOTTOM_RIGHT);
            notif.showConfirm();}
        
    }

  
    @FXML
    private void supprimer(ActionEvent event) {
        Connection  con = myconnection.conDB();
           String sql= "DELETE FROM commande where code=?";
           try{
         PreparedStatement pst = con.prepareStatement(sql);
         
           Commandes index = table.getSelectionModel().getSelectedItem();
         tfc1.setText(tfcode.getCellData(index).toString());
         
           pst.setString(1,tfc1.getText());
            pst.executeUpdate();
           table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
               System.out.println("Delete");
             
           } catch (Exception ex)
           {            System.err.println(ex.getMessage());        }
  
    }

  public void affiche()
  {  Connection  con = myconnection.conDB();
        try { 
            ResultSet rs =  con.createStatement().executeQuery("select * from commande");
            while (rs.next())
                
            {
                oblist.add(new Commandes (rs.getInt("code"),rs.getString("commande"),
                        rs.getString("quantité"),
                        rs.getString("description"),rs.getString("status"))); 
                
              
                }
              } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
             
               // TODO
                tfcode.setCellValueFactory(new PropertyValueFactory<>("code"));
            prod.setCellValueFactory(new PropertyValueFactory<>("commande"));
            quantitprod.setCellValueFactory(new PropertyValueFactory<>("quantité"));
            descrproduit.setCellValueFactory(new PropertyValueFactory<>("description"));
           
               table.setItems(oblist);}
    
    
    
    
    @FXML
    public void update(ActionEvent event) {
          String req3="UPDATE commande SET  commande=? , quantité = ? , description=? WHERE code=?";
              Connection  con = myconnection.conDB();
      /*  try {
            PreparedStatement p3 = con.prepareStatement(req3);
             p3.setInt(3,code.getText());
             p3.setString(1,p.getNom());
             p3.setString(2,p.getPrenom());
             p3.executeUpdate();
             System.out.println("Personne Modifié");
                    } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());        }*/
        
        }
    
    
        private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    @FXML
    private void refreche(ActionEvent event) {
        
        oblist.clear();
        affiche();
        
    }
}
