package in.shabhushan.tankfighter.game.model.builder;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ObjectType;
import in.shabhushan.tankfighter.game.model.GameObject;

import java.awt.*;

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

    protected GameEngine game;

    protected int objectSize;

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

    public B setGame(GameEngine game) {
        this.game = game;
        return self();
    }

    public B setObjectSize(int objectSize) {
        this.objectSize = objectSize;
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

    public GameEngine getGame() {
        return game;
    }

    public int getObjectSize() {
        return objectSize;
    }

    public abstract GameObject build();

    final B self() {
        return (B) this;
    }
}
