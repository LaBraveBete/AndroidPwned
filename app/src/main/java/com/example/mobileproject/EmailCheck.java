package com.example.mobileproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailCheck extends AppCompatActivity {


    String email;
    public Button goButtonEmail;
    public TextView Email_response;

    EditText email_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_check);


        email_input =  findViewById(R.id.email_input_field);
        Email_response = findViewById(R.id.Email_response);
        goButtonEmail = findViewById(R.id.goButtonEmail);
        goButtonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email= email_input.getText().toString();
                if (isValidEmail(email))
                {
                    String confirmation = "Checking for : " + email;
                    confirmationToast(confirmation);


                }
                else
                {
                    email_input.setError("Please enter a valid email address ");
                }



            }
        });
    }

    private void confirmationToast (String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    public static boolean isValidEmail (String email)
    {
        String EMAIL_REGEX = "\\b(?!^.{256})[a-zA-Z0-9.-_+]+@[a-zA-Z0-9.-_]+\\.[a-zA-Z]+\\b";
        Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX,Pattern.CASE_INSENSITIVE);
        Matcher EMAIL_MATCHER = EMAIL_PATTERN.matcher(email);
        return EMAIL_MATCHER.find();
    }


}


