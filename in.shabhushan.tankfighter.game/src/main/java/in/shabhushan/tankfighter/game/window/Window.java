package in.shabhushan.tankfighter.game.window;

import in.shabhushan.tankfighter.game.game.CircleGame;

import javax.swing.*;
import java.awt.*;

/**
 * @author Shashi Bhushan
 */
public class Window extends Canvas {
    public Window(int width, int height, String title, CircleGame game) {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.add(game);
        frame.setVisible(true);
    }
}
