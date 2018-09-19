package in.shabhushan.tankfighter.game.util;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.objects.GameObject;
import in.shabhushan.tankfighter.game.objects.Tank;

import static in.shabhushan.tankfighter.game.enumeration.Direction.*;

public final class GameUtil {

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

    public static Direction getShortestDistanceDirection(Tank source, Tank target) {
        Direction direction;

        // Get x y of both
        int horizontalDistance = source.getPositionX() - target.getPositionX();
        int verticalDistance = source.getPositionY() - target.getPositionY();

        System.out.println("Source position is : " + source.getPositionX() + " Target Position is : " + target.getPositionX());
        System.out.println("Horizontal Distance is : " + horizontalDistance + " and vertical distance is : " + verticalDistance);
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
}
