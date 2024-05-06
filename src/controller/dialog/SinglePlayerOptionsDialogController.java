package controller.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.dialog.SinglePlayerOptionsDialog;

public class SinglePlayerOptionsDialogController implements ActionListener{
    private SinglePlayerOptionsDialog singlePlayerOptionsDialog;

    
    public SinglePlayerOptionsDialogController(SinglePlayerOptionsDialog singlePlayerOptionsDialog) {
        this.singlePlayerOptionsDialog = singlePlayerOptionsDialog;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { 
        switch (e.getActionCommand()) {
            case "Continue":
                break;
            case "New Game":
            singlePlayerOptionsDialog.getSinglePlayerOptionsPanel().openNewGameDialog();
                break;
            case "Back":
                singlePlayerOptionsDialog.getSinglePlayerOptionsPanel().getMenuPanel().closeSinglePlayerOptionsPanel();
                break;
            default:
                break;
        }
    }
}
