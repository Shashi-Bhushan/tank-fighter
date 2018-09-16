package in.shabhushan.tankfighter.game.game;

import in.shabhushan.tankfighter.game.engine.GameEngine;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * @author Shashi Bhushan
 * @date 16/9/18
 */
public class Game extends GameEngine {
    private static final int NUM_CIRCLES = 5;
    private static final Circle[] circles = new Circle[NUM_CIRCLES];

    private static Random random = new Random();

    public static void main(String[] args) {

    }

    public Game() {
        // create some random circles
        for (int i = 0; i < circles.length; i++) {
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256), random.nextInt(256));
            int radius = random.nextInt(100) + 30;
            int x = random.nextInt(800 - radius);
            int y = random.nextInt(600 - radius);
            circles[i] = new Circle(x, y, radius, color);
        }
    }

    @Override
    public void update() {
        super.update();

        for (Circle circle : circles)
            circle.update();
    }

    @Override
    public void draw() {
        super.draw();

        for (Circle circle : circles)
            circle.draw();
    }

    class Circle {
        private int x, y, width, height, xVelocity, yVelocity;
        private Color color;

        public Circle(int x, int y, int radius, Color color) {
            this.x = x;
            this.y = y;
            width = height = radius;
            this.color = color;
            xVelocity = random.nextInt(6) + 64;
            //yVelocity = random.nextInt(6) + 4;
        }

        public void update() {
            if (x < 0 || x > getWidth() - width) // check left/right bounds
                xVelocity *= -1; // reverse horizontal velocity
            if (y < 0 || y > getHeight() - height) // check top/bottom bounds
                yVelocity *= -1; // reverse vertical velocity

            x += xVelocity;
            y += yVelocity;
        }

        public void draw() {
            drawGraphics.setColor(color);
            Shape circle = new Ellipse2D.Float(x, y, width, height);
            drawGraphics.fill(circle);
        }
    }
}