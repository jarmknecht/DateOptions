package com.example.jonathan.dateoptions;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private DateInfo date;
    private RatingBar rating;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        date = (DateInfo) getIntent().getSerializableExtra("serialize_data");
        rating = (RatingBar)findViewById(R.id.ratingBarMap);
        submit = (Button)findViewById(R.id.ratingButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i < DateApp.getInstance().getDates().size(); i++)
                {
                    if(date.getName().equals(DateApp.getInstance().getDates().get(i).getName()))
                    {
                        DateApp.getInstance().getDates().get(i).addRating((int)rating.getRating());
                    }
                }
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        date = (DateInfo) getIntent().getSerializableExtra("serialize_data");
        mMap.setMinZoomPreference(15);
        LatLng location = new LatLng(date.getLatitude(),date.getLongitude());
        //change marker to be accent color
        mMap.addMarker(new MarkerOptions().position(location).title(date.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
    }
}
