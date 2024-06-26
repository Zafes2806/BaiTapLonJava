package view.dialog;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.RankDAO;
import controller.RankDialogInMenuController;
import model.Player;
import untils.Constant;
import untils.ImagePaths;
import untils.Untils;
import view.panel.MenuPanel;

public class RankDialogInMenu extends JPanel {
    public static final int WIDTH = 627;
    public static final int HEIGHT = 385;
    private static final int MAX_PLAYERS = 5;

    private RankDialogInMenuController rankDialogController;

    private List<JLabel> names = new ArrayList<>();
    private List<JLabel> scores = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    private MenuPanel menuPanel;
    private JButton btnExit;

    public RankDialogInMenu(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;
        rankDialogController = new RankDialogInMenuController(this);
        setLayout(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initComponents();
        setOpaque(false);
        setVisible(false);
    }

    private void initComponents() {
        JPanel infoRank = new JPanel();
        infoRank.setLayout(null);
        infoRank.setBounds(85, 150, 480, 200);
        infoRank.setOpaque(false);

        Font teetree_18 = Untils.getFont(18);

        for (int i = 0; i < 5; i++) {
            names.add(new JLabel("", JLabel.LEFT));
            names.get(i).setFont(teetree_18);
            names.get(i).setBounds(0, 40 * i, 370, 40);
            infoRank.add(names.get(i));

            scores.add(new JLabel("", JLabel.LEFT));
            scores.get(i).setFont(teetree_18);
            scores.get(i).setBounds(370, 40 * i, 370, 40);
            infoRank.add(scores.get(i));
        }
        add(infoRank);

        btnExit = Untils.getButton(ImagePaths.GAME_EXIT_1, ImagePaths.GAME_EXIT_2);
        btnExit.setBounds(570, 15, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_HEIGHT);
        btnExit.setActionCommand("Exit");
        btnExit.addActionListener(rankDialogController);
        add(btnExit);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageAboutDialog = new ImageIcon(ImagePaths.DIALOG_RANK).getImage();
        g.drawImage(imageAboutDialog, 0, 0, this);
    }

    public void update() {
        this.players = RankDAO.getRank();
        for (int i = 0; i < players.size(); i++) {
            names.get(i).setText(players.get(i).getName());
            scores.get(i).setText(players.get(i).getScore() + "");
        }
        for (int i = players.size(); i < MAX_PLAYERS; i++) {
            names.get(i).setText("");
            scores.get(i).setText("");
        }
    }

    public void open() {
        update();
        setVisible(true);
    }

    public void close() {
        setVisible(false);
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public List<JLabel> getNames() {
        return names;
    }

    public void setNames(List<JLabel> names) {
        this.names = names;
    }

    public List<JLabel> getScores() {
        return scores;
    }

    public void setScores(List<JLabel> scores) {
        this.scores = scores;
    }
}
