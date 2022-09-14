package com.example.hitarth_foodbook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<Food> Food_list;
    public recyclerAdapter(ArrayList<Food> Food_list){
        this.Food_list = Food_list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView food_name;
        private String date;
        private String location;
        private TextView count;
        private TextView cost;
        private Context mContext;

        public MyViewHolder(View view, Context context) {
            super(view);
            food_name = view.findViewById(R.id.food);
            count = view.findViewById(R.id.count);
            cost = view.findViewById(R.id.cost);
            mContext = context;
            view.setOnClickListener(this);
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, DisplayFood.class);
            intent.putExtra("food", food_name.getText().toString());
            intent.putExtra("date", date);
            intent.putExtra("location", location);
            intent.putExtra("count", count.getText().toString());
            intent.putExtra("cost", cost.getText().toString());
            this.mContext.startActivity(intent);
        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler, parent, false);
        return new MyViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String food_name = Food_list.get(position).getName();
        Integer count = Food_list.get(position).getCount();
        Integer cost = Food_list.get(position).getCost();

        holder.food_name.setText(food_name);
        holder.setDate(Food_list.get(position).getDate());
        holder.setLocation(Food_list.get(position).getLocation());
        holder.count.setText(String.valueOf(count));
        holder.cost.setText(String.valueOf(cost));
    }

    @Override
    public int getItemCount() {
        return Food_list.size();
    }
}
