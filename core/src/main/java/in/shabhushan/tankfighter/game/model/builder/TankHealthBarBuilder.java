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

import in.shabhushan.tankfighter.game.model.Tank;
import in.shabhushan.tankfighter.game.model.impl.TankHealthBar;
import in.shabhushan.tankfighter.game.util.Defaults;

public class TankHealthBarBuilder extends GenericGameObjectBuilder<TankHealthBarBuilder> {
    private int width;
    private int height;
    private Tank tank;

    public TankHealthBarBuilder(Tank tank) {
        this.tank = tank;
        this.horizontalPosition = tank.getHorizontalPosition();
        this.verticalPosition = tank.getVerticalPosition() - 5;
        this.width = Defaults.DEFAULT_TANK_BLOCK_DISTANCE * 3;
        this.height = 3;
        this.outsideGameGrid = true;
    }

    public int getWidth() {
        return width;
    }

    public TankHealthBarBuilder setWidth(int width) {
        this.width = width;
        return self();
    }

    public int getHeight() {
        return height;
    }

    public TankHealthBarBuilder setHeight(int height) {
        this.height = height;
        return self();
    }

    public Tank getTank() {
        return tank;
    }

    public TankHealthBarBuilder setTank(Tank tank) {
        this.tank = tank;
        return self();
    }

    @Override
    public TankHealthBar build() {
        return new TankHealthBar(this);
    }
}
