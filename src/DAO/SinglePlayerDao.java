package DAO;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

import view.dialog.SinglePlayerDialog;
import view.object.Rock;
import view.object.Scissors;
import view.object.Tool;
import view.panel.SinglePlayerPanel;

public class SinglePlayerDao {
    public static void save(SinglePlayerDialog singlePlayerDialog) {
        try {
            FileWriter fileWriter = new FileWriter("resource/data/dataSinglePlayer.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(singlePlayerDialog.getPlayerName());
            printWriter.println(singlePlayerDialog.getPlayerScore());
            printWriter.println(singlePlayerDialog.getRemainingMoves());
            printWriter.println(singlePlayerDialog.getRemainingTime());
            Tool tools[][] = singlePlayerDialog.getToolBoard().getTools();
            for (int i = 0; i < tools.length; i++) {
                for (int j = 0; j < tools[i].length; j++) {
                    if (tools[i][j] instanceof Rock)
                        printWriter.println(0);
                    else if (tools[i][j] instanceof Scissors)
                        printWriter.println(1);
                    else
                        printWriter.println(2);
                }
            }
            printWriter.println(singlePlayerDialog.getToolBoard().getChoiceX());
            printWriter.println(singlePlayerDialog.getToolBoard().getChoiceY());
            Tool tool[] = singlePlayerDialog.getToolDice().getTools();
            for (int i = 0; i < tool.length; i++) {
                if (tool[i] instanceof Rock)
                    printWriter.println(0);
                else if (tool[i] instanceof Scissors)
                    printWriter.println(1);
                else
                    printWriter.println(2);

            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SinglePlayerPanel loadSinglePlayerPanel() {
        SinglePlayerPanel singlePlayerPanel = null;

        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("resource/data/dataSinglePlayer.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);
            singlePlayerPanel = (SinglePlayerPanel) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return singlePlayerPanel;
    }
}
