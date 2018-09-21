package in.shabhushan.tankfighter.game.game;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.engine.Handler;
import in.shabhushan.tankfighter.game.enumeration.ObjectType;
import in.shabhushan.tankfighter.game.model.Bullet;
import in.shabhushan.tankfighter.game.model.impl.EnemyTank;
import in.shabhushan.tankfighter.game.model.impl.PlayerTank;
import in.shabhushan.tankfighter.game.model.Tank;
import in.shabhushan.tankfighter.game.util.GameUtil;

import java.awt.*;
import java.util.ListIterator;

import static in.shabhushan.tankfighter.game.enumeration.Direction.DOWN;
import static in.shabhushan.tankfighter.game.util.Defaults.*;

/**
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class TankFighterGameEngine extends GameEngine {

    private Handler<Tank> handler;

    private Handler<Tank> enemyTankHandler;

    private static Tank playerTank;

    public TankFighterGameEngine(Dimension resolution) {
        super(resolution);
        handler = new Handler<>();
        enemyTankHandler = new Handler<>();

        playerTank = new PlayerTank((int)resolution.getWidth() / 2,(int)resolution.getHeight() / 2,
                ObjectType.PLAYER_TANK, this, DEFAULT_PLAYER_TANK_SPEED, DEFAULT_PLAYER_TANK_COLOR);

        handler.addObject(playerTank);

        for(int index = 0; index < DEFAULT_AI_TANK_NUMBER; index++) {
            Tank tank = new EnemyTank(100 * (index + 1),(int)resolution.getHeight() / 4,
                     this, DOWN, DEFAULT_AI_TANK_SPEED, DEFAULT_AI_TANK_COLOR);
            // Add to Handler
            enemyTankHandler.addObject(tank);

            // Add to Executor Thread Pool
            executorService.execute(tank);
        }
    }

    @Override
    public void update() {
        handler.update();
        enemyTankHandler.update();
    }

    @Override
    public void draw() {
        super.draw();

        handler.draw(drawGraphics);

        enemyTankHandler.draw(drawGraphics);
    }

    public static Tank getPlayerTank() {
        return playerTank;
    }

    @Override
    public void checkForCollisions() {
        // Get Player Tank's Bullets
        // check against position

        // Check if Player's Bullet has hit any enemy tank
        ListIterator<Bullet> playerBulletIterator = playerTank.getBullets().listIterator();
        while(playerBulletIterator.hasNext()) {
            Bullet playerBullet = playerBulletIterator.next();

            ListIterator<Tank> enemyTanksIterator = enemyTankHandler.getGameObjects().listIterator();
            while(enemyTanksIterator.hasNext()) {
                Tank enemyTank = enemyTanksIterator.next();

                if(GameUtil.isTankHitByBullet(enemyTank, playerBullet)) {
                    // Remove Player's Bullet
                    playerBulletIterator.remove();
                    enemyTanksIterator.remove();
                    // enemyTank is x_x with the bullet
                    // Bullet is already removed, tank is destroyed no need to iterate for this bullet further
                    // check for next bullet
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

                if(GameUtil.isTankHitByBullet(playerTank, enemyBullet)) {
                    //System.out.println("Remove Enemy Bullet as Player is Dead.");
                    enemyBulletIterator.remove();
                    playerTank.setDead(true);


                    //System.out.println(">>>>>>>>>>> PLAYER TANK is DEAD");
                    // break out of all loops, Player is x_x
                    break OUTER_LOOP;
                }
            }
        }
    }
}
