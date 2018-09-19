package in.shabhushan.tankfighter.game.objects;

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
}
