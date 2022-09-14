package com.example.hitarth_foodbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private boolean clicked = false;
    private ArrayList<Food> Food_list;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Food_list = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler);

        setFood();
        setAdapter();
    }

    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(Food_list);
        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutmanager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setFood() {
        Food_list.add(new Food("tuna", "12", "blah", 5, 5));
        Food_list.add(new Food("tuna", "12", "blah", 5, 6));
        Food_list.add(new Food("tuna", "12", "blah", 5, 7));
    }
}