package com.nuriagalera.domoticatr.domticatr.mainBedRoom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nuriagalera.domoticatr.domticatr.R;

public class MainBedRoomFragment extends Fragment implements MainBedRoomContract.View {
    private MainBedRoomContract.Presenter mPresenter;

    public static MainBedRoomFragment newInstance() {
        MainBedRoomFragment fragment = new MainBedRoomFragment();
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
    public void setPresenter(MainBedRoomContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
