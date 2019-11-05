package in.shabhushan.tankfighter.game.core;

import in.shabhushan.tankfighter.game.model.Tank;

import java.awt.Dimension;

/**
 * TODO: Create WorldGrid and Tile Classes. Also Create a RoomManager Class with all instances.
 */
public class GameGrid {
    private final boolean[][] gameGrid;

    private int horizontalSize;
    private int verticalSize;

    public GameGrid(Dimension dimension) {
        horizontalSize = (int)dimension.getWidth();
        verticalSize = (int)dimension.getHeight();

        // 600 rows and 800 columns
        gameGrid = new boolean[verticalSize][horizontalSize];
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
