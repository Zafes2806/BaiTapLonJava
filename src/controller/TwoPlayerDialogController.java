package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import sound.Sounds;
import view.dialog.TwoPlayerDialog;

public class TwoPlayerDialogController implements KeyListener, ActionListener {
    private TwoPlayerDialog twoPlayerDialog;

    public TwoPlayerDialogController(TwoPlayerDialog twoPlayerDialog) {
        this.twoPlayerDialog = twoPlayerDialog;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (twoPlayerDialog.getStatus() != TwoPlayerDialog.RUNNING)
            return;

        if (e.getKeyCode() != KeyEvent.VK_LEFT && e.getKeyCode() != KeyEvent.VK_A && e.getKeyCode() != KeyEvent.VK_RIGHT
                && e.getKeyCode() != KeyEvent.VK_D && e.getKeyCode() != KeyEvent.VK_W
                && e.getKeyCode() != KeyEvent.VK_UP && e.getKeyCode() != KeyEvent.VK_DOWN
                && e.getKeyCode() != KeyEvent.VK_S)
            return;
        switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_A:
            if (twoPlayerDialog.getToolBoard().isValidMove(0, -1)) {
                if (twoPlayerDialog.getTwoPlayerPanel().getGameScreen().isSound())
                    Sounds.moveSound();
                twoPlayerDialog.getToolDice().moveLeft();
                twoPlayerDialog.getToolBoard().moveLeft();
                twoPlayerDialog.setRemainingMoves(twoPlayerDialog.getRemainingMoves() - 1);
            }
            break;
        case KeyEvent.VK_RIGHT:
        case KeyEvent.VK_D:
            if (twoPlayerDialog.getToolBoard().isValidMove(0, 1)) {
                if (twoPlayerDialog.getTwoPlayerPanel().getGameScreen().isSound())
                    Sounds.moveSound();
                twoPlayerDialog.getToolDice().moveRight();
                twoPlayerDialog.getToolBoard().moveRight();
                twoPlayerDialog.setRemainingMoves(twoPlayerDialog.getRemainingMoves() - 1);
            }
            break;
        case KeyEvent.VK_W:
        case KeyEvent.VK_UP:
            if (twoPlayerDialog.getToolBoard().isValidMove(-1, 0)) {
                if (twoPlayerDialog.getTwoPlayerPanel().getGameScreen().isSound())
                    Sounds.moveSound();
                twoPlayerDialog.getToolDice().moveUp();
                twoPlayerDialog.getToolBoard().moveUp();
                twoPlayerDialog.setRemainingMoves(twoPlayerDialog.getRemainingMoves() - 1);
            }
            break;
        case KeyEvent.VK_DOWN:
        case KeyEvent.VK_S:
            if (twoPlayerDialog.getToolBoard().isValidMove(1, 0)) {
                if (twoPlayerDialog.getTwoPlayerPanel().getGameScreen().isSound())
                    Sounds.moveSound();
                twoPlayerDialog.getToolDice().moveDown();
                twoPlayerDialog.getToolBoard().moveDown();
                twoPlayerDialog.setRemainingMoves(twoPlayerDialog.getRemainingMoves() - 1);
            }
            break;
        default:
            break;
        }
        if (twoPlayerDialog.getRemainingMoves() > 0) {
            twoPlayerDialog.updateRemainingMoves();
            return;
        }
        twoPlayerDialog.completePlayerMove();
        twoPlayerDialog.updateRemainingMoves();
        if (twoPlayerDialog.finishedRound() && twoPlayerDialog.checkWin()) {
            twoPlayerDialog.getTwoPlayerPanel().getTwoPlayerDialog().endgame();
            return;
        }
        if (twoPlayerDialog.finishedRound()) {
            twoPlayerDialog.setRound(twoPlayerDialog.getRound() + 1);
            twoPlayerDialog.updateRound();
        }
        twoPlayerDialog.setRemainingTime(TwoPlayerDialog.MAX_TIME);
        twoPlayerDialog.updateTimeLabel();
        twoPlayerDialog.setRemainingMoves(TwoPlayerDialog.NUM_MOVES);
        twoPlayerDialog.switchPlayer();
        twoPlayerDialog.updateRemainingMoves();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (twoPlayerDialog.getTwoPlayerPanel().getGameScreen().isSound())
            Sounds.clickButtonSound();

        switch (e.getActionCommand()) {
        case "Home":
            twoPlayerDialog.close();
            twoPlayerDialog.getTwoPlayerPanel().close();
            twoPlayerDialog.getTwoPlayerPanel().remove(twoPlayerDialog);
            twoPlayerDialog.getTwoPlayerPanel().setTwoPlayerDialog(null);
            twoPlayerDialog.getTwoPlayerPanel().getGameScreen().openMenuPanel();
            break;
        case "Pause":
            twoPlayerDialog.pause();
            break;
        case "Resume":
            twoPlayerDialog.resume();
            break;
        case "Rules":
            twoPlayerDialog.disable();
            twoPlayerDialog.getTwoPlayerPanel().openTwoPlayerRulesDialog();
            break;
        case "Play Again":
            twoPlayerDialog.restart();
            twoPlayerDialog.resume();
            break;
        case "Mute":
            twoPlayerDialog.getTwoPlayerPanel().getGameScreen().setSound(false);
            twoPlayerDialog.getTwoPlayerPanel().getGameScreen().setMusic(false);
            twoPlayerDialog.mute();
            break;
        case "Unmute":
            Sounds.clickButtonSound();
            twoPlayerDialog.getTwoPlayerPanel().getGameScreen().setSound(true);
            twoPlayerDialog.getTwoPlayerPanel().getGameScreen().setMusic(true);
            twoPlayerDialog.getTwoPlayerPanel().getGameScreen().getSoundTrack().start();
            twoPlayerDialog.unmute();
            if (!twoPlayerDialog.getSoundClock().isRunning())
                twoPlayerDialog.getSoundClock().start();
            break;

        default:
            break;
        }
        twoPlayerDialog.requestFocusInWindow();
    }
}
