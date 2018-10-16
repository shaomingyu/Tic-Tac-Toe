public class Model {
	
	private int turn;
	private char[][] board;

	public Model() {
		board = new char[3][3]; //initializing empty 3x3 board
		turn = 0; //initializing turn count
	}
	
	public void makeMove(int x, int y) {
		if(turn % 2 == 0) { //check's who's turn it is. X moves on even turns, O moves on odd turns.
			board[x][y] = 'X';
			turn++;
			if(winner(x, y)) {
				end(1); //sets winner to x if game is in winning state
			}
		}
		else {
			board[x][y] = 'O';
			turn++;
			if(winner(x, y)) {
				end(2); //sets winner to x if game is in a winning state
			}
		}
		if(turn >= 9) {
			end(0); //sets game to tie 
		}
	}

	public boolean winner(int x, int y) {
		int row = 0;
		int col = 0;
		int diagOne = 0;
		int diagTwo = 0;
		char player;
		if(turn % 2 == 0) {
			player = 'X';
		}
		else {
			player = 'O';
		}		
		for(int i = 0; i < 3; i++) {
			if(board[x][i] == player) {
				row++; //checks if the row you just moved in has 3 in a row
			}
			if(board[i][y] == player) {
				col++; //checks if the column you just moved in has 3 in a row
			}
			if(board[i][i] == player) {
				diagOne++; //checks diagonals
			} 
			if(board[2-i][i] == player) {
				diagTwo++;	
			}
		}
		if(col == 3 || row == 3 || diagOne == 3 || diagTwo == 3) {
			return true; //if three in a row, returns true
		}
		return false;
	}

	public void end(int x) { // 0 = Tie, 1 = X win, 2 = O win
		if(x == 0) {
			System.out.println("Tie");
			reset();
		}
		else if(x == 1) {
			System.out.println("X Wins");
			reset();
		}
		else {
			System.out.println("O Wins");
			reset();
		}
	}

	public void reset() {
		turn = 0; //sets model back to starting state
		board = new char[3][3]; //I think trash collector handles this
	}
}