package controller.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import untils.Sounds;
import view.dialog.SettingsDialog;
import view.panel.MenuPanel;

public class SettingsDialogController implements ActionListener{

    private SettingsDialog settingsDialog;

    public SettingsDialogController(SettingsDialog settingsDialog) {
        this.settingsDialog = settingsDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MenuPanel menuPanel = settingsDialog.getMenuPanel();
        if (menuPanel.getGameScreen().isSound())
            Sounds.clickButtonSound();
            
        if (e.getActionCommand().equals("Exit")) {
            menuPanel.closeSettingsDialog();
            menuPanel.openMenuDialog();
        } else if (e.getActionCommand().equals("Music OFF")) {
            menuPanel.getGameScreen().setMusic(false);
            settingsDialog.offMusic();
        } else if (e.getActionCommand().equals("Music ON")) {
            menuPanel.getGameScreen().setMusic(true);
            menuPanel.getGameScreen().getSoundTrack().start();
            settingsDialog.onMusic();
        } else if (e.getActionCommand().equals("Sound OFF")) {
            menuPanel.getGameScreen().setSound(false);
            settingsDialog.offSound();
        } else if (e.getActionCommand().equals("Sound ON")) {
            menuPanel.getGameScreen().setSound(true);
            settingsDialog.onSound();
        }
    }

}
