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

    private JFrame gameFrame = new JFrame();
    private JLayeredPane gamePane = new JLayeredPane();

    private TankFighterGameEngine tankFighterGameEngine;

    @Override
    public void startGame() {
        gameFrame = new JFrame();
        gamePane = new JLayeredPane();

        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = defaultToolkit.getScreenSize();

        gameFrame.setPreferredSize(screenSize);
        gameFrame.setLayout(new CardLayout());
        gameFrame.add(gamePane, "gameFrame");

        gamePane.setBounds(0, 0, screenSize.width, screenSize.height);

        TankFighterGameEngine tankFighterGameEngine = new TankFighterGameEngine(screenSize);
        tankFighterGameEngine.setBackground(Color.LIGHT_GRAY);
        tankFighterGameEngine.setBounds(0, 0, screenSize.width, screenSize.height);
        tankFighterGameEngine.setOpaque(true);
        gamePane.add(tankFighterGameEngine, new Integer(0), 0);


        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
