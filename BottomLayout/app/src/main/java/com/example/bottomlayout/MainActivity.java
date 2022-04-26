package com.example.bottomlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;
    private HomeFragment homeFragment;
    private ProfileFragment profileFragment;
    private SettingsFragment settingsFragment;

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);
        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        homeFragment = new HomeFragment();
        profileFragment = new ProfileFragment();
        settingsFragment = new SettingsFragment();

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.error:
                        mMainNav.setItemBackgroundResource(R.color.purple_200);
                        setFragment(homeFragment);
                        return true;
                    case R.id.photo:
                        mMainNav.setItemBackgroundResource(R.color.purple_500);
                        setFragment(profileFragment);
                        return true;
                    case R.id.electric:
                        mMainNav.setItemBackgroundResource(R.color.purple_700);
                        setFragment(settingsFragment);
                        return true;
                }
                return false;
            }
        });

    }
}