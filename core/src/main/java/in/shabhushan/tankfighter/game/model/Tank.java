package in.shabhushan.tankfighter.game.model;

import java.util.List;

/**
 * This is an API for Tank, which adds additional functionality on top of Game Object to Signify how a tank should behave.
 *
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public interface Tank extends Runnable, GameObject{
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

    public void setDead(boolean isDead);
}
