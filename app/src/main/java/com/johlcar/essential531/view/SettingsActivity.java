package com.johlcar.essential531.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.johlcar.essential531.R;

public class SettingsActivity extends AppCompatActivity {

    private static final String TAG = "SettingsActivity";

    EditText squatMax;
    EditText pressMax;
    EditText benchPressMax;
    EditText deadLiftMax;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        squatMax = findViewById(R.id.squat_max);
        pressMax = findViewById(R.id.press_max);
        benchPressMax = findViewById(R.id.bench_press_max);
        deadLiftMax = findViewById(R.id.dead_lift_max);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Save to database
                Log.d(TAG, "onClick: squatMax: " + squatMax.getText().toString());
            }
        });
    }
}
