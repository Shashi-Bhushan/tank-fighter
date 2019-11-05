package in.shabhushan.tankfighter.game;

import in.shabhushan.tankfighter.game.service.internal.TankGameServiceImpl;

public class TankFighter {
    public static void main(String[] args) {
        new TankGameServiceImpl().startGame();
    }
}
