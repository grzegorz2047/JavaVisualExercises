package pl.grzegorz2047.misc.text;

import javax.swing.*;
import java.awt.*;

public class TextExample {
    public void init() {
        JFrame frame = new JFrame("Bouncing Balls");

        SwingUtilities.invokeLater(() -> {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setVisible(true);
        });
        TextPanel textPanel = new TextPanel();
        frame.add(textPanel);
    }



}
