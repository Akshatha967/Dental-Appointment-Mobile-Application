package com.example.mad_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class d_profile extends AppCompatActivity implements View.OnClickListener {
    Button confirmappt, d_myappt,d_profile;
    DbManager db;
    DataModel dmdoc;
    String dname,demail;
    TextView username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_activity_dprofile);

        d_profile=findViewById(R.id.dprof_btn);
        confirmappt = findViewById(R.id.dconfirmappt);
        d_myappt =  findViewById(R.id.d_myAppt);
        username = findViewById(R.id.doc_nametv);
        confirmappt.setOnClickListener(this);
        d_myappt.setOnClickListener(this);
        d_profile.setOnClickListener(this);

        Bundle bd = getIntent().getExtras();
        demail =bd.getString("doc_email");

        db = new DbManager(this);
        Cursor c = db.doc_name(demail);
        while (c.moveToNext()) {
            // fetch from table
            dmdoc = new DataModel(c.getString(0), c.getString(2), c.getString(5));// set name and specialzn
            // asign to smthing

        }
        dname = dmdoc.getName();
        username.setText(dname);
    }

    @Override
    public void onClick(View view) {

        if(view.equals(d_profile))
        {
            Bundle bd = new Bundle();
            bd.putString("doc_email",demail);
            Intent intent = new Intent(this,d_profile1.class);
            intent.putExtras(bd);
            startActivity(intent);

        }


        if(view.equals(confirmappt)) {
            //Bundle bd = getIntent().getExtras();
            //demail =bd.getString("doc_email");

//            db = new DbManager(this);
//            Cursor c = db.doc_name(demail);
//
//
//            while (c.moveToNext()) {
//                // fetch from table
//                dmdoc = new DataModel(c.getString(1), c.getString(0), c.getString(2));// set name and specialzn
//                // asign to smthing
//
//            }
//            dname = dmdoc.getName();
//            //username.setText(pemail);
//            Bundle bd1 = new Bundle();
//            bd1.putString("doc_name",dname);
//            bd1.putString("doc_email",demail);
//            bd1.putString("doc_yetconfirm","dyetconfirm");
//
//            Intent intent = new Intent(this, d_confirm.class);//Reset
//            intent.putExtras(bd1);
//            startActivity(intent);
//            Toast.makeText(this, "confirm appt", Toast.LENGTH_SHORT).show();

            Bundle bd2 = new Bundle();
            bd2.putString("doc_name",dname);
            bd2.putString("doc_email",demail);
            bd2.putString("doc_confirmed","dconfirmed");

            Intent intent2 = new Intent(this, doc_yetconfirmapt.class);//Reset
            intent2.putExtras(bd2);
            startActivity(intent2);

        }

        else if(view.equals(d_myappt)) {
            //finish();

            Bundle bd2 = new Bundle();
            bd2.putString("doc_name",dname);
            bd2.putString("doc_email",demail);
            bd2.putString("doc_confirmed","dconfirmed");

            Intent intent2 = new Intent(this, doc_myappt.class);//Reset
            intent2.putExtras(bd2);
            startActivity(intent2);


        }




    }
}