package view.dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import untils.Constant;
import untils.ImagePaths;
import untils.Untils;

public class NewGameDialog extends JPanel {
    private final int width = 439;
    private final int height = 302;
    private JButton exit;
    private JButton ok;
    private JTextField editName;
    private JLabel alertLabel;

    public NewGameDialog() {
        setLayout(null);
        setPreferredSize(new Dimension(width, height));

        Image imageExit1 = new ImageIcon(ImagePaths.GAME_EXIT_1).getImage();
        Image imageExit2 = new ImageIcon(ImagePaths.GAME_EXIT_2).getImage();
        Image imageOK1 = new ImageIcon(ImagePaths.GAME_OK_1).getImage();
        Image imageOK2 = new ImageIcon(ImagePaths.GAME_OK_2).getImage();

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

        exit = new JButton(new ImageIcon(imageExit1));
        exit.setRolloverIcon(new ImageIcon(imageExit2));
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setFocusPainted(false);
        exit.setBounds(389, 15, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_HEIGHT);
        add(exit);

        ok = new JButton(new ImageIcon(imageOK1));
        ok.setRolloverIcon(new ImageIcon(imageOK2));
        ok.setBorderPainted(false);
        ok.setContentAreaFilled(false);
        ok.setFocusPainted(false);
        ok.setBounds(194, 240, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_HEIGHT);
        add(ok);

        setVisible(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageAboutDialog = new ImageIcon(ImagePaths.DIALOG_NEWGAME).getImage();
        g.drawImage(imageAboutDialog, 0, 0, width, 277, this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 800);
        frame.getContentPane().setLayout(null);
        NewGameDialog newGameDialog = new NewGameDialog();
        newGameDialog.setBounds(330, 200, newGameDialog.width, newGameDialog.height);
        newGameDialog.setVisible(true);
        frame.add(newGameDialog);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
