package controller.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.SinglePlayerDao;
import sound.Sounds;
import view.dialog.SinglePlayerOptionsDialog;
import view.panel.SinglePlayerPanel;

public class SinglePlayerOptionsDialogController implements ActionListener {
    private SinglePlayerOptionsDialog singlePlayerOptionsDialog;

    public SinglePlayerOptionsDialogController(SinglePlayerOptionsDialog singlePlayerOptionsDialog) {
        this.singlePlayerOptionsDialog = singlePlayerOptionsDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SinglePlayerPanel singlePlayerPanel = singlePlayerOptionsDialog.getSinglePlayerPanel();
        if (singlePlayerPanel.getGameScreen().isSound()) {
            Sounds.clickButtonSound();
        }
        switch (e.getActionCommand()) {
        case "Continue":
            singlePlayerPanel.closeSinglePlayerOptionsDialog();
            singlePlayerPanel.startSinglePlayer();
            singlePlayerPanel.getSinglePlayerDialog().pause();
            if (SinglePlayerDao.continueSingleplayer(singlePlayerPanel.getSinglePlayerDialog()))
                singlePlayerPanel.getSinglePlayerDialog().resume();
            else {
                singlePlayerPanel.getSinglePlayerDialog().close();
                singlePlayerPanel.close();
                singlePlayerPanel.remove(singlePlayerPanel.getSinglePlayerDialog());
                singlePlayerPanel.setSinglePlayerDialog(null);
                singlePlayerPanel.setVisible(true);
                singlePlayerPanel.openNewGameDialog();
            }
            break;
        case "New Game":
            singlePlayerPanel.closeSinglePlayerOptionsDialog();
            singlePlayerPanel.openNewGameDialog();
            break;
        case "Back":
            singlePlayerPanel.getGameScreen().closeSinglePlayerPanel();
            singlePlayerPanel.getGameScreen().openMenuPanel();
            break;
        default:
            break;
        }
    }
}
