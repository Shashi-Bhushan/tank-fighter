package in.shabhushan.tankfighter.game.util;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.objects.GameObject;

public final class TankUtil {

    public static boolean objectWithinBoundary(GameObject gameObject, GameEngine game) {
        boolean withoutBoundary = false;

        switch (gameObject.getDirection()) {
            // for UP and LEFT, check only if position is greater than zero
            case UP:
                if(0 < gameObject.getPositionY()) {
                    withoutBoundary = true;
                }
                break;
            case DOWN:
                if(gameObject.getPositionY() < game.getHeight() - 33 ) {
                    withoutBoundary = true;
                }
                break;
            case LEFT:
                if(0 < gameObject.getPositionX()) {
                    withoutBoundary = true;
                }
                break;
            case RIGHT:
                if(gameObject.getPositionX() < game.getWidth() - 33 ) {
                    withoutBoundary = true;
                }
                break;
        }

        return withoutBoundary;

    }
}
