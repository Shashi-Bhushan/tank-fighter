package in.shabhushan.tankfighter.game.objects;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;

import java.awt.Graphics2D;

/**
 * This is an API for Tank, which implies how a tank should behave.
 *
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public interface Tank extends Runnable, GameObject{

    public void setVerticalPosition(int verticalPosition);

    public int getVerticalPosition();

    public void setHorizontalPosition(int horizontalPosition);

    public int getHorizontalPosition();

    public Direction getDirection();

    public void setDirection(Direction direction);

    public GameEngine getGame();

    /**
     * Updates the Tank Position, Speed, Direction etc.
     */
    public void update();

    /**
     * Add a new {@link Bullet} associated with Tank
     * @param bullet
     */
    public void addBullet(Bullet bullet);

    /**
     * Removes an existing {@link Bullet} from Tank
     * @param bullet
     */
    public void removeBullet(Bullet bullet);

    /**
     * Draw Tank based on it's position and Direction
     * @param graphics
     */
    public void draw(Graphics2D graphics);
}
