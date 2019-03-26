package com.example.mobileproject;

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

import java.util.HashMap;
import java.util.Map;
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
                    requestWithSomeHttpHeaders(email);


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


    public void requestWithSomeHttpHeaders(String email)
    {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://haveibeenpwned.com/api/v2/breachedaccount/" + email;
        StringRequest getRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Email_response.setText(response);
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ERROR","error => "+error.toString());
                        Email_response.setText(error.toString());
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("User-Agent", "School-project-Android-app");

                return params;
            }
        };
        queue.add(getRequest);

    }
}


