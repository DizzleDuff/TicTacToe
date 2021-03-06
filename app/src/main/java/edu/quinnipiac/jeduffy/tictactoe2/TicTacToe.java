package edu.quinnipiac.jeduffy.tictactoe2;
/**
 * TicTacToe class implements the interface
 * @author eamon
 * @date 1/5/2017
 */
public class TicTacToe implements ITicTacToe {
		 
	   // The game board and the game status
	   private static final int ROWS = 3, COLS = 3; // number of rows and columns
	   private int[] board = new int[ROWS*COLS]; // game board in 2D array
	   
	  

     //clear board and set current player
	public TicTacToe(){
		
	}
	@Override
	public void clearBoard() {
		// TODO Auto-generated method stub
		for (int i = 0; i < ROWS*COLS; i++) board[i] = EMPTY; 
	}

	@Override
	public void setMove(int player, int location) {
		// TODO Auto-generated method stub
		board[location] = player;
	}

	@Override
	public int getComputerMove() {
		// TODO Auto-generated method stub
		int space = 0;
		if(board[0] == EMPTY)
			space = 0;
		else if(board[1] == EMPTY)
			space = 1;
		else if(board[2] == EMPTY)
			space = 2;
		else if(board[3] == EMPTY)
			space = 3;
		else if(board[4] == EMPTY)
			space = 4;
		else if(board[5] == EMPTY)
			space = 5;
		else if(board[6] == EMPTY)
			space = 6;
		else if(board[7] == EMPTY)
			space = 7;
		else if(board[8] == EMPTY)
			space = 8;
		return space;
		
}

	@Override
	public int checkForWinner() {
		// TODO Auto-generated method stub
		if (checkWinner(CROSS))
			return CROSS_WON;
		else if (checkWinner(NOUGHT))
			return NOUGHT_WON;
		else if (board[0] != EMPTY && board[1] != EMPTY && board[2] != EMPTY && board[3] != EMPTY && board[4] != EMPTY 
				&& board[5] != EMPTY && board[6] != EMPTY && board[7] != EMPTY && board[8] != EMPTY)
			return TIE;
		else
			return PLAYING;
	}
	
	private boolean checkWinner(int player){
		return (board[0] == player && board[1] == player && board[2] == player ||
				board[3] == player && board[4] == player && board[5] == player ||
				board[6] == player && board[7] == player && board[8] == player ||
				board[0] == player && board[3] == player && board[6] == player ||
				board[1] == player && board[4] == player && board[7] == player ||
				board[2] == player && board[5] == player && board[8] == player ||
				board[0] == player && board[4] == player && board[8] == player ||
				board[2] == player && board[4] == player && board[6] == player);
		
	}
	

	   //Print the game board
	   public  void printBoard() {
	      for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	            printCell(board[col + (row *3)]); // print each of the cells
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
	 

	    //Print a cell with either empty, nought, or cross
	   public void printCell(int content) {
	      switch (content) {
	         case EMPTY:  System.out.print("   ");
	         break;
	         case NOUGHT: System.out.print(" O ");
	         break;
	         case CROSS:  System.out.print(" X ");
	         break;
	      }
	   }
	public boolean isEmpty(int index) {
		// TODO Auto-generated method stub
		return board[index] == EMPTY;
	}

	public int getCell(int i){
	   	return board[i];
	}

}
