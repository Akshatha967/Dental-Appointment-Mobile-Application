package com.example.mad_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.hardware.camera2.DngCreator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class d_confirmOrReject extends AppCompatActivity implements View.OnClickListener {

    TextView close;

Button accept,reject;
DbManager db;
Bundle bd;
String demail,pemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_activity_dconfirm_or_reject);

        accept = findViewById(R.id.accept);
        reject=findViewById(R.id.reject);
        close = findViewById(R.id.close);

        close.setOnClickListener(this);
        accept.setOnClickListener(this);
        reject.setOnClickListener(this);

        bd=getIntent().getExtras();
        demail=bd.getString("doc_email");
        pemail = bd.getString("pat_email");



    }

    @Override
    public void onClick(View view) {

      //  String pemail = bd.getString("pat_email");
      // demail = bd.getString("doc_email");
       String res=null;
        db = new DbManager(this);


           if(view.equals(close))
           {
               Bundle bd = new Bundle();
               bd.putString("doc_email",demail);
               Intent intent = new Intent(this,p_profile.class);
               intent.putExtras(bd);
               startActivity(intent);

           }

        if(view.equals(accept))

        {
           db = new DbManager(this);
           res = db.updateaptAccept(pemail,demail);//flag to 3

        }

        if(view.equals(reject))
        {
            //change db value flag to 2

            db = new DbManager(this);
            res = db.updateaptReject(pemail,demail);
        }

        Toast.makeText(this,res, Toast.LENGTH_SHORT).show();

    }
}