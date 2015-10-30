package engine.userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by apryakhin on 29.10.2015.
 */
public class ui extends JFrame{
    protected JLayeredPane panel;

    public ui(String frameName){
        super(frameName);
    }

    public void render() {
        this.setPreferredSize(new Dimension(800, 480));
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.panel = getLayeredPane();
        this.panel.setPreferredSize(new Dimension(240, 240));
        this.panel.add(new JButton("Добавить"));

        this.pack();
        this.setVisible(true);
    }

    public void addPaletteToLayer(){

    }
}
