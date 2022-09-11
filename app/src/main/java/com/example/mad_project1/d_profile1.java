package com.example.mad_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class d_profile1 extends AppCompatActivity implements  View.OnClickListener{


    TextView name,email,phone,gender,spec,location,close;
    Button submit;

    // ArrayList<p_DataModelProfile> myData2 = new ArrayList<>();
    d_DataModelProfile dm;
    DbManager db;
    String demail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_activity_dprofile1);

        name = findViewById(R.id.dname);
        email=findViewById(R.id.demail);
        phone = findViewById(R.id.dphone);
        gender = findViewById(R.id.dgender);
        spec = findViewById(R.id.dspec);
        location=findViewById(R.id.dloc);
        close = findViewById(R.id.dclose);
        submit=findViewById(R.id.dsubmit);

        close.setOnClickListener(this);
        submit.setOnClickListener(this);

        Bundle bd = getIntent().getExtras();
        demail = bd.getString("doc_email");

        db = new DbManager(this);
        Cursor c =db.getDoc(demail);
        while(c.moveToNext())
        {
            dm = new d_DataModelProfile(c.getString(0), c.getString(1), c.getString(2),c.getLong(3),c.getString(4),c.getString(5));// set name and specialzn
            // asign to smthing

        }
        name.setText(dm.getName());
        email.setText(dm.getEmail());
        phone.setText(String.valueOf(dm.getPhone()));
        gender.setText(dm.getGender());
        spec.setText(dm.getSpecialization());
        location.setText(dm.getLocation());




    }


    @Override
    public void onClick(View view) {
        if(view.equals(close))
        {
            Bundle bd = new Bundle();
            bd.putString("doc_email",demail);
            Intent intent = new Intent(this,d_profile.class);
            intent.putExtras(bd);
            startActivity(intent);

        }
        else if(view.equals(submit))
        {
            String name1,email1,gender1,location1;
            String phone1,spec1;
            name1 =name.getText().toString();
            email1=email.getText().toString();
            phone1 = phone.getText().toString();
            gender1=gender.getText().toString();
            spec1 =spec.getText().toString();
            location1=location.getText().toString();

            long phone2;

            phone2=Long.parseLong(phone1);
           // age2=Integer.parseInt(age1);

            db = new DbManager(this);
            String res = db.updataedoc(name1,spec1,email1,phone2,gender1,location1);
            Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
        }


    }
}