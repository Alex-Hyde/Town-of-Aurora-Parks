package com.example.auroratrailsapp;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class Trail {
    private LatLng location;
    private String description;
    private String name;
    private String image;
    private LatLng[] markers;
    private ArrayList<String > sightings;

    public Trail(String name,
                 LatLng location,
                 String description,
                 String image,
                 LatLng[] markers) {
        this.location = location;
        this.description = description;
        this.name = name;
        this.image = image;
        this.markers = markers;
        this.sightings = new ArrayList<String>();
    }

    public LatLng getLocation() {
        return location;
    }
    public String getDescription() {
        return description;
    }
    public String getName() { return name; }
    public String getImage() { return image; }
    public LatLng[] getMarkers() { return markers; }

    public ArrayList<String> getSightings() {
        return sightings;
    }

    public void addToSightings(String s) {
        this.sightings.add(s);
    }
}
