package view.dialog;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.dialog.SinglePlayerOptionsDialogController;
import untils.ImagePaths;
import untils.Untils;
import view.panel.SinglePlayerOptionsPanel;

public class SinglePlayerOptionsDialog extends JPanel {
    public static final int WIDTH = 217;
    public static final int HEIGHT = 236;

    private SinglePlayerOptionsDialogController singlePlayerOptionsDialogController;

    private SinglePlayerOptionsPanel singlePlayerOptionsPanel;

    private JButton btnContinue;
    private JButton btnNewGame;
    private JButton btnBack;

    public SinglePlayerOptionsDialog(SinglePlayerOptionsPanel singlePlayerOptionsPanel) {
        singlePlayerOptionsDialogController = new SinglePlayerOptionsDialogController(this); 
        this.singlePlayerOptionsPanel = singlePlayerOptionsPanel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new GridLayout(3, 1, 19, 0));
        initComponents();
        setOpaque(false);
        setVisible(false);
    }

    public void initComponents() {
        btnContinue = Untils.getButton(ImagePaths.MENU_CONTINUE_1, ImagePaths.MENU_CONTINUE_2);
        btnContinue.setActionCommand("Continue");
        btnContinue.addActionListener(singlePlayerOptionsDialogController);
        this.add(btnContinue);

        btnNewGame = Untils.getButton(ImagePaths.MENU_NEW_GAME_1, ImagePaths.MENU_NEW_GAME_2);
        btnNewGame.setActionCommand("New Game");
        btnNewGame.addActionListener(singlePlayerOptionsDialogController);
        this.add(btnNewGame);

        btnBack = Untils.getButton(ImagePaths.MENU_BACK_1, ImagePaths.MENU_BACK_2);
        btnBack.setActionCommand("Back");
        btnBack.addActionListener(singlePlayerOptionsDialogController);
        this.add(btnBack);
    }

    public void open() {
        setVisible(true);
    }

    public void close() {
        setVisible(false);
    }

    public SinglePlayerOptionsPanel getSinglePlayerOptionsPanel() {
        return singlePlayerOptionsPanel;
    }

}
