package com.example.mobileproject.Controller;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mobileproject.R;
import com.example.mobileproject.View.EmailCheckActivity;

import java.util.HashMap;
import java.util.Map;

public class EmailCheckController {


    private EmailCheckActivity activity;


    public EmailCheckController(EmailCheckActivity activity) {
        this.activity = activity;
    }

    private String email;
    private Button goButtonEmail;
    private TextView Email_response;

    private String EMAIL_ACCOUNT_API_URL = "https://haveibeenpwned.com/api/v2/breachedaccount/";
    private String PASTED_ACCOUNT_API_URL = "https://haveibeenpwned.com/api/v2/pasteaccount/";

    private boolean PwnedEmail;

    private EditText email_input;

    public void SetEmailCheck() {
        email_input = activity.findViewById(R.id.email_input_field);
        Email_response = activity.findViewById(R.id.Email_response);
        goButtonEmail = activity.findViewById(R.id.goButtonEmail);
        goButtonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = email_input.getText().toString();
                if (activity.isValidEmail(email)) {
                    String confirmation = "Checking for : " + email;
                    activity.confirmationToast(confirmation);
                    requestWithSomeHttpHeaders(email, EMAIL_ACCOUNT_API_URL);
                    if (PwnedEmail) {
                        requestWithSomeHttpHeaders(email, PASTED_ACCOUNT_API_URL);
                    }


                } else {
                    email_input.setError("Please enter a valid email address ");
                }


            }
        });
    }

    private void requestWithSomeHttpHeaders(String email, String API_URL)
    {
        RequestQueue queue = Volley.newRequestQueue(activity);
        String url = API_URL + email;
        StringRequest getRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        Email_response.setText(response);
                        Log.d("Response", response);
                        PwnedEmail = true;
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        if(error.networkResponse.statusCode != 404 )
                        {
                            Log.d("ERROR", "error => " + error.toString());
                            Email_response.setText(error.networkResponse.statusCode);
                        }
                        else
                        {
                            String Fine_email = "You'r fine. We have not found your email. ";
                            Email_response.setText(Fine_email);
                            PwnedEmail = false;
                        }
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("User-Agent", "School-project-Android-app");

                return params;
            }
        };
        queue.add(getRequest);

    }
}
