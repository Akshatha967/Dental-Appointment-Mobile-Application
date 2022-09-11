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

public class my_appointments extends AppCompatActivity {
    RecyclerView recyclerView;

    DbManager db;
    ArrayList<DataModel2> myData1 = new ArrayList<>();
    //ArrayList<DataModel> myData = new ArrayList<>();

    //RecyclerView recyclerView;
    //ArrayList<String> name, date, time;
//    DBHelper DB;
    MyaptAdapter adapter;
    //int
    String pat_id;
    String pemail;
    String demail, dname;
    String docconfirmed,docyetconfirm;
    String patmyrej,patmyRemaining,patconfirmed;
    Cursor c;

    Cursor cd1,cp1,cp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appointments);



        Bundle bd = getIntent().getExtras();
        pemail = bd.getString("pat_email");
//
//        patmyrej=bd.getString(" pat_rejapt");//2
//        patmyRemaining=bd.getString("pat_pendapt");//0
//        patconfirmed=bd.getString("pat_confirmed");//1
//
//
//
//        demail = bd.getString("doc_email");
//
//        docconfirmed = bd.getString("dconfirmed");// 1
//        docyetconfirm=bd.getString("doc_yetconfirm");//0
//



        db = new DbManager(this);


        //pat_id = db.get_pat_id(email);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        // linear laoyut

        recyclerView.setLayoutManager(new LinearLayoutManager(this));// or define it in the xml file
        // attach recylr adpr to recyclr view


        //db = new DbManager(this);
//        name = new ArrayList<>();
//        date = new ArrayList<>();
//        time = new ArrayList<>();
//        recyclerView = findViewById(R.id.recyclerview);
//        adapter = new MyaptAdapter(this, name, date, time);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        displaydata();
        //!(pemail.isEmpty()) &&

////        if ( !(pemail.isEmpty()) && (patmyrej.equals("aptRejected")))// true if string is empty
////        {
//            db = new DbManager(this);
//
//            c = db.myrejectedAppt(pemail);// for pat all with  col=0 rejected
//            if (c.getCount() > 0) {
//
//
//                while (c.moveToNext()) {
//                    // fetch from table
//                    DataModel2 dm = new DataModel2(c.getString(1), c.getString(2), c.getString(3));// set name and specialzn
//                    myData1.add(dm); // asign to smthing
//
//                }
//                adapter = new MyaptAdapter(myData1);
//                recyclerView.setAdapter(adapter);
//                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//                recyclerView.addItemDecoration(dividerItemDecoration);
//            } else {
//                Toast.makeText(this, "No appointments scheduled yet.", Toast.LENGTH_LONG).show();
//            }
//        }

//        if ( !(pemail.isEmpty()) && (patmyRemaining.equals("aptPending")))// || (docyetconfirm=="dyetconfirm")) ;functoinality
//
////        {
//            db = new DbManager(this);
//
//            c = db.confirmAppt(pemail);// for pat all with  col=2 rejctd appt
//            if (c.getCount() > 0) {
//
//
//                while (c.moveToNext()) {
//                    // fetch from table
//                    DataModel2 dm = new DataModel2(c.getString(1), c.getString(2), c.getString(3));// set name and specialzn
//                    myData1.add(dm); // asign to smthing
//
//                }
//                adapter = new MyaptAdapter(myData1);
//                recyclerView.setAdapter(adapter);
//                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//                recyclerView.addItemDecoration(dividerItemDecoration);
//            } else {
//                Toast.makeText(this, "No appointments scheduled yet.", Toast.LENGTH_LONG).show();
//            }





//        }

//        else if (!(pemail.isEmpty()) && (patconfirmed.equals("p_confirmed")))// true if string is empty
//        {
            db = new DbManager(this);

            c = db.myconfirmedAppt(pemail);// for pat all with  col=1 confirmed appt
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
                Toast.makeText(this, "No appointments scheduled yet.", Toast.LENGTH_LONG).show();
            }






















//        }
//        else if(!(demail.isEmpty()) &&(docconfirmed.equals("dconfirmed")))
//        {
//            db = new DbManager(this);
//
//            c = db.confirmAppt(pemail);
//            if (c.getCount() > 0) {
//
//
//                while (c.moveToNext()) {
//                    // fetch from table patname date and time contact button??
//                    DataModel2 dm = new DataModel2(c.getString(0), c.getString(2), c.getString(3));// set name and specialzn
//                    myData1.add(dm); // asign to smthing
//
//                }
//                adapter = new MyaptAdapter(myData1);
//                recyclerView.setAdapter(adapter);
//                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//                recyclerView.addItemDecoration(dividerItemDecoration);
//            } else {
//                Toast.makeText(this, "No appointments scheduled yet.", Toast.LENGTH_LONG).show();
//            }
//
//        }




    }
}




//
//    @Override
//    public void onDocaptClick(int position) {
//        String email = myData1.get(position).getEmail();
//        Bundle bd1 = new Bundle();
//        bd1.putInt("pat_id",pat_id);
//        bd1.putString("doc_email",email);
//
//        Intent intent=new Intent(this,p_Datepicker.class);
//        intent.putExtras(bd1);
//
//
//        startActivity(intent);
//
//        Toast.makeText(this, "set date and time", Toast.LENGTH_SHORT).show();
//
//    }




//    }
//
//    private void displaydata()
//    {
//        Cursor cursor = db.myAppt();
//        if(cursor.getCount()==0)
//        {
//            Toast.makeText(my_appointments.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        else
//        {
//            while(cursor.moveToNext())
//            {
//                name.add(cursor.getString(0));
//                date.add(cursor.getString(1));
//                time.add(cursor.getString(2));
//            }
//        }
//    }
//}