package com.example.hrpdasboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.Date;

public class NewEventActivity extends AppCompatActivity {

    private Button dateButton;
    private Button timeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        dateButton = findViewById(R.id.btn_date);
        timeButton = findViewById(R.id.btn_time);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                Date date = Calendar.getInstance().getTime();
                DatePickerFragment fragment = DatePickerFragment.newInstance(date);
                fragment.show(fm,"diaglog_date_show");
            }
        });
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                Date date = Calendar.getInstance().getTime();
                TimePickerFragment fragment = TimePickerFragment.newInstance(date);
                fragment.show(fm,"diaglog_time_show");
            }
        });
    }
}