package modules.desktop;

import modules.Module;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by apryakhin on 29.10.2015.
 */
public abstract class Widget extends Module implements desktopModuleInterface {
    protected Module myServiceModule;
    protected Object Data;

    @Override
    public void render() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void expand() {

    }

    public Object getData(){
        return Data;
    }

    public void setData(){

    }

    protected void prepareData() throws IOException {

    }

    public JComponent getComponent() throws IOException {
        return null;
    }
}
