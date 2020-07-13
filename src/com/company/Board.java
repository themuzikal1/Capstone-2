package com.company;

import com.company.Shape.Tektrominoe;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Board extends JPanel {
    private final int Board_Width = 10;
    private final int Board_Height = 25;
    private Timer timer;
    private boolean isFallingComplete = false;
    private boolean isPaused = false;
    private int numLinesRemoved = 0;
    private int curX = 0;
    private int curY = 0;
    private JLabel statusBar;
    private Shape currentPiece;
    private Tektrominoe[] board;

    public Board(Tektris parent) {
        initBoard(parent);
    }

    private void initBoard(Tektris parent) {
        setFocusable(true);
        statusBar = parent.getStatusBar();

        addKeyListener(new TAdapter());
    }

    private int squareWidth() {
        return (int) getSize().getWidth() / Board_Width;
    }

    private int squareHeight() {
        return (int) getSize().getHeight() / Board_Height;
    }

    private Tektrominoe shapeAt(int x, int y) {
        return board[(y * Board_Width) + x];
    }

    void start() {
        currentPiece = new Shape();
        board = new Tektrominoe[Board_Width * Board_Height];

        clearBoard();
        newPiece();

        timer = new Timer(400, new GameCycle());
        timer.start();
    }

    private void pause() {
        isPaused = !isPaused;
        if (isPaused) {
            statusBar.setText("Game Paused");
        } else {
            statusBar.setText(String.valueOf(numLinesRemoved));
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        Dimension size = getSize();
        int topOfBoard = (int) size.getHeight() - Board_Height * squareHeight();

        for(int i=0; i<Board_Height; i++) {
            for(int j=0; j<Board_Width; j++) {
                Tektrominoe shape = shapeAt(j, Board_Height - i - 1);
                if(shape != Tektrominoe.NoShape) {
                    drawSquare(g, j * squareWidth(),
                    topOfBoard + i * squareHeight(), shape);
                }
            }
        }
        if(currentPiece.getShape() != Tektrominoe.NoShape) {
            for(int i=0; i<4; i++) {
                int x = curX + currentPiece.x(i);
                int y = curY - currentPiece.y(i);

                drawSquare(g, x * squareWidth(), topOfBoard + (Board_Height - y - 1) * squareHeight(), currentPiece.getShape());
            }
        }

    }

    private void dropDown() {
        int newY = curY;
        while (newY > 0) {
            if(!tryMove(currentPiece, curX, newY-1)) {
                break;
            }
            newY--;
        }
        pieceDropped();
    }

    private void oneLineDown() {
        if(!tryMove(currentPiece, curX, curY -1)) {
            pieceDropped();
        }
    }

    private void clearBoard() {
        for(int i=0; i<Board_Height * Board_Width; i++) {
            board[i] = Tektrominoe.NoShape;
        }
    }

    private void pieceDropped() {
        for(int i=0; i<4; i++) {
            int x = curX + currentPiece.x(i);
            int y = curY - currentPiece.y(i);
            board[(y * Board_Width) + x] = currentPiece.getShape();
        }
        removeFullLine();
        if(!isFallingComplete) {
            newPiece();
        }
    }

    private void newPiece() {
        currentPiece.setRandomShape();
        curX = Board_Width / 2 + 1;
        curY = Board_Height - 1 + currentPiece.minY();

        if(!tryMove(currentPiece, curX, curY)) {
            currentPiece.setShape(Tektrominoe.NoShape);
            timer.stop();

            String msg = "GAME OVER!!! SCORE: " + numLinesRemoved;
            statusBar.setText(msg);
        }
    }

    private boolean tryMove(Shape newPiece, int newX, int newY) {
        for(int i=0; i<4; i++) {
            int x = newX + newPiece.x(i);
            int y = newY - newPiece.y(i);
            if(x<0 || x>= Board_Width || y<0 || y>= Board_Height) {
                return false;
            }
            if(shapeAt(x, y) != Tektrominoe.NoShape) {
                return false;
            }
        }
        currentPiece = newPiece;
        curX = newX;
        curY = newY;

        repaint();

        return true;

    }

    private void removeFullLine() {
        int numFullLines = 0;

        for(int i = Board_Height - 1; i>=0; i--) {
            boolean lineIsFull = true;
            for(int j = 0; j< Board_Width; j++) {
                if(shapeAt(j, i) == Tektrominoe.NoShape) {
                    lineIsFull = false;
                    break;
                }
            }
            if(lineIsFull) {
                numFullLines++;
                for(int k = i; k<Board_Height - 1; k++) {
                    for(int j = 0; j<Board_Width; j++) {
                        board[(k * Board_Width) + j] = shapeAt(j, k + 1);

                    }
                }
            }
        }
        if(numFullLines >0) {
            numLinesRemoved += numFullLines;
            statusBar.setText(String.valueOf(numLinesRemoved));
            isFallingComplete = true;
            currentPiece.setShape(Tektrominoe.NoShape);
        }
    }

    private void drawSquare(Graphics g, int x, int y, Tektrominoe shape) {
        Color[] colors = {new Color(72,  247, 159), new Color(192,  84, 247), new Color(75, 247, 59), new Color(247, 58, 35),
                new Color(247,  35, 166), new Color(36, 171, 24), new Color(103, 84, 247), new Color(247, 120, 35)};

     Color color = colors[shape.ordinal()];

     g.setColor(color);
     g.fillRect(x + 1, y+1, squareWidth() - 2, squareHeight() - 2);

     g.setColor(color.brighter());
     g.drawLine(x, y + squareHeight() - 1, x, y);
     g.drawLine(x, y, x + squareWidth() -1, y);

     g.setColor(color.darker());
     g.drawLine(x + 1, y + squareHeight() - 1, x + squareWidth()-1, y+ squareHeight() -1);
     g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1, x + squareWidth() - 1, y + 1);

    }

    private class GameCycle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            doGameCycle();

        }
    }

    private void doGameCycle(){
        update();
        repaint();
    }

    private void update() {
        if(isPaused) {
            return;
        }
        if(isFallingComplete) {
            isFallingComplete = false;
            newPiece();
        } else {
            oneLineDown();
        }
    }

    class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if(currentPiece.getShape() == Tektrominoe.NoShape) {
                return;
            }
            int keycode = e.getKeyCode();

            switch (keycode) {

                case KeyEvent.VK_P: pause();
                break;

                case KeyEvent.VK_RIGHT: tryMove(currentPiece, curX + 1, curY);
                    statusBar.setText(String.valueOf(numLinesRemoved));
                    break;

                case KeyEvent.VK_LEFT: tryMove(currentPiece, curX -1, curY);
                    statusBar.setText(String.valueOf(numLinesRemoved));
                    break;

                case KeyEvent.VK_UP: tryMove(currentPiece.rotateLeft(), curX, curY);
                    statusBar.setText(String.valueOf(numLinesRemoved));
                    break;

                case KeyEvent.VK_DOWN: tryMove(currentPiece.rotateRight(), curX, curY);
                    statusBar.setText(String.valueOf(numLinesRemoved));
                    break;

                case KeyEvent.VK_SPACE: dropDown();
                    break;

                case KeyEvent.VK_D: oneLineDown();
                    break;

                case KeyEvent.VK_ENTER:

                    try {
                        Thread.sleep(500);
                        String msg = "INVALID SELECTION:";
                        statusBar.setText(msg);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }

                default:
                    break;
                }
            }
        }

    }



























