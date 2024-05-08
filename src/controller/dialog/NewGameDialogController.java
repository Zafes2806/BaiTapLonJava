package controller.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sound.Sounds;
import view.dialog.NewGameDialog;
import view.frame.GameScreen;
import view.panel.SinglePlayerPanel;

public class NewGameDialogController implements ActionListener{
    private NewGameDialog newGameDialog;

    public NewGameDialogController(NewGameDialog newGameDialog) {
        this.newGameDialog = newGameDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SinglePlayerPanel singlePlayerPanel = newGameDialog.getSinglePlayerPanel();
        GameScreen gameScreen = singlePlayerPanel.getGameScreen();
        if (gameScreen.isSound())
            Sounds.clickButtonSound();
        if (e.getActionCommand().equals("Exit")) {
            singlePlayerPanel.closeNewGameDialog();
            singlePlayerPanel.openSinglePlayerOptionsDialog();
        } else if (e.getActionCommand().equals("OK")) {
            if (newGameDialog.getEditName().getText().length() > 12
                    || newGameDialog.getEditName().getText().length() < 6) {
                        newGameDialog.showAlertLabel();
                    } else {
                newGameDialog.setPlayerName(newGameDialog.getEditName().getText());
                singlePlayerPanel.closeNewGameDialog();
                singlePlayerPanel.openSinglePlayerRulesDialog();
            }
        }
    }

}
