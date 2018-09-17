package in.shabhushan.tankfighter.game.listener;

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
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("Key Event DOWN");
            playerTank.setDirection(Direction.DOWN);
            playerTank.setPositionY(playerTank.getPositionY() + playerTank.getSpeed());
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("Key Event UP");
            playerTank.setDirection(Direction.UP);
            playerTank.setPositionY(playerTank.getPositionY() - playerTank.getSpeed());
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("Key Event LEFT");
            playerTank.setDirection(Direction.LEFT);
            playerTank.setPositionX(playerTank.getPositionX() - playerTank.getSpeed());
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("Key Event RIGHT");
            playerTank.setDirection(Direction.RIGHT);
            playerTank.setPositionX(playerTank.getPositionX() + playerTank.getSpeed());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Event : " + e.getKeyCode());
    }
}
