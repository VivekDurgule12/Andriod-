package com.example.a10expsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText name, contact, dob;
    Button insert, update, delete, view, clear;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        dob = findViewById(R.id.dob);
        insert = findViewById(R.id.insert);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        view = findViewById(R.id.view);
        clear = findViewById(R.id.clear);

        // Open or create database
        db = openOrCreateDatabase("studentDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(name VARCHAR, contact VARCHAR, dob VARCHAR);");

        // Insert Record
        insert.setOnClickListener(v -> {
            if (name.getText().toString().trim().isEmpty() ||
                    contact.getText().toString().trim().isEmpty() ||
                    dob.getText().toString().trim().isEmpty()) {
                Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }
            ContentValues values = new ContentValues();
            values.put("name", name.getText().toString().trim());
            values.put("contact", contact.getText().toString().trim());
            values.put("dob", dob.getText().toString().trim());
            db.insert("student", null, values);
            Toast.makeText(MainActivity.this, "Record added", Toast.LENGTH_SHORT).show();
            clearFields();
        });

        // View Record
        view.setOnClickListener(v -> {
            String searchName = name.getText().toString().trim();
            if (searchName.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter a name to search", Toast.LENGTH_SHORT).show();
                return;
            }
            Cursor c = db.rawQuery("SELECT * FROM student WHERE name = ?", new String[]{searchName});
            if (c.moveToFirst()) {
                contact.setText(c.getString(1));
                dob.setText(c.getString(2));
            } else {
                Toast.makeText(MainActivity.this, "No record found", Toast.LENGTH_SHORT).show();
            }
            c.close();
        });

        // Update Record
        update.setOnClickListener(v -> {
            String searchName = name.getText().toString().trim();
            if (searchName.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter a name to update", Toast.LENGTH_SHORT).show();
                return;
            }
            Cursor c = db.rawQuery("SELECT * FROM student WHERE name = ?", new String[]{searchName});
            if (c.moveToFirst()) {
                ContentValues values = new ContentValues();
                values.put("contact", contact.getText().toString().trim());
                values.put("dob", dob.getText().toString().trim());
                db.update("student", values, "name = ?", new String[]{searchName});
                Toast.makeText(MainActivity.this, "Record updated successfully", Toast.LENGTH_SHORT).show();
                clearFields();
            } else {
                Toast.makeText(MainActivity.this, "No record found to update", Toast.LENGTH_SHORT).show();
            }
            c.close();
        });

        // Clear Fields
        clear.setOnClickListener(v -> clearFields());
    }

    private void clearFields() {
        name.setText("");
        contact.setText("");
        dob.setText("");
    }
}
