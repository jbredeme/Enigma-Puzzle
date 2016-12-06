package edu.jpb64nau.gameapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        String username = getIntent().getStringExtra("username");
        TextView textViewUsernameTitle = (TextView)findViewById(R.id.welcomeLabel);

        // Check if username is empty
        if(!(username.equals(""))) {
            textViewUsernameTitle.setText("Welcome " + helpers.toTitleCase(username) + "!");

        } else{
            textViewUsernameTitle.setText("Welcome!");

        }

        play_buttonOnClick();
        settings_buttonOnClick();
        exit_buttonOnClick();
    }

    public void play_buttonOnClick() {
        final Button generic = (Button) findViewById(R.id.playButton);
        generic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MenuActivity.this, GameActivity.class);
                intent.putExtra("username", getIntent().getStringExtra("username"));
                startActivity(intent);
                finish();
                System.exit(0);
                /*
                startActivity(new Intent(MenuActivity.this, GameActivity.class));
                finish();
                System.exit(0);*/
            }
        });
    }

    public void settings_buttonOnClick() {
        final Button generic = (Button) findViewById(R.id.settingsButton);
        generic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MenuActivity.this, SettingsActivity.class);
                intent.putExtra("username", getIntent().getStringExtra("username"));
                startActivity(intent);
                finish();
                System.exit(0);

                /*startActivity(new Intent(MenuActivity.this, SettingsActivity.class));
                finish();
                System.exit(0);*/
            }
        });
    }

    public void exit_buttonOnClick() {
        final Button generic = (Button) findViewById(R.id.exitButton);
        generic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

}
