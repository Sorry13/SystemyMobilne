package com.example.zad8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.view.MenuItem;
import android.widget.TextView;

public class SensorDetailsActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor sensorLight;
    private TextView sensorLightTextView;
    private TextView sensorNameTextView;
    public static final String EXTRA_SENSOR = "EXTRA_SENSOR_TYPE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_details);

        sensorLightTextView = findViewById(R.id.sensor_light_label);
        sensorNameTextView = findViewById(R.id.sensor_name);

        int sensorType = getIntent().getIntExtra(EXTRA_SENSOR, Sensor.TYPE_LIGHT);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorLight = sensorManager.getDefaultSensor(sensorType);


        if (sensorLight == null) {
            sensorLightTextView.setText(R.string.missing_sensor);
        } else { sensorNameTextView.setText(sensorLight.getName()); }
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (sensorLight != null) {
            sensorManager.registerListener(this, sensorLight, sensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();
        float currentValue = event.values[0];

        switch (sensorType) {
            case Sensor.TYPE_LIGHT:
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                sensorLightTextView.setText(getResources().getString(R.string.Sensors_label, currentValue));
                break;
            default:
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}