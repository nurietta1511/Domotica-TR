package com.nuriagalera.domoticatr.domticatr.util;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.UUID;

public class Bluethooth {
    private static final UUID mUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private BluetoothSocket mBluethoothSocket = null;
    BluetoothAdapter mBluetoothAdapter = null;
    private static Bluethooth mInstance = null;
    private ConnectBT mBluethoothConnection = null;

    private Bluethooth() {
        mBluethoothConnection = new ConnectBT();
        mBluethoothConnection.execute();
    }

    public static Bluethooth getInstance() {
        if(mInstance == null){
            mInstance = new Bluethooth();
        }
        return mInstance;
    }

    public void write(int value) {
        try
        {
            mBluethoothConnection.get();
            mBluethoothSocket.getOutputStream().write(Integer.toString(value).getBytes());
        }
        catch (Exception e) {}
    }

    private class ConnectBT extends AsyncTask<Void, Void, Void>  // UI thread
    {
        private boolean ConnectSuccess = true; //if it's here, it's almost connected

        @Override
        protected Void doInBackground(Void... devices) //while the progress dialog is shown, the connection is done in background
        {
            try {
                mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();//get the mobile bluetooth device
                BluetoothDevice dispositivo = mBluetoothAdapter.getRemoteDevice("98:D3:31:FD:6B:9B");//connects to the device's address and checks if it's available
                mBluethoothSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(mUUID);//create a RFCOMM (SPP) connection
                BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                mBluethoothSocket.connect();//start connection
            } catch (IOException e) {
                ConnectSuccess = false;//if the try failed, you can check the exception here
            }
            return null;
        }
    }
}
