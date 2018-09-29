package in.shabhushan.tankfighter.game.model.builder;

import in.shabhushan.tankfighter.game.model.impl.HeadUpDisplay;

import javax.swing.*;

public class HeadUpDisplayBuilder extends GenericGameObjectBuilder<HeadUpDisplayBuilder> {
    private int width;
    private int height;
    private JLayeredPane layeredPane;
    private int value;

    public HeadUpDisplayBuilder(int horizontalPosition, int verticalPosition, int width, int height, JLayeredPane layeredPane) {
        this.horizontalPosition = horizontalPosition;
        this.verticalPosition = verticalPosition;
        this.width = width;
        this.height = height;
        this.layeredPane = layeredPane;
        this.outsideGameGrid = true;
    }

    public int getWidth() {
        return width;
    }

    public HeadUpDisplayBuilder setWidth(int width) {
        this.width = width;
        return self();
    }

    public int getHeight() {
        return height;
    }

    public HeadUpDisplayBuilder setHeight(int height) {
        this.height = height;
        return self();
    }

    public JLayeredPane getLayeredPane() {
        return layeredPane;
    }

    public int getValue() {
        return value;
    }

    public HeadUpDisplayBuilder setValue(int value) {
        this.value = value;
        return self();
    }

    @Override
    public HeadUpDisplay build() {
        return new HeadUpDisplay(this);
    }
}
