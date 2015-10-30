package modules.serviceModule;

import modules.Module;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by apryakhin on 28.10.2015.
 */
public class WeatherService extends Module implements serviceModuleInterface{
    protected String base = "http://api.openweathermap.org/data/2.5/weather?q=";
    protected String key  = "appid=997b6111d6996259c286d92520b9d6ab";

    protected String urlRequest;
    protected String jsonResponse;

    protected String searchCity;
    protected String weatherCity;
    protected double longitude;

    public WeatherService(String searchCity){
        // TODO переделать получение города от пользователя
        this.searchCity = /*searchCity*/"Moscow";
    }

    public void requestWeather() throws IOException {
        this.urlRequest = this.base + this.searchCity + "&" + this.key;

        this.getResponse();
        this.proceedResponse();
    }

    public String getWeatherCity(){
        return this.weatherCity;
    }

    protected void getResponse() throws IOException {
        Exchange myExchangeObject = new Exchange();
        myExchangeObject.setTarget(this.urlRequest);
        myExchangeObject.createRequest();
        this.jsonResponse = myExchangeObject.getContent();
    }

    protected void proceedResponse(){
        JSONObject obj = new JSONObject(this.jsonResponse);
        int response = obj.getInt("cod");
        if(response == 200){
            this.weatherCity = obj.getString("name");
            this.longitude = obj.getJSONObject("coord").getDouble("lon");

            System.out.println();
            System.out.println("I've found city " + this.weatherCity);
            System.out.println("Longitude " + longitude);
        }
        else{
            System.out.println("Service is temporary unavailable");
        }
    }
}
