package com.example.mad_project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyaptAdapter extends RecyclerView.Adapter<MyaptAdapter.MyViewHolder> {

    ArrayList<DataModel2> mydata1;
//    private MyaptAdapter.OndocaptClickListener ondocaptClickListener;

    public MyaptAdapter(ArrayList<DataModel2> mydata1)//, OndocaptClickListener ondocaptClickListener)
    {
        this.mydata1 = mydata1;
       // this.ondocaptClickListener = ondocaptClickListener;
    }
//    public MyaptAdapter(Context context, ArrayList name_id, ArrayList date_id, ArrayList time_id) {
//        this.context = context;
//        this.name_id = name_id;
//        this.date_id = date_id;
//        this.time_id = time_id;
//    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowitem2,parent,false);
        return new MyViewHolder(v);//,ondocaptClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.name_id.setText(String.valueOf(name_id.get(position)));
//        holder.date_id.setText(String.valueOf(date_id.get(position)));
//        holder.time_id.setText(String.valueOf(time_id.get(position)));
//    }
        holder.name_id.setText(mydata1.get(position).getName());
        holder.date_id.setText(mydata1.get(position).getDate());
        holder.time_id.setText(mydata1.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return mydata1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_id, date_id, time_id;
     //   OndocaptClickListener ondocaptClickListener;

        public MyViewHolder(@NonNull View itemView){//,  OndocaptClickListener ondocaptClickListener) {
            super(itemView);
//            name_id = itemView.findViewById(R.id.textname);
//            date_id = itemView.findViewById(R.id.textemail);
//            time_id = itemView.findViewById(R.id.textage);

            name_id = itemView.findViewById(R.id.textname);
           date_id= itemView.findViewById(R.id.textdate);
            time_id = itemView.findViewById(R.id.texttime);//location and email of doc must b added
            //this.ondocaptClickListener=ondocaptClickListener;
            //itemView.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View view) {
//            ondocaptClickListener.onDocaptClick(getAdapterPosition());
//
//        }
    }

//    public interface OndocaptClickListener {
//        void onDocaptClick(int position);
//    }
}
