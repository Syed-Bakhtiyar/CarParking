package com.example.bakhtiyar.carparkingapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;

    ViewPager viewPager;

    MainFragmentAdapter mainFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragmentAdapter = new MainFragmentAdapter(getSupportFragmentManager(),1);

        tabLayout = (TabLayout) findViewById(R.id.tab);

        viewPager = (ViewPager) findViewById(R.id.vp);

        viewPager.setAdapter(mainFragmentAdapter);

        tabLayout.setupWithViewPager(viewPager);


    }
}
