/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Shashi Bhushan
 * @date 17/9/18
 */
package in.shabhushan.tankfighter.game.service.internal;

import in.shabhushan.tankfighter.game.core.TankGameFrame;
import in.shabhushan.tankfighter.game.event.*;
import in.shabhushan.tankfighter.game.model.Tank;
import in.shabhushan.tankfighter.game.service.TankGameService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class TankGameServiceImpl implements TankGameService {

    private JFrame gameFrame;

    @Override
    public void startGame() {
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

    private void addKeyBindings(TankGameFrame tankGameFrame) {
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

    @Override
    public void stopGame() {
        gameFrame.dispatchEvent(new WindowEvent(gameFrame, WindowEvent.WINDOW_CLOSING));
    }
}
