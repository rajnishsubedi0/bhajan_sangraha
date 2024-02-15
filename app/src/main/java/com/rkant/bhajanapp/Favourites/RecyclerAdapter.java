package com.rkant.bhajanapp.Favourites;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rkant.bhajanapp.R;
import com.rkant.bhajanapp.secondActivities.DataHolder;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolderClass> {
    Context context;
    ArrayList<com.rkant.bhajanapp.secondActivities.DataHolder> arrayList;
    ArrayList<com.rkant.bhajanapp.FirstActivities.DataHolder> arrayList1;

    public RecyclerAdapter(Context context, ArrayList<DataHolder> arrayList,
                           ArrayList<com.rkant.bhajanapp.FirstActivities.DataHolder> arrayList1){
        this.arrayList=arrayList;
        this.context=context;
        this.arrayList1=arrayList1;
    }
    public class MyViewHolderClass extends RecyclerView.ViewHolder {
        TextView textView,textViewNepaliNumber;
        public MyViewHolderClass(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            textViewNepaliNumber=itemView.findViewById(R.id.textViewNepaliNumber);
        }
    }
    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        return new MyViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolderClass holder, int position) {
        holder.textView.setText(arrayList.get(holder.getAdapterPosition()).getBhajan_name_nepali());
        holder.textViewNepaliNumber.setText(arrayList1.get(holder.getAdapterPosition()).getString());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
