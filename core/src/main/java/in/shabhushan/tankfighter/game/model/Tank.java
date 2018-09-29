package in.shabhushan.tankfighter.game.model;

import java.util.List;

import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_TANK_BLOCK_DISTANCE;

/**
 * This is an API for Tank, which adds additional functionality on top of Game Object to Signify how a tank should behave.
 *
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public interface Tank extends Runnable, GameObject{
    public static final int TANK_SIZE = DEFAULT_TANK_BLOCK_DISTANCE * 3;
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
     * Returns a List of all fired bullets from this tank, that are still alive
     * @return list of all alive {@link Bullet}
     */
    public List<Bullet> getBullets();

    public void setHealthPoints(int healthPoints);

    public int getHealthPoints();

    public void reducePointsBy(int healthPoints);

    public void setDead(boolean isDead);

    public void destroy();
}
