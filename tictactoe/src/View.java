package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View{
	private JFrame gui;
	private JButton[][] blocks;
	private JButton reset;
	private JTextArea playerTurn;

	public View() {
		this.gui = new JFrame("Tic Tac Toe");
		this.blocks = new JButton[3][3];
		this.reset = new JButton("Reset");
		this.playerTurn = new JTextArea();
		initialize();
	}

	public void initialize() { //creates the board, message bar, and reset button
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(new Dimension(500, 350));
        gui.setResizable(true);

        JPanel gamePanel = new JPanel(new FlowLayout());
        JPanel game = new JPanel(new GridLayout(3,3));
        gamePanel.add(game, BorderLayout.CENTER);

        JPanel options = new JPanel(new FlowLayout());
        options.add(reset);
        JPanel messages = new JPanel(new FlowLayout());

        messages.setBackground(Color.white);
        gui.add(gamePanel, BorderLayout.NORTH);
        gui.add(options, BorderLayout.CENTER);
        gui.add(messages, BorderLayout.SOUTH);

        messages.add(playerTurn);
        playerTurn.setText("Player 1 to play 'X'");

        for(int row = 0; row<3; row++) {
            for(int column = 0; column<3 ;column++) {
                blocks[row][column] = new JButton();
                blocks[row][column].setPreferredSize(new Dimension(75,75));
                blocks[row][column].setText("");
                game.add(blocks[row][column]);
        	}
        }

        gui.setVisible(true);
	}
	public void update(int row, int col, char player, String text) {
		blocks[row][col].setText(Character.toString(player));
		blocks[row][col].setEnabled(false); //blocks that have been played can't be clicked
		playerTurn.setText(text);
	}
	public void resetView() { //resets to default view state
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				blocks[row][col].setText("");
				blocks[row][col].setEnabled(true);
			}
		}
		playerTurn.setText("Player 1 to play 'X'");
	}
}