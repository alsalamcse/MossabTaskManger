package com.yassen.mossab.mossabtaskmanger;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yassen.mossab.mossabtaskmanger.ui.main.MyFragmentsPagerAdapter;

public class MainTasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tasks);
        MyFragmentsPagerAdapter sectionsPagerAdapter = new MyFragmentsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add Car", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent=new Intent(getApplication(),AddCar.class);
                startActivity(intent);

            }
        });
    }
}