package in.shabhushan.tankfighter.game.engine;

import in.shabhushan.tankfighter.game.util.Defaults;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Shashi Bhushan
 * @date 16/9/18
 *
 * Base component for games and other similar graphics intensive
 * applications.
 *
 * Usage: Create instance of a GameEngine subclass, add to a
 * Container, and call the GameEngine's start() method. Parent
 * must be made visible prior to calling start(). Override update()
 * and draw() for custom game content.
 *
 * TODO: Change to JPanel for Supporting KeyBindings.
 * See {@link https://docs.oracle.com/javase/tutorial/uiswing/TOC.html} for Reference.
 */
public abstract class GameEngine extends JPanel implements Runnable {

    private static final long nanosecondsPerSecond = 10000000000L;
    private static final long millisecondsPerNanosecond = 1000000L;

    protected int frameRate; // how many times per second to (ideally) run the game loop
    private long timePerFrame; // nanoseconds per frame based on framerate

    protected Dimension resolution; // holds the width/height of game's canvas

    protected Color backgroundColor = Defaults.DEFAULT_BG_COLOR;

    protected boolean running;

    protected boolean gameFinished = false;

    protected final GameGrid gameGrid;

    protected ExecutorService executorService = Executors.newCachedThreadPool();

    // creates GameEngine with default resolution of 800x600 at 60 fps
    public GameEngine() {
        this(new Dimension(800, 600), Defaults.DEFAULT_FRAME_RATE);
    }

    // creates GameEngine with passed resolution at 60 fps
    public GameEngine(Dimension resolution) {
        this(resolution, Defaults.DEFAULT_FRAME_RATE);
    }

    // creates GameEngine with passed resolution at passed fps
    public GameEngine(Dimension resolution, int frameRate) {
        gameGrid = new GameGrid(resolution);

        this.resolution = resolution;
        this.frameRate = frameRate;

        timePerFrame = nanosecondsPerSecond / frameRate;
        setPreferredSize(resolution);
    }

    public GameGrid getGameGrid() {
        return gameGrid;
    }

    // final set up and starts game loop
    public void start() {
        running = true;
        executorService.execute(this);
    }

    public void stop() {
    }

    @Override
    public void run() {
        // game loop
        while (running) {
            long timeBeforeLoop = System.nanoTime(); // time when game loop starts

            checkForCollisions();
            update();
            //render();
            validate();
            repaint();

            if(gameFinished) {
                break;
            }

            try {
                Thread.sleep(calculateSleepTime(timeBeforeLoop));
            } catch (InterruptedException e) {
            }
        }
    }

    abstract public void checkForCollisions();

    // update everything in the game, should be overridden
    abstract public void update();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    // figure out how long the thread should sleep to keep a consistent frame rate
    private long calculateSleepTime(long beforeLoop) {
        long afterLoop = System.nanoTime(); // get time after loop
        long difference = afterLoop - beforeLoop; // calculate the difference
        long timeToSleep = (timePerFrame - difference) / millisecondsPerNanosecond; // calculate time to sleep in milliseconds

        // if you see this in the console when running, it means the game loop isn't keeping up with frame rate
        if (timeToSleep < 0) {
            System.out.println("sleep time is < 0. DO SOMETHING.");
        }
        return (timeToSleep > 0) ? timeToSleep : 0; // if timeToSleep is < 0, frame took longer than timePerFrame, so sleep time is 0
    }
}
