package com.example.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.finalproject.fragments.HomeFragment;
import com.example.finalproject.fragments.ProfileFragment;

public class Home_screen extends AppCompatActivity {

    private ImageView navHome, navProfile;
    private View indicatorHome, indicatorProfile;

    public static final int TAB_HOME = 0;
    public static final int TAB_PROFILE = 1;
    private int currentTab = TAB_HOME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        navHome = findViewById(R.id.nav_home);
        navProfile = findViewById(R.id.nav_profile);
        indicatorHome = findViewById(R.id.indicator_home);
        indicatorProfile = findViewById(R.id.indicator_profile);

        if (savedInstanceState == null) {
            replace(new HomeFragment(), false);
            showHomeIndicator();
        } else {
            currentTab = savedInstanceState.getInt("currentTab", TAB_HOME);
            if (currentTab == TAB_PROFILE) showProfileIndicator(); else showHomeIndicator();
        }

        navHome.setOnClickListener(v -> switchTo(TAB_HOME));
        navProfile.setOnClickListener(v -> switchTo(TAB_PROFILE));
    }

    public void switchTo(int tab) {
        if (currentTab == tab) return;
        Fragment f = (tab == TAB_PROFILE) ? new ProfileFragment() : new HomeFragment();
        replace(f, true);
        if (tab == TAB_PROFILE) showProfileIndicator(); else showHomeIndicator();
        currentTab = tab;
    }

    private void replace(Fragment f, boolean animate) {
        androidx.fragment.app.FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.setReorderingAllowed(true);
        if (animate) {
            tx.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        }
        tx.replace(R.id.fragment_container, f).commit();
    }

    private void showHomeIndicator() {
        indicatorHome.setVisibility(View.VISIBLE);
        indicatorProfile.setVisibility(View.GONE);
    }

    private void showProfileIndicator() {
        indicatorHome.setVisibility(View.GONE);
        indicatorProfile.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle out) {
        super.onSaveInstanceState(out);
        out.putInt("currentTab", currentTab);
    }

    // يستدعى من ProfileFragment (زر الرجوع في الهيدر)
    public void goToHome() {
        switchTo(TAB_HOME);
    }
}
