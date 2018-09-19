package in.shabhushan.tankfighter.game.model.impl;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ObjectType;
import in.shabhushan.tankfighter.game.game.TankFighterGame;
import in.shabhushan.tankfighter.game.model.Bullet;
import in.shabhushan.tankfighter.game.util.GameUtil;

import java.awt.*;

import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_AI_TANK_SPEED;
import static in.shabhushan.tankfighter.game.util.GameUtil.objectInLineOfSight;
import static in.shabhushan.tankfighter.game.util.TankUtil.updateBulletsPosition;

public class EnemyTank extends GenericTank {

    public EnemyTank(int positionX, int positionY, ObjectType objectType, GameEngine game) {
        super(positionX, positionY, objectType, game);
    }

    public EnemyTank(int positionX, int positionY, ObjectType objectType, GameEngine game, int speed, Color color) {
        super(positionX, positionY, objectType, game, speed, color);
    }

    public EnemyTank(int positionX, int positionY, GameEngine game, Direction direction, int speed, Color color) {
        super(positionX, positionY, ObjectType.ENEMY_TANK, game, speed, color);
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

        if(objectInLineOfSight(this, TankFighterGame.getPlayerTank())) {
            this.addBullet(new Bullet(this));
        }

        updateBulletsPosition(bullets, game);
    }

    /**
     * Since The tank needs to update it's position once a second, Thus update method should be called only once in a second
     * to update Enemy Tank's position and direction.
     */
    @Override
    public void run() {
        while(!interrupted) {
            try {
                Thread.currentThread().sleep(timeToSleep);
                update();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
