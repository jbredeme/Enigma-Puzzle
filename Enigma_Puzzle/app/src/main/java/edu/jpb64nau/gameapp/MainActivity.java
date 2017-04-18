package edu.jpb64nau.gameapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_buttonOnClick();
        game_buttonOnClick();
        exit_buttonOnClick();
    }

    public void login_buttonOnClick() {
        final Button generic = (Button) findViewById(R.id.loginButton);
        generic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userinput = (EditText)findViewById(R.id.userNameTextInput);
                String username = userinput.getText().toString();
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
                finish();
                System.exit(0);
            }
        });
    }

    public void game_buttonOnClick() {
        final Button generic = (Button) findViewById(R.id.quickplayButton);
        generic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("username", "anonymous");
                startActivity(intent);
                finish();
                System.exit(0);
                /*
                startActivity(new Intent(MainActivity.this, GameActivity.class));
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
