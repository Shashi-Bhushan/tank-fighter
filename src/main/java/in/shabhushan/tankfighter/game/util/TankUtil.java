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
import in.shabhushan.tankfighter.game.core.GameGrid;
import in.shabhushan.tankfighter.game.model.Bullet;
import in.shabhushan.tankfighter.game.model.Tank;

import java.util.List;
import java.util.ListIterator;

public class TankUtil {
    public static void updateBulletsPosition(List<Bullet> bullets, GenericGameEngine game) {
        ListIterator<Bullet> bulletListIterator = bullets.listIterator();
        while(bulletListIterator.hasNext()) {
            Bullet bullet = bulletListIterator.next();

            // Remove Last Bullet if it exceeds boundary
            if(!GameUtil.objectWithinGameBoundary(bullet)) {
                bulletListIterator.remove();
            }

            bullet.update();
        }
    }

    public static boolean isSpaceOccupied(int newHorizontalPosition, int newVerticalPosition, Tank self) {
        GameGrid gameGrid = self.getGame().getGameGrid();

        return gameGrid.isSpaceOccupied(newVerticalPosition, newHorizontalPosition, self.getObjectSize());
    }
}
