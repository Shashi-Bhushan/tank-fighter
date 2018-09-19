package in.shabhushan.tankfighter.game.model.impl;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ID;
import in.shabhushan.tankfighter.game.model.Bullet;
import in.shabhushan.tankfighter.game.model.Tank;
import in.shabhushan.tankfighter.game.util.GameUtil;

import java.awt.*;
import java.util.ListIterator;

import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_PLAYER_TANK_COLOR;
import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_PLAYER_TANK_SPEED;

/**
 * This is an Implementation of {@link Tank} for Player.
 * This will have listener attached, So Player can move the tank around and Fire Bullets.
 */
public class PlayerTank extends GenericTank {

    public PlayerTank(int positionX, int positionY, ID id, GameEngine game) {
        super(positionX, positionY, id, game);

        setColor(DEFAULT_PLAYER_TANK_COLOR);
        setSpeed(DEFAULT_PLAYER_TANK_SPEED);
    }

    public PlayerTank(int positionX, int positionY, ID id, GameEngine game, int speed, Color color) {
        this(positionX, positionY, id, game);

        setColor(color);
        setSpeed(speed);
    }


    public PlayerTank(int positionX, int positionY, ID id, GameEngine game, Direction direction) {
        this(positionX, positionY, id, game);

        setDirection(direction);
    }

    @Override
    public void update() {
        // bullets.removeIf(bullet -> !GameUtil.objectWithinBoundary(bullet, game));

        ListIterator<Bullet> bulletListIterator = bullets.listIterator();
        while(bulletListIterator.hasNext()) {
            Bullet bullet = bulletListIterator.next();

            // Remove Last Bullet if it exceeds boundary
            if(!GameUtil.objectWithinBoundary(bullet, game)) {
                bulletListIterator.remove();
            }

            bullet.update();
        }
    }
}
