package com.example.non_jid.tabapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ShowDetailActivity extends FragmentActivity implements OnMapReadyCallback {

    //Explicit
    private GoogleMap mMap;
    private String shopString, addressString, phoneString, promoteString, latString, lngString;
    private TextView shopTextView, addressTextView, phoneTextView, promoteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_show_detail);

        //Bind Widget
        bindWidget();

        //show Text
        showText();


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }//onCreate

    public void clickBackShowDetail(View view) {
        finish();
    }


    private void showText() {

        shopString = getIntent().getStringExtra("Shop");
        addressString = getIntent().getStringExtra("Address");
        phoneString = getIntent().getStringExtra("Phone");
        promoteString = getIntent().getStringExtra("Promote");

        shopTextView.setText(shopString);
        addressTextView.setText("ที่อยู่ : " + addressString);
        phoneTextView.setText("เบอร์โทร : " + phoneString);
        promoteTextView.setText("โปรโมชั่น : " + promoteString);

    }

    private void bindWidget() {

        shopTextView = (TextView) findViewById(R.id.txShop);
        addressTextView = (TextView) findViewById(R.id.txAddress);
        phoneTextView = (TextView) findViewById(R.id.txPhone);
        promoteTextView = (TextView) findViewById(R.id.txPromote);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }//onMapReady
}//Main Class
