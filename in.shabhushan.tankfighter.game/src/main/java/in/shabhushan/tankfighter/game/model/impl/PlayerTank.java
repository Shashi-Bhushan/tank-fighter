package in.shabhushan.tankfighter.game.model.impl;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ObjectType;
import in.shabhushan.tankfighter.game.model.Tank;

import java.awt.*;

import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_PLAYER_TANK_COLOR;
import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_PLAYER_TANK_SPEED;
import static in.shabhushan.tankfighter.game.util.TankUtil.updateBulletsPosition;

/**
 * This is an Implementation of {@link Tank} for Player.
 * This will have listener attached, So Player can move the tank around and Fire Bullets.
 */
public class PlayerTank extends GenericTank {

    public PlayerTank(int positionX, int positionY, ObjectType objectType, GameEngine game) {
        super(positionX, positionY, objectType, game);

        setColor(DEFAULT_PLAYER_TANK_COLOR);
        setSpeed(DEFAULT_PLAYER_TANK_SPEED);
    }

    public PlayerTank(int positionX, int positionY, ObjectType objectType, GameEngine game, int speed, Color color) {
        this(positionX, positionY, objectType, game);

        setColor(color);
        setSpeed(speed);
    }


    public PlayerTank(int positionX, int positionY, ObjectType objectType, GameEngine game, Direction direction) {
        this(positionX, positionY, objectType, game);

        setDirection(direction);
    }
}
