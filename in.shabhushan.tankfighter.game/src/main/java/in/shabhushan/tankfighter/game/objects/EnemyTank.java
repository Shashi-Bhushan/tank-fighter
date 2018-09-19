package in.shabhushan.tankfighter.game.objects;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ID;
import in.shabhushan.tankfighter.game.game.TankFighterGame;
import in.shabhushan.tankfighter.game.util.GameUtil;

import java.awt.*;

import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_AI_TANK_SPEED;

public class EnemyTank extends GenericTank {
    public EnemyTank(int positionX, int positionY, ID id, GameEngine game) {
        super(positionX, positionY, id, game);
    }

    public EnemyTank(int positionX, int positionY, ID id, GameEngine game, int speed, Color color) {
        super(positionX, positionY, id, game, speed, color);
    }

    public EnemyTank(int positionX, int positionY, GameEngine game, Direction direction, int speed, Color color) {
        super(positionX, positionY, ID.ENEMY, game, speed, color);
        setDirection(direction);
    }

    /**
     * Update Enemy Tank's Position, Direction and speed.
     * Enemy tank has to move in direction of {@link PlayerTank}, hence before updating the position, it checks what is
     * the direction with shortest distance towards {@link PlayerTank} and updates the direction.
     * Secondly, It moves 1 unit into that direction as well.
     *
     * TODO: Fire Bullet if PlayerTank is in Line of Sight
     */
    @Override
    public void update() {
        Direction direction = GameUtil.getShortestDistanceDirection(this, TankFighterGame.getPlayerTank());

        this.setDirection(direction);

        // TODO: set speed in direction of tank
        if(GameUtil.objectWithinBoundary(this, game)) {
            switch(direction) {
                case UP:
                    verticalPosition -= DEFAULT_AI_TANK_SPEED;
                    break;
                case DOWN:
                    verticalPosition += DEFAULT_AI_TANK_SPEED;
                    break;
                case LEFT:
                    horizontalPosition -= DEFAULT_AI_TANK_SPEED;
                    break;
                case RIGHT:
                    horizontalPosition += DEFAULT_AI_TANK_SPEED;
                    break;
            }
        }
    }
}
