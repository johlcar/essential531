package com.johlcar.essential531;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.johlcar.essential531.db.TrainingCyclesDatabase;
import com.johlcar.essential531.view.PastTrainingCyclesListFragment;
import com.johlcar.essential531.view.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    private boolean TRAINING_CYCLES_SHOWN = true;
    private Fragment shownFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar(getString(R.string.app_name));
        initView();

        if (savedInstanceState == null){
            showFragment(PastTrainingCyclesListFragment.newInstance());
        }
    }

    public void setToolbar(@NonNull String title){
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
    }

    private void initView() {
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_past_training_cycles:
                        TRAINING_CYCLES_SHOWN = true;
                        showFragment(PastTrainingCyclesListFragment.newInstance());
                        return true;
                    case R.id.navigation_settings:
                        TRAINING_CYCLES_SHOWN = false;
                        showFragment(SettingsFragment.newInstance());
                        return true;
                }
                return false;
            }
        });
    }

    private void showFragment(final Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentHolder, fragment);
        fragmentTransaction.commitNow();
        shownFragment = fragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        final int id = item.getItemId();

        if (id == R.id.action_delete_list_data) {
            deleteCurrentListData();
            return true;
        } else if (id == R.id.action_re_create_database) {
            reCreateDatabase();
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
