package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame Window = new JFrame();
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Window.setResizable(false);
        Window.setTitle("Happy Hannah");

        GamePanel gamePanel = new GamePanel();
        Window.add(gamePanel);
        Window.pack();

        Window.setLocationRelativeTo(null);
        Window.setVisible(true);

        gamePanel.startGameThread();
    }
}