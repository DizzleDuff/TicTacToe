package edu.quinnipiac.jeduffy.tictactoe2;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {

    public static final String EXTRA_MESSAGE = "message";
    TicTacToe TTTboard;
    int currentCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //intent stuff
        Intent intent = getIntent();
        String nameText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView nameView = (TextView)findViewById(R.id.name);
        nameView.setText(nameText);

        //initialize tic tac toe board
        TTTboard = new TicTacToe();

        //starts the game with all buttons with the square image
        for (int i=0; i<9; i++){
            ((ImageButton)findViewById(R.id.button0 + i)).setBackgroundResource(R.mipmap.square);
        }
    }

    //when button is clicked
    public void buttonClicked(View view){
        //set the move
        TTTboard.setMove(ITicTacToe.CROSS, view.getId() - R.id.button0);
        //make button not clickable
        view.setEnabled(false);
        makeBoard();
        //check if win
        currentCase = TTTboard.checkForWinner();
        if (currentCase == ITicTacToe.NOUGHT_WON){
            Toast.makeText(this, "You lose!", Toast.LENGTH_LONG).show();
            enableFalse();
        } else if (currentCase == ITicTacToe.CROSS_WON){
            Toast.makeText(this, "You win!", Toast.LENGTH_LONG).show();
            enableFalse();
        } else if (currentCase == ITicTacToe.TIE){
            Toast.makeText(this, "It's a tie!", Toast.LENGTH_LONG).show();
        } else {
            doAITurn();
        }
    }

    //get the ai turn and display on buttons
    public void doAITurn(){
        TTTboard.setMove(ITicTacToe.NOUGHT, TTTboard.getComputerMove());
        makeBoard();

        currentCase = TTTboard.checkForWinner();
      if (currentCase == ITicTacToe.NOUGHT_WON){
          Toast.makeText(this, "You lose!", Toast.LENGTH_LONG).show();
          enableFalse();
      } else if (currentCase == ITicTacToe.CROSS_WON){
          Toast.makeText(this, "You win!", Toast.LENGTH_LONG).show();
          enableFalse();
      }
      else if (currentCase == ITicTacToe.TIE){
          Toast.makeText(this, "It's a tie!", Toast.LENGTH_LONG).show();
      } else {
          Toast.makeText(this, "Your turn!", Toast.LENGTH_SHORT).show();
      }
    }

    public void checkButton(int i, int id){
        switch (TTTboard.getCell(i)) {
            case ITicTacToe.CROSS:
                ((ImageButton)findViewById(id)).setBackgroundResource(R.mipmap.x);
                ((ImageButton)findViewById(id)).setEnabled(false);
                break;
            case ITicTacToe.NOUGHT:
                ((ImageButton)findViewById(id)).setBackgroundResource(R.mipmap.o);
                ((ImageButton)findViewById(id)).setEnabled(false);
                break;
            case ITicTacToe.EMPTY:
                ((ImageButton)findViewById(id)).setBackgroundResource(R.mipmap.square);
                ((ImageButton)findViewById(id)).setEnabled(true);
                break;
        }
    }

    public void makeBoard(){
        checkButton(0, R.id.button0);
        checkButton(1, R.id.button1);
        checkButton(2, R.id.button2);
        checkButton(3, R.id.button3);
        checkButton(4, R.id.button4);
        checkButton(5, R.id.button5);
        checkButton(6, R.id.button6);
        checkButton(7, R.id.button7);
        checkButton(8, R.id.button8);
    }

    // enables all buttons to false
    public void enableFalse(){
        for (int i = 0; i < 9; i++){
            ((ImageButton)findViewById(R.id.button0 + i)).setEnabled(false);
         }
    }

    // enables all buttons to true
    public void enableTrue(){
        for (int i = 0; i < 9; i++){
            ((ImageButton)findViewById(R.id.button0 + i)).setEnabled(true);
        }
    }

    // method to reset game when button is clicked
    public void resetClicked(View view){
        for (int i = 0; i < 9; i++){
            TTTboard.clearBoard();
            currentCase = ITicTacToe.PLAYING;
            enableTrue();
            ((ImageButton)findViewById(R.id.button0 + i)).setBackgroundResource(R.mipmap.square);
            makeBoard();
        }
    }
}
