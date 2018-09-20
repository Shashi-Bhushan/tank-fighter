package in.shabhushan.tankfighter.game.model;

import in.shabhushan.tankfighter.game.model.impl.GenericGameObject;

import java.awt.*;

import static in.shabhushan.tankfighter.game.util.Defaults.*;

public class Bullet extends GenericGameObject {

    public Bullet(Tank tank) {
        super(tank.getHorizontalPosition(), tank.getVerticalPosition(), tank.getObjectType(), tank.getGame());
        setDirection(tank.getDirection());
        setSpeed(DEFAULT_BULLET_SPEED);
    }

    @Override
    public void update() {
        switch (direction) {
            case UP:
                verticalPosition -= speed;
                break;
            case DOWN:
                verticalPosition += speed;
                break;
            case LEFT:
                horizontalPosition -= speed;
                break;
            case RIGHT:
                horizontalPosition += speed;
                break;
        }
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(DEFAULT_BULLET_COLOR);
        int width = DEFAULT_TANK_BLOCK_DISTANCE;
        int size = DEFAULT_TANK_BLOCK_DISTANCE;

        switch(direction) {
            case UP:
                graphics.fill3DRect(horizontalPosition + size, verticalPosition, width, width, false);
                break;
            case DOWN:
                graphics.fill3DRect(horizontalPosition + size, verticalPosition + 2 * size, width, width, false);
                break;
            case RIGHT:
                graphics.fill3DRect(horizontalPosition + 2 * size, verticalPosition + size, width, width, false);
                break;
            case LEFT:
                graphics.fill3DRect(horizontalPosition, verticalPosition + size, width, width, false);
                break;
        }
    }
}
