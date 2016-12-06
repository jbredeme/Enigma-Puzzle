package edu.jpb64nau.gameapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    // Button Array Declaration
    final Button button[] = new Button[36];

    // Game patterns
    int[] current_pattern;
    int[] pattern01 = {31, 32, 33, 34, 28, 22, 21, 20, 14, 8, 9, 10};
    int[] pattern02 = {0, 1, 7, 13, 19, 20, 21, 22, 16, 10, 9, 3};
    int[] pattern03 = {30, 24, 18, 19, 20, 26, 27, 28, 29, 23, 17, 11};
    int[] pattern04 = {20, 26, 32, 33, 34, 28, 29, 23, 17, 11, 10, 9, 8, 7, 13};
    int[] pattern05 = {11, 10, 16, 22, 21, 20, 14, 8, 7, 6, 12, 18, 24, 30, 31};

    // Current Game
    int num_correct = 0;
    int num_attempts = 0;
    int num_patterns_completed = 0;

    // Defaults
    final int delay = 200;                  // <= Tile Delay (ms)
    final int flash_delay = 600;            // <= Flash Delay (ms)
    final int activity_delay = 2000;        // <= Activity Delay (ms)
    final String color1 = "#FF9800";        // <= Flash Color
    final String color2 = "#757575";        // <= Static Color
    final String color3 = "#BF360C";        // <= Fail Color
    final Handler handler = new Handler();  // <= Event handler
    final int maxgames = 3;                 // <= Maximum Games
    final int max_attempts = 3;             // <= Maximum attempts allowed

    // Random Number Generator
    Random rand = new Random();

    // Set game status display
    TextView patternsComplete;
    TextView attemptsMade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Set Button Array
        button[0] = (Button) findViewById(R.id.btn0);
        button[1] = (Button) findViewById(R.id.btn1);
        button[2] = (Button) findViewById(R.id.btn2);
        button[3] = (Button) findViewById(R.id.btn3);
        button[4] = (Button) findViewById(R.id.btn4);
        button[5] = (Button) findViewById(R.id.btn5);
        button[6] = (Button) findViewById(R.id.btn6);
        button[7] = (Button) findViewById(R.id.btn7);
        button[8] = (Button) findViewById(R.id.btn8);
        button[9] = (Button) findViewById(R.id.btn9);
        button[10] = (Button) findViewById(R.id.btn10);
        button[11] = (Button) findViewById(R.id.btn11);
        button[12] = (Button) findViewById(R.id.btn12);
        button[13] = (Button) findViewById(R.id.btn13);
        button[14] = (Button) findViewById(R.id.btn14);
        button[15] = (Button) findViewById(R.id.btn15);
        button[16] = (Button) findViewById(R.id.btn16);
        button[17] = (Button) findViewById(R.id.btn17);
        button[18] = (Button) findViewById(R.id.btn18);
        button[19] = (Button) findViewById(R.id.btn19);
        button[20] = (Button) findViewById(R.id.btn20);
        button[21] = (Button) findViewById(R.id.btn21);
        button[22] = (Button) findViewById(R.id.btn22);
        button[23] = (Button) findViewById(R.id.btn23);
        button[24] = (Button) findViewById(R.id.btn24);
        button[25] = (Button) findViewById(R.id.btn25);
        button[26] = (Button) findViewById(R.id.btn26);
        button[27] = (Button) findViewById(R.id.btn27);
        button[28] = (Button) findViewById(R.id.btn28);
        button[29] = (Button) findViewById(R.id.btn29);
        button[30] = (Button) findViewById(R.id.btn30);
        button[31] = (Button) findViewById(R.id.btn31);
        button[32] = (Button) findViewById(R.id.btn32);
        button[33] = (Button) findViewById(R.id.btn33);
        button[34] = (Button) findViewById(R.id.btn34);
        button[35] = (Button) findViewById(R.id.btn35);

        // Add onclick listeners to buttons
        for(int i = 0; i < button.length; i++) {
            button[i].setOnClickListener(this);

        }

        // Set game status display
        patternsComplete = (TextView)findViewById(R.id.txtComplete);
        attemptsMade = (TextView)findViewById(R.id.textAttempts);

        patternsComplete.setText(num_patterns_completed + "/" + maxgames);
        attemptsMade.setText(num_attempts + "/" + max_attempts);

        // Initial Gameboard
        helpers.resetGame(button, "", color2);

        // Hide Buttons
        helpers.recursiveHideAll(button, 0, 0, color2);

        // Select a random new game
        randomPattern(5);

        // Start Game
        helpers.showTiles(handler, button, current_pattern, 0, delay, flash_delay, color1, color2);

    }


    private void randomPattern(int num) {
        // Select a game pattern at random
        int  n = rand.nextInt(num) + 1;

        switch(n) {
            case 1:
                current_pattern = pattern01;
                break;
            case 2:
                current_pattern = pattern02;
                break;
            case 3:
                current_pattern = pattern03;
                break;
            case 4:
                current_pattern = pattern04;
                break;
            case 5:
                current_pattern = pattern05;
                break;
        }

    }


    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.btn35:
                activates(35);
                break;

            case R.id.btn34:
                activates(34);
                break;

            case R.id.btn33:
                activates(33);
                break;

            case R.id.btn32:
                activates(32);
                break;

            case R.id.btn31:
                activates(31);
                break;

            case R.id.btn30:
                activates(30);
                break;

            case R.id.btn29:
                activates(29);
                break;

            case R.id.btn28:
                activates(28);
                break;

            case R.id.btn27:
                activates(27);
                break;

            case R.id.btn26:
                activates(26);
                break;

            case R.id.btn25:
                activates(25);
                break;

            case R.id.btn24:
                activates(24);
                break;

            case R.id.btn23:
                activates(23);
                break;

            case R.id.btn22:
                activates(22);
                break;

            case R.id.btn21:
                activates(21);
                break;

            case R.id.btn20:
                activates(20);
                break;

            case R.id.btn19:
                activates(19);
                break;

            case R.id.btn18:
                activates(18);
                break;

            case R.id.btn17:
                activates(17);
                break;

            case R.id.btn16:
                activates(16);
                break;

            case R.id.btn15:
                activates(15);
                break;

            case R.id.btn14:
                activates(14);
                break;

            case R.id.btn13:
                activates(13);
                break;

            case R.id.btn12:
                activates(12);
                break;

            case R.id.btn11:
                activates(11);
                break;

            case R.id.btn10:
                activates(10);
                break;

            case R.id.btn9:
                activates(9);
                break;

            case R.id.btn8:
                activates(8);
                break;

            case R.id.btn7:
                activates(7);
                break;

            case R.id.btn6:
                activates(6);
                break;

            case R.id.btn5:
                activates(5);
                break;

            case R.id.btn4:
                activates(4);
                break;

            case R.id.btn3:
                activates(3);
                break;

            case R.id.btn2:
                activates(2);
                break;

            case R.id.btn1:
                activates(1);
                break;

            case R.id.btn0:
                activates(0);
                break;

        }
    }

    public void gameCompleted() {
        Toast.makeText(getApplicationContext(), "Game Complete!", Toast.LENGTH_SHORT).show();
    }


    public void gameFailed(){
        Toast.makeText(getApplicationContext(), "Game Over! You're the worst Player Ever!", Toast.LENGTH_SHORT).show();
    }


    public void patternCompleted() {
        Toast.makeText(getApplicationContext(), "Pattern Complete!", Toast.LENGTH_SHORT).show();

    }


    public void activates(int index) {
        if(button[index].getText().toString().isEmpty()) {
            // Increment Attempt Counter
            num_attempts = num_attempts + 1;

            // Update Attempts status
            attemptsMade.setText(num_attempts + "/" + max_attempts);

            if(num_attempts >= max_attempts) {
                // Display mean message
                gameFailed();

                // Reset attempt counter
                num_attempts = 0;

                // Goto menu screen
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(GameActivity.this, MenuActivity.class);
                        intent.putExtra("username", getIntent().getStringExtra("username"));
                        startActivity(intent);
                        finish();
                        System.exit(0);

                    }
                }, activity_delay);

            } else {
                // Display message wrong button has been clicked
                Toast.makeText(getApplicationContext(), "Incorrect! Attempt #" + num_attempts, Toast.LENGTH_SHORT).show();

                // Set bad color indicator
                button[index].setBackgroundColor(Color.parseColor(color3));

                // Select a new game at random
                randomPattern(5);

                // Reset num_correct
                num_correct = 0;

                // Rest board, display new pattern
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Hide Buttons
                        helpers.resetGame(button, "", color2);
                        helpers.showTiles(handler, button, current_pattern, 0, delay, flash_delay, color1, color2);

                    }
                }, delay);

            }

        } else if(button[index].getText().toString().equalsIgnoreCase("on")) {
            // Correct button has been clicked
            button[index].setTextColor(Color.parseColor(color1));
            button[index].setBackgroundColor(Color.parseColor(color1));
            button[index].setText("off");

            // Increment Correct Counter
            num_correct = num_correct + 1;

            // Check game status
            if(num_correct >= current_pattern.length) {

                // Pattern Completed!
                patternCompleted();

                // Increment number of patterns completed
                num_patterns_completed = num_patterns_completed + 1;

                // Display Completed status
                patternsComplete.setText(num_patterns_completed + "/" + maxgames);

                // Game Completed!
                if(num_patterns_completed == maxgames) {
                    gameCompleted();

                    // Goto menu screen
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(GameActivity.this, MenuActivity.class);
                            intent.putExtra("username", getIntent().getStringExtra("username"));
                            startActivity(intent);
                            finish();
                            System.exit(0);

                        }
                    }, activity_delay);

                } else {
                    // Select a new game at random
                    randomPattern(5);

                    // Reset num_correct
                    num_correct = 0;

                    // Rest board, display new pattern
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Hide Buttons
                            helpers.resetGame(button, "", color2);
                            helpers.showTiles(handler, button, current_pattern, 0, delay, flash_delay, color1, color2);

                        }
                    }, delay);

                }

            }

        }
    }


}
