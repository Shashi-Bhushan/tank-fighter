package in.shabhushan.tankfighter.game.service.internal;

import in.shabhushan.tankfighter.game.game.TankFighterGame;
import in.shabhushan.tankfighter.game.listener.GameKeyListener;
import in.shabhushan.tankfighter.game.service.TankGameService;

import javax.swing.*;

/**
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class TankGameServiceImpl implements TankGameService {

    private TankFighterGame tankFighterGame;

    @Override
    public void startGame() {
        System.out.println("CircleGameServiceImpl#startGame");
        JFrame frame = new JFrame();
        tankFighterGame = new TankFighterGame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(tankFighterGame);
        frame.pack();
        frame.setVisible(true);
        frame.addKeyListener(new GameKeyListener(tankFighterGame.getPlayerTank()));
        tankFighterGame.start();
    }

    @Override
    public void stopGame() {
        tankFighterGame.stop();

        tankFighterGame = null;
    }
}
