/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Shashi Bhushan
 * @date 17/9/18
 */
package in.shabhushan.tankfighter.game.util;

import in.shabhushan.tankfighter.game.core.GenericGameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.model.Bullet;
import in.shabhushan.tankfighter.game.model.GameObject;
import in.shabhushan.tankfighter.game.model.Tank;

import static in.shabhushan.tankfighter.game.enumeration.Direction.*;

public final class GameUtil {

    public static final boolean objectWithinBoundary(GameObject gameObject, GenericGameEngine game) {
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

    public static final Direction getShortestDistanceDirection(GameObject source, GameObject target) {
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

    public static final boolean objectInLineOfSight(GameObject enemyTank, GameObject playerTank) {
        return Math.abs(enemyTank.getHorizontalPosition() - playerTank.getHorizontalPosition()) < 20
                || Math.abs(enemyTank.getVerticalPosition() - playerTank.getVerticalPosition()) < 20;
    }

    public static final boolean isTankHitByBullet(Tank tank, Bullet bullet) {
        int tankHorizontalPosition = tank.getHorizontalPosition();
        int tankVerticalPosition = tank.getVerticalPosition();

        int bulletHorizontalPosition = bullet.getHorizontalPosition();
        int bulletVerticalPosition = bullet.getVerticalPosition();

        // if bullet is within tank's horizontal or vertical position
        return objectWithinTankBoundary(tankHorizontalPosition, bulletHorizontalPosition) && objectWithinTankBoundary(tankVerticalPosition, bulletVerticalPosition);
    }

    public static boolean objectWithinTankBoundary(int tankPositionCoordinate, int bulletPositionCoordinate) {
        return tankPositionCoordinate <= bulletPositionCoordinate && bulletPositionCoordinate <= tankPositionCoordinate + 30;
    }
}
