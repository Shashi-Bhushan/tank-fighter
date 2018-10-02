package in.shabhushan.tankfighter.game.model.impl;

import in.shabhushan.tankfighter.game.model.GameObject;
import in.shabhushan.tankfighter.game.model.builder.HeadUpDisplayBuilder;

import javax.swing.*;
import java.awt.*;

public class HeadUpDisplay extends GenericGameObject implements GameObject {

    private JProgressBar progressBar = new JProgressBar();

    private int width;
    private int height;

    private int value;

    public HeadUpDisplay(HeadUpDisplayBuilder headUpDisplayBuilder) {
        super(headUpDisplayBuilder);

        this.width = headUpDisplayBuilder.getWidth();
        this.height = headUpDisplayBuilder.getHeight();

        this.value = headUpDisplayBuilder.getValue();

        progressBar.setOpaque(true);
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setBackground(Color.LIGHT_GRAY);
        progressBar.setValue(value);
        progressBar.setBounds(horizontalPosition, verticalPosition, width, height);

        headUpDisplayBuilder.getLayeredPane().add(this.progressBar, new Integer(1), 0);
    }

    public void setValue(int healthPoints) {
        this.progressBar.setValue(healthPoints);
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void draw(Graphics graphics) {
        progressBar.repaint();
    }
}
