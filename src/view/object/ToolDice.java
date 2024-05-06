package view.object;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class ToolDice extends JPanel {
	private Tool[] tools = new Tool[6];
	private final int toolDiceWidth = 168;
	private final int toolDiceHeight = 224;

	public ToolDice() {
		setLayout(null);
		setPreferredSize(new Dimension(toolDiceWidth, toolDiceHeight));
		setSize(new Dimension(toolDiceWidth, toolDiceHeight));

		tools[0] = new Rock();
		tools[0].setBounds(56, 0, 50, 50);
		add(tools[0]);

		tools[1] = new Scissors();
		tools[1].setBounds(56, 56, 50, 50);
		tools[1].setBackground(Color.red);
		tools[1].setOpaque(true);
		add(tools[1]);

		tools[2] = new Paper();
		tools[2].setBounds(56, 112, 50, 50);
		add(tools[2]);

		tools[3] = new Rock();
		tools[3].setBounds(56, 168, 50, 50);
		add(tools[3]);

		tools[4] = new Scissors();
		tools[4].setBounds(0, 56, 54, 54);
		add(tools[4]);

		tools[5] = new Paper();
		tools[5].setBounds(112, 56, 54, 54);
		add(tools[5]);
	}

	public Tool getChoice() {
		return tools[1];
	}

	public void moveDown() {
		tools[1].setBackground(null);
		tools[1].setOpaque(false);
		Tool tool = tools[0];
		Rectangle r0 = tools[0].getBounds();
		Rectangle r1 = tools[1].getBounds();
		Rectangle r2 = tools[2].getBounds();
		Rectangle r3 = tools[3].getBounds();

		changeTool(0, tools[1], r0);
		changeTool(1, tools[2], r1);
		changeTool(2, tools[3], r2);
		changeTool(3, tool, r3);

		tools[1].setBackground(Color.red);
		tools[1].setOpaque(true);

		tool = null;
		r0 = r1 = r2 = r3 = null;
	}

	public void moveUp() {
		tools[1].setBackground(null);
		tools[1].setOpaque(false);

		Rectangle r0 = tools[0].getBounds();
		Rectangle r1 = tools[1].getBounds();
		Rectangle r2 = tools[2].getBounds();
		Rectangle r3 = tools[3].getBounds();

		Tool tool = tools[3];
		changeTool(3, tools[2], r3);
		changeTool(2, tools[1], r2);
		changeTool(1, tools[0], r1);
		changeTool(0, tool, r0);

		tools[1].setBackground(Color.red);
		tools[1].setOpaque(true);

		tool = null;
		r0 = r1 = r2 = r3 = null;
	}

	public void moveLeft() {
		tools[1].setBackground(null);
		tools[1].setOpaque(false);

		Rectangle r1 = tools[1].getBounds();
		Rectangle r3 = tools[3].getBounds();
		Rectangle r4 = tools[4].getBounds();
		Rectangle r5 = tools[5].getBounds();

		Tool tool = tools[1];
		changeTool(1, tools[4], r1);
		changeTool(4, tools[3], r4);
		changeTool(3, tools[5], r3);
		changeTool(5, tool, r5);

		tools[1].setBackground(Color.red);
		tools[1].setOpaque(true);

		tool = null;
		r1 = r3 = r4 = r5 = null;
	}

	public void moveRight() {
		tools[1].setBackground(null);
		tools[1].setOpaque(false);

		Rectangle r1 = tools[1].getBounds();
		Rectangle r3 = tools[3].getBounds();
		Rectangle r4 = tools[4].getBounds();
		Rectangle r5 = tools[5].getBounds();

		Tool tool = tools[1];
		changeTool(1, tools[5], r1);
		changeTool(5, tools[3], r5);
		changeTool(3, tools[4], r3);
		changeTool(4, tool, r4);

		tools[1].setBackground(Color.red);
		tools[1].setOpaque(true);

		tool = null;
		r1 = r3 = r4 = r5 = null;
	}

	public void setTools(Tool[] tools) {
		this.tools = tools;
	}

	public int getToolDiceWidth() {
		return toolDiceWidth;
	}

	public int getToolDiceHeight() {
		return toolDiceHeight;
	}

	private void changeTool(int x, Tool tool, Rectangle rectangle) {
		tools[x] = tool;
		tools[x].setBounds(rectangle);
	}
}
