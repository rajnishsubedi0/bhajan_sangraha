package com.rkant.bhajanapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class SecondView_RecyclerView extends androidx.recyclerview.widget.RecyclerView.Adapter<SecondView_RecyclerView.MyViewHolder>{
    private ArrayList<Main_DataHolderUsingArraylist> arrayList;
    // initilizing linearlayout to set onTouchListener
    private LinearLayout linearLayout;



    //passiing context to make toast for testing

    private Context context;

    public SecondView_RecyclerView(ArrayList<Main_DataHolderUsingArraylist> arrayList, Context context){
        this.arrayList=arrayList;
        this.context=context;

    }
    public class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            linearLayout=itemView.findViewById(R.id.layout_name);



        }
    }
    @NonNull
    @Override
    public SecondView_RecyclerView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.logics_recycler_holder,parent,false);
        return new SecondView_RecyclerView.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull SecondView_RecyclerView.MyViewHolder holder, int position) {
        String string=arrayList.get(position).getString();
        holder.textView.setText(string);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

 

}
