package com.rkant.bhajanapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.SearchView;

import com.rkant.bhajanapp.FirstActivities.RecyclerAdapter;
import com.rkant.bhajanapp.secondActivities.DataHolder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        MenuItem menuItem;
    SearchView searchView;
    RecyclerView recyclerView;
    String[] bhajan_name_nepali,bhajan_name_english;
    RecyclerAdapter recyclerCustomAdapter;
    Boolean backPressed=false;
    ActionBar actionBar;

    String[] nepaliNumbers={"१","२","३","४","५","६","७","८","९","१०","११","१२","१३","१४","१५","१६","१७","१८","१९","२०","२१","२२","२३","२४","२५","२६","२७","२८","२९","३०","३१","३२","३३","३४","३५","३६","३७","३८","३९","४०","४१","४२","४३","४४","४५","४६","४७","४८","४९","५०","५१","५२","५३","५४","५५","५६","५७","५८","५९","६०","६१","६२","६३","६४","६५","६६","६७","६८","६९","७०","७१","७२","७३","७४","७५","७६","७७","७८","७९","८०","८१","८२","८३","८४","८५","८६","८७","८८","८९","९०","९१"};
ArrayList<DataHolder> arrayList;
AdapterView.OnItemSelectedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        arrayList=new ArrayList<>();
        addingData();
        settingAdapter();


        // Changing Action Bar colour
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff6200ed));
    }



    private void settingAdapter() {
        recyclerCustomAdapter=new RecyclerAdapter(arrayList,listener,MainActivity.this,nepaliNumbers);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerCustomAdapter);


    }


    private void addingData() {
        bhajan_name_english=getResources().getStringArray(R.array.list_opening_bhajan_lists_english);
        bhajan_name_nepali =getResources().getStringArray(R.array.list_opening_bhajan_lists);
        for(int i = 0; i< bhajan_name_nepali.length; i++){
            arrayList.add(new DataHolder(bhajan_name_nepali[i],bhajan_name_english[i],i));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_search,menu);
        menuItem =menu.findItem(R.id.search_bar);
        searchView= (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                menuItem.collapseActionView();
                searchView.onActionViewCollapsed();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<DataHolder> filteredList=new ArrayList<>();
                for(int a=0; a< arrayList.size(); a++){
                    DataHolder item=arrayList.get(a);
                    if (item.getBhajan_name_nepali().toLowerCase().contains(s.toString().toLowerCase()) || item.getBhajan_name_english().toLowerCase().contains(s.toString().toLowerCase()) ){
                        filteredList.add(item);
                    }
                }
                recyclerCustomAdapter.filterList(filteredList);
                return false;
            }

        });





        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        menuItem.collapseActionView();
        searchView.onActionViewCollapsed();
        if(backPressed){
        super.onBackPressed();}
        else {backPressed=true;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                backPressed=false;
            }
        }, 2500);




    }


    }




