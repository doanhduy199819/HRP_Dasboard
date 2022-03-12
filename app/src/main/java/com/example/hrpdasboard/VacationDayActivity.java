package com.example.hrpdasboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.UUID;

public class VacationDayActivity extends AppCompatActivity {

    ListView totalListView;
    ArrayList<Employee> employeesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation_day);

        setUp();
    }
    private void setUp() {
        employeesList = new ArrayList<>();
        for (int i=0; i<5; i++) {
            employeesList.add(new Employee(UUID.randomUUID(), "Nguyen Van " + (char)('A' + i), "A" + (i%2), 3+i));
        }

        totalListView = findViewById(R.id.listview_vacation_day);
        VacationArrayAdapter adapter = new VacationArrayAdapter(this, R.layout.list_item_vacation, employeesList);
        totalListView.setAdapter(adapter);
        totalListView.setDivider(null);
    }
}