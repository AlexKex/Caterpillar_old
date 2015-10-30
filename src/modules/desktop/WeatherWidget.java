package modules.desktop;

import modules.Module;
import modules.serviceModule.WeatherService;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by apryakhin on 28.10.2015.
 */
public class WeatherWidget extends Widget implements desktopModuleInterface {
    protected WeatherService myServiceModule;
    protected HashMap<String, Object> data;

    public WeatherWidget(){
        String searchCity = "Moscow";
        this.myServiceModule = new WeatherService(searchCity);

        this.data = new HashMap<>();
    }

    @Override
    public void render() {
        // создать слой в окне главного приложения
        this.addToScreen("", null);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void expand() {

    }

    /**
     * add smth do data container
     * @param key
     * @param value
     */
    public void setData(String key, Object value){
        this.data.put(key, value);
    }

    /**
     * collect all needed data
     * @throws IOException
     */
    protected void prepareData() throws IOException {
        try {
            this.myServiceModule.requestWeather();
            this.setData("weatherCity", this.myServiceModule.getWeatherCity());
        } catch (IOException e) {
            // TODO оповещать пользователя, что что-то пошло не так
            // e.printStackTrace();
        }
    }

    /**
     * add new widget to main application screen
     * @param container_id
     * @param widget
     */
    protected void addToScreen(String container_id, Object widget){

    }
}
