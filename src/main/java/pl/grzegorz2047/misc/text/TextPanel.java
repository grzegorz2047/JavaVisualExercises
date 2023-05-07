package pl.grzegorz2047.misc.text;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        // Draw a pattern on the bottom half of the window
        g.setColor(Color.BLACK);
        g.drawLine(0, height / 2, width, height / 2);

        g.setColor(Color.BLUE);
        for (int x = 0; x < width; x += 5) {
            for (int y = height / 2; y < height; y += 5) {
//                g.drawLine(x, y, x + 5, y + 5);
                g.drawLine(x + 10, y, x, y + 10);
            }
        }

        // Draw text using Graphics.drawString
        g.setColor(Color.BLACK);
        g.drawString("1. I ain't got time to bleed.", 5, 20);

        // Draw text using Graphics.drawBytes (equivalent to DrawText with DT_WORDBREAK)
        String text2 = "2. You take the blue pill and the story ends. You wake in your bed and believe whatever you want to believe. You take the red pill and you stay in Wonderland and I show you how deep the rabbit-hole goes.";
        g.drawBytes(text2.getBytes(), 0, text2.length(), 100, 30);

        // Change text color to red and background color to black
        g.setColor(Color.BLACK);
        g.fillRect(5, 200, width - 200, 100);
        g.setColor(Color.RED);
        String text3 = "3. The greatest trick the devil ever pulled was convincing the world he didn't exist.";
        g.drawBytes(text3.getBytes(), 0, text3.length(), 5, 220);
        g.setColor(Color.BLACK);

        // Set background to transparent
        g.setColor(Color.RED);
        String text4 = "4. ...I'm 42 years old. In less than a year I'll be dead";
        g.drawBytes(text4.getBytes(), 0, text4.length(), width/4, height - (height/12));
    }
}
