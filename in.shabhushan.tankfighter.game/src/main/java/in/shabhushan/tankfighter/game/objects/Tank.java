package in.shabhushan.tankfighter.game.objects;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ID;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class Tank extends GameObject implements KeyListener {
    // Default Direction
    private Direction direction = Direction.UP;
    private int speed;

    public Tank(int positionX, int positionY, ID id, GameEngine game) {
        super(positionX, positionY, id, game);

        setColor(Color.BLACK);
    }

    public Tank(int positionX, int positionY, ID id, GameEngine game, Direction direction) {
        super(positionX, positionY, id, game);

        setColor(Color.BLACK);
        setDirection(direction);
    }

    public Direction getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void update() {

    }

    /**
     * Draw Tank based on Direction
     * @param graphics
     */
    @Override
    public void draw(Graphics2D graphics) {
        switch (direction) {
            case UP:
                graphics.setColor(color);
                graphics.fill3DRect(positionX, positionY, 5, 30, false);
                graphics.fill3DRect(positionX + 15, positionY, 5, 30, false);
                graphics.fill3DRect(positionX + 5, positionY + 5, 10, 20, false);
                graphics.fillOval(positionX + 4, positionY + 10, 10, 10);
                graphics.drawLine(positionX + 9, positionY + 15, positionX + 9, positionX - 4);
                break;

            case DOWN:
                graphics.fill3DRect(positionX + 5, positionY + 5, 30, 5, false);
                graphics.fill3DRect(positionX + 5, positionY + 20, 30, 4, false);
                graphics.fill3DRect(positionX + 10, positionY + 10, 20, 10, false);
                graphics.fillOval(positionX + 15, positionY + 10, 10, 10);
                graphics.drawLine(positionX + 20, positionY + 15, positionX + 40, positionY + 15);
                break;

            case LEFT:
                graphics.fill3DRect(positionX, positionY, 5, 30, false);
                graphics.fill3DRect(positionX + 15, positionY, 5, 30, false);
                graphics.fill3DRect(positionX + 5, positionY + 5, 10, 20, false);
                graphics.fillOval(positionX + 4, positionY + 10, 10, 10);
                graphics.drawLine(positionX + 9, positionY + 15, positionX + 9, positionY + 28);
                break;

            case RIGHT:
                graphics.fill3DRect(positionX + 5, positionY + 5, 30, 5, false);
                graphics.fill3DRect(positionX + 5, positionY + 20, 30, 4, false);
                graphics.fill3DRect(positionX + 10, positionY + 10, 20, 10, false);
                graphics.fillOval(positionX + 15, positionY + 10, 10, 10);
                graphics.drawLine(positionX + 20, positionY + 15, positionX - 5, positionY + 15);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Event : " + e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            this.setDirection(Direction.DOWN);
            this.setPositionY(this.getPositionY() + this.getSpeed());
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            this.setDirection(Direction.UP);
            this.setPositionY(this.getPositionY() - this.getSpeed());
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            setDirection(Direction.LEFT);
            setPositionX(getPositionX() - getSpeed());
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            setDirection(Direction.RIGHT);
            setPositionX(getPositionX() + getSpeed());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
