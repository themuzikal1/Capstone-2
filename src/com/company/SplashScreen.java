package com.company;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;



abstract public class SplashScreen extends JWindow {


    public abstract void Splash();
    public abstract void showSplash();

}

class Instructions extends SplashScreen {
    @Override
    public void Splash() {
        Container container = getContentPane();
        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder());
        container.add(panel, BorderLayout.CENTER);

        JLabel label = new JLabel("LEFT arrow to move left. | " +
                "RIGHT arrow to move right. | " +
                "UP/DOWN to rotate piece. | " +
                "p to pause game. | " +
                "SPACE to drop piece to bottom of board. | " +
                "d to drop piece one line down. ");
        label.setFont(new Font ("Veranda", Font.BOLD, 14));
        panel.add(label);
        pack();
        setVisible(true);
    }

    @Override
    public void showSplash() {
        JFrame frame = new JFrame();
        int width = 450;
        int height = 115;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);
        setVisible((true));
    }
}



