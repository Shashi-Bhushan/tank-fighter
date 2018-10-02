package in.shabhushan.tankfighter.game.model.impl;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ObjectType;
import in.shabhushan.tankfighter.game.game.TankFighterGameEngine;
import in.shabhushan.tankfighter.game.model.Bullet;
import in.shabhushan.tankfighter.game.model.builder.EnemyTankBuilder;
import in.shabhushan.tankfighter.game.model.builder.TankHealthBarBuilder;
import in.shabhushan.tankfighter.game.util.GameUtil;
import in.shabhushan.tankfighter.game.util.TankUtil;

import java.awt.*;

import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_AI_BULLET_COLOR;
import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_AI_TANK_SPEED;
import static in.shabhushan.tankfighter.game.util.GameUtil.getShortestDistanceDirection;
import static in.shabhushan.tankfighter.game.util.GameUtil.objectInLineOfSight;

/**
 * This class represents Enemy Tanks which are trying to destroy Player Tanks.
 * Enemy Tank will always move in direction of Player Tank and will shoot if it's in line of sight.
 *
 * TODO: Create an AI for Enemy Tank to roam around and start following the Player tank only if it's in line of sight and within a certain proximity.
 */
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

    public EnemyTank(EnemyTankBuilder enemyTankBuilder) {
        super(enemyTankBuilder);

        tankHealthBar = new TankHealthBarBuilder(this).build();
    }

    /**
     * Update Enemy Tank's Position, Direction and speed.
     * Enemy tank has to move in direction of {@link PlayerTank}, hence before updating the position, it checks what is
     * the direction with shortest distance towards {@link PlayerTank} and updates the direction.
     * Secondly, It moves 1 unit into that direction as well.
     */
    public void updateTankPosition() {
        Direction direction = getShortestDistanceDirection(this, ((TankFighterGameEngine)game).getPlayerTank());

        this.setDirection(direction);
        this.vacantSpace();

        if(GameUtil.objectWithinBoundary(this, game)) {
            switch(direction) {
                case UP:
                    if(!TankUtil.isSpaceOccupied(horizontalPosition, verticalPosition - DEFAULT_AI_TANK_SPEED, this)) {
                        verticalPosition -= DEFAULT_AI_TANK_SPEED;
                    }
                    break;
                case DOWN:
                    if(!TankUtil.isSpaceOccupied(horizontalPosition, verticalPosition + DEFAULT_AI_TANK_SPEED, this)) {
                        verticalPosition += DEFAULT_AI_TANK_SPEED;
                    }
                    break;
                case LEFT:
                    if(!TankUtil.isSpaceOccupied(horizontalPosition - DEFAULT_AI_TANK_SPEED, verticalPosition, this)) {
                        horizontalPosition -= DEFAULT_AI_TANK_SPEED;
                    }
                    break;
                case RIGHT:
                    if(!TankUtil.isSpaceOccupied(horizontalPosition + DEFAULT_AI_TANK_SPEED, verticalPosition, this)) {
                        horizontalPosition += DEFAULT_AI_TANK_SPEED;
                    }
                    break;
            }
        }

        this.occupySpace();
    }

    public void updateHealthBarPosition() {
        this.tankHealthBar.updateHealthBarPosition();
    }

    public void fireBullet() {
        if(objectInLineOfSight(this, ((TankFighterGameEngine)game).getPlayerTank())) {
            this.addBullet(new Bullet(this, DEFAULT_AI_BULLET_COLOR, 10));
        }
    }

    /**
     * Since The tank needs to update it's position once a second, Thus update method should be called only once in a second
     * to update Enemy Tank's position and direction.
     */
    @Override
    public void run() {
        while(!interrupted & !((TankFighterGameEngine)game).isPlayerTankDead()) {
            try {
                updateTankPosition();
                updateHealthBarPosition();
                this.tankHealthBar.update();
                fireBullet();
                Thread.currentThread().sleep(timeToSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
