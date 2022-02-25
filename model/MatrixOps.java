package model;

import java.lang.Math;
import java.util.Arrays;

public abstract class MatrixOps {
    public static double[][] mult(double[][] firstMatrix, double[][] secondMatrix, int r1, int c1, int c2) {
        double[][] product = new double[r1][c2];
        for(int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return product;
    }

    public static double[][] rotate(double[][] matrix, int c2, double a) {
        double[][] product = new double[2][c2];

        double[][] rotateX = new double[][] {
            {1, 0, 0},
            {0, Math.cos(a), -Math.sin(a)},
            {0, Math.sin(a), Math.cos(a)},
        };

        double[][] rotateZ = new double[][] {
            {Math.cos(a), -Math.sin(a), 0},
            {Math.sin(a), Math.cos(a), 0},
            {0, 0, 1}
        };

        product = mult(rotateX, matrix, 3, 3, c2);
        product = mult(rotateZ, product, 3, 3, c2);
        return product;
    }

    public static double[][] rotateX(double[][] matrix, int c2, double a) {
        double[][] product = new double[2][c2];

        double[][] rotateX = new double[][] {
            {1, 0, 0},
            {0, Math.cos(a), -Math.sin(a)},
            {0, Math.sin(a), Math.cos(a)},
        };

        product = mult(rotateX, matrix, 3, 3, c2);
        return product;
    }

    public static double[][] rotateY(double[][] matrix, int c2, double a) {
        double[][] product = new double[2][c2];

        double[][] rotateY = new double[][] {
            {Math.cos(a), 0, -Math.sin(a)},
            {0, 1, 0},
            {Math.sin(a), 0, Math.cos(a)},
        };


        product = mult(rotateY, matrix, 3, 3, c2);
        return product;
    }

    public static double[][] rotateZ(double[][] matrix, int c2, double a) {
        double[][] product = new double[2][c2];

        double[][] rotateZ = new double[][] {
            {Math.cos(a), -Math.sin(a), 0},
            {Math.sin(a), Math.cos(a), 0},
            {0, 0, 1}
        };

        product = mult(rotateZ, matrix, 3, 3, c2);
        return product;
    }

    public static double[][] project(double[][] matrix, int c2, double a) {
        double[][] product = new double[2][c2];

        double[][] rotate = new double[][] {
            {Math.cos(a), -Math.sin(a)},
            {Math.sin(a), Math.cos(a)}
        };

        product = mult(rotate, matrix, 2, 2, c2);
        return product;
    }

    public static double[] crossProduct(double u[], double v[]) {
        double crossProduct[] = new double[3];
        crossProduct[0] = u[1] * v[2] - u[2] * v[1];
        crossProduct[1] = u[2] * v[0] - u[0] * v[2];
        crossProduct[2] = u[0] * v[1] - u[1] * v[0];

        return crossProduct;
    }
}