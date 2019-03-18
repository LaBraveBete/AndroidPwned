package com.example.mobileproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button ToEmailButton;
    private Button ToPasswordButton;
    private Button ToBiggestLeakButton;
    private Button ToExplanationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToEmailButton = (Button) findViewById(R.id.ToEmailButton);
        ToEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEmailActivity();
            }
        });

        ToPasswordButton = (Button) findViewById(R.id.ToPasswordButton);
        ToPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPasswordActivity();
            }
        });

        ToBiggestLeakButton = (Button) findViewById(R.id.ToBiggestLeakButton);
        ToBiggestLeakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBiggestLeakActivity();
            }
        });

        ToExplanationButton = (Button) findViewById(R.id.ToExplanationButton);
        ToExplanationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExplanationActivity();
            }
        });
    }

    public void openEmailActivity(){
        Intent intent = new Intent(this, EmailCheck.class);
        startActivity(intent);
    }

    public  void openPasswordActivity(){
        Intent intent = new Intent(this, PasswordCheck.class);
        startActivity(intent);
    }

    public  void openBiggestLeakActivity(){
        Intent intent = new Intent(this, BiggestLeak.class);
        startActivity(intent);
    }

    public  void openExplanationActivity(){
        Intent intent = new Intent(this, HowItWork.class);
        startActivity(intent);
    }
}
