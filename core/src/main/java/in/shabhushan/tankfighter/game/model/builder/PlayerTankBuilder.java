package in.shabhushan.tankfighter.game.model.builder;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.ObjectType;
import in.shabhushan.tankfighter.game.model.Tank;
import in.shabhushan.tankfighter.game.model.impl.PlayerTank;

/**
 * GenericTankBuilder<PlayerTankBuilder> can be used because PlayerTankBuilder extends from GenericTankBuilder.
 * I can not inherit from GenericTankBuilder's Type Parameter B. But because PlayerTankBuilder extends from GenericTankBuilder,
 * I can use PlayerTankBuilder as a type parameter here.
 */
public class PlayerTankBuilder extends GenericTankBuilder<PlayerTankBuilder> {

    public PlayerTankBuilder(int horizontalPosition, int verticalPosition, ObjectType objectType, int objectSize, GameEngine game) {
        this.horizontalPosition = horizontalPosition;
        this.verticalPosition = verticalPosition;
        this.objectType = objectType;
        this.objectSize = objectSize;
        this.game = game;
    }

    @Override
    public Tank build() {
        return new PlayerTank(this);
    }
}
