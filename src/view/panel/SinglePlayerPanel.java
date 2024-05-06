package view.panel;

import javax.swing.JPanel;

import view.dialog.NewGameDialog;
import view.dialog.RankDialog;
import view.dialog.SinglePlayerOptionsDialog;
import view.dialog.SinglePlayerRulesDialog;

public class SinglePlayerPanel extends JPanel {

    private MenuPanel menuPanel;
    private SinglePlayerOptionsDialog singlePlayerOptionsDialog;
    private NewGameDialog newGameDialog;
    private SinglePlayerRulesDialog singlePlayerRulesDialog;
    private ModeTwoPlayer modeTwoPlayer;
    private RankDialog rankDialog;

    public SinglePlayerPanel(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;
    }

    public void initComponents() {
        // singlePlayerOptionsDialog = new SinglePlayerOptionsDialog(this);
        singlePlayerOptionsDialog.setBounds(300, 200, SinglePlayerOptionsDialog.WIDTH,
                SinglePlayerOptionsDialog.HEIGHT);
        add(singlePlayerOptionsDialog);
    }

    public void  openSinglePlayerOptionsDialog() {
        singlePlayerOptionsDialog.setVisible(true);
    }

    public void closeSinglePlayerOptionsDialog() {
        singlePlayerOptionsDialog.setVisible(false);
    }

    public void openNewGameDialog() {
        newGameDialog.open();
        singlePlayerOptionsDialog.close();
    }

    public void closeNewGameDialog() {
        newGameDialog.close();
        singlePlayerOptionsDialog.open();
    }

    public void openRankDialog() {

    }

    public void closeRankDialog() {

    }

    public void open() {
        setVisible(true);
    }

    public void close() {
        setVisible(false);
    }

}
