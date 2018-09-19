package in.shabhushan.tankfighter.game.objects;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ID;

import java.awt.Graphics2D;
import java.awt.Color;

/**
 * This is a Game Object, which all the objects in the Game that are going to be placed, inherits from. It provides some
 * common methods across different types of GameObjects viz position, speed, direction's Getter and Setters, {@link #update()}
 * and {@link #draw(Graphics2D)}
 *
 * @author Shashi Bhushan
 * @date 16/9/18
 */
public interface GameObject {

    public void setVerticalPosition(int verticalPosition);

    public int getVerticalPosition();

    public void setHorizontalPosition(int horizontalPosition);

    public int getHorizontalPosition();

    public Direction getDirection();

    public void setDirection(Direction direction);

    public void setGame(GameEngine game);

    public GameEngine getGame();

    public void setColor(Color color);

    public Color getColor();

    public void setId(ID id);

    public ID getId();

    public void setSpeed(int speed);

    public int getSpeed();

    /**
     * Update Position, Speed, Direction etc of Game Object
     */
    public void update();

    /**
     * Draw Object based on it's position and Direction
     * @param graphics
     */
    public void draw(Graphics2D graphics);
}
