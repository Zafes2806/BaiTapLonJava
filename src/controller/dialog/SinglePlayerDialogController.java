package controller.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import DAO.RankDAO;
import DAO.SinglePlayerDao;
import model.Player;
import sound.Sounds;
import view.dialog.SinglePlayerDialog;

public class SinglePlayerDialogController implements KeyListener, ActionListener {
    private SinglePlayerDialog singlePlayerDialog;

    public SinglePlayerDialogController(SinglePlayerDialog singlePlayerDialog) {
        this.singlePlayerDialog = singlePlayerDialog;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (singlePlayerDialog.getStatus() == false)
            return;

        if (e.getKeyCode() != KeyEvent.VK_LEFT && e.getKeyCode() != KeyEvent.VK_A && e.getKeyCode() != KeyEvent.VK_RIGHT
                && e.getKeyCode() != KeyEvent.VK_D && e.getKeyCode() != KeyEvent.VK_W
                && e.getKeyCode() != KeyEvent.VK_UP && e.getKeyCode() != KeyEvent.VK_DOWN
                && e.getKeyCode() != KeyEvent.VK_S)
            return;
        switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_A:
            if (singlePlayerDialog.getToolBoard().isValidMove(0, -1)) {
                if (singlePlayerDialog.getSinglePlayerPanel().getGameScreen().isSound())
                    Sounds.moveSound();
                singlePlayerDialog.getToolDice().moveLeft();
                singlePlayerDialog.getToolBoard().moveLeft();
                singlePlayerDialog.setRemainingMoves(singlePlayerDialog.getRemainingMoves() - 1);
            }
            break;
        case KeyEvent.VK_RIGHT:
        case KeyEvent.VK_D:
            if (singlePlayerDialog.getToolBoard().isValidMove(0, 1)) {
                if (singlePlayerDialog.getSinglePlayerPanel().getGameScreen().isSound())
                    Sounds.moveSound();
                singlePlayerDialog.getToolDice().moveRight();
                singlePlayerDialog.getToolBoard().moveRight();
                singlePlayerDialog.setRemainingMoves(singlePlayerDialog.getRemainingMoves() - 1);
            }
            break;
        case KeyEvent.VK_W:
        case KeyEvent.VK_UP:
            if (singlePlayerDialog.getToolBoard().isValidMove(-1, 0)) {
                if (singlePlayerDialog.getSinglePlayerPanel().getGameScreen().isSound())
                    Sounds.moveSound();
                singlePlayerDialog.getToolDice().moveUp();
                singlePlayerDialog.getToolBoard().moveUp();
                singlePlayerDialog.setRemainingMoves(singlePlayerDialog.getRemainingMoves() - 1);
            }
            break;
        case KeyEvent.VK_DOWN:
        case KeyEvent.VK_S:
            if (singlePlayerDialog.getToolBoard().isValidMove(1, 0)) {
                if (singlePlayerDialog.getSinglePlayerPanel().getGameScreen().isSound())
                    Sounds.moveSound();
                singlePlayerDialog.getToolDice().moveDown();
                singlePlayerDialog.getToolBoard().moveDown();
                singlePlayerDialog.setRemainingMoves(singlePlayerDialog.getRemainingMoves() - 1);
            }
            break;
        default:
            break;
        }
        if (singlePlayerDialog.getRemainingMoves() > 0) {
            singlePlayerDialog.updateRemainingMoves();
            return;
        }
        singlePlayerDialog.completePlayerMove();
        singlePlayerDialog.updateRemainingMoves();
        if (!singlePlayerDialog.checkWinningMove()) {
            singlePlayerDialog.disable();
            String playerName = singlePlayerDialog.getPlayerName();
            int playerScore = singlePlayerDialog.getPlayerScore();
            RankDAO.addPlayer(new Player(playerName, playerScore));
            RankDAO.updateRank();
            singlePlayerDialog.getSinglePlayerPanel().openSinglePlayerMatchResultDialog();
            return;
        }
        singlePlayerDialog.setRemainingTime(SinglePlayerDialog.MAX_TIME);
        singlePlayerDialog.updateTimeLabel();
        singlePlayerDialog.setRemainingMoves(SinglePlayerDialog.NUM_MOVES);
        singlePlayerDialog.updateRemainingMoves();

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (singlePlayerDialog.getSinglePlayerPanel().getGameScreen().isSound())
            Sounds.clickButtonSound();

        switch (e.getActionCommand()) {
        case "Home":
            singlePlayerDialog.close();
            singlePlayerDialog.getSinglePlayerPanel().close();
            singlePlayerDialog.getSinglePlayerPanel().remove(singlePlayerDialog);
            singlePlayerDialog.getSinglePlayerPanel().setSinglePlayerDialog(null);
            singlePlayerDialog.getSinglePlayerPanel().getGameScreen().openMenuPanel();
            break;
        case "Pause":
            singlePlayerDialog.pause();
            break;
        case "Resume":
            singlePlayerDialog.resume();
            break;
        case "Rules":
            singlePlayerDialog.disable();
            singlePlayerDialog.getSinglePlayerPanel().openSinglePlayerRulesDialog();
            break;
        case "Play Again":
            singlePlayerDialog.restart();
            singlePlayerDialog.resume();
            break;
        case "Mute":
            singlePlayerDialog.getSinglePlayerPanel().getGameScreen().setSound(false);
            singlePlayerDialog.getSinglePlayerPanel().getGameScreen().setMusic(false);
            singlePlayerDialog.mute();
            break;
        case "Unmute":
            singlePlayerDialog.getSinglePlayerPanel().getGameScreen().setSound(true);
            singlePlayerDialog.getSinglePlayerPanel().getGameScreen().setMusic(true);
            singlePlayerDialog.getSinglePlayerPanel().getGameScreen().getSoundTrack().start();
            singlePlayerDialog.unmute();
            if (!singlePlayerDialog.getSoundClock().isRunning())
                singlePlayerDialog.getSoundClock().start();
            break;
        case "Rank":
            singlePlayerDialog.disable();
            singlePlayerDialog.getSinglePlayerPanel().openRankDialog();
            ;
        case "Save":
            SinglePlayerDao.save(singlePlayerDialog);
            break;
        default:
            break;
        }
        singlePlayerDialog.requestFocusInWindow();
    }
}
