package in.shabhushan.tankfighter.game.util;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;

public final class TankUtil {

    public static boolean objectWithinBoundary(int position, Direction direction, GameEngine game) {
        boolean withoutBoundary = false;

        switch (direction) {
            // for UP and LEFT, check only if position is greater than zero
            case UP:
            case LEFT:
                if(0 < position) {
                    withoutBoundary = true;
                }
                break;
            case DOWN:
                if(position < game.getHeight() - 33 ) {
                    withoutBoundary = true;
                }
                break;
            case RIGHT:
                if(position < game.getWidth() - 33 ) {
                    withoutBoundary = true;
                }
                break;
        }

        return withoutBoundary;

    }
}
