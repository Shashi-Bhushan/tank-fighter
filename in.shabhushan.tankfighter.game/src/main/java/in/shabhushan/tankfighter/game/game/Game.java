package in.shabhushan.tankfighter.game.game;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.ID;
import in.shabhushan.tankfighter.game.objects.Circle;
import in.shabhushan.tankfighter.game.objects.GameObject;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * @author Shashi Bhushan
 * @date 16/9/18
 */
public class Game extends GameEngine {
    private static final int NUM_CIRCLES = 2;
    private static final Circle[] circles = new Circle[NUM_CIRCLES];

    private static Random random = new Random();

    public Game() {
        // create some random circles
        for (int i = 0; i < circles.length; i++) {
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256), random.nextInt(256));

            int radius = random.nextInt(100) + 30;
            int x = random.nextInt(800 - radius);
            int y = random.nextInt(600 - radius);

            circles[i] = new Circle(x, y, radius, color, this);
        }
    }

    @Override
    public void update() {
        for (Circle circle : circles)
            circle.update();
    }

    @Override
    public void draw() {
        super.draw();

        for (Circle circle : circles)
            circle.draw(drawGraphics);
    }
}