package in.shabhushan.tankfighter.game.objects;

import java.awt.*;

import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_BULLET_COLOR;
import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_BULLET_SPEED;

public class Bullet extends GameObject {

    public Bullet(Tank tank) {
        super(tank.getPositionX(), tank.getPositionY(), tank.getId(), tank.getGame());
        setDirection(tank.getDirection());
        setSpeed(DEFAULT_BULLET_SPEED);
    }

    @Override
    public void update() {
        switch (direction) {
            case UP:
                positionY -= speed;
                break;
            case DOWN:
                positionY += speed;
                break;
            case LEFT:
                positionX -= speed;
                break;
            case RIGHT:
                positionX += speed;
                break;
        }
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(DEFAULT_BULLET_COLOR);
        graphics.drawLine(positionX + 5, positionY + 5, positionX + 8, positionY + 8);
    }
}
