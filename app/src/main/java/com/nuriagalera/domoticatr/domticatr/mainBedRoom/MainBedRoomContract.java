package com.nuriagalera.domoticatr.domticatr.mainBedRoom;

import com.nuriagalera.domoticatr.domticatr.BasePresenter;
import com.nuriagalera.domoticatr.domticatr.BaseView;

public interface MainBedRoomContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
        void sendToBluethooth(int value);
    }
}
