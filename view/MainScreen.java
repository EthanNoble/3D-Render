package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import controller.KeyEventListener;

public class MainScreen {
    public static final int SCREEN_SIZE = 650;
    private JFrame window;
    private RenderCanvas canvas;

    public MainScreen(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container cp = this.window.getContentPane();

        canvas = new RenderCanvas();
        cp.add(BorderLayout.CENTER, canvas);

        KeyEventListener keyListener = new KeyEventListener(this);
        canvas.addKeyListener(keyListener);

        canvas.setFocusable(true);
        canvas.requestFocus();
    }

    public RenderCanvas getCanvas() {
        return canvas;
    }
}