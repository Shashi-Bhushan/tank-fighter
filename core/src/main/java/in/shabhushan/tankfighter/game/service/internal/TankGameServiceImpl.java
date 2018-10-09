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

import in.shabhushan.tankfighter.game.core.TankFighterGameEngine;
import in.shabhushan.tankfighter.game.core.TankGameFrame;
import in.shabhushan.tankfighter.game.event.*;
import in.shabhushan.tankfighter.game.service.TankGameService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

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
