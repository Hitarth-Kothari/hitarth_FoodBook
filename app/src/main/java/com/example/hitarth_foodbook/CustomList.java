package com.example.hitarth_foodbook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hitarth_foodbook.Food;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<Food> {
    private ArrayList<Food> Food_list;
    private Context context;

    public CustomList(Context context, ArrayList<Food> Food_list){
        super(context,0,Food_list);
        this.Food_list = Food_list;
        this.context = context;
    }
    @SuppressLint("SetTextI18n")
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup
            parent) {
        View view = convertView;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }
        Food food = Food_list.get(position);

        TextView food_name = view.findViewById(R.id.food);
        TextView count = view.findViewById(R.id.count);
        TextView cost = view.findViewById(R.id.cost);

        food_name.setText(food.getName());
        count.setText(food.getCount().toString());
        cost.setText(food.getCost().toString());

        return view;
    }
}
