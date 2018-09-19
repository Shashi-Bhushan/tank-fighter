package in.shabhushan.tankfighter.game.util;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.model.GameObject;

import static in.shabhushan.tankfighter.game.enumeration.Direction.*;

public final class GameUtil {

    public static boolean objectWithinBoundary(GameObject gameObject, GameEngine game) {
        boolean withoutBoundary = false;

        switch (gameObject.getDirection()) {
            // for UP and LEFT, check only if position is greater than zero
            case UP:
                if(0 < gameObject.getVerticalPosition()) {
                    withoutBoundary = true;
                }
                break;
            case DOWN:
                if(gameObject.getVerticalPosition() < game.getHeight() - 33 ) {
                    withoutBoundary = true;
                }
                break;
            case LEFT:
                if(0 < gameObject.getHorizontalPosition()) {
                    withoutBoundary = true;
                }
                break;
            case RIGHT:
                if(gameObject.getHorizontalPosition() < game.getWidth() - 33 ) {
                    withoutBoundary = true;
                }
                break;
        }

        return withoutBoundary;
    }

    public static Direction getShortestDistanceDirection(GameObject source, GameObject target) {
        Direction direction;

        // Get horizontalDistance and Vertical Distance Between both tank Objects
        int horizontalDistance = source.getHorizontalPosition() - target.getHorizontalPosition();
        int verticalDistance = source.getVerticalPosition() - target.getVerticalPosition();

        // if horizontal distance is greater
        if(Math.abs(verticalDistance) < Math.abs(horizontalDistance)) {
            // if horizontal distance is negative, point enemy tank to left
            if(0 < horizontalDistance) {
                direction = LEFT;
            } else {
                direction = RIGHT;
            }
        } else {
            if(0 < verticalDistance) {
                direction = UP;
            } else {
                direction = DOWN;
            }
        }

        return direction;
    }

    public static boolean objectInLineOfSight(GameObject enemyTank, GameObject playerTank) {
        return Math.abs(enemyTank.getHorizontalPosition() - playerTank.getHorizontalPosition()) < 10
                || Math.abs(enemyTank.getVerticalPosition() - playerTank.getVerticalPosition()) < 10;
    }
}
