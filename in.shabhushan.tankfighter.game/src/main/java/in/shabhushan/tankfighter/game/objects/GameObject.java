package in.shabhushan.tankfighter.game.objects;

import in.shabhushan.tankfighter.game.enumeration.ID;
import in.shabhushan.tankfighter.game.game.Game;

import java.awt.*;
import java.util.Random;

/**
 * @author Shashi Bhushan
 * @date 16/9/18
 */
public abstract class GameObject {

    protected static final Random random = new Random();

    // position attributes
    protected int positionX;
    protected int positionY;

    protected Color color;
    protected Game game;

    protected int velocityX;
    protected int velocityY;

    protected ID id;

    public GameObject(int positionX, int positionY, ID id, Game game) {
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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
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

    public abstract void update();

    public abstract void draw(Graphics2D graphics);
}
