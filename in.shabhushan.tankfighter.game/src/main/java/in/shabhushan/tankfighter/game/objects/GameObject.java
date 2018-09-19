package in.shabhushan.tankfighter.game.objects;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ID;

import java.awt.Graphics2D;
import java.awt.Color;

/**
 * @author Shashi Bhushan
 * @date 16/9/18
 */
public interface GameObject {

    public int getVerticalPosition();

    public int getHorizontalPosition();

    public Color getColor();

    public GameEngine getGame();

    public ID getId();

    public int getSpeed();

    public Direction getDirection();

    public abstract void update();

    public abstract void draw(Graphics2D graphics);
}
