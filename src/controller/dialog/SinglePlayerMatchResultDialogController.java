package controller.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import untils.Sounds;
import view.dialog.SinglePlayerDialog;
import view.dialog.SinglePlayerMatchResultDialog;
import view.panel.SinglePlayerPanel;

public class SinglePlayerMatchResultDialogController implements ActionListener{
    private SinglePlayerMatchResultDialog singlePlayerMatchResultDialog;

    public SinglePlayerMatchResultDialogController(SinglePlayerMatchResultDialog singlePlayerMatchResultDialog) {
        this.singlePlayerMatchResultDialog = singlePlayerMatchResultDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SinglePlayerPanel singlePlayerPanel = singlePlayerMatchResultDialog.getSinglePlayerPanel();
        SinglePlayerDialog singlePlayerDialog = singlePlayerPanel.getSinglePlayerDialog();

        if (singlePlayerPanel.getGameScreen().isSound())
            Sounds.clickButtonSound();

        switch (e.getActionCommand()) {
        case "Home":
            singlePlayerPanel.closeSinglePlayerMatchResultDialog();
            singlePlayerDialog.close();
            singlePlayerPanel.close();
            singlePlayerPanel.remove(singlePlayerPanel.getSinglePlayerDialog());
            // singlePlayerPanel.setSinglePlayerDialog(null);
            singlePlayerPanel.getGameScreen().openMenuPanel();
            break;

        case "Play again":
            singlePlayerPanel.closeSinglePlayerMatchResultDialog();
            singlePlayerDialog.restart();
            singlePlayerDialog.enable();
            singlePlayerDialog.requestFocus();
            break;

        case "Rank":
            singlePlayerPanel.closeSinglePlayerMatchResultDialog();
            singlePlayerPanel.getGameScreen().getMenuPanel().openRankDialog();
            break;
        default:
            break;
        }
    }

}
