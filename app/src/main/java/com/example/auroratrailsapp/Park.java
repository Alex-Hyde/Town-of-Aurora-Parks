package com.example.auroratrailsapp;

import android.graphics.drawable.Drawable;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class Park {

    private LatLng location;
    private String address;
    private String description;
    private String name;
    private String image;
    private String[] strings;
    private ArrayList<String> sightings;

    public Park(String name,
                LatLng location,
                String address,
                String description,
                String image,
                String[] strings) {
        this.location = location;
        this.address = address;
        this.description = description;
        this.name = name;
        this.image = image;
        this.strings = strings;
        this.sightings = new ArrayList<String>();
    }

    public LatLng getLocation() {
        return location;
    }
    public String getAddress() {
        return address;
    }
    public String getDescription() {
        return description;
    }
    public String getName() { return name; }
    public String getImage() { return image; }
    public String[] getStrings() { return strings; }
    public ArrayList<String> getSightings() {
        return sightings;
    }
    public void addToSightings(String s) {
        this.sightings.add(s);
    }
}
