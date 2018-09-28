package in.shabhushan.tankfighter.game.util;

import java.awt.*;

public final class Defaults {
    private Defaults() {}

    public static final Color DEFAULT_BG_COLOR = Color.GREEN;

    public static final int DEFAULT_TANK_BLOCK_WIDTH = 9;
    public static final int DEFAULT_TANK_BLOCK_DISTANCE = 10;
    public static final int DEFAULT_TANK_OBJECT_SIZE = DEFAULT_TANK_BLOCK_DISTANCE * 3;

    public static final int DEFAULT_BULLET_BLOCK_WIDTH = 6;
    public static final int DEFAULT_BULLET_BLOCK_DISTANCE = 12;


    public static final Color DEFAULT_PLAYER_TANK_COLOR = Color.DARK_GRAY;
    public static final int DEFAULT_PLAYER_TANK_SPEED = 15;

    public static final int DEFAULT_AI_TANK_NUMBER = 10;
    public static final Color DEFAULT_AI_TANK_COLOR = Color.BLACK;
    public static final int DEFAULT_AI_TANK_SPEED = 10;

    public static final Color DEFAULT_AI_BULLET_COLOR = Color.RED;
    public static final Color DEFAULT_PLAYER_BULLET_COLOR = Color.BLUE;
    public static final int DEFAULT_BULLET_SPEED = 20;
    public static final int DEFAULT_BULLET_COUNT = 5;

    public static final int DEFAULT_FRAME_RATE = 60;
}
