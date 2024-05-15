package view.dialog;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JPanel;

import controller.TwoPlayerRulesDialogController;
import untils.Constant;
import untils.ImagePaths;
import untils.Untils;
import view.panel.TwoPlayerPanel;

public class TwoPlayerRulesDialog extends JPanel {
    public static final int WIDTH = 674;
    public static final int HEIGHT = 546;

    private TwoPlayerRulesDialogController twoPlayerRulesDialogController;
    private TwoPlayerPanel twoPlayerPanel;
    private JButton btnOK;

    public TwoPlayerRulesDialog(TwoPlayerPanel twoPlayerPanel) {
        this.twoPlayerPanel = twoPlayerPanel;
        twoPlayerRulesDialogController = new TwoPlayerRulesDialogController(this);
        setLayout(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        btnOK = Untils.getButton(ImagePaths.GAME_OK_1, ImagePaths.GAME_OK_2);
        btnOK.setBounds(312, 490, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_HEIGHT);
        btnOK.setActionCommand("OK");
        btnOK.addActionListener(twoPlayerRulesDialogController);
        add(btnOK);

        setOpaque(false);
        setVisible(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon(ImagePaths.DIALOG_RULES_TWO_PLAYER).getImage();
        g.drawImage(image, 0, 0, WIDTH, HEIGHT - 20, this);
    }

    public void open() {
        setVisible(true);
    }

    public void close() {
        setVisible(false);
    }

    public TwoPlayerPanel getTwoPlayerPanel() {
        return twoPlayerPanel;
    }

}
