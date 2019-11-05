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
package in.shabhushan.tankfighter.game.model;

import in.shabhushan.tankfighter.game.model.impl.GenericGameObject;

import java.awt.*;

import static in.shabhushan.tankfighter.game.util.Defaults.*;

public class Bullet extends GenericGameObject {

    private int damagePoints;

    public Bullet(Tank tank, Color bulletColor, int damagePoints) {
        super(tank.getHorizontalPosition(), tank.getVerticalPosition(), tank.getObjectType(), tank.getGame());
        setDirection(tank.getDirection());
        setSpeed(DEFAULT_BULLET_SPEED);
        setColor(bulletColor);
        this.damagePoints = damagePoints;
    }

    @Override
    public void update() {
        switch (direction) {
            case UP:
                verticalPosition -= speed;
                break;
            case DOWN:
                verticalPosition += speed;
                break;
            case LEFT:
                horizontalPosition -= speed;
                break;
            case RIGHT:
                horizontalPosition += speed;
                break;
        }
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        switch(direction) {
            case UP:
                graphics.fill3DRect(horizontalPosition + DEFAULT_BULLET_BLOCK_DISTANCE, verticalPosition, DEFAULT_BULLET_BLOCK_WIDTH, DEFAULT_BULLET_BLOCK_WIDTH, false);
                break;
            case DOWN:
                graphics.fill3DRect(horizontalPosition + DEFAULT_BULLET_BLOCK_DISTANCE, verticalPosition + 2 * DEFAULT_TANK_BLOCK_DISTANCE, DEFAULT_BULLET_BLOCK_WIDTH, DEFAULT_BULLET_BLOCK_WIDTH, false);
                break;
            case RIGHT:
                graphics.fill3DRect(horizontalPosition + 2 * DEFAULT_TANK_BLOCK_DISTANCE, verticalPosition + DEFAULT_BULLET_BLOCK_DISTANCE, DEFAULT_BULLET_BLOCK_WIDTH, DEFAULT_BULLET_BLOCK_WIDTH, false);
                break;
            case LEFT:
                graphics.fill3DRect(horizontalPosition, verticalPosition + DEFAULT_BULLET_BLOCK_DISTANCE, DEFAULT_BULLET_BLOCK_WIDTH, DEFAULT_BULLET_BLOCK_WIDTH, false);
                break;
        }
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }
}
