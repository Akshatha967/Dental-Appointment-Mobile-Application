package com.example.mad_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class p_profile extends AppCompatActivity implements View.OnClickListener {

    Button makeappt, p_myappt;
    DbManager db;
    TextView username;
    String pemail,pname;
    Button p_rejectedappt,p_pendingappt,p_profile;
    DataModel dmpat;

    //ArrayList<DataModel> myData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_activity_pprofile);

        makeappt = findViewById(R.id.makeappt);
        p_myappt =  findViewById(R.id.p_myAppt);
        username= findViewById(R.id.user_nametv);
        p_rejectedappt = findViewById(R.id.p_rejAppt);
        p_pendingappt = findViewById(R.id.p_pendingAppt);
        p_profile=findViewById(R.id.prof_btn);


        makeappt.setOnClickListener(this);
        p_myappt.setOnClickListener(this);
        p_rejectedappt.setOnClickListener(this);
        p_pendingappt.setOnClickListener(this);
        p_profile.setOnClickListener(this);

        Bundle bd = getIntent().getExtras();
        pemail =bd.getString("pat_email");

        db = new DbManager(this);
        Cursor c = db.pat_name(pemail);
        while (c.moveToNext()) {
            // fetch from table
            dmpat = new DataModel(c.getString(1), c.getString(0), c.getString(2));// set name and specialzn
            // asign to smthing

        }
        pname = dmpat.getName();
        username.setText(pname);



    }

    @Override
    public void onClick(View view) {

        if(view.equals(p_profile))
        {
            Bundle bd = new Bundle();
            bd.putString("pat_email",pemail);
            Intent intent = new Intent(this,p_profile1.class);
            intent.putExtras(bd);
            startActivity(intent);

        }


       if(view.equals(makeappt)) {

            Bundle bd1 = new Bundle();
            bd1.putString("pat_name",pname);
            bd1.putString("pat_email",pemail);

           Intent intent = new Intent(this, p_MakeAppt.class);
           intent.putExtras(bd1);
           startActivity(intent);

       }

            else if(view.equals(p_myappt)) {
          // finish();
//           Bundle bd = getIntent().getExtras();
//           String email =bd.getString("email");

//           db = new DbManager(this);
//           String name = db.pat_name(email);

           Bundle bd2 = new Bundle();
           bd2.putString("pat_name",pname);
           bd2.putString("pat_email",pemail);
           bd2.putString("pat_confirmed","p_confirmed");


           Intent intent2= new Intent(this, my_appointments.class);// RESET
           intent2.putExtras(bd2);
           startActivity(intent2);

       }

       else if(view.equals(p_rejectedappt)) {
           //finish();
//           Bundle bd = getIntent().getExtras();
//           String email =bd.getString("email");

//           db = new DbManager(this);
//           String name = db.pat_name(email);

           Bundle bd3 = new Bundle();
           bd3.putString("pat_name",pname);
           bd3.putString("pat_email",pemail);
           bd3.putString("pat_rejapt","aptRejected");

           Intent intent3= new Intent(this, RejectedAppt.class);// RESET
           intent3.putExtras(bd3);
           startActivity(intent3);

       }

       else if(view.equals(p_pendingappt)) {
          // finish();
//           Bundle bd = getIntent().getExtras();
//           String email =bd.getString("email");

//           db = new DbManager(this);
//           String name = db.pat_name(email);

           Bundle bd4 = new Bundle();
           bd4.putString("pat_name",pname);
           bd4.putString("pat_email",pemail);
           bd4.putString("pat_pendapt","aptPending");

           Intent intent4= new Intent(this, PendingAppointments.class); // RESET
           intent4.putExtras(bd4);
           startActivity(intent4);

       }


    }

    }
