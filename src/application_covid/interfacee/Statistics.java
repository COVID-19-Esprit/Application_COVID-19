package application_covid.interfacee;

import com.mysql.jdbc.Buffer;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.apache.commons.io.IOUtils;

public class Statistics extends Application {

    private static HttpURLConnection conn;
    BufferedReader reader;
    String line;
    StringBuffer response = new StringBuffer();

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Statistics.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setTitle("Statistics");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static void main(String[] args) {
        launch(args);
        /* try {

            
            URL url = new URL ("https://coronavirus-19-api.herokuapp.com/all");
            conn = (HttpURLConnection) url.openConnection();
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
              System.out.println(cases); 
              System.out.println(deaths); 
              System.out.println(recoverd); 
  
            }
        } catch (IOException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}
