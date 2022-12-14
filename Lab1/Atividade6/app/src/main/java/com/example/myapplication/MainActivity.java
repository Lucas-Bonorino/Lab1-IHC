package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);

    }

    public void GPS(View view)
    {
      GPSTracker gps=new GPSTracker(getApplicationContext());
      Location l=gps.getLocation();

      TextView texto=findViewById(R.id.LL);

      texto.setVisibility(View.VISIBLE);
      if(l!=null)
      {
          texto.setText("Latitude: "+l.getLatitude()+"\nLongitude: "+l.getLongitude());
      }
      else
      {
        texto.setText("Nenhuma informacao de posicao geografica encontrada");
      }

    }
}