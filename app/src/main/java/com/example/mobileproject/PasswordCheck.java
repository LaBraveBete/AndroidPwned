package com.example.mobileproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import java.nio.charset.StandardCharsets; //if StandardCharsets.UTF_8
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.io.UnsupportedEncodingException;


public class PasswordCheck extends AppCompatActivity {

    String password;
    String Head;
    String Tail;
    public Button goButtonPassword;

    EditText password_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_check);

        password_input =  findViewById(R.id.password_input_field);
        goButtonPassword = findViewById(R.id.goButtonPassword);
        goButtonPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                password= password_input.getText().toString();
                if (!password.isEmpty())
                {
                    String confirmation = "Checking for : " + password;
                    confirmationToast(confirmation);
                    Call_Password_API(password);

                }
                else
                {
                    password_input.setError("Please enter a password ");
                }





            }
        });
    }

    private void confirmationToast (String text){
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

    private  void Call_Password_API(String password)
    {
        String SHA1_password = encryptPasswordToSHA1(password);
        confirmationToast(SHA1_password);
        Head = SHA1_password.substring(0,5);
        Tail = SHA1_password.substring(5);


    }


}

