package in.shabhushan.tankfighter.game.game;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.engine.Handler;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ID;
import in.shabhushan.tankfighter.game.objects.Tank;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class TankFighterGame extends GameEngine {

    private Handler handler;

    private Tank playerTank;

    public TankFighterGame() {
        handler = new Handler();

        playerTank = new Tank(10,10, ID.PLAYER, this);
        playerTank.setSpeed(5);

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
