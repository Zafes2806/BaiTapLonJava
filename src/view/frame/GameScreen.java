package view.frame;

import javax.swing.JFrame;

import view.panel.MenuPanel;
import view.panel.SinglePlayerPanel;
import view.panel.TwoPlayerPanel;

public class GameScreen extends JFrame {
    // private J
    private MenuPanel menuPanel;

    private SinglePlayerPanel singlePlayerPanel;
    private TwoPlayerPanel twoPlayerPanel;

    public GameScreen() {
        setSize(1100, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuPanel = new MenuPanel(this);
        menuPanel.setBounds(0, 0, MenuPanel.WIDTH, MenuPanel.HEIGHT);
        add(menuPanel);
        menuPanel.setVisible(true);

        // singlePlayerPanel = new SinglePlayerPanel(this);

        twoPlayerPanel = new TwoPlayerPanel(this);
        twoPlayerPanel.setBounds(0, 0, TwoPlayerPanel.WIDTH, TwoPlayerPanel.HEIGHT);
        add(twoPlayerPanel);
        
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public void openMenuPanel() {
        menuPanel.open();
    }

    public void closeMenuPanel() {
        menuPanel.close();
    }

    public void openTwoPlayerPanel() {
        twoPlayerPanel.open();
    }

    public void closeTwoPlayerPanel() {
        twoPlayerPanel.close();
    }

    public TwoPlayerPanel getTwoPlayerPanel() {
        return twoPlayerPanel;
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }

    public static void main(String[] args) {
        new GameScreen();
    }
}
