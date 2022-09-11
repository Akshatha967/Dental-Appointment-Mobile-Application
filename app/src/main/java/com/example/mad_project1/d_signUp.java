package com.example.mad_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.Validator;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class d_signUp extends AppCompatActivity implements View.OnClickListener {

    EditText Email, Password, Name;
    ProgressBar progressBar;
    RadioGroup radioGroup;
    RadioButton radioButton;
    DbManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_activity_dsign_up);

        findViewById(R.id.dsignup).setOnClickListener(this);
        findViewById(R.id.dSignInTv).setOnClickListener(this);

        progressBar = findViewById(R.id.progressbar);
        Email = findViewById(R.id.demail);
        Password = findViewById(R.id.dpwd);
        Name = findViewById(R.id.dname);
        radioGroup = findViewById(R.id.radio_gender);
    }
    private void RegisterUser() {
        final String email = Email.getText().toString().trim();
        final String password = Password.getText().toString().trim();
        final String name = Name.getText().toString().trim();

        radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
        final String gender = (String) radioButton.getText();

        if (email.isEmpty()) {
            Email.setError("Email is required.");
            Email.requestFocus();
            return;
        }

        if (name.isEmpty()) {
            Name.setError("Username is required.");
            Name.requestFocus();
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


        db =new DbManager(this);
        String res = db.insertd(name,email,password,gender);
        Toast.makeText(d_signUp.this,res,Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.dsignup:

                RegisterUser ();
                break;

            case R.id.dSignInTv:

                finish();
                startActivity(new Intent(this, d_mainActivity.class));
                break;

        }
    }
}
