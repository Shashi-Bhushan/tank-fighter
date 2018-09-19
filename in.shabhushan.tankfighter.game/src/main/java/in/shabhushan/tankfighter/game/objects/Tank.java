package in.shabhushan.tankfighter.game.objects;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ID;
import in.shabhushan.tankfighter.game.util.TankUtil;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_BULLET_COUNT;
import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_PLAYER_TANK_COLOR;
import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_PLAYER_TANK_SPEED;

/**
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class Tank extends GameObject implements Runnable {

    final protected List<Bullet> bullets = new ArrayList<>();

    protected boolean interrupted = false;

    protected int timeToSleep = 1000;


    public Tank(int positionX, int positionY, ID id, GameEngine game) {
        super(positionX, positionY, id, game);

        setColor(DEFAULT_PLAYER_TANK_COLOR);
        setSpeed(DEFAULT_PLAYER_TANK_SPEED);
    }

    public Tank(int positionX, int positionY, ID id, GameEngine game, int speed, Color color) {
        this(positionX, positionY, id, game);

        setColor(color);
        setSpeed(speed);
    }


    public Tank(int positionX, int positionY, ID id, GameEngine game, Direction direction) {
        this(positionX, positionY, id, game);

        setDirection(direction);
    }

    @Override
    public void update() {
        // bullets.removeIf(bullet -> !TankUtil.objectWithinBoundary(bullet, game));

        ListIterator<Bullet> bulletListIterator = bullets.listIterator();
        while(bulletListIterator.hasNext()) {
            Bullet bullet = bulletListIterator.next();

            // Remove Last Bullet if it exceeds boundary
            if(!TankUtil.objectWithinBoundary(bullet, game)) {
                bulletListIterator.remove();
            }

            bullet.update();
        }
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
        for(Bullet bullet: bullets) {
            bullet.draw(graphics);
        }
    }

    /**
     * Thread will call update method periodically
     */
    @Override
    public void run() {
        while(!interrupted) {
            try {
                Thread.currentThread().sleep(timeToSleep);
                update();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
