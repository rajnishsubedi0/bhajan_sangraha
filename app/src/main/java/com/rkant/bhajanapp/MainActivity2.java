package com.rkant.bhajanapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity2 extends AppCompatActivity {
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        linearLayout=findViewById(R.id.toolbarLinearLayout);
        linearLayout.setBackgroundDrawable(new ColorDrawable(0xff6200ed));
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Bhajanlist_fragment bhajanlist_fragment=new Bhajanlist_fragment();
        fragmentTransaction.add(R.id.frameLayoutForRecyclerViewonMainActivity2,bhajanlist_fragment);
        fragmentTransaction.commit();
    }
}