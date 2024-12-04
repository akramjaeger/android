package com.example.mini_projet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CarDetailsActivity extends AppCompatActivity {

    private TextView txtCarName, txtCarType, txtCarPrice;
    private Button btnEditCar, btnDeleteCar;
    private String carId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);


        txtCarName = findViewById(R.id.txtCarName);
        txtCarType = findViewById(R.id.txtCarType);
        txtCarPrice = findViewById(R.id.txtCarPrice);
        btnEditCar = findViewById(R.id.btnEditCar);
        btnDeleteCar = findViewById(R.id.btnDeleteCar);


        Intent intent = getIntent();
        carId = intent.getStringExtra("carId");
        String carName = intent.getStringExtra("carName");
        String carType = intent.getStringExtra("carType");
        double carPrice = intent.getDoubleExtra("carPrice", 0.0);

        // Set car details in the views
        txtCarName.setText(carName);
        txtCarType.setText(carType);
        txtCarPrice.setText(String.format("$%.2f per day", carPrice));


        btnEditCar.setOnClickListener(v -> {
            Intent editIntent = new Intent(CarDetailsActivity.this, EditCarActivity.class);
            editIntent.putExtra("carId", carId);
            startActivity(editIntent);
        });

        // Delete car button
        btnDeleteCar.setOnClickListener(v -> {
            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("cars");
            dbRef.child(carId).removeValue();
            finish(); // Close activity after deletion
        });


        Intent editIntent = new Intent(CarDetailsActivity.this, EditCarActivity.class);
        editIntent.putExtra("carId", carId);
        editIntent.putExtra("carName", carName);
        editIntent.putExtra("carType", carType);
        editIntent.putExtra("carPrice", carPrice);
        startActivity(editIntent);

    }
}
