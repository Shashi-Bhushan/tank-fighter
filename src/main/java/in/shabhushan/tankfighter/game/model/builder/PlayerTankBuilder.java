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
package in.shabhushan.tankfighter.game.model.builder;

import in.shabhushan.tankfighter.game.core.GenericGameEngine;
import in.shabhushan.tankfighter.game.enumeration.ObjectType;
import in.shabhushan.tankfighter.game.model.Tank;
import in.shabhushan.tankfighter.game.model.impl.PlayerTank;

/**
 * GenericTankBuilder<PlayerTankBuilder> can be used because PlayerTankBuilder extends from GenericTankBuilder.
 * I can not inherit from GenericTankBuilder's Type Parameter B. But because PlayerTankBuilder extends from GenericTankBuilder,
 * I can use PlayerTankBuilder as a type parameter here.
 */
public class PlayerTankBuilder extends GenericTankBuilder<PlayerTankBuilder> {

    public PlayerTankBuilder(int horizontalPosition, int verticalPosition, ObjectType objectType, int objectSize, GenericGameEngine game) {
        this.horizontalPosition = horizontalPosition;
        this.verticalPosition = verticalPosition;
        this.objectType = objectType;
        this.objectSize = objectSize;
        this.game = game;
    }

    @Override
    public Tank build() {
        return new PlayerTank(this);
    }
}
