package com.example.hrpdasboard;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeArrayAdapter extends ArrayAdapter {

    Activity context = null;
    ArrayList<Employee> myArray = null;
    int layoutId;

    public EmployeeArrayAdapter(Activity context, int layoutId, ArrayList<Employee> arrayList) {
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

        TextView nameTextView = convertView.findViewById(R.id.text_name);
        TextView salaryTextView = convertView.findViewById(R.id.text_salary);
        View percentBar = convertView.findViewById(R.id.percent_bar);
        TextView percentNumber = convertView.findViewById(R.id.percent_number);

        Employee e = myArray.get(position);

        nameTextView.setText(e.getName());
        salaryTextView.setText(e.getSalary()/1000+"");
        percentNumber.setText((position+1)*10 + "%");

        Random r = new Random();
//        int percent = r.nextInt(100) + 1;
        int percent = (position+1)*10;
        ViewGroup.LayoutParams params = percentBar.getLayoutParams();
        int fullWidth = params.width;
        params.width = (int)((float)fullWidth/100 * percent);
        percentBar.setLayoutParams(params);

        return convertView;
    }
}
