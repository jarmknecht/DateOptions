package com.example.jonathan.dateoptions;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private DateInfo date;
    private TextView dateName;
    private RatingBar rating;
    private Button submit;
    private TextView description;

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
        rating.setRating(date.getRating());
        dateName = (TextView)findViewById(R.id.textMap);
        dateName.setText(date.getName());
        description = (TextView)findViewById(R.id.descriptionMap);
        description.setText(date.getDescription());
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
                finish();
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        int height = 300;
        int width = 150;
        BitmapDrawable myMarker = (BitmapDrawable)getResources().getDrawable(R.drawable.app_icon);
        Bitmap bMap = myMarker.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(bMap, width, height, false);
        mMap = googleMap;
        date = (DateInfo) getIntent().getSerializableExtra("serialize_data");
        LatLng location = new LatLng(date.getLatitude(),date.getLongitude());
        mMap.addMarker(new MarkerOptions().position(location).title(date.getName()).icon
                (BitmapDescriptorFactory.fromBitmap(smallMarker))).showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
    }
}
