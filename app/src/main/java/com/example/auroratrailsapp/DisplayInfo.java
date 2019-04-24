package com.example.auroratrailsapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;

public class DisplayInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        if (MainActivity.park != null) {
            toolbar.setTitle("Park Info");
        } else {
            toolbar.setTitle("Trail Info");
        }
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

//        Intent intent = getIntent();
//        if (intent.getStringExtra("type")=="sighting") {
//            String name = intent.getStringExtra("name");
//            Toast.makeText(this, "good", Toast.LENGTH_SHORT).show();
//            if (MainActivity.park != null) {
//                MainActivity.park.addToSightings("name");
//            } else if (MainActivity.trail != null) {
//                MainActivity.trail.addToSightings("name");
//            }
//
//        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (MainActivity.park != null) {
            Park park = MainActivity.park;
            TextView name = findViewById(R.id.name);
            name.setText(park.getName());
            TextView address = findViewById(R.id.address);
            address.setText(park.getAddress());
            TextView description = findViewById(R.id.description);
            ImageView image = findViewById(R.id.image);
            String imageName = park.getImage();
            String newString = "";
            for (String s : park.getStrings()) {
                newString += "\n" + "- " + s;
            }
            newString = park.getDescription() + newString;
            if (park.getSightings().isEmpty() == false) {
                newString += "\n\nAnimal Sightings:";
                for (String s :
                        park.getSightings()) {
                    newString += "\n " + s;
                }
            }
            description.setText(newString);
            description.setMovementMethod(new ScrollingMovementMethod());
            try {
                InputStream stream = getAssets().open(imageName);
                Drawable d = Drawable.createFromStream(stream, null);
                image.setImageDrawable(d);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (MainActivity.trail != null) {
            Trail trail = MainActivity.trail;
            TextView name = findViewById(R.id.name);
            name.setText(trail.getName());
            TextView description = findViewById(R.id.description);
            ImageView image = findViewById(R.id.image);
            String imageName = trail.getImage();
            String newString = trail.getDescription();
            if (trail.getSightings().isEmpty() == false) {
                newString += "\n\nAnimal Sightings:";
                for (String s :
                        trail.getSightings()) {
                    newString += "\n" + s;
                }
            }
            description.setText(newString);
            description.setMovementMethod(new ScrollingMovementMethod());
            try {
                InputStream stream = getAssets().open(imageName);
                Drawable d = Drawable.createFromStream(stream, null);
                image.setImageDrawable(d);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onBackPressed();
        return true;
    }

    public void reportSighting(View v) {
        Intent intent = new Intent(this, createSighting.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data.getStringExtra("name")!=null) {
            Date date = new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);
            if (MainActivity.park != null) {
                MainActivity.park.addToSightings(data.getStringExtra("name")+": "+ ts);
            } else if (MainActivity.trail != null) {
                MainActivity.trail.addToSightings(data.getStringExtra("name")+": "+ts);
            }
        }
    }
}
