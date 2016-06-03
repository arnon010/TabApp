package com.example.non_jid.tabapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class NewAddMap extends FragmentActivity implements OnMapReadyCallback {

    //explicit

    private GoogleMap mMap;
    private EditText shopEditext, addressEditext, promoteEditext, phoneEditext;
    private String shopString, addressString, promoteString, phoneString;
    private boolean clickMapABoolean = true;
    private double latADouble, lngADouble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_map);

        //bind widgit
        bindWidget();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    } //Main Method

    private void bindWidget() {
        shopEditext = (EditText) findViewById(R.id.edtShop);
        addressEditext = (EditText) findViewById(R.id.edtAddress);
        promoteEditext = (EditText) findViewById(R.id.edtPromote);
        phoneEditext = (EditText) findViewById(R.id.edtPhone);
    }

    public void clickUploadValueToServer(View view) {

        shopString = shopEditext.getText().toString().trim();
        addressString = addressEditext.getText().toString().trim();
        promoteString = promoteEditext.getText().toString().trim();
        phoneString = phoneEditext.getText().toString().trim();


        //check space
        if (checkSpace()) {
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "มีช่องว่าง", "กรุณากรอกทุกช่อง");
        } else if (clickMapABoolean) {
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "ยังไม่เลือกตำแหน่งของร้าน", "โปรดคลิกบนแผนที่เพื่อเลือกตำแหน่ง");
        } else {
            uploadValueToServer();
        }

    }   //clickUpload

    private void uploadValueToServer() {

        String urlUpLoad = "http://swiftcodingthai.com/non/add_shop_center.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("Shop", shopString)
                .add("Address", addressString)
                .add("Promote", promoteString)
                .add("Phone", phoneString)
                .add("Lat", Double.toString(latADouble))
                .add("Lng", Double.toString(lngADouble))
                .build();
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(urlUpLoad).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.d("3June", "e = " + e.toString());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                Log.d("3June", "ok");
            }
        });

        Toast.makeText(this, "อัพเดท ร้านเรียบร้อย", Toast.LENGTH_SHORT).show();
        finish();

    }   //upload

    private boolean checkSpace() {

        boolean result = true;

        result = shopString.equals("") ||
                addressString.equals("") ||
                promoteString.equals("") ||
                phoneString.equals("");

        return result;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Set Up center map
        LatLng latLng = new LatLng(13.661637,100.351777); // my home
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));

        //Click Able on map
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                if (clickMapABoolean) {
                    clickMapABoolean = false;
                }

                //Clear All Marker
                mMap.clear();

                //Create Marker
                mMap.addMarker(new MarkerOptions()
                .position(latLng));

                latADouble = latLng.latitude;
                lngADouble = latLng.longitude;

            } //OnMapClick
        });

    }// on Map Ready



} //Main Class
