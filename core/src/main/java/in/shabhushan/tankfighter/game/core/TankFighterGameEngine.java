package in.shabhushan.tankfighter.game.core;

import java.awt.*;

/**
 * Game Engine is responsible for running {@link TankFighterGame}
 *
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class TankFighterGameEngine extends GenericGameEngine {

    private TankFighterGame tankFighterGame;

    private boolean isGameFinished;

    public TankFighterGameEngine(Dimension resolution) {
        super(resolution);

        tankFighterGame = new TankFighterGame(resolution);
    }

    @Override
    public void update() {
        tankFighterGame.update();

        setGameFinished(tankFighterGame.isGameFinished());

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        tankFighterGame.draw(g);
    }

    @Override
    public void start() {
        super.start();

        tankFighterGame.start(executorService);
    }

    public TankFighterGame getTankFighterGame() {
        return tankFighterGame;
    }

    public void setGameFinished(boolean gameFinished) {
        isGameFinished = gameFinished;
    }

    @Override
    public boolean isGameFinished() {
        return isGameFinished;
    }
}
