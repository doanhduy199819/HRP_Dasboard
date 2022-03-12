package com.example.hrpdasboard;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;

public class VacationArrayAdapter extends ArrayAdapter {

    Activity context = null;
    ArrayList<Employee> myArray = null;
    int layoutId;

    public VacationArrayAdapter(Activity context, int layoutId, ArrayList<Employee> arrayList) {
        super(context, layoutId, arrayList);

        this.context = context;
        this.layoutId = layoutId;
        this.myArray = arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        convertView = LayoutInflater.from(context).inflate(layoutId, null);

        TextView nameTextView = convertView.findViewById(R.id.txt_name);
        TextView vacationTextView = convertView.findViewById(R.id.txt_vacation_days);
        Employee e = myArray.get(position);

        nameTextView.setText(e.getName());
        vacationTextView.setText(1+position+2+"");

        return convertView;
    }
}
