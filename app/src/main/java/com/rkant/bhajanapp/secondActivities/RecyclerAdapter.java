package com.rkant.bhajanapp.secondActivities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.rkant.bhajanapp.FirstActivities.DataHolder;
import com.rkant.bhajanapp.R;

import java.util.ArrayList;

public class RecyclerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    private ArrayList<DataHolder> arrayList;
    // initilizing linearlayout to set onTouchListener
    private LinearLayout linearLayout;



    //passiing context to make toast for testing

    private Context context;

    public RecyclerAdapter(ArrayList<DataHolder> arrayList, Context context){
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
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.show_bhajan,parent,false);
        return new RecyclerAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        String string=arrayList.get(position).getString();
        holder.textView.setText(string);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

 

}
