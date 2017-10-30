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
import android.widget.AdapterView;
import android.widget.ListView;

import com.nuriagalera.domoticatr.domticatr.R;
import com.nuriagalera.domoticatr.domticatr.util.CustomAdapter;

import java.util.ArrayList;
import java.util.HashMap;

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
        ListView listView = (ListView) root.findViewById(R.id.mainBedRoomListView);

        ArrayList<HashMap<CustomAdapter.DataAdapterValues, Object>> values = new ArrayList<HashMap<CustomAdapter.DataAdapterValues, Object>>() {{

                add(new HashMap<CustomAdapter.DataAdapterValues, Object>() {{
                    put(CustomAdapter.DataAdapterValues.TEXT, "Obrir aspersor");
                    put(CustomAdapter.DataAdapterValues.IMAGE, R.mipmap.ic_launcher);
                }});
                add(new HashMap<CustomAdapter.DataAdapterValues, Object>() {{
                    put(CustomAdapter.DataAdapterValues.TEXT, "Parar aspersor");
                    put(CustomAdapter.DataAdapterValues.IMAGE, R.mipmap.ic_launcher);
                }});


        }};
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), values);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mPresenter.sendToBluethooth(1);
                        break;
                    default:
                }
                switch (position) {
                    case 1:
                        mPresenter.sendToBluethooth(0);
                        break;
                    default:
                }
            }
        });
        return root;
    }
    @Override
    public void setPresenter(MainGardenContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
