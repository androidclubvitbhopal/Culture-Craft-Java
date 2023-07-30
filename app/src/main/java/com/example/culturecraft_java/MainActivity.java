package com.example.culturecraft_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.BlurMaskFilter;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.jgabrielfreitas.core.BlurImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        int flags = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(flags);

        init();
        ArrayList<RecyclerItem> arrList = new ArrayList<>();
        arrList.add(new RecyclerItem("History",R.drawable.img4));
        arrList.add(new RecyclerItem("Dance",R.drawable.img1));
        arrList.add(new RecyclerItem("Food",R.drawable.img3));
        arrList.add(new RecyclerItem("Places",R.drawable.img2));
        MyAdapter myAdapter = new MyAdapter(this,arrList);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.places:{
                        recyclerView.smoothScrollToPosition(3);
                        break;
                    }
                    case R.id.dance:{
                        recyclerView.smoothScrollToPosition(1);
                        break;
                    }
                    case R.id.history:{
                        recyclerView.smoothScrollToPosition(0);
                        break;

                    }
                    case R.id.food:{
                        recyclerView.smoothScrollToPosition(2);
                        break;
                    }
                    default: {

                        recyclerView.smoothScrollToPosition(0);
                    }
                }
                return false;
            }
        });

    }
    private void init(){
        recyclerView=findViewById(R.id.recyclerView);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
    }
}