package in.shabhushan.tankfighter.game.service.internal;

import in.shabhushan.tankfighter.game.core.TankFighterGameEngine;
import in.shabhushan.tankfighter.game.core.TankGameFrame;
import in.shabhushan.tankfighter.game.event.*;
import in.shabhushan.tankfighter.game.listener.GameKeyListener;
import in.shabhushan.tankfighter.game.service.TankGameService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

/**
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class TankGameServiceImpl implements TankGameService {

    private JFrame gameFrame;

    private TankFighterGameEngine tankFighterGameEngine;

    @Override
    public void startGame() {
        gameFrame = new JFrame();

        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = defaultToolkit.getScreenSize();

        gameFrame.setPreferredSize(screenSize);

        //gameFrame.add(gamePane, "gameFrame");

        //gamePane.setBounds(0, 0, screenSize.width, screenSize.height);

        TankGameFrame tankGameFrame = new TankGameFrame(screenSize);
        gameFrame.add(tankGameFrame);

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.pack();
        gameFrame.setVisible(true);
        //gameFrame.addKeyListener(new GameKeyListener(tankGameFrame.getTankFighterGameEngine().getPlayerTank()));


        tankGameFrame.getTankFighterGameEngine().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "up");
        tankGameFrame.getTankFighterGameEngine().getActionMap().put("up", new MoveTankUpAction(tankGameFrame.getTankFighterGameEngine().getPlayerTank()));

        tankGameFrame.getTankFighterGameEngine().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "down");
        tankGameFrame.getTankFighterGameEngine().getActionMap().put("down", new MoveTankDownAction(tankGameFrame.getTankFighterGameEngine().getPlayerTank()));

        tankGameFrame.getTankFighterGameEngine().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "left");
        tankGameFrame.getTankFighterGameEngine().getActionMap().put("left", new MoveTankLeftAction(tankGameFrame.getTankFighterGameEngine().getPlayerTank()));

        tankGameFrame.getTankFighterGameEngine().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "right");
        tankGameFrame.getTankFighterGameEngine().getActionMap().put("right", new MoveTankRightAction(tankGameFrame.getTankFighterGameEngine().getPlayerTank()));

        tankGameFrame.getTankFighterGameEngine().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "space");
        tankGameFrame.getTankFighterGameEngine().getActionMap().put("space", new FireTankBulletAction(tankGameFrame.getTankFighterGameEngine().getPlayerTank()));

    }

    @Override
    public void stopGame() {
        tankFighterGameEngine.stop();

        tankFighterGameEngine = null;
        gameFrame.dispatchEvent(new WindowEvent(gameFrame, WindowEvent.WINDOW_CLOSING));
    }
}
