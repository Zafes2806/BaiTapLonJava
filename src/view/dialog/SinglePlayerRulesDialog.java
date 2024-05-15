package view.dialog;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.SinglePlayerRulesDialogController;
import untils.Constant;
import untils.ImagePaths;
import untils.Untils;
import view.panel.SinglePlayerPanel;

public class SinglePlayerRulesDialog extends JPanel {
    public static final int WIDTH = 671;
    public static final int HEIGHT = 504;
    
    private SinglePlayerPanel singlePlayerPanel;
    private SinglePlayerRulesDialogController singlePlayerRulesDialogController;
    
    private JButton btnOK;

    public SinglePlayerRulesDialog(SinglePlayerPanel singlePlayerPanel) {
        this.singlePlayerPanel = singlePlayerPanel;
        this.singlePlayerRulesDialogController = new SinglePlayerRulesDialogController(this); 
        setLayout(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        btnOK = Untils.getButton(ImagePaths.GAME_OK_1, ImagePaths.GAME_OK_2);
        btnOK.setBounds(312, 450, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_HEIGHT);
        btnOK.setActionCommand("OK");
        btnOK.addActionListener(singlePlayerRulesDialogController);
        add(btnOK);

        setOpaque(false);
        setVisible(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon(ImagePaths.DIALOG_RULES_SINGLE_PLAYER).getImage();
        g.drawImage(image, 0, 0, WIDTH, HEIGHT - 20, this);
    }

    public void open() {
        setVisible(true);
    }

    public void close() {
        setVisible(false);
    }

    public SinglePlayerPanel getSinglePlayerPanel() {
        return singlePlayerPanel;
    }
}
