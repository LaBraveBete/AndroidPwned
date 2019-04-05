package com.example.mobileproject.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.mobileproject.Controller.MainActivityController;
import com.example.mobileproject.R;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityController controller = new MainActivityController(this);
        controller.setAllButon();
    }

    public void openEmailActivity(){
        Intent intent = new Intent(this, EmailCheckActivity.class);
        startActivity(intent);
    }

    public  void openPasswordActivity(){
        Intent intent = new Intent(this, PasswordCheckActivity.class);
        startActivity(intent);
    }

    public  void openBiggestLeakActivity(){
        Intent intent = new Intent(this, BiggestLeakActivity.class);
        startActivity(intent);
    }

    public  void openExplanationActivity(){
        Intent intent = new Intent(this, HowItWorkActivity.class);
        startActivity(intent);
    }
}
