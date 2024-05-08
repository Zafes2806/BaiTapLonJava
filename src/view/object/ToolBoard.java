package view.object;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JPanel;

public class ToolBoard extends JPanel {
	private Tool[][] tools;
	public Tool[][] getTools() {
		return tools;
	}

	private final int boardSize = 9;
	private final int boardWidth = 502;
	private final int boardHeight = 502;
	private int choiceX = boardSize / 2;
	public int getChoiceX() {
		return choiceX;
	}

	private int choiceY = boardSize / 2;

	public int getChoiceY() {
		return choiceY;
	}
	public ToolBoard() {
		setLayout(new GridLayout(boardSize, boardSize));
		setPreferredSize(new Dimension(boardHeight, boardWidth));
		tools = new Tool[boardSize][boardSize];
		Random random = new Random();
		int preIDTool = -1;
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				int curIDTool = 0;
				do {
					curIDTool = random.nextInt(3);
				} while (curIDTool == preIDTool);
				preIDTool = curIDTool;
				if (curIDTool == 0)
					tools[i][j] = new Rock();
				else if (curIDTool == 1)
					tools[i][j] = new Scissors();
				else
					tools[i][j] = new Paper();
				this.add(tools[i][j]);
			}
		}
		tools[choiceX][choiceY].setBackground(Color.green);
		tools[choiceX][choiceY].setOpaque(true);
	}
	public ToolBoard(int a[][], int x, int y) {
		setLayout(new GridLayout(boardSize, boardSize));
		setPreferredSize(new Dimension(boardHeight, boardWidth));
		tools = new Tool[boardSize][boardSize];
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if (a[i][j] == 0)
					tools[i][j] = new Rock();
				else if (a[i][j] == 1)
					tools[i][j] = new Scissors();
				else
					tools[i][j] = new Paper();
				this.add(tools[i][j]);
			}
		}
		choiceX = x;
		choiceY = y;
		tools[choiceX][choiceY].setBackground(Color.green);
		tools[choiceX][choiceY].setOpaque(true);
	}

	public void moveUp() {
		if (!isValidMove(-1, 0))
			return;
		tools[choiceX][choiceY].setBackground(Color.white);
		tools[choiceX][choiceY].setOpaque(false);
		moveChoice(-1, 0);
		tools[choiceX][choiceY].setBackground(Color.green);
		tools[choiceX][choiceY].setOpaque(true);
	}

	public void moveDown() {
		if (!isValidMove(1, 0))
			return;
		tools[choiceX][choiceY].setBackground(Color.white);
		tools[choiceX][choiceY].setOpaque(false);
		moveChoice(1, 0);
		tools[choiceX][choiceY].setBackground(Color.green);
		tools[choiceX][choiceY].setOpaque(true);
	}

	public void moveLeft() {
		if (!isValidMove(0, -1))
			return;
		tools[choiceX][choiceY].setBackground(Color.white);
		tools[choiceX][choiceY].setOpaque(false);
		moveChoice(0, -1);
		tools[choiceX][choiceY].setBackground(Color.green);
		tools[choiceX][choiceY].setOpaque(true);
	}

	public void moveRight() {
		if (!isValidMove(0, 1))
			return;
		tools[choiceX][choiceY].setBackground(Color.white);
		tools[choiceX][choiceY].setOpaque(false);

		moveChoice(0, 1);
		tools[choiceX][choiceY].setBackground(Color.green);
		tools[choiceX][choiceY].setOpaque(true);
	}

	public Tool getChoice() {
		return tools[choiceX][choiceY];
	}

	public Dimension getPreferredDimension() {
		return new Dimension(boardWidth, boardHeight);
	}

	public int getBoardSize() {
		return boardSize;
	}

	public boolean isValidMove(int deltaX, int deltaY) {
		if (choiceX + deltaX < 0 || choiceX + deltaX >= boardSize)
			return false;
		if (choiceY + deltaY < 0 || choiceY + deltaY >= boardSize)
			return false;
		return true;
	}

	private void moveChoice(int deltaX, int deltaY) {
		choiceX += deltaX;
		choiceY += deltaY;
	}
}
