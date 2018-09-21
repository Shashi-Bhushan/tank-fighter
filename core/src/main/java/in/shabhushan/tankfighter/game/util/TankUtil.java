package in.shabhushan.tankfighter.game.util;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.model.Bullet;

import java.util.List;
import java.util.ListIterator;

public class TankUtil {
    public static void updateBulletsPosition(List<Bullet> bullets, GameEngine game) {
        ListIterator<Bullet> bulletListIterator = bullets.listIterator();
        while(bulletListIterator.hasNext()) {
            Bullet bullet = bulletListIterator.next();

            // Remove Last Bullet if it exceeds boundary
            if(!GameUtil.objectWithinBoundary(bullet, game)) {
                bulletListIterator.remove();
            }

            bullet.update();
        }
    }
}
