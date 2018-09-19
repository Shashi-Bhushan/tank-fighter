package in.shabhushan.tankfighter.game.engine;

import in.shabhushan.tankfighter.game.model.GameObject;

public class EnemyTankHandler extends Handler {
    @Override
    public void update() {
        System.out.println("Enemy Tank Handler");
        for(GameObject gameObject: gameObjects) {
            gameObject.update();
        }
    }
}
