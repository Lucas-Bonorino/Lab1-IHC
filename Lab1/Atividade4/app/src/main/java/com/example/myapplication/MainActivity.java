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
    private Sensor luminosidade;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ManejadorDoSensor = (SensorManager)getSystemService(SENSOR_SERVICE);
        luminosidade=ManejadorDoSensor.getDefaultSensor(Sensor.TYPE_LIGHT);
        TextView lumos=(TextView)findViewById(R.id.Valor_Lumos);
        if(luminosidade != null)
          {
            ManejadorDoSensor.registerListener(MainActivity.this, luminosidade, SensorManager.SENSOR_DELAY_NORMAL);
          }
        else
          {
            lumos.setText("Sem suporte a sensores de luminosidade");
          }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int Accuracy)
    {

    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
     if(event.sensor.getType()==Sensor.TYPE_LIGHT)
       {
           TextView lumos=(TextView)findViewById(R.id.Valor_Lumos);
           lumos.setText("Intensidade Luminosa: "+event.values[0]);
       }
    }

}