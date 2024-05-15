package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sound.Sounds;
import view.dialog.SinglePlayerDialog;
import view.dialog.SinglePlayerRulesDialog;
import view.frame.GameScreen;
import view.panel.SinglePlayerPanel;

public class SinglePlayerRulesDialogController implements ActionListener {
    private SinglePlayerRulesDialog singlePlayerRulesDialog;

    public SinglePlayerRulesDialogController(SinglePlayerRulesDialog singlePlayerRulesDialog) {
        this.singlePlayerRulesDialog = singlePlayerRulesDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SinglePlayerPanel singlePlayerPanel = singlePlayerRulesDialog.getSinglePlayerPanel();
        GameScreen gameScreen = singlePlayerPanel.getGameScreen();

        if (gameScreen.isSound())
            Sounds.clickButtonSound();

        if (e.getActionCommand().equals("OK")) {
            singlePlayerPanel.closeSinglePlayerRulesDialog();
            if (singlePlayerPanel.getSinglePlayerDialog() == null) {
                singlePlayerPanel.startSinglePlayer();
                singlePlayerPanel.getSinglePlayerDialog()
                        .setPlayerName(singlePlayerPanel.getNewGameDialog().getPlayerName());
            }
            singlePlayerPanel.getSinglePlayerDialog().enable();
            singlePlayerPanel.getSinglePlayerDialog().requestFocus();
        }

    }

}
