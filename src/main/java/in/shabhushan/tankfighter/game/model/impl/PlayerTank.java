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
package in.shabhushan.tankfighter.game.model.impl;

import in.shabhushan.tankfighter.game.core.GenericGameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ObjectType;
import in.shabhushan.tankfighter.game.model.Tank;
import in.shabhushan.tankfighter.game.model.builder.PlayerTankBuilder;
import in.shabhushan.tankfighter.game.model.builder.TankHealthBarBuilder;

import java.awt.*;

/**
 * This is an Implementation of {@link Tank} for Player.
 * This will have listener attached, So Player can move the tank around and Fire Bullets.
 */
public class PlayerTank extends GenericTank {

    public PlayerTank(int positionX, int positionY, ObjectType objectType, GenericGameEngine game, int speed, Color color) {
        super(positionX, positionY, objectType, game);

        setColor(color);
        setSpeed(speed);
    }


    public PlayerTank(int positionX, int positionY, ObjectType objectType, GenericGameEngine game, Direction direction) {
        super(positionX, positionY, objectType, game);

        setDirection(direction);
    }

    public PlayerTank(PlayerTankBuilder playerTankBuilder) {
        super(playerTankBuilder);

        tankHealthBar = new TankHealthBarBuilder(this)
                .setHorizontalPosition(playerTankBuilder.getGame().getGameGrid().getHorizontalSize() - 120)
                .setVerticalPosition(0)
                .setWidth(120)
                .setHeight(8)
                .build();
    }
}
