package view.dialog;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.dialog.SinglePlayerMatchResultDialogController;
import untils.Constant;
import untils.ImagePaths;
import untils.Untils;
import view.panel.SinglePlayerPanel;

public class SinglePlayerMatchResultDialog extends JPanel {
    public static final int WIDTH = 627;
    public static final int HEIGHT = 385;

    private SinglePlayerPanel singlePlayerPanel;
    private SinglePlayerMatchResultDialogController singlePlayerMatchResultDialogController;

    private JLabel infoPlayer;
    private JLabel matchReSult;
    private JButton btnHome;
    private JButton btnPlayAgain;
    private JButton btnRank;

    public SinglePlayerMatchResultDialog(SinglePlayerPanel singlePlayerPanel) {
        this.singlePlayerPanel = singlePlayerPanel;
        singlePlayerMatchResultDialogController = new SinglePlayerMatchResultDialogController(this);

        setLayout(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initComponent();
        setOpaque(false);
        setVisible(false);
    }

    private void initComponent() {
        Font maintree_20 = Untils.getFont(20);

        infoPlayer = new JLabel("", JLabel.CENTER);
        infoPlayer.setFont(maintree_20);
        infoPlayer.setBounds(30, 120, 567, 30);
        add(infoPlayer);

        matchReSult = new JLabel("", JLabel.CENTER);
        matchReSult.setFont(maintree_20);
        matchReSult.setBounds(30, 170, 567, 30);
        add(matchReSult);
        setVisible(false);

        btnHome = Untils.getButton(ImagePaths.GAME_HOME_1, ImagePaths.GAME_HOME_2);
        btnHome.setBounds(231, 300, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_WIDTH);
        btnHome.setActionCommand("Home");
        btnHome.addActionListener(singlePlayerMatchResultDialogController);
        add(btnHome);

        btnPlayAgain = Untils.getButton(ImagePaths.GAME_PLAY_AGAIN_1, ImagePaths.GAME_PLAY_AGAIN_2);
        btnPlayAgain.setBounds(291, 300, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_WIDTH);
        btnPlayAgain.setActionCommand("Play again");
        btnPlayAgain.addActionListener(singlePlayerMatchResultDialogController);
        add(btnPlayAgain);

        btnRank = Untils.getButton(ImagePaths.GAME_RANK_1, ImagePaths.GAME_RANK_2);
        btnRank.setBounds(351, 300, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_WIDTH);
        btnRank.setActionCommand("Rank");
        btnHome.addActionListener(singlePlayerMatchResultDialogController);
        add(btnRank);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageAboutDialog = new ImageIcon(ImagePaths.DIALOG_MATCH_RESULT).getImage();
        g.drawImage(imageAboutDialog, 0, 0, WIDTH, HEIGHT, this);
    }

    public SinglePlayerPanel getSinglePlayerPanel() {
        return singlePlayerPanel;
    }

    public void open() {
        update();
        setVisible(true);
    }

    private void update() {
        infoPlayer.setText("Player's name: " + singlePlayerPanel.getNewGameDialog().getPlayerName());
        matchReSult.setText("Player's score: " + singlePlayerPanel.getSinglePlayerDialog().getPlayerScore());
    }

    public void close() {
        setVisible(false);
    }
}
