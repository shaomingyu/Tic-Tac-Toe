public class Model {
	
	private int turn;
	private char[][] board;

	public Model() {
		board = new char[3][3]; //initializing empty 3x3 board
		turn = 0; //initializing turn count
	}
	
	public void makeMove(int x, int y) {
		if(!valid(x, y)) {
			System.out.println("Invalid Move");
			return;
		}
		if(turn % 2 == 0) { //check's who's turn it is. X moves on even turns, O moves on odd turns.
			board[x][y] = 'X';
			turn++;
			if(winner(x, y)) {
				end(1);
			}
		}
		else {
			board[x][y] = 'O';
			turn++;
			if(winner(x, y)) {
				end(2);
			}
		}
		if(turn >= 9) {
			end(0);
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
				row++;
			}
			if(board[i][y] == player) {
				col++;
			}
			if(board[i][i] == player) {
				diagOne++;
			}
			if(board[2-i][i] == player) {
				diagTwo++;	
			}
		}
		if(col == 3 || row == 3 || diagOne == 3 || diagTwo == 3) {
			return true;
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

	public boolean valid(int x, int y) {
		if(board[x][y] == 'X' || board[x][y] == 'Y') {
			return false;
		}
		return true;
	}

	public void reset() {
		turn = 0;
		board = new char[3][3];
	}
}