package com.rkant.bhajanapp.Favourites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.rkant.bhajanapp.FirstActivities.DB_Handler;
import com.rkant.bhajanapp.FirstActivities.DataHolder;
import com.rkant.bhajanapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FavouriteBookmarked extends AppCompatActivity {
    RecyclerView recyclerView;
    public static ArrayList<DataHolder> publicArrayList, notPublicArrayList;
    public static RecyclerAdapter publicRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        publicArrayList=new ArrayList<>();
        notPublicArrayList=new ArrayList<>();
      
        publicRecyclerAdapter=new RecyclerAdapter(FavouriteBookmarked.this,notPublicArrayList);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(publicRecyclerAdapter);
        DB_Handler dbHandler=new DB_Handler(getApplicationContext());
        dbHandler.fetchDbData();
        try {
            addData2();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }


    public void addData2() throws IOException, JSONException {
        String jsonArrayString=readDataFromFile(R.raw.bhajan_list);
        JSONArray jsonArray=new JSONArray(jsonArrayString);
        for(int i=0;i<jsonArray.length(); i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            String str=jsonObject.getString("id");
            for (int j=0;j<publicArrayList.size();j++){
                if (str.equals(publicArrayList.get(j).getString())){
                    notPublicArrayList.add(new DataHolder(jsonObject.getString("bhajan_nepali")));
                    publicRecyclerAdapter.notifyDataSetChanged();
                }
            }
        }
    }


    public String readDataFromFile(int i) throws IOException {
        InputStream inputStream=null;
        StringBuilder builder=new StringBuilder();
        try{
            String jsonString=null;
            inputStream=getResources().openRawResource(i);
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
}