package com.rkant.bhajanapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.widget.Toast;

import com.rkant.bhajanapp.Favourite_Bhajans.FavouriteBhajans;
import com.rkant.bhajanapp.FirstActivities.DB_Handler;
import com.rkant.bhajanapp.FirstActivities.RecyclerAdapter;
import com.rkant.bhajanapp.secondActivities.DataHolder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        MenuItem menuItem_searchbar,menuItem_favourite;
    SearchView searchView;
    RecyclerView recyclerView;
    String[] bhajan_name_nepali,bhajan_name_english;
    RecyclerAdapter recyclerCustomAdapter;
    Boolean backPressed=false;
    ActionBar actionBar;
    DB_Handler dbHandler;

    String[] nepaliNumbers={"१","२","३","४","५","६","७","८","९","१०","११","१२","१३","१४","१५","१६","१७","१८","१९","२०","२१","२२","२३","२४","२५","२६","२७","२८","२९","३०","३१","३२","३३","३४","३५","३६","३७","३८","३९","४०","४१","४२","४३","४४","४५","४६","४७","४८","४९","५०","५१","५२","५३","५४","५५","५६","५७","५८","५९","६०","६१","६२","६३","६४","६५","६६","६७","६८","६९","७०","७१","७२","७३","७४","७५","७६","७७","७८","७९","८०","८१","८२","८३","८४","८५","८६","८७","८८","८९","९०","९१"};
ArrayList<DataHolder> arrayList;
AdapterView.OnItemSelectedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHandler=new DB_Handler(MainActivity.this);
        recyclerView=findViewById(R.id.recyclerView);
        arrayList=new ArrayList<>();
        initializeData();
        settingAdapter();



        // Changing Action Bar colour
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff6200ed));
    }

    public void checkSharedPref() {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String str=sharedPreferences.getString("name","");
        if(sharedPreferences.getString("name","")=="") {
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            SharedPreferences sh = getSharedPreferences("MySharedPref",MODE_PRIVATE);
            myEdit.putString("name", "true");
            myEdit.commit();
            for(int i = 0; i< bhajan_name_nepali.length; i++){
                dbHandler.addData(bhajan_name_nepali[i]);
            }
            Toast.makeText(this, ""+str, Toast.LENGTH_SHORT).show();
        }

    }



    private void settingAdapter() {
        recyclerCustomAdapter=new RecyclerAdapter(arrayList,listener,MainActivity.this,nepaliNumbers);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerCustomAdapter);


    }


    public void initializeData() {
        bhajan_name_english=getResources().getStringArray(R.array.list_opening_bhajan_lists_english);
        bhajan_name_nepali =getResources().getStringArray(R.array.list_opening_bhajan_lists);
        addData();
        checkSharedPref();
    }

    public void addData() {
        for(int i = 0; i< bhajan_name_nepali.length; i++){
            arrayList.add(new DataHolder(bhajan_name_nepali[i],bhajan_name_english[i],i));
        }
    }

    public void stringToSqlite() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_search,menu);
        menuItem_searchbar =menu.findItem(R.id.search_bar);
        menuItem_favourite=menu.findItem(R.id.menu_favourite);
        searchView= (SearchView) menuItem_searchbar.getActionView();


        menuItem_favourite.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent intent=new Intent(MainActivity.this, FavouriteBhajans.class);
                startActivity(intent);
                return false;
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                menuItem_searchbar.collapseActionView();
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
        menuItem_searchbar.collapseActionView();
        searchView.onActionViewCollapsed();
        if (backPressed) {
            super.onBackPressed();
        } else {
            backPressed = true;

        }
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                backPressed = false;
            }
        }, 2500);

    }

    }




