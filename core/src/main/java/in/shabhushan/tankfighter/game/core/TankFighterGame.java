/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Shashi Bhushan
 * @date Oct 11, 2018
 */
package in.shabhushan.tankfighter.game.core;

import in.shabhushan.tankfighter.game.enumeration.ObjectType;
import in.shabhushan.tankfighter.game.model.Bomb;
import in.shabhushan.tankfighter.game.model.Bullet;
import in.shabhushan.tankfighter.game.model.Tank;
import in.shabhushan.tankfighter.game.model.builder.BrickWallBuilder;
import in.shabhushan.tankfighter.game.model.builder.EnemyTankBuilder;
import in.shabhushan.tankfighter.game.model.builder.PlayerTankBuilder;
import in.shabhushan.tankfighter.game.model.impl.BrickWall;
import in.shabhushan.tankfighter.game.util.GameUtil;
import in.shabhushan.tankfighter.game.model.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;

import static in.shabhushan.tankfighter.game.enumeration.Direction.DOWN;
import static in.shabhushan.tankfighter.game.enumeration.Direction.UP;
import static in.shabhushan.tankfighter.game.util.Defaults.*;

/**
 * Game is responsible for updating and rendeting all {@link GameObject} classes
 */
public class TankFighterGame {

    private final Handler<Tank> handler = new Handler<>();

    private final Handler<Tank> enemyTankHandler = new Handler<>();

    private final Handler<Bomb> bombsHandler = new Handler<>();

    private final Handler<BrickWall> wallHandler = new Handler<>();

    private boolean gameFinished;

    protected final GameGrid gameGrid;

    // TODO: use for polling Bomb objects
    private List<GameObject> pollingQueue = new ArrayList<>();

    public TankFighterGame(Dimension resolution) {
        gameGrid = new GameGrid(resolution);

        Tank playerTank = new PlayerTankBuilder(
                (int) resolution.getWidth() / 2,(int) resolution.getHeight() / 2,
                ObjectType.PLAYER_TANK, DEFAULT_TANK_OBJECT_SIZE, this)
                .setSpeed(DEFAULT_PLAYER_TANK_SPEED)
                .setColor(DEFAULT_PLAYER_TANK_COLOR)
                .setDirection(UP)
                .build();

        handler.addObject(playerTank);

        //tileManager.addGameObject(playerTank);

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
            //tileManager.addGameObject(enemyTank);
        }

        updateHeadUpDisplayHealthPoints();

        BrickWall wall = new BrickWallBuilder(100, 100, this).build();
        BrickWall secondWall = new BrickWallBuilder(130, 100, this).build();
        wall.occupySpace();
        secondWall.occupySpace();

        wallHandler.addObject(wall);
        wallHandler.addObject(secondWall);

        //tileManager.addGameObject(wall);
        //tileManager.addGameObject(secondWall);
    }

    public GameGrid getGameGrid() {
        return gameGrid;
    }

    public void update() {
        checkForCollisions();

        handler.update();
        enemyTankHandler.update();
        bombsHandler.update();
    }

    public void draw(Graphics g) {
        handler.draw(g);
        enemyTankHandler.draw(g);
        bombsHandler.draw(g);
        wallHandler.draw(g);
    }

    public void start(ExecutorService gameEngineExecutorService) {
        // Start Thread for Each Enemy Tank
        for(Tank enemyTank: getEnemyTanks()) {
            gameEngineExecutorService.execute(enemyTank);
        }
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

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void checkForCollisions() {
        isEnemyTankHit();
        isPlayerTankHit();

        updateBombs();

        if(getEnemyTanks().isEmpty() || isPlayerTankDead()) {
            gameFinished = true;
        }
    }

    private void updateBombs() {
        ListIterator<Bomb> bombsIterator = bombsHandler.getGameObjects().listIterator();
        while(bombsIterator.hasNext()) {
            Bomb bomb = bombsIterator.next();

            if(!bomb.isLive()) {
                bombsIterator.remove();
            }
        }
    }

    private void isPlayerTankHit() {
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

                        //tileManager.removeGameObject(getPlayerTank());
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
    }

    private void isEnemyTankHit() {
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

                        // TODO: Enable TileManager
                        //tileManager.removeGameObject(enemyTank);
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
    }
}
