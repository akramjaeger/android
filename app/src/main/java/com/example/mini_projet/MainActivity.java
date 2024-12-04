package com.example.mini_projet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        Button btnCarList = findViewById(R.id.btnCarList);
        btnCarList.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CarListActivity.class);
            startActivity(intent);
        });

    }
}
