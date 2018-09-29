package in.shabhushan.tankfighter.game.service.internal;

import in.shabhushan.tankfighter.game.game.TankFighterGameEngine;
import in.shabhushan.tankfighter.game.listener.GameKeyListener;
import in.shabhushan.tankfighter.game.model.builder.HeadUpDisplayBuilder;
import in.shabhushan.tankfighter.game.model.impl.HeadUpDisplay;
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
    private JLayeredPane lpane = new JLayeredPane();

    private TankFighterGameEngine tankFighterGameEngine;

    @Override
    public void startGame() {
        gameFrame = new JFrame();
        lpane = new JLayeredPane();

        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = defaultToolkit.getScreenSize();

        gameFrame.setPreferredSize(screenSize);
        gameFrame.setLayout(new BorderLayout());
        gameFrame.add(lpane, BorderLayout.CENTER);

        lpane.setBounds(0, 0, screenSize.width, screenSize.height);

        TankFighterGameEngine tankFighterGameEngine = new TankFighterGameEngine(screenSize);
        tankFighterGameEngine.setBackground(Color.LIGHT_GRAY);
        tankFighterGameEngine.setBounds(0, 0, screenSize.width, screenSize.height);
        tankFighterGameEngine.setOpaque(true);
        lpane.add(tankFighterGameEngine, new Integer(0), 0);

        HeadUpDisplay headUpDisplay = new HeadUpDisplayBuilder(screenSize.width - 120, 0, 120, 8, lpane)
                .setValue(65)
                .build();

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
