package com.nuriagalera.domoticatr.domticatr.util;

/**
 * Created by Eric on 07/10/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nuriagalera.domoticatr.domticatr.R;
import com.nuriagalera.domoticatr.domticatr.main.MainFragment;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomAdapter extends BaseAdapter
{
    public enum DataAdapterValues {
        TEXT,
        IMAGE
    }

    ArrayList<HashMap<DataAdapterValues, Object>> m_values;
    FragmentActivity m_currentActivity = null;

    public CustomAdapter(FragmentActivity currentActivity, ArrayList<HashMap<DataAdapterValues, Object>> values)
    {
        m_values = values;
        m_currentActivity = currentActivity;
    }


    @Override
    public int getCount() {
        return m_values.size();
    }

    @Override
    public HashMap<DataAdapterValues, Object> getItem(int position) {
        return m_values.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = m_currentActivity.getLayoutInflater().inflate(R.layout.list_row, container, false);
        }

        ((TextView) convertView.findViewById(R.id.listRowText)).setText((String) getItem(position).get(DataAdapterValues.TEXT));
        ((ImageView) convertView.findViewById(R.id.listRowImage)).setImageResource((int) getItem(position).get(DataAdapterValues.IMAGE));//R.mipmap.ic_launcher);

        return convertView;
    }
}
