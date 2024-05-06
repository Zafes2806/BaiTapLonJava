package controller.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.dialog.SettingsDialog;

public class SettingsDialogController implements ActionListener {

    private SettingsDialog settingsDialog;

    public SettingsDialogController(SettingsDialog settingsDialog) {
        this.settingsDialog = settingsDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Exit")) {
            settingsDialog.getMenuPanel().closeSettingsDialog();
        } else if (e.getActionCommand().equals("Music OFF")) {
            settingsDialog.offMusic();
        } else if (e.getActionCommand().equals("Music ON")) {
            settingsDialog.onMusic();
        } else if (e.getActionCommand().equals("Sound OFF")) {
            settingsDialog.offSound();
        } else if (e.getActionCommand().equals("Sound ON")) {
            settingsDialog.onSound();
        }
    }

}
