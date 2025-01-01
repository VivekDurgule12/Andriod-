package com.example.a2expintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a2expintent.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve user input
                String userInput = editText.getText().toString();

                // Create an Intent to navigate to SecondActivity
                // Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);

                // Pass the data using Intent
                intent.putExtra("data_key", userInput);

                // Start the second activity
                startActivity(intent);
            }
        });
    }
}
