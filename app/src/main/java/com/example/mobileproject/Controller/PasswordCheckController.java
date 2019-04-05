package com.example.mobileproject.Controller;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mobileproject.R;
import com.example.mobileproject.View.PasswordCheckActivity;

public class PasswordCheckController {


    private PasswordCheckActivity activity;


    public PasswordCheckController(PasswordCheckActivity activity) {
        this.activity = activity;
    }


    public String password;

    private Button goButtonPassword;
    private TextView Password_response;

    private EditText password_input;


    public void setPasswordCheck() {
        password_input = activity.findViewById(R.id.password_input_field);
        goButtonPassword = activity.findViewById(R.id.goButtonPassword);
        Password_response = activity.findViewById(R.id.Password_response);
        goButtonPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                password = password_input.getText().toString();
                if (!password.isEmpty()) {
                    String confirmation = "Checking for : " + password;
                    activity.confirmationToast(confirmation);
                    activity.Call_Password_API(password);
                } else {
                    password_input.setError("Please enter a password ");
                }
            }
        });
    }

    public void passwordFound(String Occurrence){
        String fucked = "You are fucked!! Change your password immediately! Your password appears "+ Occurrence + " times in the database." ;
        Password_response.setText(fucked);
    }

    public void ConnectionFailur(){
        String stringFail = "That didn't work!";
        Password_response.setText(stringFail);
    }

    public void passwordStrong(){
        String safe = "Your Password is safe and Strong";
        Password_response.setText(safe);
    }

    public void passwordNotStrong(){
        String safe = "Your password is safe but not strong; consider adding some uppercase letters / special character";
        Password_response.setText(safe);
    }

    public void setSHA1String(String SHA1){
        String stringSHA1 = "SHA1 is : " + SHA1;
        Password_response.setText(stringSHA1);
    }
}
