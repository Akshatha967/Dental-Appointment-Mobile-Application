package com.example.mad_project1;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class p_mainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText Email, Password;
    ProgressBar progressBar;
    DbManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_activity_main);

        findViewById(R.id.plogin).setOnClickListener(this);// siggn up btn
        findViewById(R.id.pSignUptextvw).setOnClickListener(this);// click here btn

        Email = (EditText) findViewById(R.id.pemail);
        Password = (EditText) findViewById(R.id.ppwd);
        progressBar = findViewById(R.id.progressbar);
    }

    private void LoginUser() {

        String email = Email.getText().toString().trim();// remove whitespaces from the string
        String password = Password.getText().toString().trim();

        if (email.isEmpty()) {
            Email.setError("Email is required.");
            Email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Email.setError("Please enter a valid email");
            Email.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            Password.setError("Password is required.");
            Password.requestFocus();
            return;
        }

        if (password.length() < 6) {
            Password.setError("Password minimum length should be 6 characters.");
            Password.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        db = new DbManager(this);
        Boolean res = db.signIndetp(email,password);
       if(res == true)
       {
           Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
           Bundle bd = new Bundle();
           bd.putString("pat_email",email);
           Intent it = new Intent(this,p_profile.class);
           it.putExtras(bd);
           startActivity(it);
       }
        else
       {
           Toast.makeText(this, "invalid ", Toast.LENGTH_SHORT).show();
       }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.pSignUptextvw:
                finish();
                startActivity(new Intent(this, p_Signup.class));

                break;

            case R.id.plogin:
                LoginUser();

                break;
        }
    }

}