package com.example.assignment_2_project;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private Button buttonAnswer1;
    private Button buttonAnswer2;
    private Button buttonAnswer3;
    private Button buttonNextRound;
    private final String[] correctGuesses = {"Bill Cosby", "Mike Tyson"};
    // 2D array of incorrect guesses for each round
    private final String[][] incorrectGuesses = {
            {"Bill Nye", "Bill Gates", "Bill Clinton"},
            {"Bill Murray", "Billie Eilish", "Billie Joe Armstrong"},
            {"Billie Holiday", "Billy Joel", "Billy Ray Cyrus"},
            {"Billy Idol", "Billy Bob Thornton", "Billy Crystal"},
            {"Billy Dee Williams", "Billy Zane", "Billy Corgan"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        buttonAnswer1 = findViewById(R.id.button_Answer1);
        buttonAnswer2 = findViewById(R.id.button_Answer2);
        buttonAnswer3 = findViewById(R.id.button_Answer3);
        buttonNextRound = findViewById(R.id.button_Answer4);
        Button buttonNext = findViewById(R.id.button_Next);

        setupButtons(0);

        int[] round = {0}; // Initialize with an array containing a single element
        buttonNext.setOnClickListener(view -> {
            Log.d("GameActivity", "Next button clicked");
            round[0]++;
            setupButtons(round[0]);
        });

    }


    private void setupButtons(int round) {
        buttonAnswer1.setText(correctGuesses[round]);
        buttonAnswer2.setText(incorrectGuesses[round][0]);
        buttonAnswer3.setText(incorrectGuesses[round][1]);
        buttonNextRound.setText(incorrectGuesses[round][2]);

        buttonAnswer1.setOnClickListener(view -> {
            buttonAnswer1.setText(R.string.correct);
            buttonAnswer2.setText("");
            buttonAnswer3.setText("");
            buttonNextRound.setText("");
            buttonAnswer1.setBackgroundColor(getResources().getColor(R.color.green, null));
            buttonAnswer2.setBackgroundColor(getResources().getColor(R.color.red, null));
            buttonAnswer3.setBackgroundColor(getResources().getColor(R.color.red, null));
            buttonNextRound.setBackgroundColor(getResources().getColor(R.color.red, null));
        });

    }

}
