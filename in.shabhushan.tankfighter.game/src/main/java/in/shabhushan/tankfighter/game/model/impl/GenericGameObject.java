package in.shabhushan.tankfighter.game.model.impl;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ObjectType;
import in.shabhushan.tankfighter.game.model.GameObject;

import java.awt.*;
import java.util.Random;

public abstract class GenericGameObject implements GameObject {

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

    protected GameEngine game;

    public GenericGameObject(int horizontalPosition, int verticalPosition, GameEngine game) {
        this(horizontalPosition, verticalPosition, null, game);
    }

    public GenericGameObject(int horizontalPosition, int verticalPosition, ObjectType objectType, GameEngine game) {
        this.horizontalPosition = horizontalPosition;
        this.verticalPosition = verticalPosition;
        this.objectType = objectType;
        this.game = game;
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

    public GameEngine getGame() {
        return game;
    }

    public void setGame(GameEngine game) {
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
}

