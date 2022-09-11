package com.example.mad_project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class p_MakeAppt extends AppCompatActivity implements RecyclerAdapter.OndocClickListener {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    DbManager db;
    ArrayList<DataModel> myData = new ArrayList<>();

    //ArrayList<String> name, specialization, location;

    String pemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_activity_make_appt);

        Bundle bd = getIntent().getExtras();
        pemail = bd.getString("pat_email");
        db = new DbManager(this);
        //pat_id = db.get_pat_id(email);



        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        // linear laoyut

        recyclerView.setLayoutManager(new LinearLayoutManager(this));// or define it in the xml file
        // attach recylr adpr to recyclr view


//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = new DbManager(this);

        Cursor c = db.getMakeAppt();

        while (c.moveToNext()) {
            // fetch from table
            DataModel dm = new DataModel(c.getString(0), c.getString(1), c.getString(2));// set name and specialzn
            myData.add(dm); // asign to smthing

        }
        recyclerAdapter = new RecyclerAdapter(myData,this::onDocClick);
        recyclerView.setAdapter(recyclerAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onDocClick(int position) {
        String demail = myData.get(position).getEmail();
//        Bundle bd = getIntent().getExtras();
//        String p_email = bd.getString("pat_email");
        Bundle bd1 = new Bundle();
        bd1.putString("pat_email",pemail);
        bd1.putString("doc_email",demail);

        Intent intent=new Intent(this,p_Datepicker.class);
        intent.putExtras(bd1);


        startActivity(intent);

        //Toast.makeText(this, "set date and time", Toast.LENGTH_SHORT).show();

    }
}





//        else
//        {
//            Toast.makeText(this, "No doc available yet", Toast.LENGTH_SHORT).show();
//        }

//
//    private void displaydata()
//    {
//        Cursor cursor = db.getMakeAppt1();
//        if(cursor.getCount()==0)
//        {
//            Toast.makeText(p_MakeAppt.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        else
//        {
//            while(cursor.moveToNext())
//            {
//                name.add(cursor.getString(0));
//                specialization.add(cursor.getString(1));
//                location.add(cursor.getString(2));
//            }
//        }
