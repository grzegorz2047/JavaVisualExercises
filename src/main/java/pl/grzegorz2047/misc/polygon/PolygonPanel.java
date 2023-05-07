package pl.grzegorz2047.misc.polygon;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PolygonPanel extends JPanel {
    private static final int NUM_VERTS = 5;
    private final int width;
    private final int height;
    private Polygon polygon;

    public PolygonPanel(int width, int height) {
        this.width = width;
        this.height = height;
        updatePolygon();
    }

    public void updatePolygon() {
        Random random = new Random();
        int[] xPoints = new int[NUM_VERTS];
        int[] yPoints = new int[NUM_VERTS];

        for (int i = 0; i < NUM_VERTS; i++) {
            xPoints[i] = random.nextInt(width);
            yPoints[i] = random.nextInt(height);
        }

        polygon = new Polygon(xPoints, yPoints, NUM_VERTS);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.drawPolygon(polygon);

        g.setColor(Color.RED);
        g.fillPolygon(polygon);
    }
}
