package modules.desktop;

import java.awt.*;
import java.io.IOException;

/**
 * Created by apryakhin on 28.10.2015.
 */
public interface desktopModuleInterface {
    void render();
    void destroy();
    void expand();
    void setData();
    Component getComponent() throws IOException;
}
