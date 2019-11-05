package in.shabhushan.tankfighter.game;

import in.shabhushan.tankfighter.game.core.TankGameFrame;
import in.shabhushan.tankfighter.game.event.*;
import in.shabhushan.tankfighter.game.model.Tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class TankFighter {
    private static JFrame gameFrame;

    public static void main(String[] args) {
        gameFrame = new JFrame();

        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = defaultToolkit.getScreenSize();

        gameFrame.setPreferredSize(screenSize);

        TankGameFrame tankGameFrame = new TankGameFrame(screenSize);
        gameFrame.add(tankGameFrame);

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.pack();
        gameFrame.setVisible(true);

        addKeyBindings(tankGameFrame);
    }

    private static void addKeyBindings(TankGameFrame tankGameFrame) {
        InputMap inputMap = tankGameFrame.getTankFighterGameEngine().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = tankGameFrame.getTankFighterGameEngine().getActionMap();
        Tank playerTank = tankGameFrame.getTankFighterGameEngine().getPlayerTank();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "up");
        actionMap.put("up", new MoveTankUpAction(playerTank));

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "down");
        actionMap.put("down", new MoveTankDownAction(playerTank));

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "left");
        actionMap.put("left", new MoveTankLeftAction(playerTank));

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "right");
        actionMap.put("right", new MoveTankRightAction(playerTank));

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "space");
        actionMap.put("space", new FireTankBulletAction(playerTank));
    }
}
