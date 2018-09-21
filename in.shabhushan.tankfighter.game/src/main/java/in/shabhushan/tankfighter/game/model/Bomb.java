package in.shabhushan.tankfighter.game.model;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.model.impl.GenericGameObject;

import java.awt.*;

/**
 * TODO: Add Bomb Object when Tank's Destroyed
 */
public class Bomb extends GenericGameObject {

    public Bomb(int horizontalPosition, int verticalPosition, GameEngine game) {
        super(horizontalPosition, verticalPosition, game);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D graphics) {
        // TODO:
        /*
         * Create Image[],, add 3 images here
         * in draw method, draw bomb according to how much life is left in Bomb
         * when reaches zero, destroy bomb
         */
    }
}
