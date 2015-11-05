package engine.userInterface;

import modules.desktop.Widget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by apryakhin on 29.10.2015.
 */
public class ui extends JFrame{
    protected JPanel panel; // container panel
    protected LayoutManager layout;

    public ui(String frameName){
        super(frameName);

        this.prepareMainPanel();
    }

    public JPanel getPanel(){
        return this.panel;
    }

    public void render() {
        this.add(this.panel);

        // set up listeners
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

    public void addWidgetToGrid(Widget widget) throws IOException {
        JComponent component = widget.getComponent();
        System.out.println("Component created");

        this.panel.add(component);
        System.out.println("Component added");
    }

    protected void prepareMainPanel(){
        this.panel = new JPanel();
        this.layout = new GridLayout(0, 3);

        this.panel.setPreferredSize(new Dimension(800, 480));
        this.panel.setSize(800, 480);
        this.panel.setLayout(this.layout);
    }
}
