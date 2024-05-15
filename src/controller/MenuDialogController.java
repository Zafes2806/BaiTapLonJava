package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sound.Sounds;
import view.dialog.MenuDialog;
import view.panel.MenuPanel;

public class MenuDialogController implements ActionListener{

    private MenuDialog menuDialog;

    public MenuDialogController(MenuDialog menuDialog) {
        this.menuDialog = menuDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MenuPanel menuPanel = menuDialog.getMenuPanel();
        if (menuPanel.getGameScreen().isSound())
            Sounds.clickButtonSound();
        switch (e.getActionCommand()) {
            case "Single Player":
                menuPanel.getGameScreen().closeMenuPanel();
                menuPanel.getGameScreen().openSinglePlayerPanel();
                break;
            case "Two Player":
                menuPanel.getGameScreen().closeMenuPanel();
                menuPanel.getGameScreen().openTwoPlayerPanel();
                break;
            case "Settings":
                menuPanel.closeMenuDialog();
                menuPanel.openSettingsDialog();
                break;
            case "Rank":
                menuPanel.closeMenuDialog();
                menuPanel.openRankDialog();
                break;
            case "About":
                menuPanel.closeMenuDialog();
                menuPanel.openAboutDialog();
                break;
            case "Exit":
                menuPanel.exit();
                break;

            default:
                break;
        }
    }
}
