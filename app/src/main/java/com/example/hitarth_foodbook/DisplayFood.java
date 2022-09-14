package com.example.hitarth_foodbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayFood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_food);

        Intent intent = getIntent();
        TextView food_name = findViewById(R.id.food_name);
        TextView date = findViewById(R.id.date);
        TextView loc = findViewById(R.id.location);
        TextView count = findViewById(R.id.counts);
        TextView cost = findViewById(R.id.costs);
        food_name.setText(intent.getStringExtra("food"));
        date.setText(intent.getStringExtra("date"));
        loc.setText(intent.getStringExtra("loc"));
        count.setText(intent.getStringExtra("count"));
        cost.setText(intent.getStringExtra("cost"));
    }
}