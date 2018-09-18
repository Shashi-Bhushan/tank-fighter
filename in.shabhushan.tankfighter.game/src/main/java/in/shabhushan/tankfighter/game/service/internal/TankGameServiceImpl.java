package in.shabhushan.tankfighter.game.service.internal;

import in.shabhushan.tankfighter.game.game.TankFighterGame;
import in.shabhushan.tankfighter.game.listener.GameKeyListener;
import in.shabhushan.tankfighter.game.service.TankGameService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

/**
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class TankGameServiceImpl implements TankGameService {

    JFrame gameFrame;
    private TankFighterGame tankFighterGame;

    @Override
    public void startGame() {
        gameFrame = new JFrame();

        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = defaultToolkit.getScreenSize();

        tankFighterGame = new TankFighterGame(screenSize);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.add(tankFighterGame);
        gameFrame.pack();
        gameFrame.setVisible(true);
        gameFrame.addKeyListener(new GameKeyListener(tankFighterGame.getPlayerTank()));
        tankFighterGame.start();

    }

    @Override
    public void stopGame() {
        tankFighterGame.stop();

        tankFighterGame = null;
        gameFrame.dispatchEvent(new WindowEvent(gameFrame, WindowEvent.WINDOW_CLOSING));
    }
}
