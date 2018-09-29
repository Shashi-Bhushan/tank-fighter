package in.shabhushan.tankfighter.game.model.builder;

import in.shabhushan.tankfighter.game.model.Tank;
import in.shabhushan.tankfighter.game.model.impl.TankHealthBar;
import in.shabhushan.tankfighter.game.util.Defaults;

public class TankHealthBarBuilder extends GenericGameObjectBuilder<TankHealthBarBuilder> {
    private int width;
    private int height;
    private Tank tank;

    public TankHealthBarBuilder(Tank tank) {
        this.tank = tank;
        this.horizontalPosition = tank.getHorizontalPosition();
        this.verticalPosition = tank.getVerticalPosition() - 5;
        this.width = Defaults.DEFAULT_TANK_BLOCK_DISTANCE * 3;
        this.height = 3;
        this.outsideGameGrid = true;
    }

    public int getWidth() {
        return width;
    }

    public TankHealthBarBuilder setWidth(int width) {
        this.width = width;
        return self();
    }

    public int getHeight() {
        return height;
    }

    public TankHealthBarBuilder setHeight(int height) {
        this.height = height;
        return self();
    }

    public Tank getTank() {
        return tank;
    }

    public TankHealthBarBuilder setTank(Tank tank) {
        this.tank = tank;
        return self();
    }

    @Override
    public TankHealthBar build() {
        return new TankHealthBar(this);
    }
}
