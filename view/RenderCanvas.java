package view;

import javax.swing.JPanel;

import model.Shape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class RenderCanvas extends JPanel {
    private Shape shape;
    public RenderCanvas() {
        setPreferredSize(new Dimension(MainScreen.SCREEN_SIZE, MainScreen.SCREEN_SIZE));
        setBackground(Color.BLACK);

        shape = new Shape();
        shape.setCube();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        if (shape != null) {
            shape.render(g2);
        }
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}