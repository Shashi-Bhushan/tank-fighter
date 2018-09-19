package in.shabhushan.tankfighter.game.model.impl;


import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ID;
import in.shabhushan.tankfighter.game.model.Bullet;
import in.shabhushan.tankfighter.game.model.Tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_BULLET_COUNT;
import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_PLAYER_TANK_COLOR;
import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_PLAYER_TANK_SPEED;

/**
 * This is a Generic Implementation for Tank, which gives default functionality to the implementation Tank class
 */
public abstract class GenericTank extends GenericGameObject implements Tank {

    final protected List<Bullet> bullets = new ArrayList<>();

    protected boolean interrupted = false;

    protected int timeToSleep = 1000;


    public GenericTank(int positionX, int positionY, ID id, GameEngine game) {
        super(positionX, positionY, id, game);

        setColor(DEFAULT_PLAYER_TANK_COLOR);
        setSpeed(DEFAULT_PLAYER_TANK_SPEED);
    }

    public GenericTank(int positionX, int positionY, ID id, GameEngine game, int speed, Color color) {
        this(positionX, positionY, id, game);

        setColor(color);
        setSpeed(speed);
    }


    public GenericTank(int positionX, int positionY, ID id, GameEngine game, Direction direction) {
        this(positionX, positionY, id, game);

        setDirection(direction);
    }

    public void addBullet(Bullet bullet) {
        if(bullets.size() < DEFAULT_BULLET_COUNT) {
            bullets.add(bullet);
        }
    }

    public void removeBullet(Bullet bullet) {
        bullets.remove(bullet);
    }

    /**
     * Draw Tank based on it's Direction
     * @param graphics
     */
    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(color);

        switch (direction) {
            case UP:
                graphics.fill3DRect(horizontalPosition, verticalPosition, 5, 30, false);
                graphics.fill3DRect(horizontalPosition + 15, verticalPosition, 5, 30, false);
                graphics.fill3DRect(horizontalPosition + 5, verticalPosition + 5, 10, 20, false);
                graphics.fillOval(horizontalPosition + 4, verticalPosition + 10, 10, 10);
                graphics.drawLine(horizontalPosition + 9, verticalPosition + 15, horizontalPosition + 9, verticalPosition - 4);
                break;

            case DOWN:
                graphics.fill3DRect(horizontalPosition, verticalPosition, 5, 30, false);
                graphics.fill3DRect(horizontalPosition + 15, verticalPosition, 5, 30, false);
                graphics.fill3DRect(horizontalPosition + 5, verticalPosition + 5, 10, 20, false);
                graphics.fillOval(horizontalPosition + 4, verticalPosition + 10, 10, 10);
                graphics.drawLine(horizontalPosition + 9, verticalPosition + 15, horizontalPosition + 9, verticalPosition + 28);
                break;

            case LEFT:
                graphics.fill3DRect(horizontalPosition + 5, verticalPosition + 5, 30, 5, false);
                graphics.fill3DRect(horizontalPosition + 5, verticalPosition + 20, 30, 4, false);
                graphics.fill3DRect(horizontalPosition + 10, verticalPosition + 10, 20, 10, false);
                graphics.fillOval(horizontalPosition + 15, verticalPosition + 10, 10, 10);
                graphics.drawLine(horizontalPosition + 20, verticalPosition + 15, horizontalPosition - 5, verticalPosition + 15);
                break;

            case RIGHT:
                graphics.fill3DRect(horizontalPosition + 5, verticalPosition + 5, 30, 5, false);
                graphics.fill3DRect(horizontalPosition + 5, verticalPosition + 20, 30, 4, false);
                graphics.fill3DRect(horizontalPosition + 10, verticalPosition + 10, 20, 10, false);
                graphics.fillOval(horizontalPosition + 15, verticalPosition + 10, 10, 10);
                graphics.drawLine(horizontalPosition + 20, verticalPosition + 15, horizontalPosition + 40, verticalPosition + 15);
                break;
        }
        for(Bullet bullet: bullets) {
            bullet.draw(graphics);
        }
    }

    /**
     * Do Nothing By Default in the Thread.
     */
    @Override
    public void run() {}
}
