package in.shabhushan.tankfighter.game.game;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.engine.Handler;
import in.shabhushan.tankfighter.game.enumeration.ID;
import in.shabhushan.tankfighter.game.objects.Tank;
import in.shabhushan.tankfighter.game.util.Defaults;

import java.awt.*;

/**
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class TankFighterGame extends GameEngine {

    private Handler handler;

    private Tank playerTank;

    public TankFighterGame(Dimension resolution) {
        super(resolution);
        handler = new Handler();

        playerTank = new Tank((int)resolution.getWidth() / 2,(int)resolution.getHeight() / 2,
                ID.PLAYER, this);
        playerTank.setSpeed(Defaults.DEFAULT_TANK_SPEED);

        handler.addObject(playerTank);
    }

    @Override
    public void update() {
        handler.update();
    }

    @Override
    public void draw() {
        super.draw();
        handler.draw(drawGraphics);
    }

    public Tank getPlayerTank() {
        return playerTank;
    }
}
