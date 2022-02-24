package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import model.MatrixOps;
import view.MainScreen;

public class KeyEventListener implements KeyListener {
    private MainScreen mainScreen;

    public KeyEventListener(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        double[][] projection = new double[][] {{1, 0, 0}, {0, 1, 0}};
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            double angle = 0.1;
            ArrayList<double[][]> points = mainScreen.getCanvas().getShape().getPoints();
            double[][] one = MatrixOps.rotate(points.get(0), 1, angle);
            double[][] two = MatrixOps.rotate(points.get(1), 1, angle);
            double[][] three = MatrixOps.rotate(points.get(2), 1, angle);
            double[][] four = MatrixOps.rotate(points.get(3), 1, angle);
            double[][] five = MatrixOps.rotate(points.get(4), 1, angle);
            double[][] six = MatrixOps.rotate(points.get(5), 1, angle);
            double[][] seven = MatrixOps.rotate(points.get(6), 1, angle);
            double[][] eight = MatrixOps.rotate(points.get(7), 1, angle);
            points.clear();
            points.add(one);
            points.add(two);
            points.add(three);
            points.add(four);
            points.add(five);
            points.add(six);
            points.add(seven);
            points.add(eight);

            double[][] oneP = MatrixOps.mult(projection, one, 2, 3, 1);
            double[][] twoP = MatrixOps.mult(projection, two, 2, 3, 1);
            double[][] threeP = MatrixOps.mult(projection, three, 2, 3, 1);
            double[][] fourP = MatrixOps.mult(projection, four, 2, 3, 1);
            double[][] fiveP = MatrixOps.mult(projection, five, 2, 3, 1);
            double[][] sixP = MatrixOps.mult(projection, six, 2, 3, 1);
            double[][] sevenP = MatrixOps.mult(projection, seven, 2, 3, 1);
            double[][] eightP = MatrixOps.mult(projection, eight, 2, 3, 1);

            ArrayList<double[][]> projectedPoints = new ArrayList<>();
            projectedPoints.add(oneP);
            projectedPoints.add(twoP);
            projectedPoints.add(threeP);
            projectedPoints.add(fourP);
            projectedPoints.add(fiveP);
            projectedPoints.add(sixP);
            projectedPoints.add(sevenP);
            projectedPoints.add(eightP);

            mainScreen.getCanvas().getShape().setPoints(projectedPoints);
            mainScreen.getCanvas().repaint();
            mainScreen.getCanvas().getShape().setPoints(points);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
