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

import in.shabhushan.tankfighter.game.model.GameObject;
import in.shabhushan.tankfighter.game.model.Tank;
import in.shabhushan.tankfighter.game.model.builder.TankHealthBarBuilder;

import java.awt.*;

import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_AI_TANK_MAX_HEALTH_POINTS;

public class TankHealthBar extends GenericGameObject implements GameObject {

    private int width;
    private int height;
    private Tank tank;
    private int health;

    public TankHealthBar(TankHealthBarBuilder tankHealthBarBuilder) {
        super(tankHealthBarBuilder);

        this.width = tankHealthBarBuilder.getWidth();
        this.height = tankHealthBarBuilder.getHeight();
        this.tank = tankHealthBarBuilder.getTank();
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    /**
     * Get Health Points as percentage of width and assign to value
     */
    public void updateHealthBarPosition() {
        this.horizontalPosition = tank.getHorizontalPosition();
        this.verticalPosition = tank.getVerticalPosition();
    }

    @Override
    public void update() {
        this.health = (int)(width * (float)tank.getHealthPoints() / DEFAULT_AI_TANK_MAX_HEALTH_POINTS);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fill3DRect(horizontalPosition, verticalPosition, width, height, false);
        graphics.setColor(getColor(tank.getHealthPoints()));
        graphics.fill3DRect(horizontalPosition, verticalPosition, health, height, false);
    }

    private static Color getColor(int healthPoints) {
        return healthPoints <= 30 ? Color.RED : (healthPoints <= 60 ? Color.ORANGE : Color.GREEN);
    }
}
