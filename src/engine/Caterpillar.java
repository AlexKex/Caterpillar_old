package engine;

import engine.userInterface.ui;
import modules.Module;
import modules.desktop.WeatherWidget;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

/**
 * Caterpillar application entrance point
 * Created by apryakhin on 28.10.2015.
 */
public class Caterpillar {
    private static HashMap<String, Module> modules;
    private static ui appWindow;

    public static void switchOn() throws IOException {
        try {
            Caterpillar.createAppWindow();
            Caterpillar.collectModules();
            Caterpillar.drawModules();
            Caterpillar.appWindow.render();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createAppWindow() {
        Caterpillar.appWindow = new ui("Caterpillar");
    }

    private static void collectModules() throws IOException {
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(240, 240));
        panel1.setBackground(new Color(156));

        Caterpillar.appWindow.add(panel1);

        WeatherWidget ww = new WeatherWidget();
        Caterpillar.appWindow.addWidgetToLayer(panel1, ww);
    }

    private static void drawModules() {

    }

}
