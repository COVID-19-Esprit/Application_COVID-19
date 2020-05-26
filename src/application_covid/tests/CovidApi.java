
package application_covid.tests;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


        
public interface CovidApi {
    @GET("https://coronavirus-19-api.herokuapp.com/all")
    Call<JsonObject> getGlobalData();
    
    @GET("https://coronavirus-19-api.herokuapp.com/countries/{countryName}")
    Call<JsonObject> getCountryData(@Path(value = "countryName")String countryName);
    
    
}
