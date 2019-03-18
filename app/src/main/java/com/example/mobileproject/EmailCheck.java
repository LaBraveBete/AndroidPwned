package com.example.mobileproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailCheck extends AppCompatActivity {

    Pattern emailPattern = Pattern.compile("\\b(?!^.{256})[a-zA-Z0-9.-_+]+@[a-zA-Z0-9.-_]+\\.[a-zA-Z]+\\b");
    String email;
    private Button goButtonEmail;

    EditText email_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_check);


        email_input = (EditText) findViewById(R.id.email_input_field);
        goButtonEmail = (Button) findViewById(R.id.goButtonEmail);
        goButtonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email= email_input.getText().toString();
                if ()
                {
                    confirmationToast(email);

                }
                else
                {
                    //String nop = 'nop';
                    //confirmationToast();
                }





            }
        });
    }

    private void confirmationToast (String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }


}


