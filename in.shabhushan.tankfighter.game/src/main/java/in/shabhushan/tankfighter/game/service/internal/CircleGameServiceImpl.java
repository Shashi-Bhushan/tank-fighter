package in.shabhushan.tankfighter.game.service.internal;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.game.Game;
import in.shabhushan.tankfighter.game.service.CircleGameService;

import javax.swing.*;

/**
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class CircleGameServiceImpl implements CircleGameService {

    private GameEngine game;

    @Override
    public void startGame() {
        JFrame frame = new JFrame();
        game = new Game();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setVisible(true);
        game.start();
    }

    @Override
    public void stopGame() {
        game.stop();

        game = null;
    }
}
