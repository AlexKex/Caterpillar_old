package modules.desktop;

import modules.serviceModule.WeatherService;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by apryakhin on 28.10.2015.
 */
public class WeatherWidget extends Widget implements desktopModuleInterface {
    protected WeatherService myServiceModule;
    protected HashMap<String, Object> data;
    protected JComponent component;

    public WeatherWidget(){
        String searchCity = "Moscow";
        this.myServiceModule = new WeatherService(searchCity);

        this.component = new JPanel();
        this.data = new HashMap<>();
    }

    @Override
    public void render() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void expand() {

    }

    public JComponent getComponent() throws IOException {
        this.prepareData();
        this.prepareWidget();

        return this.component;
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
     * prepare widget to main application screen
     */
    protected void prepareWidget(){
        System.out.println("Preparing widget");
        this.component.add(new JLabel("Weather in " + this.myServiceModule.getWeatherCity()));
    }
}
