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
public class TankFighterGame extends GameEngine implements KeyListener {

    private Handler handler;

    private Tank tank;

    public TankFighterGame() {
        handler = new Handler();

        tank = new Tank(10,10, ID.PLAYER, this);
        tank.setSpeed(5);

        handler.addObject(tank);
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Event : " + e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            tank.setDirection(Direction.DOWN);
            tank.setPositionY(tank.getPositionY() + tank.getSpeed());
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            tank.setDirection(Direction.UP);
            tank.setPositionY(tank.getPositionY() - tank.getSpeed());
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            tank.setDirection(Direction.LEFT);
            tank.setPositionX(tank.getPositionX() - tank.getSpeed());
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            tank.setDirection(Direction.RIGHT);
            tank.setPositionX(tank.getPositionX() + tank.getSpeed());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
