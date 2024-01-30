package com.rkant.bhajanapp.FirstActivities;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.rkant.bhajanapp.R;
import com.rkant.bhajanapp.secondActivities.SecondActivity;
import com.rkant.bhajanapp.secondActivities.DataHolder;

import java.util.ArrayList;
public class RecyclerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    private ArrayList<DataHolder> arrayList;
    AdapterView.OnItemSelectedListener listener;
    DB_Handler dbHandler;
    Context context;
    String[] nepaliNumbers;
    public RecyclerAdapter(ArrayList<DataHolder> arrayList, AdapterView.OnItemSelectedListener listener, Context context, String[] nepaliNumbers){
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
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.bhajan_choosing_lists,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        String string=arrayList.get(holder.getAdapterPosition()).getBhajan_name_nepali();
        int number=arrayList.get(holder.getAdapterPosition()).getInteger();
        holder.textView.setText(string);
        holder.textViewNepaliNumber.setText(nepaliNumbers[holder.getAdapterPosition()]);

       /* holder.linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
            dbHandler=new DB_Handler(context.getApplicationContext());
            dbHandler.addData(""+holder.getAdapterPosition());
                Toast.makeText(context, "Data Added", Toast.LENGTH_SHORT).show();

                return false;
            }
        });*/
        holder.linearLayout.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.add("delete").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        dbHandler=new DB_Handler(context.getApplicationContext());
                        dbHandler.addData(""+holder.getAdapterPosition());
                        Toast.makeText(context, "Data Added", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
            }
        });
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           Intent intent= new Intent(context, SecondActivity.class);
           intent.putExtra("position",string);
           context.startActivity(intent);
                            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public void filterList(ArrayList<DataHolder> filteredList){
        arrayList=filteredList;
        notifyDataSetChanged();
    }

}
