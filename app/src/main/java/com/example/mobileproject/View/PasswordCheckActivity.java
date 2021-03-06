package com.example.mobileproject.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import java.nio.charset.StandardCharsets; //if StandardCharsets.UTF_8
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mobileproject.Controller.PasswordCheckController;
import com.example.mobileproject.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PasswordCheckActivity extends AppCompatActivity {


    String Head;
    String Tail;

    PasswordCheckController controller = new PasswordCheckController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_check);


        controller.setPasswordCheck();

    }

    public void confirmationToast (String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    private static String encryptPasswordToSHA1(String password)
    {
        String sha1 = "";
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8")); //StandardCharsets.UTF_8 if api lv 19 current lv 15
            sha1 = byteToHex(crypt.digest()).toUpperCase();
        }
        catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch(UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return sha1;
    }

    private static String byteToHex(final byte[] hash)
    {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    public void Call_Password_API(String password)
    {
        String SHA1_password = encryptPasswordToSHA1(password);
        controller.setSHA1String(SHA1_password);
        Head = SHA1_password.substring(0,5);
        Tail = SHA1_password.substring(5);


        RequestQueue PASSWORD_API= Volley.newRequestQueue(this);
        String URL_Password ="https://api.pwnedpasswords.com/range/"+Head;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_Password,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        boolean isPresent = response.contains(Tail);
                        if(isPresent)
                        {
                          String Occurrence = Password_Occurrence(response);
                            controller.passwordFound(Occurrence);

                        }
                        else
                        {
                            Password_quality();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                controller.ConnectionFailur();
            }
        });
        PASSWORD_API.add(stringRequest);

    }

    private String Password_Occurrence(String response)
    {
        int position1 =response.indexOf(Tail) + 36; //35 character in tail + : before number of occurrence
        String temp = response.substring(position1);
        int position2 =temp.indexOf("\n") + position1;
        return response.substring(position1,position2);

    }

    private void Password_quality()
    {
        final Pattern PASSWORD_PATTERN =
                Pattern.compile("^" +
                        "(?=.*[0-9])" +         //at least 1 digit
                        "(?=.*[a-z])" +         //at least 1 lower case letter
                        "(?=.*[A-Z])" +         //at least 1 upper case letter
                        "(?=.*[a-zA-Z])" +      //any letter
                        "(?=.*[@#$%^&+=À-ÿ])" +    //at least 1 special character
                        //"(?=\\S+$)" +           //no white spaces
                        ".{4,}" +               //at least 4 characters
                        "$",Pattern.CASE_INSENSITIVE);
        Matcher PASSWORD_MATCHER = PASSWORD_PATTERN.matcher(controller.password);
        if(PASSWORD_MATCHER.find())
        {
            controller.passwordStrong();
        }
        else
        {
            controller.passwordNotStrong();
        }

    }


}

