package in.shabhushan.tankfighter.game.listener;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.objects.Tank;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class GameKeyListener implements KeyListener {

    private Tank playerTank;

    public GameKeyListener(Tank playerTank) {
        this.playerTank = playerTank;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key Event : " + e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        GameEngine game = playerTank.getGame();


        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("Key Event DOWN");
            System.out.println("getPositionY() : " + playerTank.getPositionY() + " game height " + game.getHeight());
            playerTank.setDirection(Direction.DOWN);
            if(playerTank.getPositionY() < game.getHeight() - 33 ) {
                playerTank.setPositionY(playerTank.getPositionY() + playerTank.getSpeed());
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("Key Event UP");
            System.out.println("getPositionY() : " + playerTank.getPositionY() + " game height " + game.getHeight());
            playerTank.setDirection(Direction.UP);
            if(0 < playerTank.getPositionY()) {
                playerTank.setPositionY(playerTank.getPositionY() - playerTank.getSpeed());
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("Key Event LEFT");
            System.out.println("getPositionX() : " + playerTank.getPositionX() + " game width " + game.getWidth());
            playerTank.setDirection(Direction.LEFT);
            // if player tank's x position is zero, don't allow further left move
            if(0 < playerTank.getPositionX()) {
                playerTank.setPositionX(playerTank.getPositionX() - playerTank.getSpeed());
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("Key Event RIGHT");
            System.out.println("getPositionX() : " + playerTank.getPositionX() + " game width " + game.getWidth());
            playerTank.setDirection(Direction.RIGHT);
            if(playerTank.getPositionX() < game.getWidth() - 33 ) {
                playerTank.setPositionX(playerTank.getPositionX() + playerTank.getSpeed());
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Event : " + e.getKeyCode());
    }
}
