package com.rkant.bhajanapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.rkant.bhajanapp.Favourites.FavouriteBookmarked;
import com.rkant.bhajanapp.FirstActivities.RecyclerAdapter;
import com.rkant.bhajanapp.secondActivities.DataHolder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static Context myContext;
    Button button;
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
        button=findViewById(R.id.buttonn);
        recyclerView=findViewById(R.id.recyclerView);
        arrayList=new ArrayList<>();
        try {
            addData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        settingAdapter();
        onButtonClick();


        // Changing Action Bar colour
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff6200ed));
    }

    public void onButtonClick() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, FavouriteBookmarked.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void settingAdapter() {
        recyclerCustomAdapter=new RecyclerAdapter(arrayList,listener,MainActivity.this,nepaliNumbers);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerCustomAdapter);


    }

    public void addData() throws IOException, JSONException {
        String jsonDataString=readDataFromFile();
        JSONArray jsonArray=new JSONArray(jsonDataString);
        for (int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            String nepali_bhajan=jsonObject.getString("bhajan_nepali");
            String bhajan_english_for_search=jsonObject.getString("bhajan_english");
            String id=jsonObject.getString("id");
            arrayList.add( new DataHolder(nepali_bhajan,bhajan_english_for_search,id));
        }

    }

    public String readDataFromFile() throws IOException {
        InputStream inputStream=null;
        StringBuilder builder=new StringBuilder();
        try{
            String jsonString=null;
            inputStream=getResources().openRawResource(R.raw.bhajan_list);
            BufferedReader bufferedReader=new BufferedReader(
                    new InputStreamReader(inputStream,"UTF-8"));
            while ((jsonString=bufferedReader.readLine()) !=null){
                builder.append(jsonString);
            }
        }
        finally {
            if(inputStream != null){
                inputStream.close();
            }
        }
        return new String(builder);
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




