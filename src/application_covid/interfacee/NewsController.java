/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.interfacee;


import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.jfoenix.controls.JFXButton;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Rihab
 */
public class NewsController implements Initializable , MapComponentInitializedListener {

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
    
    private GoogleMapView mapView;
    
    private GoogleMap map;
    @FXML
    private Button btnT;
    @FXML
    private Button btnAr;
    @FXML
    private Button btnM;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapView.addMapInializedListener(this);
    }

    @Override
    public void mapInitialized() {
        LatLong joeSmithLocation = new LatLong(47.6197, -122.3231);
        LatLong joshAndersonLocation = new LatLong(47.6297, -122.3431);
        LatLong bobUnderwoodLocation = new LatLong(47.6397, -122.3031);
        LatLong tomChoiceLocation = new LatLong(47.6497, -122.3325);
        LatLong fredWilkieLocation = new LatLong(47.6597, -122.3357);
        
        
        //Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();
        
        mapOptions.center(new LatLong(47.6097, -122.3331))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(12);
                   
        map = mapView.createMap(mapOptions);

        //Add markers to the map
        MarkerOptions markerOptions1 = new MarkerOptions();
        markerOptions1.position(joeSmithLocation);
        
        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.position(joshAndersonLocation);
        
        MarkerOptions markerOptions3 = new MarkerOptions();
        markerOptions3.position(bobUnderwoodLocation);
        
        MarkerOptions markerOptions4 = new MarkerOptions();
        markerOptions4.position(tomChoiceLocation);
        
        MarkerOptions markerOptions5 = new MarkerOptions();
        markerOptions5.position(fredWilkieLocation);
        
        Marker joeSmithMarker = new Marker(markerOptions1);
        Marker joshAndersonMarker = new Marker(markerOptions2);
        Marker bobUnderwoodMarker = new Marker(markerOptions3);
        Marker tomChoiceMarker= new Marker(markerOptions4);
        Marker fredWilkieMarker = new Marker(markerOptions5);
        
        map.addMarker( joeSmithMarker );
        map.addMarker( joshAndersonMarker );
        map.addMarker( bobUnderwoodMarker );
        map.addMarker( tomChoiceMarker );
        map.addMarker( fredWilkieMarker );
        
        InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
        infoWindowOptions.content("<h2>Fred Wilkie</h2>"
                                + "Current Location: Safeway<br>"
                                + "ETA: 45 minutes" );

        InfoWindow fredWilkeInfoWindow = new InfoWindow(infoWindowOptions);
        fredWilkeInfoWindow.open(map, fredWilkieMarker);
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
    private void btnM(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Maps.fxml"));
            Parent root2= loader.load();
            NewsController dpc= loader.getController();
            tf3.getScene().setRoot(root2);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }         
    }

    @FXML
    private void btnT(ActionEvent event) {
    }

    @FXML
    private void btnAr(ActionEvent event) {
    }

}
