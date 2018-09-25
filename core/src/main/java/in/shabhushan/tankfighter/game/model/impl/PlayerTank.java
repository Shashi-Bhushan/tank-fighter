package in.shabhushan.tankfighter.game.model.impl;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ObjectType;
import in.shabhushan.tankfighter.game.model.Tank;
import in.shabhushan.tankfighter.game.model.builder.PlayerTankBuilder;

import java.awt.*;

import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_PLAYER_TANK_COLOR;
import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_PLAYER_TANK_SPEED;

/**
 * This is an Implementation of {@link Tank} for Player.
 * This will have listener attached, So Player can move the tank around and Fire Bullets.
 */
public class PlayerTank extends GenericTank {

    public PlayerTank(int positionX, int positionY, ObjectType objectType, GameEngine game, int speed, Color color) {
        super(positionX, positionY, objectType, game);

        setColor(color);
        setSpeed(speed);
    }


    public PlayerTank(int positionX, int positionY, ObjectType objectType, GameEngine game, Direction direction) {
        super(positionX, positionY, objectType, game);

        setDirection(direction);
    }

    public PlayerTank(PlayerTankBuilder playerTankBuilder) {
        super(playerTankBuilder);
    }
}
