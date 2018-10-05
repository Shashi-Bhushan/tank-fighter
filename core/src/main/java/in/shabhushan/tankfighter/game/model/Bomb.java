package in.shabhushan.tankfighter.game.model;

import in.shabhushan.tankfighter.game.core.GenericGameEngine;
import in.shabhushan.tankfighter.game.model.impl.GenericGameObject;

import java.awt.*;

import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_TANK_BLOCK_DISTANCE;

/**
 * Bomb Class that is initialized when a {@link GameObject} is destroyed.
 * It has 3 images, which will play one by one and it shall be destroyed when all 3 images has been displayed.
 */
public class Bomb extends GenericGameObject implements Runnable {

    private static final int timeToSleep = 200;
    private int counterToDie = 2;
    private boolean isLive = true;

    private Image image;

    private static final Image[] images = {
            Toolkit.getDefaultToolkit().getImage(
                    Bomb.class.getClassLoader().getResource("/bomb_1.gif")),
            Toolkit.getDefaultToolkit().getImage(
                    Bomb.class.getResource("/bomb_2.gif")),
            Toolkit.getDefaultToolkit().getImage(
                    Bomb.class.getResource("/bomb_3.gif")),
    };

    public Bomb(int horizontalPosition, int verticalPosition, GenericGameEngine game) {
        super(horizontalPosition, verticalPosition, game);
    }

    @Override
    public void update() {}

    public void decreaseCounterToDie() {
        counterToDie--;
    }

    /**
     * Draw Method will draw an image based on how much time is left to die for this Bomb
     *
     * Create Image[], add 3 images here
     * in draw method, draw bomb according to how much life is left in Bomb
     * when reaches zero, destroy bomb
     */
    @Override
    public void draw(Graphics graphics) {
        if(0 <= counterToDie) {
            graphics.drawImage(images[counterToDie], horizontalPosition, verticalPosition,
                    DEFAULT_TANK_BLOCK_DISTANCE * 3, DEFAULT_TANK_BLOCK_DISTANCE * 3, this);
        }

    }

    @Override
    public void run() {
        while(counterToDie >= 0) {
            try {
                Thread.sleep(timeToSleep);
                decreaseCounterToDie();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        isLive = false;
    }

    public boolean isLive() {
        return isLive;
    }
}
