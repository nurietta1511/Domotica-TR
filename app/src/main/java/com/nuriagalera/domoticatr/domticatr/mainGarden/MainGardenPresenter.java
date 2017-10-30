package com.nuriagalera.domoticatr.domticatr.mainGarden;

import android.support.annotation.NonNull;

import com.nuriagalera.domoticatr.domticatr.util.Bluethooth;

/**
 * Created by nuria_4fhc69h on 09/10/2017.
 */

public class MainGardenPresenter implements MainGardenContract.Presenter {
    private final MainGardenContract.View mMainView;

    public MainGardenPresenter(@NonNull MainGardenContract.View mainView) {
        mMainView = mainView;

        mMainView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void sendToBluethooth(int value) {
        Bluethooth.getInstance().write(value);
    }
}
