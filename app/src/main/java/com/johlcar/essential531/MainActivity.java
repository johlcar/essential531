package com.johlcar.essential531;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.johlcar.essential531.db.TrainingCyclesDatabase;
import com.johlcar.essential531.ui.CurrentTrainingCycleMenuFragment;
import com.johlcar.essential531.ui.PastTrainingCyclesListFragment;
import com.johlcar.essential531.ui.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    private boolean TRAINING_CYCLES_SHOWN = true;
    private Fragment shownFragment;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        initView();

        if (savedInstanceState == null) {
            showFragment(CurrentTrainingCycleMenuFragment.newInstance());
        }
    }

    private void initView() {

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        drawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        switch (menuItem.getItemId()) {
                            case R.id.nav_past_training_cycle:
                                TRAINING_CYCLES_SHOWN = true;
                                showFragment(PastTrainingCyclesListFragment.newInstance());
                                return true;
                            case R.id.nav_current_training_cycle:
                                TRAINING_CYCLES_SHOWN = false;
                                showFragment(CurrentTrainingCycleMenuFragment.newInstance());
                                return true;
                            case R.id.nav_settings:
                                TRAINING_CYCLES_SHOWN = false;
                                showFragment(SettingsFragment.newInstance());
                                return true;
                        }

                        return true;
                    }
                });

    }

    private void showFragment(final Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.commitNow();
        shownFragment = fragment;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void deleteCurrentListData() {
        if (TRAINING_CYCLES_SHOWN) {
            ((PastTrainingCyclesListFragment) shownFragment).removeData();
        }
    }

    private void reCreateDatabase() {
        TrainingCyclesDatabase.getDatabase(this).clearDb();
    }

}
