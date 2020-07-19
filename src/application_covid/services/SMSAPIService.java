package application_covid.services;



import application_covid.entities.SMSOAuthObject;
import application_covid.utils.ParameterStringBuilder;
import application_covid.utils.SMSBodyBuilder;
import org.joda.time.DateTime;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.Map;
import org.json.*;


public class SMSAPIService {
    private HttpClient  client = HttpClient.newHttpClient();
    private static SMSOAuthObject oauth;

    public static SMSAPIService instance;

    public static SMSAPIService getInstance() {
        if (instance == null) instance = new SMSAPIService();
        refreshToken();
        return instance;
    }

    public static void refreshToken() {

            /// ToDo Time of expiration > now
            try {
                URL url = new URL("https://api.orange.com/oauth/v2/token");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Authorization","Basic THdGNk9LSk5TaHJkQ3BxZk9lZEJoVHNUQXhjbHBBb206ZWVKYncxeHVZeU1RWVJlOQ==");
                Map<String,String> parameters = new HashMap<>();
                parameters.put("grant_type","client_credentials");
                connection.setDoOutput(true);
                DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
                out.flush();
                out.close();
                int responseCode = connection.getResponseCode();
                System.out.println(responseCode);
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    System.out.println(response.toString());
                    JSONObject jsonObject = new JSONObject(response.toString());
                    oauth = new SMSOAuthObject(
                            jsonObject.getString("token_type"),
                            jsonObject.getString("access_token"),
                            jsonObject.getString("expires_in")
                    );

                }

            } catch (IOException e) {
                e.printStackTrace();
            }


    }

    public static boolean sendSMS(String developerPhoneNumber,String clientPhoneNumber,String message) {
        refreshToken();
        if (oauth != null) {
            try {
                URL url = new URL("https://api.orange.com/smsmessaging/v1/outbound/tel%3A%2B"+developerPhoneNumber+"/requests");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Authorization","Bearer "+oauth.getAccessToken());
                connection.setRequestProperty("Content-Type","application/json");
                Map<String,String> body = new HashMap<>();
                body.put("address",clientPhoneNumber);
                body.put("senderAddress",developerPhoneNumber);
                body.put("message",message);
                connection.setDoOutput(true);
                DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                System.out.println(SMSBodyBuilder.getBodyString(body));
                out.writeBytes(SMSBodyBuilder.getBodyString(body));
                out.flush();
                out.close();
                int responseCode = connection.getResponseCode();
                System.out.println(responseCode);
                if (responseCode == HttpURLConnection.HTTP_CREATED) return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }

        }
        return false;
    }





}
