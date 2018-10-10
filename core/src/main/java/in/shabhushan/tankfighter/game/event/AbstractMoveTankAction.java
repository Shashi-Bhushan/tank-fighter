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
 *
 * AbstractMoveTankAction is meant to serve as a Abstract Super class for All {@link Tank} Movement Classes.
 *
 * AbstractMoveTankAction extends {@link AbstractAction} and defines {@link #actionPerformed(ActionEvent)} method, which
 * sets the {@link Direction} for the {@code tank} and checks whether the tank could be feasibly moved to next position.
 * Also, it makes use of two abstract methods {@link #isSpaceVacant()} and {@link #moveTank()}, which shall be defined
 * by individual MoveTankAction classes.
 *
 * @author Shashi Bhushan
 */
package in.shabhushan.tankfighter.game.event;

import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.model.Tank;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static in.shabhushan.tankfighter.game.util.GameUtil.objectWithinBoundary;

public abstract class AbstractMoveTankAction extends AbstractAction {

    protected Tank tank;
    protected Direction direction;

    public AbstractMoveTankAction(Tank tank, Direction direction) {
        this.tank = tank;
        this.direction = direction;
    }

    /**
     * Sets direction of tank, checks for if it's feasible to move the tank to next position and finally, move the tank
     * to next position if possible.
     *
     * @param e {@link ActionEvent} object associated with this Move Action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        tank.setDirection(direction);

        // Vacant Space, otherwise TankUtil.isSpaceOccupied will give true because You have occupied some part of the space you are checking for.
        tank.vacantSpace();
        if(objectWithinBoundary(tank, tank.getGame()) && isSpaceVacant()) {
            moveTank();
        }
        // occupy Space Again
        tank.occupySpace();
    }

    /**
     * Checks for if the next space where {@code tank} is moving is vacant or not.
     * This method should be overridden by MoveTankAction sub-classes to define how to check for vacancy for next position
     *
     * @return true if the next space is vacant, false otherwise
     */
    protected abstract boolean isSpaceVacant();

    /**
     * Move the {@code tank} to the new position
     * This method should be overridden by MoveTankAction sub-classes to define how to move the {@code tank} to the next position
     */
    protected abstract void moveTank();
}
