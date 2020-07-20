/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.interfacee;

import application_covid.entities.Information;
import application_covid.services.InformationCRUD;
import application_covid.utils.MyConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Rihab
 */
public class ProtectYourselfController implements Initializable {

    @FXML
    private JFXButton tf1;
    @FXML
    private JFXButton tf2;
    @FXML
    private JFXButton tf3;
    @FXML
    private JFXButton tf4;
    @FXML
    private JFXButton tf;
    @FXML
    private ImageView imV1;
    @FXML
    private ImageView imV6;
    @FXML
    private ImageView imV5;
    @FXML
    private ImageView imV4;
    @FXML
    private ImageView imV3;
    @FXML
    private ImageView imV2;
    @FXML
    private Button tfa;
    @FXML
    private Button tfb;
    @FXML
    private Button tfc;
    @FXML
    private Button tfd;
    @FXML
    private Button tfe;
    @FXML
    private Button tff;
    @FXML
    private TextArea l2;
    @FXML
    private Label l1;
    @FXML
    private ImageView imv;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn1(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WhatIsCovid.fxml"));
            Parent root2= loader.load();
            WhatIsCovidController dpc= loader.getController();
            tf.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    private void btn2(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProtectYourself.fxml"));
            Parent root2= loader.load();
            ProtectYourselfController dpc= loader.getController();
            tf1.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }        
    }

    @FXML
    private void btn3(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("QuizTest.fxml"));
            Parent root2= loader.load();
            QuizTestController dpc= loader.getController();
            tf2.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }        
    }

    @FXML
    private void btn4(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("News.fxml"));
            Parent root2= loader.load();
            NewsController dpc= loader.getController();
            tf3.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }        
    }

    @FXML
    private void btn5(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
            Parent root2= loader.load();
            SignInController dpc= loader.getController();
            tf4.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }        
    }
    /* public void displayInfo(){
        Connection cnx;
        cnx = MyConnection.getInstance().getCnx();
        try {
            
            String requete = "SELECT * FROM information WHERE id=1";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){               
                l1.setText(rs.getString("titre"));
                l2.setText(rs.getString("content"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   } */
   
    @FXML
    private void btna(ActionEvent event) {
        Connection cnx;
        cnx = MyConnection.getInstance().getCnx();
        try {
            
            String requete = "SELECT * FROM information WHERE id=1";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){               
                l1.setText(rs.getString("titre"));
                l2.setText(rs.getString("content"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void btnb(ActionEvent event) {
        Connection cnx;
        cnx = MyConnection.getInstance().getCnx();
        try {
            
            String requete = "SELECT * FROM information WHERE id=2";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){               
                l1.setText(rs.getString("titre"));
                l2.setText(rs.getString("content"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void btnc(ActionEvent event) {
        Connection cnx;
        cnx = MyConnection.getInstance().getCnx();
        try {
            
            String requete = "SELECT * FROM information WHERE id=3";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){               
                l1.setText(rs.getString("titre"));
                l2.setText(rs.getString("content"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void btnd(ActionEvent event) {
        Connection cnx;
        cnx = MyConnection.getInstance().getCnx();
        try {
            
            String requete = "SELECT * FROM information WHERE id=4";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){               
                l1.setText(rs.getString("titre"));
                l2.setText(rs.getString("content"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void btne(ActionEvent event) {
        Connection cnx;
        cnx = MyConnection.getInstance().getCnx();
        try {
            
            String requete = "SELECT * FROM information WHERE id=5";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){               
                l1.setText(rs.getString("titre"));
                l2.setText(rs.getString("content"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void btnf(ActionEvent event) {
        Connection cnx;
        cnx = MyConnection.getInstance().getCnx();
        try {
            
            String requete = "SELECT * FROM information WHERE id=6";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){               
                l1.setText(rs.getString("titre"));
                l2.setText(rs.getString("content"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
