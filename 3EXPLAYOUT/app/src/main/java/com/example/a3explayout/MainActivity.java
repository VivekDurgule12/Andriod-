package com.example.a3explayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to the buttons
        Button redButton = findViewById(R.id.redButton);
        Button blueButton = findViewById(R.id.blueButton);
        Button greenButton = findViewById(R.id.greenButton);
        Button yellowButton = findViewById(R.id.yellowButton);

        // Set click listeners to change the background color
        redButton.setOnClickListener(v -> findViewById(R.id.relativeLayout).setBackgroundColor(Color.RED));
        blueButton.setOnClickListener(v -> findViewById(R.id.relativeLayout).setBackgroundColor(Color.BLUE));
        greenButton.setOnClickListener(v -> findViewById(R.id.linearLayout).setBackgroundColor(Color.GREEN));
        yellowButton.setOnClickListener(v -> findViewById(R.id.linearLayout).setBackgroundColor(Color.YELLOW));
    }
}