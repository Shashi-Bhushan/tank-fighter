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
 * @date 19/9/18
 */
package in.shabhushan.tankfighter.game.util;

import java.awt.*;
import java.util.Locale;

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
    public static final int DEFAULT_AI_TANK_MAX_HEALTH_POINTS = 100;

    public static final Color DEFAULT_AI_BULLET_COLOR = Color.RED;
    public static final Color DEFAULT_PLAYER_BULLET_COLOR = Color.BLUE;
    public static final int DEFAULT_BULLET_SPEED = 20;
    public static final int DEFAULT_BULLET_COUNT = 5;

    public static final int DEFAULT_FRAME_RATE = 60;

    public static final Locale GAME_LOCALE = new Locale("ES", "US");
}
