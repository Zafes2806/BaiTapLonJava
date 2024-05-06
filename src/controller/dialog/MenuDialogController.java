package controller.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import view.dialog.MenuDialog;

public class MenuDialogController implements ActionListener {

    private MenuDialog menuDialog;

    public MenuDialogController(MenuDialog menuDialog) {
        this.menuDialog = menuDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            
        case "Single Player":
            menuDialog.getMenuPanel().openSinglePlayerOptionsPanel();
            break;
        case "Two Player":
            menuDialog.getMenuPanel().getGameScreen().closeMenuPanel();
            menuDialog.getMenuPanel().getGameScreen().openTwoPlayerPanel();
            break;
        case "Settings":
            menuDialog.getMenuPanel().openSettingsDialog();
            break;
        case "Rank":
            menuDialog.getMenuPanel().openRankDialog();
            break;
        case "About":
            menuDialog.getMenuPanel().openAboutDialog();
            break;
        case "Exit":
            menuDialog.getMenuPanel().exit();
            break;

        default:
            break;
        }
    }
}
