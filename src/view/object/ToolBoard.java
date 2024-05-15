package view.object;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JPanel;

public class ToolBoard extends JPanel {
	private Tool[][] tools;
	private final int boardSize = 9;
	public static final int WIDTH = 502;
	public static final int HEIGHT = 502;
	private int choiceX = boardSize / 2;
	private int choiceY = boardSize / 2;
	private int preChoiceX = boardSize / 2;
	private int preChoiceY = boardSize / 2;
	private int secondPreChoiceX = boardSize / 2;
	private int secondPreChoiceY = boardSize / 2;

	public ToolBoard() {
		setLayout(new GridLayout(boardSize, boardSize));
		setPreferredSize(new Dimension(HEIGHT, WIDTH));
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

	public ToolBoard(int a[][], int choiceX, int choiceY, int preChoiceX, int preChoiceY, int secondPreChoiceX, int secondPreChoiceY) {
		setLayout(new GridLayout(boardSize, boardSize));
		setPreferredSize(new Dimension(HEIGHT, WIDTH));
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
		this.choiceX = choiceX;
		this.choiceY = choiceY;
		this.preChoiceX = preChoiceX;
		this.preChoiceY = preChoiceY;
		this.secondPreChoiceX = secondPreChoiceX;
		this.secondPreChoiceY = secondPreChoiceY;
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

	public void updatePreMove() {
		secondPreChoiceX = preChoiceX;
		secondPreChoiceY = preChoiceY;
		preChoiceX = choiceX;
		preChoiceY = choiceY;
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
		return new Dimension(WIDTH, HEIGHT);
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

	public boolean isMoveBackToSecondPrevious() {
		return (secondPreChoiceX == choiceX && secondPreChoiceY == choiceY);
	}

	public int getChoiceX() {
		return choiceX;
	}

	public Tool[][] getTools() {
		return tools;
	}

	public int getChoiceY() {
		return choiceY;
	}

	private void moveChoice(int deltaX, int deltaY) {
		choiceX += deltaX;
		choiceY += deltaY;
	}

	public int getPreChoiceX() {
		return preChoiceX;
	}

	public int getPreChoiceY() {
		return preChoiceY;
	}

	public void setPreChoiceY(int preChoiceY) {
		this.preChoiceY = preChoiceY;
	}

	public void setPreChoiceX(int preChoiceX) {
		this.preChoiceX = preChoiceX;
	}

	public int getSecondPreChoiceX() {
		return secondPreChoiceX;
	}

	public void setSecondPreChoiceX(int secondPreChoiceX) {
		this.secondPreChoiceX = secondPreChoiceX;
	}

	public int getSecondPreChoiceY() {
		return secondPreChoiceY;
	}

	public void setSecondPreChoiceY(int secondPreChoiceY) {
		this.secondPreChoiceY = secondPreChoiceY;
	}
}
