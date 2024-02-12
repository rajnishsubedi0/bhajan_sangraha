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
    Context context;
    DB_Handler dbHandler;
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
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        String string=arrayList.get(holder.getAdapterPosition()).getBhajan_name_nepali();
        holder.textView.setText(string);
        holder.textViewNepaliNumber.setText(nepaliNumbers[holder.getAdapterPosition()]);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str= arrayList.get(holder.getAdapterPosition()).getId();
           Intent intent= new Intent(context, SecondActivity.class);
           intent.putExtra("position",str);
           context.startActivity(intent);
                            }
        });

        holder.linearLayout.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.add("Add").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                    dbHandler=new DB_Handler(context.getApplicationContext());
                    dbHandler.addData(""+holder.getAdapterPosition());
                    return false;
                }
            });
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
