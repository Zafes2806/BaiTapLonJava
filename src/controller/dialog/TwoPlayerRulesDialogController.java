package controller.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import untils.Sounds;
import view.dialog.TwoPlayerRulesDialog;
import view.panel.TwoPlayerPanel;

public class TwoPlayerRulesDialogController implements ActionListener{

    private TwoPlayerRulesDialog twoPlayerRulesDialog;

    public TwoPlayerRulesDialogController(TwoPlayerRulesDialog twoPlayerRulesDialog) {
        this.twoPlayerRulesDialog = twoPlayerRulesDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TwoPlayerPanel twoPlayerPanel = twoPlayerRulesDialog.getTwoPlayerPanel();
        if (twoPlayerPanel.getGameScreen().isSound())
            Sounds.clickButtonSound();
        if (e.getActionCommand().equals("OK")) {
            twoPlayerPanel.closeTwoPlayerRulesDialog();
            if (twoPlayerPanel.getTwoPlayerDialog() == null) {
                twoPlayerPanel.startTwoPlayer();
            }
            twoPlayerPanel.getTwoPlayerDialog().enable();
            twoPlayerPanel.getTwoPlayerDialog().requestFocus();
        }
    }
}
