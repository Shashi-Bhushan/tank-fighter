package in.shabhushan.tankfighter.game.service.internal;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.game.CircleGame;
import in.shabhushan.tankfighter.game.service.CircleGameService;

import javax.swing.*;

/**
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class CircleGameServiceImpl implements CircleGameService {

    private GameEngine circleGame;

    @Override
    public void startGame() {
        JFrame frame = new JFrame();
        circleGame = new CircleGame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(circleGame);
        frame.pack();
        frame.setVisible(true);
        circleGame.start();
    }

    @Override
    public void stopGame() {
        circleGame.stop();

        circleGame = null;
    }
}
