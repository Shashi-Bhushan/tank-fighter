package in.shabhushan.tankfighter.game.util;

import in.shabhushan.tankfighter.game.core.GenericGameEngine;
import in.shabhushan.tankfighter.game.core.GameGrid;
import in.shabhushan.tankfighter.game.model.Bullet;
import in.shabhushan.tankfighter.game.model.Tank;

import java.util.List;
import java.util.ListIterator;

public class TankUtil {
    public static void updateBulletsPosition(List<Bullet> bullets, GenericGameEngine game) {
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

    public static boolean isSpaceOccupied(int newHorizontalPosition, int newVerticalPosition, Tank self) {
        GameGrid gameGrid = self.getGame().getGameGrid();

        return gameGrid.isSpaceOccupied(newVerticalPosition, newHorizontalPosition, self.getObjectSize());
    }
}
