package com.nuriagalera.domoticatr.domticatr.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nuriagalera.domoticatr.domticatr.R;
import com.nuriagalera.domoticatr.domticatr.util.ActivityUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        MainFragment mainFragment = (MainFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mainContentFrame);

        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    mainFragment, R.id.mainContentFrame);
        }

        // Create the presenter
        new MainPresenter(mainFragment);
    }
}
