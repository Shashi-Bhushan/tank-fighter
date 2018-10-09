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
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ObjectType;
import in.shabhushan.tankfighter.game.model.GameObject;

import java.awt.*;

/**
 * Generic Game Object Builder has been implemented as a builder pattern for Creating Game Objects.
 * There are an umptienth number of parameters for Game Object, some of which are required. For eg verticalPosition and horizontalPosition.
 * These would have required a lot of constructors and in some constructors, i would need to call another constructor using this() with some values as null.
 *
 * Thus a need to implement Builder Pattern arises here.
 * But, Builder for GenericGameObject should work for Builder of say GenericTank as well.
 * Hence, each setter will return the parameterized type B instead of GenericGameObjectBuilder, enabling sub classes to use this Setter
 * with chaining. Without returning the parameterized type B, setters say #setHorizontalPosition() will return GenericGameObjectBuilder and hence a #build()
 * on this will return GenericGameObject and not the actual intended class object.
 *
 * @see https://stackoverflow.com/questions/21086417/builder-pattern-and-inheritance
 *
 * @param <B> The Actual implementation class for Builder
 */
public abstract class GenericGameObjectBuilder<B extends GenericGameObjectBuilder> {
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

    public B setHorizontalPosition(int horizontalPosition) {
        this.horizontalPosition = horizontalPosition;
        return self();
    }

    public B setVerticalPosition(int verticalPosition) {
        this.verticalPosition = verticalPosition;
        return self();
    }

    public B setSpeed(int speed) {
        this.speed = speed;
        return self();
    }

    public B setDirection(Direction direction) {
        this.direction = direction;
        return self();
    }

    public B setColor(Color color) {
        this.color = color;
        return self();
    }

    public B setObjectType(ObjectType objectType) {
        this.objectType = objectType;
        return self();
    }

    public B setGame(GenericGameEngine game) {
        this.game = game;
        return self();
    }

    public B setObjectSize(int objectSize) {
        this.objectSize = objectSize;
        return self();
    }

    public boolean isOutsideGameGrid() {
        return outsideGameGrid;
    }

    public B setOutsideGameGrid(boolean outsideGameGrid) {
        this.outsideGameGrid = outsideGameGrid;
        return self();
    }

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public int getVerticalPosition() {
        return verticalPosition;
    }

    public int getSpeed() {
        return speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public Color getColor() {
        return color;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public GenericGameEngine getGame() {
        return game;
    }

    public int getObjectSize() {
        return objectSize;
    }

    public abstract GameObject build();

    /**
     * Self returns this builder object casted to the parameterized type B.
     * intended to be called by all setters while enabling method chaining functionality
     *
     * @return builder object casted to the parameterized type B
     */
    final public B self() {
        return (B) this;
    }
}
