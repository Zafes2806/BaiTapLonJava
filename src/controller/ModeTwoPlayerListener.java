package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.panel.ModeTwoPlayer;

public class ModeTwoPlayerListener implements KeyListener, ActionListener {
    private ModeTwoPlayer modeTwoPlayer;

    public ModeTwoPlayerListener(ModeTwoPlayer modeTwoPlayer) {
        this.modeTwoPlayer = modeTwoPlayer;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() != KeyEvent.VK_LEFT && e.getKeyCode() != KeyEvent.VK_A && e.getKeyCode() != KeyEvent.VK_RIGHT
                && e.getKeyCode() != KeyEvent.VK_D && e.getKeyCode() != KeyEvent.VK_W
                && e.getKeyCode() != KeyEvent.VK_UP && e.getKeyCode() != KeyEvent.VK_DOWN
                && e.getKeyCode() != KeyEvent.VK_S)
            return;
        switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_A:
            if (modeTwoPlayer.getToolBoard().isValidMove(0, -1)) {
                modeTwoPlayer.getToolDice().moveLeft();
                modeTwoPlayer.getToolBoard().moveLeft();
                modeTwoPlayer.setRemainingMoves(modeTwoPlayer.getRemainingMoves() - 1);
            }
            break;
        case KeyEvent.VK_RIGHT:
        case KeyEvent.VK_D:
            if (modeTwoPlayer.getToolBoard().isValidMove(0, 1)) {
                modeTwoPlayer.getToolDice().moveRight();
                modeTwoPlayer.getToolBoard().moveRight();
                modeTwoPlayer.setRemainingMoves(modeTwoPlayer.getRemainingMoves() - 1);
            }
            break;
        case KeyEvent.VK_W:
        case KeyEvent.VK_UP:
            if (modeTwoPlayer.getToolBoard().isValidMove(-1, 0)) {
                modeTwoPlayer.getToolDice().moveUp();
                modeTwoPlayer.getToolBoard().moveUp();
                modeTwoPlayer.setRemainingMoves(modeTwoPlayer.getRemainingMoves() - 1);
            }
            break;
        case KeyEvent.VK_DOWN:
        case KeyEvent.VK_S:
            if (modeTwoPlayer.getToolBoard().isValidMove(1, 0)) {
                modeTwoPlayer.getToolDice().moveDown();
                modeTwoPlayer.getToolBoard().moveDown();
                modeTwoPlayer.setRemainingMoves(modeTwoPlayer.getRemainingMoves() - 1);
            }
            break;
        default:
            break;
        }
        if (modeTwoPlayer.getRemainingMoves() > 0) {
            modeTwoPlayer.updateRemainingMoves();
            return;
        }
        modeTwoPlayer.completePlayerMove();
        if (modeTwoPlayer.checkWin())
            return;
        if (modeTwoPlayer.getPlayer1Plays() == modeTwoPlayer.getPlayer2Plays()) {
            modeTwoPlayer.setRound(modeTwoPlayer.getRound() + 1);
            modeTwoPlayer.updateRound();
        }
        modeTwoPlayer.setRemainingTime(ModeTwoPlayer.MAX_TIME);
        modeTwoPlayer.updateTimeLabel();
        modeTwoPlayer.setRemainingMoves(ModeTwoPlayer.NUM_MOVES);
        modeTwoPlayer.updateRemainingMoves();
        modeTwoPlayer.switchPlayer();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        modeTwoPlayer.requestFocusInWindow();
    }
}
