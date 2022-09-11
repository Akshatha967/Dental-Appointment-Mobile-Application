package com.example.mad_project1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DoctorConfirmAdapter extends RecyclerView.Adapter<DoctorConfirmAdapter.ViewHolder> {
    ArrayList<DataModel2> mydata1;
   private OnPatClickListener onpatClickListener;
    public DoctorConfirmAdapter(ArrayList<DataModel2> mydata1,OnPatClickListener onPatClickListener) {

        this.mydata1 = mydata1;
        this.onpatClickListener=onPatClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowitem2,parent,false);
        return new ViewHolder(v,onpatClickListener);//,ondocaptClickListener);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name_id.setText(mydata1.get(position).getName());
        holder.date_id.setText(mydata1.get(position).getDate());
        holder.time_id.setText(mydata1.get(position).getTime());


    }

    @Override
    public int getItemCount() {
        return mydata1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements   View.OnClickListener {

        TextView name_id, date_id, time_id;
        OnPatClickListener onPatClickListener;

        public ViewHolder(@NonNull View itemView, OnPatClickListener onPatClickListener) {
            super(itemView);

            name_id = itemView.findViewById(R.id.textname);
            date_id = itemView.findViewById(R.id.textdate);
            time_id = itemView.findViewById(R.id.texttime);

            this.onPatClickListener = onPatClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onPatClickListener.onPatClick(getAdapterPosition());

        }
    }
        public interface OnPatClickListener {
            void onPatClick(int position);
        }

    }


