package in.shabhushan.tankfighter.game.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This Tank Game Panel has two sub panels, one with button "New Game" and another one with the actual Game.
 */
import static in.shabhushan.tankfighter.game.util.Defaults.GAME_LOCALE;

public class TankGameFrame extends JPanel implements ActionListener {

    private static final Logger LOG = LoggerFactory.getLogger(TankGameFrame.class);

    private final CardLayout cardLayout;

    private TankFighterGameEngine tankFighterGameEngine;

    public TankGameFrame(Dimension screenSize) {
        setPreferredSize(screenSize);
        cardLayout = new CardLayout();

        setLayout(cardLayout);

        addPanel(screenSize);

        setVisible(true);
    }

    private void addPanel(Dimension screenSize) {
        JPanel panel = new JPanel();

        JButton button = new JButton();
        button.setLocale(GAME_LOCALE);
        button.setText("New Game");
        button.addActionListener(this);

        panel.add(button);

        this.add(panel, "panel");

        tankFighterGameEngine = new TankFighterGameEngine(screenSize);
        tankFighterGameEngine.setBackground(Color.LIGHT_GRAY);
        tankFighterGameEngine.setBounds(0, 0, screenSize.width, screenSize.height);
        tankFighterGameEngine.setOpaque(true);
        this.add(tankFighterGameEngine, "gameFrame");
    }

    public TankFighterGameEngine getTankFighterGameEngine() {
        return tankFighterGameEngine;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("New Game")) {
            cardLayout.show(this, "gameFrame");
            tankFighterGameEngine.start();
        }
    }
}
