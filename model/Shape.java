package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import view.MainScreen;

public class Shape implements Renderable {
    private ArrayList<double[][]> points;
    private int resizeScalar = 150;

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

        g2.setColor(Color.WHITE);
        for (double[][] p : points) {
            int x = (int)(p[0][0]*resizeScalar) + offset;
            int y = (int)(p[1][0]*resizeScalar) + offset;
            g2.fillOval(x, y, 8, 8);
        }
    }
}