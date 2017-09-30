package com.nuriagalera.domoticatr.domticatr.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.nuriagalera.domoticatr.domticatr.R;

import java.util.HashMap;
import java.util.List;

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
        ListView list = (ListView) root.findViewById(R.id.list);

        // Defined Array values to show in ListView
        String[] values = new String[]{"Dormitori principal",
                "Dormitori secundari",
                "Despatx",
                "Lavabo planta principal",
                "Lavabo planta superior",
                "Menjador",
                "Rebost",
                "Cuina",
                "Escala",
                "Jardi"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),R.layout.list_row,R.id.listRowText,values);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = ((TextView) view.findViewById(R.id.listRowText)).getText().toString();
                Toast.makeText(getContext(),selected,Toast.LENGTH_LONG).show();
            }
        });

        /*Switch llumsWC1 = (Switch) root.findViewById(R.id.llumsWC1);
        llumsWC1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                llumnsWc1OnClick(isChecked);
            }
        });
        final Switch llummsWc2 = (Switch) root.findViewById(R.id.llumsWc2);
        llummsWc2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                llummsWc2onClick(isChecked);
            }
        });*/

        return root;
    }

    private void llummsWc2onClick(boolean isChecked) {
        if (isChecked == true) {
            //llum oberta
            Toast.makeText(getActivity(), "llum Wc 2 oberta!!!", Toast.LENGTH_SHORT).show();
        } else {
            //llum apagada
            Toast.makeText(getActivity(), "llum Wc 2 apagada!!!", Toast.LENGTH_SHORT).show();
        }
    }

    private void llumnsWc1OnClick(boolean isChecked) {

        if (isChecked == true) {
            //llum oberta
            Toast.makeText(getActivity(), "llum Wc 1 oberta!!!", Toast.LENGTH_SHORT).show();
        } else {
            //llum apagada
            Toast.makeText(getActivity(), "llum Wc 1 apagada!!!", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

/*
    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  String[] objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }*/
}


