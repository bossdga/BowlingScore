package com.paradoxcat.bowlingscore.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import com.paradoxcat.bowlingscore.R;
import com.paradoxcat.bowlingscore.ui.fragment.MainFragment;

/**
 * Activity that will show a list of blacklisted apps, add new apps to the black list and start/stop
 * a background service to check which app is on the foreground
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpActionBar(R.string.title_activity_main, false);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainFragment fragment = new MainFragment();
                fragment.startBowlingGame();
            }
        });
    }

}