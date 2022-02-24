package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import view.MainScreen;

public class Shape implements Renderable {
    private ArrayList<double[][]> points;
    private int resizeScalar = 250;

    public Shape(ArrayList<double[][]> points) {
        this.points = points;
    }

    public Shape() {
        this.points = new ArrayList<>();
    }

    public ArrayList<double[][]> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<double[][]> points) {
        this.points = points;
    }

    public void setCube() {
        points.add(new double[][] {{0.5}, {0.5}, {0.5}});
        points.add(new double[][] {{0.5}, {-0.5}, {0.5}});
        points.add(new double[][] {{-0.5}, {-0.5}, {0.5}});
        points.add(new double[][] {{-0.5}, {0.5}, {0.5}});

        points.add(new double[][] {{0.5}, {0.5}, {-0.5}});
        points.add(new double[][] {{0.5}, {-0.5}, {-0.5}});
        points.add(new double[][] {{-0.5}, {-0.5}, {-0.5}});
        points.add(new double[][] {{-0.5}, {0.5}, {-0.5}});
    }

    @Override
    public void render(Graphics2D g2) {
        int offset = MainScreen.SCREEN_SIZE/2;

        ArrayList<Integer[]> drawLines = new ArrayList<>();

        g2.setColor(Color.WHITE);
        for (double[][] p : points) {
            int x = (int)(p[0][0]*resizeScalar) + offset;
            int y = (int)(p[1][0]*resizeScalar) + offset;
            drawLines.add(new Integer[] {x, y});
            // g2.fillOval(x - 4, y - 4, 8, 8);
        }

        g2.drawLine(
            drawLines.get(1)[0], drawLines.get(1)[1], drawLines.get(2)[0], drawLines.get(2)[1]
        );
        g2.drawLine(
            drawLines.get(6)[0], drawLines.get(6)[1], drawLines.get(5)[0], drawLines.get(5)[1]
        );
        g2.drawLine(
            drawLines.get(2)[0], drawLines.get(2)[1], drawLines.get(6)[0], drawLines.get(6)[1]
        );
        g2.drawLine(
            drawLines.get(1)[0], drawLines.get(1)[1], drawLines.get(5)[0], drawLines.get(5)[1]
        );
        
        g2.drawLine(
            drawLines.get(4)[0], drawLines.get(4)[1], drawLines.get(0)[0], drawLines.get(0)[1]
        );
        g2.drawLine(
            drawLines.get(7)[0], drawLines.get(7)[1], drawLines.get(3)[0], drawLines.get(3)[1]
        );
        g2.drawLine(
            drawLines.get(4)[0], drawLines.get(4)[1], drawLines.get(7)[0], drawLines.get(7)[1]
        );
        g2.drawLine(
            drawLines.get(0)[0], drawLines.get(0)[1], drawLines.get(3)[0], drawLines.get(3)[1]
        );

        g2.drawLine(
            drawLines.get(4)[0], drawLines.get(4)[1], drawLines.get(5)[0], drawLines.get(5)[1]
        );
        g2.drawLine(
            drawLines.get(0)[0], drawLines.get(0)[1], drawLines.get(1)[0], drawLines.get(1)[1]
        );
        g2.drawLine(
            drawLines.get(3)[0], drawLines.get(3)[1], drawLines.get(2)[0], drawLines.get(2)[1]
        );
        g2.drawLine(
            drawLines.get(7)[0], drawLines.get(7)[1], drawLines.get(6)[0], drawLines.get(6)[1]
        );

        // g2.setColor(Color.GREEN);

        // g2.drawLine(
        //     drawLines.get(6)[0], drawLines.get(6)[1], drawLines.get(1)[0], drawLines.get(1)[1]
        // );
        // g2.drawLine(
        //     drawLines.get(1)[0], drawLines.get(1)[1], drawLines.get(3)[0], drawLines.get(3)[1]
        // );
        // g2.drawLine(
        //     drawLines.get(3)[0], drawLines.get(3)[1], drawLines.get(4)[0], drawLines.get(4)[1]
        // );
        // g2.drawLine(
        //     drawLines.get(4)[0], drawLines.get(4)[1], drawLines.get(6)[0], drawLines.get(6)[1]
        // );
        // g2.drawLine(
        //     drawLines.get(4)[0], drawLines.get(4)[1], drawLines.get(1)[0], drawLines.get(1)[1]
        // );
        // g2.drawLine(
        //     drawLines.get(3)[0], drawLines.get(3)[1], drawLines.get(6)[0], drawLines.get(6)[1]
        // );
    }
}