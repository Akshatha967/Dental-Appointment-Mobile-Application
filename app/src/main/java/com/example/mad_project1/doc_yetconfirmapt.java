package com.example.mad_project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class doc_yetconfirmapt extends AppCompatActivity implements DoctorConfirmAdapter.OnPatClickListener {

    RecyclerView recyclerView;

    DbManager db;
    ArrayList<DataModel2> myData1 = new ArrayList<>();
//    MyaptAdapter adapter;
    DoctorConfirmAdapter dadapter;
    String demail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_activity_docyetconfirmapt);

        Bundle bd = getIntent().getExtras();
        demail = bd.getString("doc_email");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        // linear laoyut

        recyclerView.setLayoutManager(new LinearLayoutManager(this));// or define it in the xml file
        // attach recylr adpr to recyclr view



        db = new DbManager(this);

        Cursor c = db.dconfirmAppt(demail);// pending/ doc must confirm for pat all with  col=2 rejctd appt
        if (c.getCount() > 0) {


            while (c.moveToNext()) {
                // fetch from table pat email is displayed
                DataModel2 dm = new DataModel2(c.getString(0), c.getString(2), c.getString(3));// set name and specialzn
                myData1.add(dm); // asign to smthing

            }
            dadapter = new DoctorConfirmAdapter(myData1,this::onPatClick);
            recyclerView.setAdapter(dadapter);
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
            recyclerView.addItemDecoration(dividerItemDecoration);
        } else {
            Toast.makeText(this, "No appointments scheduled yet.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onPatClick(int position) {


        String pemail = myData1.get(position).getName();
//        Bundle bd = getIntent().getExtras();
//        String p_email = bd.getString("pat_email");
        Bundle bd1 = new Bundle();
        bd1.putString("pat_email",pemail);
        bd1.putString("doc_email",demail);

        Intent intent=new Intent(this,d_confirmOrReject.class);
        intent.putExtras(bd1);


        startActivity(intent);

       // Toast.makeText(this, "set date and time", Toast.LENGTH_SHORT).show();

    }
}