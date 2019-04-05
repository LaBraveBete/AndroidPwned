package com.example.mobileproject.View;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mobileproject.Controller.BiggestLeakController;
import com.example.mobileproject.R;


public class BiggestLeakActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biggest_leak);

        BiggestLeakController controller = new BiggestLeakController(this);

        controller.CallAPIAndGenerateView();

    }
}



