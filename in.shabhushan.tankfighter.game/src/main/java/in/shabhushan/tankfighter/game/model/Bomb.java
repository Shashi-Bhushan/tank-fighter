package in.shabhushan.tankfighter.game.model;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.model.impl.GenericGameObject;

import java.awt.*;

import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_TANK_BLOCK_DISTANCE;

/**
 * TODO: Add Bomb Object when Tank's Destroyed
 */
public class Bomb extends GenericGameObject implements Runnable {

    private static final int timeToSleep = 300;
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

    public Bomb(int horizontalPosition, int verticalPosition, GameEngine game) {
        super(horizontalPosition, verticalPosition, game);
    }

    @Override
    public void update() {}

    public void decreaseCounterToDie() {
        counterToDie--;
    }

    @Override
    public void draw(Graphics2D graphics) {
        System.out.println("Bomb's Draw Method " + counterToDie);
        if(0 <= counterToDie) {
            graphics.drawImage(images[counterToDie], horizontalPosition, verticalPosition,
                    DEFAULT_TANK_BLOCK_DISTANCE * 3, DEFAULT_TANK_BLOCK_DISTANCE * 3, this);
        }
        /*
         * Create Image[],, add 3 images here
         * in draw method, draw bomb according to how much life is left in Bomb
         * when reaches zero, destroy bomb
         */
    }

    @Override
    public void run() {
        System.out.println("Bomb Run method " + counterToDie);
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
