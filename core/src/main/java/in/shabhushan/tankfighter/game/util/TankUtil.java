package in.shabhushan.tankfighter.game.util;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.model.Bullet;
import in.shabhushan.tankfighter.game.model.Tank;

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

    public static boolean isSpaceOccupied(int horizontalPosition, int verticalPosition, Tank self, List<Tank> tanks) {
        boolean isSpaceOccupied = false;

        for(Tank tank: tanks) {
            if(tank != self) {
                int a = horizontalPosition + 15;
                int b = tank.getHorizontalPosition() + 15;

                int c = Math.abs(a - b);

                if (c < 30) {
                    a = verticalPosition + 15;
                    b = tank.getVerticalPosition() + 15;

                    c = Math.abs(a - b);
                    if (c < 30) {
                        isSpaceOccupied = true;
                        break;
                    }
                }
            }
        }

        return isSpaceOccupied;
    }
}
