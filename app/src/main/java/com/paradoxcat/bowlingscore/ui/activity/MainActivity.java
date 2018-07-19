package com.paradoxcat.bowlingscore.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.paradoxcat.bowlingscore.R;
import com.paradoxcat.bowlingscore.ui.fragment.MainFragment;

/**
 * Activity that will show a list of bowling frames scores
 */
public class MainActivity extends BaseActivity {

    private FragmentTransaction transaction;
    private Fragment fragment = new MainFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpActionBar(R.string.title_activity_main, false);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragments();
            }
        });
    }

    /**
     * Method that load the fragments
     */
    private void loadFragments() {
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.remove(fragment);
        fragment = new MainFragment();
        transaction.add(R.id.fragment_container, fragment);

        transaction.commit();
    }

}