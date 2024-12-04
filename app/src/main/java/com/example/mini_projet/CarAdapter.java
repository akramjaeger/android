package com.example.mini_projet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class CarAdapter extends ArrayAdapter<Car> {

    public CarAdapter(Context context, ArrayList<Car> cars) {
        super(context, 0, cars);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Car car = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.car_item, parent, false);
        }


        TextView txtCarName = convertView.findViewById(R.id.txtCarName);
        TextView txtCarType = convertView.findViewById(R.id.txtCarType);
        TextView txtCarPrice = convertView.findViewById(R.id.txtCarPrice);


        if (car != null) {
            txtCarName.setText(car.getName());
            txtCarType.setText(car.getType());
            txtCarPrice.setText(String.format("$%.2f per day", car.getPricePerDay()));
        }

        return convertView;
    }
}
