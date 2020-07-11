/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.interfacee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Achref
 */
public class Home_pageController implements Initializable {

    private Button txt;
    @FXML
    private Button order;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    public void ChangeScreenStatistic(ActionEvent event) throws IOException {
    Parent StaticParent = FXMLLoader.load(getClass().getResource("Statistics.fxml"));
    Scene StaticScene = new Scene(StaticParent);
    
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(StaticScene);
    window.show();

   }
   public void ChangeScreenLogin(ActionEvent event) throws IOException {
    Parent LoginParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
    Scene LoginScene = new Scene(LoginParent);
    
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(LoginScene);
    window.show();

   }
      public void ChangeScreenInscrit(ActionEvent event) throws IOException {
    Parent LoginParent = FXMLLoader.load(getClass().getResource("InscriptionMembre.fxml"));
    Scene LoginScene = new Scene(LoginParent);
    
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(LoginScene);
    window.show();

   }
    public void ChangeScreenQuiz(ActionEvent event) throws IOException {
    Parent LoginParent = FXMLLoader.load(getClass().getResource("Quiz.fxml"));
    Scene LoginScene = new Scene(LoginParent);
    
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(LoginScene);
    window.show();

   }


}  

  /*  @FXML
    private void order(ActionEvent event) {
        
            try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/interfacee/Login.fxml")
                    );
            
            Parent root2 = loader.load();
            controllers.LoginController dpc = loader.getController();
           
            order.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());        }
    }
*/
   /* @FXML
    private void lastnew(ActionEvent event) {
    }*/
    //}
    
    

