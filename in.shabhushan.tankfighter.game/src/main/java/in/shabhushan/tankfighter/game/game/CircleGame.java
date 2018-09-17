package in.shabhushan.tankfighter.game.game;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.engine.Handler;
import in.shabhushan.tankfighter.game.objects.Circle;

import java.awt.*;
import java.util.Random;

/**
 * @author Shashi Bhushan
 * @date 16/9/18
 */
public class CircleGame extends GameEngine {
    private static final int NUM_CIRCLES = 2;
    private static Random random = new Random();

    private Handler handler;

    public CircleGame() {
         handler = new Handler();

        // create some random circles
        for (int i = 0; i < NUM_CIRCLES; i++) {
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256), random.nextInt(256));

            int radius = random.nextInt(100) + 30;
            int x = random.nextInt(800 - radius);
            int y = random.nextInt(600 - radius);

            Circle cirle = new Circle(x, y, radius, color, this);
            handler.addObject(cirle);
        }
    }

    @Override
    public void update() {
        handler.update();
    }

    @Override
    public void draw() {
        super.draw();
        handler.draw(drawGraphics);
    }
}