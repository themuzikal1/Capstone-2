package com.company;

import java.util.Random;


public class Shape  {
    protected enum Tektrominoe {

        NoShape(new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}}),
        StickShape(new int[][]{{0, -1}, {0, 0}, {0, 1}, {0, 2}}),
        ZShape(new int[][]{{0, -1}, {0, 0}, {1, 0}, {1, 1}}),
        MirroredLShape(new int[][]{{1, -1}, {0, -1}, {0, 0}, {0, 1}}),
        SquareShape(new int[][]{{0, 0}, {1, 0}, {0, 1}, {1, 1}}),
        PyramidShape(new int[][]{{-1, 0}, {0, 0}, {1, 0}, {0, 1}}),
        SShape(new int[][]{{0, -1}, {0, 0}, {-1, 0}, {-1, 1}}),
        LShape(new int[][]{{-1, -1}, {0, -1}, {0, 0}, {0, 1}});

        public int[][] coordinates; //coordinates for each shape

        Tektrominoe(int[][] coordinates) {
            this.coordinates = coordinates;
        }
    }

    private Tektrominoe pieceShape;
    private final int[][] coordinates;

    public Shape() {
        coordinates = new int [4][2];
        setShape(Tektrominoe.NoShape);
    }

    void setShape(Tektrominoe shape) {
        pieceShape = shape;
        for (int i = 0; i < 4; i++) {
        System.arraycopy(shape.coordinates[i], 0, coordinates[i], 0, 2);
        }
    }

    private void setX(int index, int x) {
        coordinates[index] [0] = x;
    }

    private void setY(int index, int y) {
        coordinates[index] [1] = y;
    }

    int x(int index) {
        return coordinates [index] [0];
    }

    int y(int index) {
        return coordinates [index] [1];
    }

    Tektrominoe getShape() {
        return pieceShape;
    }

    void setRandomShape() {
        Random r = new Random();
        int x = Math.abs(r.nextInt()) % 7 + 1;

    Tektrominoe[] values = Tektrominoe.values();
        setShape(values[x]);
    }

    int minY() {
    int m = coordinates [0] [1];
        for(int i=0; i<4; i++) {
        m=Math.min(m, coordinates[i][1]);
    }
    return m;
    }

    Shape rotateLeft() {
        if (pieceShape == Tektrominoe.SquareShape) {
        return this;
    }
    Shape result = new Shape();
        result.pieceShape = pieceShape;

        for(int i=0; i<4; i++) {
        result.setX(i, y(i));
        result.setY(i, -x(i));
    }
        return result;
    }

    Shape rotateRight() {
        if (pieceShape == Tektrominoe.SquareShape) {
            return this;
        }
    Shape result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; i++) {
            result.setX(i, -y(i));
            result.setY(i, x(i));
        }
        return result;

    }
}


























