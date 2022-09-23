package com.example.hitarth_foodbook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class AddFoodFragment extends DialogFragment {
    private boolean edit ;
    private Food mfood;
    private EditText foodName;
    private EditText count;
    private EditText cost;
    private EditText location;
    private EditText date;
    private OnFragmentInteractionListener listener;

    public AddFoodFragment()
    {
        edit = false;
    }
    public AddFoodFragment(Food food)
    {
        this.mfood = food;
        edit = true;
    }

    public interface OnFragmentInteractionListener {
        void Add_food(Food newFood);

        void Delete_food(Food mfood);
    }

    @Override
    public  void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener){
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        //cInflate the layout
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.add_food_fragment_layout, null);
        foodName = view.findViewById(R.id.food_name_editText);
        count = view.findViewById(R.id.count_editText);
        cost = view.findViewById(R.id.cost_editText);
        location = view.findViewById(R.id.location_editText);
        date = view.findViewById(R.id.date_editText);

        // Check if edit
        if (mfood != null){
            edit = true;
            foodName.setText(mfood.getName());
            count.setText(mfood.getCount().toString());
            cost.setText(mfood.getCost().toString());
            location.setText(mfood.getLocation());
            date.setText(new SimpleDateFormat("yyyy-MM-dd").format(mfood.getDate()));
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        return builder
                .setView(view)
                .setTitle("Add/Edit food")
                .setNegativeButton("Delete", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener.Delete_food(mfood);
                    }
                })
                .setNeutralButton("Cancel", null)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String food = foodName.getText().toString();
                        Integer counts = Integer.valueOf(count.getText().toString());
                        Integer costs = Integer.valueOf(cost.getText().toString());
                        String locations = location.getText().toString();
                        Date dates = null;
                        try {
                            dates = (new SimpleDateFormat("yyyy-MM-dd")).parse(String.valueOf(date.getText()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (!edit){
                            listener.Add_food(new Food(food, dates, locations, counts, costs));
                        }
                        else{
                            if (!Objects.equals(food, "")){
                                mfood.setName(food);
                            }
                            if (!Objects.equals(counts.toString(), "")){
                                mfood.setCount(counts);
                            }
                            if (!Objects.equals(costs.toString(), "")){
                                mfood.setCost(costs);
                            }
                            if (!Objects.equals(locations, "")){
                                mfood.setLocation(locations);
                            }
                            mfood.setDate(dates);
                        }
                    }
                }).create();
    }
}

