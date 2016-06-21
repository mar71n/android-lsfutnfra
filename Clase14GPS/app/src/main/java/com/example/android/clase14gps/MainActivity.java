package com.example.android.clase14gps;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //  AIzaSyAvxZLeeQ9MbTU6XzzjDGrKe4F4SqrIk_E
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        LocationListener miLocListener = new GpsListener();

        try {

            locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, miLocListener);

        }catch(SecurityException e){}

    }
}
