package in.shabhushan.tankfighter.game.model.impl;

import in.shabhushan.tankfighter.game.model.GameObject;
import in.shabhushan.tankfighter.game.model.Tank;
import in.shabhushan.tankfighter.game.model.builder.TankHealthBarBuilder;

import java.awt.*;

import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_AI_TANK_MAX_HEALTH_POINTS;

public class TankHealthBar extends GenericGameObject implements GameObject {

    private int width;
    private int height;
    private Tank tank;
    private int health;

    public TankHealthBar(TankHealthBarBuilder tankHealthBarBuilder) {
        super(tankHealthBarBuilder);

        this.width = tankHealthBarBuilder.getWidth();
        this.height = tankHealthBarBuilder.getHeight();
        this.tank = tankHealthBarBuilder.getTank();
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    /**
     * Get Health Points as percentage of width ans assign to value
     */
    @Override
    public void update() {
        this.horizontalPosition = tank.getHorizontalPosition();
        this.verticalPosition = tank.getVerticalPosition();
        this.health = width * (tank.getHealthPoints() / DEFAULT_AI_TANK_MAX_HEALTH_POINTS);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fill3DRect(horizontalPosition, verticalPosition, width, height, false);
        graphics.setColor(Color.GREEN);
        graphics.fill3DRect(horizontalPosition, verticalPosition, health, height, false);
    }
}
