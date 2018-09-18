package in.shabhushan.tankfighter.game.objects;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ID;

import java.awt.*;
import java.util.Random;

/**
 * @author Shashi Bhushan
 * @date 16/9/18
 */
public abstract class GameObject {

    protected static final Random random = new Random();

    /**
     * Position attributes
     */
    protected int positionX;
    protected int positionY;

    // TODO: Remove VelocityX and velocityY, use speed instead
    /**
     * Velocity Attributed
     * @Deprecated
     */
    protected int velocityX;
    protected int velocityY;

    // Velocity Attribute
    protected int speed;

    // Direction Attribute
    protected Direction direction = Direction.UP;

    protected Color color;

    // Unique Identifier of Game Object
    protected ID id;

    protected GameEngine game;

    public GameObject(int positionX, int positionY, ID id, GameEngine game) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.id = id;
        this.game = game;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
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

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
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

    public abstract void update();

    public abstract void draw(Graphics2D graphics);
}
