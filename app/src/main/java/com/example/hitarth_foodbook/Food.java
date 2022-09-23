package com.example.hitarth_foodbook;

import java.util.Date;

public class Food {
    // Private data variables
    private String food_name;
    private Date date;
    private String location;
    private Integer count;
    private Integer cost;

    // Initializer
    public Food(String food_name, Date date, String location, Integer count, Integer cost){
        this.food_name = food_name;
        this.date = date;
        this.location = location;
        this.count = count;
        this.cost = cost;
    }

    // Getters and Setter
    public String getName() {
        return food_name;
    }

    public void setName(String name) {
        this.food_name = name;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
