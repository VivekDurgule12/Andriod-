package com.example.toastshowing;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.toastshowing.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonShowToast = findViewById(R.id.buttonShowToast);
        buttonShowToast.setOnClickListener(view ->
                Toast.makeText(MainActivity.this, "This is a Toast message!", Toast.LENGTH_SHORT).show()
        );
    }
}
