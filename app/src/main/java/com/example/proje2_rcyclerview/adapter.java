package com.example.proje2_rcyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.define> {
    Context context;
    List<person_model> list;
    Interface_go_aboutClickedperson interface_go_aboutClickedperson;


    public adapter(Context context, List<person_model> list, Interface_go_aboutClickedperson interface_go_aboutClickedperson) {
        this.context = context;
        this.list = list;
        this.interface_go_aboutClickedperson = interface_go_aboutClickedperson;
    }

    @NonNull
    @Override
    public define onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mylayout = LayoutInflater.from(context).inflate(R.layout.layout_of_recyclerview, parent, false);
        return new define(mylayout);
    }

    @Override
    public void onBindViewHolder(@NonNull final define holder, final int position) {
        holder.gender.setImageResource(list.get(position).getGender());
        holder.name.setText(list.get(position).getName());
        holder.work.setImageResource(list.get(position).getWork());
        holder.work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.work.getDrawable().getConstantState().equals(view.getResources().getDrawable(R.drawable.evet).getConstantState())) {
                    holder.work.setImageResource(R.drawable.hayir);
                    list.get(position).setWork(R.drawable.hayir);

                } else {
                    holder.work.setImageResource(R.drawable.evet);
                    list.get(position).setWork(R.drawable.evet);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class define extends RecyclerView.ViewHolder {
        ImageView gender, work;
        TextView name;


        public define(@NonNull View itemView) {
            super(itemView);
            gender = itemView.findViewById(R.id.genderid);
            work = itemView.findViewById(R.id.workingid);
            name = itemView.findViewById(R.id.nameid);
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   interface_go_aboutClickedperson.onItemClick(getAdapterPosition());
               }
           });
        }
    }
}