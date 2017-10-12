package com.nuriagalera.domoticatr.domticatr.mainGarden;

/**
 * Created by nuria_4fhc69h on 09/10/2017.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nuriagalera.domoticatr.domticatr.R;

public class MainGardenFragment extends Fragment implements MainGardenContract.View {
    private MainGardenContract.Presenter mPresenter;

    public static com.nuriagalera.domoticatr.domticatr.mainGarden.MainGardenFragment newInstance() {
        com.nuriagalera.domoticatr.domticatr.mainGarden.MainGardenFragment fragment = new com.nuriagalera.domoticatr.domticatr.mainGarden.MainGardenFragment();
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.mainbedroom_frag, container, false);
        return root;
    }

    @Override
    public void setPresenter(MainGardenContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
