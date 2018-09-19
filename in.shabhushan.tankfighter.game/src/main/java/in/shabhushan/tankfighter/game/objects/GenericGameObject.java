package in.shabhushan.tankfighter.game.objects;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ID;

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
    protected ID id;

    protected GameEngine game;

    public GenericGameObject(int horizontalPosition, int verticalPosition, ID id, GameEngine game) {
        this.horizontalPosition = horizontalPosition;
        this.verticalPosition = verticalPosition;
        this.id = id;
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

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
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

