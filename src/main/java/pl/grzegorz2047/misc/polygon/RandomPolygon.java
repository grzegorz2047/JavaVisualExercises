package pl.grzegorz2047.misc.polygon;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RandomPolygon extends JFrame {

    private final int width = 600;
    private final int height = 400;

    public void init() {
        JFrame frame = new JFrame("Bouncing Balls");

        SwingUtilities.invokeLater(() -> {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(width, height);
            frame.setVisible(true);
        });
        PolygonPanel polygonPanel = new PolygonPanel(width, height);
        frame.add(polygonPanel);

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                polygonPanel.updatePolygon();
            }
        });

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_SPACE:
                        polygonPanel.updatePolygon();
                        break;
                    case KeyEvent.VK_ESCAPE:
                        frame.dispose();
                        break;
                }
            }
        });

        setFocusable(true);
    }


}