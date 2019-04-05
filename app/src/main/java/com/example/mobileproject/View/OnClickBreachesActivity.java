package com.example.mobileproject.View;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.mobileproject.Controller.OnClickBreachesController;
import com.example.mobileproject.R;

public class OnClickBreachesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click_breaches);

        OnClickBreachesController controller = new OnClickBreachesController(this);
        controller.getIncomingIntent();
    }




}
