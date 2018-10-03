package in.shabhushan.tankfighter.game.model.impl;

import in.shabhushan.tankfighter.game.model.builder.BrickWallBuilder;

import java.awt.*;

public class BrickWall extends GenericGameObject {

    public BrickWall(BrickWallBuilder brickWallBuilder) {
        super(brickWallBuilder);
    }

    @Override
    public void update() {

    }

    /**
    -|-|-
    |-|-|
    -|-|-
    |-|-|
     */
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fill3DRect(horizontalPosition, verticalPosition, 30, 30, false);

        // Add Borders
        graphics.setColor(Color.WHITE);
        graphics.drawLine(horizontalPosition, verticalPosition, horizontalPosition + 30, verticalPosition);
        graphics.drawLine(horizontalPosition, verticalPosition + 30, horizontalPosition + 30, verticalPosition + 30);
        graphics.drawLine(horizontalPosition, verticalPosition, horizontalPosition, verticalPosition + 30);
        graphics.drawLine(horizontalPosition + 30, verticalPosition, horizontalPosition + 30, verticalPosition + 30);

        // Add Vertical Lines
        graphics.drawLine(horizontalPosition, verticalPosition + 7, horizontalPosition + 30, verticalPosition + 7);
        graphics.drawLine(horizontalPosition, verticalPosition + 15, horizontalPosition + 30, verticalPosition + 15);
        graphics.drawLine(horizontalPosition, verticalPosition + 22, horizontalPosition + 30, verticalPosition + 22);


        // Add Horizontal Lines
        graphics.drawLine(horizontalPosition + 10, verticalPosition, horizontalPosition + 10, verticalPosition + 7);
        graphics.drawLine(horizontalPosition + 20, verticalPosition, horizontalPosition + 20, verticalPosition + 7);

        graphics.drawLine(horizontalPosition + 7, verticalPosition + 7, horizontalPosition + 7, verticalPosition + 15);
        graphics.drawLine(horizontalPosition + 15, verticalPosition + 7, horizontalPosition + 15, verticalPosition + 15);
        graphics.drawLine(horizontalPosition + 22, verticalPosition + 7, horizontalPosition + 22, verticalPosition + 15);

        graphics.drawLine(horizontalPosition + 10, verticalPosition + 15, horizontalPosition + 10, verticalPosition + 7 + 15);
        graphics.drawLine(horizontalPosition + 20, verticalPosition + 15, horizontalPosition + 20, verticalPosition + 7 + 15);

        graphics.drawLine(horizontalPosition + 7, verticalPosition + 7 + 15, horizontalPosition + 7, verticalPosition + 15 + 15);
        graphics.drawLine(horizontalPosition + 15, verticalPosition + 7 + 15, horizontalPosition + 15, verticalPosition + 15 + 15);
        graphics.drawLine(horizontalPosition + 22, verticalPosition + 7 + 15, horizontalPosition + 22, verticalPosition + 15 + 15);
    }
}
