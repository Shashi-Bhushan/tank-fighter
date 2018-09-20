package in.shabhushan.tankfighter.game.game;

import in.shabhushan.tankfighter.game.engine.EnemyTankHandler;
import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.engine.Handler;
import in.shabhushan.tankfighter.game.enumeration.ObjectType;
import in.shabhushan.tankfighter.game.model.impl.EnemyTank;
import in.shabhushan.tankfighter.game.model.impl.PlayerTank;
import in.shabhushan.tankfighter.game.model.Tank;

import java.awt.*;

import static in.shabhushan.tankfighter.game.enumeration.Direction.DOWN;
import static in.shabhushan.tankfighter.game.util.Defaults.*;

/**
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class TankFighterGameEngine extends GameEngine {

    private Handler handler;

    private EnemyTankHandler enemyTankHandler;

    private static Tank playerTank;

    public TankFighterGameEngine(Dimension resolution) {
        super(resolution);
        handler = new Handler();
        enemyTankHandler = new EnemyTankHandler();

        playerTank = new PlayerTank((int)resolution.getWidth() / 2,(int)resolution.getHeight() / 2,
                ObjectType.PLAYER_TANK, this, DEFAULT_PLAYER_TANK_SPEED, DEFAULT_PLAYER_TANK_COLOR);

        handler.addObject(playerTank);

        for(int index = 0; index < DEFAULT_AI_TANK_NUMBER; index++) {
            Tank tank = new EnemyTank(100 * (index + 1),(int)resolution.getHeight() / 4,
                     this, DOWN, DEFAULT_AI_TANK_SPEED, DEFAULT_AI_TANK_COLOR);

            enemyTankHandler.addObject(tank);
            Thread enemyTankThread = new Thread(tank);
            enemyTankThread.start();
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
}
