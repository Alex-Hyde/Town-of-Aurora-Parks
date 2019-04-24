package com.example.auroratrailsapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.InputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker marker;
    public static Park park;
    public static Trail trail;
    private ArrayList<Marker> trailMarkers = new ArrayList<Marker>();
    private ArrayList<Marker> soccerMarkers = new ArrayList<Marker>();
    private Boolean toggleSoccer = false;
    private ArrayList<Marker> skatingMarkers = new ArrayList<Marker>();
    private Boolean toggleSkating = false;
    private ArrayList<Marker> baseballMarkers = new ArrayList<Marker>();
    private Boolean toggleBaseball = false;
    private ArrayList<Marker> basketballMarkers = new ArrayList<Marker>();
    private Boolean toggleBasketball = false;
    private ArrayList<Marker> splashMarkers = new ArrayList<Marker>();
    private Boolean toggleSplash = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng aurora = new LatLng(43.997061, -79.446935);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(aurora, 12.3f));
    }

    private ArrayList<Marker> createMarkers(LatLng[] list,String title) {
        ArrayList<Marker> newList = new ArrayList<Marker>();
        for (LatLng latLng :
                list) {
            Marker marker = mMap.addMarker(new MarkerOptions().position(latLng).title(title));
            marker.setVisible(false);
            newList.add(marker);
        }
        return newList;
    }


    public void toggleSoccer(MenuItem item) {
        if (toggleSoccer) {
            for (Marker m :
                    soccerMarkers) {
                m.setVisible(false);
            }

            toggleSoccer = false;
        } else {
            for (Marker m :
                    soccerMarkers) {
                m.setVisible(true);
            }
            toggleSoccer = true;
        }
    }
    public void toggleSkating(MenuItem item) {
        if (toggleSkating) {
            for (Marker m :
                    skatingMarkers) {
                m.setVisible(false);
            }

            toggleSkating = false;
        } else {
            for (Marker m :
                    skatingMarkers) {
                m.setVisible(true);
            }
            toggleSkating = true;
        }
    }
    public void toggleBaseball(MenuItem item) {
        if (toggleBaseball) {
            for (Marker m :
                    baseballMarkers) {
                m.setVisible(false);
            }

            toggleBaseball = false;
        } else {
            for (Marker m :
                    baseballMarkers) {
                m.setVisible(true);
            }
            toggleBaseball = true;
        }
    }
    public void toggleBasketball(MenuItem item) {
        if (toggleBasketball) {
            for (Marker m :
                    basketballMarkers) {
                m.setVisible(false);
            }

            toggleBasketball = false;
        } else {
            for (Marker m :
                    basketballMarkers) {
                m.setVisible(true);
            }
            toggleBasketball = true;
        }
    }
    public void toggleSplash(MenuItem item) {
        if (toggleSplash) {
            for (Marker m :
                    splashMarkers) {
                m.setVisible(false);
            }

            toggleSplash = false;
        } else {
            for (Marker m :
                    splashMarkers) {
                m.setVisible(true);
            }
            toggleSplash = true;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.soccer);

        LatLng[] list1 = {new LatLng(44.020423, -79.443406), new LatLng(43.983319, -79.478819), new LatLng(44.008580, -79.468300),
                new LatLng(44.001729, -79.471601), new LatLng(44.012238, -79.440317), new LatLng(43.982408, -79.460138),
                new LatLng(44.006867, -79.455558), new LatLng(44.006949, -79.472183), new LatLng(43.971518, -79.482876),
                new LatLng(43.995071, -79.454966), new LatLng(43.995457, -79.455063), new LatLng(43.995827, -79.455256),
                new LatLng(43.995495, -79.456093), new LatLng(43.996035, -79.456640), new LatLng(43.995958, -79.457123),
                new LatLng(43.996499, -79.456554), new LatLng(43.996336, -79.457337), new LatLng(43.997085, -79.456930),
                new LatLng(43.996962, -79.457606), new LatLng(44.012593, -79.422502), new LatLng(44.002932, -79.48997), new LatLng(43.998696, -79.462498)};
        soccerMarkers = createMarkers(list1, "Soccer Field");
        for (Marker m : soccerMarkers) { m.setIcon(BitmapDescriptorFactory.fromAsset("soccer.png")); }
        LatLng[] list2 = {new LatLng(44.020313, -79.443890), new LatLng(44.006960, -79.471520), new LatLng(43.998264, -79.462592), new LatLng(43.983555, -79.478633)};
        skatingMarkers = createMarkers(list2, "Skating Rink");
        for (Marker m : skatingMarkers) { m.setIcon(BitmapDescriptorFactory.fromAsset("skate.png")); }
        LatLng[] list3 = {new LatLng(43.984026, -79.478912), new LatLng(43.992979, -79.481917), new LatLng(44.001814, -79.472716),
                new LatLng(43.994930, -79.447094), new LatLng(44.009584, -79.459987), new LatLng(44.010417, -79.458892), new LatLng(44.007955, -79.457653),
                new LatLng(44.005823, -79.471346), new LatLng(43.972388, -79.483102), new LatLng(44.012893, -79.422891), new LatLng(43.997844, -79.462621)};
        baseballMarkers = createMarkers(list3, "Baseball Diamond");
        for (Marker m : baseballMarkers) { m.setIcon(BitmapDescriptorFactory.fromAsset("baseball.png")); }
        LatLng[] list4 = {new LatLng(44.020554, -79.444103), new LatLng(43.983666, -79.479343), new LatLng(44.012685, -79.441390),
                new LatLng(43.993914, -79.447751), new LatLng(44.014760, -79.438047)};
        basketballMarkers = createMarkers(list4, "Basketball Court");
        for (Marker m : basketballMarkers) { m.setIcon(BitmapDescriptorFactory.fromAsset("basketball.png")); }
        LatLng[] list5 = {new LatLng(44.020442, -79.444018),new LatLng(44.025053, -79.429108),new LatLng(44.012577, -79.422886),
                new LatLng(43.998176, -79.462342),new LatLng(44.027038, -79.440541)};
        splashMarkers = createMarkers(list5, "Splash Park");
        for (Marker m : splashMarkers) { m.setIcon(BitmapDescriptorFactory.fromAsset("splash.png")); }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //Add menu handling code
        switch (id) {
            case R.id.mapTypeNormal:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.mapTypeSatellite:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.mapTypeTerrain:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
        }
        if (id == R.id.mapTypeNormal) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void drawPolygon(LatLng... lPos) {
        PolygonOptions options = new PolygonOptions()
                .fillColor(0x330000FF)
                .strokeColor(Color.BLUE)
                .strokeWidth(3);
        for (LatLng pos :
                lPos) {
            options.add(pos);
        }
        mMap.addPolygon(options);
    }

    private void drawLine(LatLng... lPos) {
        PolylineOptions options = new PolylineOptions().color(0xFF000000);
        for (LatLng pos :
                lPos) {
            options.add(pos);
        }
        mMap.addPolyline(options);
    }

    private void gotoLocation(LatLng latLng, float zoom) {
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
    }

    public void showInfo(View view) {
        if (park == null && trail == null) {
            Toast.makeText(this, "Select a Park or a Trail", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, DisplayInfo.class);
            intent.putExtra("type", "info");
            startActivity(intent);
        }
    }

    private void gotoPark(Park park) {
        gotoLocation(park.getLocation(), 17);
        marker = mMap.addMarker(new MarkerOptions().position(park.getLocation()).title(park.getName())
                .snippet(park.getAddress()));
    }

    public void gotoHome(View view) {
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(43.997061, -79.446935), 12.3f));
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (marker != null) {
            marker.remove();
            marker = null;
        }
        if (trail != null) {
            for (Marker marker :
                    trailMarkers) {
                marker.remove();
            }
            trailMarkers.clear();
        }

        park = null;
        trail = null;
        if (id == R.id.trail1) {
            trail = trail1;
        } else if (id == R.id.trail2) {
            trail = trail2;
        } else if (id == R.id.trail3) {
            trail = trail3;
        } else if (id == R.id.trail4) {
            trail = trail4;
        } else if (id == R.id.trail5) {
            trail = trail5;
        } else if (id == R.id.trail6) {
            trail = trail6;
        } else if (id == R.id.trail7) {
            trail = trail7;
        } else if (id == R.id.park1) {
            park = park1;
        } else if (id == R.id.park2) {
            park = park2;
        } else if (id == R.id.park3) {
            park = park3;
        } else if (id == R.id.park4) {
            park = park4;
        } else if (id == R.id.park5) {
            park = park5;
        } else if (id == R.id.park6) {
            park = park6;
        } else if (id == R.id.park7) {
            park = park7;
        } else if (id == R.id.park8) {
            park = park8;
        } else if (id == R.id.park9) {
            park = park9;
        } else if (id == R.id.park10) {
            park = park10;
        } else if (id == R.id.park11) {
            park = park11;
        } else if (id == R.id.park12) {
            park = park12;
        } else if (id == R.id.park13) {
            park = park13;
        } else if (id == R.id.park14) {
            park = park14;
        } else if (id == R.id.park15) {
            park = park15;
        } else if (id == R.id.park16) {
            park = park16;
        } else if (id == R.id.park17) {
            park = park17;
        } else if (id == R.id.park18) {
            park = park18;
        } else if (id == R.id.park19) {
            park = park19;
        } else if (id == R.id.park20) {
            park = park20;
        } else if (id == R.id.park21) {
            park = park21;
        }
        if (trail != null) {
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(43.997061, -79.446935), 12.3f));
            for (LatLng marker :
                    trail.getMarkers()) {
                Marker m = mMap.addMarker(new MarkerOptions().position(marker).icon(BitmapDescriptorFactory.fromAsset("walking.png")));
                trailMarkers.add(m);
            }
        } else if (park != null) {
            gotoPark(park);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private LatLng[] markers1 = {new LatLng(43.980342, -79.438635), new LatLng(43.979731, -79.439382), new LatLng(43.986672, -79.443458), new LatLng(43.991314, -79.445971), new LatLng(43.998889, -79.448892), new LatLng(44.007268, -79.455787), new LatLng(44.015934, -79.459419), new LatLng(44.020084, -79.462188), new LatLng(44.022985, -79.470578)};
    public Trail trail1 = new Trail("Holland River Trail",
            new LatLng(44.020405, -79.443817),
            "Holland river trail (aka Nokiidaa trail) is a trail that cuts through the center of aurora, starting north of St. John’s sideroad and going all the way south of " + "Vandorf. The trail borders the Holland river, providing almost 8 kilometers of uninterrupted wildlife hiking. \nTrail difficulty: EASY",
            "hollandRiver1.jpg", markers1);

    private LatLng[] markers2 = {new LatLng(43.985885, -79.443187), new LatLng(43.991292, -79.445940), new LatLng(43.992083, -79.450676), new LatLng(43.994590, -79.452608)};
    public Trail trail2 = new Trail("Klaus Wehrenberg Trail",
            new LatLng(44.020405, -79.443817),
            "Klaus Wehrenberg Trail is a 1.5 Km trail running parallel to the Holland river between Vandorf and Wellington. It is connected to the Holland river trail by two points and is engulfed by sprawling wildlife.",
            "klaus1.jpg", markers2);

    private LatLng[] markers3 = {new LatLng(44.014811, -79.476541), new LatLng(44.014270, -79.484095), new LatLng(44.009718, -79.484395), new LatLng(44.005520, -79.494480), new LatLng(44.001214, -79.489802), new LatLng(43.999917, -79.486884)};
    public Trail trail3 = new Trail("Lakeview Trail System",
            new LatLng(44.020405, -79.443817),
            "A trail linking parks and linear open space corridors within the forested hills of St. Andrews in Northwest Aurora. \nTrail difficulty: EASY/MODERATE",
            "lakeview1.jpg", markers3);

    private LatLng[] markers4 = {new LatLng(44.019779, -79.466829)};
    public Trail trail4 = new Trail("McKenzie Marsh Trail",
            new LatLng(44.020405, -79.443817),
            "The McKenzie Marsh Wetland is located just east of Yonge on St. John’s Sideroad, and provides a wildlife sanctuary at the heart of Aurora.",
            "mckenzie1.jpg", markers4);

    private LatLng[] markers5 = {new LatLng(44.013662, -79.493397), new LatLng(44.013689, -79.494840), new LatLng(44.013279, -79.490902), new LatLng(43.993957, -79.490235), new LatLng(44.022959, -79.453129), new LatLng(43.999676, -79.473318)};
    public Trail trail5 = new Trail("Municipal Trails",
            new LatLng(44.020405, -79.443817),
            "A series of small trails linking neighbourhoods all across Aurora.",
            "municipal.jpg", markers5);

    private LatLng[] markers6 = {new LatLng(44.003544, -79.450908), new LatLng(44.007341, -79.455800), new LatLng(44.013360, -79.455499), new LatLng(44.019995, -79.461937)};
    public Trail trail6 = new Trail("Tim Jones Trail & Arboretum",
            new LatLng(44.020405, -79.443817),
            "A portion of the Holland River Trail renamed after former town mayor Tim Jones. \nTrail difficulty: EASY/MODERATE",
            "tim1.jpg", markers6);

    private LatLng[] markers7 = {new LatLng(44.014811, -79.476541), new LatLng(44.014270, -79.484095), new LatLng(44.009718, -79.484395), new LatLng(44.005520, -79.494480), new LatLng(44.001214, -79.489802), new LatLng(43.999917, -79.486884)};
    public Trail trail7 = new Trail("Willow Farm Valley Trail System",
            new LatLng(44.020405, -79.443817),
            "Willow Farm Valley Trail system is located in North-West Aurora and serves as a 55 acre conservation space. \nTrail difficulty: EASY/MODERATE",
            "willow1.jpg", markers7);


    private String[] strings = {"Splash pad ", "Washroom facilities", "Vita Parcour fitness trail", "Gazebo", "2 Half basketball courts", "1 Senior/junior playground ", "1 Natural outdoor ice rink",
            "19 car paved parking facility", "1 soccer field"};
    public Park park1 = new Park("Ada Johnson Park",
            new LatLng(44.020405, -79.443817),
            "60 Hartwell Way",
            "Opened in 2007 and named after 110 year old Aurora Resident Ada Viola Johnson, this stunning 5.2 acre park located at 60 Hartwell Way boasts:",
            "adaJohnson1.png",
            strings);

    private String[] strings2 = {"1 Senior/junior playground"};
    public Park park2 = new Park("Atkinson Park",
            new LatLng(44.017121, -79.467017),
            "46 Twelve Oaks Dr.",
            "This beautiful 10.24 acre park located at 46 Twelve Oaks Dr. features a Jr./Sr. Playpark and provides a beautiful trails through the marsh area containing lots of local wildlife.",
            "atkinsonPark1.jpg",
            strings2);

    private String[] strings3 = {};
    public Park park3 = new Park("Case Woodlot",
            new LatLng(43.975388, -79.486550),
            "675 Henderson Dr.",
            "Case Woodlot is a beautiful 67 acre conservation area located at 675 Henderson Drive that provides a quiet wildlife sanctuary for the citizens of Aurora.",
            "caseWoodlot1.jpg",
            strings3);

    private String[] strings4 = {"Splash pad ", "Washroom facilities", "Vita Parcour fitness trail", "Gazebo", "2 Half basketball courts", "1 Senior/junior playground ", "1 Natural outdoor ice rink",
            "19 car paved parking facility", "1 soccer field"};
    public Park park4 = new Park("Confederation Park",
            new LatLng(43.982562, -79.476523),
            "30 Glass Dr.",
            "Confederation park is a 15 acre community space located at 30 glass drive that is fully equipped with:",
            "confederationPark1.jpg",
            strings4);

    private String[] strings5 = {"1 Senior/junior playground", "1 softball facility", "Posted toboggan area"};
    public Park park5 = new Park("Copland Park",
            new LatLng(43.998739, -79.488413),
            "225 Aurora Heights Dr.",
            "Copland park is a 5 acre park located at 225 Aurora heights drive that features:",
            "copland1.jpg",
            strings5);

    private String[] strings6 = {"1 soccer facility","20 car turf parking lot","Natural open space area"};
    public Park park6 = new Park("Craddock Park",
            new LatLng(44.008793, -79.468165),
            "5 Batson Dr.",
            "Craddock park is a 9.7 acre park area that serves as a wildlife area and soccer field.",
            "craddock1.jpg",
            strings6);

    private String[] strings7 = {"1 Senior/junior playground","1 softball facility","Open space natural area"};
    public Park park7 = new Park("Elizabeth Hader Park",
            new LatLng(43.993349, -79.482003),
            "69 Timpson Dr.",
            "Elizabeth Hader park is a 17 acre wildlife area surrounded by dense foliage that features:",
            "elizabeth1.png",
            strings7);

    private String[] strings8 = {"1 Senior/junior playground","1 softball facility","1 soccer facility","1 four-court lighted tennis facility","Washroom facilities","Picnic shelter","Posted toboggan area"};
    public Park park8 = new Park("Fleury Park",
            new LatLng(44.001490, -79.472094),
            "5 Community Centre Lane",
            "Fleury Park is an 11.4 acre park located at 5 Community Center lane located adjacent to the Aurora Community Center. The park features:",
            "fleury1.jpg",
            strings8);

    private String[] strings9 = {"1 Senior/junior playground","Skateboard facility","BMX circuit","1 soccer facility","2 Half basketball courts","Gazebo"};
    public Park park9 = new Park("Hickson Park",
            new LatLng(44.012693, -79.441218),
            "155 Conover Avenue",
            "This beautiful park features:",
            "hickson1.JPG",
            strings9);

    private String[] strings10 = {"1 Soccer facility","Home of the Aurora Soccer Club","Full clubhouse facility on the property","65 car gravel parking facility"};
    public Park park10 = new Park("Highland Park",
            new LatLng(43.982191, -79.459971),
            "510 Industrial Pkwy S",
            "Highland fields serves as the home field for the Aurora Football Club. This park features:",
            "highland1.jpg",
            strings10);

    private String[] strings11 = {"1 softball facility","1 Senior/junior playground","1 Full basketball court"};
    public Park park11 = new Park("James Lloyd Park",
            new LatLng(43.994220, -79.447566),
            "355 Stone Road",
            "James Lloyd Park is a beautiful 5.3 acre park that features:",
            "jameslloyd1.png",
            strings11);

    private String[] strings12 = {"3 senior softball facilities","1 baseball facility","1 soccer facility","1 Senior/junior playground","Skateboard park","2 Beach volleyball courts","Posted toboggan area","Washroom facility","Picnic shelter","Gazebo","Entrances to Aurora Community Arboretum"};
    public Park park12 = new Park("Lambert Wilson Park",
            new LatLng(44.008805, -79.460523),
            "115 & 135 Industrial Pkwy N",
            "This park is a 28 acre space behind the Aurora leisure complex that features:",
            "lambert1.png",
            strings12);

    private String[] strings13 = {"1 Senior/junior playground","2 soccer facility","2 softball facilities","56 car paved parking facility", "1 Natural outdoor ice rink","Posted toboggan area"};
    public Park park13 = new Park("Machell Park",
            new LatLng(44.006502, -79.471410),
            "2A Aurora Heights Dr & 15 Orchard Heights Dr.",
            "Machell Park, named after Richard Machell, a merchant and founding member of Aurora in 1804, is a 14.6 acre park that is a hub for the town of Aurora. The park hosts Aurora’s annual ribfest, has a hockey rink and toboggan hill during the winter seasons and regularly hosts town activities such as movies in the park.",
            "machell1.jpg",
            strings13);

    private String[] strings14 = {"1 Senior/junior playground","Splash Pad","1 Half Basketball Court","2 Pickle Ball Courts","Gazebo","Washroom facilities","16 car paved parking facility"};
    public Park park14 = new Park("Trent Park",
            new LatLng(44.027091, -79.440546),
            "140 Thomas Phillips Dr.",
            "This 5 acre park features:",
            "trent1.png",
            strings14);

    private String[] strings15 = {"1 softball facility","1 soccer facility","1 two-court lighted tennis facility"};
    public Park park15 = new Park("Norm Weller Park",
            new LatLng(43.971973, -79.483187),
            "250 McClellan Way",
            "Named after former town councillor and Director of Parks Norm Weller, this 5.8 acre park features:",
            "normweller1.jpg",
            strings15);

    private String[] strings16 = {"1 Artificial Turf soccer facility","10 soccer facilities","Picnic shelter","Washroom facility and concession stand","Trail entrance to Tim Jones Trail & Klaus Wehrenberg Trail","Vita Parcour fitness trail","156 car parking facility (2 lots)"};
    public Park park16 = new Park("Sheppard's Bush",
            new LatLng(43.997771, -79.455422),
            "93 & 93A Industrial Pkwy S",
            "Sheppard’s Bush Conservation Area is a 65 acre park with over three kilometres of hiking trails, eleven soccer fields, exercise equipment, two picnic pavilions and several historic buildings including a maple syrup evaporator hut and the Sheppard family house. It is also home to the AFC’s state of the art turf field and is a central hub for many of Aurora’s trails.",
            "sheppard1.jpg",
            strings16);

    private String[] strings17 = {"1 Baseball diamond","Fully equipped turf field","Outdoor Parking space","Playground","Shade structure","Outdoor bathroom facilities"};
    public Park park17 = new Park("Stewart Burnett Park",
            new LatLng(44.012507, -79.422859),
            "1344 Wellington St., East (SARC Recreation Complex)",
            "Stewart Burnett park is the newest turf field in the AFC’s outdoor lineup. This beautiful 18 acre park features:",
            "stewart1.jpg",
            strings17);

    private String[] strings18 = {"1 Senior/junior playground","1 Full basketball court","1 softball facility","1 soccer facility","1 two-court lighted tennis facility","20 car paved parking facility"};
    public Park park18 = new Park("Summit Park",
            new LatLng(44.002897, -79.490417),
            "267 Orchard Heights Boulevard",
            "Spanning 7.9 acres, this park features:",
            "summit1.PNG",
            strings18);

    private String[] strings19 = {"1 Senior/junior playground","Walking trail","Open play area","1 basketball court","1 tennis court","1 pickleball court"};
    public Park park19 = new Park("Thomas Coates Park",
            new LatLng(44.014775, -79.438105),
            "234 Mavrinac Boulevard",
            "Thomas Coates park is the newest park to be opened in the town of Aurora. This 6 acre park features:",
            "thomas1.jpg",
            strings19);

    private String[] strings20 = {"1 softball facility","2 soccer facilities","Bandshell","Washroom facilities","1 Senior/junior playground","Splash Pad","1 Natural outdoor ice rink"};
    public Park park20 = new Park("Town Park",
            new LatLng(43.998217, -79.462324),
            "49 Wells St.",
            "Town Park is home to many historical structures including the Aurora Armoury and an outdoor concert venue. This park is equipped with:",
            "town1.jpg",
            strings20);

    private String[] strings21 = {"Have fun!"};
    public Park park21 = new Park("Vandorf Woodlot",
            new LatLng(43.991110, -79.445899),
            "200 Vandorf Side Rd. & 422 Stone Rd.",
            "Vandorf Woodlot is a 66.5  acre conservation area that serves as a wildlife sanctuary and a hiking trail space.",
            "vandorf1.jpg",
            strings21);

    private Trail[] trailList = {trail1, trail2, trail3, trail4, trail5, trail6, trail7};
    private Park[] parkList = {park1, park2, park3, park4, park5, park6, park7, park8, park9, park10, park11, park12, park13, park14
            , park15, park16, park17, park18, park19, park20, park21};

//    private void createIcon() {
//        MenuView.ItemView item = findViewById(R.id.trail)
//        if (trail.getFavorite()) {
//            item.ico
//        }
//    }

}
