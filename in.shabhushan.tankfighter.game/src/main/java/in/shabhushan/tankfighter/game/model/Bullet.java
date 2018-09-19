package in.shabhushan.tankfighter.game.model;

import in.shabhushan.tankfighter.game.model.impl.GenericGameObject;

import java.awt.*;

import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_BULLET_COLOR;
import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_BULLET_SPEED;

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
        graphics.drawLine(horizontalPosition + 5, verticalPosition + 5, horizontalPosition + 8, verticalPosition + 8);
    }
}
