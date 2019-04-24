package com.example.auroratrailsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class createSighting extends AppCompatActivity {

    public String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_sighting);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Report an animal sighting");
        setSupportActionBar(toolbar);
    }


    public void selectAnimal(View view) {
        int id = view.getId();

        if (id == R.id.redfox) {
            name = "Red Fox";
        } else if (id == R.id.coyote) {
            name = "Coyote";
        } else if (id == R.id.chipmunk) {
            name = "Chipmunk";
        } else if (id == R.id.blacksquirrel) {
            name = "Black Squirrel";
        } else if (id == R.id.greysquirrel) {
            name = "Grey Squirrel";
        } else if (id == R.id.pileatedwoodpecker) {
            name = "Pileated Woodpecker";
        } else if (id == R.id.bluejay) {
            name = "Blue Jay";
        } else if (id == R.id.cardinal) {
            name = "Cardinal";
        } else if (id == R.id.goldfinch) {
            name = "Gold Finch";
        } else if (id == R.id.redwingblackbird) {
            name = "Red Wing Blackbird";
        } else if (id == R.id.cancel) {
            name = null;
        }
        if (name != null) {
            Toast.makeText(this, "You Selected: " + name, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Selection cancelled", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        name = null;
        Intent intent = new Intent();
        intent.putExtra("name", name);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void returnValue(View view) {
        Intent intent = new Intent();
        intent.putExtra("name", name);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
