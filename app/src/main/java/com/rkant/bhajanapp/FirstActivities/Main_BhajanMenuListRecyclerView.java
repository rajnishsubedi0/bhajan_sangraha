package com.rkant.bhajanapp.FirstActivities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.rkant.bhajanapp.R;
import com.rkant.bhajanapp.secondActivities.SecondMainActivity_ActualBhajanShowingActivity;
import com.rkant.bhajanapp.secondActivities.SecondView_DataHolderUsingArraylist;

import java.util.ArrayList;
public class Main_BhajanMenuListRecyclerView extends androidx.recyclerview.widget.RecyclerView.Adapter<Main_BhajanMenuListRecyclerView.MyViewHolder>{
    private ArrayList<SecondView_DataHolderUsingArraylist> arrayList;
    AdapterView.OnItemSelectedListener listener;
    Context context;
    String[] nepaliNumbers;
    public Main_BhajanMenuListRecyclerView(ArrayList<SecondView_DataHolderUsingArraylist> arrayList, AdapterView.OnItemSelectedListener listener, Context context, String[] nepaliNumbers){
        this.arrayList=arrayList;
        this.listener=listener;
        this.context=context;
        this.nepaliNumbers=nepaliNumbers;
    }



    public class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        TextView textView,textViewNepaliNumber;
        LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            linearLayout=itemView.findViewById(R.id.layout_name);
            textViewNepaliNumber=itemView.findViewById(R.id.textViewNepaliNumber);
            
        }
    }

    @NonNull
    @Override
    public Main_BhajanMenuListRecyclerView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Main_BhajanMenuListRecyclerView.MyViewHolder holder, int position) {
        String string=arrayList.get(position).getBhajan_name_nepali();
        int number=arrayList.get(position).getInteger();
        holder.textView.setText(string);
        holder.textViewNepaliNumber.setText(nepaliNumbers[position]);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           Intent intent= new Intent(context, SecondMainActivity_ActualBhajanShowingActivity.class);
           intent.putExtra("position",number);
           context.startActivity(intent);
                            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public void filterList(ArrayList<SecondView_DataHolderUsingArraylist> filteredList){
        arrayList=filteredList;
        notifyDataSetChanged();
    }

}
