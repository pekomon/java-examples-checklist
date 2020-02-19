package com.example.patterns.adapter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Example of a case where it is possible to print individual coordinates (points) to screen but
 * we have lines to draw. So this is an adapter that makes lines to bunch of points
 * In this example there are only horizontal and vertical lines in the name of simplicity...
 */

class Coordinate {
    public int x,y;

    public Coordinate(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}

class Line {
    public Coordinate start, end;

    public Line(final Coordinate start, final Coordinate end) {
        this.start = start;
        this.end = end;
    }
}


public class LineToPointAdapter extends ArrayList<Coordinate> {

    public LineToPointAdapter(Line line) {

        final int left = Math.min(line.start.x, line.end.x);
        final int right = Math.max(line.start.x, line.end.x);

        final int top = Math.min(line.start.y, line.end.y);
        final int bottom = Math.max(line.start.y, line.end.y);

        // Is it a horizontal or vertical line...
        final int dx = right - left;
        final int dy = bottom - top;

        if (dx == 0) {
            for (int i = top; i <= bottom ; i++) {
                add(new Coordinate(left, i));
            }
        } else if (dy == 0) {
            for (int i = left; i <= right ; i++) {
                add(new Coordinate(i, top));
            }
        }
    }
}

class Screen {

    private boolean[][] points;
    private int dimensionX;
    private int dimensionY;

    public Screen(int x, int y) {
        dimensionX = x;
        dimensionY = y;
        points = new boolean[x][y];
        // Make arrays 'blank'
        for (boolean[] innerArray: points) {
            Arrays.fill(innerArray, false);
        }
    }

    public void addPoint(final Coordinate coordinate) {
        if (coordinate.x > dimensionX || coordinate.y > dimensionY
                || coordinate.x < 0 || coordinate.y < 0) {
            return;
        }
        points[coordinate.x][coordinate.y] = true;
    }

    public void print() {
        System.out.println();

        // Using 'X' to print borders

        for (int i = 0; i < 2 * dimensionX + 3; i++) {
            System.out.print("X");
        }
        System.out.println();

        for (int i = 0; i < dimensionY; i++) {
            System.out.print("X ");
            for (int j = 0; j < dimensionX; j++) {
                if (points[j][i]) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                // Some extra spacing to make it look nicer
                System.out.print(" ");
            }
            System.out.print("X");
            System.out.println();
        }

        for (int i = 0; i < 2 * dimensionX + 3; i++) {
            System.out.print("X");
        }
    }
}

class Demo {
    public static void main(String[] args) {

        Line line1 = new Line(
                new Coordinate(2,3),
                new Coordinate(2, 8)
        );

        Line line2 = new Line(
                new Coordinate( 4, 6),
                new Coordinate(7, 6)
        );

        LineToPointAdapter adapter1 = new LineToPointAdapter(line1);
        LineToPointAdapter adapter2 = new LineToPointAdapter(line2);

        Screen screen = new Screen(10, 10);
        adapter1.forEach(screen::addPoint);
        adapter2.forEach(screen::addPoint);

        screen.print();
    }


}