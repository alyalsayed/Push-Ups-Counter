package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private int counter;
    private TextView sensorStatus;
    private TextView lightintensity;
    private TextView lightstatus;
    private TextView proximitystatus;
    private SensorManager sensorManager;
    Sensor proximitySensor;
    Sensor lightSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorStatus = findViewById(R.id.sensorStatus);
        lightintensity = findViewById(R.id.tv);
        lightstatus = findViewById(R.id.lightstatus);
        proximitystatus = findViewById(R.id.proximitystatus);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        counter = 0;
        setTitle("Push up App");
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            int light_value = (int) event.values[0];
            if (light_value > 255)
                light_value = 255;
            lightintensity.setTextColor(Color.rgb(255 - light_value, 255 - light_value, 255 - light_value));
            lightintensity.setBackgroundColor(Color.rgb(light_value, light_value, light_value));
            if (light_value == 0)
                lightstatus.setText("Light Status : Dark");
            else if (light_value > 0 && light_value <= 150)
                lightstatus.setText("Light Status : Medium");
            else
                lightstatus.setText("Light Status : Light");
        }
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            int proximity_value = (int) event.values[0];
            if (proximity_value > 1)
                proximity_value = 1;
            counter += proximity_value;
            sensorStatus.setText(String.valueOf(counter));
            Toast.makeText(this, "Counting by Sensor", Toast.LENGTH_SHORT).show();
            if (proximity_value == 0)
                proximitystatus.setText("proximity Status : Near");
            else
                proximitystatus.setText("proximity Status : Far");
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
    public void count(View v) {
        counter += 1;
        sensorStatus.setText(String.valueOf(counter));
        Toast.makeText(this, "Counting by button", Toast.LENGTH_SHORT).show();
    }

    public void reset(View v) {
        counter = 0;
        sensorStatus.setText(String.valueOf(counter));
    }
    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY), SensorManager.SENSOR_DELAY_UI
        );
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_UI
        );
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
