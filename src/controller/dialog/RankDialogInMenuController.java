package controller.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sound.Sounds;
import view.dialog.RankDialogInMenu;
import view.panel.MenuPanel;

public class RankDialogInMenuController implements ActionListener{
    private RankDialogInMenu rankDialog;

    public RankDialogInMenuController(RankDialogInMenu rankDialog) {
        this.rankDialog = rankDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MenuPanel menuPanel = (MenuPanel) rankDialog.getMenuPanel();
        if (menuPanel.getGameScreen().isSound())
            Sounds.clickButtonSound();
        if (e.getActionCommand().equals("Exit")) {
            if (menuPanel.isVisible()) {
                menuPanel.closeRankDialog();
                menuPanel.openMenuDialog();
            }  
        }
    }
}
