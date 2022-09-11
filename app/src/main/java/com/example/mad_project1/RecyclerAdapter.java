package com.example.mad_project1;
// items inside recycler view

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder >{

    ArrayList<DataModel> mydata;
    private OndocClickListener ondocClickListener;

    public RecyclerAdapter(ArrayList<DataModel> mydata,OndocClickListener ondocClickListener) {
        this.mydata = mydata;
        this.ondocClickListener=ondocClickListener;
    }

    // constructor
//    private Context context;
//    private ArrayList name1_id;
//    private ArrayList specialization_id;
//    private ArrayList location_id;
//    public RecyclerAdapter(Context context, ArrayList name_id, ArrayList specialization_id, ArrayList location_id) {
////        this.context = context;
////        this.name1_id = name_id;
////        this.specialization_id = specialization_id;
////        this.location_id =location_id;
//        THIS
//    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//convert xml file to view
//        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
//        View view=layoutInflater.inflate(R.layout.rowwrite3,parent,false);// instance of view holde
//        ViewHolder v=new ViewHolder(view);
//        return v;
        // vh resposible for managing rows and keeps rack of all the c=views available inside the vieew we have created

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowwrite3,parent,false);
        return new ViewHolder(v,ondocClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // puts data inside the view
        //holder.largetv.se
        //holder.smalltv.setText(mydata.get(position).specializaion);
       holder.name1_id.setText(mydata.get(position).getName());
        holder.specialization_id.setText(mydata.get(position).getSpecializaion());
        holder.location_id.setText(mydata.get(position).getEmail());
    }

    @Override
    public int getItemCount() {// no. of rows in recyclew view
        return mydata.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        //ImageView imageView;
        TextView name1_id, specialization_id, location_id;
        OndocClickListener ondocClickListener;
        public ViewHolder(@NonNull View itemView,OndocClickListener ondocClickListener) {
            super(itemView); // itemvw is the row we created
//            imageView = itemView.findViewById(R.id.imageView1);
//            largetv=itemView.findViewById((R.id.largetextView));
//            smalltv=itemView.findViewById((R.id.smalltextView));
//
//            itemView.setOnClickListener(this);// to make appt for this doc
            name1_id = itemView.findViewById(R.id.textname1);
            specialization_id = itemView.findViewById(R.id.textspecialization);
            location_id = itemView.findViewById(R.id.textlocation);
            this.ondocClickListener=ondocClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            ondocClickListener.onDocClick(getAdapterPosition());

        }
    }
//        @Override
//        public void onClick(View view) {
//            // i need pat -id and doc_id;
////            Bundle bd = new Bundle();
////            bd.putString("doc_id"+doc_id);
////            bd.putString("pat_id"+pat_id);
////            Intent intent = new Intent(view.getContext(),p_newappt.class);
//            Toast.makeText(view.getContext(), "setTimeAndDate", Toast.LENGTH_SHORT).show();
//
//
//        }
        

    public interface OndocClickListener {
        void onDocClick(int position);
    }
}

