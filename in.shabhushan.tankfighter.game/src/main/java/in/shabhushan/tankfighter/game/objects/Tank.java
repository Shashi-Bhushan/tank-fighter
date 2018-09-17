package in.shabhushan.tankfighter.game.objects;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ID;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class Tank extends GameObject {
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
        graphics.setColor(color);

        switch (direction) {
            case UP:
                graphics.fill3DRect(positionX, positionY, 5, 30, false);
                graphics.fill3DRect(positionX + 15, positionY, 5, 30, false);
                graphics.fill3DRect(positionX + 5, positionY + 5, 10, 20, false);
                graphics.fillOval(positionX + 4, positionY + 10, 10, 10);
                graphics.drawLine(positionX + 9, positionY + 15, positionX + 9, positionY - 4);
                break;

            case DOWN:
                graphics.fill3DRect(positionX, positionY, 5, 30, false);
                graphics.fill3DRect(positionX + 15, positionY, 5, 30, false);
                graphics.fill3DRect(positionX + 5, positionY + 5, 10, 20, false);
                graphics.fillOval(positionX + 4, positionY + 10, 10, 10);
                graphics.drawLine(positionX + 9, positionY + 15, positionX + 9, positionY + 28);
                break;

            case LEFT:
                graphics.fill3DRect(positionX + 5, positionY + 5, 30, 5, false);
                graphics.fill3DRect(positionX + 5, positionY + 20, 30, 4, false);
                graphics.fill3DRect(positionX + 10, positionY + 10, 20, 10, false);
                graphics.fillOval(positionX + 15, positionY + 10, 10, 10);
                graphics.drawLine(positionX + 20, positionY + 15, positionX - 5, positionY + 15);
                break;

            case RIGHT:
                graphics.fill3DRect(positionX + 5, positionY + 5, 30, 5, false);
                graphics.fill3DRect(positionX + 5, positionY + 20, 30, 4, false);
                graphics.fill3DRect(positionX + 10, positionY + 10, 20, 10, false);
                graphics.fillOval(positionX + 15, positionY + 10, 10, 10);
                graphics.drawLine(positionX + 20, positionY + 15, positionX + 40, positionY + 15);
                break;
        }
    }
}
