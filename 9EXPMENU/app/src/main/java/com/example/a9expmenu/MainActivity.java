package com.example.a9expmenu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize TextView
        textView = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu); // Inflate the menu
        return true; // Return true to display the menu
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_profile:
                textView.setText("Profile Selected");
                Toast.makeText(this, "Profile Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_settings:
                textView.setText("Settings Selected");
                Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_exit:
                textView.setText("Exit Selected");
                Toast.makeText(this, "Exit Selected", Toast.LENGTH_SHORT).show();
                finish(); // Exit the app
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
