package controller.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sound.Sounds;
import view.dialog.TwoPlayerMatchResultDialog;
import view.dialog.TwoPlayerDialog;
import view.panel.TwoPlayerPanel;

public class TwoPlayerMatchResultDialogController implements ActionListener {
    private TwoPlayerMatchResultDialog twoPlayerMatchResultDialog;

    public TwoPlayerMatchResultDialogController(TwoPlayerMatchResultDialog twoPlayerMatchResultDialog) {
        this.twoPlayerMatchResultDialog = twoPlayerMatchResultDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TwoPlayerPanel twoPlayerPanel = twoPlayerMatchResultDialog.getTwoPlayerPanel();
        TwoPlayerDialog twoPlayerDialog = twoPlayerPanel.getTwoPlayerDialog();

        if (twoPlayerPanel.getGameScreen().isSound())
            Sounds.clickButtonSound();

        switch (e.getActionCommand()) {
        case "Home": 
            twoPlayerPanel.closeTwoPlayerMatchResultDialog();
            twoPlayerDialog.close();
            twoPlayerPanel.close();
            twoPlayerPanel.remove(twoPlayerPanel.getTwoPlayerDialog());
            twoPlayerPanel.setTwoPlayerDialog(null);
            twoPlayerPanel.getGameScreen().openMenuPanel();
            break;
    
        case "Play again": 
            twoPlayerPanel.closeTwoPlayerMatchResultDialog();
            twoPlayerDialog.restart();
            twoPlayerDialog.enable();
            twoPlayerDialog.requestFocus();
            break;
        default:
            break;
        }
    }

}
