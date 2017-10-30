package com.nuriagalera.domoticatr.domticatr.mainBedRoom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.nuriagalera.domoticatr.domticatr.R;
import com.nuriagalera.domoticatr.domticatr.util.CustomAdapter;

import java.util.ArrayList;
import java.util.HashMap;

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
        ListView listView = (ListView) root.findViewById(R.id.mainBedRoomListView);

        ArrayList<HashMap<CustomAdapter.DataAdapterValues, Object>> values = new ArrayList<HashMap<CustomAdapter.DataAdapterValues, Object>>(){{
            add(new HashMap<CustomAdapter.DataAdapterValues, Object>(){{
                put(CustomAdapter.DataAdapterValues.TEXT, "Obrir Llums");
                put(CustomAdapter.DataAdapterValues.IMAGE,R.mipmap.ic_launcher);
            }});
            add(new HashMap<CustomAdapter.DataAdapterValues, Object>(){{
                put(CustomAdapter.DataAdapterValues.TEXT, "Parar Llums");
                put(CustomAdapter.DataAdapterValues.IMAGE,R.mipmap.ic_launcher);
            }});
            add(new HashMap<CustomAdapter.DataAdapterValues, Object>(){{
                put(CustomAdapter.DataAdapterValues.TEXT, "Llum controlada per arduino");
                put(CustomAdapter.DataAdapterValues.IMAGE,R.mipmap.ic_launcher);
            }});
            add(new HashMap<CustomAdapter.DataAdapterValues, Object>(){{
                put(CustomAdapter.DataAdapterValues.TEXT, "Pujar persiana");
                put(CustomAdapter.DataAdapterValues.IMAGE,R.mipmap.ic_launcher);
            }});
            add(new HashMap<CustomAdapter.DataAdapterValues, Object>(){{
                put(CustomAdapter.DataAdapterValues.TEXT, "Baixar persiana");
                put(CustomAdapter.DataAdapterValues.IMAGE,R.mipmap.ic_launcher);
            }});
            add(new HashMap<CustomAdapter.DataAdapterValues, Object>(){{
                put(CustomAdapter.DataAdapterValues.TEXT, "Parar ventilador");
                put(CustomAdapter.DataAdapterValues.IMAGE,R.mipmap.ic_launcher);
            }});
            add(new HashMap<CustomAdapter.DataAdapterValues, Object>(){{
                put(CustomAdapter.DataAdapterValues.TEXT, "Obrir ventilador");
                put(CustomAdapter.DataAdapterValues.IMAGE,R.mipmap.ic_launcher);
            }});
            add(new HashMap<CustomAdapter.DataAdapterValues, Object>(){{
                put(CustomAdapter.DataAdapterValues.TEXT, "Ventilador controlat per arduino");
                put(CustomAdapter.DataAdapterValues.IMAGE,R.mipmap.ic_launcher);
            }});

        }};

        CustomAdapter customAdapter = new CustomAdapter(getActivity(), values);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 :
                       mPresenter.sendToBluethooth(5);
                       break;
                    default:
                }
                switch (position){
                    case 1 :
                        mPresenter.sendToBluethooth(6);
                        break;
                    default:
                }
                switch (position){
                    case 2 :
                        mPresenter.sendToBluethooth(7);
                        break;
                    default:
                }
                switch (position){
                    case 3 :
                        mPresenter.sendToBluethooth(9);
                        break;
                    default:
                }
                switch (position){
                    case 4 :
                        mPresenter.sendToBluethooth(8);
                        break;
                    default:
                }
                switch (position){
                    case 5 :
                        mPresenter.sendToBluethooth(2);
                        break;
                    default:
                }
                switch (position){
                    case 6 :
                        mPresenter.sendToBluethooth(3);
                        break;
                    default:
                }
                switch (position){
                    case 7 :
                        mPresenter.sendToBluethooth(4);
                        break;
                    default:
                }



            }
        });

        return root;
    }

    @Override
    public void setPresenter(MainBedRoomContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
