package view;
// the gui, sends user inputs to controller
import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View{
	private JFrame gui;
	private JButton[][] blocks;
	private JButton reset;
	private JTextArea playerTurn;
	private Controller controller;

	public void setController(Controller c) {
		controller = c;
	}

	public View() {
		this.gui = new JFrame("Tic Tac Toe");
		this.blocks = new JButton[3][3];
		this.reset = new JButton("Reset");
		this.playerTurn = new JTextArea();
		setup();
	}

	public void setup() { //creates the board, message bar, and reset button, ripped from TicTacToe
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

        reset.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent e) {
        		resetView();
        		controller.resetModel();
        	}
        });

        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                blocks[row][col] = new JButton();
                blocks[row][col].setPreferredSize(new Dimension(75,75));
                blocks[row][col].setText("");
                blocks[row][col].addActionListener(new ActionListener() {
                	public void actionPerformed (ActionEvent e) {
                		for(int r = 0; r < 3; r++) {
                			for(int c = 0; c < 3; c++) {
                				if(e.getSource() == blocks[r][c]) {
                					controller.sendMove(r, c);
                				}
                			}
                		}
                	}
               	});
                game.add(blocks[row][col]);
            }
        }

        gui.setVisible(true);
	}
	
	public void update(int row, int col, char player, String text) {
		blocks[row][col].setText(Character.toString(player));
		blocks[row][col].setEnabled(false); //blocks that have been played can't be clicked
		playerTurn.setText(text);
	}

	public String getButton(int x, int y) {
		return blocks[x][y].getText();
	}

	public void winState() { //freezes board so when the game is over, the player must hit the reset button
		for(int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				blocks[row][col].setEnabled(false);
			}
		}
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