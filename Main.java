import javax.swing.JFrame;

import view.MainScreen;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(400, 400);
        window.setTitle("3D Rendering");

        MainScreen screen = new MainScreen(window);
        screen.init();

        window.pack();
        window.setVisible(true);
    }
} 