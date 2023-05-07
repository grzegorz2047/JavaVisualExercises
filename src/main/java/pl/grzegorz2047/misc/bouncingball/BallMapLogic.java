package pl.grzegorz2047.misc.bouncingball;


import pl.grzegorz2047.misc.bouncingball.Ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BallMapLogic extends JPanel {
    private final Random random = new Random();
    private final List<Ball> balls = new ArrayList<>();
    private static final int RECT_PADDING = 10;
    private static final int RECT_WIDTH = 10;
    private static final int RECT_HEIGHT = 20;
    private final int BALL_RADIUS = 10;

    public BallMapLogic(int ballCount, int width, int height) {
        for (int i = 0; i < ballCount; i++) {
            int x = BALL_RADIUS + random.nextInt(width - 2 * BALL_RADIUS - 20)+ 10;
            int y = BALL_RADIUS + random.nextInt(height - 2 * BALL_RADIUS - 20) + 10;
            balls.add(initBall(x,y));
        }
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    addBallAtMousePosition(e.getX(), e.getY());
                }
            }
        });
    }

    private void addBallAtMousePosition(int x, int y) {
        balls.add(initBall(x,y));
    }

    private Ball initBall(int x, int y) {
        int speedX = getRandomSpeed();
        int speedY = getRandomSpeed();
        return new Ball(x, y, speedX, speedY, BALL_RADIUS);
    }

    private int getRandomSpeed() {
        int speed;
        do {
            speed = random.nextInt(8) - 3;
        } while (speed == 0);
        return speed;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawRectangles(g);
        for (Ball ball : balls) {
            drawBall(g, ball);
        }
    }

    private void drawRectangles(Graphics g) {
        g.setColor(Color.BLACK);

        g.fillRect(RECT_PADDING, RECT_PADDING, RECT_WIDTH, RECT_HEIGHT);
        g.fillRect(RECT_PADDING, getHeight() - RECT_PADDING - RECT_HEIGHT, RECT_WIDTH, RECT_HEIGHT);
        g.fillRect(getWidth() - RECT_PADDING - RECT_WIDTH, RECT_PADDING, RECT_WIDTH, RECT_HEIGHT);
        g.fillRect(getWidth() - RECT_PADDING - RECT_WIDTH, getHeight() - RECT_PADDING - RECT_HEIGHT, RECT_WIDTH, RECT_HEIGHT);
    }

    private void drawBall(Graphics g, Ball ball) {
        g.setColor(Color.RED);
        int x = ball.x - ball.radius;
        int y = ball.y - ball.radius;
        g.fillOval(x, y, ball.radius * 2, ball.radius * 2);

        g.setColor(Color.BLACK);
        g.drawOval(x, y, ball.radius * 2, ball.radius * 2);
    }

    public void updateBallPositions() {
        for (Ball ball : balls) {
            ball.x += ball.speedX;
            ball.y += ball.speedY;

            if (ball.x - ball.radius < 0 || ball.x + ball.radius > getWidth()) {
                ball.speedX = -ball.speedX;
            }

            if (ball.y - ball.radius < 0 || ball.y + ball.radius > getHeight()) {
                ball.speedY = -ball.speedY;
            }
        }
    }
}
