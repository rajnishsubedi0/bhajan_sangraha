package com.rkant.bhajanapp.Favourites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.rkant.bhajanapp.FirstActivities.DB_Handler;
import com.rkant.bhajanapp.FirstActivities.DataHolder;
import com.rkant.bhajanapp.R;

import java.util.ArrayList;

public class FavouriteBookmarked extends AppCompatActivity {
    RecyclerView recyclerView;
    public static ArrayList<DataHolder> publicArrayList;
    public static RecyclerAdapter publicRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_bookmarked);
        recyclerView=findViewById(R.id.recyclerViewFromFavouriteBookmarked);
        publicArrayList=new ArrayList<>();
        publicRecyclerAdapter=new RecyclerAdapter(FavouriteBookmarked.this,publicArrayList);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(publicRecyclerAdapter);
        DB_Handler dbHandler=new DB_Handler(getApplicationContext());
        dbHandler.fetchDbData();
    }
}