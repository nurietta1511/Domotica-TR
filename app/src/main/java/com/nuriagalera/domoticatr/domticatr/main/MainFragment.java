package com.nuriagalera.domoticatr.domticatr.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.nuriagalera.domoticatr.domticatr.R;
import com.nuriagalera.domoticatr.domticatr.mainBedRoom.MainBedRoomActivity;
import com.nuriagalera.domoticatr.domticatr.mainGarden.MainGardenActivity;
import com.nuriagalera.domoticatr.domticatr.util.CustomAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainFragment extends Fragment implements MainContract.View {

    private MainContract.Presenter mPresenter;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
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
        View root = inflater.inflate(R.layout.main_frag, container, false);
        ListView listView = (ListView) root.findViewById(R.id.mainListView);

        ArrayList<HashMap<CustomAdapter.DataAdapterValues, Object>> values = new ArrayList<HashMap<CustomAdapter.DataAdapterValues, Object>>(){{
            add(new HashMap<CustomAdapter.DataAdapterValues, Object>(){{
                put(CustomAdapter.DataAdapterValues.TEXT, "Dormitori principal");
                put(CustomAdapter.DataAdapterValues.IMAGE,R.mipmap.ic_launcher);
            }});

            add(new HashMap<CustomAdapter.DataAdapterValues, Object>(){{
                put(CustomAdapter.DataAdapterValues.TEXT, "Despatx");
                put(CustomAdapter.DataAdapterValues.IMAGE,R.mipmap.ic_launcher);
            }});

            add(new HashMap<CustomAdapter.DataAdapterValues, Object>(){{
                put(CustomAdapter.DataAdapterValues.TEXT, "Lavabo planta principal");
                put(CustomAdapter.DataAdapterValues.IMAGE,R.mipmap.ic_launcher);
            }});

            add(new HashMap<CustomAdapter.DataAdapterValues, Object>(){{
                put(CustomAdapter.DataAdapterValues.TEXT, "Lavabo planta superior");
                put(CustomAdapter.DataAdapterValues.IMAGE,R.mipmap.ic_launcher);
            }});

            add(new HashMap<CustomAdapter.DataAdapterValues, Object>(){{
                put(CustomAdapter.DataAdapterValues.TEXT, "Dormitori secundari");
                put(CustomAdapter.DataAdapterValues.IMAGE,R.mipmap.ic_launcher);
            }});

            add(new HashMap<CustomAdapter.DataAdapterValues, Object>(){{
                put(CustomAdapter.DataAdapterValues.TEXT, "Menjador");
                put(CustomAdapter.DataAdapterValues.IMAGE,R.mipmap.ic_launcher);
            }});

            add(new HashMap<CustomAdapter.DataAdapterValues, Object>(){{
                put(CustomAdapter.DataAdapterValues.TEXT, "Cuina");
                put(CustomAdapter.DataAdapterValues.IMAGE,R.mipmap.ic_launcher);
            }});

            add(new HashMap<CustomAdapter.DataAdapterValues, Object>(){{
                put(CustomAdapter.DataAdapterValues.TEXT, "Rebost");
                put(CustomAdapter.DataAdapterValues.IMAGE,R.mipmap.ic_launcher);
            }});

            add(new HashMap<CustomAdapter.DataAdapterValues, Object>(){{
                put(CustomAdapter.DataAdapterValues.TEXT, "Jardi");
                put(CustomAdapter.DataAdapterValues.IMAGE,R.mipmap.ic_launcher);
            }});

            add(new HashMap<CustomAdapter.DataAdapterValues, Object>(){{
                put(CustomAdapter.DataAdapterValues.TEXT, "Escala");
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
                        Intent mainBedRoomIntent = new Intent(getContext(), MainBedRoomActivity.class);
                        startActivity(mainBedRoomIntent);
                        break;
                    case 8:
                        Intent mainGardenIntent = new Intent(getContext(), MainGardenActivity.class);
                        startActivity(mainGardenIntent);
                        break;

                    default:
                }

            }
        });

       return root;
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }
}


