package in.shabhushan.tankfighter.game.objects;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.enumeration.ID;
import in.shabhushan.tankfighter.game.util.TankUtil;

import java.awt.*;

import static in.shabhushan.tankfighter.game.util.Defaults.DEFAULT_AI_TANK_SPEED;

public class EnemyTank extends Tank {
    public EnemyTank(int positionX, int positionY, ID id, GameEngine game) {
        super(positionX, positionY, id, game);
    }

    public EnemyTank(int positionX, int positionY, ID id, GameEngine game, int speed, Color color) {
        super(positionX, positionY, id, game, speed, color);
    }

    public EnemyTank(int positionX, int positionY, GameEngine game, Direction direction, int speed, Color color) {
        super(positionX, positionY, ID.ENEMY, game, speed, color);
        setDirection(direction);
    }

    @Override
    public void update() {
        if(TankUtil.objectWithinBoundary(this, game)) {
            positionY += DEFAULT_AI_TANK_SPEED;
            System.out.println("Position Y is : " + positionY);
        }
    }
}
