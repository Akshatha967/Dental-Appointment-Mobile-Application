package com.example.mad_project1;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button pat,doc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pat=  findViewById(R.id.Patientbtn);
        doc = findViewById(R.id.Doctorbtn);

        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Doctor", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(MainActivity.this, d_mainActivity.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //   finish();
                startActivity(intent2);
            }
        });

        pat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Patient", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, p_mainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // finish();
                startActivity(intent);
            }
        });





    }

    public void openDatePicker(View view) {
    }

//    @Override
//    public void onClick(View view) {
//        if(view.equals(doc))
//        {
//            Toast.makeText(MainActivity.this, "Doctor", Toast.LENGTH_SHORT).show();
//            Intent intent2 = new Intent(MainActivity.this, d_mainActivity.class);
//            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            //   finish();
//            startActivity(intent2);
//        }
//
//        else if(view.equals(pat))
//        {
//            Toast.makeText(MainActivity.this, "Patient", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(MainActivity.this, p_mainActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            // finish();
//            startActivity(intent);
//
//        }
//    }
}