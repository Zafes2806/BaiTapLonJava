package DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import view.dialog.SinglePlayerDialog;
import view.object.Rock;
import view.object.Scissors;
import view.object.Tool;
import view.object.ToolBoard;
import view.object.ToolDice;

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

    public static boolean continueSingleplayer(SinglePlayerDialog singlePlayerDialog) {
       
        try {
            FileReader fileReader = new FileReader("resource/data/dataSinglePlayer.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String playerName;
            int playerScore;
            int remainingMoves;
            int remainingTime;
            int a1[][] = new int[9][9];
            int x, y;
            int a2[] = new int[6];
            String line;
            if ((line = bufferedReader.readLine()) != null) {
                playerName = line;
               
            } else {
                bufferedReader.close();
                return false;
            }
            if ((line = bufferedReader.readLine()) != null) {
                playerScore = Integer.parseInt(line);
            } else {
                bufferedReader.close();
                return false;
            }
            if ((line = bufferedReader.readLine()) != null) {
                remainingMoves = Integer.parseInt(line);
            } else {
                bufferedReader.close();
                return false;
            }
            if ((line = bufferedReader.readLine()) != null) {
                remainingTime = Integer.parseInt(line);
            } else {
                bufferedReader.close();
                return false;
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if ((line = bufferedReader.readLine()) != null) {
                        a1[i][j] = Integer.parseInt(line);
                    } else {
                        bufferedReader.close();
                        return false;
                    }
                }
            }
            if ((line = bufferedReader.readLine()) != null) {
                x = Integer.parseInt(line);
            } else {
                bufferedReader.close();
                return false;
            }
            if ((line = bufferedReader.readLine()) != null) {
                y = Integer.parseInt(line);
                
            } else {
                bufferedReader.close();
                return false;
            }
            for (int i = 0; i < 6; i++) {
                if ((line = bufferedReader.readLine()) != null) {
                    a2[i] = Integer.parseInt(line);
                } else {
                    bufferedReader.close();
                    return false;
                }
            }
            ToolBoard toolBoard = new ToolBoard(a1, x, y);
            System.out.println(toolBoard.getChoiceX());
            singlePlayerDialog.update(playerName, playerScore, remainingMoves, remainingTime, new ToolBoard(a1, x, y),
                    new ToolDice(a2));
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            // return false;
        }
        return true;
    }
}
