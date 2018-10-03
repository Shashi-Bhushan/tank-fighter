package in.shabhushan.tankfighter.game.game;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.engine.Handler;
import in.shabhushan.tankfighter.game.enumeration.ObjectType;
import in.shabhushan.tankfighter.game.model.Bomb;
import in.shabhushan.tankfighter.game.model.Bullet;
import in.shabhushan.tankfighter.game.model.builder.BrickWallBuilder;
import in.shabhushan.tankfighter.game.model.builder.EnemyTankBuilder;
import in.shabhushan.tankfighter.game.model.builder.PlayerTankBuilder;
import in.shabhushan.tankfighter.game.model.Tank;
import in.shabhushan.tankfighter.game.model.impl.BrickWall;
import in.shabhushan.tankfighter.game.util.GameUtil;

import java.util.List;
import java.awt.*;
import java.util.ListIterator;

import static in.shabhushan.tankfighter.game.enumeration.Direction.DOWN;
import static in.shabhushan.tankfighter.game.enumeration.Direction.UP;
import static in.shabhushan.tankfighter.game.util.Defaults.*;

/**
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class TankFighterGameEngine extends GameEngine {

    private Handler<Tank> handler = new Handler<>();

    private Handler<Tank> enemyTankHandler = new Handler<>();

    private Handler<Bomb> bombsHandler = new Handler<>();

    private Handler<BrickWall> wallHandler = new Handler<>();

    public TankFighterGameEngine(Dimension resolution) {
        super(resolution);

        Tank playerTank = new PlayerTankBuilder(
                (int) resolution.getWidth() / 2,(int) resolution.getHeight() / 2,
                        ObjectType.PLAYER_TANK, DEFAULT_TANK_OBJECT_SIZE, this)
                .setSpeed(DEFAULT_PLAYER_TANK_SPEED)
                .setColor(DEFAULT_PLAYER_TANK_COLOR)
                .setDirection(UP)
                .build();

        handler.addObject(playerTank);

        for(int index = 0; index < DEFAULT_AI_TANK_NUMBER; index++) {
            Tank enemyTank = new EnemyTankBuilder(
                        100 * (index + 1), (int) resolution.getHeight() / 4,
                        ObjectType.ENEMY_TANK, DEFAULT_TANK_OBJECT_SIZE, this)
                    .setDirection(DOWN)
                    .setSpeed(DEFAULT_AI_TANK_SPEED)
                    .setColor(DEFAULT_AI_TANK_COLOR)
                    .build();

            // Add to Handler
            enemyTankHandler.addObject(enemyTank);

            // Add to Executor Thread Pool
            executorService.execute(enemyTank);
        }

        updateHeadUpDisplayHealthPoints();

        BrickWall wall = new BrickWallBuilder(100, 100, this).build();
        BrickWall secondWall = new BrickWallBuilder(130, 100, this).build();

        wallHandler.addObject(wall);
        wallHandler.addObject(secondWall);
    }

    @Override
    public void update() {
        handler.update();
        enemyTankHandler.update();
        bombsHandler.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        handler.draw(g);
        enemyTankHandler.draw(g);
        bombsHandler.draw(g);
        wallHandler.draw(g);
    }

    public Tank getPlayerTank() {
        return handler.getGameObjects().get(0);
    }

    public boolean isPlayerTankDead() {
        return handler.getGameObjects().isEmpty();
    }

    public void updateHeadUpDisplayHealthPoints() {
        getPlayerTank().getTankHealthBar().update();
    }

    public List<Tank> getEnemyTanks() {
        return enemyTankHandler.getGameObjects();
    }

    @Override
    public void checkForCollisions() {
        // Check if Player's Bullet has hit any enemy tank
        ListIterator<Bullet> playerBulletIterator = getPlayerTank().getBullets().listIterator();
        while(playerBulletIterator.hasNext()) {
            Bullet playerBullet = playerBulletIterator.next();

            ListIterator<Tank> enemyTanksIterator = enemyTankHandler.getGameObjects().listIterator();
            while(enemyTanksIterator.hasNext()) {
                Tank enemyTank = enemyTanksIterator.next();

                if(GameUtil.isTankHitByBullet(enemyTank, playerBullet)) {

                    enemyTank.reducePointsBy(playerBullet.getDamagePoints());

                    if(enemyTank.getHealthPoints() <= 0) {
                        // Create a Bomb Here
                        Bomb bomb = new Bomb(enemyTank.getHorizontalPosition(), enemyTank.getVerticalPosition(), this);
                        bombsHandler.addObject(bomb);
                        // Add to Executor Thread Pool
                        executorService.execute(bomb);

                        enemyTank.destroy();
                        enemyTanksIterator.remove();

                        // enemyTank is x_x with the bullet
                        // Bullet is already removed, tank is destroyed no need to iterate for this bullet further
                        // check for next bullet
                    }

                    // Remove Player's Bullet
                    playerBulletIterator.remove();

                    break;
                }
            }
        }

        // Check if Enemy Tank has hit player
        OUTER_LOOP:
        for(Tank enemyTank: enemyTankHandler.getGameObjects()) {
            ListIterator<Bullet> enemyBulletIterator = enemyTank.getBullets().listIterator();

            while(enemyBulletIterator.hasNext()) {
                Bullet enemyBullet = enemyBulletIterator.next();

                if(GameUtil.isTankHitByBullet(getPlayerTank(), enemyBullet)) {

                    Tank playerTank = getPlayerTank();
                    playerTank.reducePointsBy(enemyBullet.getDamagePoints());
                    updateHeadUpDisplayHealthPoints();

                    if(playerTank.getHealthPoints() <= 0) {
                        // Create a Bomb Here
                        Bomb bomb = new Bomb(playerTank.getHorizontalPosition(), playerTank.getVerticalPosition(), this);
                        bombsHandler.addObject(bomb);
                        // Add to Executor Thread Pool
                        executorService.execute(bomb);

                        playerTank.destroy();
                        // Remove Player Tank
                        handler.getGameObjects().remove(getPlayerTank());
                        // break out of all loops, Player is x_x
                    }
                    enemyBulletIterator.remove();
                    break OUTER_LOOP;
                }
            }
        }

        ListIterator<Bomb> bombsIterator = bombsHandler.getGameObjects().listIterator();
        while(bombsIterator.hasNext()) {
            Bomb bomb = bombsIterator.next();

            if(!bomb.isLive()) {
                bombsIterator.remove();
            }
        }

        if(getEnemyTanks().isEmpty() || isPlayerTankDead()) {
            gameFinished = true;
        }
    }
}
