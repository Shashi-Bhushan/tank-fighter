package in.shabhushan.tankfighter.game.game;

import in.shabhushan.tankfighter.game.engine.EnemyTankHandler;
import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.engine.Handler;
import in.shabhushan.tankfighter.game.enumeration.ID;
import in.shabhushan.tankfighter.game.objects.EnemyTank;
import in.shabhushan.tankfighter.game.objects.Tank;

import java.awt.*;

import static in.shabhushan.tankfighter.game.enumeration.Direction.DOWN;
import static in.shabhushan.tankfighter.game.enumeration.Direction.LEFT;
import static in.shabhushan.tankfighter.game.util.Defaults.*;

/**
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class TankFighterGame extends GameEngine {

    private Handler handler;

    private EnemyTankHandler enemyTankHandler;

    private Tank playerTank;

    public TankFighterGame(Dimension resolution) {
        super(resolution);
        handler = new Handler();
        enemyTankHandler = new EnemyTankHandler();

        playerTank = new Tank((int)resolution.getWidth() / 2,(int)resolution.getHeight() / 2,
                ID.PLAYER, this, DEFAULT_PLAYER_TANK_SPEED, DEFAULT_PLAYER_TANK_COLOR);

        handler.addObject(playerTank);

        for(int index = 0; index < DEFAULT_AI_TANK_NUMBER; index++) {
            Tank tank = new EnemyTank(100 * (index + 1),(int)resolution.getHeight() / 4,
                     this, DOWN, DEFAULT_AI_TANK_SPEED, DEFAULT_AI_TANK_COLOR);

            enemyTankHandler.addObject(tank);
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

    public Tank getPlayerTank() {
        return playerTank;
    }
}
