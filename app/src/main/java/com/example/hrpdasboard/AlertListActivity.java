package com.example.hrpdasboard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.PersistableBundle;

public class AlertListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new AlertListFragment();
    }
}