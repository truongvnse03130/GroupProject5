package com.example.vungoctruong.project5.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vungoctruong.project5.navigation.NavigationManager;
import com.example.vungoctruong.project5.R;
import com.example.vungoctruong.project5.fragments.TeamFragment;

public class MainActivity extends AppCompatActivity {

    private NavigationManager mNavigationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNavigationManager = new NavigationManager(this);

        if (getSupportFragmentManager().findFragmentById(R.id.content_frame) == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new TeamFragment()).commit();
        }
    }

    public NavigationManager getNavigationManager() {
        return mNavigationManager;
    }
}
