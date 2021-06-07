package com.booking.Assigment.entity;

import org.springframework.lang.Nullable;

import java.util.Date;

public class Search {

    @Nullable
    private String city;
    @Nullable
    private Date date;
    @Nullable
    private boolean wifi;
    @Nullable
    private boolean restaurant;
    @Nullable
    private boolean airCondition;
    @Nullable
    boolean breakfast;

    public boolean isRestaurant() {
        return restaurant;
    }

    public void setRestaurant(boolean restaurant) {
        this.restaurant = restaurant;
    }

    public boolean isAirCondition() {
        return airCondition;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }
}
