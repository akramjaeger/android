package com.example.mini_projet;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditCarActivity extends AppCompatActivity {

    private EditText edtCarName, edtCarType, edtCarPrice;
    private Button btnSaveChanges;
    private String carId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_car);


        edtCarName = findViewById(R.id.edtCarName);
        edtCarType = findViewById(R.id.edtCarType);
        edtCarPrice = findViewById(R.id.edtCarPrice);
        btnSaveChanges = findViewById(R.id.btnSaveChanges);


        carId = getIntent().getStringExtra("carId");
        String carName = getIntent().getStringExtra("carName");
        String carType = getIntent().getStringExtra("carType");
        double carPrice = getIntent().getDoubleExtra("carPrice", 0.0);


        edtCarName.setText(carName);
        edtCarType.setText(carType);
        edtCarPrice.setText(String.valueOf(carPrice));

        btnSaveChanges.setOnClickListener(v -> {
            String updatedName = edtCarName.getText().toString();
            String updatedType = edtCarType.getText().toString();
            String priceInput = edtCarPrice.getText().toString();


            if (updatedName.isEmpty() || updatedType.isEmpty() || priceInput.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            double updatedPrice;
            try {
                updatedPrice = Double.parseDouble(priceInput);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid price format", Toast.LENGTH_SHORT).show();
                return;
            }


            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("cars").child(carId);
            Car updatedCar = new Car(carId, updatedName, updatedType, updatedPrice);
            dbRef.setValue(updatedCar).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(EditCarActivity.this, "Car details updated successfully", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(EditCarActivity.this, "Failed to update car details", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
