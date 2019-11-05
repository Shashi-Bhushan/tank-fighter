package in.shabhushan.tankfighter.game;

import in.shabhushan.tankfighter.game.core.TankGameFrame;
import in.shabhushan.tankfighter.game.enumeration.Direction;
import in.shabhushan.tankfighter.game.event.*;
import in.shabhushan.tankfighter.game.model.Tank;
import in.shabhushan.tankfighter.game.util.TankUtil;

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
        actionMap.put("up", new MoveTankAction(playerTank, Direction.UP,
                () -> !TankUtil.isSpaceOccupied(playerTank.getHorizontalPosition(), playerTank.getVerticalPosition() - playerTank.getSpeed(), playerTank),
                () -> playerTank.setVerticalPosition(playerTank.getVerticalPosition() - playerTank.getSpeed())
        ));

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "down");
        actionMap.put("down", new MoveTankAction(playerTank, Direction.DOWN,
                () -> !TankUtil.isSpaceOccupied(playerTank.getHorizontalPosition(), playerTank.getVerticalPosition() + playerTank.getSpeed(), playerTank),
                () -> playerTank.setVerticalPosition(playerTank.getVerticalPosition() + playerTank.getSpeed())
        ));

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "left");
        actionMap.put("left", new MoveTankAction(playerTank, Direction.LEFT,
                () -> !TankUtil.isSpaceOccupied(playerTank.getHorizontalPosition() - playerTank.getSpeed(), playerTank.getVerticalPosition(), playerTank),
                () -> playerTank.setHorizontalPosition(playerTank.getHorizontalPosition() - playerTank.getSpeed())
        ));

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "right");
        actionMap.put("right", new MoveTankAction(playerTank, Direction.RIGHT,
                () -> !TankUtil.isSpaceOccupied(playerTank.getHorizontalPosition() + playerTank.getSpeed(), playerTank.getVerticalPosition(), playerTank),
                () -> playerTank.setHorizontalPosition(playerTank.getHorizontalPosition() + playerTank.getSpeed())
        ));

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "space");
        actionMap.put("space", new FireTankBulletAction(playerTank));
    }
}
