package com.nuriagalera.domoticatr.domticatr.mainBedRoom;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nuriagalera.domoticatr.domticatr.R;
import com.nuriagalera.domoticatr.domticatr.util.ActivityUtils;

public class MainBedRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainbedroom_act);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MainBedRoomFragment mainBedRoomFragment = (MainBedRoomFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mainBedRoomContentFrame);

        if (mainBedRoomFragment == null) {
            mainBedRoomFragment = MainBedRoomFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    mainBedRoomFragment, R.id.mainBedRoomContentFrame);
        }

        // Create the presenter
        new MainBedRoomPresenter(mainBedRoomFragment);
    }
}
