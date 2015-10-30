package engine;

import engine.userInterface.ui;
import modules.Module;

import java.util.HashMap;

/**
 * Caterpillar application entrance point
 * Created by apryakhin on 28.10.2015.
 */
public class Caterpillar {
    private HashMap<String, Module> modules;
    private static ui appWindow;

    public static void switchOn() {
        Caterpillar.createAppWindow();
        Caterpillar.collectModules();
        Caterpillar.drawModules();
    }

    private static void createAppWindow() {
        Caterpillar.appWindow = new ui("Caterpillar");
        Caterpillar.appWindow.render();
    }

    private static void collectModules() {

    }

    private static void drawModules() {

    }

}
