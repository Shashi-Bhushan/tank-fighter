package in.shabhushan.tankfighter.game.objects;

import in.shabhushan.tankfighter.game.enumeration.ID;

import java.awt.*;
import java.awt.geom.Ellipse2D;
/**
 * @author Shashi Bhushan
 * @date 16/9/18
 */
public class Circle extends GameObject {
    private int width, height;

    public Circle(int x, int y, int radius, Color color) {
        super(x, y, ID.PLAYER);

        setColor(color);
        setVelocityX(random.nextInt(6) + 64);
        setVelocityY(random.nextInt(6) + 4);

        width = height = radius;
    }

    public void update() {
        if (positionX < 0 || positionX > getWidth() - width) // check left/right bounds
            velocityX *= -1; // reverse horizontal velocity
        if (positionY < 0 || positionY > getHeight() - height) // check top/bottom bounds
            velocityY *= -1; // reverse vertical velocity

        positionX += velocityX;
        positionY += velocityY;
    }

    public void draw(Graphics2D graphics) {
        graphics.setColor(color);
        Shape circle = new Ellipse2D.Float(positionX, positionY, width, height);
        graphics.fill(circle);
    }
}
