package com.company;

import javax.swing.*;
import java.awt.*;


public class Tektris extends JFrame {
    private JLabel statusBar;

    public Tektris() {
        initUI();
    }

    private void initUI() {
        statusBar = new JLabel(" 0" );
        add(statusBar, BorderLayout.NORTH);

        Board board = new Board(this);
        add(board);
        board.start();

        setTitle("TEKtris");
        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    JLabel getStatusBar() {
        return statusBar;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Tektris tektris = new Tektris();
            tektris.setVisible(true);
            Instructions inst = new Instructions();
            inst.Splash();
        });
    }
}
