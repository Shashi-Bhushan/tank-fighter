package in.shabhushan.tankfighter.game.service.internal;

import in.shabhushan.tankfighter.game.game.TankFighterGameEngine;
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
    private TankFighterGameEngine tankFighterGameEngine;

    @Override
    public void startGame() {
        gameFrame = new JFrame();

        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = defaultToolkit.getScreenSize();

        tankFighterGameEngine = new TankFighterGameEngine(screenSize);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.add(tankFighterGameEngine);
        gameFrame.pack();
        gameFrame.setVisible(true);
        gameFrame.addKeyListener(new GameKeyListener(tankFighterGameEngine.getPlayerTank()));
        tankFighterGameEngine.start();

    }

    @Override
    public void stopGame() {
        tankFighterGameEngine.stop();

        tankFighterGameEngine = null;
        gameFrame.dispatchEvent(new WindowEvent(gameFrame, WindowEvent.WINDOW_CLOSING));
    }
}
