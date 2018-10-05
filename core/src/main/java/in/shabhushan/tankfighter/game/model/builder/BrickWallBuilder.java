package in.shabhushan.tankfighter.game.model.builder;

import in.shabhushan.tankfighter.game.core.GenericGameEngine;
import in.shabhushan.tankfighter.game.model.impl.BrickWall;

public class BrickWallBuilder extends GenericGameObjectBuilder<BrickWallBuilder> {

    public BrickWallBuilder(int horizontalPosition, int verticalPosition, GenericGameEngine game) {
        this.horizontalPosition = horizontalPosition;
        this.verticalPosition = verticalPosition;
        this.game = game;
        this.objectSize = 30;
    }

    @Override
    public BrickWall build() {
        return new BrickWall(this);
    }
}
