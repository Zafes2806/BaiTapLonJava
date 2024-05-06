package controller.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.dialog.NewGameDialog;

public class NewGameDialogController implements ActionListener{
    private NewGameDialog newGameDialog;

    public NewGameDialogController(NewGameDialog newGameDialog) {
        this.newGameDialog = newGameDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
        if (e.getActionCommand().equals("Exit"))
            newGameDialog.getSinglePlayerOptionsPanel().closeNewGameDialog();
    }
    
}
