package com.example.non_jid.tabapp;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.InfoWindowAdapter {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setInfoWindowAdapter(this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);


        // Add a marker in Sydney and move the camera
        LatLng chorcharearn = new LatLng(13.677017, 100.345347);
        mMap.addMarker(new MarkerOptions().position(chorcharearn).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)).title("ช.เจริญ").snippet("099-247-8681 รับซ่อม มอเตอร์ไซด์ เปลี่ยนยางนอก ยางใน ภายนอกทุกชนิด"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chorcharearn, 16));
        LatLng teemotor = new LatLng(13.648967, 100.358780);
        mMap.addMarker(new MarkerOptions().position(teemotor).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)).title("ตี๋มอเตอร์").snippet("085-099-2428 รับซ่อม มอเตอร์ไซด์ เปลี่ยนยางนอก ยางใน ตัดโครง จำหน่ายอะไหล่"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(teemotor, 16));
        LatLng oomnoigroup = new LatLng(13.680842, 100.344788);
        mMap.addMarker(new MarkerOptions().position(oomnoigroup).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)).title("อ้อมน้อยกรุ๊บ").snippet("02-812-0545 รับซื้อ-ขาย-แลกเปลี่ยน จักรยานยนต์ทุกยี่ห้อ รับซื้อรถเก่าให้ราคาสูง www.omnoigroup.com"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(oomnoigroup, 16));
        LatLng winner = new LatLng(13.676687, 100.328693);
        mMap.addMarker(new MarkerOptions().position(winner).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)).title("วินเนอร์สวนหลวง").snippet("083-880-6823 จำหน่ายรถมอเตอร์ไซด์ ทุกรุ่น มือ 1 ต่อภาษี พรบ. โอนเล่ม แจ้งย้าย"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(winner, 16));
        LatLng nutjukyanyon = new LatLng(13.682513, 100.344012);
        mMap.addMarker(new MarkerOptions().position(nutjukyanyon).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)).title("นัทจักรยานยนต์").snippet("082-442-3857 จำหน่ายอะไหล่ และมอเตอร์ไซด์มือ2 รับประกันการใช้งาน1เดือนสำหรับซื้อมอเตอร์ไซด์จากทางร้าน"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nutjukyanyon, 16));
        LatLng porsukasame = new LatLng(13.705304, 100.337831);
        mMap.addMarker(new MarkerOptions().position(porsukasame).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)).title("ป.สุเกษม").snippet("02-420-4625 ผู้แทนจำหน่ายรถจักรยานยนต์ ศูนย์บริการมาตรฐานฮอนด้า พร้อมอะไหล่"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(porsukasame, 16));
        LatLng chakneak = new LatLng(13.708606, 100.338584);
        mMap.addMarker(new MarkerOptions().position(chakneak).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)).title("ช่างเหน่ง").snippet("02-810-6218 รับซ่อมมอเตอร์ไซด์ทุกชนิด"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chakneak, 16));
        LatLng chakland = new LatLng(13.709797, 100.337838);
        mMap.addMarker(new MarkerOptions().position(chakland).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)).title("ช่างล้าน").snippet("080-216-2195 รับซ่อมมอเตอร์ไซด์ทุกชนิด"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chakland, 16));
        LatLng chorkasame = new LatLng(13.658214, 100.353366);
        mMap.addMarker(new MarkerOptions().position(chorkasame).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)).title("ช.เกษม").snippet("02-878-7875 จำหน่ายรถจักรยานยนต์ทุกชนิด สด-ผ่อน ราคากันเอง"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chorkasame, 16));
        LatLng kasamecharearnyon = new LatLng(13.677218, 100.330860);
        mMap.addMarker(new MarkerOptions().position(kasamecharearnyon).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)).title("เกษมเจริญยนต์").snippet("02-811-1607 จำหน่ายรถจักรยานยนต์ มือ2 รับซ่อมมอเตอร์ไซด์ทุกชนิด"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kasamecharearnyon, 16));
        LatLng papas = new LatLng(13.677075, 100.330543);
        mMap.addMarker(new MarkerOptions().position(papas).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)).title("ปภัส เจริญยนต์").snippet("081-933-1149 รับซื้อ-ขายรถจักรยานยนต์ มือ2"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(papas, 16));
        LatLng myhome = new LatLng(13.661637, 100.351777);
        mMap.addMarker(new MarkerOptions().position(myhome).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)).title("My Home").snippet("บ้านของฉัน"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myhome, 14));


    }

    public void onZoom(View view) {
        if (view.getId() == R.id.btnZoomIn) {
            mMap.animateCamera(CameraUpdateFactory.zoomIn());
        }
        if (view.getId() == R.id.btnZoomOut) {
            mMap.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }


    @Override
    public View getInfoWindow(Marker marker) {

        View view = getLayoutInflater().inflate(R.layout.info_window, null);
        

        return view;

    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
