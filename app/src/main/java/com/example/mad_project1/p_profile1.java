package com.example.mad_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class p_profile1 extends AppCompatActivity implements View.OnClickListener {

    TextView name,email,phone,gender,age,location,close;
    Button submit;

   // ArrayList<p_DataModelProfile> myData2 = new ArrayList<>();
   p_DataModelProfile dm;
    DbManager db;
    String pemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_activity_pprofile1);

        name = findViewById(R.id.pname);
        email=findViewById(R.id.pemail);
        phone = findViewById(R.id.pphone);
        gender = findViewById(R.id.pgender);
        age = findViewById(R.id.page);
        location=findViewById(R.id.plocation);
        close = findViewById(R.id.close);
        submit=findViewById(R.id.submmit);

        close.setOnClickListener(this);
        submit.setOnClickListener(this);

        Bundle bd = getIntent().getExtras();
        pemail = bd.getString("pat_email");

        db = new DbManager(this);
        Cursor c =db.getPat(pemail);
        while(c.moveToNext())
        {
           dm = new p_DataModelProfile(c.getString(1), c.getString(0), c.getLong(2),c.getString(3),c.getInt(4),c.getString(5));// set name and specialzn
             // asign to smthing

        }
        name.setText(dm.getName());
        email.setText(dm.getEmail());
        phone.setText(String.valueOf(dm.getPhone()));
        gender.setText(dm.getGender());
        age.setText(String.valueOf(dm.getAge()));
        location.setText(dm.getLocation());




        }


    @Override
    public void onClick(View view) {
        if(view.equals(close))
        {
            Bundle bd = new Bundle();
            bd.putString("pat_email",pemail);
            Intent intent = new Intent(this,p_profile.class);
            intent.putExtras(bd);
            startActivity(intent);

    }
        else if(view.equals(submit))
        {
            String name1,email1,gender1,location1;
            String phone1,age1;
            name1 =name.getText().toString();
            email1=email.getText().toString();
            phone1 = phone.getText().toString();
            gender1=gender.getText().toString();
            age1 =age.getText().toString();
          location1=location.getText().toString();

          long phone2;
            int age2;
          phone2=Long.parseLong(phone1);
          age2=Integer.parseInt(age1);

            db = new DbManager(this);
            String res = db.updatepat(name1,email1,phone2,gender1,age2,location1);
            Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
        }


}
}