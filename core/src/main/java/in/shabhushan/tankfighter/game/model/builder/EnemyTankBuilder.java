package in.shabhushan.tankfighter.game.model.builder;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.ObjectType;
import in.shabhushan.tankfighter.game.model.Tank;
import in.shabhushan.tankfighter.game.model.impl.EnemyTank;

public class EnemyTankBuilder extends GenericTankBuilder<EnemyTankBuilder> {

    public EnemyTankBuilder(int horizontalPosition, int verticalPosition, ObjectType objectType, GameEngine game) {
        this.horizontalPosition = horizontalPosition;
        this.verticalPosition = verticalPosition;
        this.objectType = objectType;
        this.game = game;
    }

    @Override
    public Tank build() {
        return new EnemyTank(this);
    }
}
