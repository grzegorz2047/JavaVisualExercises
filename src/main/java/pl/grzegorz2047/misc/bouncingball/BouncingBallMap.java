package pl.grzegorz2047.misc.bouncingball;

import pl.grzegorz2047.misc.MapPanel;

import javax.swing.*;

public class BouncingBallMap {


    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    public void init() {
        JFrame frame = new JFrame("Bouncing Balls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);

        MapPanel ballPanel = new MapPanel(10, WIDTH, HEIGHT); // Initialize with 10 balls
        frame.add(ballPanel);
        frame.setVisible(true);

        Timer timer = new Timer(1000 / 60, e -> {
            ballPanel.updateBallPositions();
            ballPanel.repaint();
        });
        timer.start();
    }
}
