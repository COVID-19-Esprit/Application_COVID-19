/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.interfacee;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.mysql.jdbc.Buffer;
import com.teknikindustries.yahooweather.WeatherDisplay;
import com.teknikindustries.yahooweather.WeatherDoc;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.Thread.sleep;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.apache.commons.io.IOUtils;
import com.teknikindustries.yahooweather.WeatherDisplay;
import com.teknikindustries.yahooweather.WeatherDoc;
import java.io.BufferedInputStream;


/**
 * FXML Controller class
 *
 * @author A
 */
public class WordStatisticsController implements Initializable {
    @FXML
    private Label colCases;
    private static HttpURLConnection conn;
    BufferedReader reader ; 
    String line;
    StringBuffer response = new StringBuffer();
    @FXML
    private Label colDeaths;
    @FXML
    private Label colRec;
    @FXML
    private Label clocklbl;
    
    public void ChangeBack(ActionEvent event) throws IOException {
    Parent WorldStaticParent = FXMLLoader.load(getClass().getResource("Statistics.fxml"));
    Scene WorldStaticScene = new Scene(WorldStaticParent);
    
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(WorldStaticScene);
    window.show();

   }
    
    
        public void ChangeBacktohome(ActionEvent event) throws IOException {
    Parent StaticParent = FXMLLoader.load(getClass().getResource("Home_page.fxml"));
    Scene StaticScene = new Scene(StaticParent);
    
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(StaticScene);
    window.show();

   }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            
            URL urlCon = new URL ("https://coronavirus-19-api.herokuapp.com/all");
            conn = (HttpURLConnection) urlCon.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(8000);
            conn.setReadTimeout(5000);
            
            int stat = conn.getResponseCode();
            //System.out.println(stat);
            if(stat>299){
            
                System.out.println("Error connection!"+stat);
            }else{
             
                InputStream in = new BufferedInputStream(conn.getInputStream());
                String res = IOUtils.toString(in,"UTF-8");
                String cases;
                String deaths;
                String recoverd;
                int len , com ; 

                System.out.println(res); 
                //System.out.println(ob);
                String[] arrSplit_3 = res.split("\\:");
                 cases = arrSplit_3[1];
                 deaths = arrSplit_3[2];
                 recoverd = arrSplit_3[3];
              String[] arrCases = cases.split("\\,");
              String[] arrDeaths = deaths.split("\\,");
              String[] arrRec = recoverd.split("\\,");
              cases = arrCases[0];
              deaths = arrDeaths[0];
              recoverd = arrRec[0];
              String recCopy = String.copyValueOf(recoverd.toCharArray(), 0, recoverd.length()-1);
             /* System.out.println(cases); 
              System.out.println(deaths); 
              System.out.println(recCopy);*/
              colCases.setText(cases);  
              colDeaths.setText(deaths);
              colRec.setText(recCopy);

                Calendar cal=new GregorianCalendar();
                
                int day =cal.get(Calendar.DAY_OF_MONTH);
                int month =cal.get(Calendar.MONTH);
                int year =cal.get(Calendar.YEAR);
                clocklbl.setText(day+"/"+month+"/"+year);
 

               WeatherDoc doc= new WeatherDoc("36.8688529","10.1353404,13z");
               WeatherDisplay disp = new WeatherDisplay();
               System.out.println(disp.getTemperature());
               System.out.println(disp.getHumidity());

               
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
