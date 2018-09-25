package in.shabhushan.tankfighter.game.model.builder;

import in.shabhushan.tankfighter.game.model.Tank;
import in.shabhushan.tankfighter.game.model.impl.PlayerTank;

public abstract class GenericTankBuilder<B extends GenericTankBuilder<B>> extends GenericGameObjectBuilder<B> {
    // Add Tank Specific Setters here

    @Override
    public abstract Tank build();
}
