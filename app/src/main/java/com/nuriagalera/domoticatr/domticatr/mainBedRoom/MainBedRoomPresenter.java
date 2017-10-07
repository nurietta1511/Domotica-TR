package com.nuriagalera.domoticatr.domticatr.mainBedRoom;

import android.support.annotation.NonNull;

public class MainBedRoomPresenter implements MainBedRoomContract.Presenter {

    private final MainBedRoomContract.View mMainView;

    public MainBedRoomPresenter(@NonNull MainBedRoomContract.View mainView) {
        mMainView = mainView;

        mMainView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}