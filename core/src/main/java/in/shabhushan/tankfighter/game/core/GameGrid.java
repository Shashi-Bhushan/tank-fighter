package in.shabhushan.tankfighter.game.core;

import in.shabhushan.tankfighter.game.model.GameObject;
import in.shabhushan.tankfighter.game.model.Tank;

import java.awt.Dimension;
import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * TODO: Create WorldGrid and Tile Classes. Also Create a RoomManager Class with all instances.
 */
public class GameGrid {
    private final boolean[][] gameGrid;
    private Map<BigInteger ,GameObject> gameObjects = new ConcurrentHashMap<>();

    private int horizontalSize;
    private int verticalSize;

    public GameGrid(Dimension dimension) {
        horizontalSize = (int)dimension.getWidth();
        verticalSize = (int)dimension.getHeight();

        // 600 rows and 800 columns
        gameGrid = new boolean[verticalSize][horizontalSize];
    }

    public void addGameObject(GameObject gameObject) {
        gameObjects.put(getCantorPairing(gameObject.getHorizontalPosition(), gameObject.getVerticalPosition()), gameObject);
    }

    public boolean isSpaceOccupied(GameObject gameObject) {
        BigInteger cantorPairing = getCantorPairing(gameObject.getHorizontalPosition(), gameObject.getVerticalPosition());

        return gameObjects.containsKey(cantorPairing);
    }

    public GameObject getGameObject(int horizontalPosition, int verticalPosition) {
        BigInteger cantorPairing = getCantorPairing(horizontalPosition, verticalPosition);

        return gameObjects.get(cantorPairing);
    }

    private BigInteger getCantorPairing(int x, int y) {
        return BigInteger.valueOf(((x + y) * ( x + y + 1)) / 2);
    }

    public int getHorizontalSize() {
        return horizontalSize;
    }

    public void setHorizontalSize(int horizontalSize) {
        this.horizontalSize = horizontalSize;
    }

    public int getVerticalSize() {
        return verticalSize;
    }

    public void setVerticalSize(int verticalSize) {
        this.verticalSize = verticalSize;
    }

    public void occupySpace(int verticalPosition, int horizontalPosition) {
        occupySpace(verticalPosition, horizontalPosition, 1);
    }

    public void occupySpace(int verticalPosition, int horizontalPosition, int size) {
        occupySpace(verticalPosition, horizontalPosition, size, size);
    }

    public void occupySpace(int verticalPosition, int horizontalPosition, int verticalSize, int horizontalSize) {
        for(int row = 0; row < verticalSize && row < gameGrid.length; row++) {
            for(int column = 0; column < horizontalSize && column < gameGrid[row].length; column++) {
                synchronized (Tank.class) {
                    gameGrid[verticalPosition + row][horizontalPosition + column] = true;
                }
            }
        }
    }

    public void vacantSpace(int verticalPosition, int horizontalPosition) {
        vacantSpace(verticalPosition, horizontalPosition, 1);
    }

    public void vacantSpace(int verticalPosition, int horizontalPosition, int size) {
        vacantSpace(verticalPosition, horizontalPosition, size, size);
    }

    public void vacantSpace(int verticalPosition, int horizontalPosition, int verticalSize, int horizontalSize) {
        for(int row = 0; row < verticalSize && row < gameGrid.length; row++) {
            for(int column = 0; column < horizontalSize && column < gameGrid[row].length; column++) {
                synchronized (Tank.class) {
                    gameGrid[verticalPosition + row][horizontalPosition + column] = false;
                }
            }
        }
    }

    public boolean isSpaceOccupied(int verticalPosition, int horizontalPosition) {
        return isSpaceOccupied(verticalPosition, horizontalPosition, 1);
    }

    public boolean isSpaceOccupied(int verticalPosition, int horizontalPosition, int size) {
        return isSpaceOccupied(verticalPosition, horizontalPosition, size, size);
    }

    public boolean isSpaceOccupied(int verticalPosition, int horizontalPosition, int verticalSize, int horizontalSize) {
        boolean isSpaceOccupied = false;

        for(int row = 0; row < verticalSize && row < gameGrid.length; row++) {
            for(int column = 0; column < horizontalSize && column < gameGrid[row].length; column++) {
                if(gameGrid[verticalPosition + row][horizontalPosition + column]) {
                    isSpaceOccupied = true;
                    break;
                }
            }
        }

        return isSpaceOccupied;
    }
}
