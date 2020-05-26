
package application_covid.tests;
import com.google.gson.JsonObject;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataProviderService {
      public void getData(String countryName){ 
        
            Retrofit retrofit;
          retrofit = new Retrofit.Builder()
                  .baseUrl("https://coronavirus-19-api.herokuapp.com/")
                  .addConverterFactory(GsonConverterFactory.create())
                  .build();
            CovidApi covidApi = retrofit.create(CovidApi.class);
            covidApi.getGlobalData()
                    .enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> rspns) {
                    System.out.println(rspns.body());
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable thrwbl) {
                    
                }
            });
    }
            
}
