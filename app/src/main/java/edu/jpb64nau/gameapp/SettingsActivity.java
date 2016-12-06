package edu.jpb64nau.gameapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        newbie_buttonOnClick();
        talented_buttonOnClick();
        expert_buttonOnClick();
    }

    public void newbie_buttonOnClick() {
        final Button generic = (Button) findViewById(R.id.newbieButton);
        generic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, MenuActivity.class);
                intent.putExtra("difficulty", "newbie");
                intent.putExtra("username", getIntent().getStringExtra("username"));
                startActivity(intent);
                finish();
                System.exit(0);;
            }
        });
    }

    public void talented_buttonOnClick() {
        final Button generic = (Button) findViewById(R.id.talentedButton);
        generic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, MenuActivity.class);
                intent.putExtra("difficulty", "talented");
                intent.putExtra("username", getIntent().getStringExtra("username"));
                startActivity(intent);
                finish();
                System.exit(0);;
            }
        });
    }

    public void expert_buttonOnClick() {
        final Button generic = (Button) findViewById(R.id.expertButton);
        generic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, MenuActivity.class);
                intent.putExtra("difficulty", "expert");
                intent.putExtra("username", getIntent().getStringExtra("username"));
                startActivity(intent);
                finish();
                System.exit(0);;
            }
        });
    }
}
