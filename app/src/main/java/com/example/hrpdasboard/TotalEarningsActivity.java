package com.example.hrpdasboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.UUID;

public class TotalEarningsActivity extends AppCompatActivity {

    ListView totalListView;
    ArrayList<Employee> employeesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_earnings);

        setUp();
    }
    private void setUp() {
        employeesList = new ArrayList<>();
        for (int i=0; i<5; i++) {
            employeesList.add(new Employee(UUID.randomUUID(), "Nguyen Van " + (char)('A' + i), "A" + (i%2), 2000000));
        }

        totalListView = findViewById(R.id.listview_total_earnings);
        EmployeeArrayAdapter adapter = new EmployeeArrayAdapter(this, R.layout.total_earnings_list_item, employeesList);
        totalListView.setAdapter(adapter);
        totalListView.setDivider(null);
    }
}