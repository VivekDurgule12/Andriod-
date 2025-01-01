package com.example.a6expexplicit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button explicitIntentButton = findViewById(R.id.explicitIntentButton);
        Button implicitIntentButton = findViewById(R.id.implicitIntentButton);

        // Explicit Intent to navigate to SecondActivity
        explicitIntentButton.setOnClickListener(v -> {
            Intent explicitIntent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(explicitIntent);
        });

        // Implicit Intent to open a web page
        implicitIntentButton.setOnClickListener(v -> {
            Intent implicitIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vivekdurgule.vercel.app"));
            startActivity(implicitIntent);
        });
    }
}