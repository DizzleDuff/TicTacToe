package edu.quinnipiac.jeduffy.tictactoe2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGame(View view){
        EditText nameView = (EditText) findViewById(R.id.name);
        String nameText = nameView.getText().toString();
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(GameActivity.EXTRA_MESSAGE, nameText);
        startActivity(intent);
    }
}