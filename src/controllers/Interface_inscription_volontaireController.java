/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.Interface_inscription_maladeController.isTextFieldNotEmpty;
import entities.Utilisateur_Volontaire;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
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
public class Interface_inscription_volontaireController implements Initializable {

    
    @FXML
    private TextField tfnomm;
    @FXML
    private TextField tfprenomm;
    @FXML
    private TextField tfadd;
    @FXML
    private TextField tftelephonee;
    @FXML
    private TextField tfmaill;
     @FXML

    private TextField tfasso;
    @FXML
    private TextField tfmp;
    @FXML
    private Button lastnew;
    @FXML
    private Button order;
    @FXML
    private Label errnom;
    @FXML
    private Label errnom1;
    @FXML
    private Label erradresse;
    @FXML
    private Label errcontact;
    @FXML
    private Label errnail;
    @FXML
    private Label errmdp;
    @FXML
    private Label errassocia;
    ValidationSupport valide = new ValidationSupport();

    
     public static boolean isTextFieldNotEmpty(TextField tff)
    {boolean b= false ;
     if (tff.getText().length() !=0 ||!tff.getText().isEmpty())
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
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //  valide.registerValidator(tfid,Validator.createEmptyValidator("Test is required")) ; 
    valide.registerValidator(tfnomm,Validator.createEmptyValidator("")) ;     
    valide.registerValidator(tfprenomm,Validator.createEmptyValidator("")) ;     
    valide.registerValidator(tfadd,Validator.createEmptyValidator("")) ;     
    valide.registerValidator(tftelephonee,Validator.createEmptyValidator("")) ;     
    valide.registerValidator(tfmaill,Validator.createEmptyValidator("")) ;     
    valide.registerValidator(tfmp,Validator.createEmptyValidator("")) ; 
    }    

    @FXML
    private void ajoutervolontaire(ActionEvent event) {
              //  boolean idempty = isTextFieldNotEmpty(tfid, error_id,"erroemessage");
                boolean nomempty = isTextFieldNotEmpty(tfnomm, errnom,"What is your name ?");
                boolean prenomempty = isTextFieldNotEmpty(tfprenomm, errnom1,"What is your name ?");
               // boolean ageempty = isDateNotEmpty(tfage, error_date,"erroemessage");
                boolean adresseempty = isTextFieldNotEmpty(tfadd, erradresse,"What is your adress ?");
                boolean teleempty = isTextFieldNotEmpty(tftelephonee, errcontact,"Give your phone number ?");
                 boolean mailempty = isTextFieldNotEmpty(tfmaill, errnail,"Check your email");
                boolean mdpempty = isTextFieldNotEmpty(tfmp, errmdp,"Check your password");
              //   boolean assempty = isTextFieldNotEmpty(tfasso, errassocia,"What's your association name?");

        
        
        
        
           Utilisateur_Volontaire uv = new Utilisateur_Volontaire();
      
            uv.setNomVolontaire(tfnomm.getText());
            uv.setPrenomVolontaire(tfprenomm.getText());
            uv.setAdresseVolontaire(tfadd.getText());
            uv.setTelephoneVolontaire(tftelephonee.getText());
            uv.setMail(tfmaill.getText());
            uv.setAssociation(tfasso.getText());
            uv.setCode(tfmp.getText());

      if (nomempty && prenomempty && adresseempty  && teleempty &&mailempty && mdpempty )
     {       
            services.Inscription_Volontaire pcd = new services.Inscription_Volontaire();
            pcd.ajouteruv(uv);
              Notifications notif = Notifications.create().title("Succes").text("Add successfully").graphic(null).hideAfter(Duration.seconds(7)).position(Pos.BOTTOM_RIGHT);
            notif.showConfirm();
                
         try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/Login.fxml")
                    );
            
            Parent root2 = loader.load();
           LoginController dpc = loader.getController();
           
            tfnomm.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
            
      }
     else {System.out.println("erreur d'insertion");
Notifications notif = Notifications.create().title("Error").text("Insertion error").graphic(null).hideAfter(Duration.seconds(7)).position(Pos.BOTTOM_RIGHT);
            notif.showConfirm();
}
    }
    
    
    @FXML
    private void retour(ActionEvent event) {
         try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/Login.fxml")
                    );
            
            Parent root2 = loader.load();
            LoginController dpc = loader.getController();
           
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
