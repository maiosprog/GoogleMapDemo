package com.abc.googlemapdemo;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

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
        GoogleMap mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        LatLng rtvLiberia = new LatLng(10.6088762, -85.4326206);
        mMap.addMarker(new MarkerOptions().position(rtvLiberia).title("RTV Liberia"))
                .setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rtvLiberia));

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(10.6088762, -85.4326206, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Add this code.
        Address obj = addresses.get(0);
        System.out.println("*****************************************************");
        System.out.println(obj.getCountryName() + " - "+ obj.getCountryCode()
                + "- " + obj.getAddressLine(0) +" - "+ obj.getLocality() + "-"
                + obj.getSubLocality() + "-" + obj.getSubAdminArea() );
    }
}
