package com.nuriagalera.domoticatr.domticatr.main;

import android.support.annotation.NonNull;

import com.nuriagalera.domoticatr.domticatr.util.Bluethooth;

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View mMainView;

    public MainPresenter(@NonNull MainContract.View mainView) {
        mMainView = mainView;

        mMainView.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void startBluethoothConnection() {
        Bluethooth.getInstance();
    }
}
