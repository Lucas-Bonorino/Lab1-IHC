package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener
{

    private SensorManager ManejadorDoSensor;
    private Sensor Temperatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ManejadorDoSensor = (SensorManager)getSystemService(SENSOR_SERVICE);
        Temperatura=ManejadorDoSensor.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        TextView temp=(TextView)findViewById(R.id.Temprature);
        if(Temperatura!=null)
          {
              ManejadorDoSensor.registerListener(MainActivity.this, Temperatura, SensorManager.SENSOR_DELAY_NORMAL);
          }
        else
          {
            temp.setText("Sensor de temperautra indisponivel");
          }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int Accuracy)
    {

    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        if(event.sensor.getType()==Sensor.TYPE_AMBIENT_TEMPERATURE)
        {
            TextView temp=(TextView)findViewById(R.id.Temprature);
            temp.setText("A temperatura ambiente: "+event.values[0]);
        }
    }
}