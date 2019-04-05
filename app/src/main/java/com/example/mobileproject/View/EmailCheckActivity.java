package com.example.mobileproject.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mobileproject.Controller.EmailCheckController;
import com.example.mobileproject.R;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailCheckActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_check);

        EmailCheckController controller = new EmailCheckController(this);
        controller.SetEmailCheck();

    }

    public void confirmationToast (String text){
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


