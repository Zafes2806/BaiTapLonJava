package view.dialog;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.dialog.MenuDialogController;
import untils.ImagePaths;
import untils.Untils;
import view.panel.MenuPanel;

public class MenuDialog extends JPanel {

    private MenuDialogController menuDialogController;
    public static final int WIDTH = 217;
    public static final int HEIGHT = 491;

    private MenuPanel menuPanel;
    
    private JButton btnSinglePlayer;
    private JButton btnTwoPlayer;
    private JButton btnSettings;
    private JButton btnRank;
    private JButton btnAbout;
    private JButton btnExit;

    public MenuDialog(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;
        setLayout(new GridLayout(6, 1, 19, 0));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        menuDialogController = new MenuDialogController(this);
        initComponents();
        setOpaque(false);
        this.setVisible(false);
    }

    private void initComponents() {
        btnSinglePlayer = Untils.getButton(ImagePaths.MENU_SINGLE_PLAYER_1, ImagePaths.MENU_SINGLE_PLAYER_2);
        btnSinglePlayer.setActionCommand("Single Player");
        btnSinglePlayer.addActionListener(menuDialogController);
        this.add(btnSinglePlayer);

        btnTwoPlayer = Untils.getButton(ImagePaths.MENU_TWO_PLAYER_1, ImagePaths.MENU_TWO_PLAYER_2);
        btnTwoPlayer.setActionCommand("Two Player");
        btnTwoPlayer.addActionListener(menuDialogController);
        this.add(btnTwoPlayer);

        btnSettings = Untils.getButton(ImagePaths.MENU_SETTINGS_1, ImagePaths.MENU_SETTINGS_2);
        btnSettings.setActionCommand("Settings");
        btnSettings.addActionListener(menuDialogController);
        this.add(btnSettings);

        btnRank = Untils.getButton(ImagePaths.MENU_RANK_1, ImagePaths.MENU_RANK_2);
        btnRank.setActionCommand("Rank");
        btnRank.addActionListener(menuDialogController);
        this.add(btnRank);

        btnAbout = Untils.getButton(ImagePaths.MENU_ABOUT_1, ImagePaths.MENU_ABOUT_2);
        btnAbout.setActionCommand("About");
        btnAbout.addActionListener(menuDialogController);
        this.add(btnAbout);

        btnExit = Untils.getButton(ImagePaths.MENU_EXIT_1, ImagePaths.MENU_EXIT_2);
        btnExit.setActionCommand("Exit");
        btnExit.addActionListener(menuDialogController);
        this.add(btnExit);
    }

    public void exitGame() {
        System.exit(1);
    }

    public void open() {
        setVisible(true);
    }

    public void close() {
        setVisible(false);
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }
}
