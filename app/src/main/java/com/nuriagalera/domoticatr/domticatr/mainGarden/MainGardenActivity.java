package com.nuriagalera.domoticatr.domticatr.mainGarden;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nuriagalera.domoticatr.domticatr.R;
import com.nuriagalera.domoticatr.domticatr.util.ActivityUtils;

public class MainGardenActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        setContentView(R.layout.maingarden_act);
        MainGardenFragment mainGardenFragment = (MainGardenFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mainGardenContentFrame);
        if (mainGardenFragment == null) {
            mainGardenFragment = MainGardenFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    mainGardenFragment, R.id.mainGardenContentFrame);
        }
        new MainGardenPresenter(mainGardenFragment);

   }

}


