package in.shabhushan.tankfighter.game.model.builder;

import in.shabhushan.tankfighter.game.model.impl.BrickWall;

public class BrickWallBuilder extends GenericGameObjectBuilder<BrickWallBuilder> {
    @Override
    public BrickWall build() {
        return new BrickWall(this);
    }
}
