/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import entities.Utilisateur_Malade;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

/**
 * FXML Controller class
 *
 * @author Achref
 */
public class Interface_inscription_maladeController implements Initializable {
  
   // private TextField tfid;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private DatePicker tfage;
    @FXML
    private TextField tfadresse;
    @FXML
    private TextField tftelephone;
    @FXML
    private TextField tfmail;
    @FXML
    private TextField tfmdp;
   
    //  @FXML
   // private Label error_id;
     @FXML
    private Label error_nom;
      @FXML
    private Label error_prenom;
    @FXML
    private Label error_mdp;
    @FXML
    private Label error_mail;
    @FXML
    private Label error_contact;
    @FXML
    private Label error_adresse;
    @FXML
    private Label error_date;
     
  
    ValidationSupport valide = new ValidationSupport();
    /**
     * Initializes the controller class.
     */
    
    public static boolean isTextFieldNotEmpty(TextField tff)
    {boolean b= false ;
     if (tff.getText().length() !=0 || !tff.getText().isEmpty())
         b=true;
     return  b; 
         }
    
    
    public static boolean isTextFieldTypeNumber(TextField tff)
    {boolean b= false ;
     if (tff.getText().matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+"));
         b=true;
     return  b; 
         }
    
    
   /* public static boolean isDateNotEmpty(DatePicker tf)
    {boolean b= false ;
     if (tf.getDayCellFactory().equals("") )
         b=true;
     return  b; 
         }*/
    
    
     public static boolean isTextFieldNotEmpty( TextField tff , Label lb , String erroemessage )
    {boolean b= true ;
    String msg=null;
     if (!isTextFieldNotEmpty(tff))
     {   b=false;
     msg=erroemessage;
         }
     lb.setText(msg);
     return  b; 
    }
     
     
      public static boolean isTextFieldTypeNumber( TextField tff , Label lb , String erroemessage )
    {boolean b= true ;
    String msg=null;
     if (!isTextFieldTypeNumber(tff))
     {   b=true;
     msg=erroemessage;
         }
     lb.setText(msg);
     return  b; 
    }
   
    /* public static boolean isDateNotEmpty(DatePicker tf , Label lb , String erroemessage )
    {boolean b= true ;
    String msg=null;
     if (!isDateNotEmpty(tf))
     {   b=false;
     msg=erroemessage;
         }
     lb.setText(msg);
     return  b; 
    }
   
 */
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
     //  valide.registerValidator(tfid,Validator.createEmptyValidator("Test is required")) ; 
    valide.registerValidator(tfnom,Validator.createEmptyValidator("")) ;     
    valide.registerValidator(tfprenom,Validator.createEmptyValidator("")) ;     
    valide.registerValidator(tfadresse,Validator.createEmptyValidator("")) ;     
  //  valide.registerValidator(tfage,Validator.createEmptyValidator("Test is required")) ;     
    valide.registerValidator(tftelephone,Validator.createEmptyValidator("")) ;     
    valide.registerValidator(tfmail,Validator.createEmptyValidator("")) ;     
    valide.registerValidator(tfmdp,Validator.createEmptyValidator("")) ; 
    
}    

    
    
  /*   
    private boolean  valideEmail()
    {
      Pattern p =  Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
       Matcher m = p.matcher(tfmail.getText());
     
        if (m.find() && m.group().equals(tfmail.getText()));
        {   System.out.println("email valider");
            return  true; 
        }
        
        /*else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate Number");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Valid Mail ");
                alert.showAndWait();
                     return false;

                }*/
     //   else 
       // {return false;}
      
       //return false;
        
   // }
   
  
   

/*
   
    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }  
*/
    @FXML
    private void retour(ActionEvent event) {
        
         try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/Login.fxml")
                    );
            
            Parent root2 = loader.load();
           LoginController dpc = loader.getController();
           
            tfnom.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }

   
            ;
    
    
   private void clear()
   { 
       tfadresse.setText(null);
       tfmail.setText(null);
       tfmdp.setText(null);
       tfnom.setText(null);
       tfprenom.setText(null);
       tftelephone.setText(null);
     }
    
    @FXML
    private void ajouterMalade(ActionEvent event) {
              //  boolean idempty = isTextFieldNotEmpty(tfid, error_id,"erroemessage");
                boolean nomempty = isTextFieldNotEmpty(tfnom, error_nom,"What is your name ?");
                boolean prenomempty = isTextFieldNotEmpty(tfprenom, error_prenom,"What is your name ?");
               // boolean ageempty = isDateNotEmpty(tfage, error_date,"erroemessage");
                boolean adresseempty = isTextFieldNotEmpty(tfadresse, error_adresse,"What is your adress ?");
                boolean teleempty = isTextFieldNotEmpty(tftelephone, error_contact,"Give your phone number ?");
                boolean mailempty = isTextFieldNotEmpty(tfmail, error_mail,"Check your email");
                boolean mdpempty = isTextFieldNotEmpty(tfmdp, error_mdp,"Check your password");
     //*******************************************************************************//
      Utilisateur_Malade um = new Utilisateur_Malade();
            um.setNomMalade(tfnom.getText());
             um.setPrenomMalade(tfprenom.getText());
            um.setAgeMalade(tfage.getValue().toString());
            um.setAdresseMalade(tfadresse.getText());
            um.setTelephoneMalade(tftelephone.getText());
            um.setMailMalade(tfmail.getText());
            um.setCode(tfmdp.getText());
            
if (nomempty && prenomempty && adresseempty  && teleempty &&mailempty && mdpempty )
     { services.Inscription_Malade pcd = new services.Inscription_Malade();
            pcd.ajouterMalade(um);
            
         Notifications notif = Notifications.create().title("Succes").text("Add successfully").graphic(null).hideAfter(Duration.seconds(7)).position(Pos.BOTTOM_RIGHT);
            notif.showConfirm();
           clear();
    
         try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/Login.fxml")
                    );
            
            Parent root2 = loader.load();
           LoginController dpc = loader.getController();
           
            tfnom.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
     
     }
   else {System.out.println("erreur d'insertion");
Notifications notif = Notifications.create().title("Error").text("Insertion error").graphic(null).hideAfter(Duration.seconds(7)).position(Pos.BOTTOM_RIGHT);
            notif.showConfirm();
}
     
     
     

    }
}
    

        
        

