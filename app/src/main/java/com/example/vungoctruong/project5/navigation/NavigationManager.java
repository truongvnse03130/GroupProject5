package com.example.vungoctruong.project5.navigation;

import android.support.v4.app.Fragment;

import com.example.vungoctruong.project5.R;
import com.example.vungoctruong.project5.activity.MainActivity;

/**
 * Created by Vu Ngoc Truong on 5/16/2016.
 */
public class NavigationManager {
    private MainActivity mainActivity;

    public NavigationManager(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void displayFragment(Fragment fragment) {
        mainActivity.getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).addToBackStack(null).commit();
    }
}
