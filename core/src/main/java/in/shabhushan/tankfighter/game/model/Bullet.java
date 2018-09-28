package in.shabhushan.tankfighter.game.model;

import in.shabhushan.tankfighter.game.model.impl.GenericGameObject;

import java.awt.*;

import static in.shabhushan.tankfighter.game.util.Defaults.*;

public class Bullet extends GenericGameObject {

    public Bullet(Tank tank, Color bulletColor) {
        super(tank.getHorizontalPosition(), tank.getVerticalPosition(), tank.getObjectType(), tank.getGame());
        setDirection(tank.getDirection());
        setSpeed(DEFAULT_BULLET_SPEED);
        setColor(bulletColor);
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
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        switch(direction) {
            case UP:
                graphics.fill3DRect(horizontalPosition + DEFAULT_BULLET_BLOCK_DISTANCE, verticalPosition, DEFAULT_BULLET_BLOCK_WIDTH, DEFAULT_BULLET_BLOCK_WIDTH, false);
                break;
            case DOWN:
                graphics.fill3DRect(horizontalPosition + DEFAULT_BULLET_BLOCK_DISTANCE, verticalPosition + 2 * DEFAULT_TANK_BLOCK_DISTANCE, DEFAULT_BULLET_BLOCK_WIDTH, DEFAULT_BULLET_BLOCK_WIDTH, false);
                break;
            case RIGHT:
                graphics.fill3DRect(horizontalPosition + 2 * DEFAULT_TANK_BLOCK_DISTANCE, verticalPosition + DEFAULT_BULLET_BLOCK_DISTANCE, DEFAULT_BULLET_BLOCK_WIDTH, DEFAULT_BULLET_BLOCK_WIDTH, false);
                break;
            case LEFT:
                graphics.fill3DRect(horizontalPosition, verticalPosition + DEFAULT_BULLET_BLOCK_DISTANCE, DEFAULT_BULLET_BLOCK_WIDTH, DEFAULT_BULLET_BLOCK_WIDTH, false);
                break;
        }
    }
}
