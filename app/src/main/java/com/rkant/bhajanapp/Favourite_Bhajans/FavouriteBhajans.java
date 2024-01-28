package com.rkant.bhajanapp.Favourite_Bhajans;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.rkant.bhajanapp.R;

public class FavouriteBhajans extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_bhajans);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff6200ed));
    }
}