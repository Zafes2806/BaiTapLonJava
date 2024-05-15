package view.dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.NewGameDialogController;
import untils.Constant;
import untils.ImagePaths;
import untils.Untils;
import view.panel.SinglePlayerPanel;

public class NewGameDialog extends JPanel {
    public static final int WIDTH = 439;
    public static final int HEIGHT = 302;
    private String playerName;

    private SinglePlayerPanel singlePlayerPanel;
    private NewGameDialogController newGameDialogController;

    private JButton btnExit;
    private JButton btnOK;
    private JTextField editName;
    private JLabel alertLabel;

    public NewGameDialog(SinglePlayerPanel singlePlayerPanel) {
        this.singlePlayerPanel = singlePlayerPanel;
        newGameDialogController = new NewGameDialogController(this);
        setLayout(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initComponents();
        setOpaque(false);
        setVisible(false);
    }

    public void initComponents() {
        editName = new JTextField();
        editName.setFont(Untils.getFont(18));
        editName.setBounds(65, 143, 260, 40);
        editName.setForeground(new Color(236, 214, 136));
        editName.setOpaque(false);
        editName.setBorder(null);
        add(editName);

        alertLabel = new JLabel("Name must be 6-12 characters!");
        alertLabel.setFont(Untils.getFont(13).deriveFont(Font.ITALIC));
        alertLabel.setBounds(65, 180, 280, 40);
        alertLabel.setForeground(Color.red);
        alertLabel.setVisible(false);
        add(alertLabel);

        btnExit = Untils.getButton(ImagePaths.GAME_EXIT_1, ImagePaths.GAME_EXIT_2);
        btnExit.setBounds(389, 15, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_HEIGHT);
        btnExit.setActionCommand("Exit");
        btnExit.addActionListener(newGameDialogController);
        add(btnExit);

        btnOK = Untils.getButton(ImagePaths.GAME_OK_1, ImagePaths.GAME_OK_2);
        btnOK.setBounds(194, 240, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_HEIGHT);
        btnOK.setActionCommand("OK");
        btnOK.addActionListener(newGameDialogController);
        add(btnOK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageAboutDialog = new ImageIcon(ImagePaths.DIALOG_NEWGAME).getImage();
        g.drawImage(imageAboutDialog, 0, 0, WIDTH, 277, this);
    }

    public void showAlertLabel() {
        alertLabel.setVisible(true);
    }

    public void open() {
        editName.setText("");
        playerName = "";
        alertLabel.setVisible(false);
        setVisible(true);
    }

    public void close() {
        setVisible(false);
    }

    public SinglePlayerPanel getSinglePlayerPanel() {
        return singlePlayerPanel;
    }

    public JTextField getEditName() {
        return editName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}
