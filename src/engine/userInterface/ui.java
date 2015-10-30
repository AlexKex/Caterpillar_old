package engine.userInterface;

import modules.desktop.Widget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * Created by apryakhin on 29.10.2015.
 */
public class ui extends JFrame{
    protected JLayeredPane panel;

    public ui(String frameName){
        super(frameName);

        this.panel = new JLayeredPane();
        this.add(this.panel);
    }

    public JLayeredPane getPanel(){
        return this.panel;
    }

    public void render() {
        this.setPreferredSize(new Dimension(800, 480));
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.pack();
        this.setVisible(true);
    }

    /**
     * add component to mother container
     * @param motherContainer
     * @param widget
     */
    public void addWidgetToLayer(JComponent motherContainer, Widget widget) throws IOException {
        JComponent component = widget.getComponent();
        System.out.println("Component created");

        motherContainer.add(component);
        System.out.println("Component added");
    }
}
