/**
 * TicTacToe class implements the interface
 * @author relkharboutly
 * @date 1/5/2017
 */
public class TicTacToe implements ITicTacToe {
		 
	   // The game board and the game status
	   private static final int ROWS = 3, COLS = 3; // number of rows and columns
	   private int[] board = new int[ROWS*COLS]; // game board in 2D array
	  
	/**
	 * clear board and set current player   
	 */
	public TicTacToe(){
		
	}
	@Override
	public void clearBoard() {
		// TODO Auto-generated method stub
		for (int i = 0; i < ROWS*COLS; i++) {
			board[i] = EMPTY;
		}
	}

	@Override
	public void setMove(int player, int location) {
		// TODO Auto-generated method stub
		board[location] = player;
	}

	@Override
	public int getComputerMove() {
		// TODO Auto-generated method stub
		if(board[0] == 0)
			return 0;
		else if (board[1] == 0)
			return 1;
		else if (board[2] == 0)
			return 2;
		else if (board[3] == 0)
			return 3;
		else if (board[4] == 0)
			return 4;
		else if (board[5] == 0)
			return 5;
		else if (board[6] == 0)
			return 6;
		else if (board[7] == 0)
			return 7;
		else 
			return 8;
	}
	@Override
	public int checkForWinner() {
		if (checkWinner(CROSS))
			return CROSS_WON;
		else if (checkWinner(NOUGHT)) 
			return NOUGHT_WON;
		else if (board[0] != EMPTY && board[1] != EMPTY && board[2] != EMPTY && board[3] != EMPTY && board[4] != EMPTY && board[5] != EMPTY &&
				board[6] != EMPTY && board[7] != EMPTY && board[8] != EMPTY)
			return TIE;
		else 
			return PLAYING;
			
		
	}
	
	public boolean isEmpty(int index) {
		return board[index] == EMPTY;
	}
	  /**
	   *  Print the game board 
	   */
	   public  void printBoard() {
	      for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	            printCell(board[col+row*3]); // print each of the cells
	            if (col != COLS - 1) {
	               System.out.print("|");   // print vertical partition
	            }
	         }
	         System.out.println();
	         if (row != ROWS - 1) {
	            System.out.println("-----------"); // print horizontal partition
	         }
	      }
	      System.out.println();
	   }
	 
	   /**
	    * Print a cell with the specified "content" 
	    * @param content either CROSS, NOUGHT or EMPTY
	    */
	   public  void printCell(int content) {
	      switch (content) {
	         case EMPTY:  System.out.print("   "); break;
	         case NOUGHT: System.out.print(" O "); break;
	         case CROSS:  System.out.print(" X "); break;
	      }
	   }

	public boolean checkWinner(int player) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				if (board[0] == player && board[1] == player && board[2] == player ||
					board[3] == player && board[4] == player && board[5] == player ||
					board[6] == player && board[7] == player && board[8] == player ||
					board[0] == player && board[3] == player && board[6] == player ||
					board[1] == player && board[4] == player && board[7] == player ||
					board[2] == player && board[5] == player && board[8] == player ||
					board[0] == player && board[4] == player && board[8] == player ||
					board[2] == player && board[4] == player && board[6] == player) {
				return true;	
				} else
					return false;
	}

}
