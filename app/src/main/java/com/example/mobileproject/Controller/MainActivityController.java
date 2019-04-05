package com.example.mobileproject.Controller;

import android.view.View;
import android.widget.Button;

import com.example.mobileproject.R;
import com.example.mobileproject.View.MainActivity;

public class MainActivityController {


    private Button ToEmailButton;
    private Button ToPasswordButton;
    private Button ToBiggestLeakButton;
    private Button ToExplanationButton;

    private MainActivity activity;


    public MainActivityController(MainActivity activity) {
        this.activity = activity;
    }


    public void setAllButon() {
        ToEmailButton = (Button) activity.findViewById(R.id.ToEmailButton);
        ToEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.openEmailActivity();
            }
        });

        ToPasswordButton = (Button) activity.findViewById(R.id.ToPasswordButton);
        ToPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.openPasswordActivity();
            }
        });

        ToBiggestLeakButton = (Button) activity.findViewById(R.id.ToBiggestLeakButton);
        ToBiggestLeakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.openBiggestLeakActivity();
            }
        });

        ToExplanationButton = (Button) activity.findViewById(R.id.ToExplanationButton);
        ToExplanationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.openExplanationActivity();
            }
        });
    }
}
