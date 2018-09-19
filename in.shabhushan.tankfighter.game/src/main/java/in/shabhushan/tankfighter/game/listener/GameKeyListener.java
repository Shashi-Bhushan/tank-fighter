package in.shabhushan.tankfighter.game.listener;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.objects.Bullet;
import in.shabhushan.tankfighter.game.objects.Tank;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static in.shabhushan.tankfighter.game.enumeration.Direction.*;
import static in.shabhushan.tankfighter.game.util.GameUtil.objectWithinBoundary;

/**
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class GameKeyListener extends KeyAdapter {

    private Tank playerTank;

    public GameKeyListener(Tank playerTank) {
        this.playerTank = playerTank;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        GameEngine game = playerTank.getGame();

        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            playerTank.setDirection(DOWN);

            if(objectWithinBoundary(playerTank, game)) {
                playerTank.setVerticalPosition(playerTank.getVerticalPosition() + playerTank.getSpeed());
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            playerTank.setDirection(UP);

            if(objectWithinBoundary(playerTank, game)) {
                playerTank.setVerticalPosition(playerTank.getVerticalPosition() - playerTank.getSpeed());
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            playerTank.setDirection(Direction.LEFT);

            // if player tank's x position is zero, don't allow further left move
            if(objectWithinBoundary(playerTank, game)) {
                playerTank.setHorizontalPosition(playerTank.getHorizontalPosition() - playerTank.getSpeed());
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            playerTank.setDirection(Direction.RIGHT);

            if(objectWithinBoundary(playerTank, game)){
                playerTank.setHorizontalPosition(playerTank.getHorizontalPosition() + playerTank.getSpeed());
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE ) {
            Bullet bullet = new Bullet(playerTank);

            playerTank.addBullet(bullet);
        }
    }
}
