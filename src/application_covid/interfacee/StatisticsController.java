/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.interfacee;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import com.teknikindustries.yahooweather.WeatherDisplay;
import com.teknikindustries.yahooweather.WeatherDoc;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.mysql.jdbc.Buffer;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import com.teknikindustries.yahooweather.WeatherDisplay;
import com.teknikindustries.yahooweather.WeatherDoc;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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

/**
 * FXML Controller class
 *
 * @author A
 */
public class StatisticsController implements Initializable {

    private TextField col_temp;
    @FXML
    private Label colCases;
    private static HttpURLConnection conn;
    BufferedReader reader ; 
    String line;
    StringBuffer response = new StringBuffer();
    @FXML
    private Label colRecoverd;
    @FXML
    private Label colDeaths;
    @FXML
    private Label colCritical;
    @FXML
    private Label colTests;
    @FXML
    private Label colTodayCases;
    @FXML
    private Label colTodayDeaths;
    @FXML
    private Label colPer;
    
    public void ChangeScreenWorld(ActionEvent event) throws IOException {
    Parent WorldStaticParent = FXMLLoader.load(getClass().getResource("WordStatistics.fxml"));
    Scene WorldStaticScene = new Scene(WorldStaticParent);
    
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(WorldStaticScene);
    window.show();

   }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
  try {
            
            URL ur = new URL ("https://coronavirus-19-api.herokuapp.com/countries/tunisia");
            conn = (HttpURLConnection) ur.openConnection();
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
                String todayCases;
                String deaths;
                String todayDeaths;
                String recovered;
                String activeCases;
                String critical;
                String totalTests,percentage;
                int casesInt,recoverdInt,per;  
                
                //System.out.println(res);
                Object ob = res ; 
                //System.out.println(ob);
                String[] arrSplit_3 = res.split("\\,");
                     cases = arrSplit_3[1];
                     todayCases = arrSplit_3[2];
                     deaths = arrSplit_3[3];
                     todayDeaths = arrSplit_3[4];
                     recovered = arrSplit_3[5];
                     activeCases = arrSplit_3[6];
                     critical = arrSplit_3[7];
                     totalTests = arrSplit_3[10];
               String[] arrCases = cases.split("\\:");
               String[] arrRec = recovered.split("\\:");
               String[] arrtodCases = todayCases.split("\\:");
               String[] arrDeaths = deaths.split("\\:");
               String[] arrtodayDeaths = todayDeaths.split("\\:");
               String[] arrActive = activeCases.split("\\:");
               String[] arrCritical = critical.split("\\:");
               String[] arrTests = totalTests.split("\\:");
               cases = arrCases[1];
               recovered = arrRec[1];
               todayCases = arrtodCases[1];
               deaths = arrDeaths[1];
               todayDeaths = arrtodayDeaths[1];
               activeCases = arrActive[1];
               critical = arrCritical[1];
               totalTests = arrTests[1];
                //System.out.println(totalTests);
               casesInt = Integer.parseInt(cases);
               recoverdInt = Integer.parseInt(recovered);
               per = (recoverdInt/casesInt)*100;
               percentage = (per +"%") ;
               
              colCases.setText(cases);  
              colRecoverd.setText(recovered);
              colDeaths.setText(deaths);
              colCritical.setText(activeCases);
              colTests.setText(totalTests);
              colTodayCases.setText(todayCases);
              colTodayDeaths.setText(todayDeaths);
              colPer.setText(percentage);
            }
        } catch (IOException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
