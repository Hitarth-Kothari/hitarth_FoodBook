package com.example.hitarth_foodbook;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AddFoodFragment.OnFragmentInteractionListener{

    // Declare the variables so that you will be able to reference it later.
    ListView foodList;
    ArrayAdapter<Food> foodAdapter;
    ArrayList<Food> foodDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        foodList = findViewById(R.id.food_list);

        foodDataList = new ArrayList<>();

        foodAdapter = new CustomList(this, foodDataList);

        foodList.setAdapter(foodAdapter);

        final FloatingActionButton addfoodButton = findViewById(R.id.add_food_button);
        addfoodButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new AddFoodFragment().show(getSupportFragmentManager(), "ADD_food");
            }
        });

        foodList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                new AddFoodFragment(foodDataList.get(i)).show(getSupportFragmentManager(), "ADD_food");
            }
        });
    }

    @Override
    public void Add_food(Food newfood) {
        foodAdapter.add(newfood);
    }

    @Override
    public void Delete_food(Food mfood) {
        if (mfood != null){
            foodAdapter.remove(mfood);
        }
    }
}