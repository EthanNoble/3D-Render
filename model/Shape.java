package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.geom.Path2D;

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
            int z = (int)(p[2][0]*resizeScalar) + offset;
            drawLines.add(new Integer[] {x, y, z});
            //g2.fillOval(x - 4, y - 4, 8, 8);
            //g2.drawString(String.valueOf(points.indexOf(p)), x + 10, y + 10);
        }

        g2.setColor(Color.GREEN);
        // g2.drawLine(
        //     drawLines.get(1)[0], drawLines.get(1)[1], drawLines.get(2)[0], drawLines.get(2)[1]
        // );
        // g2.drawLine(
        //     drawLines.get(6)[0], drawLines.get(6)[1], drawLines.get(5)[0], drawLines.get(5)[1]
        // );
        // g2.drawLine(
        //     drawLines.get(2)[0], drawLines.get(2)[1], drawLines.get(6)[0], drawLines.get(6)[1]
        // );
        // g2.drawLine(
        //     drawLines.get(1)[0], drawLines.get(1)[1], drawLines.get(5)[0], drawLines.get(5)[1]
        // );
        Path2D.Double parallelogram1 = new Path2D.Double();
        parallelogram1.moveTo(drawLines.get(2)[0], drawLines.get(2)[1]);
        parallelogram1.lineTo(drawLines.get(1)[0], drawLines.get(1)[1]);
        parallelogram1.lineTo(drawLines.get(5)[0], drawLines.get(5)[1]);
        parallelogram1.lineTo(drawLines.get(6)[0], drawLines.get(6)[1]);
        parallelogram1.closePath();
        double[] v1 = new double[] {
            drawLines.get(2)[0] - drawLines.get(1)[0],
            drawLines.get(2)[1] - drawLines.get(1)[1],
            drawLines.get(2)[2] - drawLines.get(1)[2]
        };
        double[] v2 = new double[] {
            drawLines.get(5)[0] - drawLines.get(1)[0],
            drawLines.get(5)[1] - drawLines.get(1)[1],
            drawLines.get(5)[2] - drawLines.get(1)[2]
        };
        double[] cross = MatrixOps.crossProduct(v1, v2);
        if (cross[2] < 0) {
            g2.fill(parallelogram1);
        }
        
        g2.setColor(Color.RED);
        // g2.drawLine(
        //     drawLines.get(4)[0], drawLines.get(4)[1], drawLines.get(0)[0], drawLines.get(0)[1]
        // );
        // g2.drawLine(
        //     drawLines.get(7)[0], drawLines.get(7)[1], drawLines.get(3)[0], drawLines.get(3)[1]
        // );
        // g2.drawLine(
        //     drawLines.get(4)[0], drawLines.get(4)[1], drawLines.get(7)[0], drawLines.get(7)[1]
        // );
        // g2.drawLine(
        //     drawLines.get(0)[0], drawLines.get(0)[1], drawLines.get(3)[0], drawLines.get(3)[1]
        // );
        Path2D.Double parallelogram2 = new Path2D.Double();
        parallelogram2.moveTo(drawLines.get(4)[0], drawLines.get(4)[1]);
        parallelogram2.lineTo(drawLines.get(0)[0], drawLines.get(0)[1]);
        parallelogram2.lineTo(drawLines.get(3)[0], drawLines.get(3)[1]);
        parallelogram2.lineTo(drawLines.get(7)[0], drawLines.get(7)[1]);
        parallelogram2.closePath();
        double[] v11 = new double[] {
            drawLines.get(3)[0] - drawLines.get(0)[0],
            drawLines.get(3)[1] - drawLines.get(0)[1],
            drawLines.get(3)[2] - drawLines.get(0)[2]
        };
        double[] v22 = new double[] {
            drawLines.get(4)[0] - drawLines.get(0)[0],
            drawLines.get(4)[1] - drawLines.get(0)[1],
            drawLines.get(4)[2] - drawLines.get(0)[2]
        };
        double[] cross2 = MatrixOps.crossProduct(v11, v22);
        if (cross2[2] > 0) {
            g2.fill(parallelogram2);
        }

        // g2.drawLine(
        //     drawLines.get(4)[0], drawLines.get(4)[1], drawLines.get(5)[0], drawLines.get(5)[1]
        // );
        // g2.drawLine(
        //     drawLines.get(0)[0], drawLines.get(0)[1], drawLines.get(1)[0], drawLines.get(1)[1]
        // );
        // g2.drawLine(
        //     drawLines.get(3)[0], drawLines.get(3)[1], drawLines.get(2)[0], drawLines.get(2)[1]
        // );
        // g2.drawLine(
        //     drawLines.get(7)[0], drawLines.get(7)[1], drawLines.get(6)[0], drawLines.get(6)[1]
        // );

        g2.setColor(Color.YELLOW);
        Path2D.Double parallelogram3 = new Path2D.Double();
        parallelogram3.moveTo(drawLines.get(2)[0], drawLines.get(2)[1]);
        parallelogram3.lineTo(drawLines.get(3)[0], drawLines.get(3)[1]);
        parallelogram3.lineTo(drawLines.get(7)[0], drawLines.get(7)[1]);
        parallelogram3.lineTo(drawLines.get(6)[0], drawLines.get(6)[1]);
        parallelogram3.closePath();
        double[] v111 = new double[] {
            drawLines.get(3)[0] - drawLines.get(2)[0],
            drawLines.get(3)[1] - drawLines.get(2)[1],
            drawLines.get(3)[2] - drawLines.get(2)[2]
        };
        double[] v222 = new double[] {
            drawLines.get(6)[0] - drawLines.get(2)[0],
            drawLines.get(6)[1] - drawLines.get(2)[1],
            drawLines.get(6)[2] - drawLines.get(2)[2]
        };
        double[] cross3 = MatrixOps.crossProduct(v111, v222);
        if (cross3[2] < 0) {
            g2.fill(parallelogram3);
        }

        g2.setColor(Color.BLUE);
        Path2D.Double parallelogram4 = new Path2D.Double();
        parallelogram4.moveTo(drawLines.get(5)[0], drawLines.get(5)[1]);
        parallelogram4.lineTo(drawLines.get(1)[0], drawLines.get(1)[1]);
        parallelogram4.lineTo(drawLines.get(0)[0], drawLines.get(0)[1]);
        parallelogram4.lineTo(drawLines.get(4)[0], drawLines.get(4)[1]);
        parallelogram4.closePath();
        double[] v1111 = new double[] {
            drawLines.get(0)[0] - drawLines.get(1)[0],
            drawLines.get(0)[1] - drawLines.get(1)[1],
            drawLines.get(0)[2] - drawLines.get(1)[2]
        };
        double[] v2222 = new double[] {
            drawLines.get(5)[0] - drawLines.get(1)[0],
            drawLines.get(5)[1] - drawLines.get(1)[1],
            drawLines.get(5)[2] - drawLines.get(1)[2]
        };
        double[] cross4 = MatrixOps.crossProduct(v1111, v2222);
        if (cross4[2] > 0) {
            g2.fill(parallelogram4);
        }

        g2.setColor(Color.WHITE);
        Path2D.Double parallelogram5 = new Path2D.Double();
        parallelogram5.moveTo(drawLines.get(3)[0], drawLines.get(3)[1]);
        parallelogram5.lineTo(drawLines.get(0)[0], drawLines.get(0)[1]);
        parallelogram5.lineTo(drawLines.get(1)[0], drawLines.get(1)[1]);
        parallelogram5.lineTo(drawLines.get(2)[0], drawLines.get(2)[1]);
        parallelogram5.closePath();
        double[] v11111 = new double[] {
            drawLines.get(0)[0] - drawLines.get(1)[0],
            drawLines.get(0)[1] - drawLines.get(1)[1],
            drawLines.get(0)[2] - drawLines.get(1)[2]
        };
        double[] v22222 = new double[] {
            drawLines.get(2)[0] - drawLines.get(1)[0],
            drawLines.get(2)[1] - drawLines.get(1)[1],
            drawLines.get(2)[2] - drawLines.get(1)[2]
        };
        double[] cross5 = MatrixOps.crossProduct(v11111, v22222);
        if (cross5[2] < 0) {
            g2.fill(parallelogram5);
        }

        g2.setColor(Color.PINK);
        Path2D.Double parallelogram6 = new Path2D.Double();
        parallelogram6.moveTo(drawLines.get(7)[0], drawLines.get(7)[1]);
        parallelogram6.lineTo(drawLines.get(6)[0], drawLines.get(6)[1]);
        parallelogram6.lineTo(drawLines.get(5)[0], drawLines.get(5)[1]);
        parallelogram6.lineTo(drawLines.get(4)[0], drawLines.get(4)[1]);
        parallelogram6.closePath();
        double[] v111111 = new double[] {
            drawLines.get(5)[0] - drawLines.get(4)[0],
            drawLines.get(5)[1] - drawLines.get(4)[1],
            drawLines.get(5)[2] - drawLines.get(4)[2]
        };
        double[] v222222 = new double[] {
            drawLines.get(7)[0] - drawLines.get(4)[0],
            drawLines.get(7)[1] - drawLines.get(4)[1],
            drawLines.get(7)[2] - drawLines.get(4)[2]
        };
        double[] cross6 = MatrixOps.crossProduct(v111111, v222222);
        if (cross6[2] < 0) {
            g2.fill(parallelogram6);
        }

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