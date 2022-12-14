package com.example.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.content.ContextCompat;


public class GPSTracker implements LocationListener
{
    Context contexto;

    public GPSTracker(Context c)
    {
     contexto=c;
    }

    public Location getLocation()
    {
     if(ContextCompat.checkSelfPermission(contexto, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
     {
            Toast.makeText(contexto, "Permissao nao concedida", Toast.LENGTH_LONG).show();
            return null;
     }

     LocationManager lm = (LocationManager)contexto.getSystemService(Context.LOCATION_SERVICE);

     boolean isGPSEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);

     if(isGPSEnabled)
        {
         lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000, 10, this);
         Location l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
         return l;
        }

      return null;
    }

    @Override
    public void onLocationChanged(Location location)
    {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras)
    {

    }

    @Override
    public void onProviderEnabled(String provider)
    {

    }

    @Override
    public void onProviderDisabled(String provider)
    {

    }


}
