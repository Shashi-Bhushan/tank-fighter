/*
 * Copyright 2017 the original author or authors.
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
 */
package in.shabhushan.tankfighter.game.event;

import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.model.Tank;
import in.shabhushan.tankfighter.game.util.TankUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static in.shabhushan.tankfighter.game.util.GameUtil.objectWithinBoundary;

public class MoveTankRightAction extends AbstractAction {

    private Tank tank;

    public MoveTankRightAction(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tank.setDirection(Direction.RIGHT);

        tank.vacantSpace();
        if(objectWithinBoundary(tank, tank.getGame())
                && !TankUtil.isSpaceOccupied(tank.getHorizontalPosition() + tank.getSpeed(), tank.getVerticalPosition(), tank)){
            tank.setHorizontalPosition(tank.getHorizontalPosition() + tank.getSpeed());
        }
        tank.occupySpace();
    }
}
