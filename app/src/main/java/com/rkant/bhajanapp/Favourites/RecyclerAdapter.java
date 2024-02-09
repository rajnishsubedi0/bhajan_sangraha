package com.rkant.bhajanapp.Favourites;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rkant.bhajanapp.FirstActivities.DataHolder;
import com.rkant.bhajanapp.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolderClass> {
    Context context;

    public RecyclerAdapter(Context context){
        this.context=context;
    }
    String [] strings={"halo","hola","inkiya","hihi","hihi"};
    public class MyViewHolderClass extends RecyclerView.ViewHolder {
        TextView textView;
        public MyViewHolderClass(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textViewFromFavouriteRecyclerLayout);
        }
    }
    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_bookmarked_layout,parent,false);
        return new MyViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolderClass holder, int position) {
       holder.textView.setText(strings[holder.getAdapterPosition()]);
    }

    @Override
    public int getItemCount() {
        return strings.length;
    }
}
