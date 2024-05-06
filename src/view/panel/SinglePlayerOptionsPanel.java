package view.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import untils.ImagePaths;
import view.dialog.NewGameDialog;
import view.dialog.SinglePlayerOptionsDialog;

public class SinglePlayerOptionsPanel extends JPanel {

    public static int WIDTH = 1100;
    public static int HEIGHT = 800;

    private MenuPanel menuPanel;

    private SinglePlayerOptionsDialog singlePlayerOptionsDialog;
    private NewGameDialog newGameDialog;

    public SinglePlayerOptionsPanel(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;
        setLayout(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initComponents();
        setVisible(false);
    }

    public void initComponents() {
        singlePlayerOptionsDialog = new SinglePlayerOptionsDialog(this);
        singlePlayerOptionsDialog.setBounds(442, 300, SinglePlayerOptionsDialog.WIDTH, SinglePlayerOptionsDialog.HEIGHT);
        add(singlePlayerOptionsDialog);

        newGameDialog = new NewGameDialog(this);
        newGameDialog.setBounds(331, 300, NewGameDialog.WIDTH, NewGameDialog.HEIGHT);
        add(newGameDialog);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon(ImagePaths.BACKGROUND_SINGLE_PLAYER_OPTIONS_PANEL).getImage();
        g.drawImage(image, 0, 0, this);
    }

    public void openSinglePlayerOptionsDialog() {
        singlePlayerOptionsDialog.open();
    }

    public void closeSinglePlayerOptionsDialog() {
        singlePlayerOptionsDialog.close();
    }

    public void openNewGameDialog() {
        singlePlayerOptionsDialog.close();
        newGameDialog.open();
    }

    public void closeNewGameDialog() {
        newGameDialog.close();
        singlePlayerOptionsDialog.open();
    }

    public void open() {
        singlePlayerOptionsDialog.open();
        setVisible(true);

    }
    public void close() {
        setVisible(false);
    }


    public MenuPanel getMenuPanel() {
        return menuPanel;
    }
}
