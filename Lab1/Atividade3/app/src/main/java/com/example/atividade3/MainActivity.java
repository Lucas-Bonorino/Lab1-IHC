package com.example.atividade3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.hardware.SensorManager;
import android.hardware.Sensor;
import android.widget.TextView;
import java.lang.Math;
import java.lang.Float;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager ManejamentoDoSensor;
    private Sensor Acelerometro;
    static float VelhoX=0, VelhoY=0, VelhoZ=0, threshold=1.0f;
    static Boolean AvancarX=false, AvancarY=false, AvancarZ=false;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        ManejamentoDoSensor=(SensorManager)getSystemService(SENSOR_SERVICE);
        Acelerometro=ManejamentoDoSensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        ManejamentoDoSensor.registerListener(this, Acelerometro, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        ManejamentoDoSensor.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {

        if(event.sensor.getType()== Sensor.TYPE_ACCELEROMETER)
        {
            float sensorX = event.values[0];
            float sensorY = event.values[1];
            float sensorZ = event.values[2];

            TextView aEditar=(TextView)findViewById(R.id.X);
            aEditar.setText(String.valueOf(sensorX));

            aEditar=(TextView)findViewById(R.id.Y);
            aEditar.setText(String.valueOf(sensorY));

            aEditar=(TextView)findViewById(R.id.Z);
            aEditar.setText(String.valueOf(sensorZ));

            float deltaX=VelhoX-sensorX,deltaY=VelhoY-sensorY, deltaZ=VelhoZ-sensorZ;

            if(Float.compare(Math.abs(deltaX), threshold)>=0)
              {
               AvancarX=true;
               VelhoX=sensorX;
              }

            if(Float.compare(Math.abs(deltaY), threshold)>=0)
            {
                AvancarY=true;
                VelhoY=sensorY;
            }

            if(Float.compare(Math.abs(deltaZ), threshold)>=0)
            {
                AvancarZ=true;
                VelhoZ=sensorZ;
            }

            if(AvancarX || AvancarY || AvancarZ)
              {
                  AvancarX=false;
                  AvancarY=false;
                  AvancarZ=false;
                  Intent i=new Intent(this, MainActivity2.class);
                  startActivity(i);
              }

        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int Accuracy)
    {

    }

}