package engine;

import com.sun.javafx.collections.MappingChange;
import engine.userInterface.ui;
import modules.Module;
import modules.desktop.WeatherWidget;
import modules.desktop.Widget;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Caterpillar application entrance point
 * Created by apryakhin on 28.10.2015.
 */
public class Caterpillar {
    private static Map<String, Widget> modules;
    private static ui appWindow;

    public static void switchOn() throws IOException {
        try {
            Caterpillar.createAppWindow();
            Caterpillar.collectModules();
            Caterpillar.drawModules();
            Caterpillar.appWindow.render();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createAppWindow() {
        Caterpillar.appWindow = new ui("Caterpillar");
    }

    private static void collectModules() throws IOException {
        // TODO автоматизировать сбор модулей в массив
        Caterpillar.modules = new HashMap<>();
        Caterpillar.modules.put("weather_module", new WeatherWidget());
    }

    private static void drawModules() throws Exception {
        if(Caterpillar.modules.size() > 0){
            JPanel motherPanel = new JPanel();
            Caterpillar.appWindow.add(motherPanel);

            Iterator<Map.Entry<String, Widget>> iterator = Caterpillar.modules.entrySet().iterator();

            while(iterator.hasNext()){
                Map.Entry<String, Widget> pair = iterator.next();

                Caterpillar.appWindow.addWidgetToGrid(pair.getValue());
                Caterpillar.appWindow.getPanel().add(new JButton("Button 1"));
            }
        }
        else{
            throw new Exception("You have no modules!");
        }
    }

}
