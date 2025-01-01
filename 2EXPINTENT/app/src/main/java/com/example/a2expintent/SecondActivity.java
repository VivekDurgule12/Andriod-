package com.example.a2expintent;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a2expintent.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = findViewById(R.id.textView);

        // Retrieve the data from the Intent
        String receivedData = getIntent().getStringExtra("data_key");

        // Display the received data
        textView.setText(receivedData);
    }
}
