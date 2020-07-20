/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.interfacee;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author Rihab
 */
public class WhatIsCovidController implements Initializable {

    @FXML
    private JFXButton tf4;
    @FXML
    private JFXButton tf3;
    @FXML
    private JFXButton tf2;
    @FXML
    private JFXButton tf1;
    @FXML
    private JFXButton tf;
    @FXML
    private MediaView mV;
    private MediaPlayer mediaPlayer;
    private Media media;
    @FXML
    private Slider volume;
    @FXML
    private Button btnv1;
    @FXML
    private Button btnv2;
    @FXML
    private Button btnv3;



    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL location , ResourceBundle resources) {
        String path = new File("src/vedio/What is COVID-19.mp4").getAbsolutePath();
        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mV.setMediaPlayer(mediaPlayer);
        volume.setValue(mediaPlayer.getVolume()*100);
        volume.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mediaPlayer.setVolume(volume.getValue()/100);
            }
        });
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
    
    @FXML
    private void play(ActionEvent event) {
        mediaPlayer.play();
    }

    @FXML
    private void pause(ActionEvent event) {
        mediaPlayer.pause();
    }

    @FXML
    private void stop(ActionEvent event) {
        mediaPlayer.seek(mediaPlayer.getStopTime());
        mediaPlayer.stop();
    }


    

}
