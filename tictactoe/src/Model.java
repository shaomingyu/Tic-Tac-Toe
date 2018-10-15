public class Model {
	
	private int turn;
	private char[][] board;

	public Model() {
		board = new char[3][3]; //initializing empty 3x3 board
		turn = 0; //initializing turn count
	}
	
	public void makeMove(int x, int y) {
		if(turn >= 9) { //check's if game is over
			System.out.println("Tie");
			resetModel();
			return;
		}
		if(!validMove(x, y)) {
			System.out.println("Invalid Move");
			return;
		}
		if(turn % 2 = 0) { //check's who's turn it is. X moves on even turns, O moves on odd turns.
			board[x][y] = 'X';
			turn++;
		}
		else {
			board[x][y] = 'O';
			turn++;
		}
	}

	public int winner(int x, int y) {
		int row = 0;
		int col = 0;
		int diagOne = 0;
		int diagTwo = 0;
		char player;
		if(turn % 2 = 0) {
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

	public int valid(int x, int y) {
		if(board[x][y]) {
			return false;
		}
		return true;
	}
}