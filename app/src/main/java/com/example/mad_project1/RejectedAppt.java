package com.example.mad_project1;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RejectedAppt extends AppCompatActivity {

    RecyclerView recyclerView;

    DbManager db;

    MyaptAdapter adapter;
    ArrayList<DataModel2> myData1 = new ArrayList<>();
    //ArrayList<DataModel> myData = new ArrayList<>();
    Cursor c;

    String pemail;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appointments);


        Bundle bd = getIntent().getExtras();
        pemail = bd.getString("pat_email");


        db = new DbManager(this);



        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));// or define it in the xml file


        db = new DbManager(this);

            c = db.myrejectedAppt(pemail);// for pat all with  col=0 rejected
            if (c.getCount() > 0) {


                while (c.moveToNext()) {
                    // fetch from table
                    DataModel2 dm = new DataModel2(c.getString(1), c.getString(2), c.getString(3));// set name and specialzn
                   myData1.add(dm); // asign to smthing

                }
               adapter = new MyaptAdapter(myData1);
                recyclerView.setAdapter(adapter);
                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
               recyclerView.addItemDecoration(dividerItemDecoration);
           } else {
                Toast.makeText(this, "No appointments Rejected.", Toast.LENGTH_LONG).show();
            }

    }



    }
