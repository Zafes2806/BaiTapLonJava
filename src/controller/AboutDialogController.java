package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sound.Sounds;
import view.dialog.AboutDialog;

public class AboutDialogController implements ActionListener{

    private AboutDialog aboutDialog;

    public AboutDialogController(AboutDialog dialog) {
        this.aboutDialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (aboutDialog.getMenuPanel().getGameScreen().isSound())
            Sounds.clickButtonSound();
        if (e.getActionCommand().equals("Exit")) {
            aboutDialog.getMenuPanel().closeAboutDialog();
            aboutDialog.getMenuPanel().openMenuDialog();
        }
    }

}
