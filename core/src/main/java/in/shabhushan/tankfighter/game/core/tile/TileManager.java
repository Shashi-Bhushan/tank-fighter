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
 * @date Oct 10, 2018
 */
package in.shabhushan.tankfighter.game.core.tile;

import in.shabhushan.tankfighter.game.model.GameObject;
import in.shabhushan.tankfighter.game.util.GameUtil;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TileManager {
    private Map<BigInteger ,GameObject> tiles = new ConcurrentHashMap<>();

    public void addGameObject(GameObject gameObject) {
        tiles.put(GameUtil.getTileID(gameObject.getHorizontalPosition(), gameObject.getVerticalPosition()), gameObject);
    }

    public void removeGameObject(GameObject gameObject) {
        tiles.remove(GameUtil.getTileID(gameObject.getHorizontalPosition(), gameObject.getVerticalPosition()));
    }

    public boolean isSpaceOccupied(GameObject gameObject) {
        BigInteger cantorPairing = GameUtil.getTileID(gameObject.getHorizontalPosition(), gameObject.getVerticalPosition());

        return tiles.containsKey(cantorPairing);
    }

    public GameObject getGameObject(int horizontalPosition, int verticalPosition) {
        BigInteger cantorPairing = GameUtil.getTileID(horizontalPosition, verticalPosition);

        return tiles.get(cantorPairing);
    }
}
