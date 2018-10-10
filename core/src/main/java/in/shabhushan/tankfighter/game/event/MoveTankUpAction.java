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
 */
package in.shabhushan.tankfighter.game.event;

import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.model.Tank;
import in.shabhushan.tankfighter.game.util.TankUtil;

public class MoveTankUpAction extends AbstractMoveTankAction {

    public MoveTankUpAction(Tank tank) {
        super(tank, Direction.UP);
    }

    @Override
    protected boolean isSpaceVacant() {
        return !TankUtil.isSpaceOccupied(tank.getHorizontalPosition(), tank.getVerticalPosition() - tank.getSpeed(), tank);
    }

    @Override
    protected void moveTank() {
        tank.setVerticalPosition(tank.getVerticalPosition() - tank.getSpeed());
    }
}
