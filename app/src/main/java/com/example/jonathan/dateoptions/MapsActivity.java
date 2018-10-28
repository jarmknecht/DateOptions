package com.example.jonathan.dateoptions;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private DateInfo date;
    private TextView dateName;
    private RatingBar rating;
    private Button submit;
    private TextView description;
    private TextView miles;
    private String escapedQuery = null;
    private RatingBar popupRating;
    private EditText userReview;
    private Button popupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        date = (DateInfo) getIntent().getSerializableExtra("serialize_data");
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.review_popup, null);
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        popupRating = (RatingBar)popupView.findViewById(R.id.popupRating);
        userReview = (EditText)popupView.findViewById(R.id.userReview);
        popupButton = (Button)popupView.findViewById(R.id.popupButton);
        rating = (RatingBar)findViewById(R.id.ratingBarMap);
        rating.setRating(date.getRating());
        dateName = (TextView)findViewById(R.id.textMap);
        dateName.setText(date.getName());
        dateName.setPaintFlags(dateName.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        description = (TextView)findViewById(R.id.descriptionMap);
        description.setText(date.getDescription());
        miles = (TextView)findViewById(R.id.miNumMap);
        CharSequence strmiles = date.getMiles() + " mi away";
        miles.setText(strmiles);
        submit = (Button)findViewById(R.id.ratingButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
                popupButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        for(int i = 0; i < DateApp.getInstance().getDates().size(); i++)
                        {
                            if(date.getName().equals(DateApp.getInstance().getDates().get(i).getName()))
                            {
                                DateApp.getInstance().getDates().get(i).addRating((int)popupRating.getRating());
                                DateApp.getInstance().getDates().get(i).addReview(userReview.getText().toString());
                                popupWindow.dismiss();
                            }
                        }
                        finish();
                    }
                });
            }
        });

        dateName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    escapedQuery = URLEncoder.encode(date.getName(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                Uri uri = Uri.parse("http://www.google.com/#q=" + escapedQuery);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
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
