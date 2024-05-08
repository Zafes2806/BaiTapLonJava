package controller.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import untils.Sounds;
import view.dialog.RankDialogInSinglePlayer;
import view.panel.SinglePlayerPanel;

public class RankDialogInSinglePlayerController implements ActionListener {
    private RankDialogInSinglePlayer rankDialogInSinglePlayer;

    public RankDialogInSinglePlayerController(RankDialogInSinglePlayer rankDialogInSinglePlayer) {
        this.rankDialogInSinglePlayer = rankDialogInSinglePlayer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SinglePlayerPanel singlePlayerPanel = rankDialogInSinglePlayer.getSinglePlayerPanel();
        if (singlePlayerPanel.getGameScreen().isSound())
            Sounds.clickButtonSound();
        if (e.getActionCommand().equals("Exit")) {
            singlePlayerPanel.closeRankDialog();
            singlePlayerPanel.getSinglePlayerDialog().enable();
        }
    }
}
