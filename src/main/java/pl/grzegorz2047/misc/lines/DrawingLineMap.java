package pl.grzegorz2047.misc.lines;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawingLineMap extends JPanel {

    Random rand = new Random();

    public void init() {
        JFrame frame = new JFrame("Bouncing Balls");
        SwingUtilities.invokeLater(() -> {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setVisible(true);
        });
        frame.add(this);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        int numLinesPerSide = 10;
        int height = getHeight();
        int yStep = height / numLinesPerSide;
        int width = getWidth();
        int xStep = width / numLinesPerSide;

        for (int shiftDistance = 1; shiftDistance < numLinesPerSide; shiftDistance++) {
            Color c = getRandomColor();
            graphics.setColor(c);
            int x1 = xStep * shiftDistance;
            int y2 = height - yStep * shiftDistance;
            graphics.drawLine(x1, 0, 0, y2);
            graphics.drawLine(x1, height, width, y2);
            graphics.drawLine(x1, 0, width, yStep * shiftDistance);
            graphics.drawLine(x1, height, 0, yStep * shiftDistance);
        }
    }

    private Color getRandomColor() {
        int r = rand.nextInt(255); // [0,255]
        int g = rand.nextInt(255); // [0,255]
        int b = rand.nextInt(255); // [0,255]
        return new Color(r, g, b);
    }
}
