package controller.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.dialog.TwoPlayerRulesDialog;

public class TwoPlayerRulesDialogController implements ActionListener {

    private TwoPlayerRulesDialog twoPlayerRulesDialog;

    public TwoPlayerRulesDialogController(TwoPlayerRulesDialog twoPlayerRulesDialog) {
        this.twoPlayerRulesDialog = twoPlayerRulesDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
        if (e.getActionCommand().equals("OK")) {
            twoPlayerRulesDialog.getTwoPlayerPanel().closeTwoPlayerRulesDialog();
            twoPlayerRulesDialog.getTwoPlayerPanel().openModeTwoPlayer();
            twoPlayerRulesDialog.getTwoPlayerPanel().getModeTwoPlayer().requestFocus();

        }
    }
    
}
