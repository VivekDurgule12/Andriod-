package com.example.a5exptoggle;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        TextView stateTextView = findViewById(R.id.stateTextView);

        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // ToggleButton is ON
                stateTextView.setText("Toggle State: ON");
            } else {
                // ToggleButton is OFF
                stateTextView.setText("Toggle State: OFF");
            }
        });
    }
}