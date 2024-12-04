package com.example.mini_projet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.*;
import java.util.ArrayList;

public class CarListActivity extends AppCompatActivity {
    private DatabaseReference dbRef;
    private ArrayList<Car> carList = new ArrayList<>();
    private CarAdapter carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);

        ListView listView = findViewById(R.id.carListView);
        carAdapter = new CarAdapter(this, carList);
        listView.setAdapter(carAdapter);

        dbRef = FirebaseDatabase.getInstance().getReference("cars");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                carList.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Car car = postSnapshot.getValue(Car.class);
                    carList.add(car);
                }
                carAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Handle error
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Car selectedCar = carList.get(position);
            Intent intent = new Intent(CarListActivity.this, CarDetailsActivity.class);
            intent.putExtra("carId", selectedCar.getId());
            startActivity(intent);
        });
    }
}
