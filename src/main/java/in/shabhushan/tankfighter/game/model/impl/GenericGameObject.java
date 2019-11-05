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
import in.shabhushan.tankfighter.game.core.GameGrid;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ObjectType;
import in.shabhushan.tankfighter.game.model.GameObject;
import in.shabhushan.tankfighter.game.model.builder.GenericGameObjectBuilder;
import in.shabhushan.tankfighter.game.util.GameUtil;

import java.awt.*;
import java.math.BigInteger;
import java.util.Random;

public abstract class GenericGameObject extends Component implements GameObject {

    protected static final Random random = new Random();

    /**
     * Position attributes
     */
    protected int horizontalPosition;
    protected int verticalPosition;

    // Velocity Attribute
    protected int speed;

    // Direction Attribute
    protected Direction direction = Direction.UP;

    protected Color color;

    // Unique Identifier of Game Object
    protected ObjectType objectType;

    protected GenericGameEngine game;

    protected int objectSize;

    protected boolean outsideGameGrid;

    protected BigInteger tileID;

    public GenericGameObject(int horizontalPosition, int verticalPosition, GenericGameEngine game) {
        this(horizontalPosition, verticalPosition, null, game);
    }

    public GenericGameObject(int horizontalPosition, int verticalPosition, ObjectType objectType, GenericGameEngine game) {
        this.horizontalPosition = horizontalPosition;
        this.verticalPosition = verticalPosition;
        this.objectType = objectType;
        this.game = game;
    }

    public GenericGameObject(int horizontalPosition, int verticalPosition, ObjectType objectType, GenericGameEngine game, int objectSize) {
        this.horizontalPosition = horizontalPosition;
        this.verticalPosition = verticalPosition;
        this.objectType = objectType;
        this.game = game;
        this.objectSize = objectSize;

        if(!outsideGameGrid) {
            occupySpace();
        }
    }

    public GenericGameObject(GenericGameObjectBuilder genericGameObjectBuilder) {
        this.horizontalPosition = genericGameObjectBuilder.getHorizontalPosition();
        this.verticalPosition = genericGameObjectBuilder.getVerticalPosition();
        this.objectType = genericGameObjectBuilder.getObjectType();
        this.game = genericGameObjectBuilder.getGame();
        this.objectSize = genericGameObjectBuilder.getObjectSize();
        this.objectType = genericGameObjectBuilder.getObjectType();
        this.color = genericGameObjectBuilder.getColor();
        this.direction = genericGameObjectBuilder.getDirection();
        this.speed = genericGameObjectBuilder.getSpeed();
        this.outsideGameGrid = genericGameObjectBuilder.isOutsideGameGrid();

        // Occupy Current Position in Playing Grid
        if(!outsideGameGrid) {
            occupySpace();
        }

        tileID = GameUtil.getTileID(this.horizontalPosition, this.verticalPosition);
    }

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public void setHorizontalPosition(int horizontalPosition) {
        this.horizontalPosition = horizontalPosition;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public GenericGameEngine getGame() {
        return game;
    }

    public void setGame(GenericGameEngine game) {
        this.game = game;
    }

    public int getVerticalPosition() {
        return verticalPosition;
    }

    public void setVerticalPosition(int verticalPosition) {
        this.verticalPosition = verticalPosition;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isOutsideGameGrid() {
        return outsideGameGrid;
    }

    public void setOutsideGameGrid(boolean outsideGameGrid) {
        this.outsideGameGrid = outsideGameGrid;
    }

    @Override
    public int getObjectSize() {
        return objectSize;
    }

    @Override
    public void setObjectSize(int objectSize) {
        this.objectSize = objectSize;
    }

    @Override
    public BigInteger getTileID() {
        return tileID;
    }

    @Override
    public void setTileID(BigInteger tileID) {
        this.tileID = tileID;
    }

    @Override
    public void occupySpace() {
        final GameGrid gameGrid = game.getGameGrid();
        gameGrid.occupySpace(verticalPosition, horizontalPosition, objectSize);
    }

    @Override
    public void vacantSpace() {
        final GameGrid gameGrid = game.getGameGrid();
        gameGrid.vacantSpace(verticalPosition, horizontalPosition, objectSize);
    }
}

