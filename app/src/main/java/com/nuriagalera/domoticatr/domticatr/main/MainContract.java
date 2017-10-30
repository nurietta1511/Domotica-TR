package com.nuriagalera.domoticatr.domticatr.main;

import com.nuriagalera.domoticatr.domticatr.BasePresenter;
import com.nuriagalera.domoticatr.domticatr.BaseView;

public interface MainContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
        void startBluethoothConnection();
    }
}
